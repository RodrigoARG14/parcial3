package co.edu.uniquindio.preparcial3.Model;

public class Paciente extends Persona {

    private String tipoSangre;

    public Paciente(String nombre, String documento, String telefono, String correo) {
        super(nombre, documento, telefono, correo);

    }

    @Override
    public String toString() {
        return getNombre() + " - Tipo de sangre: " + tipoSangre;
    }
}
