package Runtime;

import java.io.IOException;

//try catch para excepciones no verificadas -- dependen del programador y su codigo
public class Exc4 {
    public static void main(String[] args) {
        operaciones2();
    }

    public static void operaciones(){
        int num1=5,num2=0;
        int resultado= num1/num2;
    }


    public static void operaciones2(){
        try {
            operaciones();
        }catch (ArithmeticException e){
            System.out.println("No se puede dividir entre cero");
        }
    }

}
