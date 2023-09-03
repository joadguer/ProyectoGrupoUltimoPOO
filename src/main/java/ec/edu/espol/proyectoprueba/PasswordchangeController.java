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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author JOSUE
 */
public class PasswordchangeController implements Initializable {

    @FXML
    private PasswordField oldpassword;
    @FXML
    private PasswordField newpassword;
    @FXML
    private PasswordField verifynewpassword;

    private Usuario usuario;
    
    @FXML
    private Label validaroldpassword;
    @FXML
    private Label valiardnewpassword;
    @FXML
    private Label validarverifynewpassword;
    
    private ArrayList<Usuario> usuarios;
    private int indiceUsuario; 
    //el indice se usa para cambiar la password
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
            usuarios = Usuario.readListFromFileSer("usuarios.ser");
        }catch(Exception e){
        }
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
            try {
                FXMLLoader loader = App.loadFXML("Perfil");
                Scene sc = new Scene(loader.load(),1214,590);
                PerfilController controlador = loader.getController();
                controlador.setUsuario(usuario);
                controlador.setIndiceUsuario(indiceUsuario);
                
                App.setScene(sc);

                controlador.setNameperfil(usuario.getNombre());
                controlador.setLastnameperfil(usuario.getApellidos());
                controlador.setOrganizationperfil(usuario.getOrganizacion());
                controlador.setUsernameperfil(usuario.getNombreUsuario());
                controlador.setEmailperfil(usuario.getEmail());
            } catch (IOException ex) {
                Alert a = new Alert(Alert.AlertType.ERROR,"Archivo no encontrado");
                a.show();
            }        
    }

    @FXML
    private void registrarVehiculo(MouseEvent event) {
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
            st.setScene(sc);
            st.setResizable(false);            
            st.show();

        }catch(IOException e){
            Alert a = new Alert(Alert.AlertType.INFORMATION,"Error");
            a.show();
        }
    }

    @FXML
    private void changepassword(MouseEvent event) {
        //validar que la contraseña sea igual 
    //campos donde ingresa la contraseña


        if(oldpassword.getText().isBlank())
            {
                validaroldpassword.setText("*Required field");
            }
        else if(!oldpassword.getText().equals(usuario.getContraseña()))
            {
                validaroldpassword.setText("*Incorrect");                
            }
        else
            {
                validaroldpassword.setText("Valid");
            }

        if(newpassword.getText().isBlank())
            {
                valiardnewpassword.setText("*Required field");
            }
        else
            {
                valiardnewpassword.setText("Valid");
            }
        if(verifynewpassword.getText().isBlank())
            {
                validarverifynewpassword.setText("*Required field");
            }
        else if(!verifynewpassword.getText().equals(newpassword.getText()))
            {
                validarverifynewpassword.setText("*No coincidence");
                
            }
        else
            {
                validarverifynewpassword.setText("Valid");
            }
        if(validaroldpassword.getText().equals("Valid") && valiardnewpassword.getText().equals("Valid") && validarverifynewpassword.getText().equals("Valid"))
        {
            //error se elimina el indice 0
            usuarios.remove(indiceUsuario);
            //System.out.println(usuarios);
            
            usuario.setContraseña(verifynewpassword.getText());
            usuarios.add(indiceUsuario,usuario);
            
            //System.out.println(usuarios);
            
            Usuario.saveListToFileSer("usuarios.ser", usuarios);
            
            //System.out.println(usuario);
        }
        
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setIndiceUsuario(int indiceUsuario) {
        this.indiceUsuario = indiceUsuario;
    }
    
    
    
}
