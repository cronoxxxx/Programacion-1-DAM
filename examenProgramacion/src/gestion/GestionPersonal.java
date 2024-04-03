package gestion;

import java.util.Arrays;
import java.util.Scanner;

public class GestionPersonal {

    private Trabajador[] trabajadores;


    public GestionPersonal(Trabajador[] trabajadores) {
        this.trabajadores = trabajadores;
    }



    public GestionPersonal() {
        trabajadores = new Trabajador[50];

        for (int i = 0; i < trabajadores.length; i++) {
            if (i < 3) {
                trabajadores[i] = new Programador();
            } else if (i<6) {
                trabajadores[i] = new Jefe();
            } else {
                trabajadores[i]=null;
            }
        }

    }

    public void draft() {
        for (int i = 0; i < trabajadores.length; i++) {
            if (trabajadores[i]!=null){
                System.out.println(trabajadores[i]);
            }
        }
    }


    public boolean darAltaTrabajador(int opcion) {
        Scanner entrada = new Scanner(System.in);
        String nombre;
        String apellidos;
        String dep;
        int añoIncorporacion;
        double sueldoDiario;
        String[] lenguajes = new String[50];
        int cantidadTrabajadores, dias;
        if (opcion == 1) {
            System.out.println("Ingrese su nombre");
            nombre = entrada.nextLine();
            System.out.println("Apellidos: ");
            apellidos = entrada.nextLine();
            System.out.println("Departamento");
            dep = entrada.nextLine();
            System.out.println("Año de incorporacion");
            añoIncorporacion = entrada.nextInt();
            System.out.println("Sueldo diario");
            sueldoDiario = entrada.nextDouble();
            System.out.println("Dias de trabajo");
            dias = entrada.nextInt();
            System.out.println("Cantidad de lenguajes que sabe");
            int c = entrada.nextInt();
            entrada.nextLine();
            String [] v = new String[c];
            System.out.println("Ingrese");
            for (int i = 0; i < v.length; i++) {
                v[i]= entrada.nextLine();
            }

            for (int i = 0; i < v.length; i++) {
                if (v[i]!=null){
                    lenguajes[i]=v[i];
                }
            }
            if (darAltaProgramador(nombre, apellidos, dep, añoIncorporacion, sueldoDiario, lenguajes, dias)) {
                return true;
            }

        } else if (opcion == 2) {
            System.out.println("Ingrese su nombre");
            nombre = entrada.nextLine();
            System.out.println("Apellidos: ");
            apellidos = entrada.nextLine();
            System.out.println("Departamento");
            dep = entrada.nextLine();
            System.out.println("Año de incorporacion");
            añoIncorporacion = entrada.nextInt();
            System.out.println("Sueldo diario");
            sueldoDiario = entrada.nextDouble();
            System.out.println("Dias de trabajo");
            dias = entrada.nextInt();
            System.out.println("Cantidad de trabajadores");
            cantidadTrabajadores = entrada.nextInt();
            if (darAltaJefe(nombre, apellidos, dep, añoIncorporacion, sueldoDiario, cantidadTrabajadores, dias)) {
                return true;
            }
        }
        return false;
    }

    private boolean darAltaProgramador(String nombre, String apellidos, String dep, int añoIncorporacion, double sueldoDiario, String[] lenguajes, int dias) {


        for (int i = 0; i < trabajadores.length; i++) {
            if (trabajadores[i] == null) {
                trabajadores[i] = new Programador(nombre, apellidos, dep, añoIncorporacion, sueldoDiario, lenguajes, dias);

                return true;
            }
        }
        return false;
    }


    private boolean darAltaJefe(String nombre, String apellidos, String dep, int añoIncorporacion, double sueldoDiario, int cantidadTr, int dias) {


        for (int i = 0; i < trabajadores.length; i++) {
            if (trabajadores[i] == null) {
                trabajadores[i] = new Jefe(nombre, apellidos, dep, añoIncorporacion, sueldoDiario, cantidadTr, dias);
                return true;
            }
        }
        return false;
    }

