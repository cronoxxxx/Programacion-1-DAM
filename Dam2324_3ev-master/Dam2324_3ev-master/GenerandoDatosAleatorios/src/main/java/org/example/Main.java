package org.example;

import net.datafaker.Faker;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        Faker fk = new Faker();
        System.out.println("------------------Baloncesto---------------------------");
        for (int i = 0; i < 10 ; i++) {
            System.out.println(fk.basketball().positions());
        }
        System.out.println("----------------------POKEMON--------------------------");
        for (int i = 0; i < 10 ; i++) {
            System.out.println(fk.pokemon().name());
        }
        System.out.println("---------------------HARRY POTTER----------------------");
        for (int i = 0; i < 10 ; i++) {
            System.out.println(fk.harryPotter().book());
        }
        System.out.println("---------------Cómo entrenar a tu dragon------------------------------");
        for (int i = 0; i < 10 ; i++) {
            System.out.println(fk.howToTrainYourDragon().characters());
        }
    }

}