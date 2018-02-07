package ec.com.arcotel.anegocio.test;
import ec.com.arcotel.anegocio.dao.*;
import ec.com.arcotel.anegocio.entidades.*;
import ec.com.arcotel.anegocio.impl.*;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ProductoTest {

    public ProductoTest() {
    }
    @Test
    public void prueba(){
     //              INSERTAR
        int filasAfectadas =0;
        IProducto productoDao = new ProductoImpl();
        Producto producto = new Producto(2,"Angel",10,60,"arroz");
        try{
            filasAfectadas = productoDao.insertar(producto);
            System.out.println("Producto ingresado!!!");
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        assertEquals(filasAfectadas>0, true);
        //              LISTADO DE PEdido
        List<Producto> lista = new ArrayList<>();
        try {
            lista = productoDao.obtener();
            for (Producto es:lista){
                System.out.println("\nDatos producto");
                System.out.println("Codigo :"+es.getCodigo());
                System.out.println("Nombre :"+es.getNombre());
                System.out.println("Cantidad :"+es.getCantidad());                
                System.out.println("Precio unitario :"+es.getPreciounitario());                
                System.out.println("Descripcion :"+es.getDescripcion());
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size()>0);
    }
    
}
