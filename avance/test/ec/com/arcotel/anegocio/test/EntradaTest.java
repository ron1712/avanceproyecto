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

public class EntradaTest {

    public EntradaTest() {
    }
    @Test
    public void prueba()throws Exception{
     //              INSERTAR
        int filasAfectadas =0;
        IEntrada clienteDao = new EntradaImpl();
        IProveedor proveedorDao = new ProveedorImpl();
        Proveedor proveedor = proveedorDao.obtener(2);
        Entrada cliente = new Entrada("2",proveedor,new Date(),154,"compra");
        try{
            filasAfectadas = clienteDao.insertar(cliente);
            System.out.println("Entrada ingresado!!!");
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        assertEquals(filasAfectadas>0, true);
        //              LISTADO DE PEdido
        List<Entrada> lista = new ArrayList<>();
        try {
            lista = clienteDao.obtener();
            for (Entrada es:lista){
                System.out.println("\nDatos cliente");
                System.out.println("Codigo:"+es.getCodigo());
                System.out.println("Proveedor:"+es.getProveedor().getCodigo());
                System.out.println("Fecha:"+es.getFecha());                
                System.out.println("Precio total:"+es.getPreciototal());                
                System.out.println("Descripcion :"+es.getDescripcion());
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size()>0);
    }
}
