package ec.com.arcotel.anegocio.impl;

import ec.com.arcotel.accesodedatos.Conexion;
import ec.com.arcotel.accesodedatos.Parametro;
import ec.com.arcotel.anegocio.dao.*;
import ec.com.arcotel.anegocio.entidades.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DetalleEntradaImpl implements IDetalleEntrada {

    @Override
    public int insertar(DetalleEntrada detalleentrada) throws Exception {
        int Filas = 0;
        String csql = "Insert into DetalleEntrada (codEntrada, codProducto, valorcompra) Values (?,?,?)";
        ArrayList<Parametro> lstP = new ArrayList<>();
        lstP.add(new Parametro(1, detalleentrada.getEntrada().getCodigo()));
        lstP.add(new Parametro(2, detalleentrada.getProducto().getCodigo()));
        lstP.add(new Parametro(3, detalleentrada.getValorcompra()));
      
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
    public DetalleEntrada obtener(int codigoDetalleEntrada) throws Exception {
        DetalleEntrada trata = null;
        Entrada entrada=null;
        IEntrada entradaDao = new EntradaImpl();
        Producto producto=null;
        IProducto producDao=new ProductoImpl();
        String csql = "Select codigoEntrada, codigoProducto, valorcompra From DetalleEntrada Where codigo=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigoDetalleEntrada));
        Conexion con = null;
        try {
            con = new Conexion();
            ResultSet rst = con.ejecutarQuery(csql, lstPar);
            while (rst.next()) {
                entrada=new Entrada();
                entrada=entradaDao.obtener(rst.getInt(1));
                producto =new Producto();
                producto = producDao.obtener(rst.getInt(2));
                trata=new DetalleEntrada();
                trata.setEntrada(entrada);
                trata.setProducto(producto);
                trata.setValorcompra(rst.getString(3));
               
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
    public List<DetalleEntrada> obtener() throws Exception {
        ArrayList<DetalleEntrada> comps = new ArrayList<>();
        Entrada entrada=null;
        IEntrada entradaDao=new EntradaImpl();
        Producto producto=null;
        IProducto productoDao=new ProductoImpl();
        String csql="select codigoEntrada, codigoProducto, valorcompra from DetalleEntrada";
        Conexion con=null;
        try {
            con=new Conexion();
            con.conectar();
            ResultSet rst=con.ejecutarQuery(csql, null);
            DetalleEntrada comp=null;
            while(rst.next()){
                entrada=new Entrada();
                entrada=entradaDao.obtener(rst.getInt(1));
                producto = new Producto();
                producto = productoDao.obtener(rst.getInt(2));
                comp=new DetalleEntrada();
                comp.setEntrada(entrada);
                comp.setProducto(producto);
                comp.setValorcompra(rst.getString(3));             
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
    public int modificar(DetalleEntrada detalleentrada) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(DetalleEntrada detalleentrada) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}