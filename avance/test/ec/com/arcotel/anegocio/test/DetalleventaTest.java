package ec.com.arcotel.anegocio.test;
import ec.com.arcotel.anegocio.dao.*;
import ec.com.arcotel.anegocio.entidades.*;
import ec.com.arcotel.anegocio.impl.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class DetalleventaTest {

    public DetalleventaTest() {
    }
     @Test
    public void prueba() throws Exception{
     //              INSERTAR
        int filasAfectadas =0;
        IDetalleVenta detalleventaDao = new DetalleVentaImpl();
        IVentas ventaDao = new VentaImpl();
        Ventas venta = ventaDao.obtener("2");
        IProducto productoDao = new ProductoImpl();
        Producto producto = productoDao.obtener(2);
        Detalleventa detalleventa = new Detalleventa(venta,producto,320, new Date(),2000);
        try{
            filasAfectadas = detalleventaDao.insertar(detalleventa);
            System.out.println("DetalleVenta ingresado!!!");
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        assertEquals(filasAfectadas>0, true);
        //              LISTADO DE PEdido
        List<Detalleventa> lista = new ArrayList<>();
        try {
            lista = detalleventaDao.obtener();
            for (Detalleventa es:lista){
                System.out.println("\nDatos detalleventa");
                System.out.println("Venta:"+es.getVentas().getCodigo());
                System.out.println("Producto:"+es.getProducto().getCodigo());
                System.out.println("Precio compra:"+es.getCantidad());                                
                System.out.println("Fecha:"+es.getFecha());
                System.out.println("Total:"+es.getTotal());                
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size()>0);
    }
    
}
