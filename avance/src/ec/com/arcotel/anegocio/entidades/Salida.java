package ec.com.arcotel.anegocio.entidades;
import java.util.*;

public class Salida {
   private String codigo;
   private Date fecha;
   private double preciocompra;
   private String descripcion;

    public Salida() {
    }
    
    public Salida(String codigo, Date fecha, double preciocompra, String descripcion) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.preciocompra = preciocompra;
        this.descripcion = descripcion;
    } 

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getPreciocompra() {
        return preciocompra;
    }

    public void setPreciocompra(double preciocompra) {
        this.preciocompra = preciocompra;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return codigo;
    }
    
}
