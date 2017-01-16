/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmotipocifrado;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author ediss
 */
public class AlgoritmoTipoCifrado {

    private String criptograma;
    public static boolean ASC = true;
    public static boolean DESC = false;

    public AlgoritmoTipoCifrado(String criptograma) {
        this.criptograma = criptograma;
    }

    public Map saveFrecuencias() {
        Map<String, Integer> frecuencia = new HashMap<>();

        for (int i = 0; i < criptograma.length(); i++) {
            Character letra = criptograma.charAt(i);
            if (frecuencia.containsKey(Character.toString(letra))) {
                frecuencia.put(Character.toString(letra), frecuencia.get(Character.toString(letra)) + 1);
            } else {
                frecuencia.put(Character.toString(letra), 1);
            }
        }
        return frecuencia;

    }

    public Map<String, Integer> sortByComparator(Map<String, Integer> unsortMap, final boolean order) {

        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());

        // Sorting the list based on values
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                    Map.Entry<String, Integer> o2) {
                if (order) {
                    return o1.getValue().compareTo(o2.getValue());
                } else {
                    return o2.getValue().compareTo(o1.getValue());

                }
            }
        });

        // Maintaining insertion order with the help of LinkedList
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

    public void printMap(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key : '" + entry.getKey() + "'   ->   Value : " + entry.getValue());
        }
    }

    public boolean getTipoCifrado(Map unsortMap) {
        Map<String, Integer> sortedMapDesc = (Map<String, Integer>) sortByComparator(unsortMap, DESC);
        System.out.println("\nMAPA LUEGO DE ORDENAR POR LA FRECUENCIA");
        printMap(sortedMapDesc);

        //OBTENEMOS UN SET CON LOS CARACTERES ORDENADOS DE MAYOR A MENOR
        Set conjunto = sortedMapDesc.keySet();
        System.out.println("\nArreglo con las claves ordenadas por su frecuencia: " + conjunto.toString());
        Object arreglo[] = conjunto.toArray();

        String Key1 = (String) arreglo[0];
        String Key2 = (String) arreglo[1];
        String Key3 = (String) arreglo[2];
        String Key4 = (String) arreglo[3];
        String Key5 = (String) arreglo[4];
        String Key6 = (String) arreglo[5];
        String Key7 = (String) arreglo[6];
        
        //COMPARACION PARA SABER SI EL TEXTO FUE CIFRADO POR TRANSPOSICION O POR SUSTITUCION
        //if (((firstKey.equals("a") || firstKey.equals("e") || firstKey.equals("s") || firstKey.equals("o")) && (secondKey.equals("a") || secondKey.equals("e") || secondKey.equals("s") || secondKey.equals("o"))) && ((thirdKey.equals("a") || thirdKey.equals("e") || thirdKey.equals("s") || thirdKey.equals("o")) && (fourthKey.equals("a") || fourthKey.equals("e") || fourthKey.equals("s") || fourthKey.equals("o"))))
        if (Key1.equals("e") || Key1.equals("a") || Key1.equals("o") || Key1.equals("s") || Key1.equals("r") || Key1.equals(" "))
            if (Key2.equals("e") || Key2.equals("a") || Key2.equals("o") || Key2.equals("s") || Key2.equals("r") || Key2.equals(" ")) 
                if (Key3.equals("e") || Key3.equals("a") || Key3.equals("o") || Key3.equals("s") || Key3.equals("r") || Key3.equals(" ")) 
                    if (Key4.equals("e") || Key4.equals("a") || Key4.equals("o") || Key4.equals("s") || Key4.equals("r") || Key4.equals(" ")) 
                        return true;
        return false;
    }    

}
