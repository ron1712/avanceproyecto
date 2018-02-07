package ec.com.arcotel.anegocio.impl;

import ec.com.arcotel.accesodedatos.*;
import ec.com.arcotel.anegocio.dao.*;
import ec.com.arcotel.anegocio.entidades.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoImpl implements IProducto{
     @Override
    public int insertar(Producto producto) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into producto  values "
                +"(?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, producto.getCodigo()));
        lstPar.add(new Parametro(2, producto.getNombre()));
        lstPar.add(new Parametro(3, producto.getCantidad()));
        lstPar.add(new Parametro(4, producto.getPreciounitario()));        
        lstPar.add(new Parametro(5, producto.getDescripcion()));
      
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
    public int modificar(Producto producto) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE producto"
                + "   SET codigo=?, nombre=?, cantidad=?, valorunitario=? "
                + "descripcion=? where codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, producto.getCodigo()));
        lstPar.add(new Parametro(2, producto.getNombre()));
        lstPar.add(new Parametro(3, producto.getCantidad()));
        lstPar.add(new Parametro(4, producto.getPreciounitario()));        
        lstPar.add(new Parametro(5, producto.getDescripcion()));
        lstPar.add(new Parametro(6, producto.getCodigo()));
        
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
    public int eliminar(Producto producto) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM producto  where codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, producto.getCodigo()));       
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
    public Producto obtener(int codigo) throws Exception {
        Producto producto = null;
        String sql = "SELECT codigo, nombre, cantidad,valorunitario"
                + "descripcion FROM producto where codigo=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                producto = new Producto();
                producto.setCodigo(rst.getInt(1));
                producto.setNombre(rst.getString(2));
                producto.setCantidad(rst.getInt(3)); 
                producto.setPreciounitario(rst.getDouble(4));
                producto.setDescripcion(rst.getString(5));              
               
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return producto;
    }

    @Override
    public List<Producto> obtener() throws Exception {
        List<Producto> lista = new ArrayList<>();
         String sql = "SELECT codigo, nombre, cantidad, valorunitario,descripcion FROM producto ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql, null);
            Producto producto=null;
            while (rst.next()) {
                producto = new Producto();
                producto.setCodigo(rst.getInt(1));
                producto.setNombre(rst.getString(2));
                producto.setCantidad(rst.getInt(3)); 
                producto.setPreciounitario(rst.getDouble(4));
                producto.setDescripcion(rst.getString(5));                             
                lista.add(producto);
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

