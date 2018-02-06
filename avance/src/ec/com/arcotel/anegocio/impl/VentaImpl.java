package ec.com.arcotel.anegocio.impl;

import ec.com.arcotel.accesodedatos.*;
import ec.com.arcotel.anegocio.dao.*;
import ec.com.arcotel.anegocio.entidades.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VentaImpl implements IVentas{
     @Override
    public int insertar(Ventas ventas) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into ventas  values "
                +"(?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, ventas.getCodigo()));
        lstPar.add(new Parametro(2, ventas.getCliente().getCodigo()));
        lstPar.add(new Parametro(3, ventas.getFecha()));
        lstPar.add(new Parametro(4, ventas.getVendedor().getLogin()));
      
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
    public int modificar(Ventas ventas) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE ventas"
                + "   SET codigo=?, codCliente=?, fecha=?, login=? where codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, ventas.getCodigo()));
        lstPar.add(new Parametro(2, ventas.getCliente().getCodigo()));
        lstPar.add(new Parametro(3, ventas.getFecha()));
        lstPar.add(new Parametro(4, ventas.getVendedor().getLogin()));
        
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
    public int eliminar(Ventas ventas) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM ventas  where codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, ventas.getCodigo()));       
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
        Ventas ventas = null;
        String sql = "SELECT codigo, codCliente, fecha,codVendedor FROM ventas where codigo=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                ventas = new Ventas();
                ventas.setCodigo(rst.getInt(1));
                ICliente clientedao = new ClienteImpl();
                Cliente cliente = clientedao.obtener(rst.getInt(2));
                ventas.setCliente(cliente);
                ventas.setFecha(rst.getDate(3));
                IVendedor vendedordao = new VendedorImpl();
                Vendedor vendedor = vendedordao.obtener(rst.getInt(4));
                ventas.setVendedor(vendedor);
               
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return ventas;
    }

    @Override
    public List<Ventas> obtener() throws Exception {
        List<Ventas> lista = new ArrayList<>();
         String sql = "SELECT codigo, codCliente, fecha, valortotal FROM ventas ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql, null);
            Ventas ventas=null;
            while (rst.next()) {
                ventas = new Ventas();
                ventas.setCodigo(rst.getInt(1));
                ICliente clientedao = new ClienteImpl();
                Cliente cliente = clientedao.obtener(rst.getInt(2));
                ventas.setCliente(cliente);
                ventas.setFecha(rst.getDate(3));
                IVendedor vendedordao = new VendedorImpl();
                Vendedor vendedor = vendedordao.obtener(rst.getInt(4));
                ventas.setVendedor(vendedor);                              
                lista.add(ventas);
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

