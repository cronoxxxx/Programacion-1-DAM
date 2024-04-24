package org.example.previas.E1.dao;

import org.example.previas.E1.common.precioVentaExcepcion;
import org.example.previas.E1.domain.Database;
import org.example.previas.E1.domain.Fruta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
@ExtendWith(MockitoExtension.class)
class DaoFruteriaImplementacionTest {

    @InjectMocks
    DaoFruteriaImplementacion daoFruteriaImplementacion;

    @Mock
    Database database;

    @Test
    void getListaAlojamientos() throws precioVentaExcepcion {

        //given
        List<Fruta> lista = new ArrayList<>();
        lista.add(new Fruta(Math.random() * 30, (Math.random() * 30) + 31));
        lista.add(new Fruta(Math.random() * 30, (Math.random() * 30) + 31));

        //when
        when(database.getListafrutas()).thenReturn(lista);

        List<Fruta> result = daoFruteriaImplementacion.getFrutas();

        //then;
        assertAll(
                () -> assertThat(result).isEqualTo(lista),
                () -> assertThat(result).isNotNull()
        );
    }
}