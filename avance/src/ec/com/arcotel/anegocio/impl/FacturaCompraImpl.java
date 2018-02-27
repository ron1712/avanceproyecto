package ec.com.arcotel.anegocio.impl;

import ec.com.arcotel.accesodedatos.*;
import ec.com.arcotel.anegocio.dao.*;
import ec.com.arcotel.anegocio.entidades.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FacturaCompraImpl implements IFacturaCompra {

    @Override
    public int insertar(FacturaCompra facturacompra) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into facturacompra  values "
                +"(?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, facturacompra.getCodigo()));
        lstPar.add(new Parametro(2, facturacompra.getFecha()));
        lstPar.add(new Parametro(3, facturacompra.getProveedor().getNombre()));        
       
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
    public int modificar(FacturaCompra facturacompra) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE facturacompra"
                + "   SET codigo=?, fecha=?, codProveedor=? where codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, facturacompra.getCodigo()));
        lstPar.add(new Parametro(2, facturacompra.getFecha()));
        lstPar.add(new Parametro(3, facturacompra.getProveedor().getNombre()));
        lstPar.add(new Parametro(4, facturacompra.getCodigo()));
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
    public int eliminar(FacturaCompra facturacompra) throws Exception {
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
    public FacturaCompra obtener(int codigo) throws Exception {
        FacturaCompra facturacompra = null;
        String sql = "SELECT codigo, fecha, codProveedor FROM facturacompra where codigo=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                facturacompra = new FacturaCompra();
                facturacompra.setCodigo(rst.getString(1));
                facturacompra.setFecha(rst.getDate(2)); 
                IProveedor proveedordao = new ProveedorImpl();
                Proveedor proveedor = proveedordao.obtener(rst.getString(3));
                facturacompra.setProveedor(proveedor);
                            
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
    public List<FacturaCompra> obtener() throws Exception {
        List<FacturaCompra> lista = new ArrayList<>();
         String sql ="SELECT codigo, fecha, codProveedor FROM facturacompra";       
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql, null);
            FacturaCompra facturacompra=null;
            while (rst.next()) {                
                facturacompra = new FacturaCompra();
                 facturacompra.setCodigo(rst.getString(1));
                facturacompra.setFecha(rst.getDate(2)); 
                IProveedor proveedordao = new ProveedorImpl();
                Proveedor proveedor = proveedordao.obtener(rst.getString(3));
                facturacompra.setProveedor(proveedor);
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

