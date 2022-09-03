package controlador;


import java.util.Optional;
import javax.swing.table.DefaultTableModel;
import modelo.Producto;
import modelo.RepositorioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import vista.ActualizarV;
import vista.Advertencia;
import vista.Fondo;
import vista.InformeV;

//adicionales
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControladorProducto implements ActionListener{
    @Autowired
    RepositorioProducto rp;
    Fondo fondo;
    ArrayList<Producto> listaProductos;

    public ControladorProducto(RepositorioProducto rp, Fondo fondo) {
        this.rp = rp;
        this.fondo = fondo;
    }
    
    public void setListaProductos(ArrayList<Producto> listaProductos){
        this.listaProductos = listaProductos;
        
    }
    
    //adicional
    public void inicializar(){
        DefaultTableModel modelo = (DefaultTableModel) fondo.getInventario().getModel();
        int ind = 0;
        for(Producto p: listaProductos){
            modelo.insertRow(ind, new Object[]{p.getNombre(),p.getPrecio(),p.getInventario()});
            ind+=1;
        }
    }
    
    
    //metodos del repositorio para realizar las consultas
    public Producto agregar(Producto p) {
        return rp.save(p);
    }

    public Producto actualizar(Producto p) {
        return rp.save(p);
    }
    
    public boolean eliminar(Integer id){
        try{
            rp.deleteById(id);
            return true;
        }catch(Exception ex){
            return false;
        }
    }
    
    public ArrayList<Producto> obtenerProductos(){
        return (ArrayList<Producto>) rp.findAll();
    }
    
    public Optional<Producto> obtenerProducto(Integer id){
        return rp.findById(id);
    }
    
    public double TotalInventario(){
        double total = 0;
        for(Producto producto: listaProductos){
            total += producto.getPrecio() * producto.getInventario();
        }
        return total;
    }
    
    public String  precioMenor(){
        String nombre = listaProductos.get(0).getNombre();
        double precio = listaProductos.get(0).getPrecio();
        
        for(Producto p: listaProductos){
            if(p.getPrecio() < precio){
                nombre = p.getNombre();
                precio = p.getPrecio();
            }
        }
        return nombre;
    }
    
    public String  precioMayor(){
        String nombre = listaProductos.get(0).getNombre();
        double precio = listaProductos.get(0).getPrecio();
        
        for(Producto p: listaProductos){
            if(p.getPrecio() > precio){
                nombre = p.getNombre();
                precio = p.getPrecio();
            }
        }
        return nombre;
    }
    
    public double promedioPrecios(){
        double suma = 0;
        
        for(Producto p: listaProductos){
            suma += p.getPrecio();
        }
        return suma/listaProductos.size();
    }
    
    public void eventoAgregar(){
        String nombre = fondo.getCampoNombre();
        String precio = fondo.getCampoPrecio();
        String inventario = fondo.getCampoInventario();
        if(!nombre.equals("") && !precio.equals("") && !inventario.equals("")){
            Producto nuevo = new Producto(nombre, Double.parseDouble(precio), Integer.parseInt(inventario));
            Producto dv = this.agregar(nuevo);
            listaProductos.add(dv);
            agregar(nuevo);
            DefaultTableModel modelo = (DefaultTableModel) fondo.getInventario().getModel();
            modelo.insertRow(listaProductos.size()-1, new Object[]{nuevo.getNombre(), nuevo.getPrecio(), nuevo.getInventario()});
        }
        else{
            //Advertencia adv = new Advertencia();
            //adv.setVisible(true); 
            
            JOptionPane.showMessageDialog(null, "Debes completar los campos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
   /* public void eventoEliminar(){
        int filaEliminar = fondo.getInventario().getSelectedRow();
        listaProductos.remove(filaEliminar);
        eliminar(listaProductos.get(filaEliminar).getCodigo());
        DefaultTableModel modelo = (DefaultTableModel) fondo.getInventario().getModel();
        modelo.removeRow(filaEliminar);
    }*/
    
    //adicional
        public void eventoEliminar(){
        int filaEliminar = -1;
        try{
            filaEliminar = fondo.getInventario().getSelectedRow();
        }catch(ArrayIndexOutOfBoundsException e){}
        
        if (filaEliminar !=-1 && filaEliminar < listaProductos.size()){
            int respuesta = JOptionPane.showOptionDialog(
                    null, "Esta seguro de que quiere eliminar? ", "Validacion",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Si", "No"}, "No");
            if(respuesta == JOptionPane.YES_NO_OPTION){
                this.eliminar(listaProductos.get(filaEliminar).getCodigo());
                listaProductos.remove(filaEliminar);
                DefaultTableModel modelo = (DefaultTableModel) fondo.getInventario().getModel();
                modelo.removeRow(filaEliminar);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro valido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void abrirVentanaAct(){
       ActualizarV a = new ActualizarV();
       a.setControlador(this);
       a.setVisible(true);
    }
    
    
    public void eventoActualizar(){
        ActualizarV v = new ActualizarV();
        String nombre = v.getCampoNombreAct();
        String precio = v.getCampoPrecioAct();
        String inventario = v.getCampoInventarioAct();
        if(!nombre.equals("") && !precio.equals("") && !inventario.equals("")){
            int filaActualizar = fondo.getInventario().getSelectedRow();
            DefaultTableModel modelo = (DefaultTableModel) fondo.getInventario().getModel();
            listaProductos.get(filaActualizar).setNombre(nombre);
            listaProductos.get(filaActualizar).setPrecio(Double.parseDouble(precio));
            listaProductos.get(filaActualizar).setInventario(Integer.parseInt(inventario));
            
            
            //adicional
            this.actualizar(listaProductos.get(filaActualizar));
            
            //actualizar(listaProductos.get(filaActualizar));
            modelo.setValueAt(nombre, filaActualizar, 0);
            modelo.setValueAt(Double.parseDouble(precio), filaActualizar, 1);
            modelo.setValueAt(Integer.parseInt(inventario), filaActualizar, 2);
        }
        else{
            /*
            Advertencia adv = new Advertencia();
            adv.setVisible(true); 
            */
            JOptionPane.showMessageDialog(null, "Debes completar los campos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //pendiente por adicional
    public void eventoInforme(){
        InformeV i = new InformeV();
        i.setVisible(true);
        i.setInventario(i.getLabelInventario()+TotalInventario());
        i.setMayor(i.getLabelMayor()+precioMayor());
        i.setMenor(i.getLabelMenor()+precioMenor());
        i.setPromedio(i.getLabelPromedio()+String.format("%.1f", promedioPrecios()));       
    }
    
    public void inicializaTabla(){
        DefaultTableModel modelo = (DefaultTableModel) fondo.getInventario().getModel();
        int cont = 0;
        for(Producto p: listaProductos){
            modelo.insertRow(cont, new Object[]{p.getNombre(), p.getPrecio(), p.getInventario()});
            cont += 1;
        }
    }

    /*
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    */
    
        @Override
    public void actionPerformed(ActionEvent e) {
        Object presionado = e.getSource();
        if(presionado == fondo.getBotonActualizar()){
            //accionAbrir();
            System.out.println("actualizar");
        
        }else if(presionado == fondo.getBotonAgregar()){
            eventoAgregar();
        
        }else if(presionado == fondo.getBotonInforme()){
            eventoInforme();
            System.out.println("informe");
        }else if(presionado == fondo.getBotonBorrar()){
            eventoEliminar();
            System.out.println("borrar");
        }else{
            eventoActualizar();
        }

    }
    
}
