package org.example.drafts;

import org.example.dao.DaoFicherosFruta;
import org.example.dao.Mostrador;

import java.io.IOException;

public class JsonFacturas {
    public static void main(String[] args) throws IOException {
        Mostrador mostrador = new Mostrador();
        try {
            System.out.println(mostrador.loadFacturas());
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }


    }
}
