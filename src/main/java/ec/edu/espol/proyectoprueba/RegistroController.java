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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author JOSUE
 */
public class RegistroController implements Initializable {

    @FXML
    private Label camponame;
    @FXML
    private Label campolastname;
    @FXML
    private Label campoemail;
    @FXML
    private Label campousername;
    @FXML
    private Label campopassword;
    @FXML
    private Label campoverifypassword;
    //id de los textfields
    @FXML
    private TextField nametext;
    @FXML
    private TextField lastnametext;
    @FXML
    private TextField emailtext;    
    @FXML
    private TextField usernametext;
    @FXML
    private PasswordField passwordtext;
    @FXML
    private PasswordField verifypasswordtext;

    private ArrayList<Usuario> usuarios;
    @FXML
    private Label campoorganizacion;
    @FXML
    private TextField organizaciontext;

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
    private void registrarusuario(MouseEvent event) {
        
        //1
        if(nametext.getText().isBlank())
        {
            camponame.setText("*Required field");
        }else
        {
            camponame.setText("Valido");
        }
        //2
        
        if(lastnametext.getText().isBlank())
        {
            campolastname.setText("*Required field");
        }else
        {
            campolastname.setText("Valido");
        }
        
        
        //3
        if(emailtext.getText().isBlank())
        {
            campoemail.setText("*Required field");
        }
        else
        {
            //recorrer lista y validar que correo no sea igual
            for(Usuario userInList: usuarios)
            {
                if(userInList.getEmail().equals(emailtext.getText()))
                {
                    campoemail.setText("Correo ya existe");
                    //como salir del bucle for sin usar el break;
                    break;
                }else if(!(emailtext.getText().contains("@")&&emailtext.getText().contains("."))){
                    campoemail.setText("Correo no valido");
                    
                } 
                else
                {
                campoemail.setText("Valido");
                }   
            }
        }
        //4
        if(usernametext.getText().isBlank())
        {
            campousername.setText("*Required field");
        }else
        {
            for(Usuario userInList: usuarios)
            {
                if(userInList.getNombreUsuario().equals(usernametext.getText()))
                {
                    campousername.setText("Uusario ya existe");
                    //como salir del bucle for sin usar el break;
                    break;
                }
                else
                {
                    campousername.setText("Valido");
                }   
            }            
        }
        //5
        if(passwordtext.getText().isBlank())
        {
            campopassword.setText("*Required field");
        }else
        {
            campopassword.setText("Valido");
        }
        //6
        if(verifypasswordtext.getText().isBlank())
        {
            campoverifypassword.setText("*Required field");
        }else if(!verifypasswordtext.getText().equals(passwordtext.getText()))
        {
            campoverifypassword.setText("No Coincidence");
        }else
        {
            campoverifypassword.setText("Valido");        
        }

//7
        if(organizaciontext.getText().isBlank())
        {
            campoorganizacion.setText("*Required field");
        }else
        {
            campoorganizacion.setText("Valido");
        }
        

        //conditional para crear al usuario 
        //poner todos los label e igualarlos a valido
        if(camponame.getText().equals("Valido") && campolastname.getText().equals("Valido") && campoemail.getText().equals("Valido") && campousername.getText().equals("Valido") && campopassword.getText().equals("Valido") && campoverifypassword.getText().equals("Valido")&&campoorganizacion.getText().equals("Valido"))
        {
            Usuario usuarioAgregar = new Usuario(   usernametext.getText(),
                                                    passwordtext.getText(),    
                                                    lastnametext.getText(),
                                                    nametext.getText(),
                                                    organizaciontext.getText(),
                                                    emailtext.getText()
            );
            usuarios.add(usuarioAgregar);
            Usuario.saveListToFileSer("usuarios.ser", usuarios);
            
            //el alert solo se muestra cuando si todos los datos son correctos
            Alert a = new Alert(Alert.AlertType.INFORMATION,"USUARIO REGISTRADO");
            a.show();            
        }
    }
    @FXML
    private void loginvolver(MouseEvent event) {
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
            st.show();
        }catch(IOException e){
            Alert a = new Alert(Alert.AlertType.INFORMATION,"Error");
            a.show();
        }
    }
    
}



