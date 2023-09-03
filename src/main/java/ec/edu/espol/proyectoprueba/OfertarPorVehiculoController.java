/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyectoprueba;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author JOSUE
 */
public class OfertarPorVehiculoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    private Usuario usuario; 
    private int indiceUsuario; 
    private ArrayList<Vehiculo> vehiculos;
    @FXML
    private ComboBox<String> cbx;
    @FXML
    private TextField minRecorrido;
    @FXML
    private TextField maxRecorrido;
    @FXML
    private TextField minAño;
    @FXML
    private TextField maxAño;
    @FXML
    private TextField minPrecio;
    @FXML
    private TextField maxPrecio;

    private String opcionSeleccionada;
    @FXML
    private Label minRecorridoLabel;
    @FXML
    private Label maxRecorridoLabel;
    @FXML
    private Label minYearLabel;
    @FXML
    private Label maxYearLabel;
    @FXML
    private Label minPrecioLabel;
    @FXML
    private Label maxPrecioLabel;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        vehiculos = Vehiculo.readListFromFileSer("vehiculos.ser");
        ArrayList<String> tipoVehiculo = new ArrayList();
        tipoVehiculo.add("Moto");
        tipoVehiculo.add("Auto");
        tipoVehiculo.add("Camioneta");
        cbx.getItems().addAll(tipoVehiculo);    
    }    

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setIndiceUsuario(int indiceUsuario) {
        this.indiceUsuario = indiceUsuario;
    }

    public int getIndiceUsuario() {
        return indiceUsuario;
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
    private void seleccionarTipo(ActionEvent event) {
        ComboBox cb = (ComboBox)event.getSource();
        String s = (String)cb.getValue();  
        opcionSeleccionada = s;
    }

    @FXML
    private void buscar(MouseEvent event) {

    int minRecorridoVariable = 0;
    int maxRecorridoVariable = Integer.MAX_VALUE;
    int minAñoVariable = 0;
    int maxAñoVariable = Integer.MAX_VALUE;
    double minPrecioVariable = 0;
    double maxPrecioVariable = Double.MAX_VALUE;
    
    if(!minRecorrido.getText().isEmpty()) {
        try{
            minRecorridoVariable = Integer.parseInt(minRecorrido.getText());
            
        }catch(NumberFormatException e){
            minRecorridoLabel.setText("*Solo se aceptan numeros");
        }
    }

    if(!maxRecorrido.getText().isEmpty()) {
        try{
            maxRecorridoVariable = Integer.parseInt(maxRecorrido.getText());
            
        }catch(NumberFormatException e){
            maxRecorridoLabel.setText("*Solo se aceptan numeros");
        }
    }
    
    if (!minAño.getText().isEmpty()) {
        try{
            minAñoVariable = Integer.parseInt(minAño.getText());            
        }catch(NumberFormatException e){
            minYearLabel.setText("*Solo se aceptan numeros");
        }
    }    

    if (!maxAño.getText().isEmpty()) {
        try{
            maxAñoVariable = Integer.parseInt(maxAño.getText());

        }catch(NumberFormatException e){
            maxYearLabel.setText("*Solo se aceptan numeros");
        }
}
    
    
    
    if (!minPrecio.getText().isEmpty()) {
        try{
            minPrecioVariable = Double.parseDouble(minPrecio.getText());
            
        }catch(NumberFormatException e){
            minPrecioLabel.setText("*Solo se aceptan numeros");
        }
    }

    if (!maxPrecio.getText().isEmpty()) {
        try{
            maxPrecioVariable = Double.parseDouble(maxPrecio.getText());
            
        }catch(NumberFormatException e){
            maxPrecioLabel.setText("*Solo se aceptan numeros");
        }
    }
    
    ArrayList<Vehiculo> vehiculosFiltrados = new ArrayList<>();
     for (Vehiculo v : vehiculos) {
           if ((opcionSeleccionada == null || v.getTipoVehiculo().equals(opcionSeleccionada)) &&
            (v.getRecorrido() >= minRecorridoVariable && v.getRecorrido() <= maxRecorridoVariable) &&
            (v.getAño() >= minAñoVariable && v.getAño() <= maxAñoVariable) &&
            (v.getPrecio() >= minPrecioVariable && v.getPrecio() <= maxPrecioVariable)) {
             vehiculosFiltrados.add(v);
            }
           //System.out.println(vehiculos);
     }
     System.out.println(vehiculosFiltrados);

    try {
            FXMLLoader loader = App.loadFXML("VehiculosBuscar");
            Scene sc = new Scene(loader.load(),1214,590);
            VehiculosBuscarController controlador = loader.getController();
            controlador.setUsuario(usuario);
            controlador.setVehiculos(vehiculosFiltrados);
            
            App.setScene(sc);


        } catch (IOException ex) {

        }
    
    } 
}





