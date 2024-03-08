public class Coche extends Vehiculo {
    private double capacidad; //del maletero expresada en litros
    private boolean isAcabado;

    public Coche(double precio, int identificador, String tipoVehiculo, int anyoFabricacion, Direccion direccionVehiculo, double capacidad, boolean isAcabado) {
        super(precio, identificador, tipoVehiculo, anyoFabricacion, direccionVehiculo);
        this.capacidad = capacidad;
        this.isAcabado = isAcabado;
    }

    public double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(double capacidad) {
        this.capacidad = capacidad;
    }

    public boolean isAcabado() {
        return isAcabado;
    }

    public void setAcabado(boolean acabado) {
        isAcabado = acabado;
    }
@Override
    public double getPrecioAlquiler(boolean isFestivo){
        double auxPrecioBase = precio;
        if (isAcabado){
            return auxPrecioBase+ (auxPrecioBase*0.2);
        } else if (isFestivo){
            return auxPrecioBase+ (auxPrecioBase*0.3);
        }
        return auxPrecioBase;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "capacidad=" + capacidad +
                ", isAcabado=" + isAcabado +
                ", precio=" + precio +
                ", identificador=" + identificador +
                ", tipoVehiculo='" + tipoVehiculo + '\'' +
                ", anyoFabricacion=" + anyoFabricacion +
                ", direccionVehiculo=" + direccionVehiculo +
                '}';
    }
}
