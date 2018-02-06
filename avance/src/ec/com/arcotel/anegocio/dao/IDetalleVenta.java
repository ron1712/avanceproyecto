/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.arcotel.anegocio.dao;

import ec.com.arcotel.anegocio.entidades.Detalleventa;
import java.util.List;

/**
 *
 * @author flavi
 */
public interface IDetalleVenta {
    public int insertar(Detalleventa detalleventa) throws Exception;
    public int modificar(Detalleventa detalleventa) throws Exception;
    public int eliminar(Detalleventa detalleventa) throws Exception;
    public Detalleventa obtener(int codigoDetalleventa) throws Exception;
    public List<Detalleventa> obtener() throws Exception;    
}
