package ec.com.arcotel.anegocio.impl;

import ec.com.arcotel.accesodedatos.*;
import ec.com.arcotel.anegocio.dao.*;
import ec.com.arcotel.anegocio.entidades.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VendedorImpl implements IVendedor {
    @Override
    public int insertar(Vendedor vendedor) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into vendedor  values "
                +"(?,?,?,?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, vendedor.getLogin()));
        lstPar.add(new Parametro(2, vendedor.getClave()));
        lstPar.add(new Parametro(3, vendedor.getNombre()));
        lstPar.add(new Parametro(4, vendedor.getApellido()));
        lstPar.add(new Parametro(5, vendedor.getCedula()));
        lstPar.add(new Parametro(6, vendedor.getDireccion()));
        lstPar.add(new Parametro(7, vendedor.getTelefono()));
        lstPar.add(new Parametro(8, vendedor.getEmail()));     
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
    public int modificar(Vendedor vendedor) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE vendedor"
                + "   SET login=?,clave=?,nombre=?,apellido=? cedula=?,direccion=?,"
                + "telefono=?, email=? where login=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, vendedor.getLogin()));
        lstPar.add(new Parametro(2, vendedor.getClave()));
        lstPar.add(new Parametro(3, vendedor.getNombre()));
        lstPar.add(new Parametro(4, vendedor.getApellido()));
        lstPar.add(new Parametro(5, vendedor.getCedula()));
        lstPar.add(new Parametro(6, vendedor.getDireccion()));
        lstPar.add(new Parametro(7, vendedor.getTelefono()));
        lstPar.add(new Parametro(8, vendedor.getEmail()));
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
    public int eliminar(Vendedor vendedor) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM vendedor  where login=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, vendedor.getLogin()));       
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
    public Vendedor obtener(String login) throws Exception {
        Vendedor vendedor = null;
        String sql = "SELECT login,clave,nombre,apellido,cedula,direccion,"
                + " telefono, email FROM vendedor where login=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, login));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                vendedor = new Vendedor();
                vendedor.setLogin(rst.getString(1));
                vendedor.setClave(rst.getString(2));
                vendedor.setNombre(rst.getString(3));
                vendedor.setApellido(rst.getString(4));
                vendedor.setCedula(rst.getString(5));
                vendedor.setDireccion(rst.getString(6));
                vendedor.setTelefono(rst.getString(7));
                vendedor.setEmail(rst.getString(8));               
            
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return vendedor;
    }

    @Override
    public List<Vendedor> obtener() throws Exception {
        List<Vendedor> lista = new ArrayList<>();
         String sql = "SELECT login, clave, nombre, apellido,cedula ,direccion,"
                + "telefono, email  FROM vendedor ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql, null);
            Vendedor vendedor=null;
            while (rst.next()) {
                vendedor = new Vendedor();                
                vendedor.setLogin(rst.getString(1));
                vendedor.setClave(rst.getString(2));
                vendedor.setNombre(rst.getString(3));
                vendedor.setApellido(rst.getString(4));
                vendedor.setCedula(rst.getString(5));
                vendedor.setDireccion(rst.getString(6));
                vendedor.setTelefono(rst.getString(7));
                vendedor.setEmail(rst.getString(8));                  
                lista.add(vendedor);
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
