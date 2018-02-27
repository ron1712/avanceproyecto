package ec.com.arcotel.anegocio.impl;

import ec.com.arcotel.accesodedatos.*;
import ec.com.arcotel.anegocio.dao.*;
import ec.com.arcotel.anegocio.entidades.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FacturaVentaImpl implements IFacturaVenta {

    @Override
    public int insertar(FacturaVenta facturacompra) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into facturacompra  values "
                +"(?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, facturacompra.getCodigo()));
        lstPar.add(new Parametro(2, facturacompra.getFecha()));
        lstPar.add(new Parametro(3, facturacompra.getCliente().getNombre()));        
       
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
    public int modificar(FacturaVenta facturacompra) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE facturacompra"
                + "   SET codigo=?, fecha=?, codCliente=? where codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, facturacompra.getCodigo()));
        lstPar.add(new Parametro(2, facturacompra.getFecha()));
        lstPar.add(new Parametro(3, facturacompra.getCliente().getNombre()));
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
    public int eliminar(FacturaVenta facturacompra) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM facturacompra  where codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, facturacompra.getCodigo()));       
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
    public FacturaVenta obtener(int codigo) throws Exception {
        FacturaVenta facturacompra = null;
        String sql = "SELECT codigo, fecha, codCliente FROM facturacompra where codigo=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                facturacompra = new FacturaVenta();
                facturacompra.setCodigo(rst.getString(1));
                facturacompra.setFecha(rst.getDate(2)); 
                ICliente clienterdao = new ClienteImpl();
                Cliente clienter = clienterdao.obtener(rst.getString(3));
                facturacompra.setCliente(clienter);
                            
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return facturacompra;
    }

    @Override
    public List<FacturaVenta> obtener() throws Exception {
        List<FacturaVenta> lista = new ArrayList<>();
         String sql ="SELECT codigo, fecha, codCliente FROM facturacompra";       
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql, null);
            FacturaVenta facturacompra=null;
            while (rst.next()) {                
                facturacompra = new FacturaVenta();
                 facturacompra.setCodigo(rst.getString(1));
                facturacompra.setFecha(rst.getDate(2)); 
                ICliente clienterdao = new ClienteImpl();
                Cliente clienter = clienterdao.obtener(rst.getString(3));
                facturacompra.setCliente(clienter);
                lista.add(facturacompra);
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




