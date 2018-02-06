package ec.com.arcotel.anegocio.entidades;

import java.sql.Date;

public class Entrada {
    private int codigoEntrada;
    private int codigoProveedor;
    private Date fecha;
    private int valortotal;

    public Entrada() {
    }

    public Entrada(int codigoEntrada, int codigoProveedor, Date fecha, int valortotal) {
        this.codigoEntrada = codigoEntrada;
        this.codigoProveedor = codigoProveedor;
        this.fecha = fecha;
        this.valortotal = valortotal;
    }

    public int getCodigoEntrada() {
        return codigoEntrada;
    }

    public void setCodigoEntrada(int codigoEntrada) {
        this.codigoEntrada = codigoEntrada;
    }

    public int getCodigoProveedor() {
        return codigoProveedor;
    }

    public void setCodigoProveedor(int codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getValortotal() {
        return valortotal;
    }

    public void setValortotal(int valortotal) {
        this.valortotal = valortotal;
    }
    
   
}
