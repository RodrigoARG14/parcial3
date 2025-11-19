package co.edu.uniquindio.preparcial3;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javafx.stage.Stage;

public class Menu extends Application {

    @Override
    public void start (Stage stage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/preparcial3/Dashboard.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 880, 797);

        stage.setTitle("Dashboard principal");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}
