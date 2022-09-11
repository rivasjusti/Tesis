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
//lo que usa el empleado del local 
public class vtrabajador {
    
    private int idtipotrabajador;
    private String nombretra;
    private String apellidotra;
    private String direciontra;
    private String telefonotra;
    private String numerodocumento;
    private String login;
   private String password;
   private int idestado;
   private int idTipoaceso;
   private int idDepartamento;

    public vtrabajador() {
    }

    public vtrabajador(int idtipotrabajador, String nombretra, String apellidotra, String direciontra, String telefonotra, String numerodocumento, String login, String password, int idestado, int idTipoaceso, int idDepartamento) {
        this.idtipotrabajador = idtipotrabajador;
        this.nombretra = nombretra;
        this.apellidotra = apellidotra;
        this.direciontra = direciontra;
        this.telefonotra = telefonotra;
        this.numerodocumento = numerodocumento;
        this.login = login;
        this.password = password;
        this.idestado = idestado;
        this.idTipoaceso = idTipoaceso;
        this.idDepartamento = idDepartamento;
    }

    public int getIdtipotrabajador() {
        return idtipotrabajador;
    }

    public void setIdtipotrabajador(int idtipotrabajador) {
        this.idtipotrabajador = idtipotrabajador;
    }

    public String getNombretra() {
        return nombretra;
    }

    public void setNombretra(String nombretra) {
        this.nombretra = nombretra;
    }

    public String getApellidotra() {
        return apellidotra;
    }

    public void setApellidotra(String apellidotra) {
        this.apellidotra = apellidotra;
    }

    public String getDireciontra() {
        return direciontra;
    }

    public void setDireciontra(String direciontra) {
        this.direciontra = direciontra;
    }

    public String getTelefonotra() {
        return telefonotra;
    }

    public void setTelefonotra(String telefonotra) {
        this.telefonotra = telefonotra;
    }

    public String getNumerodocumento() {
        return numerodocumento;
    }

    public void setNumerodocumento(String numerodocumento) {
        this.numerodocumento = numerodocumento;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdestado() {
        return idestado;
    }

    public void setIdestado(int idestado) {
        this.idestado = idestado;
    }

    public int getIdTipoaceso() {
        return idTipoaceso;
    }

    public void setIdTipoaceso(int idTipoaceso) {
        this.idTipoaceso = idTipoaceso;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
   

    
}
