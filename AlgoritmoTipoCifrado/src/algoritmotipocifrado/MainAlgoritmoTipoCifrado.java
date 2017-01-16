/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmotipocifrado;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ediss
 */
public class MainAlgoritmoTipoCifrado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String cadena;
        String criptograma = "";
        //File archivoCifrado = new File("CSustitucion/TextoPlanoCifrado.txt");
        File archivoCifrado = new File("CTransposicion/TextoPlanoCifrado.txt");
        
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(archivoCifrado));
            while ((cadena = reader.readLine()) != null) {
                criptograma += cadena;
            }
            reader.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainAlgoritmoTipoCifrado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainAlgoritmoTipoCifrado.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        AlgoritmoTipoCifrado tipo = new AlgoritmoTipoCifrado(criptograma.toLowerCase());
        
        //OBTENEMOS UN MAPA DONDE LAS CLAVES SON LOS CARACTERES QUE APARECEN EN EL TEXTO CIFRADO
        //Y LOS VALORES SON LA FRECUENCIA DE CADA UNO
        Map unsortMap = tipo.saveFrecuencias();
        System.out.println("MAPA INICIAL SIN ORDENAR");
        tipo.printMap(unsortMap);
        
        if (tipo.getTipoCifrado(unsortMap))
            System.out.println("\nEl texto fue cifrado por Transposicion");
        else 
            System.out.println("\nEl texto fue cifrado por Sustitucion");
    }
}
