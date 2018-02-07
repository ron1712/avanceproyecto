package ec.com.arcotel.anegocio.impl;

import ec.com.arcotel.accesodedatos.*;
import ec.com.arcotel.anegocio.dao.*;
import ec.com.arcotel.anegocio.entidades.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EntradaImpl implements IEntrada{
     @Override
    public int insertar(Entrada entrada) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into entrada  values "
                +"(?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, entrada.getCodigo()));
        lstPar.add(new Parametro(2, entrada.getProveedor().getCodigo()));
        lstPar.add(new Parametro(3, entrada.getFecha()));
        lstPar.add(new Parametro(4, entrada.getValortotal()));
        lstPar.add(new Parametro(5, entrada.getDetalle()));
        
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
    public int modificar(Entrada entrada) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE entrada"
                + "   SET codigo=?, codProveedor=?, fecha=?, valortotal=?"
                + " detalle=? where codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, entrada.getCodigo()));
        lstPar.add(new Parametro(2, entrada.getProveedor().getCodigo()));
        lstPar.add(new Parametro(3, entrada.getFecha()));
        lstPar.add(new Parametro(4, entrada.getValortotal()));
        lstPar.add(new Parametro(5, entrada.getDetalle()));
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
    public int eliminar(Entrada entrada) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM entrada  where codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, entrada.getCodigo()));       
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
    public Entrada obtener(int codigo) throws Exception {
        Entrada entrada = null;
        String sql = "SELECT codigo, codProveedor, fecha,valortotal, detalle FROM entrada where codigo=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                entrada = new Entrada();
                entrada.setCodigo(rst.getInt(1));
                IProveedor proveedordao = new ProveedorImpl();
                Proveedor proveedor = proveedordao.obtener(rst.getInt(2));
                entrada.setProveedor(proveedor);
                entrada.setFecha(rst.getDate(3));
                entrada.setValortotal(rst.getDouble(4));              
                entrada.setDetalle(rst.getString(5)); 
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return entrada;
    }

    @Override
    public List<Entrada> obtener() throws Exception {
        List<Entrada> lista = new ArrayList<>();
         String sql = "SELECT codigo, codProveedor, fecha, valortotal, detalle FROM entrada ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql, null);
            Entrada entrada=null;
            while (rst.next()) {
                entrada = new Entrada();
                entrada.setCodigo(rst.getInt(1));
                IProveedor proveedordao = new ProveedorImpl();
                Proveedor proveedor = proveedordao.obtener(rst.getInt(2));
                entrada.setProveedor(proveedor);
                entrada.setFecha(rst.getDate(3));
                entrada.setValortotal(rst.getDouble(4));        
                entrada.setDetalle(rst.getString(5)); 
                lista.add(entrada);
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
