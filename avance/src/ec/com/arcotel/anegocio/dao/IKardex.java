/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.arcotel.anegocio.dao;

import ec.com.arcotel.anegocio.entidades.Kardex;
import java.util.List;

/**
 *
 * @author flavi
 */
public interface IKardex {
    public int insertar(Kardex kardex) throws Exception;
    public int modificar(Kardex kardex) throws Exception;
    public int eliminar(Kardex kardex) throws Exception;
    public Kardex obtener(int codigoKardex ) throws Exception;
    public List<Kardex> obtener() throws Exception;    
}
