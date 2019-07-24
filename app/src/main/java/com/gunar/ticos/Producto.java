package com.gunar.ticos;

public class Producto {
    private String nombre;
    private int imagen, pedido;
    private double precio;

    public Producto() {
        this.precio = 0;
    }


    public Producto(String nombre, int imagen, int pedido, double precio) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.pedido = pedido;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getPedido() {
        return pedido;
    }

    public void setPedido(int pedido) {
        this.pedido = pedido;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
