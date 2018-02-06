
package ec.com.arcotel.anegocio.entidades;

import java.sql.Date;


public class Detalleventa {
    private int codigoVenta;
    private int codigoArticulo;
    private int cantidad;
    private Date fecha;
    private int total;

    public Detalleventa() {
    }

    public Detalleventa(int codigoVenta, int codigoArticulo, int cantidad, Date fecha, int total) {
        this.codigoVenta = codigoVenta;
        this.codigoArticulo = codigoArticulo;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.total = total;
    }

    public int getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(int codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public int getCodigoArticulo() {
        return codigoArticulo;
    }

    public void setCodigoArticulo(int codigoArticulo) {
        this.codigoArticulo = codigoArticulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
}
