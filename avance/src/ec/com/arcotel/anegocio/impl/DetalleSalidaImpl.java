package ec.com.arcotel.anegocio.impl;

import ec.com.arcotel.accesodedatos.Conexion;
import ec.com.arcotel.accesodedatos.Parametro;
import ec.com.arcotel.anegocio.dao.IDetalleSalida;
import ec.com.arcotel.anegocio.dao.IProducto;
import ec.com.arcotel.anegocio.dao.ISalida;
import ec.com.arcotel.anegocio.entidades.DetalleSalida;
import ec.com.arcotel.anegocio.entidades.Producto;
import ec.com.arcotel.anegocio.entidades.Salida;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DetalleSalidaImpl implements IDetalleSalida{

    @Override
    public int insertar(DetalleSalida detallesalida) throws Exception {
        int Filas = 0;
        String csql = "Insert into DetalleSalida (codSalida, codProducto, cantidad) Values (?,?,?)";
        ArrayList<Parametro> lstP = new ArrayList<>();
        lstP.add(new Parametro(1, detallesalida.getSalida().getCodigo()));
        lstP.add(new Parametro(2, detallesalida.getProducto().getCodigo()));
        lstP.add(new Parametro(3, detallesalida.getCantidad()));
      
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
    public DetalleSalida obtener(int codigoDetalleSalida) throws Exception {
        DetalleSalida trata = null;
        Salida salida=null;
        ISalida salidaDao = new SalidaImpl();
        Producto producto=null;
        IProducto producDao=new ProductoImpl();
        String csql = "Select codigo, codigo, cantidad From DetalleSalida Where codigo=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigoDetalleSalida));
        Conexion con = null;
        try {
            con = new Conexion();
            ResultSet rst = con.ejecutarQuery(csql, lstPar);
            while (rst.next()) {
                salida =new Salida();
                salida =salidaDao.obtener(rst.getInt(1));
                producto =new Producto();
                producto = producDao.obtener(rst.getInt(2));
                trata=new DetalleSalida();
                trata.setSalida(salida);
                trata.setProducto(producto);
                trata.setCantidad(rst.getInt(3));
                
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
    public List<DetalleSalida> obtener() throws Exception {
        ArrayList<DetalleSalida> comps = new ArrayList<>();
        Salida salida=null;
        ISalida salidaDao=new SalidaImpl();
        Producto producto=null;
        IProducto productoDao=new ProductoImpl();
        String csql="select codigo, codigo, cantidad from DeatlleSalida";
        Conexion con=null;
        try {
            con=new Conexion();
            con.conectar();
            ResultSet rst=con.ejecutarQuery(csql, null);
            DetalleSalida comp=null;
            while(rst.next()){
                salida=new Salida();
                salida=salidaDao.obtener(rst.getInt(1));
                producto = new Producto();
                producto = productoDao.obtener(rst.getInt(2));
                comp=new DetalleSalida();
                comp.setSalida(salida);
                comp.setProducto(producto);
                comp.setCantidad(rst.getInt(3));
             
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
    public int modificar(DetalleSalida detallesalida) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(DetalleSalida detallesalida) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