/*
Codigo anterior 
 try {
        System.out.println("Ingrese el modelo de vehículo:");
        String modelo = sc.nextLine();
        if (modelo.isEmpty()) modelo = null;

        System.out.println("Ingrese el rango de recorrido en el formato min-max:");
        String recorrido = sc.nextLine();
        double minRecorrido = 0;
        double maxRecorrido = Double.MAX_VALUE;
        if (!recorrido.isEmpty()) {
            String[] parts = recorrido.split("-");
            minRecorrido = Double.parseDouble(parts[0]);
            maxRecorrido = Double.parseDouble(parts[1]);
        }

        System.out.println("Ingrese el rango de año en el formato min-max:");
        String año = sc.nextLine();
        int minAño = Integer.MIN_VALUE;
        int maxAño = Integer.MAX_VALUE;
        if (!año.isEmpty()) {
            String[] parts = año.split("-");
            minAño = Integer.parseInt(parts[0]);
            maxAño = Integer.parseInt(parts[1]);
        }

        System.out.println("Ingrese el rango de precio en el formato min-max:");
        String precio = sc.nextLine();
        double minPrecio = 0;
        double maxPrecio = Double.MAX_VALUE;
        if (!precio.isEmpty()) {
            String[] parts = precio.split("-");
            minPrecio = Double.parseDouble(parts[0]);
            maxPrecio = Double.parseDouble(parts[1]);
        }

        ArrayList<Vehiculo> vehiculos = Vehiculo.readFile(archivoVehiculos);
        ArrayList<Vehiculo> vehiculosFiltrados = new ArrayList<>();
         for (Vehiculo v : vehiculos) {
               if ((modelo == null || v.getModelo().equals(modelo)) &&
                (v.getRecorrido() >= minRecorrido && v.getRecorrido() <= maxRecorrido) &&
                (v.getAño() >= minAño && v.getAño() <= maxAño) &&
                (v.getPrecio() >= minPrecio && v.getPrecio() <= maxPrecio)) {
                 vehiculosFiltrados.add(v);
                }
         }   


        
        for (int i = 0; i < vehiculosFiltrados.size(); i++) {
            System.out.println(vehiculosFiltrados.get(i).toString());
            
            System.out.println("¿Desea hacer una oferta por este vehículo? (s/n)");
            String respuesta = sc.nextLine();
            
            if (respuesta.equalsIgnoreCase("s")) {
                System.out.println("Ingrese el precio ofertado: ");
                double precioOfertado = Double.parseDouble(sc.nextLine());

                
                Oferta oferta = new Oferta(Util.nextID(archivoOfertas),vRevisarClave.IdComprador,vehiculosFiltrados.get(i).getIdVehiculo(),correoElectronicoIn, precioOfertado );
                oferta.saveFile(archivoOfertas);
                vehiculosFiltrados.get(i).addOferta(oferta);
                
                System.out.println("Oferta realizada con éxito");
            } else if (respuesta.equalsIgnoreCase("n")) {
                continue;
            }
            
            System.out.println("¿Desea seguir buscando vehículos? (s/n)");
            String seguirBuscando = sc.nextLine();
            
            if (seguirBuscando.equalsIgnoreCase("n")) {
                break;
            }
        }
    } catch (NumberFormatException e) {
        System.out.println("Por favor, ingrese los números correctamente. Error: " + e.getMessage());
    } catch (Exception e) {
        System.out.println("Ha ocurrido un error inesperado. Error: " + e.getMessage());
    }
}


*/