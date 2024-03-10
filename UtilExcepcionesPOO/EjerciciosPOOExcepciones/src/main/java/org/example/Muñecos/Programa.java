package org.example.Muñecos;

import java.util.Scanner;

public class Programa {
    private Muñecos [][] muñecos;
    private Scanner entrada = new Scanner(System.in);

    public Programa(int filas, int columnas) {
        muñecos = new Muñecos[filas][columnas];
    }

    public void añadirMuñeco (Muñecos nuevo){
        boolean hayHueco = false;
        for (int i = 0; i < muñecos.length && !hayHueco; i++) {
            for (int j = 0; j < muñecos[i].length && !hayHueco; j++) {
                if (muñecos[i][j]==null){
                    muñecos[i][j]=nuevo;
                    hayHueco=true;
                }
            }
        }
        if (!hayHueco){
            System.err.println("No se ha podido añadir, posiciones llenas");
        }
    }

    public void listarMuñecoEspecifico (String nombre){
        boolean encontrado = false;
        for (int i = 0; i < muñecos.length && !encontrado; i++) {
            for (int j = 0; j < muñecos[i].length && !encontrado ; j++) {
                if (muñecos[i][j]!=null){
                    if (nombre.trim().equalsIgnoreCase(muñecos[i][j].getNombre())){

                        System.out.println(muñecos[i][j]);
                        encontrado=true;
                    }
                }
            }
        }
        if (!encontrado){
            System.err.println("El objeto no existe");
        }
    }

    public void listarTodosMuñecos (){
        int contador = 0;

        for (int i = 0; i < muñecos.length; i++) {
            for (int j = 0; j < muñecos[i].length ; j++) {
                if (muñecos[i][j]!=null){
                    System.out.println(muñecos[i][j]);
                    contador++;
                }
            }
        }
        if (contador==0){
            System.err.println("No existen objetos para alistar");
        }
    }

    public void realizarAccionesMuñeco (String nombre){
        int opcion;
        System.out.println("Opciones: ");
        System.out.println("1. Que hable");
        System.out.println("2. Que se mueva");
        System.out.println("3. Cambiar su color");
        System.out.println("Ingrese la opcion: ");
        opcion=entrada.nextInt();
        boolean encontrado = false;
        switch (opcion){
            case 1:
                for (int i = 0; i < muñecos.length && !encontrado; i++) {
                    for (int j = 0; j < muñecos[i].length && !encontrado; j++) {
                        if (muñecos[i][j]!=null){
                            if (nombre.trim().equalsIgnoreCase(muñecos[i][j].getNombre())){
                                muñecos[i][j].muñecoHabla();
                                encontrado=true;
                            }
                        }

                    }
                }
                if (!encontrado){
                    System.err.println("Muñeco no encontrado");
                }
            break;
            case 2:
                for (int i = 0; i < muñecos.length && !encontrado; i++) {
                    for (int j = 0; j < muñecos[i].length && !encontrado; j++) {
                        if (muñecos[i][j]!=null){
                            if (nombre.trim().equalsIgnoreCase(muñecos[i][j].getNombre())){
                                encontrado=true;
                                muñecos[i][j].muñecoMueve();
                            }
                        }
                    }
                }
                if (!encontrado){
                    System.err.println("Muñeco no encontrado");
                }
                break;
            case 3:
                entrada.nextLine();
                for (int i = 0; i < muñecos.length && !encontrado; i++) {
                    for (int j = 0; j < muñecos[i].length && !encontrado; j++) {
                        if (muñecos[i][j]!=null){
                            if (nombre.trim().equalsIgnoreCase(muñecos[i][j].getNombre())){
                                encontrado=true;
                                System.out.println("Ingrese un color nuevo: ");
                                String cambiarcolor = entrada.nextLine();
                                muñecos[i][j].setColor(cambiarcolor);
                            }
                        }
                    }
                }
                if (!encontrado){
                    System.err.println("Muñeco no encontrado");
                }
                break;
            default:
        }
    }



}
