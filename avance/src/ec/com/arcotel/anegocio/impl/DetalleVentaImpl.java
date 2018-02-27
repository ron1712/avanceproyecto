package ec.com.arcotel.anegocio.impl;

import ec.com.arcotel.accesodedatos.Conexion;
import ec.com.arcotel.accesodedatos.Parametro;
import ec.com.arcotel.anegocio.dao.*;
import ec.com.arcotel.anegocio.entidades.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DetalleVentaImpl implements IDetalleVenta {
    
 @Override
    public int insertar(Detalleventa detalleventa) throws Exception {
        int numFilas = 0;
        String sqlC = "INSERT INTO Detalleventa VALUES (?,?,?,?,?)";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, detalleventa.getCodigo()));        
        lisParametros.add(new Parametro(2, detalleventa.getProducto().getCodigo()));
        lisParametros.add(new Parametro(3, detalleventa.getFacturaventa().getCodigo()));        
        lisParametros.add(new Parametro(4, detalleventa.getCantidad()));
        lisParametros.add(new Parametro(5, detalleventa.getPrecio_total()));
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
    public int modificar(Detalleventa detalleventa) throws Exception {
        int numFilas = 0;
        String sqlC = "UPDATE Detalleventa SET codigo=?, codProducto=?, codFacturaVenta=?, cantidad=?. precio_total=? WHERE codigo=?";
        
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, detalleventa.getCodigo()));        
        lisParametros.add(new Parametro(2, detalleventa.getProducto().getCodigo()));
        lisParametros.add(new Parametro(3, detalleventa.getFacturaventa().getCodigo()));        
        lisParametros.add(new Parametro(4, detalleventa.getCantidad()));
        lisParametros.add(new Parametro(5, detalleventa.getPrecio_total()));
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
    public int eliminar(Detalleventa detalleventa) throws Exception {
        int numFilas = 0;
        String sqlC = "DELETE FROM Detalleventa WHERE codigo=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, detalleventa.getCodigo()));
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
    public Detalleventa obtener(int codDetalleventa) throws Exception {
        Detalleventa detalleventa = null;
        String sqlC = "SELECT codigo, codProducto, codFacturaVenta, cantidad, precio_total FROM Detalleventa WHERE codigo=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, codDetalleventa));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sqlC, lisParametros);
            
            while (rst.next()) {     
                detalleventa = new Detalleventa();
                detalleventa.setCodigo(rst.getString(1));
                IProducto productoDao = new ProductoImpl();
                Producto producto = productoDao.obtener(rst.getInt(2));
                detalleventa.setProducto(producto);
                IFacturaVenta facturaventaDao = new FacturaVentaImpl();
                FacturaVenta facturaventa = facturaventaDao.obtener(rst.getInt(3));
                detalleventa.setFacturaventa(facturaventa);
                detalleventa.setCantidad(Integer.parseInt(rst.getString(4)));
                detalleventa.setPrecio_total(Double.parseDouble(rst.getString(5)));  
                
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return detalleventa;  
    }  
    
    @Override
    public List<Detalleventa> obtener() throws Exception {
        List<Detalleventa> lista = new ArrayList<>();
         String sql ="SELECT codidog, codProducto, codFacturaVenta, cantidad, precio_total FROM Detalleventa";       
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql, null);
            Detalleventa detalleventa=null;
            while (rst.next()) {                
                detalleventa = new Detalleventa();
                detalleventa.setCodigo(rst.getString(1));
                IProducto productoDao = new ProductoImpl();
                Producto producto = productoDao.obtener(rst.getInt(2));
                detalleventa.setProducto(producto);
                IFacturaVenta facturaventadao = new FacturaVentaImpl();
                FacturaVenta facturaventa = facturaventadao.obtener(rst.getInt(3));
                detalleventa.setFacturaventa(facturaventa);
                detalleventa.setCantidad(Integer.parseInt(rst.getString(4)));
                detalleventa.setPrecio_total(Double.parseDouble(rst.getString(5)));
                lista.add(detalleventa);
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
