package EJERCICIOS.CLASESYOBJETOS.Inicial.E9;

import java.awt.image.RasterOp;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Scanner entrada= new Scanner(System.in);
        System.out.println("Ingrese el codigo del hospital: ");
        int cod = entrada.nextInt();
        System.out.println("Ingrese el total de habitaciones: ");
        int totalRooms = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Ingrese el nombre del hospital: ");
        String hosp = entrada.nextLine();
        System.out.println("Ingrese la direccion: ");
        String dir = entrada.nextLine();
        Hospital miQueridoHospital = new Hospital(cod,totalRooms,hosp,dir);
        //PRUEBAS:
        System.out.println("Cambie el numeros de habitaciones del hospital");
        int cambio = entrada.nextInt();
        if (cambio > 0){
            miQueridoHospital.setHabitacionesTotales(cambio);
            System.out.println(miQueridoHospital);
        }

        System.out.println("Ocupa habitaciones: ");
        cambio= entrada.nextInt();
        miQueridoHospital.ingreso(cambio);
        System.out.println("Habitaciones ocupadas: "+miQueridoHospital.getHabitacionesOcupadas());

        System.out.println("Desocupa habitaciones: ");
        cambio= entrada.nextInt();
        miQueridoHospital.alta(cambio);
        System.out.println("Habitaciones ocupadas: "+miQueridoHospital.getHabitacionesOcupadas());

        System.out.println("Resultado final: ");
        System.out.println(miQueridoHospital);

    }
}
