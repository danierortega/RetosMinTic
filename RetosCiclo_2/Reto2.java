import java.util.Scanner;
import java.util.HashMap;

/*
* Recomendaciones Generales:
*
*    -> El método run() funcionará como nuestro método principal
*    -> No declarar objetos de tipo Scanner, utilizar el método read() para solicitar datos al usuario.
*    -> Si requiere utilizar varias clases, estas NO deben ser tipo public.
*/
public class Reto2 {
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
        BaseDatosProducto ListaProductos = new BaseDatosProducto();
        
        String operacion = read();
        String[] input = read().split(" ");
        
        Producto producto = new Producto(Integer.parseInt(input[0]),input[1],
                                        Double.parseDouble(input[2]),
                                        Integer.parseInt(input[3]));
        
        if("AGREGAR".equals(operacion) && (!ListaProductos.VerificarExistencia(producto))){
            ListaProductos.Agregar(producto);
            ListaProductos.Informe();
        }
        else if("BORRAR".equals(operacion) && (ListaProductos.VerificarExistencia(producto))){
            ListaProductos.Borrar(producto);
            ListaProductos.Informe();
        }
        else if("ACTUALIZAR".equals(operacion) && (ListaProductos.VerificarExistencia(producto))){
            ListaProductos.Actualizar(producto);
            ListaProductos.Informe();
        }
        else{
            System.out.println("ERROR");
        }
    }
}

class BaseDatosProducto{
    private HashMap<Integer, Producto> ListaProductos = new HashMap <Integer, Producto>();

    public BaseDatosProducto() {
        
        
        ListaProductos.put(1, new Producto(1, "Manzanas", 5000.0, 25));
        ListaProductos.put(2, new Producto(2, "Limones", 2300.0, 15));
        ListaProductos.put(3, new Producto(3, "Peras", 2700.0, 33));
        ListaProductos.put(4, new Producto(4, "Arandanos", 9300.0, 5));
        ListaProductos.put(5, new Producto(5, "Tomates", 2100.0, 42));
        ListaProductos.put(6, new Producto(6, "Fresas", 4100.0, 3));
        ListaProductos.put(7, new Producto(7, "Helado", 4500.0, 41));
        ListaProductos.put(8, new Producto(8, "Galletas", 500.0, 8));
        ListaProductos.put(9, new Producto(9, "Chocolates", 3500.0, 80));
        ListaProductos.put(10, new Producto(10, "Jamon", 15000.0, 10));
    }
    
    public void Agregar(Producto producto){
        ListaProductos.put(producto.getCodigo(), producto);
    }
    public void Borrar(Producto producto){
        ListaProductos.remove(producto.getCodigo());
    }
    public void Actualizar(Producto producto){
        ListaProductos.replace(producto.getCodigo(), producto);
    }
    public boolean VerificarExistencia(Producto producto){
        return ListaProductos.containsKey(producto.getCodigo());
    }
    
    public double TotalInventario(){
        
        double total = 0;
        
        for(Producto producto: ListaProductos.values()){
            total += producto.getPrecio() * producto.getCantidad();
        }
        return total;
    }
    
    public void Informe(){
        
        System.out.println(String.format("%.1f", TotalInventario()));
    }

}

class Producto{
    /*en cualquier clase se puede manipular ni tener acceso, por esto
    son privados y no publicos estos atributos(encapsulamiento)*/
    private int codigo;
    private String nombre;
    private double precio;
    private int cantidad;
    
    //constructor clase Producto
    public Producto(int codigo, String nombre, double precio, int cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    //getter and setters para poder tomar colocar valores a los atributos
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
