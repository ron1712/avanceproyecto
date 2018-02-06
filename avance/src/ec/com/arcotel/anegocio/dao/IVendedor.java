
package ec.com.arcotel.anegocio.dao;

import ec.com.arcotel.anegocio.entidades.*;
import java.util.List;

public interface IVendedor {
   public int insertar(Vendedor vendedor) throws Exception;
    public int modificar(Vendedor vendedor) throws Exception;
    public int eliminar(Vendedor vendedor) throws Exception;
    public Vendedor obtener(String login) throws Exception;
    public List<Vendedor> obtener() throws Exception;  
}
