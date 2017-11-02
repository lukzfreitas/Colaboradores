/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aceleradora;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Lucas
 */
public class Main {
    public static void main(String[] args) throws ParseException {
        Leitura.carregaColaboradores("colaboradores.txt");
    }
}
