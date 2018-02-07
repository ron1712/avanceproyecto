package ec.com.arcotel.anegocio.test;

import ec.com.arcotel.anegocio.dao.ICliente;
import ec.com.arcotel.anegocio.entidades.Cliente;
import ec.com.arcotel.anegocio.impl.ClienteImpl;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.*;

public class ClienteTest {

    public ClienteTest() {
    }

    @Test
    public void pruebageneral() {
        int filasAfectadas = 0;
        ICliente clienteDao = new ClienteImpl();
        Cliente cliente = new Cliente(
                10007, "Juan", "Pérez", "060272477-5","las palmas", "0984912356",
                "flaviotswl@gmail.com");
        try {
            filasAfectadas = clienteDao.insertar(cliente);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertEquals((filasAfectadas > 0), true);

        cliente = null;
        try {
            cliente = clienteDao.obtener(10003);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(cliente != null);

        try {
            cliente.setNombre("Prueba");
            filasAfectadas= clienteDao.modificar(cliente);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
         assertEquals((filasAfectadas > 0), true);
         
         List<Cliente> lista = new ArrayList<>();
        try {
            lista = clienteDao.obtener();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size()>0);

        try {            
            filasAfectadas= clienteDao.eliminar(cliente);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
         assertEquals((filasAfectadas > 0), true);
    }

}