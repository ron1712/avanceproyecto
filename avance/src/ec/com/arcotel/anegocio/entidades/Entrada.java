package ec.com.arcotel.anegocio.entidades;
import java.util.*;

public class Entrada {
    private int codigo;
    private Proveedor proveedor;
    private Date fecha;
    private double valortotal;
    private String detalle;

    public Entrada() {
    }

    public Entrada(int codigo, Proveedor proveedor, Date fecha, double valortotal, String detalle) {
        this.codigo = codigo;
        this.proveedor = proveedor;
        this.fecha = fecha;
        this.valortotal = valortotal;
        this.detalle = detalle;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
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

    public double getValortotal() {
        return valortotal;
    }

    public void setValortotal(double valortotal) {
        this.valortotal = valortotal;
    }

    @Override
    public String toString() {
        return detalle;
    }
    
}
