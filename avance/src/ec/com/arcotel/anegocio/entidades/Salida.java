
package ec.com.arcotel.anegocio.entidades;
import java.sql.Date;

public class Salida {
    private int codigoSalida;
    private Date fecha;
    private int valorcompra;

    public Salida() {
    }

    public Salida(int codigoSalida, Date fecha, int valorcompra) {
        this.codigoSalida = codigoSalida;
        this.fecha = fecha;
        this.valorcompra = valorcompra;
    }

    public int getCodigoSalida() {
        return codigoSalida;
    }

    public void setCodigoSalida(int codigoSalida) {
        this.codigoSalida = codigoSalida;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getValorcompra() {
        return valorcompra;
    }

    public void setValorcompra(int valorcompra) {
        this.valorcompra = valorcompra;
    }
    
    
}
