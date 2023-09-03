/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyectoprueba;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author JOSUE
 */



public class AceptarOfertaController implements Initializable {
private Usuario usuario;
private int indiceUsuario; 
    @FXML
    private ComboBox<String> cbxOrdenar;
    @FXML
    private TableView<Oferta> tablaOfertas;
    @FXML
    private TableColumn<Oferta, String> columnPrecio;
    @FXML
    private TableColumn<Oferta, String> columnAnio;
    @FXML
    private Button btnAceptarOferta;
    
    private static ArrayList<Oferta> ofertasAceptadas = new ArrayList<>();



    public Usuario getUsuario() {
        return usuario;
        // TODO
    }    

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getIndiceUsuario() {
        return indiceUsuario;
    }

    /**
     * Initializes the controller class.
     */
    public void setIndiceUsuario(int indiceUsuario) {
        this.indiceUsuario = indiceUsuario;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ArrayList<String> opciones = new ArrayList<>();
        opciones.add("Precio");
        opciones.add("Año");
        cbxOrdenar.getItems().addAll(opciones);
        
            
          ObservableList<Oferta> data = FXCollections.observableArrayList(Oferta.getOfertas());
           tablaOfertas.setItems(data);

        
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
                
            } catch (IOException ex) {

            }          
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
private void ordenarOfertas(ActionEvent event) {
    ObservableList<Oferta> orderedList = FXCollections.observableArrayList(Oferta.getOfertas());

    String selectedOrder = cbxOrdenar.getSelectionModel().getSelectedItem();
    if (selectedOrder != null) {
        switch (selectedOrder) {
            case "Precio":
                FXCollections.sort(orderedList, Comparator.comparing(Oferta::getPrecio));
                break;
            case "Año":
                // I'm assuming that Vehiculo class has a getYear() method. 
                // If it doesn't, you'll have to adjust this line accordingly.
                FXCollections.sort(orderedList, Comparator.comparing(o -> o.getVehiculo().getAño()));
                break;
            default:
                break;
        }

        tablaOfertas.setItems(orderedList);
    }
}

    
@FXML
private void aceptarOferta(ActionEvent event) {
    Oferta selectedOffer = tablaOfertas.getSelectionModel().getSelectedItem();
    
    if (selectedOffer != null) {
        
        ofertasAceptadas.add(selectedOffer);

        
//        Oferta.getOfertas().remove(selectedOffer);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Oferta Aceptada");
        alert.setHeaderText(null);
        alert.setContentText("La oferta seleccionada ha sido aceptada");
        alert.showAndWait();
    } else {
        
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("No seleccion");
        alert.setHeaderText(null);
        alert.setContentText("Por favor seleccionar una oferta de la tabla.");
        alert.showAndWait();
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
            FXMLLoader loader = App.loadFXML("Tienda");
            Scene sc = new Scene(loader.load(),640,480);
            TiendaController controlador = loader.getController();
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
    private void option(MouseEvent event) {
    }
    
}
