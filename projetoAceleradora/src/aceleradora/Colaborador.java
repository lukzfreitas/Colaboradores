package aceleradora;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lucas
 */
public class Colaborador {
       
    private String nome;    
    private Date data;     
    private Impostos impostos;

    public Colaborador(String nome, Date data, Impostos impostos) {
        this.nome = nome;              
        this.data = data;                                          
        this.impostos = impostos;
    }        

    public String getNome() {
        return nome;
    }

    public Date getData() {
        return data;
    }    
    
    public Impostos getImpostos() {
        return impostos;
    }
    
    public double getSalarioComImpostos() {
        return impostos.custoTotal() + impostos.getSalario();
    }

    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        return "Nome: " + nome + "; " + impostos.toString() + "; CustTotal: " 
                + nf.format(getSalarioComImpostos());
    }
}
