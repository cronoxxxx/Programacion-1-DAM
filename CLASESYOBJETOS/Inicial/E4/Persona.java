package EJERCICIOS.CLASESYOBJETOS.Inicial.E4;

/*
* Hacer un programa que cree una clase Persona, con estos atributos:
String nombre, int edad, String dni.
Crear un constructor que de valores a los atributos, y estos métodos:
• void esMayorDeEdad() escribe por pantalla si la persona es mayor de edad o si no lo es.
• int cuantoHaceMayorEdad() es un método que no recibe parámetro y devuelve el número de
años que hace que la persona es mayor de edad (si la persona es menor de edad deberá por lo
tanto devolver un valor negativo)
• boolean asignarDNI() es un método que recibe un String por parámetro, y lo asigna al DNI de
la Persona. Sin embargo, no debe asignar el DNI si éste no es correcto (es correcto si tiene 9
caracteres, ni más ni menos). El método además devuelve un valor booleano dependiendo de si
el DNI se ha validado (y por lo tanto, se ha asignado al atributo de la clase )
• boolean estaJubilado() devuelve true o false dependiente de si la persona esta jubilada o no
Se considera que una persona se jubila a los 65.*/
public class Persona {
    private String nombre;
    private String DNI;
    private int edad;

    public Persona(String nombre, String DNI, int edad) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.edad = edad;
    }

    public void esMayorDeEdad() {
            if (edad >= 18) {
                System.out.println("Es una persona mayor de edad");
            } else {
                System.out.println("Es menor de edad");
            }
    }



    public int cuantoHaceMayorEdad() {
        if (edad >= 0) {
            if (edad >= 18) {
                return edad;
            } else {
                return edad = -1;
            }
        } else {
            return edad = -1;
        }
    }

    public String getDNI() {
        return DNI;
    }

    public boolean asignarDNI(String DNIP) {
        if (DNIP.length() == 9) {
            DNI = DNIP;
            return true;
        } else {
            return false;
        }
    }

    public boolean estaJubilado() {
        if (edad>=0){
            if (edad>=65){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
