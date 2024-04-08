package exdrafts.com.software.peliculas.ui;

import exdrafts.com.software.peliculas.common.Constantes;
import exdrafts.com.software.peliculas.service.ControlPeliculasImpl;
import exdrafts.com.software.peliculas.service.IControlPeliculas;

import java.util.Scanner;

public class TesterControlPeliculas {
public void principal (){

    IControlPeliculas control = new ControlPeliculasImpl();
    Scanner entrada= new Scanner(System.in);
    int opcion;
    System.out.println(Constantes.MENU_GESTIONPELICULAS);
    do {
        System.out.println(Constantes.OPCION_INGRESAR);
        opcion= entrada.nextInt();
        switch (opcion){
            case 1 -> control.iniciarControlDePeliculas();

            case 2 ->{
                entrada.nextLine();
                System.out.println(Constantes.INGRESE_EL_NOMBRE_DE_LA_PELICULA);
                String nombrePelicula = entrada.nextLine();

                control.agregarPelicula(nombrePelicula);
                System.out.println(Constantes.PELICULA_AGREGADA);
            }
            case 3 ->{
                control.listarPeliculas();
            }
            case 4 ->{
                entrada.nextLine();
                System.out.println(Constantes.INGRESE_EL_NOMBRE_DE_LA_PELICULA);
                String nombrePelicula = entrada.nextLine();
                control.buscarPelicula(nombrePelicula);
            }
            case 5 -> System.out.println(Constantes.VUELVA_PRONTO);

            default -> {
                System.out.println(Constantes.NO_SE_HA_ENCONTRADO_ESA_OPCION_VUELVA_A_INGRESAR);
            }
        }
    }while (opcion!=5);

}
}
