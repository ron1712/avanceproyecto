package ec.com.arcotel.anegocio.entidades;

public class Producto {
    private int codigo;
    private Categoria categoria;
    private String nombre;
    private double precio;

    public Producto() {
    }

    public Producto(int codigo, Categoria categoria, String nombre, double precio) {
        this.codigo = codigo;
        this.categoria = categoria;
        this.nombre = nombre;
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    @Override
    public String toString() {
        return nombre; 
    }
}
