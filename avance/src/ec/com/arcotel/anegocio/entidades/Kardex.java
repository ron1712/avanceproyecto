package ec.com.arcotel.anegocio.entidades;


public class Kardex {
   private int codigo;
   private Producto producto;
   private Entrada entrada;
   private Salida salida;
   private int cantidad;
   private double preciocompra;
   private double precioventa;
   private int cantidadinicial;
   private int cantidadactual;

    public Kardex() {
    }

    public Kardex(int codigo, Producto producto, Entrada entrada, Salida salida, int cantidad, double preciocompra, double precioventa, int cantidadinicial, int cantidadactual) {
        this.codigo = codigo;
        this.producto = producto;
        this.entrada = entrada;
        this.salida = salida;
        this.cantidad = cantidad;
        this.preciocompra = preciocompra;
        this.precioventa = precioventa;
        this.cantidadinicial = cantidadinicial;
        this.cantidadactual = cantidadactual;
    }

    public int getCantidadactual() {
        return cantidadactual;
    }

    public void setCantidadactual(int cantidadactual) {
        this.cantidadactual = cantidadactual;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Entrada getEntrada() {
        return entrada;
    }

    public void setEntrada(Entrada entrada) {
        this.entrada = entrada;
    }

    public Salida getSalida() {
        return salida;
    }

    public void setSalida(Salida salida) {
        this.salida = salida;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPreciocompra() {
        return preciocompra;
    }

    public void setPreciocompra(double preciocompra) {
        this.preciocompra = preciocompra;
    }

    public double getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(double precioventa) {
        this.precioventa = precioventa;
    }

    public int getCantidadinicial() {
        return cantidadinicial;
    }

    public void setCantidadinicial(int cantidadinicial) {
        this.cantidadinicial = cantidadinicial;
    }
   
}
