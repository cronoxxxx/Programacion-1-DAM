package EJERCICIOS.CLASESYOBJETOS.Inicial.E5;
/*
*
* Crear una clase "Coche" que tenga declaradas estos atributos :
• String marca: se da valor inicial en el constructor y no se modifica nunca más.
• String color: se da valor inicial en el constructor y se puede modificar posteriormente.
• int km: al principio vale 0, y se puede incrementar posteriormente (solo incrementar)
• double precio: se da valor inicial en el constructor y se puede modificar posteriormente.
• double factor_contaminación: se da valor inicial en el constructor y no se puede modificar
posteriormente
• int anio: se da valor inicial en el constructor y no se puede modificar posteriormente
• String matricula: no se da valor inicial con el constructor, pero se puede cambiar después.
• double impuestoMatriculacion: no se da valor inicial con el constructor, pero puede cambiar
después.
• String dniTitular: no se da valor inicial con el constructor, se puede cambiar después.
Se solicita:
• Hacer métodos setters y getters para todos los atributos que los necesiten, y hacer constructor
con todos los parámetros que sean necesarios, según las reglas antes descritas.
• Escribir un método void anadirKm(int km) para añadir kilómetros.
• Hacer una clase Prueba que cree 3 objetos de la clase coche con varios valores, escriba por
pantalla los atributos de cada coche tras haberlos creado, y escriba por pantalla la media del
precio de los 3 coches y escriba por pantalla cual de los 3 es el que tiene más
factor_contaminacion
*
*
MEJORA 1: Incluir un método double calcularImpuestoContaminacion() que calcule un nuevo
atributo, el impuesto_contaminación, que depende del factor_contaminacion, según estas reglas:
• si el factor_contaminacion es < 5.0, el impuesto es el 2% del precio del coche
• si el factor_contaminacion es > 5.0 y < 10.0 , el impuesto es el 5% del precio del coche
• si el factor_contaminacion es > 10.0, el impuesto es el 10% del precio del coche
*
*
MEJORA 2:
• Crear método hacerTransferencia(Coche otroCoche), que cambia de titular al coche
(pone como dniTitular del coche actual el dniTitular del coche pasado por parámetro).
*
*
MEJORA 3:
• Crear la clase Persona. Atributos String nombre y String dni. Cambiar la clase Coche y
el atributo String dniTitular pasa a ser Persona titular. Realizar los cambios
necesarios para que todos los métodos y pruebas anteriores funcionen
*
*
* MEJORA 4:
• Crear clase PlazaGarage, que tiene dos atributos:
‣ atributo Coche coche, un objeto Coche que se puede asignar a una plaza
‣ atributo double coste, que tiene el importe mensual que cuesta cada plaza
• Crear clase Garage, que tiene un único atributo y varios métodos:
‣ atributo PlazaGarage[] plazas, un array de 10 plazas de garage.
‣ método construyePlazas(), que crea plazas (vacías) para todas las posiciones del
array de plazas
‣ método alquilarPlaza(Coche uncoche, int numplaza), que asigna el coche uncoche
al array de plazas, en la posición numplaza. No puede alquilarse una plaza si ya tenia
un coche asignado a ella
‣ método asignarImporte(double importeAlquiler, int numplaza), que aplica el
valor importeAlquiler en el atributo coste, en la plaza que ocupa la posición
numplaza en el array
‣ método double calcularIngresosGarage(): calcula y devuelve el importe total que
se gana con todas las plazas que estén alquiladas
‣ método boolean bajaPlaza(int numplaza): elimina un coche del garage. Devuelve
true si puede darlo de baja, false si no existía en el garaje.
‣ método double plazaMasBarata(): calcula y devuelve el importe de la plaza más
barata (cuidado, solo de las que están alquiladas)
* */
public class Tester {
}
