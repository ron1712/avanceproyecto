
package ec.com.arcotel.anegocio.entidades;


public class Kardex {
    private int codigokardex;
    private int codigoArticulo;
    private int codigoEntrada;
    private int codigoSalida;
    private int cantidad;
    private int preciocompra;
    private int precioventa;
    private int cantidadinicial;
    private int cantidadfinal;

    public Kardex() {
    }

    public Kardex(int codigokardex, int codigoArticulo, int codigoEntrada, int codigoSalida, int cantidad, int preciocompra, int precioventa, int cantidadinicial, int cantidadfinal) {
        this.codigokardex = codigokardex;
        this.codigoArticulo = codigoArticulo;
        this.codigoEntrada = codigoEntrada;
        this.codigoSalida = codigoSalida;
        this.cantidad = cantidad;
        this.preciocompra = preciocompra;
        this.precioventa = precioventa;
        this.cantidadinicial = cantidadinicial;
        this.cantidadfinal = cantidadfinal;
    }

    public int getCodigokardex() {
        return codigokardex;
    }

    public void setCodigokardex(int codigokardex) {
        this.codigokardex = codigokardex;
    }

    public int getCodigoArticulo() {
        return codigoArticulo;
    }

    public void setCodigoArticulo(int codigoArticulo) {
        this.codigoArticulo = codigoArticulo;
    }

    public int getCodigoEntrada() {
        return codigoEntrada;
    }

    public void setCodigoEntrada(int codigoEntrada) {
        this.codigoEntrada = codigoEntrada;
    }

    public int getCodigoSalida() {
        return codigoSalida;
    }

    public void setCodigoSalida(int codigoSalida) {
        this.codigoSalida = codigoSalida;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPreciocompra() {
        return preciocompra;
    }

    public void setPreciocompra(int preciocompra) {
        this.preciocompra = preciocompra;
    }

    public int getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(int precioventa) {
        this.precioventa = precioventa;
    }

    public int getCantidadinicial() {
        return cantidadinicial;
    }

    public void setCantidadinicial(int cantidadinicial) {
        this.cantidadinicial = cantidadinicial;
    }

    public int getCantidadfinal() {
        return cantidadfinal;
    }

    public void setCantidadfinal(int cantidadfinal) {
        this.cantidadfinal = cantidadfinal;
    }
    
    
}
