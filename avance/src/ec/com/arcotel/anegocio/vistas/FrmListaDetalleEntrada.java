/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.arcotel.anegocio.vistas;

import ec.com.arcotel.anegocio.dao.IDetalleEntrada;
import ec.com.arcotel.anegocio.entidades.DetalleEntrada;
import ec.com.arcotel.anegocio.impl.DetalleEntradaImpl;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SYSTEMarket-pc
 */
public class FrmListaDetalleEntrada extends JInternalFrame{

    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    JScrollPane jscTabla;
    
    public FrmListaDetalleEntrada() {
      this.setSize(800,600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        lblTitulo=new JLabel("Listado de DetalleEntradas");
        tabla=new JTable();
        jscTabla=new JScrollPane(tabla);
        
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(jscTabla, BorderLayout.CENTER);
        cargarTabla();  
    }
    public void cargarTabla(){
        modelo=new DefaultTableModel();
        modelo.addColumn("Entrada");
//      
        modelo.addColumn("Entrada");
        modelo.addColumn("Producto");
        modelo.addColumn("Valor compra");
        
        List<DetalleEntrada> lista =new ArrayList<>();
        try {
            IDetalleEntrada tiendaDao = new DetalleEntradaImpl();
            lista=tiendaDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),"Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        for(DetalleEntrada c : lista){
        modelo.addRow(new Object[]{ c.getEntrada().getCodigo(),
        c.getProducto().getCodigo(),c.getValorcompra()});
        }
        tabla.setModel(modelo);
    }
    
    
}
