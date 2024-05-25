package org.example.dao;

import lombok.Getter;
import lombok.Setter;
import org.example.domain.Cliente;
import org.example.domain.ClienteFisico;
import org.example.domain.ClienteOnline;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
@Getter@Setter
public class Database implements Serializable
{
    private static int iterador = 0;
    private  double beneficios = 0;
    private final Map<Integer, Cliente> clientesEsperaCompra;
    public Database() {
        clientesEsperaCompra = new HashMap<>();
        for (int i = 0; i < 20; i++) {
            int randoMizer = (int) (Math.random() * 2);
            if (randoMizer == 1) {
                clientesEsperaCompra.put(iterador++, new ClienteFisico());
            } else {
                clientesEsperaCompra.put(iterador++, new ClienteOnline());
            }
        }
    }

}
