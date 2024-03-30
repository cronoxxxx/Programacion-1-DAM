package EJERCICIOS.CLASESYOBJETOS.Inicial.E9;

import java.util.StringJoiner;

/**
 * CrearCrear un objeto llamado Hospital con las siguientes propiedades y métodos:
 * Atributos:
 * int codHospital
 * String nombreHospital
 * String dirección
 * String telefono
 * int habitaciones totales
 * int habitaciones ocupadas
 * Métodos:
 * • Constructor que permite crear una instancia con los datos de un hospital.
 * • Métodos getter y setter
 * • Método ingreso() que incrementa las habitaciones ocupadas. No puede realizarse el
 * ingreso si las habitaciones ocupadas son iguales a las habitaciones totales del hospital.
 * Devuelve true si se ha podido realizar el ingreso.
 * • Método alta() que decrementa las habitaciones ocupadas. No puede realizarse el alta
 * las habitaciones ocupadas son 0. Devuelve true si se ha podido realizar el alta.
 * • Método toString(), que muestre todos los datos del hospital.
 * Crear una clase principal main ejecutable que:
 * • Cree una instancia del objeto Hospital llamado miQueridoHospital.
 * • Cambie el número de habitaciones de la instancia miQueridoHospital.
 * • Muestre el número de habitaciones de la instancia miQueridoHospital.
 * • Realiza un ingreso en la instancia miQueridoHospital.
 * • Muestra las habitaciones ocupadas de la instancia miQueridoHospital.
 * • Realiza un alta de la instancia miQueridoHospital.
 * • Muestra las habitaciones ocupadas de la instancia miQueridoHospital.
 * • Muestre todos los datos de la instancia miQueridoHospital.
 */
public class Hospital {
    private int codHospital,habitacionesTotales,habitacionesOcupadas;
    private String nombreHospital,direccion;

    public Hospital(int codHospital, int habitacionesTotales, String nombreHospital, String direccion) {
        this.codHospital = codHospital;
        this.habitacionesTotales = habitacionesTotales;
        this.habitacionesOcupadas = 0;
        this.nombreHospital = nombreHospital;
        this.direccion = direccion;
    }

    public int getCodHospital() {
        return codHospital;
    }

    public void setCodHospital(int codHospital) {
        this.codHospital = codHospital;
    }

    public int getHabitacionesTotales() {
        return habitacionesTotales;
    }

    public void setHabitacionesTotales(int habitacionesTotales) {
        this.habitacionesTotales = habitacionesTotales;
    }

    public int getHabitacionesOcupadas() {
        return habitacionesOcupadas;
    }

    public void setHabitacionesOcupadas(int habitacionesOcupadas) {
        this.habitacionesOcupadas = habitacionesOcupadas;
    }

    public String getNombreHospital() {
        return nombreHospital;
    }

    public void setNombreHospital(String nombreHospital) {
        this.nombreHospital = nombreHospital;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean ingreso (int ocupadas){
        if (this.habitacionesOcupadas+ocupadas<habitacionesTotales){
            habitacionesOcupadas+=ocupadas;
            return true;
        }
        return false;
    }
    public boolean alta (int desocupadas){
        if (this.habitacionesOcupadas-desocupadas>0){
            habitacionesOcupadas-=desocupadas;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("Codigo de hospital: %d\nHabitaciones totales: %d, Habitaciones ocupadas: %d\nNombre de hospital: %s\nDireccion: %s",codHospital,habitacionesTotales,habitacionesOcupadas,nombreHospital,direccion);
    }
}
