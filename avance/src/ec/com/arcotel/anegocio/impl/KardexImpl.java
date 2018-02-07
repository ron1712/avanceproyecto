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
                +"(?,?,?,?,?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, kardex.getCodigo()));
        lstPar.add(new Parametro(2, kardex.getProducto().getCodigo()));
        lstPar.add(new Parametro(3, kardex.getEntrada().getCodigo()));
        lstPar.add(new Parametro(4, kardex.getSalida().getCodigo()));
        lstPar.add(new Parametro(5, kardex.getCantidad()));
        lstPar.add(new Parametro(6, kardex.getPreciocompra()));
        lstPar.add(new Parametro(7, kardex.getPrecioventa()));
        lstPar.add(new Parametro(8, kardex.getCantidadinicial()));
        lstPar.add(new Parametro(9, kardex.getCantidadactual()));
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
                + "   SET codigo=?, codProducto=?, codEntrada=?, codSalida=?,"
                + "cantidad=?, preciocompra=?, precioventa=?, cantidadinicial=?, "
                + "cantidadactual=? where codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
         lstPar.add(new Parametro(1, kardex.getCodigo()));
        lstPar.add(new Parametro(2, kardex.getProducto().getCodigo()));
        lstPar.add(new Parametro(3, kardex.getEntrada().getCodigo()));
        lstPar.add(new Parametro(4, kardex.getSalida().getCodigo()));
        lstPar.add(new Parametro(5, kardex.getCantidad()));
        lstPar.add(new Parametro(6, kardex.getPreciocompra()));
        lstPar.add(new Parametro(7, kardex.getPrecioventa()));
        lstPar.add(new Parametro(8, kardex.getCantidadinicial()));
        lstPar.add(new Parametro(9, kardex.getCantidadactual()));
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
        String sql = "SELECT codigo, codProducto, codEntrada, codSalida,"
                + "cantidad, preciocompra, precioventa, cantidadinicial, "
                + "cantidadactual FROM kardex where codigo=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                kardex = new Kardex();
                kardex.setCodigo(rst.getString(1));
                IProducto productodao = new ProductoImpl();
                Producto producto = productodao.obtener(rst.getInt(2));
                kardex.setProducto(producto);
                IEntrada entradadao = new EntradaImpl();
                Entrada entrada = entradadao.obtener(rst.getInt(3));
                kardex.setEntrada(entrada);
                ISalida salidadao = new SalidaImpl();
                Salida salida = salidadao.obtener(rst.getInt(4));
                kardex.setSalida(salida);
                kardex.setCantidad(rst.getInt(5));
                kardex.setPreciocompra(rst.getDouble(6));                              
                kardex.setPrecioventa(rst.getDouble(7));                 
                kardex.setCantidadinicial(rst.getInt(8));                
                kardex.setCantidadactual(rst.getInt(9));                  
                kardex.setEntrada(entrada);
               
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
         String sql = "SELECT codigo, codProducto, codEntrada, codSalida,"
                + "cantidad, preciocompra, precioventa, cantidadinicial, "
                + "cantidadactual FROM kardex ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql, null);
            Kardex kardex=null;
            while (rst.next()) {
                kardex = new Kardex();
                kardex.setCodigo(rst.getString(1));
                IProducto productodao = new ProductoImpl();
                Producto producto = productodao.obtener(rst.getInt(2));
                kardex.setProducto(producto);
                IEntrada entradadao = new EntradaImpl();
                Entrada entrada = entradadao.obtener(rst.getInt(3));
                kardex.setEntrada(entrada);
                ISalida salidadao = new SalidaImpl();
                Salida salida = salidadao.obtener(rst.getInt(4));
                kardex.setSalida(salida);
                kardex.setCantidad(rst.getInt(5));
                kardex.setPreciocompra(rst.getDouble(6));                              
                kardex.setPrecioventa(rst.getDouble(7));                 
                kardex.setCantidadinicial(rst.getInt(8));                
                kardex.setCantidadactual(rst.getInt(9));                                                    
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

