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

public class TecnicoDAO {
    private Connection conexion;
    
    public TecnicoDAO(){
        try{
            conexion = Conexion.getConnection();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public boolean autenticacionTecnico(Tecnico tecnico){
        String sql = "SELECT * FROM tecnicos";
        try(PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    if(tecnico.getNombreUsuario().equalsIgnoreCase(rs.getString("nombre_usuario"))&&
                            tecnico.getPassword().equalsIgnoreCase(rs.getString("password"))){
                        return true;
                    }
                }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean crearTecnico(Tecnico tecnico){
        if(tecnico == null){return false;}
        String sql = "INSERT INTO tecnicos (nombre_usuario,password) VALUES (?,?)";
        try(PreparedStatement ps = conexion.prepareStatement(sql)){
            ps.setString(1, tecnico.getNombreUsuario());
            ps.setString(2, tecnico.getPassword());
            return ps.executeUpdate() > 0;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    public List<Tecnico> obtenerEmpleados(){
        List<Tecnico> empleados = new ArrayList<>();
        String sql = "SELECT * FROM tecnicos";
        try(PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    Tecnico t = new Tecnico();
                    t.setId(rs.getInt("id"));
                    t.setNombreUsuario(rs.getString("nombre_usuario"));
                    t.setPassword(rs.getString("password"));
                    empleados.add(t);
                }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return empleados;
    }
    
    public boolean actualizarEmpleado(Tecnico tecnico){
        String sql = "UPDATE tecnicos SET nombre=?,email=? WHERE id=?";
        try(PreparedStatement ps = conexion.prepareStatement(sql)){
            ps.setString(1, tecnico.getNombreUsuario());
            ps.setString(2, tecnico.getPassword());
            ps.setInt(3, tecnico.getId());
            return ps.executeUpdate() > 0;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean eliminarEmpleado(int id){
        String sql = "DELETE FROM empleados WHERE id=?";
        try(PreparedStatement ps = conexion.prepareStatement(sql);){
            ps.setInt(1,id);
            return ps.executeUpdate() > 0;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}
