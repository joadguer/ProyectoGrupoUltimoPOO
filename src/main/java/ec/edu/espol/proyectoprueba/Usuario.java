/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectoprueba;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author JOSUE
 */
public class Usuario implements Serializable{
    //nombre de usuario es el correo
   private String nombreUsuario;
   private String contraseña;
   private String apellidos;
   private String nombre;
   private String organizacion;
   private String email;

    public Usuario(String nombreUsuario, String contraseña, String apellidos, String nombre, String organizacion, String email) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.organizacion = organizacion;
        this.email = email;
    }
   

    
   
    public static void saveListToFileSer(String nombreArchivo, ArrayList<Usuario> usuarios) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(usuarios);
        } catch (IOException e) {
    }
}
   
     public static ArrayList<Usuario> readListFromFileSer(String nombreArchivo) {
        ArrayList<Usuario> usuarios = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            usuarios = (ArrayList<Usuario>) ois.readObject();
        } catch (IOException e){
            e.printStackTrace();
        } 
        catch (ClassNotFoundException h){
            h.printStackTrace();
        }
        return usuarios;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombreUsuario=" + nombreUsuario + ", contrase\u00f1a=" + contraseña + ", apellidos=" + apellidos + ", nombre=" + nombre + ", organizacion=" + organizacion + ", email=" + email + '}';
    }
    
    
        public static void enviarConGMail(String destinatario, String asunto, String cuerpo) {
        
        String remitente = "tiendadeautospoo@gmail.com";
        
        String claveemail = "jmivvcsnbosuoork";

        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com");  
        props.put("mail.smtp.user", remitente);
        props.put("mail.smtp.clave", claveemail);    
        props.put("mail.smtp.auth", "true");   
        props.put("mail.smtp.starttls.enable", "true"); 
        props.put("mail.smtp.port", "587"); 

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(remitente));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));   
            message.setSubject(asunto);
            message.setText(cuerpo);
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", remitente, claveemail);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (MessagingException me) {
            me.printStackTrace();  
        }
  }
    
    
}