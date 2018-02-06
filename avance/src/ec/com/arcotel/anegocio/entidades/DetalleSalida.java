package ec.com.arcotel.anegocio.entidades;

public class DetalleSalida {
   private Salida salida;
   private Producto producto;
   private String cantidad;

    public DetalleSalida() {
    }

    public DetalleSalida(Salida salida, Producto producto, String cantidad) {
        this.salida = salida;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public Salida getSalida() {
        return salida;
    }

    public void setSalida(Salida salida) {
        this.salida = salida;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
   
}
