package IOFilles.Files2;

import java.io.*;

public class Files2 {


    private static void crearArchivoDeTexto() {
        File archivo = new File("archivo.txt");
        try {
            if (archivo.createNewFile()){ //crear archivo nuevo
                System.out.println("El archivo ha sido creado con exito: "+archivo.getName());
            } else {
                System.out.println("El archivo ya existe: "+archivo.getName());
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

    private static void eliminarArchivoDeTexto() {
        File archivo= new File("archivos.txt");

            if (archivo.delete()) {
                System.out.println("Archivo eliminado con exito");
            } else {
                System.out.println("Error al eliminar archivo");
            }
    }


    private static void escribirArchivoDeTexto(String archivos) {
        try {
            FileWriter archivo = new FileWriter(archivos,true); //true para seguir añadiendo contenido
           archivo.write("\nShe is my crush");
           archivo.close();
            System.out.println("Texto añadido con exito");
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

    private static void leerArchivoDeTexto(String archivoo){

        try {
            FileReader archivo = new FileReader(archivoo);
            BufferedReader bf = new BufferedReader(archivo);
            String linea;
            while ((linea = bf.readLine()) != null) {
                System.out.println(linea);

            }
        }catch (IOException i){
            i.printStackTrace(System.out);
        }
    }

    public static void main(String[] args) throws IOException {
        escribirArchivoDeTexto("prueba.txt");
        leerArchivoDeTexto("prueba.txt");
    }


}
