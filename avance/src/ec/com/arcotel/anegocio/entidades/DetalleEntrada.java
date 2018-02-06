package ec.com.arcotel.anegocio.entidades;

public class DetalleEntrada {
    private Entrada entrada;
    private Producto producto;
    private int valorcompra;

    public DetalleEntrada() {
    }

    public DetalleEntrada(Entrada entrada, Producto producto, int valorcompra) {
        this.entrada = entrada;
        this.producto = producto;
        this.valorcompra = valorcompra;
    }

    public int getValorcompra() {
        return valorcompra;
    }

    public void setValorcompra(int valorcompra) {
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
