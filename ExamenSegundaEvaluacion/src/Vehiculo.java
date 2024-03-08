public class Vehiculo {
    protected double precio;
    protected int identificador;
    protected String tipoVehiculo;
    protected int anyoFabricacion;
    protected Direccion direccionVehiculo;

    public Vehiculo(double precio, int identificador, String tipoVehiculo, int anyoFabricacion, Direccion direccionVehiculo) {
        this.precio = precio;
        this.identificador = identificador;

        this.tipoVehiculo = tipoVehiculo;
        this.anyoFabricacion = anyoFabricacion;
        this.direccionVehiculo = direccionVehiculo;
    }



    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }



    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public int getAnyoFabricacion() {
        return anyoFabricacion;
    }

    public void setAnyoFabricacion(int anyoFabricacion) {
        this.anyoFabricacion = anyoFabricacion;
    }

    public Direccion getDireccionVehiculo() {
        return direccionVehiculo;
    }

    public void setDireccionVehiculo(Direccion direccionVehiculo) {
        this.direccionVehiculo = direccionVehiculo;
    }

    public double getPrecioAlquiler(boolean isFestivo){
        return 0.0;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "precio=" + precio +
                ", identificador=" + identificador +
                ", tipoVehiculo='" + tipoVehiculo + '\'' +
                ", anyoFabricacion=" + anyoFabricacion +
                ", direccionVehiculo=" + direccionVehiculo +
                '}';
    }
}
