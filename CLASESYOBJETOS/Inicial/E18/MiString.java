package EJERCICIOS.CLASESYOBJETOS.Inicial.E18;

import java.util.Arrays;

/*
* Escribir una clase MiString, que tiene
• atributos:
- private String contenido;
• Métodos:
- Constructor vacío
- Constructor con todos los atributos
- getters de los atributos (no se escriben setters)
- mitadFrase(): devuelve un String que desde ser la primera mitad del valor de contenido
*- invierteFrase(): devuelve un String que coge el contenido y lo divide en palabras y las ubica en
orden inverso
- tamaño(): devuelve el tamaño del contenido
- tamañoSinEspacios(): devuelve el tamaño de contenido sin contar los espacios iniciales o finales
de la cadena
- concatena(String otracadena); devuelve un String que es la concatenación del contenido actual
más el parámetro recibido.
Crear una clase Prueba que en su main cree varios objetos de MiString y pruebe sus métodos.
* */
public class MiString {
    private StringBuilder sb;
    private String contenido;

    public MiString(String contenido) {
        sb = new StringBuilder();
        sb.append(contenido).append(" ");
        this.contenido = contenido;
    }

    public String mitadFrase(){
        String cs=null;
        char [] c = new char[contenido.length()/2];
        for (int i = 0,j=0; i < contenido.length()/2; i++) {

            c[j]= contenido.charAt(i);
            j++;

        }
        cs= String.valueOf(c);
        return cs;
    }

    public String mitadFrases() {
        return contenido.substring(0, contenido.length() / 2);
    }

    public String invierteFrases(){
        return String.valueOf(new StringBuilder(contenido).reverse());
    }

    public String invierteFrase(){
        String cs=null;
        char [] c = new char[contenido.length()];
        for (int i = contenido.length()-1,j=0; i>=0 ; i--) {
            c[j]= contenido.charAt(i);
            j++;
        }
        cs = Arrays.toString(c).replace("[","").replace("]","").replace(",","").replace(" ","");
        return cs;
    }

    public int tamaño(){
        return contenido.length();
    }

    public int tamañosinEspacios(){

        return contenido.replaceAll("\\s","").length();
    }

    public String concat(String otracadena){
        return String.valueOf(sb.append(otracadena).append(" "));
    }

}
