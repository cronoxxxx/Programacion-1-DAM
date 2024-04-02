package EJERCICIOS.CLASESYOBJETOS.Inicial.E15;

import java.util.Arrays;
import java.util.Scanner;

/*
* Crear una clase Libro que contenga los siguientes atributos:
– ISBN
– Titulo
– Autor
– Número de páginas
Crear sus respectivos métodos get y set correspondientes para cada atributo. Elegir el tipo de dato mas
correcto para cada atributo. Crear el método toString() para mostrar la información relativa al libro
con el siguiente formato:
“El libro con ISBN XXX creado por el autor AAA tiene NNN páginas”
En el fichero main, crear 3 objetos Libro (los valores que se quieran) y mostrarlos por pantalla.
Por último, indicar cuál de los 3 tiene más páginas.
* */
public class Tester {
    public static void main(String[] args) {
        Scanner entrada= new Scanner(System.in);
        Libro [] libros = new Libro[3];
        Libro [] libroscopia = new Libro[libros.length];
        for (int i = 0, x=0; i < libros.length; i++) {
            System.out.println("Ingrese el titulo");
            String titulo = entrada.nextLine();
            System.out.println("Ingrese el autor");
            String autor = entrada.nextLine();
            System.out.println("Ingrese el ISBN");
            String ISBN = entrada.nextLine();
            System.out.println("Ingrese el numero de pagians");
            int pags = entrada.nextInt();
            libros[i]= new Libro(ISBN,titulo,autor,pags);
            if (libros[i]!=null){
                libroscopia[x]=libros[i];
                x++;
            }
        }
        Arrays.sort(libroscopia);

        System.out.println(Arrays.toString(libroscopia));

    }
}
