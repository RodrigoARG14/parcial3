package co.edu.uniquindio.preparcial3.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import java.io.IOException;

public class DashboardController {

    @FXML
    private AnchorPane layout;
    @FXML
    private Button btnClientes;
    @FXML
    private Button btnProductos;
    @FXML
    private Button btnVentas;

    @FXML
    void irAClientes(ActionEvent event) {
        cargarVista("/co/edu/uniquindio/preparcial3/Pacientes.fxml");
    }

    @FXML
    void irAProductos(ActionEvent event) {
        cargarVista("/co/edu/uniquindio/preparcial3/Doctores.fxml");
    }

    @FXML
    void irAVentas(ActionEvent event) {
        cargarVista("/co/edu/uniquindio/preparcial3/Citas.fxml");
    }


    private void cargarVista(String fxmlPath) {
        try {
            AnchorPane nuevaVista = FXMLLoader.load(getClass().getResource(fxmlPath));
            layout.getChildren().setAll(nuevaVista);
        } catch (IOException e) {
            mostrarAlerta("Error", "No se pudo cargar la vista", Alert.AlertType.ERROR);
            e.printStackTrace();
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
