package ec.com.arcotel.anegocio.entidades;
import java.util.*;

public class Entrada {
    private String codigo;
    private Proveedor proveedor;
    private Date fecha;
    private double preciototal;
    private String descripcion;

    public Entrada() {
    }

    public Entrada(String codigo, Proveedor proveedor, Date fecha, double preciototal, String descripcion) {
        this.codigo = codigo;
        this.proveedor = proveedor;
        this.fecha = fecha;
        this.preciototal = preciototal;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getPreciototal() {
        return preciototal;
    }

    public void setPreciototal(double preciototal) {
        this.preciototal = preciototal;
    }

    @Override
    public String toString() {
        return codigo;
    }
    
}
