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
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author JOSUE
 */
public class MenuController implements Initializable{

    @FXML
    private Label bienvenida;

    private Usuario usuario;

    private int indiceUsuario; 

    

    /**
     * Initializes the controller class.
     */
    
    private  Stage st;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    @FXML
    private void home(MouseEvent event) {
        //implementar para regresar
        bienvenida.setText("Bienvenido "+ usuario.getNombre() +" "+ usuario.getApellidos());
        
        //podría ser un condicional donde se verifique que la escena es la misma que el home
    }

    @FXML
    private void perfil(MouseEvent event) {
       
            Button b = (Button)event.getSource();

            try {
                FXMLLoader loader = App.loadFXML("Perfil");
                Scene sc = new Scene(loader.load(),1214,590);
                PerfilController controlador = loader.getController();
                controlador.setUsuario(usuario);
                App.setScene(sc);

                controlador.setNameperfil(usuario.getNombre());
                controlador.setLastnameperfil(usuario.getApellidos());
                controlador.setOrganizationperfil(usuario.getOrganizacion());
                controlador.setUsernameperfil(usuario.getNombreUsuario());
                controlador.setEmailperfil(usuario.getEmail());
                controlador.setIndiceUsuario(indiceUsuario);
            } catch (IOException ex) {
                Alert a = new Alert(Alert.AlertType.ERROR,"Archivo no encontrado");
                a.show();
            }
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

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setIndiceUsuario(int indiceUsuario) {
        this.indiceUsuario = indiceUsuario;
    }
    
    
}
