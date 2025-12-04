
package com.airpot.airport.t1poo.entidades;


public class Usuario {
    private int id_usuario;
    private String username;
    private String password;
    private String nombre;
    private boolean activo;

    public Usuario() {}

    public Usuario(int id_usuario, String username, String password, String nombre, boolean activo) {
        this.id_usuario=id_usuario;
        this.username = username;
        this.password = password;
        this.nombre=nombre;
        this.activo=activo;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    @Override
    public String toString() {
        return "Usuario{" + "username=" + username + ", password=" + password + ", nombre=" + nombre + ", activo=" + activo + '}';
    }


}
