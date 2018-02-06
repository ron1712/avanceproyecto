package ec.com.arcotel.anegocio.entidades;
import java.util.*;

public class Detalleventa {
    private Ventas ventas;
    private Producto producto;
    private int cantidad;
    private Date fecha;
    private double total;

    public Detalleventa() {
    }

    public Detalleventa(Ventas ventas, Producto producto, int cantidad, Date fecha, double total) {
        this.ventas = ventas;
        this.producto = producto;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.total = total;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Ventas getVentas() {
        return ventas;
    }

    public void setVentas(Ventas ventas) {
        this.ventas = ventas;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
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
    
}
