/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cifradocesar;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 Algoritmo de cesar creado por Emmanuel & Nicolas. Matematicas discretas 2
 */
public class CifradoCesar {

    static final String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ";

    
    static final String letrasD = " ZYXWVUTSRQPONMLKJIHGFEDCBA";

    static final int CODIFICAR = 0;
    static final int DESCODIFICAR = 1;

    static Integer clave;
    static String textoEncriptado;

    public static void main(String[] args) {

        String opcion = "";
        do {
            //Variables para guardar datos introducidos por teclado
            Scanner teclado = new Scanner(System.in);
            Scanner sOpcion = new Scanner(System.in);
            String texto = null;

            //PEDIMOS LA PALABRA A CODIFICAR O DESCODIFICAR
            System.out.println("Introduce la frase que desea codificar: ");
            texto = teclado.nextLine();
            texto = texto.toUpperCase();

            //PEDIMOS EL VALOR DE DESPLAZAMIENTO
            clave();
           
            System.out.println("""
                               Ingrese C para codificar. 
                                Ingrese D para decodificar. 
                                 Pulse cualquier tecla si quiere salir del programa""");
            opcion = sOpcion.nextLine();

            if (opcion.equalsIgnoreCase("C")) {
                System.out.println(procesar(texto, CODIFICAR));
            } else if (opcion.equalsIgnoreCase("D")) {
                System.out.println(procesar(texto, DESCODIFICAR));
            } else {
                System.exit(0);
            }
        } while (!opcion.equals("S"));

    }

   
    static private String procesar(String texto, int accion) {
        //codificar
        String abecedario = "";
        if (accion == CODIFICAR) {        
            abecedario = letras;
            //si hay que descodificar se utiliza el alfabeto al revés
        } else if (accion == DESCODIFICAR) {     
            abecedario = letrasD;
        }
        textoEncriptado = "";
        for (int i = 0; i < texto.length(); i++) {
            for (int j = 0; j < abecedario.length(); j++) {
                if (texto.charAt(i) == abecedario.charAt(j)) {
                    if (j + clave >= abecedario.length()) {
                        textoEncriptado += abecedario.charAt((j + clave) % abecedario.length());
                    } else {
                        textoEncriptado += abecedario.charAt(j + clave);

                    }
                    
                } 

            }

        }

        return textoEncriptado;
    }
   

    /**
     * Método que comprueba si el valor introducido por teclado es un número
     */
    static private void clave() {
        Scanner teclado = new Scanner(System.in);
        boolean continua;
        do {

            try {
                System.out.println("Introduce valor de desplazamiento: ");
                continua = false;
                clave = teclado.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Debe introducir un valor numérico!!");
                teclado.next();
                continua = true;
            }
        } while (continua);

    }

}