package ec.com.arcotel.anegocio.entidades;
import java.sql.Date;

public class Salida {
   private int codigo;
   private Date fecha;
   private double valorcompra;

    public Salida() {
    }

    public Salida(int codigo, Date fecha, double valorcompra) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.valorcompra = valorcompra;
    }

    public double getValorcompra() {
        return valorcompra;
    }

    public void setValorcompra(double valorcompra) {
        this.valorcompra = valorcompra;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
   
}
