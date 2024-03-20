package dao;


import common.Categoria;
import common.CategoriaException;
import domain.Palabra;
import net.datafaker.Faker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Palabras {
    private final ArrayList<Palabra> palabras;
    private static final int maxLength = 1000;
    public Palabras() {
        HashSet<Palabra> hs = new HashSet<>();
        //try catch
        Faker fake = new Faker();
            for (int i = 0; i <maxLength; i++) {
                try {
                    switch (i / 200) {
                        case 0-> hs.add(new Palabra(fake.pokemon().name().strip(), Categoria.pokemon.name()));
                        case 1-> hs.add(new Palabra(fake.southPark().characters().strip(), Categoria.southPark.name()));
                        case 2-> hs.add(new Palabra(fake.address().country().strip(), Categoria.address.name()));
                        case 3-> hs.add(new Palabra(fake.football().players().strip(), Categoria.football.name()));
                        default-> hs.add(new Palabra(fake.starWars().character().strip(), Categoria.starWars.name()));
                    }//System.out.println(hs.get(i).toStringFile()); //separador con comas para el archivo
                }catch (CategoriaException e){
                    System.out.println(e.getMessage());
                    i--;
                }
            }
        //System.out.println(hs);
        //Se añade el HashSet de palabras
        palabras = new ArrayList<>(hs);
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
            if (palabras.get(i).getCategoria().trim().equalsIgnoreCase(categoria) && palabras.get(i).getLevel() == dificultad) {
                elementosDeTalCategoriaDificultad.add(palabras.get(i));
            }
        }
        if (elementosDeTalCategoriaDificultad.size() > 0) { //obtener palabra aleatoria
            palabra = elementosDeTalCategoriaDificultad.get((int) (Math.random() * elementosDeTalCategoriaDificultad.size()));
        }
        return palabra;
    }


}

