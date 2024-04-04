package EJERCICIOS.CLASESYOBJETOS.Inicial.E17;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
* Queremos mantener una colección de los libros que hemos ido leyendo, poniéndoles una calificación
según nos lo que nos hayan gustado. Para ello, crear la clase Libro, cuyos atributos son el titulo, el
autor, el número de páginas y la calificación que le damos entre 0 y 10.
Crear los métodos típicos para poder modificar y obtener los atributos
Posteriormente, crear una clase ConjuntoLibros, que almacena un conjunto de libros (con un array de
un tamaño fijo).
Crear los métodos para hacer estas acciones:
• Añadir libros que no existan (siempre que haya espacio),
• Eliminar libros por título o autor,
• Mostrar por pantalla los libros con la mayor y menor calificación dada,
• Mostrar la información de un libro sabiendo su título
• Mostrar el contenido de todos los libros.
Crear una clase PruebaLibros, que realice varias pruebas con las clases creadas. Por ejemplo, probar a
crear dos libros, añadirlos al array, consultar uno de ellos por su titulo, eliminarlos por los dos criterios
hasta que el array esté vacío, volver a añadir un libro y mostrar el contenido final del array.
*
*
* */
public class ColeccionLibros {

    private Libros[] libros;

    public ColeccionLibros(Libros[] libros) {
        this.libros = libros;
    }

    public ColeccionLibros() {
        libros = new Libros[3];
    }

    public void mostrarLibros() {
        for (int i = 0; i < libros.length; i++) {
            if (libros[i] != null) {
                System.out.println(libros[i]);
            }
        }
    }

    public void mostrarLibroMayorMenorCalificacion() {
        Libros aux = null;
        boolean valido = false;
        for (int i = 0; i < libros.length && !valido; i++) {
            if (libros[i] != null) {
                aux = libros[i];
                valido=true;
            }
        }

        for (int i = 0; i < libros.length; i++) {
            if (libros[i] != null && aux!=null)
                if (aux.getCalificacion() > libros[i].getCalificacion()) {
                    aux = libros[i];
                }
        }
        System.out.println("Libro con menor calificacion");
        System.out.println(aux);
        Libros aux2 = null;
        valido = false;
        for (int i = 0; i < libros.length && !valido; i++) {
            if (libros[i] != null) {
                aux2 = libros[i];
                valido=true;
            }
        }
        for (int i = 0; i < libros.length; i++) {
            if (libros[i] != null && aux2!=null)
                if (aux2.getCalificacion() < libros[i].getCalificacion()) {
                    aux2 = libros[i];
                }
        }
        System.out.println("Libro con mayor calificacion");
        System.out.println(aux2);
    }

    public void eliminarLibrosTituloAutor() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingresa el titulo del libro");
        String titulo = entrada.nextLine();
        System.out.println("Ingrese el autor");
        String autor = entrada.nextLine();
        try {
            for (int i = 0; i < libros.length; i++) {
                if (libros[i] != null) {
                    if (libros[i].getTitulo().strip().equalsIgnoreCase(titulo) && libros[i].getAutor().strip().equalsIgnoreCase(autor)) {
                        libros[i] = null;
                    }
                }
            }
        }catch (ArrayIndexOutOfBoundsException array){
            System.out.println("Esta superando el espacio de libros a añadir, por favor, elimine alguno y haga un hueco");
        }
    }

    public void infoLibroTitulo() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingresa el titulo del libro");
        String titulo = entrada.nextLine();
        for (int i = 0; i < libros.length; i++) {
            if (libros[i] != null) {
                if (libros[i].getTitulo().strip().equalsIgnoreCase(titulo)) {
                    System.out.println(libros[i]);
                }
            }
        }
    }


    public boolean añadirLibro() {
        Scanner entrada = new Scanner(System.in);
        try {
            for (int i = 0; i < libros.length; i++) {
                if (libros[i] == null) {
                    boolean valido;
                    do {
                        System.out.println("Ingrese el titulo");
                        String titulo = entrada.nextLine();
                        System.out.println("Ingrese el autor");
                        String autor = entrada.nextLine();
                        System.out.println("Numero de páginas");
                        int nPaginas = entrada.nextInt();
                        System.out.println("Calificacion");
                        int cal = entrada.nextInt();
                        try {
                            libros[i] = new Libros(titulo, autor, nPaginas, cal);
                            return true;
                        } catch (CalificacionException e) {
                            entrada.nextLine();
                            System.out.println(e.getMessage());
                            valido = false;
                        }
                    } while (!valido);
                }
            }
        }catch (ArrayIndexOutOfBoundsException array){
            entrada.nextLine();
            System.out.println("Se esta procediendo a eliminar libros que no existen");
        }
        return false;

    }
}
