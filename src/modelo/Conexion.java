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
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/subidanota";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static Connection conn = null;
    private static final Logger logger = Logger.getLogger(Conexion.class.getName());

    private Conexion(){}
    
    public static Connection getConnection() throws SQLException{
        try{
            if(conn == null || conn.isClosed()){
                conn = establecerConexion();
                logger.log(Level.INFO,"Conexion establecida correctamente");
            }
        }catch(SQLException e){
            logger.log(Level.SEVERE,"Error al establecer conexion",e);
            throw new SQLException("No se pudo establecer la conexion a la base de datos",e);
        }
        return conn;
    }
    
    private static Connection establecerConexion() throws SQLException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
            
            connection.setAutoCommit(true);
            return connection;
        }catch(ClassNotFoundException e){
            logger.log(Level.SEVERE,"Driver JDBC no encontrado", e);
            throw new SQLException("Driver JDBC no encontrado",e);
        }catch(SQLException e){
            logger.log(Level.SEVERE,"Error al conectar con la base de datos",e);
            throw e;
        }
    }
    
    public static void cerrarConexion(){
        if(conn != null){
            try{
                if(!conn.isClosed()){
                    conn.close();
                    logger.log(Level.INFO,"Conexion cerrada correctamente");
                }
            }catch(SQLException e){
                logger.log(Level.WARNING,"Error al cerrar la conexion",e);
            }finally{
                conn = null;
            }
        }
    }
    
    public static boolean verificarConexion(){
        try{
            return conn != null && !conn.isClosed() && conn.isValid(2);
        }catch(SQLException e){
            logger.log(Level.WARNING,"Error al verificar conexion",e);
            return false;
        }
    }
}
