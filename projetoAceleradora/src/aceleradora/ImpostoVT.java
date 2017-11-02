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
public class ImpostoVT extends Salario implements ImpostoInterface{
    
    private static final double PERCENTUAL = 0.05;    
    private double valor;

    public ImpostoVT(double salario) {
        super(salario);
        valor = super.valor * PERCENTUAL;
    }    

    @Override
    public double getValor() {
        return valor;
    }
}
