/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectoprueba;



/**
 *
 * @author JOSUE
 */
public class Camioneta extends Vehiculo {
    private int numVidrios;
    private String transmision;
    private String traccion;

    public Camioneta(int numVidrios, String transmision, String traccion, String placa, String marca, String modelo, String tipoMotor, String color, String tipoCombustible, int año, int recorrido, double precio, String tipoVehiculo, String nameFile) {
        super(placa, marca, modelo, tipoMotor, color, tipoCombustible, año, recorrido, precio, tipoVehiculo, nameFile);
        this.numVidrios = numVidrios;
        this.transmision = transmision;
        this.traccion = traccion;
    }




    public int getNumVidrios() {
        return numVidrios;
    }

    public void setNumVidrios(int numVidrios) {
        this.numVidrios = numVidrios;
    }

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }

    public String getTraccion() {
        return traccion;
    }

    public void setTraccion(String traccion) {
        this.traccion = traccion;
    }

    @Override
    public String toString() {
        return "Camioneta{" + "numVidrios=" + numVidrios + ", transmision=" + transmision + ", traccion=" + traccion + '}';
    }
   
    
    
}
