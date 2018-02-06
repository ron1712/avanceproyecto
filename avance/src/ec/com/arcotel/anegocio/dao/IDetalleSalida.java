package ec.com.arcotel.anegocio.dao;

import ec.com.arcotel.anegocio.entidades.DetalleSalida;
import java.util.List;

public interface IDetalleSalida {
    public int insertar(DetalleSalida detallesalida) throws Exception;
    public int modificar(DetalleSalida detallesalida) throws Exception;
    public int eliminar(DetalleSalida detallesalida) throws Exception;
    public DetalleSalida obtener(int codSalida,int codProducto) throws Exception;
    public List<DetalleSalida> obtener() throws Exception;    
}