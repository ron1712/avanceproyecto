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
                +"(?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, producto.getCodigo()));
        lstPar.add(new Parametro(2, producto.getCategoria().getCodigo()));
        lstPar.add(new Parametro(3, producto.getNombre()));
        lstPar.add(new Parametro(4, producto.getPrecio()));        
       
      
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
                + "   SET codigo=?,codigocategoria=?, nombre=?, precio=? "
                + " where codigo=?";
    List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, producto.getCodigo()));
        lstPar.add(new Parametro(2, producto.getCategoria().getCodigo()));
        lstPar.add(new Parametro(3, producto.getNombre()));
        lstPar.add(new Parametro(4, producto.getPrecio())); 
        
        
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
        String sql = "SELECT codigo,codigocategoria, nombre,precio,"
                + " FROM producto where codigo=?;";
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
                ICategoria categoriadao = new CategoriaImpl();
                Categoria categoria = categoriadao.obtener(rst.getInt(2));
                producto.setNombre(rst.getString(3));
                producto.setPrecio(rst.getDouble(4));
                
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
         String sql = "SELECT codigo,codigocategoria ,nombre,precio FROM producto ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql, null);
            Producto producto=null;
            while (rst.next()) {
                producto = new Producto();
                producto.setCodigo(rst.getInt(1));
                ICategoria categoriadao = new CategoriaImpl();
                Categoria categoria = categoriadao.obtener(rst.getInt(2));
                producto.setNombre(rst.getString(3));
                producto.setPrecio(rst.getDouble(4));                            
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

