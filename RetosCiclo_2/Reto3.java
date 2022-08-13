package Reto3;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;
/*
* Recomendaciones Generales:
*
*    -> El método run() funcionará como nuestro método principal
*    -> No declarar objetos de tipo Scanner, utilizar el método read() para solicitar datos al usuario.
*    -> Si requiere utilizar varias clases, estas NO deben ser tipo public.
*/
class Reto3{

    /**
    *  Este debe ser el único objeto de tipo Scanner en el código
    */
    private final Scanner scanner = new Scanner(System.in);

    /**
    * Este método es usado para solicitar datos al usuario
    * @return  Lectura de la siguiente linea del teclado
    */
    public String read(){
        return this.scanner.nextLine();
    }

    /**
    * método principal
    */
    public void run(){
        /*
        solución propuesta
        */
        BaseDatosProductos listaProductos = new BaseDatosProductos();
        String operacion = read();
        String[] entrada = read().split(" ");
        
        Producto p = new Producto(Integer.parseInt(entrada[0]), entrada[1], Double.parseDouble(entrada[2]), Integer.parseInt(entrada[3]));
        
        if (operacion.equals("AGREGAR") && !listaProductos.verificarExistencia(p)){
            listaProductos.agregar(p);
            listaProductos.generarInforme();
        }
        
        else if (operacion.equals("BORRAR") && listaProductos.verificarExistencia(p)){
            listaProductos.eliminar(p);
            listaProductos.generarInforme();
        }
        
        else if (operacion.equals("ACTUALIZAR") && listaProductos.verificarExistencia(p)){
            listaProductos.actualizar(p);
            listaProductos.generarInforme();
        }
        
        else{
            System.out.println("ERROR");
        }
    }
}

class Producto {
    private int codigo;
    private String nombre;
    private double precio;
    private int inventario;
    
    public Producto(int codigo, String nombre, double precio, int inventario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.inventario = inventario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getInventario() {
        return inventario;
    }

    public void setInventario(int inventario) {
        this.inventario = inventario;
    }
}

class BaseDatosProductos {
    private HashMap<Integer, Producto> listaProductos = new HashMap<>();
    
    public BaseDatosProductos(){
        listaProductos.put(1, new Producto(1, "Manzanas", 5000.0, 25));
        listaProductos.put(2, new Producto(2, "Limones", 2300.0, 15));
        listaProductos.put(3, new Producto(3, "Peras", 2700.0, 33));
        listaProductos.put(4, new Producto(4, "Arandanos", 9300.0, 5));
        listaProductos.put(5, new Producto(5, "Tomates", 2100.0, 42));
        listaProductos.put(6, new Producto(6, "Fresas", 4100.0, 3));
        listaProductos.put(7, new Producto(7, "Helado", 4500.0, 41));
        listaProductos.put(8, new Producto(8, "Galletas", 500.0, 8));
        listaProductos.put(9, new Producto(9, "Chocolates", 3500.0, 80));
        listaProductos.put(10, new Producto(10, "Jamon", 15000.0, 10));
    }
    
    public void agregar(Producto p){
        listaProductos.put(p.getCodigo(), p);
    }
    
    public void eliminar(Producto p){
        listaProductos.remove(p.getCodigo());
    }
    
    public void actualizar(Producto p){
        listaProductos.replace(p.getCodigo(), p);
    }
    
    public boolean verificarExistencia(Producto p){
        return listaProductos.containsKey(p.getCodigo());
    }
    
    /**
     * Compara uno tras otro el precio de cada producto tomando el primero como el menor
     * @return nombre del producto con menor precio 
     */
    public String  precioMenor(){
        String nombre = ((Producto) listaProductos.values().toArray()[0]).getNombre();
        double precio = ((Producto) listaProductos.values().toArray()[0]).getPrecio();
        
        for(Producto p: listaProductos.values()){
            if(p.getPrecio() < precio){
                nombre = p.getNombre();
                precio = p.getPrecio();
            }
        }
        return nombre;
    }
    
    public String  precioMayor(){
        String nombre = ((Producto) listaProductos.values().toArray()[0]).getNombre();
        double precio = ((Producto) listaProductos.values().toArray()[0]).getPrecio();

        for(Producto p: listaProductos.values()){
            if(p.getPrecio() > precio){
                nombre = p.getNombre();
                precio = p.getPrecio();
            }
        }
        return nombre;
    }
    
    public double promedioPrecios(){
        double suma = 0;
        
        for(Producto p: listaProductos.values()){
            suma += p.getPrecio();
        }
        return suma/listaProductos.size();
    }
    
    public void generarInforme(){
        System.out.println(precioMayor() + " " + precioMenor() + " " + String.format("%.1f", promedioPrecios()));
    }
}
