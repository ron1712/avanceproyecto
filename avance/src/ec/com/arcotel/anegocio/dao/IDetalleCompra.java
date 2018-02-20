package ec.com.arcotel.anegocio.dao;

import ec.com.arcotel.anegocio.entidades.DetalleCompra;
import java.util.List;

public interface IDetalleCompra {
    public int insertar(DetalleCompra detallecompra) throws Exception;
    public int modificar(DetalleCompra detallecompra) throws Exception;
    public int eliminar(DetalleCompra detallecompra) throws Exception;
    public DetalleCompra obtener(int codigo) throws Exception;
    public List<DetalleCompra > obtener() throws Exception;    
}
