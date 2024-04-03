package gestion;

import java.util.Scanner;

public class Tester {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcion = 0;
        GestionPersonal g = new GestionPersonal();
        do {
            System.out.println("Gestion: ");
            System.out.println("Bienvenido al menu");
            System.out.println("1. Dar alta a un trabajador");
            System.out.println("2. Dar baja a un trabajador");
            System.out.println("3. Mostrar a los trabajadores segun su departamento");
            System.out.println("4. Obtener trabajadores por un salario medio");
            System.out.println("5. Modificar el numero de trabajadores de un jefe");
            System.out.println("6. Añadir un lenguaje de programacion a un programador");
            System.out.println("7. Mostrar los trabajadores ordenados");
            System.out.println("8.Coste total de tres empleados y un jefe");
            System.out.println("9. Salir.");
            System.out.println("Ingrese una opcion: ");
            opcion= entrada.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("¿Cual desea?");
                    System.out.println("1. Programador");
                    System.out.println("2. Jefe");
                    opcion= entrada.nextInt();

                    if(g.darAltaTrabajador(opcion)){
                        System.out.println("AGREGADO CON EXITO");
                    } else {
                        System.err.println("No se pudo completar la accion");
                    }
                    break;
                case 2:
                    g.darBajaTrabajador();
                    break;
                case 3:
                    g.mostrarEmpleadoDepartamento();
                    break;
                case 4:
                    g.listaProgramadoresSalarioReal();
                    break;
                case 5:
                    g.modificarTrabajadoresJefes();
                    break;
                case 6:
                    g.modificarLenguajesProgramador();
                    break;
                case 7:
                    g.ordenarTrabajadoresPorIncorporacion();
                    break;
                case 8:
                    g.calcularCosteTotal();
                    break;
                case 9:
                    System.out.println("VUELVA PRONTO ! ! !");
                    break;
            }
        }while (opcion!=9);



    }

}
