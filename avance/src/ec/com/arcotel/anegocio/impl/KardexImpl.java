package ec.com.arcotel.anegocio.impl;

import ec.com.arcotel.accesodedatos.*;
import ec.com.arcotel.anegocio.dao.*;
import ec.com.arcotel.anegocio.entidades.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class KardexImpl implements IKardex{
     @Override
    public int insertar(Kardex kardex) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into kardex  values "
                +"(?,?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, kardex.getCodigo()));
        lstPar.add(new Parametro(2, kardex.getProducto().getCodigo()));
        lstPar.add(new Parametro(3, kardex.getFecha_emision()));
        lstPar.add(new Parametro(4, kardex.getTipo_transaccion()));
        lstPar.add(new Parametro(5, kardex.getExistencias()));
        lstPar.add(new Parametro(6, kardex.getValor_total()));
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
    public int modificar(Kardex kardex) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE kardex"
                + "   SET codigo=?, codProducto=?, fechaEmision=?, tipoTransaccion=?,"
                + "existencias=?, valor_total=? where codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, kardex.getCodigo()));
        lstPar.add(new Parametro(2, kardex.getProducto().getCodigo()));
        lstPar.add(new Parametro(3, kardex.getFecha_emision()));
        lstPar.add(new Parametro(4, kardex.getTipo_transaccion()));
        lstPar.add(new Parametro(5, kardex.getExistencias()));
        lstPar.add(new Parametro(6, kardex.getValor_total()));
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
    public int eliminar(Kardex kardex) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM kardex  where codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, kardex.getCodigo()));       
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
    public Kardex obtener(int codigo) throws Exception {
        Kardex kardex = null;
        String sql = "SELECT codigo, codProducto, fechaEmision, tipoTransaccion"
                + "existencias, valor_total FROM kardex where codigo=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                kardex = new Kardex();
                kardex.setCodigo(rst.getInt(1));
                IProducto productodao = new ProductoImpl();
                Producto producto = productodao.obtener(rst.getInt(2));
                kardex.setProducto(producto);
                kardex.setFecha_emision(rst.getDate(3));                              
                kardex.setTipo_transaccion(rst.getString(4));                 
                kardex.setExistencias(rst.getInt(5));                
                kardex.setValor_total(rst.getDouble(6));                  
               
               
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return kardex;
    }

    @Override
    public List<Kardex> obtener() throws Exception {
        List<Kardex> lista = new ArrayList<>();
         String sql = "SELECT codigo,codProducto, fechaEmision,"
                 + "tipoTransaccion, existencias, valor_total FROM kardex ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql, null);
            Kardex kardex=null;
            while (rst.next()) {
                kardex = new Kardex();
                kardex.setCodigo(rst.getInt(1));
                IProducto productodao = new ProductoImpl();
                Producto producto = productodao.obtener(rst.getInt(2));
                kardex.setProducto(producto);
                kardex.setFecha_emision(rst.getDate(3));                              
                kardex.setTipo_transaccion(rst.getString(4));                 
                kardex.setExistencias(rst.getInt(5));                
                kardex.setValor_total(rst.getDouble(6));                                                      
                lista.add(kardex);
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

