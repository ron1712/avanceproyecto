/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.arcotel.anegocio.dao;

import ec.com.arcotel.anegocio.entidades.DetalleEntrada;
import java.util.List;

/**
 *
 * @author flavi
 */
public interface IDetalleEntrada {
    public int insertar(DetalleEntrada detalleentrada) throws Exception;
    public int modificar(DetalleEntrada detalleentrada) throws Exception;
    public int eliminar(DetalleEntrada detalleentrada) throws Exception;
    public DetalleEntrada obtener(int codigoDetalleEntrada) throws Exception;
    public List<DetalleEntrada > obtener() throws Exception;    
}
