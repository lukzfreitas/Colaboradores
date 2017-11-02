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
public class ImpostoVR extends Salario implements ImpostoInterface{

    private static final double PERCENTUAL = 0.11;
    private double valor;
        
    public ImpostoVR(double salario) {
        super(salario);
        valor = super.valor * PERCENTUAL;
    }    

    @Override
    public double getValor() {
        return valor;
    }   
    
}
