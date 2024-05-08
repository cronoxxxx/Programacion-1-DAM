package org.example.dao;

import org.assertj.core.api.Assertions;
import org.example.common.AgregarProvinciasException;
import org.example.common.FechaInvalidaException;
import org.example.common.precioVentaExcepcion;
import org.example.domain.Fruta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@ExtendWith(MockitoExtension.class)
class DaoFruteriaImplementacionTest {
    @Mock
    private Fruteria fruteria;
    @InjectMocks
    private DaoFruteriaImplementacion daoFruteria;


    @Test
    void getFrutas() throws precioVentaExcepcion {
        List<Fruta> frutas = Arrays.asList(
                new Fruta(2, 3),
                new Fruta(2, 3),
                new Fruta(2, 3)

        );
        when(fruteria.getFrutas()).thenReturn(frutas);
        List<Fruta> frutaList = daoFruteria.getFrutas();

        assertAll(
                () -> assertEquals(frutas, frutaList),
                () -> assertEquals(3, frutaList.size()),
                () -> assertEquals(2, frutaList.get(0).getPrecioCostePorKilo()),
                () -> assertEquals(frutas.get(frutas.size() - 2).getPrecioCostePorKilo(), frutaList.get(frutas.size() - 2).getPrecioCostePorKilo()),
                () -> assertThrowsExactly(UnsupportedOperationException.class, () -> frutaList.add(new Fruta(10, 3)))
        );
    }

    @Test
    void isEmptyFrutas() {
        when(fruteria.isEmptyFrutas()).thenReturn(true);
        assertTrue(daoFruteria.isEmptyFrutas());
        when(fruteria.isEmptyFrutas()).thenReturn(false);
        assertFalse(daoFruteria.isEmptyFrutas());
    }

    @Test
    void mostrarInformacion() throws precioVentaExcepcion {
        List<Fruta> frutas = Arrays.asList(
                new Fruta(2, 3),
                new Fruta(2, 3),
                new Fruta(2, 3)
        );
        when(fruteria.mostrarInformacion(true)).thenReturn(frutas);

        assertAll(
                () -> assertNotEquals(fruteria.mostrarInformacion(true), daoFruteria.mostrarInformacion(false))
        );
    }

    @Test
    void setFrutas() throws precioVentaExcepcion {
        //given
        List<Fruta> lista = new ArrayList<>();
        lista.add(new Fruta(1, 3));
        //when
        daoFruteria.getFruteria().setFrutas(lista);
        //then
        verify(fruteria, times(1)).setFrutas(lista);
    }

    @Test
    void darAltaFruta() throws precioVentaExcepcion, AgregarProvinciasException, FechaInvalidaException {
        //given
        List<Fruta> lista = new ArrayList<>();
        //Fruta fruta = new Fruta(2, 3);
        Fruta fruta = new Fruta("Manzana", "Madrid", 1, 2, 3, LocalDate.of(2025, 1, 1));
        Fruta fruta2 = new Fruta(2, 3);
        Fruta fruta3 = new Fruta(2, 3);
        lista.add(fruta);
        lista.add(fruta2);
        when(fruteria.getFrutas()).thenReturn(lista);
        //When
        daoFruteria.getFrutas().add(fruta3);

        assertAll(
                () -> assertThat(daoFruteria.getFrutas()).contains(fruta3),
                () -> assertThat(daoFruteria.getFrutas().size()).isEqualTo(3),
                () -> assertThat(daoFruteria.getFrutas().get(2)).isEqualTo(fruta3)
        );
    }

    @Test
    void removeFruta() throws precioVentaExcepcion, AgregarProvinciasException, FechaInvalidaException {
        //given
        List<Fruta> lista = new ArrayList<>();
        //Fruta fruta = new Fruta(2, 3);
        Fruta fruta = new Fruta("Manzana", "Madrid", 1, 2, 3, LocalDate.of(2025, 1, 1));
        Fruta fruta2 = new Fruta(2, 3);
        lista.add(fruta);
        lista.add(fruta2);

        when(fruteria.getFrutas()).thenReturn(lista);
        //When
        daoFruteria.getFrutas().remove(fruta);
        assertAll(
                () -> assertThat(daoFruteria.getFrutas()).doesNotContain(fruta),
                () -> assertThat(daoFruteria.getFrutas()).contains(fruta2),
                () -> assertThat(daoFruteria.getFrutas().size()).isEqualTo(1),
                () -> assertThat(daoFruteria.getFrutas().get(0)).isEqualTo(fruta2)
        );
    }

