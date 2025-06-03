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
import java.util.Scanner;
import modelo.Empleado;
import java.util.InputMismatchException;

public class EmpleadosVista {
    private final Scanner ooo;
    
    public EmpleadosVista(){
        ooo = new Scanner(System.in);
    }
    
    public void mostrarMenu(){
        System.out.println("---MENU EMPLEADOS---");
        System.out.println("1. Agregar empleado");
        System.out.println("2. Mostrar empleados");
        System.out.println("3. Actualizar empleado");
        System.out.println("4. Eliminar empleado");
        System.out.println("5. Volver");
        System.out.println("Seleccione una opcion");
    }
    public Empleado capturarEmpleado(){
        try{
        System.out.println("---INSERTAR DATOS DE EMPLEADO---");
        System.out.println("Nombre:");
        String nombre = ooo.next();
        System.out.println("Email:");
        String email = ooo.next();
        
        return new Empleado(nombre,email);
        }catch(InputMismatchException e){
            ooo.nextLine();
            System.out.println("Error con los datos");
            return null;
        }
    }
    public void mostrarEmpleados(List<Empleado>empleados){
        System.out.println("---LISTA DE EMPLEADOS---");
        if(empleados.isEmpty()){
            System.out.println("No hay empleados registrados");
        }else{
            for(Empleado l : empleados){
                System.out.println("ID: "+ l.getId()+
                        ", Nombre: "+ l.getNombre()+
                        ", Email: "+ l.getEmail()
                );
            }
        }
    }
    public void mostrarEmpleadosDelStringBuilder(List<StringBuilder>empleados){
        System.out.println("---LISTA DE EMPLEADOS---");
        if(empleados.isEmpty()){
            System.out.println("No hay empleados registrados");
        }else{
            for(StringBuilder sb : empleados){
                System.out.println(sb);
            }
        }
    }
    
    public int capturarId(){
        System.out.println("Ingrese el ID del empleado(0 para cancelar): ");
        try{
            return ooo.nextInt();
        }catch(InputMismatchException e){
            System.out.println("Error, debe ser numero");
            ooo.nextLine();
        }
        return 0;
    }
    public boolean checkIdEmpleados(List<Empleado>empleados,int idToVerify){
            for(Empleado e : empleados){
                if(idToVerify == e.getId()){
                    return true;
                }
            }
            return false;
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
