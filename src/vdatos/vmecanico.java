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
public class vmecanico {
    private int idmecanico;
    private String nombremeca;
    private String apellidomeca;
    private String direccionmeca;

    public vmecanico() {
    }

    public vmecanico(int idmecanico, String nombremeca, String apellidomeca, String direccionmeca) {
        this.idmecanico = idmecanico;
        this.nombremeca = nombremeca;
        this.apellidomeca = apellidomeca;
        this.direccionmeca = direccionmeca;
    }

    public int getIdmecanico() {
        return idmecanico;
    }

    public void setIdmecanico(int idmecanico) {
        this.idmecanico = idmecanico;
    }

    public String getNombremeca() {
        return nombremeca;
    }

    public void setNombremeca(String nombremeca) {
        this.nombremeca = nombremeca;
    }

    public String getApellidomeca() {
        return apellidomeca;
    }

    public void setApellidomeca(String apellidomeca) {
        this.apellidomeca = apellidomeca;
    }

    public String getDireccionmeca() {
        return direccionmeca;
    }

    public void setDireccionmeca(String direccionmeca) {
        this.direccionmeca = direccionmeca;
    }
    
    
    
}
