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
public class vtipoacceso {
    private int idTipoacceso;
    private String nombrea;

    public vtipoacceso() {
    }

    public vtipoacceso(int idTipoacceso, String nombrea) {
        this.idTipoacceso = idTipoacceso;
        this.nombrea = nombrea;
    }

    public int getIdTipoacceso() {
        return idTipoacceso;
    }

    public void setIdTipoacceso(int idTipoacceso) {
        this.idTipoacceso = idTipoacceso;
    }

    public String getNombrea() {
        return nombrea;
    }

    public void setNombrea(String nombrea) {
        this.nombrea = nombrea;
    }
    
    
        
    
}
