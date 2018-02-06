/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.arcotel.anegocio.dao;
import ec.com.arcotel.anegocio.entidades.*;
import java.util.*;

/**
 *
 * @author flavi
 */
public interface ICliente {
    public int insertar(Cliente cliente) throws Exception;
    public int modificar(Cliente cliente) throws Exception;
    public int eliminar(Cliente cliente) throws Exception;
    public Cliente obtener(int codigo) throws Exception;
    public List<Cliente> obtener() throws Exception;    
}
