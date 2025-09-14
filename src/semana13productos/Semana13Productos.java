/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package semana13productos;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Cristofer
 */
public class Semana13Productos {

    public static void mostrarMenu(){
        System.out.println("1. Agregar producto\n2. Pagar\n3. Salir\"");
        System.out.print("Seleccione una opcion: ");
    }
    
  
   
    static int leerOpcion(Scanner sc) {
        try {
            return sc.nextInt();
        } catch (InputMismatchException e) {
            sc.nextLine(); 
            return -1; 
        }}
    
    
    
    static void agregarProducto(List<Double> carrito, double precio) {
        if (precio > 0) {
            carrito.add(precio);
            System.out.println("Producto agregado. Total de productos: " + carrito.size());
        } else {
            System.out.println("El precio debe ser mayor a 0.");
        }}
    
    
    
     static double total(List<Double> carrito, double imp) {
        int suma = 0;
        for (double precio : carrito) {
            suma += precio;
        }
        return suma * imp;}
     
     
     
    static void confirmarCompra(Scanner sc, double total) {
        System.out.println("colocar su correo>: ");
        String correo = sc.nextLine();
        System.out.println("El total que se enviara a su correo: " + correo + " es $" + String.format("%.2f", total));
        System.out.println("Si esta de acuerdo presione la opcion 3 para salir");
    }
    
   
    
    static void  pagar(List<Double> carrito, Scanner sc){
        System.out.print("\nIngrese su nombre: ");
        sc.nextLine();
        String nombre = sc.nextLine();
        double impuesto = total(carrito, 0.14);
        double subtotal = impuesto/0.14;
        double total = impuesto+subtotal;
        
        System.out.println("\n--- RESUMEN DE COMPRA Sr " + nombre);
        System.out.println("Productos en carrito: " + carrito.size());
        System.out.println("Subtotal: $" + String.format("%.2f", subtotal));
        System.out.println("IVA (14%): $" + String.format("%.2f", impuesto));
        System.out.println("TOTAL: $" + String.format("%.2f",total));
        confirmarCompra(sc, total);
        System.out.println();
        
    }
    
    
    public static void main(String[] args) {
        List<Double> carrito = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int option;
        do {
        mostrarMenu();
        option = leerOpcion(sc);
        
        switch (option) {
            case (1):
                System.out.print("ingresa un producto: ");
                double precio = sc.nextDouble();
                agregarProducto(carrito, precio);
                break;
            case (2):
                if (!carrito.isEmpty()) {
                        pagar(carrito, sc);
                        carrito.clear();
                    } else {
                        System.out.println("El carrito esta vacio. Agregue productos primero.");
                    }
                    break;
           case (3):
                System.out.println("Gracias por tu compra");
                break;
           default:
                System.out.println("Opcion invalida. Intente nuevamente.");
            }
        } while (option != 3);
        
        sc.close();
    
       
    }
           
    }
    

