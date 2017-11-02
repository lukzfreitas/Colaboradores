/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aceleradora;

import java.text.NumberFormat;

/**
 *
 * @author Lucas
 */
public class Impostos {
    
    private ImpostoINSS INSS;
    private ImpostoSegVida segVida;
    private ImpostoVT vt;
    private ImpostoVR vr;    
    private double salario;

    public Impostos(double salario) {
        this.INSS = new ImpostoINSS(salario);
        this.segVida = new ImpostoSegVida(salario);
        this.vt = new ImpostoVT(salario);
        this.vr = new ImpostoVR(salario);
        this.salario = salario;
    }

    public ImpostoINSS getINSS() {
        return INSS;
    }

    public ImpostoSegVida getSegVida() {
        return segVida;
    }

    public ImpostoVT getVt() {
        return vt;
    }

    public ImpostoVR getVr() {
        return vr;
    }   
    
    public double custoTotal() {
        return INSS.getValor() + segVida.getValor() + vt.getValor() + vr.getValor();
    }
    
    public double getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        return "INSS: " + nf.format(INSS.getValor()) + ";"
                + " SegVida: " + nf.format(segVida.getValor()) + ";"
                + " VR: " + nf.format(vr.getValor()) + ";"
                + " VT: " + nf.format(vt.getValor());
    }
    
    
    
}
