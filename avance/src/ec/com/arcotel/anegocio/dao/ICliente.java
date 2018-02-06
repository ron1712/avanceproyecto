package ec.com.arcotel.anegocio.dao;
import ec.com.arcotel.anegocio.entidades.*;
import java.util.*;

public interface ICliente {
    public int insertar(Cliente cliente) throws Exception;
    public int modificar(Cliente cliente) throws Exception;
    public int eliminar(Cliente cliente) throws Exception;
    public Cliente obtener(int codigo) throws Exception;
    public List<Cliente> obtener() throws Exception;    
}
