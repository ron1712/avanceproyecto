package ec.com.arcotel.anegocio.dao;

import ec.com.arcotel.anegocio.entidades.DetalleEntrada;
import java.util.List;

public interface IDetalleEntrada {
    public int insertar(DetalleEntrada detalleentrada) throws Exception;
    public int modificar(DetalleEntrada detalleentrada) throws Exception;
    public int eliminar(DetalleEntrada detalleentrada) throws Exception;
    public DetalleEntrada obtener(int codEntrada) throws Exception;
    public List<DetalleEntrada > obtener() throws Exception;    
}
