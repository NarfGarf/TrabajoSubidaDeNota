/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author francisco.vidal
 */
public class Tecnico {
    private int id;
    private String nombreUsuario;
    private String password;
    
    public Tecnico(){}

    public Tecnico(String nombre, String email) {
        this.nombreUsuario = nombre;
        this.password = email;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getNombreUsuario() {return nombreUsuario;}
    public void setNombreUsuario(String nombreUsuario) {this.nombreUsuario = nombreUsuario;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

}
