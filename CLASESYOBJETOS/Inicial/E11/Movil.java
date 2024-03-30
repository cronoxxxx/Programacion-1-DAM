package EJERCICIOS.CLASESYOBJETOS.Inicial.E11;



/**Una clase Movil tiene estos atributos
 int capacidadMaxima (se mide en mb)
 int numeroMaximoAplicaciones
 int capacidadUsada
 int numeroAplicacionesActuales
 Crear getters y setters y un constructor que recibe capacidadMáxima y númeroMáximoAplicaciones, y pone
 capacidadUsada a 0 y númeroAplicacionesActuales a 0
 Crear estos métodos:
 - void añadirAplicación(int cap), que tiene parámetro capacidad (tamaño) de la aplicación a añadir.
 No puede añadir una aplicación si se supera el tamaño máximo del móvil, o el número
 máximo de aplicaciones permitido. Si se puede añadir la aplicación, se cambian los atributos
 capacidadUsada y numeroAplicacionesActuales
 - void borrartodo() , pone capacidadUsada a 0 y númeroAplicacionesActuales a 0
 - void mostrarEstado() , que escribe por consola los cuatro atributos.
 Crear una clase Prueba con un main para probar todas las funcionalidades de la clase Movil.
 MEJORA 1: Consideremos que cambiamos el atributo númeroAplicacionesActuales por un array (array) de
 Strings, que contendrá los nombres de las aplicaciones que se instalen en el móvil. Modificar el método
 void añadirAplicación(int cap), para que sea void añadirAplicación(String nombre, int cap), y añada una
 aplicación al array. Hacer el resto de cambios necesarios para que funcionen el resto de métodos*/
public class Movil {
    private int capacidadMaxima,numeroMaximoAplicaciones,capacidadUsada,numeroAplicacionesActuales;
    public Movil(int capacidadMaxima, int numeroMaximoAplicaciones) throws MBEXception {
        ComprobacionMegas.megasOK(capacidadMaxima);
        this.capacidadMaxima = capacidadMaxima;
        this.numeroMaximoAplicaciones = numeroMaximoAplicaciones;
        this.capacidadUsada=0;
        this.numeroAplicacionesActuales=0;
    }

    public boolean añadirAplicacion (int capacidad){
        if (capacidad<this.capacidadMaxima && this.capacidadUsada<this.capacidadMaxima && this.numeroAplicacionesActuales<this.numeroMaximoAplicaciones ){
            this.capacidadUsada+=capacidad;
            this.numeroAplicacionesActuales+=1;
            return true;
        }
        return false;
    }
    public void borrarTodo (){
        this.capacidadUsada = 0;  this.capacidadMaxima=0;  this.numeroAplicacionesActuales=0;  this.numeroMaximoAplicaciones=0;
    }


    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public int getNumeroMaximoAplicaciones() {
        return numeroMaximoAplicaciones;
    }

    public void setNumeroMaximoAplicaciones(int numeroMaximoAplicaciones) {
        this.numeroMaximoAplicaciones = numeroMaximoAplicaciones;
    }

    public int getCapacidadUsada() {
        return capacidadUsada;
    }

    public void setCapacidadUsada(int capacidadUsada) {
        this.capacidadUsada = capacidadUsada;
    }

    @Override
    public String toString() {
        return String.format("Capacidad maxima: %d\nNumero max de apps: %d\nCapacidad Usada: %d\nApps actuales: %d",capacidadMaxima,numeroMaximoAplicaciones,capacidadUsada,numeroAplicacionesActuales);
    }

    public int getNumeroAplicacionesActuales() {
        return numeroAplicacionesActuales;
    }

    public void setNumeroAplicacionesActuales(int numeroAplicacionesActuales) {
        this.numeroAplicacionesActuales = numeroAplicacionesActuales;
    }

}
