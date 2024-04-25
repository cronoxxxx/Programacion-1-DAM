package org.example.domain;

import lombok.*;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Data
public class Factura implements Serializable {
    final Cliente cliente;
    LocalDateTime fechaHora = LocalDateTime.now();
    final List<Fruta> frutasVendidas;
    final double precioCompra;
    final List<Double>almacenVenta;

    @Override
    public String toString() {
        StringBuilder nombres = new StringBuilder();
        nombres.append("-------------------------------------------------------\n");
        String var = String.format("Cliente %sFecha de la venta %s\n", cliente, fechaHora.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        nombres.append(var);
        nombres.append("Frutas compradas\n---------\n");
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        for (int i = 0; i<frutasVendidas.size(); i++) {
            nombres.append(i + 1).append(". ").append(frutasVendidas.get(i).getNombre()).append("\t->\t").append(decimalFormat.format(almacenVenta.get(i))).append("$\n");
        }
        nombres.append("-------------------------------------------------------\n");
        return String.valueOf(nombres);
    }
}

