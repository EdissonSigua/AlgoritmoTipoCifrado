/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CifradoTransposicion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ediss
 */
public class MainTransposicion {
    public static void main(String[] args) {
        int clave = 10;
        
        String cadena;
        String txtPlano = "";
        File archivo = new File("CTransposicion/TextoPlano.txt");
        
            
        try {
            BufferedReader reader = new BufferedReader(new FileReader(archivo));
            while ((cadena = reader.readLine()) != null) {
                txtPlano += cadena;
            }
            reader.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainTransposicion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainTransposicion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        CifradoTransposicion encriptacion = new CifradoTransposicion("MEGABUCK", txtPlano);
        String textoCifrado = encriptacion.cifrar();
        System.out.println("ENCRIPTADO POR TRANSPOSICION CORRECTO!!");
        
        File archivoCifrado = new File("CTransposicion/TextoPlanoCifrado.txt");
        
            
        try {
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(archivoCifrado)));
            writer.print(textoCifrado);
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(MainTransposicion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
