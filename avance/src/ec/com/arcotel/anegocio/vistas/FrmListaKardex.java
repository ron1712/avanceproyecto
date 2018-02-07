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

public class FrmListaKardex extends JInternalFrame{
    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    JScrollPane jscTabla;
    public FrmListaKardex(){
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        lblTitulo = new JLabel("Listado Kardex");
        tabla= new JTable();
        jscTabla = new JScrollPane(tabla);
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(jscTabla, BorderLayout.CENTER);
        cargarTabla();        
    }
        public void cargarTabla(){
        modelo= new DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Producto");
        modelo.addColumn("Entrada");
        modelo.addColumn("Salida");        
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio compra");
        modelo.addColumn("Precio venta");        
        modelo.addColumn("Cantidad inicial");
        modelo.addColumn("Cantdad actual");
        
        List<Kardex> lista = new ArrayList<>();
        try{
            IKardex kardexDao = new KardexImpl();
            lista = kardexDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        for(Kardex est : lista){
            modelo.addRow(new Object[]{ est.getCodigo(), est.getProducto().getCodigo(),
               est.getEntrada().getCodigo(),est.getSalida().getCodigo(), est.getCantidad(),
               est.getPreciocompra(),est.getPrecioventa(),est.getCantidadinicial(),est.getCantidadactual() });
        }
        tabla.setModel(modelo);
    }
       
}
