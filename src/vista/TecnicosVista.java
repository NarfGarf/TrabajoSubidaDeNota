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
import modelo.Tecnico;
import java.util.InputMismatchException;

public class TecnicosVista {
    private final Scanner ooo;
    
    public TecnicosVista(){
        ooo = new Scanner(System.in);
    }
    
    public void mostrarMenuAutenticacion(){
        System.out.println("---MENU---");
        System.out.println("1. Iniciar Sesion");
        System.out.println("2. Salir");
        System.out.println("Seleccione una opcion");
    }
    public Tecnico capturarTecnico(){
        try{
        System.out.println("Nombre Usuario:");
        String nombreUsuario = ooo.next();
        System.out.println("Password:");
        String password = ooo.next();
        
        return new Tecnico(nombreUsuario,password);
        }catch(InputMismatchException e){
            ooo.nextLine();
            System.out.println("Error con los datos");
            return null;
        }
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
