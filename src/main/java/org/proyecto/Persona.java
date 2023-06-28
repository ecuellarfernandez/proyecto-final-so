package org.proyecto;

public class Persona implements Runnable {
    private String nombre;
    private boolean sincronizado;
    private Tienda tienda;

    public Persona(String nombre, boolean sincronizado, Tienda tienda) {
        this.nombre = nombre;
        this.sincronizado = sincronizado;
        this.tienda = tienda;
    }

    @Override
    public void run() {
        if (sincronizado) {
            tienda.comprarLecheSincronizado(nombre);
        } else {
            tienda.comprarLeche(nombre);
        }
    }
}