    @Nested
    @DisplayName(" Cantidad de Frutas Vendidas mayor y menor")
    public class hasVendidos {
        @Test
        void testFrutasConMayorNumeroVendido() throws precioVentaExcepcion, AgregarProvinciasException, FechaInvalidaException {
            List<Fruta> lista = new ArrayList<>();
            Fruta fruta1 = new Fruta("Manzana", "Madrid", 1, 2, 3, LocalDate.of(2025, 1, 1));
            Fruta fruta2 = new Fruta(2, 3);
            Fruta fruta3 = new Fruta(3, 4);
            Fruta fruta4 = new Fruta(1, 3);
            Fruta fruta5 = new Fruta(1, 4);
            lista.add(fruta1);
            lista.add(fruta2);
            lista.add(fruta3);
            lista.add(fruta4);
            lista.add(fruta5);
            when(fruteria.frutasConMayorNumeroVendido()).thenReturn(lista);
            //assertEquals(5, fruteria.frutasConMayorNumeroVendido().size());
            assertEquals(5, daoFruteria.frutasConMayorNumeroVendido().size());
        }

        @Test
        void testFrutasConMenorNumeroVendido() throws precioVentaExcepcion, AgregarProvinciasException, FechaInvalidaException {
            List<Fruta> lista = new ArrayList<>();
            Fruta fruta1 = new Fruta("Manzana", "Madrid", 1, 2, 3, LocalDate.of(2025, 1, 1));
            Fruta fruta2 = new Fruta(2, 3);
            Fruta fruta3 = new Fruta(3, 4);
            Fruta fruta4 = new Fruta(1, 3);
            Fruta fruta5 = new Fruta(1, 4);
            lista.add(fruta1);
            lista.add(fruta2);
            lista.add(fruta3);
            lista.add(fruta4);
            lista.add(fruta5);
            when(fruteria.frutasConMenorNumeroVendido()).thenReturn(lista);
            //assertEquals(5, fruteria.frutasConMayorNumeroVendido().size());
            assertEquals(5, daoFruteria.frutasConMenorNumeroVendido().size());
        }
    }

    @Test
    void updateFruta() throws precioVentaExcepcion, AgregarProvinciasException, FechaInvalidaException {
        //given
        List<Fruta> lista = new ArrayList<>();
        Fruta fruta = new Fruta("Manzana", "Madrid", 1, 2, 3, LocalDate.of(2025, 1, 1));
        Fruta fruta2 = new Fruta(2, 3);
        lista.add(fruta);
        lista.add(fruta2);
        when(fruteria.getFrutas()).thenReturn(lista);
        //When
        daoFruteria.getFrutas().get(0).setNombre("Naranja");
        assertAll(
                () -> assertThat(daoFruteria.getFrutas()).contains(fruta),
                () -> assertThat(daoFruteria.getFrutas().size()).isEqualTo(2),
                () -> assertThat(daoFruteria.getFrutas().get(0).getNombre()).isEqualTo("Naranja")
        );
    }

    @Test
    void reunirFrutasProcedencia() throws precioVentaExcepcion, AgregarProvinciasException, FechaInvalidaException {
        //given
        List<Fruta> lista = new ArrayList<>();
        Fruta fruta = new Fruta("Manzana", "Madrid", 1, 2, 3, LocalDate.of(2025, 1, 1));
        Fruta fruta2 = new Fruta("Naranja", "Madrid", 1, 2, 3, LocalDate.of(2025, 1, 1));

        lista.add(fruta);
        lista.add(fruta2);
        when(fruteria.getFrutas()).thenReturn(lista);

        assertAll(
                ()->assertThat(daoFruteria.getFrutas().get(0).getProcedencia()).isEqualTo("Madrid"),
                () -> assertThat(daoFruteria.getFrutas().get(1).getProcedencia()).isEqualTo("Madrid"),
                () -> assertThat(daoFruteria.getFrutas().get(0).getProcedencia()).isEqualTo(daoFruteria.getFrutas().get(1).getProcedencia())
        );
    }







}