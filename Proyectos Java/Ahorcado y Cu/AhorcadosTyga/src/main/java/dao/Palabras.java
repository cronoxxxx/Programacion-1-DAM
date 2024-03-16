package dao;


import common.Categoria;
import common.CategoriaException;
import domain.Palabra;
import net.datafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class Palabras {
    private final ArrayList<Palabra> palabras;

    public Palabras() {
        this.palabras = new ArrayList<>();
        //try catch
        Faker fake = new Faker();
        for (int i = 0; i < 10; i++) {
            try {
                palabras.add(new Palabra(fake.pokemon().name(), Categoria.pokemon.name()));
                System.out.println(palabras.get(i).toStringFile()); //separador con comas para el archivo
            }catch (CategoriaException e){
                System.out.println(e.getMessage());
                i--;
            }
        }

    }

    public Palabras(ArrayList<Palabra> palabras) {
        this.palabras = palabras;
    }

    public List<Palabra> getListaPalabras() {
        return palabras;
    }

    public void setListaPalabras(List<Palabra> palabras) {
        this.palabras.clear();
        this.palabras.addAll(palabras);
    }

    public Palabra getPalabraDificultadCategoria(int dificultad, String categoria) { //se usara en la clase de juego
        Palabra palabra = null;
        ArrayList<Palabra> elementosDeTalCategoriaDificultad = new ArrayList<>();
        for (int i = 0; i < palabras.size(); i++) {
            if (palabras.get(i).getCategoria().equalsIgnoreCase(categoria) && palabras.get(i).getLevel() == dificultad) {
                elementosDeTalCategoriaDificultad.add(palabras.get(i));
            }
        }
        if (elementosDeTalCategoriaDificultad.size() > 0) { //obtener palabra aleatoria
            palabra = elementosDeTalCategoriaDificultad.get((int) (Math.random() * elementosDeTalCategoriaDificultad.size()));
        }
        return palabra;
    }


}

