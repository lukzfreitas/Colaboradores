/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aceleradora;

import excecoes.ValorInvalidoException;

/**
 *
 * @author Lucas
 */
public class Salario {
    
    protected double valor;

    public Salario(double valor) {
        if (valor < 0.0) {
           throw new ValorInvalidoException("Salário Informado negativo");
        }
        this.valor = valor;
    }

    public double getSalario() {
        return valor;
    }
}
