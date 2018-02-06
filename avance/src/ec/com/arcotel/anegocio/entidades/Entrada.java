package ec.com.arcotel.anegocio.entidades;
import java.util.*;

public class Entrada {
    private int codigo;
    private Proveedor proveedor;
    private Date fecha;
    private double valortotal;

    public Entrada() {
    }

    public Entrada(int codigo, Proveedor proveedor, Date fecha, double valortotal) {
        this.codigo = codigo;
        this.proveedor = proveedor;
        this.fecha = fecha;
        this.valortotal = valortotal;
    }

    public double getValortotal() {
        return valortotal;
    }

    public void setValortotal(double valortotal) {
        this.valortotal = valortotal;
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

    @Override
    public int hashCode() {
        return codigo; 
    }
   
}
