package ec.com.arcotel.anegocio.entidades;

import java.util.Date;

public class FacturaCompra {
    private String codigo;
    private Date fecha;
    private Proveedor proveedor;

     public FacturaCompra() {
    }
     
    public FacturaCompra(String codigo, Date fecha, Proveedor proveedor) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.proveedor = proveedor;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
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
