package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
public class Funcion {

    private List<Teatro> teatros; // <1>
    private double beneficio;

    public Funcion() {
        this.teatros = new ArrayList<>();
        this.beneficio = 0;
        for (int i = 0; i < 15; i++) {
            teatros.add(new Teatro());
        }
    }

    public boolean cambiarNombreTeatro(Teatro teatro, String nombre) {
        if (teatro == null) {
            return false;
        }
        teatro.setNombre(nombre);
        return true;
    }

    public boolean cambiarPrecioNombreSesion(Sesion sesion, double precio, String nombre) {
        if (sesion == null) {
            return false;
        }
        sesion.setPrecio(precio);
        sesion.setNombre(nombre);
        return true;
    }

    public List<Sesion> consultarSesiones(Teatro teatro) {
        return teatro.getSesiones();
    }

    public Teatro devolverTeatro(String nombre, String direccion) {
        return teatros.stream().filter(teatro -> teatro.getNombre().equalsIgnoreCase(nombre) && teatro.getDireccion().equalsIgnoreCase(direccion)).findFirst().orElse(null);
    }


    /*public boolean venderButaca (Teatro teatro, List sesiones, int butaca) {
    List<Sesion> sesionObtenida = new ArrayList<>();
boolean valido = false;
if (butaca<=0 || butaca>teatro.getButacas().length){
    valido = false;
}

for (int i = 0; i < teatro.getSesiones().size(); i++) {
    if (sesiones.get(i).getNombre().equals(teatro.getSesiones().get(i).getNombre())) {
        sesionObtenida.add(teatro.getSesiones().get(i));
        valido = true;
    }
}
for (int i = 0; i < teatro.getButacas().length; i++) {
    for (int j = 0; j < teatro.getButacas()[i].length ; j++) {
        if (teatro.getButacas()[i][j]==0 && butaca - 1==teatro.getButacas()[i][j]) {
            teatro.getButacas()[i][j] = 1;
            valido = true;
        }
    }
}

if (valido){
    for (Sesion sesion : sesionObtenida) {
        beneficio += sesion.getPrecio();
    }
}

return valido;
}
*/

    public boolean venderButaca(Teatro teatro, List<Sesion> sesiones, int butaca) {
        List<Sesion> sesionObtenida = sesiones.stream()
                .filter(sesion -> teatro.getSesiones().stream().anyMatch(sesionTeatro -> sesionTeatro.getNombre().equals(sesion.getNombre()))).toList();

        boolean valido = butaca > 0 && butaca <= teatro.getButacas().length &&
                Arrays.stream(teatro.getButacas()).anyMatch(butacaFila -> butacaFila.length > butaca - 1 && butacaFila[butaca - 1] == 0);

        if (valido) {
            sesionObtenida.forEach(sesion -> beneficio += sesion.getPrecio());
            Arrays.stream(teatro.getButacas()).filter(butacaFila -> butacaFila.length > butaca - 1 && butacaFila[butaca - 1] == 0)
                    .forEach(butacaFila -> butacaFila[butaca - 1] = 1);
        }

        return valido;
    }


}
