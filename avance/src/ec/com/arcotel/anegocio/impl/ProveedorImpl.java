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
                +"(?,?,?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, proveedor.getCodigo()));
        lstPar.add(new Parametro(2, proveedor.getNombre()));
        lstPar.add(new Parametro(3, proveedor.getApellido()));
        lstPar.add(new Parametro(4, proveedor.getCedula()));
         lstPar.add(new Parametro(5, proveedor.getDireccion()));
         lstPar.add(new Parametro(6,proveedor.getTelefono()));       
        lstPar.add(new Parametro(7, proveedor.getEmail()));     
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
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
                + "   SET codigo=?,nombre=?,, apellido=? cedula=?,telefono=?, "
                + "direccion=?, email=? where codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, proveedor.getCodigo()));
        lstPar.add(new Parametro(2, proveedor.getNombre()));
        lstPar.add(new Parametro(3, proveedor.getApellido()));
        lstPar.add(new Parametro(4, proveedor.getCedula()));
        lstPar.add(new Parametro(5, proveedor.getTelefono()));
        lstPar.add(new Parametro(6, proveedor.getDireccion()));
        lstPar.add(new Parametro(7, proveedor.getEmail()));         
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
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
         String sql = "DELETE FROM proveedor  where codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, proveedor.getCodigo()));       
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
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
        String sql = "SELECT codigo,nombre,apellido,cedula,telefono,"
                + "direccion , email FROM proveedor where codigo=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                proveedor = new Proveedor();
                proveedor.setCodigo(rst.getInt(1));
                proveedor.setNombre(rst.getString(2));
                proveedor.setApellido(rst.getString(3));
                proveedor.setCedula(rst.getString(4));
                proveedor.setTelefono(rst.getString(5));
                proveedor.setDireccion(rst.getString(6));
                proveedor.setEmail(rst.getString(7));                
            
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
         String sql = "SELECT codigo,nombre,apellido,cedula,telefono,"
                + "direccion , email FROM proveedor ";       
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Proveedor proveedor=null;
            while (rst.next()) {
                proveedor = new Proveedor();
                proveedor.setCodigo(rst.getInt(1));
                proveedor.setNombre(rst.getString(2));
                proveedor.setApellido(rst.getString(3));
                proveedor.setCedula(rst.getString(4));
                proveedor.setTelefono(rst.getString(5));
                proveedor.setDireccion(rst.getString(6));
                proveedor.setEmail(rst.getString(7));  
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

