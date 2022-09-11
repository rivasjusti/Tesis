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
public class vdepartamento {
    private int idDepartamento;
    private String nombredepa;
    private String barriodepa;
    private int idPais;

    public vdepartamento() {
    }

    public vdepartamento(int idDepartamento, String nombredepa, String barriodepa, int idPais) {
        this.idDepartamento = idDepartamento;
        this.nombredepa = nombredepa;
        this.barriodepa = barriodepa;
        this.idPais = idPais;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNombredepa() {
        return nombredepa;
    }

    public void setNombredepa(String nombredepa) {
        this.nombredepa = nombredepa;
    }

    public String getBarriodepa() {
        return barriodepa;
    }

    public void setBarriodepa(String barriodepa) {
        this.barriodepa = barriodepa;
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

   

   

   
    
    
}
