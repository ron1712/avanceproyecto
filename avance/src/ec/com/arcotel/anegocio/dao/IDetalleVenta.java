package ec.com.arcotel.anegocio.dao;

import ec.com.arcotel.anegocio.entidades.DetalleVenta;
import java.util.List;

public interface IDetalleVenta {
    public int insertar(DetalleVenta detalleventa) throws Exception;
    public int modificar(DetalleVenta detalleventa) throws Exception;
    public int eliminar(DetalleVenta detalleventa) throws Exception;
    public DetalleVenta obtener(int codVenta) throws Exception;
    public List<DetalleVenta> obtener() throws Exception;    
}
