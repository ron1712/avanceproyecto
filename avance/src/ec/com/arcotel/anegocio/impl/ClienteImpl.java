package ec.com.arcotel.anegocio.impl;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import ec.com.arcotel.accesodedatos.Conexion;
import ec.com.arcotel.accesodedatos.Parametro;
import ec.com.arcotel.anegocio.dao.ICliente;
import ec.com.arcotel.anegocio.entidades.Cliente;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteImpl implements ICliente {

    @Override
    public int insertar(Cliente cliente) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into cliente (descripcion) values (?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cliente.getDescripcion()));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return numFilasAfectadas;
    }

    @Override
    public int modificar(Cliente cliente) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "update  cliente set descripcion=? where codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cliente.getDescripcion()));
        lstPar.add(new Parametro(2, cliente.getCodigo()));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return numFilasAfectadas;
    }

    @Override
    public int eliminar(Cliente cliente) throws Exception {
        int numFilasAfectadas = 0;
        return numFilasAfectadas;
    }

    @Override
    public Cliente obtener(int codigo) throws Exception {
        Cliente cliente = null;
         String sql = "select codigo, descripcion from cliente where codigo=?"; 
          List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);            
            while(rst.next()){
                cliente= new Cliente();
                cliente.setCodigo(rst.getInt(1));
                cliente.setDescripcion(rst.getString(2));            
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return cliente;
    }

    @Override
    public List<Cliente> obtener() throws Exception {
        List<Cliente> lista = new ArrayList<>();
         String sql = "select codigo, descripcion from cliente";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Cliente cliente= null;
            while(rst.next()){
                cliente= new Cliente();
                cliente.setCodigo(rst.getInt(1));
                cliente.setDescripcion(rst.getString(2));
                lista.add(cliente);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return lista;
    }

    @Override
    public int insertar(Cliente cliente) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int modificar(Cliente cliente) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(Cliente cliente) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
