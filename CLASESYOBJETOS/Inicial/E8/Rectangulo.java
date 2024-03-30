package EJERCICIOS.CLASESYOBJETOS.Inicial.E8;

import java.util.StringJoiner;

/**
* Crear una clase llamada Rectángulo con atributos privados base, altura, x e y (estos últimos indican su
posición).
Implementa los siguientes constructores, teniendo en cuenta que cuando se omitan los valores
se asignarán por defecto los siguientes: base=1, altura=1, x=0, y=0.
• Rectangulo(float base, float altura, float x, float y)
• Rectangulo(float base, float altura)
• Rectangulo(float base)
• Rectangulo( )
Implementa los métodos públicos getters y setters.
Implementa los siguientes métodos:
• float getArea( )
• float getPerimetro( )
Implementa los siguientes métodos (cuidado, están sobrecargados, tienen todos el mismo nombre):
• void agranda(float aumentaBase, float aumentaAltura) Aumenta la base y la altura del
rectángulo con los valores indicados.
• void agranda(float valor) Aumenta tanto la base como la altura con el valor indicado.
• void agranda( ) Aumenta la base y la altura en una unidad.
Crea una clase aparte con el método main para probar todas las funcionalidades de la clase
Rectángulo.
MEJORA 1: Hacer un constructor-copia (que valga para crear un Rectángulo recibiendo como
parámetro otro Rectángulo) y un método Rectángulo copiar(), que devuelve un duplicado del
Rectángulo actual. Ambas son duplicados, no copias, esto es, las copias han de ser "profundas" (deep
copy)
*
* */
public class Rectangulo {
    private double base,altura,x,y;

    public Rectangulo(Rectangulo rectanguloOriginal) {
        this.base = rectanguloOriginal.base;
        this.altura = rectanguloOriginal.altura;
        this.x = rectanguloOriginal.x;
        this.y = rectanguloOriginal.y;
    }
    public Rectangulo() {
        this.base = 1;
        this.altura = 1;
        this.x = 0;
        this.y = 0;
    }

    public Rectangulo(double base, double altura, double x, double y) {
        this.base = base;
        this.altura = altura;
        this.x = x;
        this.y = y;
    }

    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
        this.x = 0;
        this.y = 0;
    }

    public Rectangulo(double base) {
        this.base = base;
        this.altura = 1;
        this.x = 0;
        this.y = 0;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public boolean agranda(double aumentaBase, double aumentaAltura){
        if (base + aumentaBase > 0 && altura + aumentaAltura > 0){
            base+= aumentaBase;
            altura+=aumentaAltura;
            return true;
        }
        return false;
    }
    public boolean agranda(double valor){//Aumenta tanto la base como la altura con el valor indicado
        if (base + valor > 0 && altura + valor > 0){
            base+=valor;
            altura+=valor;
            return true;
        }
        return false;
    }

    public boolean agranda(){ //mathrandom
        int valorRandom = (int) (Math.random() * 1000) + 1;
        if (base + valorRandom > 0 && altura + valorRandom > 0){
            base+=valorRandom;
            altura+=valorRandom;
            return true;
        }
        return false;
    }

    public Rectangulo devolver() {
         // Crear una nueva instancia con los mismos valores
        return new Rectangulo(this);
    }

    @Override
    public String toString() {
        return String.format("Base: %.2f\nAltura: %.2f\nPosicion x: %.2f\nPosicion y: %.2f",base,altura,x,y);
    }
}
