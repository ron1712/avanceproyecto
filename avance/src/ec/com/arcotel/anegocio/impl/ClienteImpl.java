package ec.com.arcotel.anegocio.impl;

import ec.com.arcotel.accesodedatos.*;
import ec.com.arcotel.anegocio.dao.*;
import ec.com.arcotel.anegocio.entidades.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteImpl implements ICliente {

    @Override
    public int insertar(Cliente cliente) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into cliente  values "
                +"(?,?,?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cliente.getCedula()));
        lstPar.add(new Parametro(2, cliente.getNombre()));
        lstPar.add(new Parametro(3, cliente.getApellido()));        
        lstPar.add(new Parametro(4, cliente.getDireccion()));
        lstPar.add(new Parametro(5, cliente.getTelefono()));
        lstPar.add(new Parametro(6, cliente.getEmail()));  
        lstPar.add(new Parametro(7, cliente.getFecha_nac()));
       
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutarComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return numFilasAfectadas;
    }

    @Override
    public int modificar(Cliente cliente) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE cliente"
                + "   SET cedula=?,nombre=?, apellido=?,direccion=?, "
                + "telefono=?, email=?, fecha_nac=? where cedula=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cliente.getCedula()));
        lstPar.add(new Parametro(2, cliente.getNombre()));
        lstPar.add(new Parametro(3, cliente.getApellido()));        
        lstPar.add(new Parametro(4, cliente.getDireccion()));
        lstPar.add(new Parametro(5, cliente.getTelefono()));
        lstPar.add(new Parametro(6, cliente.getEmail()));  
        lstPar.add(new Parametro(7, cliente.getFecha_nac()));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutarComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return numFilasAfectadas;
    }

    @Override
    public int eliminar(Cliente cliente) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM cliente  where cedula=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cliente.getCedula()));       
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutarComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return numFilasAfectadas;
    }

    @Override
    public Cliente obtener(String cedula) throws Exception {
        Cliente cliente = null;
        String sql = "SELECT cedula,nombre,apellido,direccion,"
                + " telefono, email,fecha_nac FROM cliente where cedula=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cedula));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                cliente = new Cliente();
                cliente.setCedula(rst.getString(1));
                cliente.setNombre(rst.getString(2));
                cliente.setApellido(rst.getString(3));
                cliente.setDireccion(rst.getString(4));
                cliente.setTelefono(rst.getString(5));
                cliente.setEmail(rst.getString(6));                  
                cliente.setFecha_nac(rst.getDate(7));  
                
            
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return cliente;
    }

    @Override
    public List<Cliente> obtener() throws Exception {
        List<Cliente> lista = new ArrayList<>();
         String sql ="SELECT cedula,nombre,apellido,direccion,"
                + " telefono, email, fecha_nac FROM cliente";       
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql, null);
            Cliente cliente=null;
            while (rst.next()) {                
                cliente = new Cliente();
                cliente.setCedula(rst.getString(1));
                cliente.setNombre(rst.getString(2));
                cliente.setApellido(rst.getString(3));
                cliente.setDireccion(rst.getString(4));
                cliente.setTelefono(rst.getString(5));
                cliente.setEmail(rst.getString(6));                  
                cliente.setFecha_nac(rst.getDate(7)); 
                lista.add(cliente);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return lista;
    }
}

