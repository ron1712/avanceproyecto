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

public class SalidaTest {

    public SalidaTest() {
    }
    @Test
    public void prueba(){
     //              INSERTAR
        int filasAfectadas =0;
        ISalida salidaDao = new SalidaImpl();
        Salida salida = new Salida("2",new Date(),12,"compra de producto");
        try{
            filasAfectadas = salidaDao.insertar(salida);
            System.out.println("Salida ingresada!!!");
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        assertEquals(filasAfectadas>0, true);
        //              LISTADO DE PEdido
        List<Salida> lista = new ArrayList<>();
        try {
            lista = salidaDao.obtener();
            for (Salida es:lista){
                System.out.println("\nDatos salida");
                System.out.println("Codigo :"+es.getCodigo());
                System.out.println("Fecha :"+es.getFecha());
                System.out.println("Precio compra :"+es.getPreciocompra());                
                System.out.println("Descripcion :"+es.getDescripcion());                
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size()>0);
    }
    
}
