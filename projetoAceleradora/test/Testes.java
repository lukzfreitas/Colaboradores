/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import aceleradora.*;
import excecoes.ValorInvalidoException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Lucas
 */
public class Testes {

    public Colaborador colaborador;
    public Colaborador colaboradorDesempenho;
    private static final double DELTA = 1e-15;
    private static final Date data = new Date();
    private static final double salario = 1500.0;
    private static final String nome = "Lucas Freitas";
    
    @Test
    public void testRelatorioDeCustos() throws ParseException {        
        ArrayList<Colaborador> listaDeColaboradores = new ArrayList<>();
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date data = (Date)formatter.parse("10/01/2017");                
        Colaborador colaborador1 = new Colaborador(
                "Julho Iglesias", 
                data,                 
                new Impostos(1500.0)
        );        
        listaDeColaboradores.add(colaborador1);
        data = (Date)formatter.parse("05/03/2017");
        Colaborador colaborador2 = new Colaborador(
                        "Álvaro Vasconcellos", 
                        data,                         
                        new Impostos(2000.0)
                );        
        listaDeColaboradores.add(colaborador2);
        RelatorioDeCustos.geraRelatorio(listaDeColaboradores);
        assertEquals(1435.0, RelatorioDeCustos.getTotalDeImpostos(), DELTA);
        assertEquals(3500.0, RelatorioDeCustos.getTotalDeSalarios(), DELTA);
        assertEquals(4935.0, RelatorioDeCustos.getTotalGeral(), DELTA);        
        listaDeColaboradores.clear();        
    }
    
    @Test
    public void testCalculoDoINSS() {
        ImpostoINSS impostoINSS = new ImpostoINSS(salario);
        double expected = 150.0;
        double actual = impostoINSS.getValor();
        assertEquals(expected, actual, DELTA);
    }
    
    @Test(expected = ValorInvalidoException.class)
    public void testExcecaoCalculoDoINSS() {
        ImpostoINSS impostoINSS = new ImpostoINSS(-1000.0);        
    }

    @Test
    public void testCalcularSegVida() {        
        ImpostoSegVida impostoSegVida = new ImpostoSegVida(salario);
        double expected = 225.0;
        double actual = impostoSegVida.getValor();
        assertEquals(expected, actual, DELTA);
    }
    
    @Test(expected = ValorInvalidoException.class)
    public void testExcecaoCalcularSegVida() {
        ImpostoSegVida impostoSegVida = new ImpostoSegVida(-1000.0);
    }

    @Test
    public void testCalcularVR() {        
        ImpostoVR impostoVR = new ImpostoVR(salario);
        double expected = 165.0;
        double actual = impostoVR.getValor();
        assertEquals(expected, actual, DELTA);
    }
    
    @Test(expected = ValorInvalidoException.class)
    public void testExcecaoCalcularVR() {
        ImpostoVR impostoVR = new ImpostoVR(-1000.0);
    }

    @Test
    public void testCalcularVT() {        
        ImpostoVT impostoVT = new ImpostoVT(salario);
        double expected = 75.0;
        double actual = impostoVT.getValor();
        assertEquals(expected, actual, DELTA);
    }
    
    @Test(expected = ValorInvalidoException.class)
    public void testExcecaoCalcularVT() {
        ImpostoVT impostoVT = new ImpostoVT(-1000.0);
    }
    
    @Before
    public void testColaboradorDesempenho() {
        Impostos impostos = new Impostos(salario);
        colaboradorDesempenho = new Colaborador(nome, data, impostos);
    }
    
    @Test
    public void testColaboradorDesempenhoOtimo() {        
        BonificacaoAnual bonificacaoAnual = new BonificacaoAnual(
                colaboradorDesempenho, 
                DesempenhoDeProducaoEnum.OTIMO
        );
        double expected = bonificacaoAnual.calculaBonificacao();
        double actual = 600.0; 
        assertEquals(expected, actual, DELTA);
    }
    
    @Test
    public void testColaboradorDesempenhoBom() {        
        BonificacaoAnual bonificacaoAnual = new BonificacaoAnual(
                colaboradorDesempenho, 
                DesempenhoDeProducaoEnum.BOM
        );
        double expected = bonificacaoAnual.calculaBonificacao();
        double actual = 270.0; 
        assertEquals(expected, actual, DELTA);
    }
    
    @Test
    public void testColaboradorDesempenhoRegular() {         
        BonificacaoAnual bonificacaoAnual = new BonificacaoAnual(
                colaboradorDesempenho, 
                DesempenhoDeProducaoEnum.REGULAR
        );
        double expected = bonificacaoAnual.calculaBonificacao();
        double actual = 90.0; 
        assertEquals(expected, actual, DELTA);
    }
}
