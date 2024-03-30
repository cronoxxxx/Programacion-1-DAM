package EJERCICIOS.CLASESYOBJETOS.Inicial.E13;

public class Coche {
    private String matricula,modelo,marca,añoMatriculacion,estado;
    private int categoria;
    private double precio;

    public Coche(String modelo, String marca, String añoMatriculacion, String estado, int categoria) throws EstadoCocheException, CategoriaCocheException {
        estadoOK(estado);
        this.matricula = obtenerMatricula();
        this.modelo = modelo;
        this.marca = marca;
        this.añoMatriculacion = añoMatriculacion;
        this.estado = estado;
        this.categoria = categoria;
        CategoriaOK(categoria);
        this.precio=0;
    }




    public void estadoOK (String estado) throws EstadoCocheException{
        if (!(estado.strip().equalsIgnoreCase("alquilado") || estado.strip().equalsIgnoreCase("no alquilado"))){
            throw new EstadoCocheException();
        }
    }

    public void CategoriaOK (int categoria) throws CategoriaCocheException{
        if (categoria<1 || categoria>2){
            throw new CategoriaCocheException();
        }
    }



    private String obtenerMatricula (){
        String caracteres = "1234567890QWERTYUIOPASDFGHJKLÑZXCVBNM";
        StringBuilder cod = new StringBuilder(6);
        for (int i = 0; i < 6; i++) {
            int index = (int)(Math.random() * caracteres.length()); //Elige letra random de caracteres, saca un caracter
            cod.append(caracteres.charAt(index)); //y lo concatena en la posicion random
        }
        return String.valueOf(cod);


    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getAñoMatriculacion() {
        return añoMatriculacion;
    }

    public void setAñoMatriculacion(String añoMatriculacion) {
        this.añoMatriculacion = añoMatriculacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return String.format ("Modelo: %s\nMarca: %s\sAño que se matriculó: %s\nEstado: %s\n Categoria: %d\nPrecio: %.2f\nMatricula: %s",modelo,marca,añoMatriculacion,estado,categoria,precio,matricula);
    }
}
