package ui;


import common.Categoria;
import common.CategoriaException;
import common.Comprobacion;
import net.datafaker.Faker;

public class Main {
    public static void main(String[] args)  {
        //En el main sólo hay que llamar a los métodos de la UI que darán paso al luego o administrar diccionario.


        //Este código no va aquí, pero es para que veáis cómo funciona ciertos aspectos de la aplicación a tener en cuenta
        /*GestionDiccionario.mostrarMenu();
        try {
            Comprobacion.categoriaOk(Categoria.comedia.name());
            Comprobacion.categoriaOk("hola");
        }catch (CategoriaException e){
            System.out.println(e.getMessage());
        }


        Faker faker = new Faker();
        String nombre = faker.gameOfThrones().character();
        System.out.println(nombre);
        String animal = faker.animal().name();
        System.out.println(animal);
        String fecha = faker.date().birthday(10,15).toString();
        System.out.println(fecha);*/

        //El siguiente código no va aquí pero es para que sepáis cómo funciona el id autonumérico
        /*Palabras asdf = new Palabras();
        System.out.println(Palabras.getAutonumerico());
        Palabra asd = new Palabra(2,"324",Categoria.accion.name());
        System.out.println(Palabras.getAutonumerico());
        Palabra asd2 = new Palabra(2,"324",Categoria.miedo.name());
        System.out.println(Palabras.getAutonumerico());*/


        String FALLO1 = "  +---+\n  |   |\n      |\n      |\n      |\n      |\n      |\n   ========";
        System.out.println(FALLO1);
        String FALLO2= "  +---+\n  |   |\n __   |\n      |\n      |\n      |\n      |\n   ========";
        System.out.println(FALLO2);
        String FALLO3= " +---+\n  |   |\n __   |\n   |  |\n      |\n      |\n      |\n   ========";
        System.out.println(FALLO3);
        String FALLO4 = " +---+\n  |   |\n __   |\n|  |  |\n      |\n      |\n      |\n   ========";
        System.out.println(FALLO4);
        String FALLO5=" +---+\n  |   |\n __   |\n|  |  |\n --   |\n      |\n      |\n   ========";
        System.out.println(FALLO5);
        String FALLO6=" +---+\n  |   |\n __   |\n|  |  |\n --   |\n  |   |\n      |\n   ========";
        System.out.println(FALLO6);
        String FALLO7=" +---+\n  |   |\n __   |\n|  |  |\n --   |\n  |   |\n / \\    |\n   ========";
        System.out.println(FALLO7);



    }
}



/*
* +---+
  |   |
      |
      |
      |
      |
=========
*
* */