package com.example.ejemploahorcado.dao;


import com.example.ejemploahorcado.common.Categoria;
import com.example.ejemploahorcado.common.CategoriaException;
import com.example.ejemploahorcado.domain.Palabra;
import net.datafaker.Faker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Palabras extends ArrayList<Palabra> {
    private final ArrayList<Palabra> palabras;
    private static final int maxLength = 1000;
    public Palabras() {
        HashSet<Palabra> hs = new HashSet<>();
        //try catch
        Faker fake = new Faker();
            for (int i = 0; i <maxLength;i++) {
                try {
                    int categoryIndex =(int) (Math.random() * 6)+1;
                    switch (categoryIndex) {
                        case 1-> hs.add(new Palabra(fake.pokemon().name(), Categoria.pokemon.name()));
                        case 2-> hs.add(new Palabra(fake.dragonBall().character(), Categoria.dragonBall.name()));
                        case 3-> hs.add(new Palabra(fake.address().country(), Categoria.address.name()));
                        case 4-> hs.add(new Palabra(fake.football().players(), Categoria.football.name()))  ;
                        case 5 -> hs.add (new Palabra(fake.animal().name(),Categoria.animal.name()));
                        default-> hs.add(new Palabra(fake.starWars().character(), Categoria.starWars.name()));
                    }//System.out.println(hs.get(i).toStringFile()); //separador con comas para el archivo
                    // Verificar duplicados y decrementar el índice si es necesario
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

