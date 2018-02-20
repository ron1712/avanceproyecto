package ec.com.arcotel.anegocio.entidades;

public class DetalleCompra {
    private String codigo;
    private Producto producto;
    private FacturaCompra facturacompra;
    private int cantidad;
    private double precio_total;

    public DetalleCompra() {
    }

    public DetalleCompra(String codigo, Producto producto, FacturaCompra facturacompra, int cantidad, double precio_total) {
        this.codigo = codigo;
        this.producto = producto;
        this.facturacompra = facturacompra;
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

    public FacturaCompra getFacturacompra() {
        return facturacompra;
    }

    public void setFacturacompra(FacturaCompra facturacompra) {
        this.facturacompra = facturacompra;
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
