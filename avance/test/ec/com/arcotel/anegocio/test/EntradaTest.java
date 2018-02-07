package ec.com.arcotel.anegocio.test;
import ec.com.arcotel.anegocio.dao.*;
import ec.com.arcotel.anegocio.entidades.*;
import ec.com.arcotel.anegocio.impl.*;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class EntradaTest {

    public EntradaTest() {
    }
    @Test
    public void prueba(){
     //              INSERTAR
        int filasAfectadas =0;
        IEntrada clienteDao = new EntradaImpl();
        Entrada cliente = new Entrada(2,"Angel","Ramos","0650256050","0998679028","Riobamba","angelrc1998@hotmail.com");
        try{
            filasAfectadas = clienteDao.insertar(cliente);
            System.out.println("Entrada ingresado!!!\n");
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
