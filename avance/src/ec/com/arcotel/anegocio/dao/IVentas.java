package ec.com.arcotel.anegocio.dao;

import ec.com.arcotel.anegocio.entidades.*;
import java.util.List;

public interface IVentas {
    public int insertar(Ventas ventas) throws Exception;
    public int modificar(Ventas ventas) throws Exception;
    public int eliminar(Ventas ventas) throws Exception;
    public Ventas obtener(int codigo) throws Exception;
    public List<Ventas> obtener() throws Exception; 
}
