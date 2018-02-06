package ec.com.arcotel.anegocio.entidades;

import java.sql.Date;

public class Ventas {
   public int codigo;
   public Cliente cliente;
   public Date fecha;

    public Ventas() {
    }

    public Ventas(int codigo, Cliente cliente, Date fecha) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.fecha = fecha;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
   
}
