/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.arcotel.anegocio.dao;

import ec.com.arcotel.anegocio.entidades.DetalleSalida;
import java.util.List;

/**
 *
 * @author flavi
 */
public interface IDetalleSalida {
    public int insertar(DetalleSalida detallesalida) throws Exception;
    public int modificar(DetalleSalida detallesalida) throws Exception;
    public int eliminar(DetalleSalida detallesalida) throws Exception;
    public DetalleSalida obtener(int codigoDetalleSalida) throws Exception;
    public List<DetalleSalida> obtener() throws Exception;    
}