package ec.com.arcotel.anegocio.entidades;

import java.util.Date;

public class Kardex {
  private int codigo;
  private Producto producto;
  private Date fecha_emision;
  private String tipo_transaccion;
  private int existencias;
  private double valor_total;

    public Kardex() {
    }

    public Kardex(int codigo, Producto producto, Date fecha_emision, String tipo_transaccion, int existencias, double valor_total) {
        this.codigo = codigo;
        this.producto = producto;
        this.fecha_emision = fecha_emision;
        this.tipo_transaccion = tipo_transaccion;
        this.existencias = existencias;
        this.valor_total = valor_total;
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

    public Date getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(Date fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public String getTipo_transaccion() {
        return tipo_transaccion;
    }

    public void setTipo_transaccion(String tipo_transaccion) {
        this.tipo_transaccion = tipo_transaccion;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public double getValor_total() {
        return valor_total;
    }

    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }
    
}
