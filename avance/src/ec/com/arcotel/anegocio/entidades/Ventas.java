package ec.com.arcotel.anegocio.entidades;
import java.util.*;

public class Ventas {
   private String codigo;
   private Cliente cliente;
   private Date fecha;
   private Vendedor vendedor;

    public Ventas() {
    }

    public Ventas(String codigo, Cliente cliente, Date fecha, Vendedor vendedor) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.fecha = fecha;
        this.vendedor = vendedor;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return codigo;
    }

}
