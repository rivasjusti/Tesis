/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vdatos;

import java.util.logging.Logger;

/**
 *
 * @author Justi
 */
public class vmodelo {
    private int idModelo;
    private String modelo;
    private int cilindrada;
    private String chapa;
    private String chasis;
    private int idmarcas;

    public vmodelo() {
    }

    public vmodelo(int idModelo, String modelo, int cilindrada, String chapa, String chasis, int idmarcas) {
        this.idModelo = idModelo;
        this.modelo = modelo;
        this.cilindrada = cilindrada;
        this.chapa = chapa;
        this.chasis = chasis;
        this.idmarcas = idmarcas;
    }

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public String getChapa() {
        return chapa;
    }

    public void setChapa(String chapa) {
        this.chapa = chapa;
    }

    public String getChasis() {
        return chasis;
    }

    public void setChasis(String chasis) {
        this.chasis = chasis;
    }

    public int getIdmarcas() {
        return idmarcas;
    }

    public void setIdmarcas(int idmarcas) {
        this.idmarcas = idmarcas;
    }

    
    

   
}
