public class Autobus extends Vehiculo {
    private int numeroPasajeros;
    private boolean isAccesoMinusvalidos;

    public Autobus(double precio, int identificador, String tipoVehiculo, int anyoFabricacion, Direccion direccionVehiculo, int numeroPasajeros, boolean isAccesoMinusvalidos) {
        super(precio, identificador, tipoVehiculo, anyoFabricacion, direccionVehiculo);
        this.numeroPasajeros = numeroPasajeros;
        this.isAccesoMinusvalidos = isAccesoMinusvalidos;
    }

    public int getNumeroPasajeros() {
        return numeroPasajeros;
    }

    public void setNumeroPasajeros(int numeroPasajeros) {
        this.numeroPasajeros = numeroPasajeros;
    }

    public boolean isAccesoMinusvalidos() {
        return isAccesoMinusvalidos;
    }

    public void setAccesoMinusvalidos(boolean accesoMinusvalidos) {
        isAccesoMinusvalidos = accesoMinusvalidos;
    }


@Override
    public double getPrecioAlquiler(boolean isFestivo){
        double auxPrecioBase = precio;
        if (isFestivo){
            return auxPrecioBase+ (auxPrecioBase*0.3);
        }
        return auxPrecioBase + (numeroPasajeros*0.001); //por pasajero
    }

    @Override
    public String toString() {
        return "Autobus{" +
                "numeroPasajeros=" + numeroPasajeros +
                ", isAccesoMinusvalidos=" + isAccesoMinusvalidos +
                ", precio=" + precio +

                ", identificador=" + identificador +
                ", tipoVehiculo='" + tipoVehiculo + '\'' +
                ", anyoFabricacion=" + anyoFabricacion +
                ", direccionVehiculo=" + direccionVehiculo +
                '}';
    }
}
