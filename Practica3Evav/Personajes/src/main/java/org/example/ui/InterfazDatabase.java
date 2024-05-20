package org.example.ui;
import org.example.common.Constantes.*;
import org.example.service.GestionDatabase;

import java.util.InputMismatchException;
import java.util.Scanner;

import static org.example.common.Constantes.*;

public class InterfazDatabase {


    public static void action(){
        GestionDatabase gestionDatabase= new GestionDatabase();
        System.out.println(MENU);
        System.out.println(OP1);
        System.out.println(OP2);
        System.out.println(OP3);
        System.out.println(OP4);
        System.out.println(OP5);
        System.out.println(OP6);
        System.out.println(OP7);
        int op;
        do {
            op = menu();
            switch (op){
                case 1->mostrarInformacion(gestionDatabase);
                case 2-> agregarCampeon(gestionDatabase);

            }
        }while (op !=7);

    }

    private static void agregarCampeon(GestionDatabase g) {
        Scanner entrada= new Scanner(System.in);
        System.out.println("A que campeon deseas agregar? 1.Asesino 2.Mago");
        int op = menu();
        if (op==1){
            System.out.println("ingrese el numero de skins");
            int nSkins = entrada.nextInt();
            System.out.println("Ingrese el nombre del asesino");
            String n = entrada.nextLine();
            System.out.println("Altura");
            double altura = entrada.nextDouble();
            System.out.println("Ataque");
            double ataque = entrada.nextDouble();
            System.out.println("2 habilidades a ingresar: ");
            String h1 = entrada.nextLine();
            System.out.println("otra");
            String h2 = entrada.nextLine();

            //g.addCampeon()
        } else {
            //g.addCampeon()
        }

    }

    private static void mostrarInformacion(GestionDatabase g) {
        System.out.println("Por cual orden desea? 1.AScendente 2.Descendente");
        int op = menu();
        if (op==1){
            g.mostrarInformacion(true);
        } else {
            g.mostrarInformacion(false);
        }
    }

    public static int menu (){
        Scanner entrada= new Scanner(System.in);
        int n= 0;
        try {
            n = entrada.nextInt();
        } catch (InputMismatchException e){
            e.printStackTrace(System.out);
        }
        return n;
    }
}
