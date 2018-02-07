package ec.com.arcotel.anegocio.entidades;
import java.util.*;

public class Salida {
   private String codigo;
   private Date fecha;
   private double preciocompra;
   private String detalle;

    public Salida() {
    }
    
    public Salida(String codigo, Date fecha, double preciocompra, String detalle) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.preciocompra = preciocompra;
        this.detalle = detalle;
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

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    @Override
    public String toString() {
        return detalle;
    }
    
}
