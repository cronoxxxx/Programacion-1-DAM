package org.example.common;

import java.util.List;

public class Comprobacion {

    public static void habilidadesOK (List<String >habilidades) throws AddHabilidadesException {
        Habilidades [] h = Habilidades.values();
        boolean valid = false;

        for (int i = 0; i < h.length ; i++) {
            for (int j = 0; j < habilidades.size() && !valid ; j++) {
                if (String.valueOf(h[i]).equalsIgnoreCase(habilidades.get(j))){
                    valid=true;
                }
            }
        }

        if (!valid){
            throw new AddHabilidadesException("No se puede añadir habilidades no encontradas en la lista");
        }
    }
}
