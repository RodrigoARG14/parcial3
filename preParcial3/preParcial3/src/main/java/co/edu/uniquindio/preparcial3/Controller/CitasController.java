package co.edu.uniquindio.preparcial3.Controller;

import co.edu.uniquindio.preparcial3.Model.Paciente;
import co.edu.uniquindio.preparcial3.Model.Doctor;
import co.edu.uniquindio.preparcial3.Model.Cita;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CitasController {

    @FXML
    private Button btnGuardar;

    @FXML
    private ComboBox<Paciente> cBCliente;

    @FXML
    private ComboBox<Doctor> cBProducto;

    @FXML
    private TableColumn<Cita, Integer> colCantidad;

    @FXML
    private TableColumn<Cita, Paciente> colCliente;

    @FXML
    private TableColumn<Cita, Date> colFecha;

    @FXML
    private TableColumn<Cita, Doctor> colProducto;

    @FXML
    private TableView<Cita> tableVenta;

    @FXML
    private TextField txtCantidad;

    @FXML
    private TextField txtFecha;

    private ObservableList<Cita> listaVentas = FXCollections.observableArrayList();

    @FXML
    private void initialize() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        txtFecha.setText(sdf.format(new Date()));
        txtFecha.setEditable(false);

        cBCliente.setItems(PacientesController.listaCliente);
        cBProducto.setItems(DoctoresController.listaProductos);

        colFecha.setCellValueFactory(cellData ->
                new SimpleObjectProperty<>(cellData.getValue().getFecha()));

        colCliente.setCellValueFactory(cellData ->
                new SimpleObjectProperty<>(cellData.getValue().getCliente()));

        colProducto.setCellValueFactory(cellData ->
                new SimpleObjectProperty<>(cellData.getValue().getProducto()));


        colCantidad.setCellValueFactory(cellData ->
                new SimpleObjectProperty<>(cellData.getValue().getCantidad()));

        tableVenta.setItems(listaVentas);
    }

    @FXML
    private void guardar() {
        String fechaTexto = txtFecha.getText();
        Paciente cliente = cBCliente.getValue();
        Doctor producto = cBProducto.getValue();
        int cantidad = 0;

        if (!fechaTexto.isEmpty() && cliente != null && producto != null && !txtCantidad.getText().isEmpty()) {
            try {
                cantidad = Integer.parseInt(txtCantidad.getText());
            } catch (NumberFormatException e) {
                mostrarAlerta("Error", "La cantidad debe ser un número válido", Alert.AlertType.ERROR);
                return;
            }
            if (cantidad <= 0) {
                mostrarAlerta("Error", "La cantidad debe ser mayor que 0", Alert.AlertType.ERROR);
                return;
            }

            Date fecha = parseFecha(txtFecha.getText());
            Cita venta = new Cita(fecha, cliente, producto, cantidad);
            listaVentas.add(venta);

            txtCantidad.clear();
            cBCliente.getSelectionModel().clearSelection();
            cBProducto.getSelectionModel().clearSelection();

            mostrarAlerta("Éxito", "cita guardada correctamente", Alert.AlertType.INFORMATION);
        } else {
            mostrarAlerta("Error", "Todos los campos deben ser completados correctamente", Alert.AlertType.ERROR);
        }
    }

    private Date parseFecha(String fechaTexto) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return sdf.parse(fechaTexto);
        } catch (ParseException e) {
            mostrarAlerta("Error", "La fecha no tiene el formato correcto. Use yyyy-MM-dd", Alert.AlertType.ERROR);
            return null;
        }
    }

    private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

}
