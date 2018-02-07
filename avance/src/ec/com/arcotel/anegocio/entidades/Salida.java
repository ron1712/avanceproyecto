package ec.com.arcotel.anegocio.entidades;
import java.util.*;

public class Salida {
   private int codigo;
   private Date fecha;
   private double valorcompra;
   private String detalle;

    public Salida() {
    }
    
    public Salida(int codigo, Date fecha, double valorcompra, String detalle) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.valorcompra = valorcompra;
        this.detalle = detalle;
    } 

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getValorcompra() {
        return valorcompra;
    }

    public void setValorcompra(double valorcompra) {
        this.valorcompra = valorcompra;
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
