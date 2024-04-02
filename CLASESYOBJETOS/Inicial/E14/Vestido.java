package EJERCICIOS.CLASESYOBJETOS.Inicial.E14;

import java.util.Objects;

/**
 * Ejercicio Vestido para rebajas.
 * Crear la Clase Vestido: tiene estos atributos (todos privados)
 * - String nombre
 * - int talla
 * - String marca
 * - double precio
 * - boolean temporadaRebajas (indica si estamos en rebajas o no)
 * - int unidadesEnAlmacen (numero de unidades de ese vestido que hay en el almacén)
 * Métodos a escribir:
 * - constructor con todos los atributos
 * - constructor con todos los atributos menos precio, que por defecto es 0
 * - constructor vacío
 * - getters y setters, de todo menos setter de temporadaRebajas y de unidadesEnAlmacen
 * - String toString(), para poder "escribir" como es un vestido (a gusto del alumno)
 * - void cambiarTemporada() cambia el valor de temporadaRebajas, de true a false, o de false a true. Si se
 * activa temporada de rebajas, el precio baja al 40%, si se acaba la temporada de rebajas, el precio
 * vuelve al precio original
 * - double precioEnRebajas() Devuelve el precio que tiene el vestido (si esta en rebajas) o el que tendría en
 * rebajas (si no se esta en rebajas)
 * - boolean retirarUnidades(int unidades) Quita las unidades indicadas por parámetro. Si no hay unidades
 * disponibles, no hace nada y devuelve false, si no, elimina y devuelve true
 * - double importeEnAlmacen() devuelve el importe de todas las unidades del vestido en el almacén, según
 * el precio del momento (considerando si se esta en rebajas o no)
 * - double importeEnAlmacen(boolean estandoEnRebajas) devuelve el importe de todas las unidades del vestido
 * en el almacén, pero no teniendo en cuenta su precio del momento, sino considerando que el
 * parametro estandoEnRebajajas nos indica si hemos de hacer el cálculo como si estuviéramos en rebajas o
 * no
 * - void aumentarPrecio(int porcentaje) aumenta el precio del vestido en el porcentaje indicado por parámetro
 * Realizar otra clase Prueba que cree vestidos y pruebe todos los métodos
 * MEJORA1: en la clase Prueba hacer un array de 5 Vestidos, rellenarlo, y calcular y escribir por
 * pantalla el precio de los cinco vestido juntos, la media de los cinco y el nombre del vestido más caro
 * MEJORA2: escribir los métodos compareTo() e equals() . Para comparar dos vestidos se hace por el
 * precio, y dos vestidos son iguales si son del mismo nombre, marca y talla.
 * MEJORA3: Hacer un constructor copia (que valga para crear un vestido recibiendo como parámetro
 * otro vestido) y un método Vestido copiar(), que devuelve un duplicado del vestido actual. Ambas son
 * duplicados, no copias, esto es, las copias han de ser "profundas" (deep copy)
 */
public class Vestido implements Comparable<Vestido> {

    private String nombre, marca;
    private int talla;
    private double precio;

    private boolean isTemporadaRebajas;

    private int unidadesEnAlmacen;

    public Vestido() {
    }

    public Vestido(String nombre, String marca, int talla, double precio, boolean isTemporadaRebajas, int unidadesEnAlmacen) {
        this.nombre = nombre;
        this.marca = marca;
        this.talla = talla;
        this.precio = precio;
        this.isTemporadaRebajas = isTemporadaRebajas;
        this.unidadesEnAlmacen = unidadesEnAlmacen;
    }

    public Vestido(Vestido v) {
        this.nombre = v.nombre;
        this.marca = v.marca;
        this.talla = v.talla;
        this.precio = v.precio;
        this.isTemporadaRebajas = v.isTemporadaRebajas;
        this.unidadesEnAlmacen = v.unidadesEnAlmacen;
    }

    public Vestido devolverVestido() {
        return new Vestido(this);
    }

    public Vestido(String nombre, String marca, int talla, boolean isTemporadaRebajas, int unidadesEnAlmacen) {
        this.nombre = nombre;
        this.marca = marca;
        this.talla = talla;
        this.precio = cambiarPrecioTemporada();
        this.isTemporadaRebajas = isTemporadaRebajas;
        this.unidadesEnAlmacen = unidadesEnAlmacen;
    }

    public double cambiarPrecioTemporada() {
        this.precio = Math.random() * 1000 + 1;
        double auxPrecio = this.precio;
        if (isTemporadaRebajas) {
            return auxPrecio;
        } else {
            double desc = this.precio * 0.4;
            return this.precio -= desc;
        }
    }

    public void cambiarTemporada (){
        if (isTemporadaRebajas){
            isTemporadaRebajas=false;
        } else {
            isTemporadaRebajas=true;
        }
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getTalla() {
        return talla;
    }

    public void setTalla(int talla) {
        this.talla = talla;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isTemporadaRebajas() {
        return isTemporadaRebajas;
    }


    public int getUnidadesEnAlmacen() {
        return unidadesEnAlmacen;
    }


    public double precioEnRebajas() {

        if (!isTemporadaRebajas) {
            return this.precio * (1-((double) 40 /100));
        } else {
            return -1;
        }
    }

        public boolean retirarUnidades ( int unidades){
            if (this.unidadesEnAlmacen - unidades > 0) {
                this.unidadesEnAlmacen -= unidades;
                return true;
            }
            return false;
        }


        public double importeEnAlmacen () {
            return this.unidadesEnAlmacen * precio;
        }

        public double importeEnAlmacen ( boolean estadoRebajas){
            double precioRebajas = this.precio - 0.6;
            if (estadoRebajas) {
                return precioRebajas * unidadesEnAlmacen;
            } else {
                return this.unidadesEnAlmacen * precio;
            }
        }

        public void aumentarPrecio ( double porcentaje){
        double obtenido = precio * porcentaje/100;
            if (porcentaje < 99.9) {
                this.precio += obtenido;
            }
        }


        @Override
        public String toString () {
            return String.format("Nombre: %s\nTalla: %d\nMarca: %s\nPrecio: %.2f\nUnidades en almacen disponibles: %d\nEstá en temporada de rebaja?: %b", nombre, talla, marca, precio, unidadesEnAlmacen, isTemporadaRebajas);
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vestido vestido = (Vestido) o;
        return talla == vestido.talla && Objects.equals(nombre, vestido.nombre) && Objects.equals(marca, vestido.marca);
    }

    @Override
        public int hashCode () {
            return Objects.hash(nombre, marca, talla, precio, isTemporadaRebajas, unidadesEnAlmacen);
        }

        @Override
        public int compareTo (Vestido o){
            return Double.compare(this.precio, o.getPrecio());
        }
    }
