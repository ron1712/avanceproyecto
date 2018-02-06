package ec.com.arcotel.anegocio.entidades;

public class DetalleEntrada {
    private Entrada entrada;
    private Producto producto;
    private double valorcompra;

    public DetalleEntrada() {
    }

    public DetalleEntrada(Entrada entrada, Producto producto, double valorcompra) {
        this.entrada = entrada;
        this.producto = producto;
        this.valorcompra = valorcompra;
    }

    public double getValorcompra() {
        return valorcompra;
    }

    public void setValorcompra(double valorcompra) {
        this.valorcompra = valorcompra;
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
