package EJERCICIOS.CLASESYOBJETOS.Inicial.E12;

public class Ascensor {
    /**13.Ejercicio Ascensor. Un edificio, que tiene 11 plantas (de la 0 -planta baja- a la 10) tiene dos ascensores.
     Cada ascensor tiene estos atributos (todos private)
     int capacidad .- numero de personas que puede albergar
     int ocupación .- personas que tiene dentro en un momento dado
     int consumo .- consumo que ha realizado, inicialmente es 0, no se incluye en el constructor
     int piso actual .- piso en el que se encuentra actualmente
     Escribir su constructor y funciones getters y setters
     Realizar un programa que tenga un menú con varias opciones.
     Las acciones de cada opción se han de desarrollar en métodos diferentes.
     Estas son las opciones del menu :
     1- añadir ocupante ascensor 1
     (añade un ocupante al ascensor, si cabe)
     2- añadir ocupante ascensor 2
     (ídem opción 1 pero con ascensor 2 )
     3- salir ocupante ascensor 1
     ( quita un ocupante al ascensor, si lo tiene)
     4- salir ocupante ascensor 2
     ( ídem opción 3 pero con ascensor 2)
     5- mover ascensor 1
     ( Se pide la usuario que indique por teclado a qué piso se dirige el ascensor. Cada vez que se
     mueve el ascensor, se incrementa su atributo consumo, en tantas unidades como los pisos que
     se desplaza, multiplicados por las personas que tiene en el momento de moverse)
     6- mover ascensor 2
     ( ídem opción 5 pero con ascensor 2)
     • Al final de la ejecución de cada opción se ha de llamar a un método (que hay que hacer también)
     llamado public static void mostrarEstadoAscensores() que escriba por pantalla todos los atributos de los
     dos ascensores (static si se va a llamar al método desde un método main...).
     • CONSEJO: Considerar que parece que las acciones de meter y sacar gente de un ascensor, o
     moverlo, son propias de un ascensor... ¿deberían ser métodos de la clase Ascensor ...?
     • Otras reglas:
     - Siempre ha de haber un ascensor en la planta 0, si esta vacío. Esto es, si hay un ascensor vacío y
     no está en la planta 0, cuando el otro ascensor sale de la planta 0, el primer ascensor ha de bajar a
     la planta 0
     - Un ascensor que este en la planta x no puede moverse a la misma planta x
     - Un ascensor que no esta en la planta 0, y se mueve a la planta 0, se vacía de ocupantes al llegar a
     la planta 0
     **/
    private int capacidad,consumo,ocupacion,pisoActual;
    private int id;
    private static int autonumerico=1;

    public Ascensor(int capacidad, int ocupacion, int pisoActual) {
        this.id=autonumerico;
        autonumerico++;
        this.capacidad = capacidad;
        this.consumo = 0;
        this.ocupacion = ocupacion;
        this.pisoActual = pisoActual;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getConsumo() {
        return consumo;
    }

    public void setConsumo() {
        this.consumo = consumo+1;
    }

    public int getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion() {
        this.ocupacion = ocupacion+1;
    }

    public void removeOcupacion() {
        this.ocupacion = ocupacion-1;
    }

    public void removeOcupacion(int cantidadRemover) {
            this.ocupacion-=cantidadRemover;
    }
    public int getPisoActual() {
        return pisoActual;
    }

    public void setPisoActual(int pisoActual) {
        if (pisoActual>=0 && pisoActual<10) {
            this.pisoActual = pisoActual;
        } else {
            System.err.println("PISO INEXISTENTE");
        }
    }

    public void pintarAscensor (){
        System.out.println("ASCENSOR "+id);
        for (int i = 10; i>=0; i--) {
            if (i==pisoActual){
                System.out.println(i+"  #");
            } else {
                System.out.println(i+"  -");
            }
        }
        System.out.println("Capacidad: "+this.capacidad);
        System.out.println("Ocupacion: "+this.ocupacion);
        System.out.println("Consumo: "+this.consumo);
    }



}
