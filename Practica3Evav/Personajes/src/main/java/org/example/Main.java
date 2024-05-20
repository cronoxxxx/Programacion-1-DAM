package org.example;

import org.example.dao.DaoFicheros;
import org.example.dao.Database;
import org.example.domain.Campeon;

import java.util.List;
import java.util.Map;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
Database database = new Database();
        Map<String, List<Campeon>> habilidadesMap = database.getHabilidadesMap();

        for (String habilidad : habilidadesMap.keySet()) {
            List<Campeon> campeonesConHabilidad = habilidadesMap.get(habilidad);
            System.out.println("Habilidad: " + habilidad);
            System.out.println("Numero de campeones: " + campeonesConHabilidad.size());
            for (Campeon campeon : campeonesConHabilidad) {
                System.out.println("Nombre: " + campeon.getNombre());
            }
        }
    }
}