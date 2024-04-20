package org.example.Map;

import java.util.*;

public class MapasTester {
    public static void main(String[] args) {
        Map<Integer,String> diccionarioHashMap = new HashMap<>(); //No ordena pero evita duplicados
        diccionarioHashMap.put(4, "Paco");
        diccionarioHashMap.put(2, "Negro");
        diccionarioHashMap.put(1, "Paco");
        diccionarioHashMap.put(1, "Paco");
        diccionarioHashMap.put(1, "Sebas"); // La clave 1 se actualiza con el valor "Sebas"
        diccionarioHashMap.put(3, "Paco");
        diccionarioHashMap.put(5, "Juan");
        diccionarioHashMap.put(65, "Juan");
        diccionarioHashMap.put(6, "María");
        diccionarioHashMap.put(7, "Luisa");
        diccionarioHashMap.put(8, "Pedro");
        diccionarioHashMap.forEach((i, j) -> {System.out.println("Clave: " + i + ", Valor: " + j);});

        System.out.println("\nTREE"); //Ordena por clave menor a mayor y evita duplicados
        Map<Integer,String> diccionarioTreeMap = new TreeMap<>();
        diccionarioTreeMap.put(4, "Paco");
        diccionarioTreeMap.put(2, "Negro");
        diccionarioTreeMap.put(1, "Paco");
        diccionarioTreeMap.put(1, "Paco");
        diccionarioTreeMap.put(1, "Sebas"); // La clave 1 se actualiza con el valor "Sebas"
        diccionarioTreeMap.put(3, "Paco");
        diccionarioTreeMap.put(5, "Juan");
        diccionarioTreeMap.put(65, "Juan");
        diccionarioTreeMap.put(6, "María");
        diccionarioTreeMap.put(7, "Luisa");
        diccionarioTreeMap.put(8, "Pedro");
        diccionarioTreeMap.forEach((i, j) -> {System.out.println("Clave: " + i + ", Valor: " + j);});

        System.out.println("\nLINKEDHASH"); //Ordena por el orden que mete el usuario (FIFO)
        Map<Integer,String> diccionarioLinkedHashMap = new LinkedHashMap<>();
        diccionarioLinkedHashMap.put(4, "Paco");
        diccionarioLinkedHashMap.put(2, "Negro");
        diccionarioLinkedHashMap.put(1, "Paco");
        diccionarioLinkedHashMap.put(1, "Paco");
        diccionarioLinkedHashMap.put(1, "Sebas"); // La clave 1 se actualiza con el valor "Sebas"
        diccionarioLinkedHashMap.put(3, "Paco");
        diccionarioLinkedHashMap.put(5, "Juan");
        diccionarioLinkedHashMap.put(65, "Juan");
        diccionarioLinkedHashMap.put(6, "María");
        diccionarioLinkedHashMap.put(7, "Luisa");
        diccionarioLinkedHashMap.put(8, "Pedro");
        diccionarioLinkedHashMap.forEach((i, j) -> {System.out.println("Clave: " + i + ", Valor: " + j);});
    }
}
