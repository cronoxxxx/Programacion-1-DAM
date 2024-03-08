package IOFilles.Files3;

import java.io.*;

public class AddContenido extends ObjectOutputStream {
    public AddContenido(OutputStream out) throws IOException {
        super(out);
    }
    public AddContenido () throws IOException,SecurityException{

    }

    @Override
    protected void writeStreamHeader() throws IOException {
        reset();
    }

    @Override
    protected void writeObjectOverride(Object obj) throws IOException {
        // Personalización: Imprimir información antes de escribir cada objeto
        System.out.println("Escribiendo objeto: " + obj);

        // Llamada al método writeObject de la superclase para realizar la escritura estándar
        super.writeObjectOverride(obj);
    }
}
