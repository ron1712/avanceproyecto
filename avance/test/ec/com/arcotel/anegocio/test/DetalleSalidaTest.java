package ec.com.arcotel.anegocio.test;
import ec.com.arcotel.anegocio.dao.*;
import ec.com.arcotel.anegocio.entidades.*;
import ec.com.arcotel.anegocio.impl.*;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class DetalleSalidaTest {
     @Test
    public void prueba() throws Exception{
     //              INSERTAR
        int filasAfectadas =0;
        IDetalleSalida detallesalidaDao = new DetalleSalidaImpl();
        ISalida salidaDao = new SalidaImpl();
        Salida salida = salidaDao.obtener(2);
        IProducto productoDao = new ProductoImpl();
        Producto producto = productoDao.obtener(2);
        DetalleSalida detallesalida = new DetalleSalida(salida,producto,320);
        try{
            filasAfectadas = detallesalidaDao.insertar(detallesalida);
            System.out.println("DetalleSalida ingresado!!!");
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        assertEquals(filasAfectadas>0, true);
        //              LISTADO DE PEdido
        List<DetalleSalida> lista = new ArrayList<>();
        try {
            lista = detallesalidaDao.obtener();
            for (DetalleSalida es:lista){
                System.out.println("\nDatos detallesalida");
                System.out.println("Salida:"+es.getSalida().getCodigo());
                System.out.println("Producto:"+es.getProducto().getCodigo());
                System.out.println("Cantidad:"+es.getCantidad());                
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size()>0);
    }
    
}
