/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.arcotel.anegocio.entidades;

/**
 *
 * @author flavi
 */
public class DetalleSalida {
    private int codigoSalida;
    private int codigoArticulo;
    private int cantidad;

    public DetalleSalida() {
    }

    public DetalleSalida(int codigoSalida, int codigoArticulo, int cantidad) {
        this.codigoSalida = codigoSalida;
        this.codigoArticulo = codigoArticulo;
        this.cantidad = cantidad;
    }

    public int getCodigoSalida() {
        return codigoSalida;
    }

    public void setCodigoSalida(int codigoSalida) {
        this.codigoSalida = codigoSalida;
    }

    public int getCodigoArticulo() {
        return codigoArticulo;
    }

    public void setCodigoArticulo(int codigoArticulo) {
        this.codigoArticulo = codigoArticulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}
