package ec.com.arcotel.anegocio.impl;

import ec.com.arcotel.accesodedatos.Conexion;
import ec.com.arcotel.accesodedatos.Parametro;
import ec.com.arcotel.anegocio.dao.*;
import ec.com.arcotel.anegocio.entidades.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DetalleCompraImpl implements IDetalleCompra {
    
 @Override
    public int insertar(DetalleCompra detallecompra) throws Exception {
        int numFilas = 0;
        String sqlC = "INSERT INTO DetalleCompra VALUES (?,?,?,?,?)";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, detallecompra.getCodigo()));        
        lisParametros.add(new Parametro(2, detallecompra.getProducto().getCodigo()));
        lisParametros.add(new Parametro(3, detallecompra.getFacturacompra().getCodigo()));        
        lisParametros.add(new Parametro(4, detallecompra.getCantidad()));
        lisParametros.add(new Parametro(5, detallecompra.getPrecio_total()));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilas = con.ejecutarComando(sqlC, lisParametros);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return numFilas;
    }

     @Override
    public int modificar(DetalleCompra detallecompra) throws Exception {
        int numFilas = 0;
        String sqlC = "UPDATE DetalleCompra SET codigo=?, codProducto=?, codFacturaCompra=?, cantidad=?. precio_total=? WHERE codigo=?";
        
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, detallecompra.getCodigo()));        
        lisParametros.add(new Parametro(2, detallecompra.getProducto().getCodigo()));
        lisParametros.add(new Parametro(3, detallecompra.getFacturacompra().getCodigo()));        
        lisParametros.add(new Parametro(4, detallecompra.getCantidad()));
        lisParametros.add(new Parametro(5, detallecompra.getPrecio_total()));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilas = con.ejecutarComando(sqlC, lisParametros);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return numFilas;
    }

      @Override
    public int eliminar(DetalleCompra detallecompra) throws Exception {
        int numFilas = 0;
        String sqlC = "DELETE FROM DetalleCompra WHERE codigo=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, detallecompra.getCodigo()));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilas = con.ejecutarComando(sqlC, lisParametros);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return numFilas;
    }
     @Override
    public DetalleCompra obtener(int codDetalleCompra) throws Exception {
        DetalleCompra detallecompra = null;
        String sqlC = "SELECT codigo, codProducto, codFacturaCompra, cantidad, precio_total FROM DetalleCompra WHERE codigo=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, codDetalleCompra));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sqlC, lisParametros);
            
            while (rst.next()) {     
                detallecompra = new DetalleCompra();
                detallecompra.setCodigo(rst.getString(1));
                IProducto productoDao = new ProductoImpl();
                Producto producto = productoDao.obtener(rst.getInt(2));
                detallecompra.setProducto(producto);
                IFacturaCompra facturacompradao = new FacturaCompraImpl();
                FacturaCompra facturacompra = facturacompradao.obtener(rst.getInt(3));
                detallecompra.setFacturacompra(facturacompra);
                detallecompra.setCantidad(Integer.parseInt(rst.getString(4)));
                detallecompra.setPrecio_total(Double.parseDouble(rst.getString(5)));  
                
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return detallecompra;  
    }  
    
    @Override
    public List<DetalleCompra> obtener() throws Exception {
        List<DetalleCompra> lista = new ArrayList<>();
         String sql ="SELECT codidog, codProducto, codFacturaCompra, cantidad, precio_total FROM DetalleCompra";       
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql, null);
            DetalleCompra detallecompra=null;
            while (rst.next()) {                
                detallecompra = new DetalleCompra();
                detallecompra.setCodigo(rst.getString(1));
                IProducto productoDao = new ProductoImpl();
                Producto producto = productoDao.obtener(rst.getInt(2));
                detallecompra.setProducto(producto);
                IFacturaCompra facturacompradao = new FacturaCompraImpl();
                FacturaCompra facturacompra = facturacompradao.obtener(rst.getInt(3));
                detallecompra.setFacturacompra(facturacompra);
                detallecompra.setCantidad(Integer.parseInt(rst.getString(4)));
                detallecompra.setPrecio_total(Double.parseDouble(rst.getString(5)));
                lista.add(detallecompra);
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
