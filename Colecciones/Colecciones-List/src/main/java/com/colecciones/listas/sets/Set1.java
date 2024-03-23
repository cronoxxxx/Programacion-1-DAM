package com.colecciones.listas.sets;

import net.datafaker.Faker;

import java.util.*;

public class Set1 {
    public static void main(String[] args) {
        Set<String> conjuntoHash = new HashSet<>();
        Faker faker = new Faker();
        conjuntoHash.add(faker.address().country());
        conjuntoHash.add(faker.address().country());
        conjuntoHash.add("bash");
        conjuntoHash.add("bash");
        System.out.println("HASHSET: coleccion sin valor repetido");
        conjuntoHash.forEach(var -> System.out.println(var));

        System.out.println("\nTREESET : Ordena en order de menor a mayor sin valores repetidos");
        Set<String> conjuntoArbol = new TreeSet<>();
        conjuntoArbol.add(faker.address().country());
        conjuntoArbol.add(faker.address().country());
        conjuntoArbol.forEach(adder -> System.out.println(adder));

        System.out.println("\nTREESET REVERSO DE MAYOR A MENOR");
        Set<String> conjuntoArbolReverse = new TreeSet<>(Comparator.reverseOrder());
        conjuntoArbolReverse.add(faker.address().country());
        conjuntoArbolReverse.add(faker.address().country());
        conjuntoArbolReverse.forEach(adder -> System.out.println(adder));
        System.out.println("\nColeccion sin valor repetido, que se itera solo desde lo primero añadido (FIFO)");
        Set <Character> conjuntoLinkedHash = new LinkedHashSet<>();
        for (int i = 65; i < 91 ; i++) {
            conjuntoLinkedHash.add((char) i);
        }
        conjuntoLinkedHash.add((char) 66); //no se mostraran duplicados
        conjuntoLinkedHash.forEach(adderChar -> System.out.print(adderChar+ " "));






    }
}
