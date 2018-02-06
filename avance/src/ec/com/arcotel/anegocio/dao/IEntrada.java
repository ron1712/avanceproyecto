/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.arcotel.anegocio.dao;

import ec.com.arcotel.anegocio.entidades.Entrada;
import java.util.List;

/**
 *
 * @author flavi
 */
public interface IEntrada {
    public int insertar(Entrada entrada) throws Exception;
    public int modificar(Entrada entrada) throws Exception;
    public int eliminar(Entrada entrada) throws Exception;
    public Entrada obtener(int codigoEntrada) throws Exception;
    public List<Entrada> obtener() throws Exception;    
}
