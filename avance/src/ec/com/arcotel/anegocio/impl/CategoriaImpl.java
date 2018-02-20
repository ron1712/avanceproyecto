package ec.com.arcotel.anegocio.impl;

import ec.com.arcotel.accesodedatos.*;
import ec.com.arcotel.anegocio.dao.*;
import ec.com.arcotel.anegocio.entidades.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoriaImpl implements ICategoria {

    @Override
    public int insertar(Categoria categoria) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into categoria  values "
                +"(?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, categoria.getCodigo()));
        lstPar.add(new Parametro(2, categoria.getNombre()));
        lstPar.add(new Parametro(3, categoria.getDescripcion()));        
       
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
    public int modificar(Categoria categoria) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE categoria"
                + "   SET codigo=?, nombre=?, descripcion=? where codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, categoria.getCodigo()));
        lstPar.add(new Parametro(2, categoria.getNombre()));
        lstPar.add(new Parametro(3, categoria.getDescripcion())); 
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
    public int eliminar(Categoria categoria) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM categoria  where codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, categoria.getCodigo()));       
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
    public Categoria obtener(int codigo) throws Exception {
        Categoria categoria = null;
        String sql = "SELECT codigo, nombre, descripcion FROM categoria where codigo=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                categoria = new Categoria();
                categoria.setCodigo(rst.getInt(1));
                categoria.setNombre(rst.getString(2));
                categoria.setDescripcion(rst.getString(3));
                            
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return categoria;
    }

    @Override
    public List<Categoria> obtener() throws Exception {
        List<Categoria> lista = new ArrayList<>();
         String sql ="SELECT codigo, nombre, descripcion FROM categoria";       
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql, null);
            Categoria categoria=null;
            while (rst.next()) {                
                categoria = new Categoria();
                categoria.setCodigo(rst.getInt(1));
                categoria.setNombre(rst.getString(2));
                categoria.setDescripcion(rst.getString(3));
                lista.add(categoria);
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

