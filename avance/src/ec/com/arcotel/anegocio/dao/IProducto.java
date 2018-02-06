package ec.com.arcotel.anegocio.dao;

import ec.com.arcotel.anegocio.entidades.*;
import java.util.List;

public interface IProducto {
    public int insertar(Producto producto) throws Exception;
    public int modificar(Producto producto) throws Exception;
    public int eliminar(Producto producto) throws Exception;
    public Producto obtener(int codigo) throws Exception;
    public List<Producto> obtener() throws Exception; 
}
