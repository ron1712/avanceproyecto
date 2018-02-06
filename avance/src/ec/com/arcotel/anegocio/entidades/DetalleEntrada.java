
package ec.com.arcotel.anegocio.entidades;

public class DetalleEntrada {
    private int codigoEntrada;
    private int codigoArticulo;
    private int valorcompra;

    public DetalleEntrada() {
    }

    public DetalleEntrada(int codigoEntrada, int codigoArticulo, int valorcompra) {
        this.codigoEntrada = codigoEntrada;
        this.codigoArticulo = codigoArticulo;
        this.valorcompra = valorcompra;
    }

    public int getCodigoEntrada() {
        return codigoEntrada;
    }

    public void setCodigoEntrada(int codigoEntrada) {
        this.codigoEntrada = codigoEntrada;
    }

    public int getCodigoArticulo() {
        return codigoArticulo;
    }

    public void setCodigoArticulo(int codigoArticulo) {
        this.codigoArticulo = codigoArticulo;
    }

    public int getValorcompra() {
        return valorcompra;
    }

    public void setValorcompra(int valorcompra) {
        this.valorcompra = valorcompra;
    }
    

}
