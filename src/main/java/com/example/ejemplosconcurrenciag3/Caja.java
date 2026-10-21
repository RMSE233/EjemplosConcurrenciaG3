package com.example.ejemplosconcurrenciag3;

public class Caja {

    private int cantidadVentas = 0;
    private int totalRecaudado = 0;

    // synchronized evita condiciones de carrera entre hilos
    public synchronized void registrarVentas(String vendedor, int monto) {
        cantidadVentas++;
        totalRecaudado += monto;

        System.out.println(vendedor + " registró una venta de C$" + monto +
                " | Ventas acumuladas: " + cantidadVentas +
                " | Total: C$" + totalRecaudado);
    }

    public synchronized int getCantidadVentas() {
        return cantidadVentas;
    }

    public synchronized int getTotalRecaudado() {
        return totalRecaudado;
    }
}