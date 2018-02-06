package ec.com.arcotel.anegocio.dao;

import ec.com.arcotel.anegocio.entidades.Kardex;
import java.util.List;

public interface IKardex {
    public int insertar(Kardex kardex) throws Exception;
    public int modificar(Kardex kardex) throws Exception;
    public int eliminar(Kardex kardex) throws Exception;
    public Kardex obtener(int codigo) throws Exception;
    public List<Kardex> obtener() throws Exception;    
}
