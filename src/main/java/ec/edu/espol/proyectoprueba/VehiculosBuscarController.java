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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author JOSUE
 */
public class VehiculosBuscarController implements Initializable {

    @FXML
    private HBox hboxVehiculos;

    private Usuario usuario;
    
    private ArrayList<Vehiculo> vehiculos;
    private int indiceUsuario; 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODOjoad
        hboxVehiculos.setSpacing(10);
        
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
            st.setResizable(false);
            st.setScene(sc);
            st.show();

        }catch(IOException e){
            Alert a = new Alert(Alert.AlertType.INFORMATION,"Error");
            a.show();
        }        
    }

    @FXML
    private void informacionVehiculo(MouseEvent event) {
    hboxVehiculos.getChildren().clear();
        for(Vehiculo p : vehiculos)
        {
            Image im = new Image("img/"+p.getNameFile());
            ImageView img = new ImageView(im);
            img.setFitHeight(300);
            img.setFitWidth(300);
            img.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent t) -> {
                Alert a  = new Alert(Alert.AlertType.INFORMATION,p.toString());
                a.show();
            });
           hboxVehiculos.getChildren().add(img);   
           
           
        }
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void setIndiceUsuario(int indiceUsuario) {
        this.indiceUsuario = indiceUsuario;
    }
    
    
    
    
}
