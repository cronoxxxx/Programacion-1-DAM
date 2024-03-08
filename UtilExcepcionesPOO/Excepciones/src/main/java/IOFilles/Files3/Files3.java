package IOFilles.Files3;

import java.io.*;

public class Files3 { //Binarios

    public static void crearArchivo (){
        File archivo = new File("personas.bin");
        try {
            if (archivo.createNewFile()){
                System.out.println("Archivo creado con exito");
            } else {
                System.out.println("Archivo ya existente");
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

    /*public static void insertarTexto(String archivoo){
        try {
            FileWriter archivo = new FileWriter(archivoo,true);
            archivo.write("Hola mundo");
            archivo.close();
        } catch (IOException e){
            e.printStackTrace(System.out);
        }

    }*/

    private static void insertarTexto(String archivoo){
        try {
            FileOutputStream archivo = new FileOutputStream(archivoo);
            ObjectOutputStream escritura = new ObjectOutputStream(archivo);
            escritura.writeObject(new Persona(50,"Adrian"));
            escritura.writeObject(new Persona(20,"Adrian"));
            escritura.writeObject(new Persona(21,"Adrian"));
            escritura.writeObject(new Persona(22,"Adrian"));
            escritura.writeObject(new Persona(23,"Adrian"));
            escritura.writeObject(new Persona(24,"Adrian"));


            System.out.println("Objeto añadido con exito");
            escritura.close();
        } catch (IOException e){
            e.printStackTrace(System.out);
        }

    }

    /*public static void leerTexto (String archivo){
        try {
            BufferedReader lector= new BufferedReader(new FileReader(archivo));
            String lectura;

            while ((lectura=lector.readLine())!=null){
                System.out.println(lectura);
            }
        }catch (IOException e){
            e.printStackTrace(System.out);
        }
    }*/

    private static void leerBinario(String archivoo) throws ClassNotFoundException {
        Persona asignada;
        try {
            FileInputStream archivo = new FileInputStream(archivoo);
            ObjectInputStream lectur = new ObjectInputStream(archivo);
            while (true){ //Leer continuamente hasta que ya no hayan mas objetos, ahi pasara a false
                asignada= (Persona) lectur.readObject(); //Guardar en persona todo lo que se va aa leer, por eso el casteo
                System.out.println(asignada+"\n");
            }
        }catch (EOFException i){
            return;
        } catch (IOException i){
            i.printStackTrace(System.out);
        }
    }

    private static void addBinario(String archivoo){
        try {
            FileOutputStream archivo = new FileOutputStream(archivoo,true);
            AddContenido escritura = new AddContenido(archivo);
            escritura.writeObject(new Persona(19,"Adrian"));
            escritura.writeObject(new Persona(20,"Adrian"));
            escritura.writeObject(new Persona(21,"Adrian"));
            escritura.writeObject(new Persona(22,"Adrian"));
            escritura.writeObject(new Persona(23,"Adrian"));
            escritura.writeObject(new Persona(24,"Adrian"));

            System.out.println("Objeto añadido con exito");
            escritura.close();
        } catch (IOException e){
            e.printStackTrace(System.out);
        }

    }

    public static void main(String[] args) throws ClassNotFoundException {
        insertarTexto("personas.bin");
        addBinario("personas.bin");
        leerBinario("personas.bin");
    }


}


/*
* private static void addBinario(String archivoo){
        try {
            FileOutputStream archivo = new FileOutputStream(archivoo,true);
            AddContenido escritura = new AddContenido(archivo);
            // Lista de personas para escribir en el archivo
            Persona[] personas = {
                    new Persona(19, "Adrian"),
                    new Persona(20, "Adrian"),
                    new Persona(21, "Adrian"),
                    new Persona(22, "Adrian"),
                    new Persona(23, "Adrian"),
                    new Persona(24, "Adrian")
            };

            // Escribir cada persona en el archivo
            for (Persona persona : personas) {
                escritura.writeObjectOverride(persona);
            }


            System.out.println("Objeto añadido con exito");
            escritura.close();
        } catch (IOException e){
            e.printStackTrace(System.out);
        }

    }
*
* */