package ec.edu.espol.proyectoprueba;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Stage st;

    @Override
    public void start(Stage stage) throws IOException {
        st = stage;        
        scene = new Scene(loadFXML("tienda").load(), 640, 480);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml).load());
    }
    
    public static FXMLLoader loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader;
}

    public static void setScene(Scene sc) throws IOException {
        st.setScene(sc);
    }

    public static void main(String[] args) {
        
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Usuario usuario1 = new Usuario("joad","123","Guerrero","Josue","Espol","edchavez@espol.edu.ec");
        Usuario usuario2 = new Usuario("ricar","456","Maldonado","Ricardo","Espol","ricardo@gmail.com");
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        Usuario.saveListToFileSer("usuarios.ser", usuarios);
        
        
        
      //  (String placa, String marca, String modelo, String tipoMotor, String color, String tipoCombustible, int año, int recorrido, double precio, String tipoVehiculo) {
        
      
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();

        Vehiculo vehiculo1 = new Vehiculo("ABC123", "Toyota", "Corolla", "Gasolina", "Rojo",
                "Gasolina", 2022, 0, 25000.0, "moto","toyota.jpg");       
                
        Vehiculo vehiculo2 = new Vehiculo("XYZ789", "Ford", "Mustang", "Gasolina", "Negro",
                "Gasolina", 2021, 15000, 45000.0, "moto","mustang.jpg");
        
        vehiculos.add(vehiculo1);
        vehiculos.add(vehiculo2);
        Vehiculo.saveListToFileSer("vehiculos.ser", vehiculos);
        ArrayList<Oferta> ofertas  =new ArrayList<>();
        Oferta.saveListToFileSer("ofertas.ser", ofertas);
        
        launch();
    }
    public static void setStage(Stage newSt) throws IOException{
        st =newSt;
    }
}

//anotaciones importante 
/*
paleta de colores 1:
#010001
#2B0504
#874000
#BC5F04
#F4442E
 #FCDC4D
 #9A031E

*/