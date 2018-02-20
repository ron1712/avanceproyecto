package ec.com.arcotel.anegocio.test;



import ec.com.arcotel.anegocio.dao.ICliente;
import ec.com.arcotel.anegocio.entidades.Cliente;
import ec.com.arcotel.anegocio.impl.ClienteImpl;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.*;

public class ClienteTest {

    public ClienteTest() {}  
    
    @Test
    public void prueba(){
     //              INSERTAR
        int filasAfectadas =0;
        ICliente clienteDao = new ClienteImpl();
        Cliente cliente = new Cliente("1501051682","Angel","Ramos","viaguano","0998679028","angelrc1998@hotmail.com",new Date());
        try{
            filasAfectadas = clienteDao.insertar(cliente);
            System.out.println("Cliente ingresado!!!");
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        assertEquals(filasAfectadas>0, true);
        //              LISTADO DE PEdido
        List<Cliente> lista = new ArrayList<>();
        try {
            lista = clienteDao.obtener();
            for (Cliente es:lista){
                System.out.println("\nDatos cliente");
                System.out.println("Cedula :"+es.getCedula());
                System.out.println("Nombre :"+es.getNombre());
                System.out.println("Apellido :"+es.getApellido());                             
                System.out.println("Direccion :"+es.getDireccion());
                System.out.println("Telefono :"+es.getTelefono());
                System.out.println("Email :"+es.getEmail()); 
                System.out.println("Email :"+es.getFecha_nac());
                
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size()>0);
    }
    
}