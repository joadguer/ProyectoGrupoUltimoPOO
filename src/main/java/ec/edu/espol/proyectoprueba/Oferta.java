/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectoprueba;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author JOSUE
 */
public class Oferta implements Serializable{
    private String correo;
    private double precio;
    private Vehiculo vehiculo;

    public Oferta(String correo, double precio, Vehiculo vehiculo) {
        this.correo = correo;
        this.precio = precio;
        this.vehiculo = vehiculo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }


    @Override
    public String toString() {
        return "Oferta{" + "correo=" + correo + ", precio=" + precio + ", vehiculo=" + vehiculo.getPlaca() + '}';
    }
    
        public static void saveListToFileSer(String nombreArchivo, ArrayList<Oferta> ofertas) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(ofertas);
        } catch (IOException e) {
    }
}
   
     public static ArrayList<Oferta> readListFromFileSer(String nombreArchivo) {
        ArrayList<Oferta> ofertas = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            ofertas = (ArrayList<Oferta>) ois.readObject();
        } catch (IOException e){
            e.printStackTrace();
        } 
        catch (ClassNotFoundException h){
            h.printStackTrace();
        }
        return ofertas;
    }

    
}
