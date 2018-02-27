
package ec.com.arcotel.anegocio.dao;

import ec.com.arcotel.anegocio.entidades.*;
import java.util.List;

public interface IProveedor {
    public int insertar(Proveedor proveedor) throws Exception;
    public int modificar(Proveedor proveedor) throws Exception;
    public int eliminar(Proveedor proveedor) throws Exception;
    public Proveedor obtener(String ruc) throws Exception;
    public List<Proveedor> obtener() throws Exception; 
}
