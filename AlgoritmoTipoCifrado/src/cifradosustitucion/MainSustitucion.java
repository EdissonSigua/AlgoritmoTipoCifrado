/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifradosustitucion;

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
public class MainSustitucion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String cadena = "";
        String txtPlano = "";
        File archivo = new File("CSustitucion/TextoPlano.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(archivo));
            while ((cadena = reader.readLine()) != null) {
                txtPlano += cadena;
            }
            reader.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainSustitucion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainSustitucion.class.getName()).log(Level.SEVERE, null, ex);
        }

        int clave = 1;
        if (clave > 26) {
            clave = (clave % 26);
        }
        CifradoSustitucion cifrar = new CifradoSustitucion();
        String textoCifrado = cifrar.encriptar(clave, txtPlano);
        System.out.println("ENCRIPTADO POR SUSTITUCION CORRECTO!!");
        
        
        File archivoCifrado = new File("CSustitucion/TextoPlanoCifrado.txt");
        try {
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(archivoCifrado)));
            writer.print(textoCifrado);
            writer.flush();
            writer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainSustitucion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainSustitucion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
