package EJERCICIOS.CLASESYOBJETOS.Inicial.E1;
/*
* Crear una clase Triangulo que representa un triángulo equilátero, con los atributos enteros base y
altura. Crear métodos para dar valor y poder consultar los atributos, un método constructor, y otros
métodos para calcular el perímetro y el área del triángulo.*/
public class Triangulo {
    private int base,altura;

    public Triangulo(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }
    public Triangulo (int base){
        this.base=base;
        this.altura=0;
    }

    public int getBase() {
        return base;
    }

    public int getAltura() {
        return altura;
    }
    public int getPerimetro(int lado1, int lado2){
        return base+lado2+lado1;
    }
    public int getArea(){
        return (base*altura)/2;
    }

}
