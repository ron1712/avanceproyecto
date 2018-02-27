package ec.com.arcotel.anegocio.dao;
import ec.com.arcotel.anegocio.entidades.*;
import java.util.*;

public interface IUsuario {
    public int insertar(Usuario usuario) throws Exception;
    public int modificar(Usuario usuario) throws Exception;
    public int eliminar(Usuario usuario) throws Exception;
    public Usuario obtener(String usuario) throws Exception;
    public List<Usuario> obtener() throws Exception;    
}
