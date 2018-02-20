package ec.com.arcotel.anegocio.dao;
import ec.com.arcotel.anegocio.entidades.*;
import java.util.*;

public interface IFacturaCompra {
    public int insertar(FacturaCompra facturacompra) throws Exception;
    public int modificar(FacturaCompra facturacompra) throws Exception;
    public int eliminar(FacturaCompra facturacompra) throws Exception;
    public FacturaCompra obtener(int codigo) throws Exception;
    public List<FacturaCompra> obtener() throws Exception;    
}
