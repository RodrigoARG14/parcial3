package co.edu.uniquindio.preparcial3.Model;

import java.util.Date;

public class Cita {
    private Date fecha;
    private Paciente cliente;
    private Doctor producto;
    private int cantidad;

    public Cita(Date fecha, Paciente cliente, Doctor producto, int cantidad) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Paciente getCliente() {
        return cliente;
    }

    public void setCliente(Paciente cliente) {
        this.cliente = cliente;
    }

    public Doctor getProducto() {
        return producto;
    }

    public void setProducto(Doctor producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return fecha + " " + cliente + " " + producto + " " + cantidad + " ";
    }
}