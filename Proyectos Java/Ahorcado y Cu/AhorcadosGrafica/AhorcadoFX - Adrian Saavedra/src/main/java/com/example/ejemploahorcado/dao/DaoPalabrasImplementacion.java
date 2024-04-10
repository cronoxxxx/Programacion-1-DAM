package com.example.ejemploahorcado.dao;

import com.example.ejemploahorcado.common.CategoriaException;
import com.example.ejemploahorcado.common.Constantes;
import com.example.ejemploahorcado.domain.Palabra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class DaoPalabrasImplementacion implements DaoPalabras {
    protected final Palabras lista;

    public DaoPalabrasImplementacion()  {
        this.lista = new Palabras();
    }

    @Override
    public List<Palabra> getListaDePalabras() {
        return lista.getListaPalabras(); //devuelve los elementos
    }

    @Override
    public boolean isEmptyPalabrasList() { //comprueba si esta vacio o no
        return lista.getListaPalabras().isEmpty();
    }

    @Override
    public boolean insertarPalabra(Palabra palabra) { //metodo add con el objeto directamente
        return lista.getListaPalabras().add(palabra);
    }

    @Override
    public boolean insertarPalabra(int id, int level, String incognita, String categoria) throws CategoriaException { //metodo add creando un elemento dentro
        return lista.getListaPalabras().add(new Palabra(id,level,incognita,categoria));
    }

    @Override
    public List<Palabra> getPalabrasCategoria(String categoria) {
        List<Palabra> palabraObtenida = new ArrayList<>();
        for (int i =0; i<lista.getListaPalabras().size();i++){
            if (lista.getListaPalabras().get(i).getCategoria().equalsIgnoreCase(categoria)){
                palabraObtenida.add(lista.getListaPalabras().get(i));
            }
        }
        return palabraObtenida;
    }

    @Override
    public List<Palabra> getPalabrasNivelCategoria(int nivel, String categoria) {
        List<Palabra> palabraObtenida = new ArrayList<>();
        for (int i =0; i<lista.getListaPalabras().size();i++){
            if (lista.getListaPalabras().get(i).getCategoria().equalsIgnoreCase(categoria) && lista.getListaPalabras().get(i).getLevel()==nivel){
                palabraObtenida.add(lista.getListaPalabras().get(i));
            }
        }
        return palabraObtenida;
    }

    @Override
    public List<Palabra> getPalabrasNivel(int nivel) {
        List<Palabra> palabraObtenida = new ArrayList<>();
        for (int i =0; i<lista.getListaPalabras().size();i++){
            if (lista.getListaPalabras().get(i).getLevel()==nivel){
                palabraObtenida.add(lista.getListaPalabras().get(i));
            }
        }
        return palabraObtenida;
    }

    @Override
    public List<Palabra> getPalabrasOrdenadas(boolean ascendente) {
        List<Palabra> elementosOrdenados = new ArrayList<>();
        elementosOrdenados = getListaDePalabras();
        Collections.sort(elementosOrdenados);
        if (!ascendente){
            Collections.reverse(elementosOrdenados);
        }
        return elementosOrdenados;
    }

    @Override
    public boolean eliminarPalabra(Palabra Palabra) {
        boolean eliminado = false;
        for (int i = 0; i < lista.getListaPalabras().size() && !eliminado; i++) {
            if (Objects.equals(lista.getListaPalabras().get(i).getIncognita(), Palabra.getIncognita()) && Objects.equals(lista.getListaPalabras().get(i).getCategoria(), Palabra.getCategoria())){
                lista.getListaPalabras().remove(i);
                eliminado=true;
            }
        }
        if (!eliminado){
            System.out.println(Constantes.NO_SE_HA_ENCONTRADO_LA_PALABRA);
        }

        return eliminado;
    }

    @Override
    public boolean eliminarPalabra(int id) {
        boolean eliminado = false;
        for (int i = 0; i < lista.getListaPalabras().size() && !eliminado; i++) {
            if (lista.getListaPalabras().get(i).getId()==id){
                lista.getListaPalabras().remove(i);
                eliminado=true;
            }
        }
        if (!eliminado){
            System.out.println(Constantes.NO_SE_HA_ENCONTRADO_LA_PALABRA);
        }
        return eliminado;
    }

    @Override
    public void idOK(int id) throws IDException {
        boolean encontrado = false;
        for (int i = 0; i < lista.getListaPalabras().size() && !encontrado; i++) {
            if (lista.getListaPalabras().get(i).getId()==id){
                encontrado = true;
            }
        }
        if (encontrado){
            //System.out.println("No se ha encontrado la palabra");
            throw new IDException();
        }
    }

    @Override
    public boolean modificarCategoria(int id, String categoria)  {
        boolean cambio = false;
        for (int i = 0; i < lista.getListaPalabras().size() && !cambio; i++) {
            if (lista.getListaPalabras().get(i).getId()==id){

                try {
                    lista.getListaPalabras().get(i).setCategoria(categoria);
                    cambio=true;
                } catch (CategoriaException e) {
                    System.out.println(e.getMessage());

                }
            }
        }
        return cambio;
    }

    @Override
    public boolean modificarPalabra(int id, String incognita) {
        boolean cambio = false;
        for (int i = 0; i < lista.getListaPalabras().size() && !cambio; i++) {
            if (lista.getListaPalabras().get(i).getId()==id){
                lista.getListaPalabras().get(i).setIncognita(incognita);
                cambio=true;
                 //rompe bucle
            }
        }
        return cambio;
    }
}
