package ec.com.arcotel.anegocio.dao;

import ec.com.arcotel.anegocio.entidades.Detalleventa;
import java.util.List;

public interface IDetalleVenta {
    public int insertar(Detalleventa detalleventa) throws Exception;
    public int modificar(Detalleventa detalleventa) throws Exception;
    public int eliminar(Detalleventa detalleventa) throws Exception;
    public Detalleventa obtener(int codVenta, int codProducto) throws Exception;
    public List<Detalleventa> obtener() throws Exception;    
}
