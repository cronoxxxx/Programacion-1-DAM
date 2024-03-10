package org.example.Muñecos;

import java.util.Scanner;

/*
* **Enunciado: Programa de Muñecos**

**Objetivo:**
Desarrollar un programa que permita gestionar un conjunto de muñecos, cada uno con sus propias características y acciones.

**Características de los Muñecos:**
1. **Nombre:** Cada muñeco tiene un nombre único.
2. **Tipo:** Los muñecos pueden pertenecer a diferentes tipos (por ejemplo, animales, personas, robots, etc.).
3. **Color:** Cada muñeco tiene un color asociado.
4. **trabajo o chamba:**


**Acciones de los Muñecos:**
1. **Hablar:** Los muñecos pueden emitir frases o sonidos.
2. **Moverse:** Los muñecos pueden realizar movimientos específicos.
3. **Cambiar Color:** Los muñecos pueden cambiar su color.

**Funcionalidades del Programa:**
1. **Agregar Muñeco:** Permitir al usuario agregar un nuevo muñeco con nombre, tipo y color especificados.
2. **Mostrar Información:** Mostrar la información detallada de un muñeco específico.
3. **Listar Muñecos:** Mostrar la lista de todos los muñecos presentes, indicando su nombre y tipo.
4. **Realizar Acciones:** Permitir al usuario seleccionar un muñeco y realizar acciones como hablar, moverse o cambiar de color.
5. **Salir del Programa:** Ofrecer la opción de salir del programa.

**Consideraciones Adicionales:**
- Utilizar estructuras de datos adecuadas para almacenar la información de los muñecos.
- Proporcionar una interfaz amigable para que el usuario interactúe con el programa.
- Implementar funciones o métodos para cada acción realizada por los muñecos.

---

Este enunciado es bastante general, así que puedes ajustarlo según las necesidades específicas y la complejidad que desees agregar al programa. ¡Espero que te sea útil!
* */
public class Probador {
    static Scanner entrada= new Scanner(System.in);
    public static void main(String[] args) {
        menu();
    }
    private static void menu(){
        int fila= (int)(Math.random()*30)+1;
        System.out.println(fila);
        int columna= (int)(Math.random()*30)+1;
        System.out.println(columna);
        Programa programa = new Programa(fila,columna);
        Muñecos nuevos ;
        int opcion;
        do {
            System.out.println("Bienvenido al programa, selecciona tus muñecos");
            System.out.println("1. **Listar Muñecos:.\n" +
                    "2. **Mostrar Información:.\n" +
                    "3. **Agregar Muñeco:.\n" +
                    "4. **Realizar Acciones:.\n" +
                    "5. **Salir del Programa:.");
            System.out.println("Ingrese una opcion: ");
            opcion= entrada.nextInt();
            String nombre, color, trabajo, tipo;
            switch (opcion){
                case 1:
                    programa.listarTodosMuñecos();
                    break;
                case 2:
                    entrada.nextLine();
                    System.out.println("Ingresa el nombre del muñeco");
                    nombre=entrada.nextLine();
                    programa.listarMuñecoEspecifico(nombre);
                    break;
                case 3:
                    entrada.nextLine();
                    System.out.println("Ingresa el nombre del muñeco");
                    nombre=entrada.nextLine();
                    System.out.println("Tipo de muñeco");
                    tipo=entrada.nextLine();
                    System.out.println("Trabajo del muñeco");
                    trabajo = entrada.nextLine();
                    System.out.println("Color del muñeco: ");
                    color = entrada.nextLine();
                    nuevos= new Muñecos(nombre,tipo,trabajo,color);
                    programa.añadirMuñeco(nuevos);
                    break;
                case 4:
                    entrada.nextLine();
                    System.out.println("Ingresa el nombre del muñeco");
                    nombre=entrada.nextLine();
                    programa.realizarAccionesMuñeco(nombre);
                    break;
                case 5:
                    System.out.println("VUELVA PRONTO ! ! !");
                    break;
                default:
                    System.err.println("Opcion no valida");
            }
        }while (opcion!=5);
    }
}
