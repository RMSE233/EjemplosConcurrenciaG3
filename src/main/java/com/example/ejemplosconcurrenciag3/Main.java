package com.example.ejemplosconcurrenciag3;

import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        //Objeto compartido por todos los threads
        Caja caja = new Caja();

        //Runnable representa la tarea qie ejecutará cada uno de los vendedores
        Runnable vendedor1 = () -> procesarVenta("Vendedor 1", caja);
        Runnable vendedor2 = () -> procesarVenta("Vendedor 2", caja);
        Runnable vendedor3 = () -> procesarVenta("Vendedor 3", caja);

        //Crear los Threads (hilos)
        Thread hilo1 = new Thread(vendedor1);
        Thread hilo2 = new Thread(vendedor2);
        Thread hilo3 = new Thread(vendedor3);

        System.out.println("---- Inicio del proceso de ventas ----");

        /**
         * start() en el encargo de iniciar el proveso del hilo
         * Los tres vendedores comienzan a procesar sus ventas concurrentemente
         */
        hilo1.start();
        hilo2.start();
        hilo3.start();

        /**
         * join() permite que el hilo main espere al proceso
         * hasta que terminen los otros Threads
         */
        hilo1.join();
        hilo2.join();
        hilo3.join();

        System.out.println("---- Termina del proceso de ventas ----");
        System.out.println("Cantidad de ventas: " + caja.getCantidadVentas());
        System.out.println("Total recaudado: C$" + caja.getTotalRecaudado());

    }

    /**
     *
     * @param vendedor
     * @param caja
     */

    private static void procesarVenta(String vendedor, Caja caja) {
        // simulando un total de cinco ventas
        for(int i= 1; i <= 200; i++){
            try {
                Thread.sleep(1000);
                caja.registrarVentas(vendedor, 100);
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
                System.out.println(vendedor + "fue interrumpido");
                return;
            }
        }
    }
}
