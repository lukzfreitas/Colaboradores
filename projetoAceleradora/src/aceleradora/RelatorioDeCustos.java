/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aceleradora;

import java.text.NumberFormat;
import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public class RelatorioDeCustos {

    private static double totalDeImpostos = 0.0;
    private static double totalDeSalarios = 0.0;
    private static double totalGeral = 0.0;    

    public static void geraRelatorio(ArrayList<Colaborador> lista) {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        for (Colaborador colab : lista) {
            System.out.println(colab.toString());            
            totalDeSalarios += colab.getImpostos().getSalario();
            totalDeImpostos += colab.getImpostos().custoTotal();
        }
        totalGeral = totalDeImpostos + totalDeSalarios;                
        System.out.println("Total Impostos: " + nf.format(totalDeImpostos));
        System.out.println("Total Salários: " + nf.format(totalDeSalarios));
        System.out.println("Total Geral: " + nf.format(totalGeral));
    }

    public static double getTotalDeImpostos() {
        return totalDeImpostos;
    }

    public static double getTotalDeSalarios() {
        return totalDeSalarios;
    }

    public static double getTotalGeral() {
        return totalGeral;
    }
}
