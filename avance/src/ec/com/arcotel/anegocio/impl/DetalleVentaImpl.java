package ec.com.arcotel.anegocio.impl;

import ec.com.arcotel.accesodedatos.Conexion;
import ec.com.arcotel.accesodedatos.Parametro;
import ec.com.arcotel.anegocio.dao.IDetalleVenta;
import ec.com.arcotel.anegocio.dao.IProducto;
import ec.com.arcotel.anegocio.dao.IVentas;
import ec.com.arcotel.anegocio.entidades.Detalleventa;
import ec.com.arcotel.anegocio.entidades.Producto;
import ec.com.arcotel.anegocio.entidades.Ventas;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DetalleVentaImpl implements IDetalleVenta{

    @Override
    public int insertar(Detalleventa detalleventa) throws Exception {
        int Filas = 0;
        String csql = "Insert into DetalleVenta (codVenta, codProducto, cantidad, fecha, total) Values (?,?,?,?,?)";
        ArrayList<Parametro> lstP = new ArrayList<>();
        lstP.add(new Parametro(1, detalleventa.getVentas().getCodigo()));
        lstP.add(new Parametro(2, detalleventa.getProducto().getCodigo()));
        lstP.add(new Parametro(3, detalleventa.getCantidad()));
        lstP.add(new Parametro(4, detalleventa.getFecha()));
        lstP.add(new Parametro(5, detalleventa.getTotal()));
      
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            Filas = con.ejecutarComando(csql, lstP);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + " " + e.getLocalizedMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return Filas;
    }

    @Override
    public Detalleventa obtener(int codVenta) throws Exception {
        Detalleventa trata = null;
        Ventas ventas=null;
        IVentas ventasDao = new VentaImpl();
        Producto producto=null;
        IProducto producDao=new ProductoImpl();
        String csql = "Select codVenta, codProducto, cantidad, fecha, total From DetalleVenta Where codVenta=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codVenta));
        Conexion con = null;
        try {
            con = new Conexion();
            ResultSet rst = con.ejecutarQuery(csql, lstPar);
            while (rst.next()) {
                ventas=new Ventas();
                ventas=ventasDao.obtener(rst.getString(1));
                producto =new Producto();
                producto = producDao.obtener(rst.getInt(2));
                trata=new Detalleventa();
                trata.setVentas(ventas);
                trata.setProducto(producto);
                trata.setCantidad(rst.getInt(3));
                trata.setFecha(rst.getDate(4));
                trata.setTotal(rst.getDouble(5));
               
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + " " + e.getLocalizedMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return trata;
    }

    @Override
    public List<Detalleventa> obtener() throws Exception {
        ArrayList<Detalleventa> comps = new ArrayList<>();
        Ventas ventas=null;
        IVentas ventaDao=new VentaImpl();
        Producto producto=null;
        IProducto productoDao=new ProductoImpl();
        String csql="select codigoVenta, codigoProducto, cantidad, fecha, total from Compra";
        Conexion con=null;
        try {
            con=new Conexion();
            con.conectar();
            ResultSet rst=con.ejecutarQuery(csql, null);
            Detalleventa comp=null;
            while(rst.next()){
                ventas=new Ventas();
                ventas=ventaDao.obtener(rst.getString(1));
                producto = new Producto();
                producto = productoDao.obtener(rst.getInt(2));
                comp=new Detalleventa();
                comp.setVentas(ventas);
                comp.setProducto(producto);
                comp.setCantidad(rst.getInt(3));
                comp.setFecha(rst.getDate(4));
                comp.setTotal(rst.getDouble(5));             
                comps.add(comp);
            }
        } catch (Exception e) {
            throw e;
        } finally{
            if(con!=null){
                con.desconectar();
            }
        }
        return comps;
    }

    @Override
    public int modificar(Detalleventa detalleventa) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(Detalleventa detalleventa) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
