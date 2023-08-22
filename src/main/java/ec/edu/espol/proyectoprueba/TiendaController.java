/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyectoprueba;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author JOSUE
 */
public class TiendaController implements Initializable {

    @FXML
    private TextField password;
    @FXML
    private TextField user;
    @FXML
    public Button login;
    @FXML
    private Button signUp;
    @FXML
    private ImageView imagenUsuario;
    @FXML
    private ImageView imagenLocker;
    
    private ArrayList<Usuario> usuarios;

    /**
     * Initializes the controller class.
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            usuarios = Usuario.readListFromFileSer("usuarios.ser");            
        }catch(Exception e){
        }
        
        
    }    
    
    //implementar mejora tener ya todos los archivos en el 
    @FXML
    public Usuario Login(MouseEvent event) {
        Usuario usuarioRetornar = null;
        try {
            String usuarioTexto = user.getText();
            String clave = password.getText();

            for (Usuario usuario : usuarios) {
                if ((usuario.getNombreUsuario().equals(usuarioTexto) || usuario.getEmail().equals(usuarioTexto) )&& usuario.getContraseña().equals(clave)) {
//                    Alert a = new Alert(Alert.AlertType.INFORMATION, "Usuario correcto");
//                    a.show();
                    usuarioRetornar = usuario;
                    int i =usuarios.indexOf(usuario);
                    Button b = (Button)event.getSource();
                    try{
                        if (b.getScene() != null) {
                            Stage old = (Stage) b.getScene().getWindow();
                            old.close();
                        }          
                        //nota importante para mí,primero hay que cerrar el old stage y luego crear uno nuevo para que no salga una exception

                        FXMLLoader loader = App.loadFXML("Menu");
                        Scene sc = new Scene(loader.load(),1214,590);
                        MenuController controlador = loader.getController();
                        controlador.setUsuario(usuarioRetornar);
                        controlador.setIndiceUsuario(i);
                        System.out.println(usuarioRetornar);
            // analizar si no se necesita el este codio controlador.setPelicula(p);
                        App.setScene(sc);


                        Stage st = new Stage();
                        st.setScene(sc);
                        App.setStage(st);
                        st.show();
                    }catch(IOException e){
                        Alert x = new Alert(Alert.AlertType.INFORMATION,"Error");
                        x.show();
                    }
                    
                    return usuarioRetornar;
                }
            }
            //implementar codigo para que el codigo no use banderas
//                Alert a = new Alert(Alert.AlertType.ERROR, "Usuario Incorrecto");
//                a.show();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return usuarioRetornar;
    }


    @FXML
    private void SignUp(MouseEvent event) {
       // Alert a = new Alert(Alert.AlertType.INFORMATION,"Alert funciona");
        //a.show
        Button b = (Button)event.getSource();
        
        try{
            if (b.getScene() != null) {
                Stage old = (Stage) b.getScene().getWindow();
                old.close();
            }          
            //nota importante para mí,primero hay que cerrar el old stage y luego crear uno nuevo para que no salga una exception
           
            FXMLLoader loader = App.loadFXML("Registro");
            Scene sc = new Scene(loader.load(),730,518);
            RegistroController controlador = loader.getController();
// analizar si no se necesita el este codio controlador.setPelicula(p);
            App.setScene(sc);


            Stage st = new Stage();
            st.setScene(sc);
            st.show();
        }catch(IOException e){
            Alert a = new Alert(Alert.AlertType.INFORMATION,"Error");
            a.show();
        }
            
    }

    
}
