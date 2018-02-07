package ec.com.arcotel.anegocio.vistas;

import ec.com.arcotel.anegocio.dao.IProducto;
import ec.com.arcotel.anegocio.entidades.Producto;
import ec.com.arcotel.anegocio.impl.ProductoImpl;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class FrmListaProducto  extends JInternalFrame{
    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
      public FrmListaProducto(){
          this.setSize(800,600);
          this.setLayout(new BorderLayout());
          this.setClosable(true);
          lblTitulo=new  JLabel("listado de producto");
          tabla=new JTable();
          this.add(lblTitulo,BorderLayout.NORTH);
          this.add(tabla,BorderLayout.CENTER);
          cargarTabla();
          
      }
      public void cargarTabla(){
        modelo=new DefaultTableModel();
        modelo.addColumn("codigo");
        modelo.addColumn("nombre");
        modelo.addColumn("cantidad");
        modelo.addColumn("valor unitario");
        modelo.addColumn("descripcion");
        
        
        List<Producto>lista=new ArrayList<>();
        try{
             IProducto productoDao= new ProductoImpl();
             lista= productoDao.obtener();
        }catch(Exception e){
        JOptionPane.showMessageDialog(this, e.getMessage(),"error",JOptionPane.ERROR_MESSAGE);
        
        }
        for(Producto pro: lista){
        modelo.addRow(new Object[]{pro.getCodigo(),pro.getNombre(),
            pro.getCantidad(),pro.getPreciounitario(),pro.getDescripcion()});
        }
        tabla.setModel(modelo);
      }
      
}
