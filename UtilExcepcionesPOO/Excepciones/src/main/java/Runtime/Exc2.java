package Runtime;

import java.io.*;

public class Exc2 { //Excepcion verificada
    public static void main(String[] args) throws FileNotFoundException,IOException{
    leerArchivo2();
    }

    public static void leerArchivo() throws IOException, FileNotFoundException {
        File archivo = new File("C:\\Users\\madrid\\Desktop\\prueba\\prueba.txt");
        FileReader fr = new FileReader(archivo);
        BufferedReader bf = new BufferedReader(fr);
        String linea;
        while ((linea = bf.readLine()) != null) {
            System.out.println(linea);
        }
    }

    //try-catch

    public static void leerArchivo2(){
        try { //intenta hacer lo que hay dentro
            leerArchivo();
        } catch (FileNotFoundException f){ //y en caso de suceder una excepcion, la captura
            System.out.println("No se ha encontrado el archivo deseado, por favor, verifique la ruta");
        } catch (IOException e){
            System.out.println("Hay un error de entrada y salida en el archivo");
        }

        System.out.println("Programa finalizado");
    }

    //obtener archivos de solo extension .java


}
