/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author francisco.vidal
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IncidenciaDAO {
    private Connection conexion;
    
    public IncidenciaDAO(){
        try{
            conexion = Conexion.getConnection();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public boolean crearIncidencia(Incidencia incidencia){
        if(incidencia == null){return false;}
        String sql = "INSERT INTO incidencias (id_empleado,descripcion,prioridad,estado,fecha_creacion,fecha_resolucion) VALUES (?,?,?,?,?,?)";
        try(PreparedStatement ps = conexion.prepareStatement(sql)){
            ps.setInt(1, incidencia.getIdEmpleado());
            ps.setString(2, incidencia.getDescripcion());
            ps.setString(3, incidencia.getPrioridad());
            ps.setString(4, incidencia.getEstado());
            ps.setDate(5,incidencia.getFecha_creacion());
            ps.setDate(6, incidencia.getFecha_resolucion());
            return ps.executeUpdate() > 0;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    public List<Incidencia> obtenerIncidencias(){
        List<Incidencia> incidencia = new ArrayList<>();
        String sql = "SELECT * FROM incidencias";
        try(PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    Incidencia p = new Incidencia();
                    p.setId(rs.getInt("id"));
                    p.setIdEmpleado(rs.getInt("id_empleado"));
                    p.setDescripcion(rs.getString("descripcion"));
                    p.setPrioridad(rs.getString("prioridad"));
                    p.setEstado(rs.getString("estado"));
                    p.setFecha_creacion(rs.getDate("fecha_creacion"));
                    p.setFecha_resolucion(rs.getDate("fecha_resolucion"));
                    incidencia.add(p);
                }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return incidencia;
    }
    
    public boolean actualizarEstadoIncidencia(Incidencia incidencia){
        String sql = "UPDATE incidencias SET estado=?,fecha_resolucion=? WHERE id=?";
        try(PreparedStatement ps = conexion.prepareStatement(sql)){
            ps.setString(1, incidencia.getEstado());
            ps.setDate(2,incidencia.getFecha_resolucion());
            ps.setInt(3, incidencia.getId());
            return ps.executeUpdate() > 0;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean eliminarIncidencia(int id){
        String sql = "DELETE FROM incidencias WHERE id=?";
        try(PreparedStatement ps = conexion.prepareStatement(sql);){
            ps.setInt(1,id);
            return ps.executeUpdate() > 0;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    public List<Incidencia> obtenerIncidenciasPorEstado(){
        List<Incidencia> incidencias = new ArrayList<>();
        String sql = "SELECT * FROM incidencias ORDER BY estado";
        try(PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    Incidencia p = new Incidencia();
                    p.setId(rs.getInt("id"));
                    p.setIdEmpleado(rs.getInt("id_empleado"));
                    p.setDescripcion(rs.getString("descripcion"));
                    p.setPrioridad(rs.getString("prioridad"));
                    p.setEstado(rs.getString("estado"));
                    p.setFecha_creacion(rs.getDate("fecha_creacion"));
                    p.setFecha_resolucion(rs.getDate("fecha_resolucion"));
                    incidencias.add(p);
                }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return incidencias;
    }
    
    
    
}
