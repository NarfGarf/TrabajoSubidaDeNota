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
import modelo.Empleado;
import modelo.EmpleadoDAO;
import vista.EmpleadosVista;

public class EmpleadoControlador {
    private EmpleadoDAO modelo;
    private EmpleadosVista vista;

    public EmpleadoControlador() {
        this.modelo = new EmpleadoDAO();
        this.vista = new EmpleadosVista();
    }
    public void iniciar(){
        
        int opcion;
        do{
            vista.mostrarMenu();
            opcion = vista.obtenerOpcion();
            switch(opcion){
                case 1:
                    agregarEmpleado();
                    break;
                case 2:
                    mostrarEmpleado();
                    break;
                case 3:
                    actualizarEmpleado();
                    break;
                case 4:
                    eliminarEmpleado();
                    break;
                case 5:
                    System.out.println("Saliendo de la tabla empleados...");
                    break;
                default:
                    vista.mostrarMensaje("Opcion no valida");
            }
        }while(opcion != 5);
    }
    
    private void agregarEmpleado(){
        Empleado empleado = vista.capturarEmpleado();
        if(modelo.crearEmpleado(empleado)){
            vista.mostrarMensaje("Empleado agregado con exito");
        }else{
            vista.mostrarMensaje("Error al agregar el empleado");
        }
    }
    public void mostrarEmpleado(){
        List<Empleado> empleados = modelo.obtenerEmpleados();
        vista.mostrarEmpleados(empleados);
    }
    private void actualizarEmpleado(){
        vista.mostrarEmpleados(modelo.obtenerEmpleados());
        int id = vista.capturarId();
        if(id == 0){return;}
        Empleado empleado = vista.capturarEmpleado();
        if(empleado == null){return;}
        empleado.setId(id);
        if(modelo.actualizarEmpleado(empleado)){
            vista.mostrarMensaje("Empleado actualizado con exito");
        }else{
            vista.mostrarMensaje("Error al actualizar el empleado");
        }
    }
    private void eliminarEmpleado(){
        vista.mostrarEmpleados(modelo.obtenerEmpleados());
        int id = vista.capturarId();
        if(id == 0){return;}
        if(modelo.eliminarEmpleado(id)){
            vista.mostrarMensaje("Empleado eliminado con exito");
        }else{
            vista.mostrarMensaje("Error al eliminar el empleado");
        }
    }
    public void mostrarHistorialDeEmpleado(){
        int idEmpleado = vista.capturarId();
        if(!verificarIdEmpleado(idEmpleado)){
            vista.mostrarMensaje("Error: id invalida");
            return;
        }
        List<StringBuilder> empleados = modelo.obtenerHistorialDeEmpleado(idEmpleado);
        vista.mostrarEmpleadosDelStringBuilder(empleados);
    }
    public boolean verificarIdEmpleado(int idToVerify){
        List<Empleado> empleados = modelo.obtenerEmpleados();
        return vista.checkIdEmpleados(empleados,idToVerify);
    }
    public void mostrarInformes(){
        List<StringBuilder> informes = modelo.obtenerInformes();
        vista.mostrarInformes(informes);
    }
}

