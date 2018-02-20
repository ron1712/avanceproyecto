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
        int Filas = 0;
        String csql = "Insert into DetalleCompra values (?,?,?,?,?)";
        ArrayList<Parametro> lstP = new ArrayList<>();
        lstP.add(new Parametro(1, detallecompra.getCodigo()));
        lstP.add(new Parametro(2, detallecompra.getProducto().getCodigo()));
        lstP.add(new Parametro(3, detallecompra.get()));
      
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
    public DetalleCompra obtener(int codigoDetalleCompra) throws Exception {
        DetalleCompra trata = null;
        Compra compra=null;
        ICompra compraDao = new CompraImpl();
        Producto producto=null;
        IProducto producDao=new ProductoImpl();
        String csql = "Select codCompra, codProducto, preciocompra From DetalleCompra Where codigo=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigoDetalleCompra));
        Conexion con = null;
        try {
            con = new Conexion();
            ResultSet rst = con.ejecutarQuery(csql, lstPar);
            while (rst.next()) {
                compra=new Compra();
                compra=compraDao.obtener(rst.getInt(1));
                producto =new Producto();
                producto = producDao.obtener(rst.getInt(2));
                trata=new DetalleCompra();
                trata.setCompra(compra);
                trata.setProducto(producto);
                trata.setPreciocompra(rst.getInt(3));
               
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
    public List<DetalleCompra> obtener() throws Exception {
        ArrayList<DetalleCompra> comps = new ArrayList<>();
        Compra compra=null;
        ICompra compraDao=new CompraImpl();
        Producto producto=null;
        IProducto productoDao=new ProductoImpl();
        String csql="select codCompra, codProducto, preciocompra from DetalleCompra";
        Conexion con=null;
        try {
            con=new Conexion();
            con.conectar();
            ResultSet rst=con.ejecutarQuery(csql, null);
            DetalleCompra comp=null;
            while(rst.next()){
                compra=new Compra();
                compra=compraDao.obtener(rst.getInt(1));
                producto = new Producto();
                producto = productoDao.obtener(rst.getInt(2));
                comp=new DetalleCompra();
                comp.setCompra(compra);
                comp.setProducto(producto);
                comp.setPreciocompra(rst.getInt(3));             
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
    public int modificar(DetalleCompra detallecompra) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(DetalleCompra detallecompra) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}