/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.arcotel.anegocio.entidades;

import java.sql.Date;

/**
 *
 * @author flavi
 */
public class Ventas {
    private int codigoVenta;
    private int codigoVendedor;
    private int codigoCliente;
    private Date fecha;

    public Ventas() {
    }

    public Ventas(int codigoVenta, int codigoVendedor, int codigoCliente, Date fecha) {
        this.codigoVenta = codigoVenta;
        this.codigoVendedor = codigoVendedor;
        this.codigoCliente = codigoCliente;
        this.fecha = fecha;
    }

    public int getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(int codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public int getCodigoVendedor() {
        return codigoVendedor;
    }

    public void setCodigoVendedor(int codigoVendedor) {
        this.codigoVendedor = codigoVendedor;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}
