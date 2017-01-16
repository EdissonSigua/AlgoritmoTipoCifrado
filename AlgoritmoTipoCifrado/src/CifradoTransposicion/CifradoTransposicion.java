/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CifradoTransposicion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author ediss
 */
public class CifradoTransposicion {

    private final String clave;
    private final String criptograma;

    public CifradoTransposicion(String clave, String criptograma) {
        this.clave = clave;
        this.criptograma = criptograma;
    }

    public String cifrar() {

        int columnas = this.clave.length();
        int filas = (int) Math.ceil(((float) (this.criptograma.length()) / (float) (this.clave.length())));
        filas += 2;
        Object[][] matriz = new Object[filas][columnas];

        //LLENAR LOS CARACTERES DE LA CLAVE EN LA PRIMERA FILA DE LA MATRIZ
        List listaClaves = new ArrayList();
        for (int i = 0; i < columnas; i++) {
            matriz[0][i] = clave.charAt(i);
            listaClaves.add(matriz[0][i]);
        }

        //ORDENAMOS LA LISTA DE CLAVES
        Collections.sort(listaClaves);
        
        //LLENAR LA CLAVE NUMERICA EN LA SEGUNDA FILA DE LA MATRIZ
        boolean bandera = false;
        int comparado = -1;
        for (int i = 0; i < listaClaves.size(); i++) {
            for (int j = 0; j < listaClaves.size(); j++) {
                if ((char) listaClaves.get(i) == (char) matriz[0][j] && bandera == false && comparado != j) {
                    matriz[1][j] = i + 1;
                    bandera = true;
                    comparado = j;
                }
            }
            bandera = false;
        }

        //LLENAR EL RESTO DE LA MATRIZ
        int cont = 2;
        String filaCaracteres = "";
        for (int i = 0; i < this.criptograma.length(); i++) {

            filaCaracteres += this.criptograma.charAt(i);
            if (filaCaracteres.length() == columnas) {
                for (int j = 0; j < columnas; j++) {
                    matriz[cont][j] = filaCaracteres.charAt(j);

                }
                cont = cont + 1;
                filaCaracteres = "";
            }

        }
        //COMPLETAMOS LA MATRIZ SI FUESE NECESARIO
        if (filaCaracteres.length() >= 1) {
            String abecedario = "abcdefghijklmnopqrstuvwxyz";
            int cont2 = 0;
            for (int j = 0; j < columnas; j++) {
                if (j < filaCaracteres.length()) {
                    matriz[cont][j] = filaCaracteres.charAt(j);
                } else {
                    matriz[cont][j] = abecedario.charAt(cont2);
                    cont2++;
                }
            }
        }

        //PROCESO DE CIFRADO
        String textoCifrado = "";
        for (int i = 0; i < listaClaves.size(); i++) {
            for (int j = 0; j < listaClaves.size(); j++) {
                if ((char) listaClaves.get(i) == (char) matriz[0][j]) {
                    for (int k = 2; k < filas; k++) {
                        textoCifrado += matriz[k][j];
                    }
                }
            }
        }
        /*
        //IMPRIMIR LA MATRIZ
        System.out.println("\tMATRIZ");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("TextoCifrado: " + textoCifrado.toUpperCase());
        */
        return textoCifrado;
    }
}
