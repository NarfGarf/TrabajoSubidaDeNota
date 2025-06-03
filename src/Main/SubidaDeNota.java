/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

/**
 *
 * @author francisco.vidal
 */
import controlador.IncidenciaControlador;
import controlador.EmpleadoControlador;
import controlador.TecnicoControlador;
import java.util.Scanner;
import java.util.InputMismatchException;

public class SubidaDeNota {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner ooo = new Scanner(System.in);
        
        int earlyExit = new TecnicoControlador().iniciar();// inicio de sesion
        int seleccion=0;
            do{
                try{
                    if(earlyExit == 2){break;}
                    System.out.println("En que tabla quieres trabajar?");
                    System.out.println("1. Gestionar Empleados");
                    System.out.println("2. Gestionar Incidencias");
                    System.out.println("3. Ver Incidencias por Estado");
                    System.out.println("4. Ver Historial de un Empleado");
                    System.out.println("5. Ver Informes Generales");
                    System.out.println("6. Cerrar Sesion");
                    seleccion = ooo.nextInt();
                    switch(seleccion){
                        case 1:// tabla empleados
                            new EmpleadoControlador().iniciar();
                            break;
                        case 2:// tabla incidencias
                            new IncidenciaControlador().iniciar();
                            break;
                        case 3:// mostrar incidencias por estado
                            new IncidenciaControlador().mostrarIncidenciasPorEstado();
                            break;
                        case 4:// mostrar historial de un empleado
                            new EmpleadoControlador().mostrarHistorialDeEmpleado();
                            break;
                        case 5:// mostrar informes generales de todos los empleados
                            new EmpleadoControlador().mostrarInformes();
                            break;
                        case 6:
                            System.out.println("Cerrando Sesion...");
                            break;
                        default:
                            System.out.println("Error: seleccion desconocida");
                            break;
                    }
                }catch(InputMismatchException e){
                    System.out.println("Error: dato invalido (debe ser un numero)");
                    ooo.nextLine();
                }
            }while(seleccion != 6 && earlyExit != 2);
                
        
    }
}
