/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//package controlador;

/**
 *
 * @author francisco.vidal
 */
/*import java.util.List;
import modelo.Incidencia;
import modelo.IncidenciaDAO;
import vista.IncidenciasVista;
*/

package controlador;
import modelo.*;
import vista.*;
import java.util.List;


public class IncidenciaControlador {
    private IncidenciaDAO modelo;
    private IncidenciasVista vista;

    public IncidenciaControlador(){
        this.modelo = new IncidenciaDAO();
        this.vista = new IncidenciasVista();
    }
    
    public void iniciar(){
        int opcion;
        do{
            vista.mostrarMenu();
            opcion = vista.obtenerOpcion();
            switch(opcion){
                case 1:
                    agregarIncidencia();
                    break;
                case 2:
                    mostrarIncidencias();
                    break;
                case 3:
                    actualizarEstadoIncidencia();
                    break;
                case 4:
                    eliminarIncidencia();
                    break;
                case 5:
                    System.out.println("Saliendo de la tabla incidencias...");
                    break;
                default:
                    vista.mostrarMensaje("Opcion no valida");
            }
        }while(opcion != 5);
    }
    
    private void agregarIncidencia(){
        Incidencia incidencia = vista.capturarIncidencia();
        if(modelo.crearIncidencia(incidencia)){
            vista.mostrarMensaje("Incidencia agregado con exito");
        }else{
            vista.mostrarMensaje("Error al agregar la incidencia");
        }
    }
    private void mostrarIncidencias(){
        List<Incidencia> incidencias = modelo.obtenerIncidencias();
        vista.mostrarIncidencias(incidencias);
    }
    private void actualizarEstadoIncidencia(){
        vista.mostrarIncidencias(modelo.obtenerIncidencias());
        int id = vista.capturarId();
        if(id == 0){return;}
        Incidencia incidencia = vista.capturarEstado();
        if(incidencia == null){return;}
        incidencia.setId(id);
        if(modelo.actualizarEstadoIncidencia(incidencia)){
            vista.mostrarMensaje("Incidencia actualizado con exito");
        }else{
            vista.mostrarMensaje("Error al actualizar la incidencia");
        }
    }
    private void eliminarIncidencia(){
        vista.mostrarIncidencias(modelo.obtenerIncidencias());
        int id = vista.capturarId();
        if(id == 0){return;}
        if(modelo.eliminarIncidencia(id)){
            vista.mostrarMensaje("Incidencia eliminado con exito");
        }else{
            vista.mostrarMensaje("Error al eliminar la incidencia");
        }
    }
    public void mostrarIncidenciasPorEstado(){
        List<Incidencia> incidencias = modelo.obtenerIncidenciasPorEstado();
        vista.mostrarIncidenciasPorEstado(incidencias);
    }
}