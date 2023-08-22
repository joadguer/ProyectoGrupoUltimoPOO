/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyectoprueba;

import java.io.IOException;
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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author JOSUE
 */
public class RegistrarVehiculoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    private Usuario usuario;
    private int indiceUsuario;
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
    @FXML
    private TextField placaText;
    @FXML
    private Label placalabel;
    @FXML
    private TextField marcaText;
    @FXML
    private Label marcalabel;
    @FXML
    private TextField modeloText;
    @FXML
    private Label modelolabel;
    @FXML
    private TextField tipomotorText;
    @FXML
    private Label tipomotorlabel;
    @FXML
    private TextField yearText;
    @FXML
    private Label yearlabel;
    @FXML
    private TextField recorridoText;
    @FXML
    private Label recorridolabel;
    @FXML
    private TextField colorText;
    @FXML
    private Label colorlabel;
    @FXML
    private TextField tipocombustibleText;
    @FXML
    private Label tipocombustiblelabel;
    @FXML
    private TextField vidrioText;
    @FXML
    private Label vidriolabel;
    @FXML
    private TextField transmisionText;
    @FXML
    private Label transmisionlabel;
    @FXML
    private VBox vboxVehiculo;
    @FXML
    private ComboBox<String> cbx = new ComboBox<>();
           
    private ArrayList<Vehiculo> vehiculos;
    @FXML
    private TextField precioText;
    @FXML
    private Label preciolabel;
    @FXML
    private TextField traccionText;
    @FXML
    private Label traccionlabel;
    
    private String opcionSeleccionada; 
    @FXML
    private Label tipoVehiculolabel;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //agregar la parte de leer vehiculos
        vehiculos = Vehiculo.readListFromFileSer("vehiculos.ser");
        ArrayList<String> tipoVehiculo = new ArrayList();
        tipoVehiculo.add("Moto");
        tipoVehiculo.add("Auto");
        tipoVehiculo.add("Camioneta");
        cbx.getItems().addAll(tipoVehiculo);
