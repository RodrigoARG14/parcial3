package co.edu.uniquindio.preparcial3.Controller;

import co.edu.uniquindio.preparcial3.Model.Paciente;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;


public class PacientesController {

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnGuardar;

    @FXML
    private TableColumn<Paciente, String> colCorreo;

    @FXML
    private TableColumn<Paciente, String> colDocumento;

    @FXML
    private TableColumn<Paciente, String> colNombre;

    @FXML
    private TableColumn<Paciente, String> colTelefono;

    @FXML
    private TableView<Paciente> tableCliente;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtDocumento;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtTelefono;

    private ObservableList<Paciente> listaClientes = FXCollections.observableArrayList();


    public ObservableList<Paciente> getListaClientes() {
        return listaClientes;
    }
    @FXML
    private void initialize() throws IOException {
        colNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        colDocumento.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDocumento()));
        colTelefono.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefono()));
        colCorreo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCorreo()));
        tableCliente.setItems(listaCliente);


    }


    public static ObservableList<Paciente> listaCliente = FXCollections.observableArrayList();


    @FXML
    private void guardar() {
        String nombre = txtNombre.getText();
        String documento = txtDocumento.getText();
        String telefono  = txtTelefono.getText();
        String correo = txtCorreo.getText();

        if (!nombre.isEmpty() && !documento.isEmpty() && !telefono.isEmpty() && !correo.isEmpty()) {
            Paciente cliente = new Paciente(nombre, documento, telefono, correo);
            listaCliente.add(cliente);

            txtNombre.clear();
            txtDocumento.clear();
            txtTelefono.clear();
            txtCorreo.clear();
            mostrarAlerta("Exito", "paciente guardado corrrectamente", Alert.AlertType.INFORMATION);
        }

        else{
            mostrarAlerta("Error", "No se pudo guardar el paciente", Alert.AlertType.ERROR);
        }
    }


    @FXML
    void actualizar(ActionEvent event) {

        Paciente seleccionado = tableCliente.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            seleccionado.setCorreo(txtCorreo.getText());
            seleccionado.setDocumento(txtDocumento.getText());
            seleccionado.setNombre(txtNombre.getText());
            seleccionado.setTelefono(txtTelefono.getText());
            tableCliente.refresh();

            mostrarAlerta("Éxito", "Paciente actualizado correctamente", Alert.AlertType.INFORMATION);
        } else {
            mostrarAlerta("Error", "No se ha seleccionado ningún Paciente para actualizar", Alert.AlertType.ERROR);
        }
    }

    @FXML
    void eliminar(ActionEvent event) {

        Paciente seleccionado = tableCliente.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            listaCliente.remove(seleccionado);
            System.out.println("Paciente eliminado: " + seleccionado);
        } else {
            System.out.println("No se ha seleccionado ningún paciente para eliminar.");
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
