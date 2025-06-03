/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author francisco.vidal
 */
import java.util.List;
import modelo.Tecnico;
import modelo.TecnicoDAO;
import vista.TecnicosVista;

public class TecnicoControlador {
    private TecnicoDAO modelo;
    private TecnicosVista vista;

    public TecnicoControlador() {
        this.modelo = new TecnicoDAO();
        this.vista = new TecnicosVista();
    }
    public int iniciar(){
        
        boolean autenticacionCorrecta = false;
        int opcion;
        do{
            vista.mostrarMenuAutenticacion();
            opcion = vista.obtenerOpcion();
            switch(opcion){
                case 1:
                    Tecnico tecnico = vista.capturarTecnico();
                    autenticacionCorrecta = modelo.autenticacionTecnico(tecnico);
                    break;
                case 2:
                    vista.mostrarMensaje("Saliendo...");
                    break;
                default:
                    vista.mostrarMensaje("opcion no valida");
            }
        }while(!autenticacionCorrecta && opcion != 2);
        return opcion;
    }
    
}

