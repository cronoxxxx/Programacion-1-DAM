package com.colecciones.listas;
import java.util.*;
public class TestListas {
    public static void main(String[] args) {
        List<Integer> listaNumeros = new ArrayList<>();
        System.out.println("Add:");
        for (int i = 10; i >=1; i--) {
            listaNumeros.add(i);
        }

        for(Integer numero : listaNumeros){
            System.out.println(numero);
        }
        System.out.println();
        for(Iterator<Integer> it = listaNumeros.iterator();it.hasNext();){
            Integer valor = it.next();
            System.out.println(valor);
        }
        System.out.println("\nRemove:");

        listaNumeros.remove(0); //borrar indice 0
        for(Integer numero : listaNumeros){
            System.out.println(numero);
        }
        System.out.println("\nSize:");
        System.out.println("tamaño cambiado : "+listaNumeros.size());

        System.out.println("\nGet:");
        System.out.println("Obtengo un elemento");
        System.out.println(listaNumeros.get(0));

        System.out.println("\nIndexof:");
        System.out.println(listaNumeros.indexOf(4)); //devuelve el numero que esta en x posicion, -1 si no existe

        System.out.println("\nSort:");
        Collections.sort(listaNumeros);
        for (Integer numeros : listaNumeros ) {
            System.out.println(numeros);
        }
        System.out.println("IsEmpty:");
        System.out.println("ESTA VACIO?:    "+listaNumeros.isEmpty());


        System.out.println("Mayor elemento: "+Collections.max(listaNumeros));
        System.out.println("Menor elemento: "+Collections.min(listaNumeros));

        System.out.println("En reversa, invertimos la lista: ");
        Collections.reverse(listaNumeros);
        for(Integer numeros: listaNumeros){
            System.out.println(numeros);
        }

        System.out.println("\nClear:");
        listaNumeros.clear(); //elimina todos lo valors
        for(Integer numero : listaNumeros){
            System.out.println(numero);
        }

    }



}
