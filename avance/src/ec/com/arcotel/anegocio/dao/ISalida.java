package ec.com.arcotel.anegocio.dao;

import ec.com.arcotel.anegocio.entidades.*;
import java.util.List;

public interface ISalida {
  public int insertar(Salida salida) throws Exception;
    public int modificar(Salida salida) throws Exception;
    public int eliminar(Salida salida) throws Exception;
    public Salida obtener(int codigo) throws Exception;
    public List<Salida> obtener() throws Exception;   
}
