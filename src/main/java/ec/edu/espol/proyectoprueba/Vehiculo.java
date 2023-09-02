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
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author JOSUE
 */
public class Vehiculo implements Serializable{
        protected String placa;
        protected String marca;
        protected String modelo;
        protected String tipoMotor;
        protected String color;
        protected String tipoCombustible;
        protected int año;
        protected int recorrido;
        protected double precio;
        protected ArrayList<Oferta> ofertas; //ofertas del vehiculo en específico
        protected String tipoVehiculo;
        protected String nameFile;

    public Vehiculo(String placa, String marca, String modelo, String tipoMotor, String color, String tipoCombustible, int año, int recorrido, double precio, String tipoVehiculo, String nameFile) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.tipoMotor = tipoMotor;
        this.color = color;
        this.tipoCombustible = tipoCombustible;
        this.año = año;
        this.recorrido = recorrido;
        this.precio = precio;
        this.tipoVehiculo = tipoVehiculo;
        this.ofertas = new ArrayList<>();
        this.nameFile = nameFile;
    }
    


    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getRecorrido() {
        return recorrido;
    }

    public void setRecorrido(int recorrido) {
        this.recorrido = recorrido;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


    public ArrayList<Oferta> getOfertas() {
        return ofertas;
    }

    public void setOfertas(ArrayList<Oferta> ofertas) {
        this.ofertas = ofertas;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }



    @Override
    public String toString() {
        return "Vehiculo{" + "placa=" + placa + ", marca=" + marca + ", modelo=" + modelo + ", tipoMotor=" + tipoMotor + ", color=" + color + ", tipoCombustible=" + tipoCombustible + ", a\u00f1o=" + año + ", recorrido=" + recorrido + ", precio=" + precio  + ", ofertas=" + ofertas + '}';
    }
        
    public void addOferta(Oferta e){
        this.ofertas.add(e);
    }        
    
    
        public static void saveListToFileSer(String nombreArchivo, ArrayList<Vehiculo> vehiculos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(vehiculos);
        } catch (IOException e) {
    }
}
   
     public static ArrayList<Vehiculo> readListFromFileSer(String nombreArchivo) {
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            vehiculos = (ArrayList<Vehiculo>) ois.readObject();
        } catch (IOException e){
            e.printStackTrace();
        } 
        catch (ClassNotFoundException h){
            h.printStackTrace();
        }
        return vehiculos;
    }
     
     
     
    
    //creando el archivo que contiene las lista de vehiculos .ser



    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehiculo other = (Vehiculo) obj;
        if (this.año != other.año) {
            return false;
        }
        if (this.recorrido != other.recorrido) {
            return false;
        }
        if (Double.doubleToLongBits(this.precio) != Double.doubleToLongBits(other.precio)) {
            return false;
        }
        if (!Objects.equals(this.placa, other.placa)) {
            return false;
        }
        if (!Objects.equals(this.marca, other.marca)) {
            return false;
        }
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        if (!Objects.equals(this.tipoMotor, other.tipoMotor)) {
            return false;
        }
        if (!Objects.equals(this.color, other.color)) {
            return false;
        }
        if (!Objects.equals(this.tipoCombustible, other.tipoCombustible)) {
            return false;
        }
        if (!Objects.equals(this.tipoVehiculo, other.tipoVehiculo)) {
            return false;
        }
        if (!Objects.equals(this.nameFile, other.nameFile)) {
            return false;
        }
        return Objects.equals(this.ofertas, other.ofertas);
    }
}


