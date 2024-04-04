package EJERCICIOS.CLASESYOBJETOS.Inicial.E16;

/*Vamos a realizar una clase llamada Ecuacion2grado, donde representaremos los valores de una
ecuación de 2º grado (Formula ecuación 2º grado: -b±√((b^2)-(4*a*c)))/(2*a) (en cursiva lo que hay dentro
de la raíz)
La clase por tanto tendrá 3 atributos, que serán los 3 coeficientes de la ecuación, llamémosles a, b y c.
Los valores de los atributos se asignan únicamente con el constructor.
Las operaciones que se podrán hacer son las siguientes:
• getDiscriminante(): devuelve el valor del discriminante (double), el discriminante es la parte que está
dentro de la raiz, y tiene la siguiente formula, (b^2)-4*a*c
• cuantasSoluciones(): devuelve un int indicando cuantas soluciones tiene la ecuación (0, 1 o 2). Para que
una solución sea válida, el discriminante debe ser mayor o igual que 0.
• calcular(): mostrara por consola las posibles soluciones que tiene nuestra ecuación, en caso de no
existir solución, mostrarlo también.
Crear una clase con un main y probar todos los métodos con varios ejemplos que den juego a todas las
posibilidades*/
public class EcuacionCuadrada {
    private double a, b, c;

    public EcuacionCuadrada(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getDiscriminante() {
        return Math.sqrt(Math.pow(b, 2) - (4 * a * c));
    }

    public int cuantasSoluciones() {
        double discriminante = Math.sqrt(Math.pow(b, 2) - (4 * a * c));
        double ecuacionPositiva = (-b + discriminante) / (2 * a);
        double ecuacionNegativa = (-b - discriminante) / (2 * a);
        if (discriminante >= 0) {
            if (!(Double.isNaN(ecuacionPositiva) && Double.isNaN(ecuacionNegativa))) {
                return 2;
            } else if (!(Double.isNaN(ecuacionPositiva)) && Double.isNaN(ecuacionNegativa)) {
                return 1;
            }else if (!(Double.isNaN(ecuacionNegativa)) && Double.isNaN(ecuacionPositiva)){
                return 1;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public void mostrarSoluciones() {
        double discriminante = Math.sqrt(Math.pow(b, 2) - (4 * a * c));
        double ecuacionPositiva = (-b + discriminante) / (2 * a);
        double ecuacionNegativa = (-b - discriminante) / (2 * a);
        if (discriminante >= 0) {
            System.out.println("Solucion positiva: " + ecuacionPositiva);
            System.out.println("Solucion negativa: " + ecuacionNegativa);
        } else {
            System.out.println("La ecuacion no tiene una solucion debido a su discriminante");
        }
    }


}
