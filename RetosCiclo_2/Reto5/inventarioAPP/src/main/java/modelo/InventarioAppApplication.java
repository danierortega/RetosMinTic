package modelo;

import controlador.ControladorProducto;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import vista.Fondo;

@SpringBootApplication
//metodo principal
public class InventarioAppApplication {
        //inicializar independencias
        @Autowired
        RepositorioProducto rep;
        
	public static void main(String[] args) {
		//SpringApplication.run(InventarioAppApplication.class, args);
                SpringApplicationBuilder builder = new SpringApplicationBuilder(InventarioAppApplication.class);
                builder.headless(false);
                ConfigurableApplicationContext context = builder.run(args);
        }
        
        @Bean
        ApplicationRunner applicationRunner() {
            return args -> {
                //logger para registro de operaciones que se llevan en la ejecucion
                final Log logger = LogFactory.getLog(getClass());
                Fondo fondo = new Fondo();
                fondo.setVisible(true);
                ControladorProducto controlador = new ControladorProducto(rep, fondo);
                fondo.setControlador(controlador);
                controlador.setListaProductos(controlador.obtenerProductos());
                controlador.inicializaTabla();

                System.out.println(controlador.precioMayor());
                
            };
        }
}
