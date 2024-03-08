package IOFilles.Files1;

import java.io.File;
import java.io.IOException;

public class Files1 {
    public static void main(String[] args){
        //Clase File
        File archivo = new File("pennis.txt");
        try {
            if (archivo.createNewFile()){ //crear archivo nuevo
                System.out.println("El archivo ha sido creado con exito: "+archivo.getName());
            } else {
                System.out.println("El archivo ya existe: "+archivo.getName());
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        if(archivo.exists()){
            System.out.println("Nombre del archivo "+archivo.getName());
            System.out.println("Camino             "+archivo.getPath());
            System.out.println("Camino absoluto    "+archivo.getAbsolutePath());
            System.out.println("Se puede escribir  "+archivo.canRead());
            System.out.println("Se puede leer      "+archivo.canWrite());
            System.out.println("Tamaño             "+archivo.length());
            System.out.println("Es archivo?   "+archivo.isFile());
            System.out.println("Es directorio?   "+archivo.isDirectory());
            System.out.println("Longitud: "+archivo.length()+"\n");
        }

        //Documentar los archivos que hay
        File archivo0 = new File(".");
        String[] listaArchivos=archivo0.list();
        for(int i=0; i<listaArchivos.length; i++){
            System.out.println(listaArchivos[i]);
        }
        System.out.println();


        //Crear mkdir directorio
        File archivo2 = new File("direct");
        if (archivo2.mkdir()){ //crear archivo nuevo
            System.out.println("El archivo ha sido creado con exito: "+archivo2.getName());
        } else {
            System.out.println("El archivo ya existe: "+archivo2.getName());
        }
        if(archivo2.exists()){
            System.out.println("Nombre del archivo "+archivo2.getName());
            System.out.println("Camino             "+archivo2.getPath());
            System.out.println("Camino absoluto    "+archivo2.getAbsolutePath());
            System.out.println("Se puede escribir  "+archivo2.canRead());
            System.out.println("Se puede leer      "+archivo2.canWrite());
            System.out.println("Tamaño             "+archivo2.length());
            System.out.println("Es archivo?   "+archivo2.isFile());
            System.out.println("Es directorio?   "+archivo2.isDirectory());
            System.out.println("Longitud: "+archivo2.length());
        }


        //Eliminado con exito
        File archivo3 = new File("pennis.txt");
            if (archivo3.delete()){ //crear archivo nuevo
                System.out.println("\nEl archivo ha sido eliminado con exito: "+archivo3.getName());
            } else {
                System.out.println("\nEl archivo no existe: "+archivo3.getName());
            }

        File archivo4 = new File("C:\\Users\\madrid\\Desktop\\utilidades1DAM\\Proyectos Java\\Ajedrez\\fx\\fx\\src\\main\\java\\Modelo");
        listaArchivos=archivo4.list(new Filtro(".java"));
        System.out.println("\nLos archivos con extension java de mi ajedrez son: ");
        for(int i=0; i<listaArchivos.length; i++){
            System.out.println(listaArchivos[i]);
        }

    }
}
