package ec.com.arcotel.anegocio.dao;

import ec.com.arcotel.anegocio.entidades.Entrada;
import java.util.List;

public interface IEntrada {
    public int insertar(Entrada entrada) throws Exception;
    public int modificar(Entrada entrada) throws Exception;
    public int eliminar(Entrada entrada) throws Exception;
    public Entrada obtener(int codigo) throws Exception;
    public List<Entrada> obtener() throws Exception;    
}
