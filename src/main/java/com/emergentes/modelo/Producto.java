
package com.emergentes.modelo;
public class Producto {
    private int id;
    private String nombre;
    private String descripcion;
    private float precio;

     public Producto() {
         id=0;
         nombre="";
         descripcion="";
         precio=0;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

   
}
