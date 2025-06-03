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
import java.lang.NullPointerException;

public class EmpleadoDAO {
    private Connection conexion;
    
    public EmpleadoDAO(){
        try{
            conexion = Conexion.getConnection();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public boolean crearEmpleado(Empleado empleado){
        if(empleado == null){return false;}
        String sql = "INSERT INTO empleados (nombre,email) VALUES (?,?)";
        try(PreparedStatement ps = conexion.prepareStatement(sql)){
            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getEmail());
            return ps.executeUpdate() > 0;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    public List<Empleado> obtenerEmpleados(){
        List<Empleado> empleados = new ArrayList<>();
        String sql = "SELECT * FROM empleados";
        try(PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    Empleado p = new Empleado();
                    p.setId(rs.getInt("id"));
                    p.setNombre(rs.getString("nombre"));
                    p.setEmail(rs.getString("email"));
                    empleados.add(p);
                }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return empleados;
    }
    
    public boolean actualizarEmpleado(Empleado empleado){
        String sql = "UPDATE empleados SET nombre=?,email=? WHERE id=?";
        try(PreparedStatement ps = conexion.prepareStatement(sql)){
            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getEmail());
            ps.setInt(3, empleado.getId());
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
    public List<StringBuilder> obtenerHistorialDeEmpleado(int idEmpleadoForSQL){
        List<StringBuilder> empleados = new ArrayList<>();
        String sql = "SELECT * FROM empleados INNER JOIN incidencias ON incidencias.id_empleado = empleados.id WHERE empleados.id=?";
        try(PreparedStatement ps = conexion.prepareStatement(sql)){
            ps.setInt(1,idEmpleadoForSQL);
            ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    StringBuilder sb = new StringBuilder();
                    sb.append(Integer.toString(rs.getInt("empleados.id"))).append(" ");
                    sb.append(rs.getString("nombre")).append(" ");
                    sb.append(rs.getString("email")).append(" ");
                    sb.append(Integer.toString(rs.getInt("incidencias.id"))).append(" ");
                    sb.append(rs.getString("descripcion")).append(" ");
                    sb.append(rs.getString("prioridad")).append(" ");
                    sb.append(rs.getString("estado")).append(" ");
                    sb.append(rs.getDate("fecha_creacion").toString()).append(" ");
                    try{
                        sb.append(rs.getDate("fecha_resolucion").toString());
                    }catch(NullPointerException e){
                        sb.append("null");
                    }
                    empleados.add(sb);
                }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return empleados;
    }
    public List<StringBuilder> obtenerInformes(){
        List<StringBuilder> informes = new ArrayList<>();
        String sql = "SELECT * FROM empleados INNER JOIN incidencias ON incidencias.id_empleado = empleados.id";// gotta change this probably
        try(PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    StringBuilder sb = new StringBuilder();
                    sb.append(Integer.toString(rs.getInt("empleados.id"))).append(" ");
                    sb.append(rs.getString("nombre")).append(" ");
                    sb.append(rs.getString("email")).append(" ");
                    sb.append(Integer.toString(rs.getInt("incidencias.id"))).append(" ");
                    sb.append(rs.getString("descripcion")).append(" ");
                    sb.append(rs.getString("prioridad")).append(" ");
                    sb.append(rs.getString("estado")).append(" ");
                    sb.append(rs.getDate("fecha_creacion").toString()).append(" ");
                    try{
                        sb.append(rs.getDate("fecha_resolucion").toString());
                    }catch(NullPointerException e){
                        sb.append("null");
                    }
                    informes.add(sb);
                }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return informes;
    }
}
