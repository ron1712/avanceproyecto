package ec.com.arcotel.anegocio.dao;
import ec.com.arcotel.anegocio.entidades.*;
import java.util.*;

public interface ICategoria {
    public int insertar(Categoria categoria) throws Exception;
    public int modificar(Categoria categoria) throws Exception;
    public int eliminar(Categoria categoria) throws Exception;
    public Categoria obtener(int codigo) throws Exception;
    public List<Categoria> obtener() throws Exception;    
}
