/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aceleradora;

/**
 *
 * @author Lucas
 */
public class BonificacaoAnual {    
    
    private Colaborador colaborador;
    private DesempenhoDeProducaoEnum desempenhoDeProducao;    
    private static final double PERCENTOTIMO = 0.40;
    private static final double PERCENTBOM = 0.18;
    private static final double PERCENTREGULAR = 0.06;

    public BonificacaoAnual(
            Colaborador colaborador,
            DesempenhoDeProducaoEnum desempenhoProducao            
    ) { 
        this.colaborador = colaborador;
        this.desempenhoDeProducao = desempenhoProducao;        
    }

    public double calculaBonificacao() {
        double bonificacao = 0.0;
        switch (desempenhoDeProducao) {
            case OTIMO :
                bonificacao = colaborador.getImpostos().getSalario() * PERCENTOTIMO;            
                break;
            case BOM :
                bonificacao = colaborador.getImpostos().getSalario() * PERCENTBOM;
                break;
            case REGULAR:
                bonificacao = colaborador.getImpostos().getSalario() * PERCENTREGULAR;
                break;
            default :
                throw new IllegalArgumentException("Desempenho inválido");
        }
        return bonificacao;
    }
}
