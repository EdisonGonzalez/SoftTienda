package tiendasoft;

import java.util.Scanner;

public class TiendaSoft {
    //Variables estaticas para ingresar a la función principal
    static Producto arreglo[] = new Producto[256];
    static Scanner Lector = new Scanner(System.in);
    static int n=256,k=0,pos=0,c=0,pos_venta,cant_venta,cant_new,sel;
    static String nombre;
    static double Ventas_Totales=0;

    //Funciones para Agregar, buscar, eliminar y mostrar producto.
    //Adicional se tiene un sistema contable capaz de realizar ventas y mostrar ganancias totales
    
    static void agregar(int pos){
        if (pos<256){
            arreglo[pos].CreateProduct();
            pos++;
        }
        else {
            System.out.println("Su lista de productos se encuentra completa (256 productos)");
        }
    }
    
    static int buscar(String nombre){
        int i=0;
        while (i<n){
            if (nombre.equals(arreglo[i].getNombre())){
                System.out.println("En su lista de productos, este producto ocupa el lugar numero: "+i);
                arreglo[i].ShowProduct();
                k=1;
            }
            else if((i==256)&&(k==0)){
                System.out.println("Este producto no existe en el inventario o digite correctamente su nombre");
                k=0;
            }   
            else{
                i++;
            }
        }
        return i;
    }
    
    static void eliminar(String nombre){
        int i=0;
        while (i<n){
            if (nombre.equals(arreglo[i].getNombre())){
                System.out.println("Se elimino de su lista de productos, el producto que ocupa el lugar numero: "+i);
                arreglo[i]=null;
                k++;
            }
            else if((i==256)&&(k==0)){
                System.out.println("Este producto no existe en el inventario o digite correctamente su nombre");
                k=0;
            }   
            else{
                i++;
            }
        }
    }
    
    static void ShowInventory(){
        System.out.println("Lista de productos.");
        for(c=0;c<=pos;c++){
            System.out.println("\n"+(c+1)+". ");
            arreglo[c].ShowProduct();
        }
        c=0;
    }
    
    static void ventas(){
        System.out.println("Ingrese el nombre del producto");
        nombre=Lector.next();
        pos_venta=buscar(nombre);
        if(pos_venta<256){
            System.out.println("\nEl valor del producto es:"+arreglo[pos_venta].getValor());
            System.out.println("Ingrese la cantidad del producto que desea vender");
            cant_venta=Lector.nextInt();
            arreglo[pos_venta].setCantidad_venta(cant_venta);
            if(cant_venta<=arreglo[pos_venta].getCantidad()){
                cant_new=arreglo[pos_venta].getCantidad()-arreglo[pos_venta].getCantidad_venta();
                arreglo[pos_venta].setCantidad(cant_new);
                System.out.println("Ahora la cantidad de este producto es: "+arreglo[pos_venta].getCantidad());
            }
            else{
                System.out.println("La cantidad deseada es mayor, la cantidad de este producto es: "+arreglo[pos_venta].getCantidad());
            }
        }
        else{
            System.out.println("Su producto no fue encontrado, verifique el nombre digitado");
        }
    }
    
    static void Show_Gain_Total(){
        for(c=0;c<=pos;c++){
            arreglo[c].Show_Ventas();
            Ventas_Totales=Ventas_Totales+arreglo[c].getValor_total_venta();
        }
        c=0;
        System.out.println("\nY LAS VENTAS TOTALES (TODOS LOS PRODUCTOS) SON: $"+Ventas_Totales);
        Ventas_Totales=0;
    }
     
    
    public static void main(String[] args) {
        
        do {
            System.out.println("Bienvenido a TiendaSoft");
            System.out.println("Por favor ingrese una de las siguientes opciones según su necesidad:");
            System.out.println("\n1.Agregar Producto.\n2.Buscar Producto.\n3.Eliminar Producto."
                    + "\n4.Mostrar Inventario.\n5.Realizar Venta.\n6.Mostrar Ganancias Totales.\n7.Salir.");
            sel=Lector.nextInt();
        
            switch(sel){
                case 1:
                    
                break;
                case 2:
                    
                break;
                case 3:
                    
                break;
                case 4:
                    
                break;
                case 5:
                    
                break;
                case 6:
                    
                break;
                case 7:
                    
                break;
                default:
                    System.out.println("El valor ingresado fue incorrecto, ingrese nuevamente");
                    sel=1;
                break;
            }
        } while (sel != 0);
    }
