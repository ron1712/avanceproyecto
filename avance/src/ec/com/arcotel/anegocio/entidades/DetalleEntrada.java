package ec.com.arcotel.anegocio.entidades;

public class DetalleEntrada {
    private Entrada entrada;
    private Producto producto;
    private String valorcompra;

    public DetalleEntrada() {
    }

    public DetalleEntrada(Entrada entrada, Producto producto, String valorcompra) {
        this.entrada = entrada;
        this.producto = producto;
        this.valorcompra = valorcompra;
    }

    public String getValorcompra() {
        return valorcompra;
    }

    public void setValorcompra(String valorcompra) {
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
