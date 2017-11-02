/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aceleradora;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Lucas
 */
public class Leitura {

    private static final ArrayList<Colaborador> lista = new ArrayList<>();
    
    
    public static void carregaColaboradores(String nomeDoArquivo) throws ParseException {    
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader(nomeDoArquivo)
            );
            String linha = null;
            String nome = null;
            Date data = null;
            double valor = 0.0;            
            Colaborador colaborador = null;
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            while (br.ready()) {
                linha = br.readLine();
                Scanner sc = new Scanner(linha).useDelimiter(";");                
                nome = sc.next();                                
                valor = Double.parseDouble(
                        sc.next().replace('"', ' ').replace(" ", "")
                );                
                data = (Date)formatter.parse(
                        sc.next().replace('"', ' ').replace(" ", "")
                );                     
                Impostos impostos = new Impostos(valor);                
                colaborador = new Colaborador(
                        nome, 
                        data,                         
                        impostos
                );
                lista.add(colaborador);
            }
            RelatorioDeCustos.geraRelatorio(lista);            
        } catch (IOException exception) {
            System.err.format("Erro de E/S: %s%n", exception);
        }        
    }

    public static ArrayList<Colaborador> getLista() {
        return lista;
    }
}
