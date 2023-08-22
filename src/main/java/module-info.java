module ec.edu.espol.proyectoprueba {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens ec.edu.espol.proyectoprueba to javafx.fxml;
    exports ec.edu.espol.proyectoprueba;
}
