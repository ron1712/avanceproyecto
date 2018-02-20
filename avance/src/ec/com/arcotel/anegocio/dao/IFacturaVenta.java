package ec.com.arcotel.anegocio.dao;
import ec.com.arcotel.anegocio.entidades.*;
import java.util.*;

public interface IFacturaVenta {
    public int insertar(FacturaVenta facturaventa) throws Exception;
    public int modificar(FacturaVenta facturaventa) throws Exception;
    public int eliminar(FacturaVenta facturaventa) throws Exception;
    public FacturaVenta obtener(int codigo) throws Exception;
    public List<FacturaVenta> obtener() throws Exception;    
}
