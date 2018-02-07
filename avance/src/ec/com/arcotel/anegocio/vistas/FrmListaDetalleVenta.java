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

public class FrmListaDetalleVenta extends JInternalFrame{
    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    JScrollPane jscTabla;
    public FrmListaDetalleVenta(){
        this.setSize(600, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        lblTitulo = new JLabel("Listado DetalleVentas");
        tabla= new JTable();
        jscTabla = new JScrollPane(tabla);
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(jscTabla, BorderLayout.CENTER);
        cargarTabla();        
    }
        public void cargarTabla(){
        modelo= new DefaultTableModel();
        modelo.addColumn("Venta");
        modelo.addColumn("Producto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Fecha");
        modelo.addColumn("Total");
        
        List<Detalleventa> lista = new ArrayList<>();
        try{
            IDetalleVenta detalleventasDao = new DetalleVentaImpl();
            lista = detalleventasDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        for(Detalleventa est : lista){
            modelo.addRow(new Object[]{ est.getVentas().getCodigo(), est.getProducto().getCodigo(),
               est.getFecha(), est.getTotal()});
        }
        tabla.setModel(modelo);
    }
       
}
