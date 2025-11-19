package co.edu.uniquindio.preparcial3.Model;

public class Doctor extends Persona {

    private String especialidad;

    public Doctor(String nombre, String documento, String telefono, String correo, String especialidad) {
        super(nombre, documento, telefono, correo);
    }

    @Override
    public String toString() {
        return "Dr. " + getNombre() + " - Especialidad: " + especialidad;
    }

    public Double getPrecio() {
        return 0.0;
    }
}