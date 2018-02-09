package ec.com.arcotel.anegocio.test;
import ec.com.arcotel.anegocio.dao.*;
import ec.com.arcotel.anegocio.entidades.*;
import ec.com.arcotel.anegocio.impl.*;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class KardexTest {

    public KardexTest() {
    }
    
    @Test
    public void prueba()throws Exception{
     //              INSERTAR
        int filasAfectadas =0;
        IKardex kardexDao = new KardexImpl();
        IProducto productoDao = new ProductoImpl();
        Producto producto = productoDao.obtener(2);
        IEntrada entradaDao = new EntradaImpl();
        Entrada entrada = entradaDao.obtener(2);
        ISalida salidaDao = new SalidaImpl();
        Salida salida = salidaDao.obtener(2);
        Kardex kardex = new Kardex("2",producto,entrada,salida,10,300,400,200,150);
        try{
            filasAfectadas = kardexDao.insertar(kardex);
            System.out.println("Kardex ingresado!!!");
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        assertEquals(filasAfectadas>0, true);
        //              LISTADO DE PEdido
        List<Kardex> lista = new ArrayList<>();
        try {
            lista = kardexDao.obtener();
            for (Kardex es:lista){
                System.out.println("\nDatos kardex");
                System.out.println("Codigo:"+es.getCodigo());
                System.out.println("Producto :"+es.getProducto().getCodigo());
                System.out.println("Entrada:"+es.getEntrada().getCodigo());                
                System.out.println("Salida:"+es.getSalida().getCodigo());                
                System.out.println("Cantidad:"+es.getCantidad());
                System.out.println("Precio compra:"+es.getPreciocompra());
                System.out.println("Precio venta:"+es.getPrecioventa());                     
                System.out.println("Cantidad inicial:"+es.getCantidadinicial());
                System.out.println("Cantidad actual:"+es.getCantidadactual());     
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size()>0);
    }
}
