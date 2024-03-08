import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Empresa {
    private Vehiculo[][] vehiculos;
    private Scanner entrada = new Scanner(System.in);
    private static final String[] constantes = {"Barcelona", "Lugo", "Madrid", "Málaga", "Valencia", "Vizcaya"};

    public Empresa() {
        vehiculos = new Vehiculo[6][6];

        for (int i = 0; i < vehiculos.length; i++) {
            for (int j = 0; j < vehiculos[i].length; j++) {
                double precioRandom = (Math.random() * 60) + 30;
                double precioRandom2 = (Math.random() * 100) + 60;
                if (j % 2 == 0) {
                    switch (i) {
                        case 0:
                            vehiculos[i][j] = new Coche(precioRandom, (i + j), null, 2017, new Direccion(constantes[i]), 4, false);
                            break;
                        case 1:
                            vehiculos[i][j] = new Coche(precioRandom, (i + j), null, 2024, new Direccion(constantes[i]), 4, true);
                            break;
                        case 2:
                            vehiculos[i][j] = new Coche(precioRandom, (i + j), null, 2024, new Direccion(constantes[i]), 2, true);
                            break;
                        case 3:
                            vehiculos[i][j] = new Coche(precioRandom, (i + j), null, 2024, new Direccion(constantes[i]), 4, false);
                            break;
                        case 4:
                            vehiculos[i][j] = new Coche(precioRandom, (i + j), null, 2024, new Direccion(constantes[i]), 4, false);
                            break;
                        case 5:
                            vehiculos[i][j] = new Coche(precioRandom, (i + j), null, 2024, new Direccion(constantes[i]), 4, false);
                            break;
                    }
                } else {
                    switch (i) {
                        case 0:
                            vehiculos[i][j] = new Autobus(precioRandom2, (i + j), null, 2024, new Direccion(constantes[i]), 120, false);
                            break;
                        case 1:
                            vehiculos[i][j] = new Autobus(precioRandom2, (i + j), null, 2024, new Direccion(constantes[i]), 12, true);
                            break;
                        case 2:
                            vehiculos[i][j] = new Autobus(precioRandom2, (i + j), null, 2024, new Direccion(constantes[i]), 50, true);
                            break;
                        case 3:
                            vehiculos[i][j] = new Autobus(precioRandom2, (i + j), null, 2024, new Direccion(constantes[i]), 45, false);
                            break;
                        case 4:
                            vehiculos[i][j] = new Autobus(precioRandom2, (i + j), null, 2024, new Direccion(constantes[i]), 69, false);
                            break;
                        case 5:
                            vehiculos[i][j] = new Autobus(precioRandom2, (i + j), null, 2024, new Direccion(constantes[i]), 1000, false);
                            break;
                    }
                }

            }

        }
    }

    public Empresa(Vehiculo[][] vehiculos) {
        vehiculos = new Vehiculo[6][];
        for (int i = 0; i < vehiculos.length; i++) {
            System.out.println("¿De cuanto desea la longitud de la columna?");
            int columna = entrada.nextInt();
            vehiculos[i] = new Vehiculo[columna];
            for (int j = 0; j < vehiculos[i].length; j++) {
                double precioRandom = (Math.random() * 60) + 30;
                if (j % 2 == 0) {
                    vehiculos[i][j] = new Coche(precioRandom, (i + j), null, 2024, new Direccion(null, null), 4, false);
                } else {
                    vehiculos[i][j] = new Autobus(precioRandom, (i + j), null, 2024, new Direccion(null, null), 2, true);
                }
                System.out.println(vehiculos[i][j]);
            }
        }
    }


    public Vehiculo[][] getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(Vehiculo[][] vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void listadoVehiculos() {
        for (int i = 0; i < vehiculos.length; i++) {
            for (int j = 0; j < vehiculos[i].length; j++) {
                if (vehiculos[i][j] != null) {
                    System.out.println(vehiculos[i][j]);
                }
                System.out.println(vehiculos[i][j] + "\n");
            }

        }
        System.out.println();
    }

    public void anadirAutobus (Autobus autobus){
        boolean encontrado = false;
        for (int i = 0; i < vehiculos.length && !encontrado; i++) {
            for (int j = 0; j < vehiculos[i].length; j++) {
                if (vehiculos[i][j] == null) {
                    System.out.println("Agregado con exito");
                    vehiculos[i][j] = autobus;
                    encontrado = true;
                }
            }
        }
    }


    public void anadirCoche(Coche coche) {
        boolean encontrado = false;
        for (int i = 0; i < vehiculos.length && !encontrado; i++) {
            for (int j = 0; j < vehiculos[i].length; j++) {
                if (vehiculos[i][j] == null) {
                    System.out.println("Agregado con exito");
                    vehiculos[i][j] = coche;
                    encontrado = true;
                }
            }
        }
    }

    public void eliminarVehiculo(int id, Direccion provincia) {
        boolean encontrado = false;
        for (int i = 0; i < vehiculos.length && !encontrado; i++) {
            for (int j = 0; j < vehiculos[i].length; j++) {
                if ( vehiculos[i][j]!=null && id == vehiculos[i][j].identificador && provincia.getProvincia().trim().equalsIgnoreCase(vehiculos[i][j].direccionVehiculo.getProvincia())) {
                    vehiculos[i][j] = null;
                    System.out.println("Eliminado con exito");
                    encontrado = true;
                }
            }
        }
    }
    public void consultarVehiculos (Direccion provincia, int anyoPrincipal){
        for (int i = 0; i < vehiculos.length ; i++) {
            for (int j = 0; j < vehiculos[i].length; j++) {
                if (provincia.getProvincia().trim().equalsIgnoreCase(vehiculos[i][j].direccionVehiculo.getProvincia()) && anyoPrincipal<vehiculos[i][j].anyoFabricacion){
                        System.out.println(vehiculos[i][j]);
                }
            }
        }
    }

    public void vehiculosAscendente (Direccion provincia){
        double aux;
        for (int i = 0; i < vehiculos.length; i++) {
            for (int j = 0; j < vehiculos[i].length-1; j++) {
                if ( vehiculos[i][j]!=null &&provincia.getProvincia().trim().equalsIgnoreCase(vehiculos[i][j].direccionVehiculo.getProvincia())){
                    if (vehiculos[i][j].precio> vehiculos[i][j+1].precio){
                        aux=vehiculos[i][j].precio;
                        vehiculos[i][j].precio=vehiculos[i][j+1].precio;
                        vehiculos[i][j+1].precio=aux;
                    }
                }
            }
        }
        for (int i = 0; i < vehiculos.length; i++) {
            for (int j = 0; j < vehiculos[i].length; j++) {
                if ((vehiculos[i][j]!=null && provincia.getProvincia().trim().equalsIgnoreCase(vehiculos[i][j].direccionVehiculo.getProvincia()))){
                    System.out.println("Precio: "+vehiculos[i][j].precio);
                }

            }
        }


    }

    public void actualizarCapacidadCoche (int id){
        Scanner entrada = new Scanner(System.in);
        boolean encontrado = false;
        for (int i = 0; i < vehiculos.length && !encontrado; i++) {
            for (int j = 0; j < vehiculos[i].length; j++) {
                if (vehiculos[i][j]!=null){
                    if (id==vehiculos[i][j].identificador && vehiculos[i][j] instanceof Coche){
                        System.out.println("Actualiza la capacidad del coche: ");
                        double capacidadNuevo = entrada.nextInt();
                        ((Coche) vehiculos[i][j]).setCapacidad(capacidadNuevo);
                        System.out.println("Capacidad actualizada: "+vehiculos[i][j]);
                    }
                }
            }
        }
    }
    public boolean accesoMinusvalidos (int identificador){
        boolean encontrado = false;
        Scanner entrada = new Scanner(System.in);
        for (int i = 0; i < vehiculos.length && !encontrado; i++) {
            for (int j = 0; j < vehiculos[i].length; j++) {
                if (identificador==vehiculos[i][j].identificador && vehiculos[i][j]instanceof Autobus){
                    System.out.println("Actualiza la capacidad de acceso a minusvalidos a accesible? (Posibilitar) (si/no): ");
                    String opcion =entrada.next();
                    if (opcion.trim().equalsIgnoreCase("si")){
                        ((Autobus) vehiculos[i][j]).setAccesoMinusvalidos(true);

                        System.out.println("Accesibilidad posibilitada");
                        System.out.println(vehiculos[i][j]);
                        encontrado=true;
                    } else {
                        ((Autobus) vehiculos[i][j]).setAccesoMinusvalidos(false);
                        System.out.println("Accesibilidad negada");
                    }

                }
            }
        }
        return encontrado;
    }

    public void calcularPrecioMedioReal (){
        double precioMedia = 0;
        int contador = 0;
        for (int i = 0; i < vehiculos.length; i++) {
            for (int j = 0; j < vehiculos[i].length; j++) {
                if (vehiculos[i][j]!=null && vehiculos[i][j].direccionVehiculo.getProvincia().trim().equalsIgnoreCase(constantes[i])){
                    System.out.println("Provincia: "+(vehiculos[i][j].direccionVehiculo.getProvincia()));
                    precioMedia= precioMedia+vehiculos[i][j].precio;
                    contador++;
                    if (vehiculos[i][j]instanceof Coche){
                        System.out.println("Coches: "+vehiculos[i][j]);
                    } else {
                        System.out.println("Autobuses: "+vehiculos[i][j]);
                    }
                }
            }
            System.out.println("Media de precio real en la provincia: "+(precioMedia/contador));
        }

    }

}














