package ec.com.arcotel.anegocio.impl;

import ec.com.arcotel.accesodedatos.*;
import ec.com.arcotel.anegocio.dao.*;
import ec.com.arcotel.anegocio.entidades.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteImpl implements ICliente {

    @Override
    public int insertar(Cliente cliente) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into cliente  values "
                +"(?,?,?,?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cliente.getCodigo()));
        lstPar.add(new Parametro(2, cliente.getNombre()));
        lstPar.add(new Parametro(3, cliente.getApellido()));
        lstPar.add(new Parametro(4, cliente.getCedula()));
        lstPar.add(new Parametro(5, cliente.getDireccion()));
        lstPar.add(new Parametro(6, cliente.getTelefono()));
        lstPar.add(new Parametro(7, cliente.getEmail()));  
        lstPar.add(new Parametro(8, cliente.getVentas().getCodigo()));
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
    public int modificar(Cliente cliente) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE cliente"
                + "   SET codigo=?,nombre=?,, apellido=? cedula=?,direccion=?, "
                + "telefono=?, email=?, codigo=? where codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cliente.getCodigo()));
        lstPar.add(new Parametro(2, cliente.getNombre()));
        lstPar.add(new Parametro(3, cliente.getApellido()));
        lstPar.add(new Parametro(4, cliente.getCedula()));
        lstPar.add(new Parametro(5, cliente.getDireccion()));
        lstPar.add(new Parametro(6, cliente.getTelefono()));
        lstPar.add(new Parametro(7, cliente.getEmail())); 
        lstPar.add(new Parametro(8, cliente.getVentas().getCodigo()));
         lstPar.add(new Parametro(9, cliente.getCodigo()));
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
    public int eliminar(Cliente cliente) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM cliente  where codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cliente.getCodigo()));       
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
    public Cliente obtener(int codigo) throws Exception {
        Cliente cliente = null;
        String sql = "SELECT codigo,nombre,apellido,cedula,direccion,"
                + " telefono, email, codigo FROM cliente where codigo=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                cliente = new Cliente();
                cliente.setCodigo(rst.getInt(1));
                cliente.setNombre(rst.getString(2));
                cliente.setApellido(rst.getString(3));
                cliente.setCedula(rst.getString(4));
                cliente.setDireccion(rst.getString(5));
                cliente.setTelefono(rst.getString(6));
                cliente.setEmail(rst.getString(7));  
                 IVentas ventasdao = new VentaImpl();
                Ventas ventas = ventasdao.obtener(rst.getInt(8));
                cliente.setVentas(ventas); 
            
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return cliente;
    }

    @Override
    public List<Cliente> obtener() throws Exception {
        List<Cliente> lista = new ArrayList<>();
         String sql ="SELECT codigo,nombre,apellido,cedula,direccion,"
                + " telefono, email, codigo FROM cliente";       
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Cliente cliente=null;
            while (rst.next()) {
                cliente = new Cliente();
                cliente.setCodigo(rst.getInt(1));
                cliente.setNombre(rst.getString(2));
                cliente.setApellido(rst.getString(3));
                cliente.setCedula(rst.getString(4));
                cliente.setDireccion(rst.getString(5));
                cliente.setTelefono(rst.getString(6));
                cliente.setEmail(rst.getString(7));
                IVentas ventasdao = new VentaImpl();
                Ventas ventas = ventasdao.obtener(rst.getInt(8));
                cliente.setVentas(ventas); 
                lista.add(cliente);
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

