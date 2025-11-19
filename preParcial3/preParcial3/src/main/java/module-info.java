module co.edu.uniquindio.preparcial3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.datatransfer;
    requires javafx.base;

    exports co.edu.uniquindio.preparcial3;
    exports co.edu.uniquindio.preparcial3.Controller;

    opens co.edu.uniquindio.preparcial3 to javafx.fxml;
    opens co.edu.uniquindio.preparcial3.Controller to javafx.fxml;
}