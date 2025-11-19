package co.edu.uniquindio.preparcial3.Controller;

import co.edu.uniquindio.preparcial3.Model.Doctor;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class DoctoresController {

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnGuardar;

    @FXML
    private TableColumn<Doctor, String> colDescripcion;

    @FXML
    private TableColumn<Doctor, String> colId;

    @FXML
    private TableColumn<Doctor, String> colPrecio;

    @FXML
    private TableView<Doctor> tableProductos;

    @FXML
    private TextField txtDescripcion;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtPrecio;

    public static ObservableList<Doctor> listaProductos = FXCollections.observableArrayList();

    @FXML
    private void initialize() throws IOException {

        colDescripcion.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getNombre()));

        colId.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getDocumento()));

        colPrecio.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getTelefono()));

        tableProductos.setItems(listaProductos);
    }

    @FXML
    void guardar(ActionEvent event) {

        String nombre = txtDescripcion.getText();
        String documento = txtId.getText();
        String telefono = txtPrecio.getText();

        if (!nombre.isEmpty() && !documento.isEmpty() && !telefono.isEmpty()) {

            Doctor doctor = new Doctor(nombre, documento, telefono, "", "");
            listaProductos.add(doctor);

            txtDescripcion.clear();
            txtId.clear();
            txtPrecio.clear();

            mostrarAlerta("Éxito", "Doctor guardado correctamente", Alert.AlertType.INFORMATION);

        } else {
            mostrarAlerta("Error", "Debes llenar todos los campos", Alert.AlertType.ERROR);
        }
    }

    @FXML
    void actualizar(ActionEvent event) {
        Doctor seleccionado = tableProductos.getSelectionModel().getSelectedItem();

        if (seleccionado != null) {
            seleccionado.setNombre(txtDescripcion.getText());
            seleccionado.setDocumento(txtId.getText());
            seleccionado.setTelefono(txtPrecio.getText());

            tableProductos.refresh();
            mostrarAlerta("Éxito", "Doctor actualizado correctamente", Alert.AlertType.INFORMATION);

        } else {
            mostrarAlerta("Error", "No se ha seleccionado ningún doctor", Alert.AlertType.ERROR);
        }
    }

    @FXML
    void eliminar(ActionEvent event) {

        Doctor seleccionado = tableProductos.getSelectionModel().getSelectedItem();

        if (seleccionado != null) {
            listaProductos.remove(seleccionado);
            mostrarAlerta("Éxito", "Doctor eliminado", Alert.AlertType.INFORMATION);
        } else {
            mostrarAlerta("Error", "Selecciona un doctor para eliminar", Alert.AlertType.ERROR);
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