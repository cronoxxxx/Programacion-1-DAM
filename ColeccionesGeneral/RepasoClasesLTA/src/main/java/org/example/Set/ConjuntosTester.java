package org.example.Set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class ConjuntosTester {
    public static void main(String[] args) {
        Set<String> conjuntoString = new HashSet<>();
        conjuntoString.add("Peru");
        conjuntoString.add("Colombia");
        conjuntoString.add("Caracas");
        conjuntoString.add("Caracas");
        conjuntoString.add("Caracas");
        conjuntoString.forEach(System.out::println);
        System.out.println();

        Set<Integer> conjuntoEntero = new TreeSet<>();
        conjuntoEntero.add(1);
        conjuntoEntero.add(1);
        conjuntoEntero.add(3);
        conjuntoEntero.add(56);
        conjuntoEntero.add(2);
        conjuntoEntero.forEach(System.out::println);
        //Se agregan en el orden que se insertan, metodo FIFO, diferente a HashSet, que lo agrega en cualquier lugar
        Set<Character> conjuntoChar = new LinkedHashSet<>();
        conjuntoChar.add((char) 1);
        conjuntoChar.add((char) 1);
        conjuntoChar.add((char) 3);
        conjuntoChar.add((char) 56);
        conjuntoChar.add((char) 2);
    }
}