    public void darBajaTrabajador() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el año");
        int año = entrada.nextInt();
        for (int i = 0; i < trabajadores.length; i++) {
            if(trabajadores[i]!=null){
                if (trabajadores[i].añoIncorporacion<año){
                    System.out.println(trabajadores[i]);
                    System.out.println("Esta seguro de que quiere eliminar? ");
                    String conf =null;
                    do{
                        conf = entrada.nextLine();
                        if (conf.strip().equalsIgnoreCase("si")){
                            trabajadores[i]=null;

                        }
                    }while (!(conf.strip().equalsIgnoreCase("si") || (conf.strip().equalsIgnoreCase("no"))));


                }

            }
        }

    }

    public void mostrarEmpleadoDepartamento() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el departamento");
        String depart = entrada.nextLine();
        for (int i = 0; i < trabajadores.length; i++) {
            if(trabajadores[i]!=null){
                if (trabajadores[i].departamento.strip().equalsIgnoreCase(depart)){
                    System.out.println(trabajadores[i]);

                }
            }
        }

    }

    public void listaProgramadoresSalarioReal (){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el valor menor");
        int menor = entrada.nextInt();
        System.out.println("Ingrese el valor mayor");
        int mayor= entrada.nextInt();
        for (int i = 0; i < trabajadores.length; i++) {
            if (trabajadores[i]!=null){
                if (trabajadores[i].sueldoReal>menor && trabajadores[i].sueldoReal<mayor){
                    System.out.println(trabajadores[i]);

                }
            }
        }

    }

    public void modificarTrabajadoresJefes (){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el nombre del jefe");
        String nombre = entrada.nextLine();
        System.out.println("Ingrese el apellido");
        String apellido = entrada.nextLine();
        for (int i = 0; i < trabajadores.length; i++) {
            if (trabajadores[i]!=null && trabajadores[i]instanceof Jefe && trabajadores[i].nombre.strip().equalsIgnoreCase(nombre) && trabajadores[i].apellidos.strip().equalsIgnoreCase(apellido)){
                System.out.println("Ingrese el numero de trabajadores a modificar");
                int n = entrada.nextInt();
                ((Jefe) trabajadores[i]).setCantidadTrabajadores(n);
            }
        }
    }

    public void modificarLenguajesProgramador (){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el nombre del programador");
        String nombre = entrada.nextLine();
        System.out.println("Ingrese el apellido");
        String apellido = entrada.nextLine();
        for (int i = 0; i < trabajadores.length; i++) {
            if (trabajadores[i]!=null && trabajadores[i]instanceof Programador && trabajadores[i].nombre.strip().equalsIgnoreCase(nombre) && trabajadores[i].apellidos.strip().equalsIgnoreCase(apellido)){

                System.out.println("Ingrese el lenguaje de programacion nuevo");
                String l = entrada.nextLine();

                ((Programador) trabajadores[i]).setLenguajes(l);
            }
        }
    }

    public void ordenarTrabajadoresPorIncorporacion() {
        Trabajador t;
        for (int i = 0; i < trabajadores.length; i++) {
            for (int j = i+1; j < trabajadores.length-1; j++) {
                if (trabajadores[i]!=null && trabajadores[j]!=null)
                if (trabajadores[i].compareTo(trabajadores[j])>0){
                    t = trabajadores[i];
                    trabajadores[i]=trabajadores[j];
                    trabajadores[j]=t;
                }
            }

        }

        for (int i = 0; i < trabajadores.length; i++) {
            if (trabajadores[i]!=null){
                System.out.println(trabajadores[i]);
            }

        }


    }


    public void calcularCosteTotal(){
        Scanner entrada = new Scanner(System.in);
        double suma=0;
        System.out.println("Introduzca el nombre del jefe");
        String jefe = entrada.nextLine();
        String []nombre = new String[3];
        for (int j = 0; j < nombre.length; j++) {
            System.out.println("Ingrese el empleado");
            nombre[j]= entrada.nextLine();
            for (int i = 0; i < trabajadores.length; i++) {

                if (trabajadores[i]!=null)
                    if (trabajadores[i].nombre.strip().equalsIgnoreCase(nombre[j]) || trabajadores[i].nombre.strip().equalsIgnoreCase(jefe)){
                        suma+= trabajadores[i].sueldoDiario * 7;

                    }


            }
        }
        System.out.println(suma);




    }
    }
















