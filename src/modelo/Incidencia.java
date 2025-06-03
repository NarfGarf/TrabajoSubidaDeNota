/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;
import java.sql.Date;
/**
 *
 * @author francisco.vidal
 */
public class Incidencia {
    private int id;
    private int idEmpleado;
    private String descripcion;
    private String prioridad;
    private String estado;
    private Date fecha_creacion;
    private Date fecha_resolucion;
    
    public Incidencia(){}
    public Incidencia(String estado){
        this.estado = estado;
        if (estado.equalsIgnoreCase("Cerrada")){
            this.fecha_resolucion= Date.valueOf(LocalDate.now());
        }else{
            this.fecha_resolucion = null;
        }
    }

    public Incidencia(int idEmpleado,String descripcion, String prioridad, String estado) {
        this.idEmpleado = idEmpleado;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.estado = estado;
        this.fecha_creacion = Date.valueOf(LocalDate.now());
        if (estado.equalsIgnoreCase("Cerrada")){
            this.fecha_resolucion= Date.valueOf(LocalDate.now());
        }
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public int getIdEmpleado() {return idEmpleado;}
    public void setIdEmpleado(int idEmpleado) {this.idEmpleado = idEmpleado;}

    public String getDescripcion() {return descripcion;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

    public String getPrioridad() {return prioridad;}
    public void setPrioridad(String prioridad) {this.prioridad = prioridad;}

    public String getEstado() {return estado;}
    public void setEstado(String estado) {this.estado = estado;}

    public Date getFecha_creacion() {return fecha_creacion;}
    public void setFecha_creacion(Date fecha_creacion) {this.fecha_creacion = fecha_creacion;}
    
    public Date getFecha_resolucion() {return fecha_resolucion;}
    public void setFecha_resolucion(Date fecha_resolucion) {this.fecha_resolucion = fecha_resolucion;}

}
