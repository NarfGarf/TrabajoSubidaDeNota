/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

/**
 *
 * @author francisco.vidal
 */
import java.util.List;
import modelo.Incidencia;
import controlador.EmpleadoControlador;
import java.util.InputMismatchException;
import java.util.Scanner;



public class IncidenciasVista {
    private final Scanner ooo;
    
    public IncidenciasVista(){
    ooo = new Scanner(System.in);
    }
    
    public void mostrarMenu(){
        System.out.println("---MENU INCIDENCIAS---");
        System.out.println("1. Registrar incidencia");
        System.out.println("2. Listar todas");
        System.out.println("3. Cambiar Estado");
        System.out.println("4. Eliminar incidencia");
        System.out.println("5. Volver");
        System.out.println("Seleccione una opcion");
    }
    public Incidencia capturarIncidencia(){
        try{
            System.out.println("---INSERTAR DATOS DE INCIDENCIAS---");
            new controlador.EmpleadoControlador().mostrarEmpleado();//listar los empleados
            System.out.println("Id Empleado:");
            int idEmpleado = ooo.nextInt();
            if(!checkIdEmpleadoIsPresent(idEmpleado)){
                System.out.println("Error: id invalido");
                return null;
            }
            System.out.println("Descripcion:");
            String desc = ooo.next();
            System.out.println("Prioridad (Alta|Media|Baja): ");
            String prioridad = ooo.next();
            if(!checkPrioridad(prioridad)){
                System.out.println("Error: valor invalido");
                return null;
            }
            System.out.println("Estado (Abierta|En_proceso|Cerrada):");
            String estado = ooo.next();
            if(!checkEstado(estado)){
                System.out.println("Error: valor invalido, reemplazando con valor por defecto 'Abierta'");
                estado = "Abierta";
            }
            return new Incidencia(idEmpleado,desc,prioridad,estado);
        }catch(InputMismatchException e){
            ooo.nextLine();
            System.out.println("Error con los datos");
            return null;
        }
    }
    public Incidencia capturarEstado(){
        try{
            System.out.println("---ACTUALIZAR ESTADO---");
            System.out.println("Estado (Abierta|En_proceso|Cerrada):");
            String estado = ooo.next();
            if(!checkEstado(estado)){
                System.out.println("Error: valor invalido, reemplazando con valor 'Abierta'");
                estado = "Abierta";
            }
            return new Incidencia(estado);
        }catch(InputMismatchException e){
            ooo.nextLine();
            System.out.println("Error con los datos");
            return null;
        }
    }
    public void mostrarIncidencias(List<Incidencia>incidencias){
        System.out.println("---LISTA DE INCIDENCIAS---");
        if(incidencias.isEmpty()){
            System.out.println("No hay incidencias registradas");
        }else{
            for(Incidencia i : incidencias){
                System.out.println("ID: "+ i.getId()+
                        ", Descripcion: "+ i.getDescripcion()+
                        ", Prioridad: "+ i.getPrioridad()+
                        ", Estado: "+ i.getEstado()+
                        ", Fecha Creacion: "+i.getFecha_creacion()+
                        ", Fecha Resolucion: "+i.getFecha_resolucion()
                );
            }
        }
    }
    public void mostrarIncidenciasPorEstado(List<Incidencia>incidencias){
        System.out.println("---LISTA DE INCIDENCIAS (POR ESTADO)---");
        if(incidencias.isEmpty()){
            System.out.println("No hay incidencias registradas");
        }else{
            for(Incidencia i : incidencias){
                System.out.println("Estado: "+ i.getEstado()+
                        ", ID: "+ i.getId()+
                        ", Descripcion: "+ i.getDescripcion()+
                        ", Prioridad: "+ i.getPrioridad()+
                        ", Fecha Creacion: "+i.getFecha_creacion()+
                        ", Fecha Resolucion: "+i.getFecha_resolucion()
                );
            }
        }
    }
    
    public int capturarId(){
        System.out.println("Ingrese el ID de la incidencia(0 para cancelar): ");
        try{
            return ooo.nextInt();
        }catch(InputMismatchException e){
            System.out.println("Error, debe ser numero");
            ooo.nextLine();
        }
        return 0;
    }
    public boolean checkPrioridad(String prioridad){
        return prioridad.equalsIgnoreCase("alta")||prioridad.equalsIgnoreCase("media")||prioridad.equalsIgnoreCase("baja");
    }
    public boolean checkEstado(String estado){
        return estado.equalsIgnoreCase("abierta")||estado.equalsIgnoreCase("En_proceso")||estado.equalsIgnoreCase("cerrada");
    }
    public boolean checkIdEmpleadoIsPresent(int idToVerify){
        return new EmpleadoControlador().verificarIdEmpleado(idToVerify);
    }
    public void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }
    public int obtenerOpcion(){
        try{
            return ooo.nextInt();
        }catch(InputMismatchException e){
            ooo.nextLine();
            return 0;
        }
    }
}
