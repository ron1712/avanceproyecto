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

public class VentaTest {

    public VentaTest() {
    }
     @Test
    public void pruebageneral() throws Exception{
        //              INSERTAR
        int filasAfectadas =0;
        IVentas ventaDao = new VentaImpl();
        ICliente clienteDao = new ClienteImpl();
        Cliente cliente = clienteDao.obtener(2);          
        IVendedor vendedorDao = new VendedorImpl();
        Vendedor vendedor = vendedorDao.obtener("angel1");
        Ventas venta = new Ventas("2",cliente, new Date(),vendedor);
        try{
            filasAfectadas = ventaDao.insertar(venta);
            System.out.println("Venta ingresado!!!");
        }catch(Exception e){
            System.out.println("Error:.. "+e.getMessage());
        }
        assertEquals(filasAfectadas>0, true);
        
        //              LISTADO DE PEdido
        List<Ventas> lista = new ArrayList<>();
        try {
            lista = ventaDao.obtener();
            for (Ventas v:lista){
                System.out.println("\nCodigo:"+v.getCodigo());
                System.out.println("Cliente:"+v.getCliente().getCodigo());
                System.out.println("Fecha:"+v.getFecha());                
                System.out.println("Vendedor: "+v.getVendedor().getLogin());
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size()>0);
    }

}
