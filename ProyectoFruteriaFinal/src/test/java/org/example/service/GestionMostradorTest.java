package org.example.service;

import org.example.common.Provincias;
import org.example.dao.DaoFruteriaImplementacion;
import org.example.dao.DaoMostradorImplementacion;
import org.example.domain.Cliente;
import org.example.domain.ClienteFisico;
import org.example.domain.ClienteOnline;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@ExtendWith(MockitoExtension.class)
class GestionMostradorTest {

    private static final Logger logger = LogManager.getLogger(GestionMostradorTest.class);
    @Mock
    private DaoMostradorImplementacion daoMostradorImplementacion;
    @InjectMocks
    private GestionMostrador gestionMostrador;

    @Test
    void putCliente() {
        Map<Integer, Cliente> map = new HashMap<>();
        ClienteFisico clienteFisico = new ClienteFisico();
        ClienteOnline clienteOnline = new ClienteOnline();
        map.put(1,clienteFisico);
        map.put(2,clienteOnline);
        when(daoMostradorImplementacion.mostrarInformacion(true)).thenReturn(map);
        ClienteOnline clienteOnline1 = new ClienteOnline();
        gestionMostrador.mostrarInformacion(true).put(3,clienteOnline1);
        assertAll(
                () -> assertEquals(3,gestionMostrador.mostrarInformacion(true).size()),
                () -> assertEquals(clienteOnline1,gestionMostrador.mostrarInformacion(true).get(3)),
                ()-> assertEquals(daoMostradorImplementacion.mostrarInformacion(true),gestionMostrador.mostrarInformacion(true))
        );
        logger.info("Se agrego un nuevo cliente");

    }

    @Test
    void isEmptyClientes() {
        when(gestionMostrador.isEmptyClientes()).thenReturn(true);
        assertTrue(daoMostradorImplementacion.isEmptyClientes());
        when(gestionMostrador.isEmptyClientes()).thenReturn(false);
        assertFalse(daoMostradorImplementacion.isEmptyClientes());
    }
    @Test
    void mostrarInformacionPorNombre () {
        Map<Integer, Cliente> map = new HashMap<>();
        ClienteFisico clienteFisico = new ClienteFisico("Xiomara","Saavedra",true);
        ClienteFisico clienteFisico1 = new ClienteFisico("Mirko","Saavedra",true);
        map.put(1,clienteFisico);
        map.put(2,clienteFisico1);
        when(daoMostradorImplementacion.mostrarInformacionporNombre(true)).thenReturn(map);
        assertAll(
                () -> assertEquals(2,gestionMostrador.mostrarInformacionporNombre(true).size()),
                ()->assertEquals(gestionMostrador.mostrarInformacionporNombre(true).get(1),clienteFisico)
        );
    }

    @Test
    void removeClienteporID() {
        Map<Integer, Cliente> map = new HashMap<>();
        ClienteFisico clienteFisico = new ClienteFisico("Xiomara","Saavedra",true);
        ClienteFisico clienteFisico1 = new ClienteFisico("Mirko","Saavedra",true);
        map.put(1,clienteFisico);
        map.put(2,clienteFisico1);
        when(daoMostradorImplementacion.mostrarInformacionporNombre(true)).thenReturn(map);
        gestionMostrador.mostrarInformacionporNombre(true).remove(1);
        assertAll(
                () -> assertEquals(1,gestionMostrador.mostrarInformacionporNombre(true).size()),
                ()->assertEquals(clienteFisico1, gestionMostrador.mostrarInformacionporNombre(true).get(2)
        ));
        logger.info("Se elimino un cliente");
    }
    @Test
    void reunirClientesPorCiudad() {
        Map<Integer, Cliente> map = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            ClienteOnline clienteOnline = new ClienteOnline();
            map.put(i, clienteOnline);
        }
        when(daoMostradorImplementacion.mostrarInformacionporNombre(true)).thenReturn(map);
        Provincias[] aux = Provincias.values();
        String g = null;
        for (int i = 0; i < aux.length; i++) {
            Cliente cliente = gestionMostrador.mostrarInformacionporNombre(true).get((int) (Math.random() * gestionMostrador.mostrarInformacionporNombre(true).size()));
            String ciudadActual = "";
            if (cliente instanceof ClienteOnline) {
                ciudadActual = ((ClienteOnline) cliente).getCiudad();
                if (aux[i].toString().equals(ciudadActual)) {
                    g = aux[i].toString();
                    assertEquals(aux[i].toString(), g);
                }
            }
        }
        String finalG = g;
                assertNotNull(finalG);

        logger.info("Se reunieron los clientes por ciudad");
    }}