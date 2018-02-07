package ec.com.arcotel.anegocio.test;
import ec.com.arcotel.anegocio.dao.*;
import ec.com.arcotel.anegocio.entidades.*;
import ec.com.arcotel.anegocio.impl.*;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ProveedorTest {

    public ProveedorTest() {
    }
    @Test
    public void prueba(){
     //              INSERTAR
        int filasAfectadas =0;
        IProveedor proveedorDao = new ProveedorImpl();
        Proveedor proveedor = new Proveedor(2,"Angel","Ramos","0650256050","0998679028","Riobamba","angelrc1998@hotmail.com");
        try{
            filasAfectadas = proveedorDao.insertar(proveedor);
            System.out.println("Proveedor ingresado!!!");
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        assertEquals(filasAfectadas>0, true);
        //              LISTADO DE PEdido
        List<Proveedor> lista = new ArrayList<>();
        try {
            lista = proveedorDao.obtener();
            for (Proveedor es:lista){
                System.out.println("\nDatos proveedor");
                System.out.println("Codigo :"+es.getCodigo());
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
