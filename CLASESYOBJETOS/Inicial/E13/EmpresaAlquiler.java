package EJERCICIOS.CLASESYOBJETOS.Inicial.E13;

import java.util.Arrays;

/**
* La clase EmpresaAlquiler almacena la información de sus 5 coches en un array. De cada coche se
 * guarda: matrícula, modelo, marca, año de matriculación, categoría (1 ó 2), estado (alquilado o no) y
 * precio. Crear una programa y guarda directamente cinco coches, y después muetra un menu que
 * pueda hacer las siguientes operaciones:
 * - Alquiler de un vehículo: Se indica la matricula y el número de días que se quiere alquilar. Si el
 * vehículo ya está alquilado se retorna 0, sino, se retorna el importe del mismo teniendo en cuenta las
 * siguientes tarifas:
 * Tipo vehiculo 1; 2 días o menos : 40 euros/día. Más de dos días: 30 euros/día
 * Tipo vehiculo 2; 2 días o menos : 60 euros/día. Más de dos días: 45 euros/día
*Devolver un vehículo. Si no está alquilado da error.
 * - Saber si un vehículo está alquilado o no.
 * - Saber cuántos vehículos hay alquilados en este momento.
 * - Ganancias totales de todos los coches actualmente alquilados
*
* //crear metodo donde recorre y verifice si la matricula es igual a la de las que dara un metodo aleatoriamente, si las da, entonces se crea otra matricula
* */
public class EmpresaAlquiler {
    private Coche [] coche;

    public EmpresaAlquiler(Coche[] coche) throws EstadoCocheException, CategoriaCocheException {
        if (coche.length==2){
            this.coche=coche;
        }
    }

    public void precioAlquilerCoche (int dia, String matricula){
        boolean enAlquiler = false;
        for (int i = 0; i < coche.length && !enAlquiler; i++) {
            if (coche[i]!=null){
                if (!coche[i].getEstado().strip().equalsIgnoreCase("alquilado") && coche[i].getMatricula().equals(matricula)){
                    if (coche[i].getCategoria()==1 ){
                        if (dia > 0 && dia <=2){
                            enAlquiler=true;
                            coche[i].setPrecio(40*dia);
                            coche[i].setEstado("alquilado");
                        } else  if (dia > 2){
                            enAlquiler=true;
                            coche[i].setPrecio(30*dia);
                            coche[i].setEstado("alquilado");
                        }
                    } else  if (coche[i].getCategoria()==2){
                        if (dia > 0 && dia <=2){
                            enAlquiler=true;
                            coche[i].setPrecio(60*dia);
                            coche[i].setEstado("alquilado");
                        } else  if (dia > 2){
                            enAlquiler=true;
                            coche[i].setPrecio(45*dia);
                            coche[i].setEstado("alquilado");
                        }
                    }
                }
            }
        }
        if (!enAlquiler){
            System.err.println("No se ha encontrado un vehiculo para alquilar");
        }
    }

    public Coche isAlquilado (String matricula){
        Coche nuevo=null;
        boolean alquilado = false;
        for (int i = 0; i < coche.length && !alquilado; i++) {
            if (coche[i]!=null){
                if (coche[i].getMatricula().strip().equals(matricula) && coche[i].getEstado().strip().equalsIgnoreCase("alquilado")){
                    alquilado=true;
                    nuevo = coche[i];
                }
            }
        }
        return nuevo;
    }

    public void cantidadAlquilados (){
        int contador = 0;
        for (int i = 0; i < coche.length ; i++) {
            if (coche[i]!=null){
                if ( coche[i].getEstado().strip().equalsIgnoreCase("alquilado")){
                    contador++;
                }
            }
        }
        if (contador!=0){
            System.out.println("Hay "+contador+" vehiculos alquilados");
        } else
            System.err.println("No hay vehiculos alquilados");
    }

    public void gananciaAlquilados (){
        double suma = 0;
        for (int i = 0; i < coche.length ; i++) {
            if (coche[i]!=null){
                if ( coche[i].getEstado().strip().equalsIgnoreCase("alquilado")){
                    suma+=coche[i].getPrecio();
                }
            }
        }
        if (suma!=0){
            System.out.println("Hay "+suma+" de dinero en ganancia en total");
        } else
            System.err.println("No hay muchas ganancias presentes");
    }



    public void mostrarDatosVehiculos (){
        boolean enAlquiler = false;
        for (int i = 0; i < this.coche.length && !enAlquiler ; i++) {
            if (coche [i]!=null){
                System.out.println(coche[i]);
            }

        }
    }
}
