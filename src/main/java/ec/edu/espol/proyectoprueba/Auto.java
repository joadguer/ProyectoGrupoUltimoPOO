/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectoprueba;



/**
 *
 * @author JOSUE
 */
public class Auto extends Vehiculo{
    private int vidrio;
    private String transmision;

    public Auto(int vidrio, String transmision, String placa, String marca, String modelo, String tipoMotor, String color, String tipoCombustible, int año, int recorrido, double precio, String tipoVehiculo, String nameFile) {
        super(placa, marca, modelo, tipoMotor, color, tipoCombustible, año, recorrido, precio, tipoVehiculo, nameFile);
        this.vidrio = vidrio;
        this.transmision = transmision;
    }
    
    




    public int getVidrio() {
        return vidrio;
    }

    public void setVidrio(int vidrio) {
        this.vidrio = vidrio;
    }

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }

    @Override
    public String toString() {
        return "Auto{" + "vidrio=" + vidrio + ", transmision=" + transmision + '}';
    }
    
    
    

    
}
