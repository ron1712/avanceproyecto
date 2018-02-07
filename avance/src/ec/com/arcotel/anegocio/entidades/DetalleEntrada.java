package ec.com.arcotel.anegocio.entidades;

public class DetalleEntrada {
    private Entrada entrada;
    private Producto producto;
    private int preciocompra;

    public DetalleEntrada() {
    }

    public DetalleEntrada(Entrada entrada, Producto producto, int preciocompra) {
        this.entrada = entrada;
        this.producto = producto;
        this.preciocompra = preciocompra;
    }

    public int getPreciocompra() {
        return preciocompra;
    }

    public void setPreciocompra(int preciocompra) {
        this.preciocompra = preciocompra;
    }

    public Entrada getEntrada() {
        return entrada;
    }

    public void setEntrada(Entrada entrada) {
        this.entrada = entrada;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
}
