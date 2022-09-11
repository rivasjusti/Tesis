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
public class vTipoFactura {
    private int idTipoFactura;
    private String nombrefac;

    public vTipoFactura() {
    }

    public vTipoFactura(int idTipoFactura, String nombrefac) {
        this.idTipoFactura = idTipoFactura;
        this.nombrefac = nombrefac;
    }

    public int getIdTipoFactura() {
        return idTipoFactura;
    }

    public void setIdTipoFactura(int idTipoFactura) {
        this.idTipoFactura = idTipoFactura;
    }

    public String getNombrefac() {
        return nombrefac;
    }

    public void setNombrefac(String nombrefac) {
        this.nombrefac = nombrefac;
    }
    
    
}
   