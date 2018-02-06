package ec.com.arcotel.anegocio.entidades;

public class Producto {
    private int codigo;
    private String nombre;
    private int cantidad;
    private double valorunitario;
    private String descripcion;

    public Producto() {
    }

    public Producto(int codigo, String nombre, int cantidad, double valorunitario, String descripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.valorunitario = valorunitario;
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

    public double getValorunitario() {
        return valorunitario;
    }

    public void setValorunitario(double valorunitario) {
        this.valorunitario = valorunitario;
    }
    @Override
    public String toString() {
        return nombre; 
    }
}
