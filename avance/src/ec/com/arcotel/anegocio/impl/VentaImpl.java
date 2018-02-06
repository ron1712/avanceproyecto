package ec.com.arcotel.anegocio.impl;

import ec.com.arcotel.accesodedatos.*;
import ec.com.arcotel.anegocio.dao.*;
import ec.com.arcotel.anegocio.entidades.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VentaImpl implements IVentas{
     @Override
    public int insertar(Ventas venta) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into venta values "
                +"(?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, venta.getCodigo()));
        lstPar.add(new Parametro(2, venta.getCliente().getCodigo()));
        lstPar.add(new Parametro(3, venta.getFecha()));
        lstPar.add(new Parametro(4, venta.getVendedor().getLogin()));
      
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
    public int modificar(Ventas venta) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE venta"
                + "   SET codigo=?, codCliente=?, fecha=?, login=? where codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, venta.getCodigo()));
        lstPar.add(new Parametro(2, venta.getCliente().getCodigo()));
        lstPar.add(new Parametro(3, venta.getFecha()));
        lstPar.add(new Parametro(4, venta.getVendedor().getLogin()));
        
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
    public int eliminar(Ventas venta) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM venta  where codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, venta.getCodigo()));       
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
    public Ventas obtener(int codigo) throws Exception {
        Ventas venta = null;
        String sql = "SELECT codigo, codCliente, fecha,login FROM venta where codigo=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                venta = new Ventas();
                venta.setCodigo(rst.getInt(1));
                ICliente clientedao = new ClienteImpl();
                Cliente cliente = clientedao.obtener(rst.getInt(2));
                venta.setCliente(cliente);
                venta.setFecha(rst.getDate(3));
                IVendedor vendedordao = new VendedorImpl();
                Vendedor vendedor = vendedordao.obtener(rst.getString(4));
                venta.setVendedor(vendedor);
               
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return venta;
    }

    @Override
    public List<Ventas> obtener() throws Exception {
        List<Ventas> lista = new ArrayList<>();
         String sql = "SELECT codigo, codCliente, fecha, login FROM venta ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql, null);
            Ventas venta=null;
            while (rst.next()) {
                venta = new Ventas();
                venta.setCodigo(rst.getInt(1));
                ICliente clientedao = new ClienteImpl();
                Cliente cliente = clientedao.obtener(rst.getInt(2));
                venta.setCliente(cliente);
                venta.setFecha(rst.getDate(3));
                IVendedor vendedordao = new VendedorImpl();
                Vendedor vendedor = vendedordao.obtener(rst.getString(4));
                venta.setVendedor(vendedor);                              
                lista.add(venta);
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

