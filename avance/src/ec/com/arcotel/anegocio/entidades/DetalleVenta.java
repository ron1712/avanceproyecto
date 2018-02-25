package ec.com.arcotel.anegocio.entidades;

public class DetalleVenta {
    private String codigo;
    private Producto producto;
    private FacturaVenta facturaventa;
    private int cantidad;
    private double precio_total;

    public DetalleVenta() {
    }

    public DetalleVenta(String codigo, Producto producto, FacturaVenta facturaventa, int cantidad, double precio_total) {
        this.codigo = codigo;
        this.producto = producto;
        this.facturaventa = facturaventa;
        this.cantidad = cantidad;
        this.precio_total = precio_total;
    }

    public double getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(double precio_total) {
        this.precio_total = precio_total;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public FacturaVenta getFacturaventa() {
        return facturaventa;
    }

    public void setFacturaventa(FacturaVenta facturaventa) {
        this.facturaventa = facturaventa;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return codigo;
    }
    
}
