package EJERCICIOS.CLASESYOBJETOS.Inicial.E5;

public class Coche {
    private String marca,color,matricula;
    private Persona dniTitular;
    private int km,anio;
    private double precio,factorContaminacion,impuestoMatriculacion,impuestaContaminacion;

    public Coche(String color, String matricula, Persona dniTitular, int km, double precio, double impuestoMatriculacion) {
        this.marca = "Toyota";
        this.color = "Blanco";
        this.matricula = matricula;
        this.dniTitular = dniTitular;
        this.km = 0;
        this.anio = 2005;
        this.precio = 0;
        this.factorContaminacion = 0;
        this.impuestoMatriculacion = impuestoMatriculacion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Persona getDniTitular() {
        return dniTitular;
    }

    public void setDniTitular(Persona dniTitular) {
        this.dniTitular = dniTitular;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getImpuestoMatriculacion() {
        return impuestoMatriculacion;
    }

    public void setImpuestoMatriculacion(double impuestoMatriculacion) {
        this.impuestoMatriculacion = impuestoMatriculacion;
    }


    public void incrementarKilometraje(int incremento){
        int aux= km+incremento;
        if (incremento>0){
            km=aux;
        } else {
            System.err.println("No se agrega valores menor a 0");
        }
    }
    public double calcularImpuestoContaminacion (){
        if (impuestaContaminacion<5){
            return impuestaContaminacion=precio*2/100;
        } else if (impuestaContaminacion>5 && impuestaContaminacion<10){
            return impuestaContaminacion=precio*5/100;
        } else if (impuestaContaminacion>10){
            return impuestaContaminacion=precio*10/100;
        } else {
            return impuestoMatriculacion;
        }

    }
    public void hacerTransferencia (Coche nuevo){
        if (!dniTitular.equals(nuevo.getDniTitular())){
            System.out.println("Nuevo titular");
            dniTitular=nuevo.getDniTitular();
        } else {
            System.out.println("Mismos datos, no se puede hacer la transferencia");
        }
    }
}
