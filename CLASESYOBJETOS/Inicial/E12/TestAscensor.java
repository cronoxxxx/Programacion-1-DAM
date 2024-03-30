package EJERCICIOS.CLASESYOBJETOS.Inicial.E12;

import java.util.Scanner;

public class TestAscensor {
    //poner subir gente con math random, y si va mas alla del aforo, mostrar un mensaje, sino, completar la accion
    public static void main(String[] args) {
        Scanner entrada= new Scanner(System.in);
        int aforo = (int) (Math.random()*30) + 10;
        Ascensor uno = new Ascensor(aforo,0,0);
        Ascensor dos = new Ascensor(aforo,0,0);
        uno.pintarAscensor();
        dos.pintarAscensor();
        int opcion;
        do {
            System.out.println("Bienvenido a los ascensores, seleccione las opciones que hay: \n" +
                    "1. Añadir ocupante en un ascensor\n" +
                    "2. Salir ocupante en un ascensor\n" +
                    "3. Mover un ascensor\n" +
                    "4. Completar accion");
            System.out.println("Ingrese una opcion: ");
            opcion= entrada.nextInt();
            switch (opcion){
                case 1-> {
                    System.out.println("1. Ascensor 1\n2. Ascensor 2\n\nIngrese una opcion: ");
                    opcion= entrada.nextInt();
                    if (opcion==1){
                        if (uno.getCapacidad()-uno.getOcupacion()>0 && uno.getOcupacion()<uno.getCapacidad()) {
                            uno.setOcupacion();
                            System.out.println("Aforo disponible: " + (uno.getCapacidad() - uno.getOcupacion()));
                            uno.pintarAscensor();
                        } else {
                            System.out.println("ASCENSOR LLENO");
                        }
                    } else if (opcion==2) {
                        if (dos.getCapacidad()-dos.getOcupacion()>0 && dos.getOcupacion()<dos.getCapacidad()) {
                            dos.setOcupacion();
                            System.out.println("Aforo disponible: " + (dos.getCapacidad() - dos.getOcupacion()));
                            dos.pintarAscensor();
                        } else {
                            System.out.println("ASCENSOR LLENO");
                        }
                    } else {
                        System.err.println("Ascensor "+opcion+" no existe");
                    }
                }
                case 2->{
                    System.out.println("1. Ascensor 1\n2. Ascensor 2\n\nIngrese una opcion: ");
                    opcion= entrada.nextInt();
                    if (opcion==1){
                        if (uno.getCapacidad()-uno.getOcupacion()>0 && uno.getOcupacion()<uno.getCapacidad() && uno.getOcupacion()>0) {
                            uno.removeOcupacion();
                            System.out.println("Aforo disponible: " + (uno.getCapacidad() - uno.getOcupacion()));
                            uno.pintarAscensor();
                        } else {
                            System.out.println("ASCENSOR VACIO");
                        }
                    } else if (opcion==2) {
                        if (dos.getCapacidad()-dos.getOcupacion()>0 && dos.getOcupacion()<dos.getCapacidad() && dos.getOcupacion()>0) {
                            dos.removeOcupacion();
                            System.out.println("Aforo disponible: " + (dos.getCapacidad() - dos.getOcupacion()));
                            dos.pintarAscensor();
                        } else {
                            System.out.println("ASCENSOR VACIO");
                        }
                    } else {
                        System.err.println("Ascensor "+opcion+" no existe");
                    }
                }
                case 3->{
                    int pisoNext;
                    int quantity;
                    System.out.println("1. Ascensor 1\n2. Ascensor 2\n\nIngrese una opcion: ");
                    opcion= entrada.nextInt();
                    if (opcion==1){
                        if (uno.getCapacidad()-uno.getOcupacion()>0 && uno.getOcupacion()<uno.getCapacidad() && uno.getOcupacion()>0) {
                            do {
                                System.out.println("Ingrese a que piso desea mover");
                                pisoNext= entrada.nextInt();
                            } while (pisoNext>10 || pisoNext<0);
                            uno.setPisoActual(pisoNext);
                            uno.setConsumo();
                            uno.pintarAscensor();
                            do {
                                System.out.println("¿Cuantos pasajeros salen?");
                                quantity= entrada.nextInt();
                            } while (quantity<0 || quantity>uno.getOcupacion());
                            uno.removeOcupacion(quantity);
                            //EL DOS VA AL CERO SI ESTA VACIO
                            if (dos.getOcupacion()==0){
                                dos.setPisoActual(0);
                            }
                            uno.pintarAscensor();
                            dos.pintarAscensor();
                        } else {
                            System.out.println("NO SE PUEDE MOVER EL ASCENSOR ASI");
                        }
                    } else if (opcion==2) {
                        if (dos.getCapacidad()-dos.getOcupacion()>0 && dos.getOcupacion()<dos.getCapacidad() && dos.getOcupacion()>0) {
                            System.out.println("Ingrese a que piso desea mover");
                            do {
                                System.out.println("Ingrese a que piso desea mover");
                                pisoNext= entrada.nextInt();
                            } while (pisoNext> 10 || pisoNext<0);
                            dos.setPisoActual(pisoNext);
                            dos.setConsumo();
                            dos.pintarAscensor();
                            do {
                                System.out.println("¿Cuantos pasajeros salen?");
                                quantity= entrada.nextInt();
                            } while (quantity<0 || quantity>dos.getOcupacion());
                            dos.removeOcupacion(quantity);
                            //EL uno VA AL CERO SI ESTA VACIO
                            if (uno.getOcupacion() == 0) {
                                uno.setPisoActual(0);
                            }
                            uno.pintarAscensor();
                            dos.pintarAscensor();
                        }else{
                            System.out.println("NO SE PUEDE MOVER EL ASCENSOR ASI");
                        }
                    } else {
                        System.err.println("Ascensor "+opcion+" no existe");
                    }
                }
                case 4-> System.out.println("GRACIAS POR SU BUEN VIAJE");
                default -> System.err.println("OPCION NO DISPONIBLE");
            }
        } while (opcion!=4);



    }



}
