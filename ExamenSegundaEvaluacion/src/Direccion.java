public class Direccion {
    private String calle, provincia;

    public Direccion(String calle, String provincia) {
        this.calle = calle;
        this.provincia = provincia;
    }

    public Direccion(String provincia) {
        this.provincia = provincia;
        this.calle="XYZ";
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return "Direccion{" +
                "calle='" + calle + '\'' +
                ", provincia='" + provincia + '\'' +
                '}';
    }
}
