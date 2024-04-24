package org.example.previas.E1.dao;



import org.example.previas.E1.domain.Cliente;
import org.example.previas.E1.domain.ClienteFisico;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

class DaoMostradorImplementacionTest {
    //private static final Logger logger = LogManager.getLogger(DaoFruteriaImplementacionTest.class);
    @InjectMocks
    private DaoMostradorImplementacion daoMostradorImplementacion;
    @Mock
    private Mostrador mostrador;
    @BeforeEach
    void setUp() {
        daoMostradorImplementacion = new DaoMostradorImplementacion();
    }

    @Test
    void getFacturas() {
    }

    @Test
    void isEmpty() {
        // Given
        when(mostrador.isEmptyClientes()).thenReturn(true);
        // When
        boolean result = mostrador.isEmptyClientes();
        // Then
        assertTrue(result);

    }



    @Test
    void mostrarInformacion() {
    }

    @Test
    void mostrarInformacionporNombre() {
    }

    @Test
    void venderClienteFisico() {
    }

    @Test
    void getBeneficios() {
    }

    @Test
    void venderClienteOnline() {
    }

    @Test
    void buscarClienteporID() {
    }

    @Test
    void buscarClienteNombreApellido() {
    }

    @Test
    void removeClienteporID() {
    }

    @Test
    void removeClienteporNombreApellidos() {
    }

    @Test
    void aplicarDescuentosClienteporID() {
    }

    @Test
    void aplicarDescuentosporClienteNombreApellidos() {
    }
}