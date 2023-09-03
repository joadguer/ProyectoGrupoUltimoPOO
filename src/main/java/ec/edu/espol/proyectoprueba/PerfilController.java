/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyectoprueba;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author JOSUE
 */
public class PerfilController implements Initializable {

    @FXML
    private Label nameperfil;
    @FXML
    private Label lastnameperfil;
    @FXML
    private Label emailperfil;
    @FXML
    private Label usernameperfil;
    @FXML
    private Label organizationperfil;
    
    
    private Usuario usuario;
    
    private int indiceUsuario; 
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void home(MouseEvent event) {
            try {
                FXMLLoader loader = App.loadFXML("Menu");
                Scene sc = new Scene(loader.load(),1214,590);
                MenuController controlador = loader.getController();
                controlador.setUsuario(usuario);
                controlador.setIndiceUsuario(indiceUsuario);
                
                App.setScene(sc);
//                Stage old = (Stage)b.getScene().getWindow();
//                old.close();
//                Stage st = new Stage();
//                st.setScene(sc);
//                st.show();
                
            } catch (IOException ex) {
//                Alert a = new Alert(Alert.AlertType.ERROR,"Archivo no encontrado");
//                a.show();
            }        
    }
    

    @FXML
    private void perfil(MouseEvent event) {
        
    }

    @FXML
    private void registrarVehiculo(MouseEvent event) {
        try {
                FXMLLoader loader = App.loadFXML("RegistrarVehiculo");
                Scene sc = new Scene(loader.load(),1400,700);
                RegistrarVehiculoController controlador = loader.getController();
                controlador.setUsuario(usuario);
                controlador.setIndiceUsuario(indiceUsuario);
                App.setScene(sc);
                
                
            } catch (IOException ex) {
//                Alert a = new Alert(Alert.AlertType.ERROR,"Archivo no encontrado");
//                a.show();
            }         
    }

    @FXML
    private void ofertarVehiculo(MouseEvent event) {
            try {
                FXMLLoader loader = App.loadFXML("OfertarPorVehiculo");
                Scene sc = new Scene(loader.load(),1214,590);
                OfertarPorVehiculoController controlador = loader.getController();
                controlador.setUsuario(usuario);
                controlador.setIndiceUsuario(indiceUsuario);
                
                App.setScene(sc);
//                Stage old = (Stage)b.getScene().getWindow();
//                old.close();
//                Stage st = new Stage();
//                st.setScene(sc);
//                st.show();
                
            } catch (IOException ex) {
//                Alert a = new Alert(Alert.AlertType.ERROR,"Archivo no encontrado");
//                a.show();
            }                
    }

    @FXML
    private void aceptarOferta(MouseEvent event) {
        try {
                FXMLLoader loader = App.loadFXML("AceptarOferta");
                Scene sc = new Scene(loader.load(),1214,590);
                AceptarOfertaController controlador = loader.getController();
                controlador.setUsuario(usuario);
                controlador.setIndiceUsuario(indiceUsuario);
                App.setScene(sc);
                
                
            } catch (IOException ex) {
//                Alert a = new Alert(Alert.AlertType.ERROR,"Archivo no encontrado");
//                a.show();
            }        
    }

    @FXML
    private void cerrarSession(MouseEvent event) {
        Button b = (Button)event.getSource();
        try{
            if (b.getScene() != null) {
                Stage old = (Stage) b.getScene().getWindow();
                old.close();
            }          
            //nota importante para mí,primero hay que cerrar el old stage y luego crear uno nuevo para que no salga una exception
           
            FXMLLoader loader = App.loadFXML("Tienda");
            Scene sc = new Scene(loader.load(),640,480);
            TiendaController controlador = loader.getController();
// analizar si no se necesita el este codio controlador.setPelicula(p);
            App.setScene(sc);
            Stage st = new Stage();
            st.setResizable(false);
            st.setScene(sc);
            st.show();

        }catch(IOException e){
            Alert a = new Alert(Alert.AlertType.INFORMATION,"Error");
            a.show();
        }
    }

    public Label getNameperfil() {
        return nameperfil;
    }

    public void setNameperfil(Label nameperfil) {
        this.nameperfil = nameperfil;
    }

    public Label getLastnameperfil() {
        return lastnameperfil;
    }

    public void setLastnameperfil(Label lastnameperfil) {
        this.lastnameperfil = lastnameperfil;
    }

    public Label getEmailperfil() {
        return emailperfil;
    }

    public void setNameperfil(String name) {
        nameperfil.setText(name);
    }
    
    public void setLastnameperfil(String lastname) {
        lastnameperfil.setText(lastname);
    }
    
    public void setOrganizationperfil(String organization) {
        organizationperfil.setText(organization);
    }
    
    public void setUsernameperfil(String username) {
        usernameperfil.setText(username);
    }
    
    public void setEmailperfil(String email) {
        emailperfil.setText(email);
    }
    
    
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    @FXML
    private void changepassword(MouseEvent event) {
        //cambiar la escena a password
            try {
                FXMLLoader loader = App.loadFXML("passwordchange");
                Scene sc = new Scene(loader.load(),1214,590);
                PasswordchangeController controlador = loader.getController();
                controlador.setUsuario(usuario);
                controlador.setIndiceUsuario(indiceUsuario);
                App.setScene(sc);
                
                
            } catch (IOException ex) {
//                Alert a = new Alert(Alert.AlertType.ERROR,"Archivo no encontrado");
//                a.show();
            }         
        
    }

    public void setIndiceUsuario(int indiceUsuario) {
        this.indiceUsuario = indiceUsuario;
    }


    
    
    
}