//        cbx.setStyle("-fx-background-color: #9A031E, white; -fx-text-fill: white; -fx-font-family: 'Baskerville Old Face';");
        
    }    
    

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setIndiceUsuario(int indiceUsuario) {
        this.indiceUsuario = indiceUsuario;
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
                controlador.setIndiceUsuario(indiceUsuario);
            } catch (IOException ex) {
                Alert a = new Alert(Alert.AlertType.ERROR,"Archivo no encontrado");
                a.show();
            }
        
    }

    @FXML
    private void registrarVehiculo(MouseEvent event) {
        
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

    
//guardar el vehiculo en el registro de vehiculos    
    @FXML
    private void register(MouseEvent event) {
//        Alert a = new Alert(Alert.AlertType.INFORMATION,opcionSeleccionada);
//        a.show();
        
        //1
        if(placaText.getText().isBlank())
        {
            placalabel.setText("*Required field");
        }else
        {
            for(Vehiculo vehiculo: vehiculos)
            {
                if(vehiculo.getPlaca().equals(placaText.getText()))
                {
                    placalabel.setText("*Placa ya existe");   
                    break;
                }
                else
                {
                    placalabel.setText("Valido");

                }
                
            }
            
            } //buscar una manera mas eficiente de mostrar el valido
        
        
        //2
        
        if(marcaText.getText().isBlank())
        {
            marcalabel.setText("*Required field");
        }else
        {
            marcalabel.setText("Valido");
        }
        
        
        //3
        if(modeloText.getText().isBlank())
        {
            modelolabel.setText("*Required field");
        }
        else
        {
            modelolabel.setText("Valido");
            
        }
        //4
        if(tipomotorText.getText().isBlank())
        {
            tipomotorlabel.setText("*Required field");
        }else
        {
            tipomotorlabel.setText("Valido");                        
        }
        //5
        //Falta agregar validaciones de numerica
        if(yearText.getText().isBlank())
        {
            yearlabel.setText("*Required field");
        }else
        {  
            try
            {
                Integer.parseInt(yearText.getText());
                yearlabel.setText("Valido");
            } catch(NumberFormatException e)
            {
                yearlabel.setText("*Solo se aceptan numeros");
                
            }
            
        }
        //6
        //falta validar que el precio se un double
        if(precioText.getText().isBlank())
        {
            preciolabel.setText("*Required field");
        }else
        {
            try
            {
                Double.parseDouble(precioText.getText());
                preciolabel.setText("Valido");
            } catch(NumberFormatException e)
            {
                preciolabel.setText("*Solo se aceptan numeros");
                
            }        
        }

//7
        if(recorridoText.getText().isBlank())
        {
            recorridolabel.setText("*Required field");
        }else
        {
            try
            {
                Integer.parseInt(recorridoText.getText());
                recorridolabel.setText("Valido");
            } catch(NumberFormatException e)
            {
                recorridolabel.setText("*Solo se aceptan numeros");
                
            }        
        }
        
        if(colorText.getText().isBlank())
        {
            colorlabel.setText("*Required field");
        }else
        {
            colorlabel.setText("Valido");
        }
        
        if(tipocombustibleText.getText().isBlank())
        {
            tipocombustiblelabel.setText("*Required field");
        }else
        {
            tipocombustiblelabel.setText("Valido");
        }
        

        //conditional para crear al usuario 
        //poner todos los label e igualarlos a valido
        //agregar condicional de que el tipo de vehiculo sea uno en específico
        
        // validar que tipo de vehiculo es para que se guarde en un tipo
        switch(opcionSeleccionada){
            case "Moto":
                vidriolabel.setText("*No aplica para motos");
                transmisionlabel.setText("*No aplica para motos");
                traccionlabel.setText("*Solo aplica para camionetas");
                if(placalabel.getText().equals("Valido") && marcalabel.getText().equals("Valido") && modelolabel.getText().equals("Valido") && tipomotorlabel.getText().equals("Valido") && yearlabel.getText().equals("Valido") && preciolabel.getText().equals("Valido")&&recorridolabel.getText().equals("Valido") && colorlabel.getText().equals("Valido")&&tipocombustiblelabel.getText().equals("Valido"))
                {
                    Vehiculo vehiculoAgregar = new Vehiculo(placaText.getText(),
                                                            marcaText.getText(),    
                                                            modeloText.getText(),
                                                            tipomotorText.getText(),
                                                            colorText.getText(),
                                                            tipocombustibleText.getText(),                    
                                                            Integer.parseInt(recorridoText.getText()),
                                                            Integer.parseInt(yearText.getText()),
                                                            Double.parseDouble(precioText.getText()),
                                                            opcionSeleccionada,
                                                            "mustang.jpg"
                            
                                                            
                    );
                    vehiculos.add(vehiculoAgregar);
                    Vehiculo.saveListToFileSer("vehiculos.ser", vehiculos);

                    //el alert solo se muestra cuando si todos los datos son correctos
                    Alert a = new Alert(Alert.AlertType.INFORMATION,"VEHICULO REGISTRADO");
                    a.show();            
                } 
                break;
                
                //falta agregar las validaciones para el auto
            case "Auto":
                if(vidrioText.getText().isBlank())
                        {
                            vidriolabel.setText("*Required field");
                        }else
                        {
                            try
                            {
                                Integer.parseInt(vidrioText.getText());
                                vidriolabel.setText("Valido");
                            } catch(NumberFormatException e)
                            {
                                vidriolabel.setText("*Solo se aceptan numeros");
                            }
                        }


                        //transmission para autos y camion
                        if(transmisionText.getText().isBlank())
                        {
                            transmisionlabel.setText("*Required field");
                        }else
                        {
                            transmisionlabel.setText("Valido");
                        }    
                        //pára auto no hay que validar tracción
                if(placalabel.getText().equals("Valido") && marcalabel.getText().equals("Valido") && modelolabel.getText().equals("Valido") && tipomotorlabel.getText().equals("Valido") && yearlabel.getText().equals("Valido") && preciolabel.getText().equals("Valido")&&recorridolabel.getText().equals("Valido") && colorlabel.getText().equals("Valido")&&tipocombustiblelabel.getText().equals("Valido")&&vidriolabel.getText().equals("Valido")&&transmisionlabel.getText().equals("Valido"))
                {
                    Vehiculo vehiculoAgregar = new Vehiculo(placaText.getText(),
                                                            marcaText.getText(),    
                                                            modeloText.getText(),
                                                            tipomotorText.getText(),
                                                            colorText.getText(),
                                                            tipocombustibleText.getText(),                    
                                                            Integer.parseInt(recorridoText.getText()),
                                                            Integer.parseInt(yearText.getText()),
                                                            Double.parseDouble(precioText.getText()),
                                                            opcionSeleccionada,
                                                            "mustang.jpg"
                    );
                    vehiculos.add(vehiculoAgregar);
                    Vehiculo.saveListToFileSer("vehiculos.ser", vehiculos);

                    //el alert solo se muestra cuando si todos los datos son correctos
                    Alert a = new Alert(Alert.AlertType.INFORMATION,"VEHICULO REGISTRADO");
                    a.show();            
                } 
                break;
                //falta agregar las validaciones para la camioneta

            case "Camioneta":
                if(vidrioText.getText().isBlank())
                {
                    vidriolabel.setText("*Required field");
                }else
                {
                    try
                    {
                        Integer.parseInt(vidrioText.getText());
                        vidriolabel.setText("Valido");
                    } catch(NumberFormatException e)
                    {
                        vidriolabel.setText("*Solo se aceptan numeros");
                    }
                }

                if(transmisionText.getText().isBlank())
                {
                    transmisionlabel.setText("*Required field");
                }else
                {
                    transmisionlabel.setText("Valido");
                }    
                
                //la traccion es solo para camioneta
                if(traccionText.getText().isBlank())
                {
                    traccionlabel.setText("*Required field");
                }else
                {
                    traccionlabel.setText("Valido");
                }                        
                
                
                if(placalabel.getText().equals("Valido") && marcalabel.getText().equals("Valido") && modelolabel.getText().equals("Valido") && tipomotorlabel.getText().equals("Valido") && yearlabel.getText().equals("Valido") && preciolabel.getText().equals("Valido")&&recorridolabel.getText().equals("Valido") && colorlabel.getText().equals("Valido")&&tipocombustiblelabel.getText().equals("Valido")&&vidriolabel.getText().equals("Valido")&&transmisionlabel.getText().equals("Valido")&&traccionlabel.getText().equals("Valido"))
                {
                    //si se puede agregar un camion a una lista de vehiculos
                    Camioneta vehiculoAgregar = new Camioneta(Integer.parseInt(vidrioText.getText()),
                                                            transmisionText.getText(),
                                                            traccionText.getText(),
                                                            placaText.getText(),
                                                            marcaText.getText(),    
                                                            modeloText.getText(),
                                                            tipomotorText.getText(),
                                                            colorText.getText(),
                                                            tipocombustibleText.getText(),                    
                                                            Integer.parseInt(recorridoText.getText()),
                                                            Integer.parseInt(yearText.getText()),
                                                            Double.parseDouble(precioText.getText()),
                                                            opcionSeleccionada,
                                                            "mustang.jpg"
                    );
                    vehiculos.add(vehiculoAgregar);
                    Vehiculo.saveListToFileSer("vehiculos.ser", vehiculos);
                    System.out.println(vehiculos);
                    //el alert solo se muestra cuando si todos los datos son correctos
                    Alert a = new Alert(Alert.AlertType.INFORMATION,"VEHICULO REGISTRADO");
                    a.show();            
                }
                break;
            default:
                tipoVehiculolabel.setText("Seleccione un tipo");
                                
                                
    }
}
    
    // El archivo debe tener una lista con todos los vehiculos

    @FXML
    private void seleccionarTipo(ActionEvent event) {
        ComboBox cb = (ComboBox)event.getSource();
        String s = (String)cb.getValue();  
        opcionSeleccionada = s;
        //leer lista de vehiculos
        
    }
    
}
