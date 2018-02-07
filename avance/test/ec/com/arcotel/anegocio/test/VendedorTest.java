package ec.com.arcotel.anegocio.test;
import ec.com.arcotel.anegocio.dao.*;
import ec.com.arcotel.anegocio.entidades.*;
import ec.com.arcotel.anegocio.impl.*;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class VendedorTest {
    @Test
    public void prueba(){
     //              INSERTAR
        int filasAfectadas =0;
        IVendedor vendedorDao = new VendedorImpl();
        Vendedor vendedor = new Vendedor("angel1","juegos","Angel","Ramos","0650256050","Riobamba","0998679028","angelrc1998@hotmail.com");
        try{
            filasAfectadas = vendedorDao.insertar(vendedor);
            System.out.println("Vendedor ingresado!!!");
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        assertEquals(filasAfectadas>0, true);
        //              LISTADO DE PEdido
        List<Vendedor> lista = new ArrayList<>();
        try {
            lista = vendedorDao.obtener();
            for (Vendedor es:lista){
                System.out.println("\nDatos vendedor");
                System.out.println("Login :"+es.getLogin());
                System.out.println("Clave :"+es.getClave());                
                System.out.println("Nombre :"+es.getNombre());
                System.out.println("Apellido :"+es.getApellido());                
                System.out.println("Cedula :"+es.getCedula());                
                System.out.println("Direccion :"+es.getDireccion());
                System.out.println("Telefono :"+es.getTelefono());
                System.out.println("Email :"+es.getEmail());                
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size()>0);
    }
}
