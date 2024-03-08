import java.util.Scanner;
//WALTHER ADRIAN SAAVEDRA MATEO 1DAM
public class Tester {
    public static void main(String[] args) {
        programaMenu();
    }
    private static void programaMenu(){
        Empresa empresa = new Empresa();
        Scanner entrada = new Scanner(System.in);
        int opcion,id;
        Direccion dir=null;
        String provincia;
        int anyo,identificador;

        do {
            System.out.println("Bienvenido al menu, seleccione una opcion:\n" +
                    "1. Listar vehiculos de la empresa\n" +
                    "2. Añadir algun vehiculo (Autobus o Coche)\n" +
                    "3. Consulta de vehiculos\n" +
                    "4. Actualizar capacidad de un coche a partir de su identificador\n" +
                    "5. Actualizar el atributo de minusvalidos para cada autobus\n" +
                    "6. Eliminar vehiculo por identificador y provincia\n" +
                    "7. Calcular el precio medio del alquiler total por provincia (coches y autobuses)\n" +
                    "8. Mostrar los vehiculos en una provincia de forma ascendente");
            System.out.println("Ingrese una opcion: ");
            opcion= entrada.nextInt();
            switch (opcion){
                case 1:
                    empresa.listadoVehiculos();
                    break;
                case 2:
                    anadirVehiculo(empresa);
                case 3:
                    entrada.nextLine();
                    System.out.println("Ingresa la provincia: ");
                    provincia = entrada.nextLine();
                    dir=new Direccion(provincia);
                    System.out.println("Ingresa el año a partir de donde desea contar");
                    anyo= entrada.nextInt();
                    empresa.consultarVehiculos(dir,anyo);
                    break;
                case 4:
                    System.out.println("Ingresa el indentificador: ");
                    identificador=entrada.nextInt();
                    empresa.actualizarCapacidadCoche(identificador);
                    break;
                case 5:
                    System.out.println("Ingresa identificador: ");
                    identificador=entrada.nextInt();
                    boolean siPosible = empresa.accesoMinusvalidos(identificador);
                    if (siPosible){
                        System.out.println("Se ha logrado la actualizacion");
                    } else {
                        System.out.println("No se ha logrado, o ha sido rechazado");
                    }
                    break;
                case 6:
                    System.out.println("Ingrese el identificador: ");
                    id= entrada.nextInt();
                    entrada.nextLine();
                    System.out.println("Ingresa la provincia: ");
                    provincia = entrada.nextLine();
                    dir=new Direccion(provincia);
                    empresa.eliminarVehiculo(id,dir);
                    break;
                case 7:
                    empresa.calcularPrecioMedioReal();
                    break;
                case 8:
                    entrada.nextLine();
                    System.out.println("Ingresa la provincia: ");
                    provincia = entrada.nextLine();
                    dir=new Direccion(provincia);
                    empresa.vehiculosAscendente(dir);
                    break;
                case 9:
                    System.out.println("VUELVA PRONTO ! ! !");
                    break;
                default:
                    System.err.println("OPCION NO VALIDA");
            }
        }while (opcion!=9);

    }


    private  static void anadirVehiculo(Empresa empresa){
        Scanner entrada = new Scanner(System.in);
        double precio;
        int identificador;
        String tipoVehiculo, provincia;
        int anyoFabricacion, numPasajeros;
        Direccion direccionVehiculo;
        double capacidad;
        Coche coche = null;
        Autobus autobus = null;
        System.out.println("Seleciona un vehiculo para añadir: ");
        System.out.println("1. Coche");
        System.out.println("2. Autobus");
        System.out.println("Selecciona una opcion: ");
      int   opcion = entrada.nextInt();
        switch (opcion){
            case 1:
                System.out.println("Ingrese el precio: ");
                precio=entrada.nextInt();
                System.out.println("Ingresa el indentificador: ");
                identificador=entrada.nextInt();
                entrada.nextLine();
                System.out.println("Ingresa el tipoDeVehiculo: ");
                tipoVehiculo=entrada.nextLine();
                System.out.println("Ingresa el año de fabricacion");
                anyoFabricacion=entrada.nextInt();
                System.out.println("Ingresa la capacidad");
                capacidad=entrada.nextDouble();
                entrada.nextLine();
                System.out.println("Ingrese la provincia: ");
                provincia= entrada.nextLine();
                direccionVehiculo= new Direccion(provincia);
                coche=new Coche(precio,identificador,tipoVehiculo,anyoFabricacion,direccionVehiculo,capacidad,false);
                empresa.anadirCoche(coche);
                break;

            case 2:
                System.out.println("Ingrese el precio: ");
                precio=entrada.nextInt();
                System.out.println("Ingresa el indentificador: ");
                identificador=entrada.nextInt();
                entrada.nextLine();
                System.out.println("Ingresa el tipoDeVehiculo: ");
                tipoVehiculo=entrada.nextLine();
                entrada.nextLine();
                System.out.println("Ingresa el año de fabricacion");
                anyoFabricacion=entrada.nextInt();
                System.out.println("Ingresa la capacidad");
                capacidad=entrada.nextInt();
                entrada.nextLine();
                System.out.println("Ingrese la provincia: ");
                provincia= entrada.nextLine();
                System.out.println("Ingrese el numero de pasajeros");
                numPasajeros=entrada.nextInt();
                direccionVehiculo= new Direccion(provincia);
                autobus=new Autobus(precio,identificador,tipoVehiculo,anyoFabricacion,direccionVehiculo,numPasajeros,true);
                empresa.anadirAutobus(autobus);
                break;
}}}