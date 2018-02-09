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

public class FrmListaVenta extends JInternalFrame{
    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    JScrollPane jscTabla;
    public FrmListaVenta(){
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        lblTitulo = new JLabel("Listado Venta");
        tabla= new JTable();
        jscTabla = new JScrollPane(tabla);
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(jscTabla, BorderLayout.CENTER);
        cargarTabla();        
    }
        public void cargarTabla(){
        modelo= new DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Venta");
        modelo.addColumn("Fecha");
        modelo.addColumn("Vendedor");   
        
        List<Ventas> lista = new ArrayList<>();
        try{
            IVentas ventasDao = new VentaImpl();
            lista = ventasDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        for(Ventas est : lista){
            modelo.addRow(new Object[]{ est.getCodigo(), est.getCliente().getCodigo(),
               est.getFecha(), est.getVendedor().getNombre()});
        }
        tabla.setModel(modelo);
    }
       
}