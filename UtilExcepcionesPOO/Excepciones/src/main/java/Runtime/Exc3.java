package Runtime;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Exc3 {
    public static void main(String[] args) {
        try {
            leerArchivo();
        }catch (FileNotFoundException e){
            System.out.println("Archivo no encontrado");
        }

    }
//excepciones verificadas -- no dependen del programador, es mas de archivos y operaciones de entrada/salida
    public static void leerArchivo() throws FileNotFoundException {
        File archivo = new File("C:\\Users\\madrid\\Desktop\\prueba\\prueba.txt");
        FileReader fr = new FileReader(archivo);
        System.out.println("Archivo encontrado con exito");
    }
}
