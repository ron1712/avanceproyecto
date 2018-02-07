package ec.com.arcotel.anegocio.vistas;

import ec.com.arcotel.anegocio.dao.*;
import ec.com.arcotel.anegocio.entidades.*;
import ec.com.arcotel.anegocio.impl.*;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FrmListaDetalleEntrada extends JInternalFrame{
    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    JScrollPane jscTabla;
    public FrmListaDetalleEntrada(){
        this.setSize(600, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        lblTitulo = new JLabel("Listado DetalleEntradas");
        tabla= new JTable();
        jscTabla = new JScrollPane(tabla);
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(jscTabla, BorderLayout.CENTER);
        cargarTabla();        
    }
        public void cargarTabla(){
        modelo= new DefaultTableModel();
        modelo.addColumn("Entrada");       
        modelo.addColumn("Producto");
        modelo.addColumn("Precio compra");
        
        List<DetalleEntrada> lista = new ArrayList<>();
        try{
            IDetalleEntrada detalleentradaDao = new DetalleEntradaImpl();
            lista = detalleentradaDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        for(DetalleEntrada est : lista){
            modelo.addRow(new Object[]{ est.getEntrada().getCodigo(),est.getProducto().getCodigo(), 
                est.getPreciocompra()});
        }
        tabla.setModel(modelo);
    }
       
}
