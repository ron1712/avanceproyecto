package ec.com.arcotel.anegocio.impl;

import ec.com.arcotel.accesodedatos.*;
import ec.com.arcotel.anegocio.dao.*;
import ec.com.arcotel.anegocio.entidades.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProveedorImpl implements IProveedor {

    @Override
    public int insertar(Proveedor proveedor) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into proveedor values "
                +"(?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, proveedor.getRuc()));
        lstPar.add(new Parametro(2, proveedor.getNombre()));
        lstPar.add(new Parametro(3, proveedor.getDireccion()));
        lstPar.add(new Parametro(4, proveedor.getTelefono()));        
        lstPar.add(new Parametro(5, proveedor.getEmail()));     
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
    public int modificar(Proveedor proveedor) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE proveedor"
                + "   SET ruc=?,nombre=?,direccion=?,telefono=?, "
                + "email=? where ruc=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, proveedor.getRuc()));
        lstPar.add(new Parametro(2, proveedor.getNombre()));
        lstPar.add(new Parametro(3, proveedor.getDireccion()));
        lstPar.add(new Parametro(4,proveedor.getTelefono()));        
        lstPar.add(new Parametro(5, proveedor.getEmail()));         
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
    public int eliminar(Proveedor proveedor) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM proveedor  where ruc=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, proveedor.getRuc()));       
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
    public Proveedor obtener(int codigo) throws Exception {
        Proveedor proveedor = null;
        String sql = "SELECT ruc,nombre,direccion,telefono,"
                + " email FROM proveedor where ruc=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                proveedor = new Proveedor();
                proveedor.setRuc(rst.getString(1));
                proveedor.setNombre(rst.getString(2));
                proveedor.setDireccion(rst.getString(3));
                proveedor.setTelefono(rst.getString(4));
                proveedor.setEmail(rst.getString(5));                
            
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return proveedor;
    }

    @Override
    public List<Proveedor> obtener() throws Exception {
        List<Proveedor> lista = new ArrayList<>();
         String sql = "SELECT ruc,nombre,direccion,telefono,"
                + "email FROM proveedor ";       
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql, null);
            Proveedor proveedor=null;
            while (rst.next()) {
                proveedor = new Proveedor();
                proveedor.setRuc(rst.getString(1));
                proveedor.setNombre(rst.getString(2));
                proveedor.setDireccion(rst.getString(3));
                proveedor.setTelefono(rst.getString(4));
                proveedor.setEmail(rst.getString(5)); 
                lista.add(proveedor);
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

