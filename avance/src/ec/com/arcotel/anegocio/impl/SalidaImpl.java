package ec.com.arcotel.anegocio.impl;

import ec.com.arcotel.accesodedatos.*;
import ec.com.arcotel.anegocio.dao.*;
import ec.com.arcotel.anegocio.entidades.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SalidaImpl implements ISalida{
     @Override
    public int insertar(Salida salida) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into salida  values "
                +"(?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, salida.getCodigo()));
        lstPar.add(new Parametro(2, salida.getFecha()));
        lstPar.add(new Parametro(3, salida.getValorcompra()));        
      
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
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
    public int modificar(Salida salida) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE salida"
                + "   SET codigo=?,fecha=?, valorcompra=? where codigo=?";
        List<Parametro> lstPar = new ArrayList<>();        
        lstPar.add(new Parametro(1, salida.getCodigo()));
        lstPar.add(new Parametro(2, salida.getFecha()));
        lstPar.add(new Parametro(3, salida.getValorcompra())); 
        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
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
    public int eliminar(Salida salida) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM salida  where codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, salida.getCodigo()));       
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
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
    public Salida obtener(int codigo) throws Exception {
        Salida salida = null;
        String sql = "SELECT codigo, fecha, valorcompra FROM salida where codigo=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                salida = new Salida();
                salida.setCodigo(rst.getInt(1));                                
                salida.setValorcompra(rst.getDouble(2));                             
                salida.setFecha(rst.getDate(3));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return salida;
    }

    @Override
    public List<Salida> obtener() throws Exception {
        List<Salida> lista = new ArrayList<>();
         String sql = "SELECT codigo, codProveedor, fecha, valortotal FROM salida ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Salida salida=null;
            while (rst.next()) {
                salida = new Salida();
                salida.setCodigo(rst.getInt(1));                                
                salida.setValorcompra(rst.getDouble(2));                             
                salida.setFecha(rst.getDate(3));                              
                lista.add(salida);
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
