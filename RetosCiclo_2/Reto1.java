/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package retos1;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class Reto1 {
        /**
    *  Este debe ser el único objeto de tipo Scanner en el código
    */
    private static final Scanner scanner = new Scanner(System.in);

    /**
    * Este método es usado para solicitar datos al usuario
    * @return  Lectura de la siguiente linea del teclado
    */
    public static String read(){
        return scanner.nextLine();
    }
        /**
    * método principal
    */
   // public void run(){
        /*
        solución propuesta
        */
    public static void main(String[] args) {
        String datos = read();
        String[] arregloDatos = datos.split(" ");
        
        double masa = Double.parseDouble(arregloDatos[0]);
        double estatura = Double.parseDouble(arregloDatos[1]);
        int edad = Integer.parseInt(arregloDatos[2]);
        
        double imc = masa/(estatura*estatura);
        
          if(masa < 0 || masa > 150){
            System.out.println("ERROR");
        }
        else if(estatura < 0.1 || estatura > 2.5){
            System.out.println("ERROR");
        }
        else if( edad < 0 || edad > 110){
            System.out.println("ERROR");
        }
        
        else if(imc < 22 && edad < 45 ){
            System.out.println(String.format("%.1f", imc) + " " + "Bajo");
        }
     
        else if(imc < 22 && edad >= 45){
            System.out.println(String.format("%.1f", imc) + " " + "Medio");
        }
        
        else if(imc >= 22 && edad < 45){
            System.out.println(String.format("%.1f", imc) + " " + "Medio");
        }
        
        else if(imc >= 22 && edad >= 45){
            System.out.println(String.format("%.1f", imc) + " " + "Alto");
        }
    }
}
