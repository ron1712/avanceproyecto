package ec.com.arcotel.anegocio.vistas;

import ec.com.arcotel.anegocio.dao.IDetalleSalida;
import ec.com.arcotel.anegocio.dao.ISalida;
import ec.com.arcotel.anegocio.dao.IProducto;
import ec.com.arcotel.anegocio.entidades.DetalleSalida;
import ec.com.arcotel.anegocio.entidades.Salida;
import ec.com.arcotel.anegocio.entidades.Producto;
import ec.com.arcotel.anegocio.impl.DetalleSalidaImpl;
import ec.com.arcotel.anegocio.impl.SalidaImpl;
import ec.com.arcotel.anegocio.impl.ProductoImpl;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrmNuevoDetalleSalida extends JInternalFrame{
     List <Salida> lstSalida; 
    
    List<Producto> lstProducto;
    
    JComboBox<Salida> cmbSalida;
    JComboBox<Producto> cmbProducto;
    
    JLabel Titulo;
    JLabel Salida;
    JLabel Producto;
    JLabel Cantidad;
    JTextField txtCantidad;

    
    JButton btnLimpiar;
    JButton btnAceptar;
    
    
    
    JPanel pnlA;
    JPanel pnlB;
    
    public FrmNuevoDetalleSalida(){
        
        this.setSize(800, 400);
        this.setLayout(new BorderLayout());
        this.setBackground(Color.CYAN);
        pnlA = new JPanel();
        pnlB = new JPanel();
        
        pnlA.setLayout(new GridLayout(12, 2, 5, 5));
        pnlB.setLayout(new GridLayout(1, 2, 5, 5));
        
        Titulo = new JLabel("DATOS DE LA DETALLE SALIDA");
        
        Salida = new JLabel("SALIDA");
        Producto = new JLabel("PRODUCTO");
        Cantidad = new JLabel("VALOR COMPRA");
        
        
        txtCantidad = new JTextField();
        cargarProducto();
        cmbProducto = new JComboBox(lstProducto.toArray());
        cargarSalida();
        cmbSalida = new JComboBox(lstSalida.toArray());
        btnAceptar = new JButton("ACEPTAR");
        btnLimpiar = new JButton("LIMPIAR");
        
        this.add(Titulo, BorderLayout.NORTH);
        
        pnlA.add(Salida);
        pnlA.add(cmbSalida);
        pnlA.add(Producto);
        pnlA.add(cmbProducto);
        pnlA.add(Cantidad);
        pnlA.add(txtCantidad);
        pnlB.add(btnAceptar);
        pnlB.add(btnLimpiar);
        
        
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    try {
                    btnAceptarActionListener(e);
                } catch (Exception ex) {
                    System.out.print("error " + ex.getMessage());
                }
            
            }
        });
        
        this.add(Titulo, BorderLayout.NORTH);
        this.add(pnlA, BorderLayout.CENTER);
        this.add(pnlB, BorderLayout.SOUTH);
        this.setClosable(true);
        
    }
    
       public static void main(String[] args) {

        FrmNuevoDetalleSalida frmcompra = new FrmNuevoDetalleSalida();
        frmcompra.setVisible(true);

    }
       
       
     public void btnAceptarActionListener(ActionEvent e) {      
         
         
             IDetalleSalida tiendaDao = new DetalleSalidaImpl();
             DetalleSalida ntienda = new DetalleSalida();
             ntienda.setSalida((Salida) cmbSalida.getSelectedItem());
             ntienda.setProducto((Producto) cmbProducto.getSelectedItem());
             ntienda.setCantidad(Integer.parseInt(txtCantidad.getText()));
                           
              try{
                  
                  if (tiendaDao.insertar(ntienda) > 0) {

                JOptionPane.showMessageDialog(this, "PROCESO CORRECTO!!", "Transaction", JOptionPane.INFORMATION_MESSAGE);

             }
            } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "PROCESO CORRECTO!!", "Transaction", JOptionPane.INFORMATION_MESSAGE);
        }  
     }
         

    private void cargarProducto() {
        
        IProducto productoDao = new ProductoImpl();
        try{
            
            lstProducto = productoDao.obtener();
            
        }catch(Exception ex){
             JOptionPane.showMessageDialog(this, "ERROR AL CARGAR LOS PRODUCTOS!!", "Transaction", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarSalida() {
       
        ISalida personaDao = new SalidaImpl();
        try{
            
            lstSalida = personaDao.obtener();
            
        }catch(Exception ex){
             JOptionPane.showMessageDialog(this, "ERROR AL CARGAR LAS PERSONAS!!", "Transaction", JOptionPane.ERROR_MESSAGE);
        }
    
    }
}
