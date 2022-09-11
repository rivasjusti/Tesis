/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vdatos;

/**
 *
 * @author Justi
 */
public class vaccesorios {
    
    private int idAccesorios;
    private String  codigoaccesorios;
    private String Nombreacc;
    private String marcaacc;
    private int cantidadacc;
    private int precioacc;

    public vaccesorios() {
    }

    public vaccesorios(int idAccesorios, String codigoaccesorios, String Nombreacc, String marcaacc, int cantidadacc, int precioacc) {
        this.idAccesorios = idAccesorios;
        this.codigoaccesorios = codigoaccesorios;
        this.Nombreacc = Nombreacc;
        this.marcaacc = marcaacc;
        this.cantidadacc = cantidadacc;
        this.precioacc = precioacc;
    }

    public int getIdAccesorios() {
        return idAccesorios;
    }

    public void setIdAccesorios(int idAccesorios) {
        this.idAccesorios = idAccesorios;
    }

    public String getCodigoaccesorios() {
        return codigoaccesorios;
    }

    public void setCodigoaccesorios(String codigoaccesorios) {
        this.codigoaccesorios = codigoaccesorios;
    }

    public String getNombreacc() {
        return Nombreacc;
    }

    public void setNombreacc(String Nombreacc) {
        this.Nombreacc = Nombreacc;
    }

    public String getMarcaacc() {
        return marcaacc;
    }

    public void setMarcaacc(String marcaacc) {
        this.marcaacc = marcaacc;
    }

    public int getCantidadacc() {
        return cantidadacc;
    }

    public void setCantidadacc(int cantidadacc) {
        this.cantidadacc = cantidadacc;
    }

    public int getPrecioacc() {
        return precioacc;
    }

    public void setPrecioacc(int precioacc) {
        this.precioacc = precioacc;
    }

  
    
    
    
}
