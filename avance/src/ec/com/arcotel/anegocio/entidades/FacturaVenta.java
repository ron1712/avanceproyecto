package ec.com.arcotel.anegocio.entidades;

import java.util.Date;

public class FacturaVenta {
    private String codigo;
    private Date fecha; 
    private Cliente cliente;

    public FacturaVenta() {
    }

    public FacturaVenta(String codigo, Date fecha, Cliente cliente) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

    @Override
    public String toString() {
        return codigo;
    }
    
}
