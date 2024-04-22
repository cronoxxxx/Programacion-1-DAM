package org.example.previas.E1.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import lombok.*;
@Data
public class Factura {
    final Cliente cliente;
    LocalDateTime fechaHora = LocalDateTime.now();
    final List<Fruta> frutasVendidas;
    final double precioCompra;
    @Override
    public String toString() {
        return String.format("Cliente %s\nFecha de la venta\n %s\nFrutas vendidas: %s\n",cliente,fechaHora.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),frutasVendidas);
    }
}

