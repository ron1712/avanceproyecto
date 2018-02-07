package ec.com.arcotel.anegocio.entidades;

public class Producto {
    private int codigo;
    private String nombre;
    private int cantidad;
    private double preciounitario;
    private String descripcion;

    public Producto() {
    }

    public Producto(int codigo, String nombre, int cantidad, double preciounitario, String descripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.preciounitario = preciounitario;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPreciounitario() {
        return preciounitario;
    }

    public void setPreciounitario(double preciounitario) {
        this.preciounitario = preciounitario;
    }
    @Override
    public String toString() {
        return nombre; 
    }
}
