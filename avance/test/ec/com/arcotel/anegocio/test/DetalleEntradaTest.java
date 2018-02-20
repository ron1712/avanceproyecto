package ec.com.arcotel.anegocio.test;
import ec.com.arcotel.anegocio.dao.*;
import ec.com.arcotel.anegocio.entidades.*;
import ec.com.arcotel.anegocio.impl.*;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class DetalleEntradaTest {

    public DetalleEntradaTest() {
    }
    @Test
    public void prueba() throws Exception{
     //              INSERTAR
        int filasAfectadas =0;
        IDetalleCompra detalleentradaDao = new DetalleCompraImpl();
        IEntrada entradaDao = new EntradaImpl();
        Entrada entrada = entradaDao.obtener(2);
        IProducto productoDao = new ProductoImpl();
        Producto producto = productoDao.obtener(2);
        DetalleCompra detalleentrada = new DetalleCompra(entrada,producto,250);
        try{
            filasAfectadas = detalleentradaDao.insertar(detalleentrada);
            System.out.println("DetalleEntrada ingresado!!!");
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        assertEquals(filasAfectadas>0, true);
        //              LISTADO DE PEdido
        List<DetalleCompra> lista = new ArrayList<>();
        try {
            lista = detalleentradaDao.obtener();
            for (DetalleCompra es:lista){
                System.out.println("\nDatos detalleentrada");
                System.out.println("Entrada:"+es.getEntrada().getCodigo());
                System.out.println("Producto:"+es.getProducto().getCodigo());
                System.out.println("Precio compra:"+es.getPreciocompra());                
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size()>0);
    }
    
}
