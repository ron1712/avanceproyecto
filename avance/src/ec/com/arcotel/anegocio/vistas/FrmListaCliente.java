package ec.com.arcotel.anegocio.vistas;

import ec.com.arcotel.anegocio.dao.ICliente;
import ec.com.arcotel.anegocio.entidades.Cliente;
import ec.com.arcotel.anegocio.impl.ClienteImpl;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class FrmListaCliente  extends JInternalFrame{
    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
      public FrmListaCliente(){
          this.setSize(800,600);
          this.setLayout(new BorderLayout());
          this.setClosable(true);
          lblTitulo=new  JLabel("listado de cliente");
          tabla=new JTable();
          this.add(lblTitulo,BorderLayout.NORTH);
          this.add(tabla,BorderLayout.CENTER);
          cargarTabla();
          
      }
      public void cargarTabla(){
        modelo=new DefaultTableModel();
        modelo.addColumn("codigo");
        modelo.addColumn("cedula");
        modelo.addColumn("nombres");
        modelo.addColumn("apellidos");
        modelo.addColumn("telefono");
        modelo.addColumn("direccion");
        modelo.addColumn("email");
        
        List<Cliente>lista=new ArrayList<>();
        try{
             ICliente clienteDao= new ClienteImpl();
             lista= clienteDao.obtener();
        }catch(Exception e){
        JOptionPane.showMessageDialog(this, e.getMessage(),"error",JOptionPane.ERROR_MESSAGE);
        
        }
        for(Cliente cli: lista){
        modelo.addRow(new Object[]{cli.getCodigo(),cli.getCedula(),cli.getNombre(),
            cli.getApellido(),cli.getTelefono(),cli.getDireccion(),cli.getEmail()});
        }
        tabla.setModel(modelo);
      }
      
}
