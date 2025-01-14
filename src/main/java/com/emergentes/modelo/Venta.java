package com.emergentes.modelo;

public class Venta {

    private int id;
    private int producto_id;
    private int cliente_id;
    private String fecha;

    private String cliente;
    private String producto;

    public Venta() {
    }

    @Override
    public String toString() {
        return "Venta{" + "id=" + id + ", producto_id=" + producto_id + ", cliente_id=" + cliente_id + ", fecha=" + fecha + ", cliente=" + cliente + ", producto=" + producto + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(int producto_id) {
        this.producto_id = producto_id;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

}
