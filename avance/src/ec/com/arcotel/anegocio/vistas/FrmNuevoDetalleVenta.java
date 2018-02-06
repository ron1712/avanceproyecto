package ec.com.arcotel.anegocio.vistas;

import ec.com.arcotel.anegocio.dao.IDetalleVenta;
import ec.com.arcotel.anegocio.dao.IProducto;
import ec.com.arcotel.anegocio.dao.IVentas;
import ec.com.arcotel.anegocio.entidades.Detalleventa;
import ec.com.arcotel.anegocio.entidades.Producto;
import ec.com.arcotel.anegocio.entidades.Ventas;
import ec.com.arcotel.anegocio.impl.DetalleVentaImpl;
import ec.com.arcotel.anegocio.impl.ProductoImpl;
import ec.com.arcotel.anegocio.impl.VentaImpl;
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

public class FrmNuevoDetalleVenta extends JInternalFrame{
     List <Ventas> lstVentas; 
    
    List<Producto> lstProducto;
    
    JComboBox<Ventas> cmbVentas;
    JComboBox<Producto> cmbProducto;
    
    JLabel Titulo;
    JLabel Ventas;
    JLabel Producto;
    JLabel Cantidad;
    JTextField txtCantidad;

    
    JButton btnLimpiar;
    JButton btnAceptar;
    
    
    
    JPanel pnlA;
    JPanel pnlB;
    
    public FrmNuevoDetalleVenta(){
        
        this.setSize(800, 400);
        this.setLayout(new BorderLayout());
        this.setBackground(Color.CYAN);
        pnlA = new JPanel();
        pnlB = new JPanel();
        
        pnlA.setLayout(new GridLayout(12, 2, 5, 5));
        pnlB.setLayout(new GridLayout(1, 2, 5, 5));
        
        Titulo = new JLabel("DATOS DE LA DETALE ENTRADA");
        
        Ventas = new JLabel("NOMBRE DE LA ENTRADA");
        Producto = new JLabel("PRODUCTO");
        Cantidad = new JLabel("VALOR COMPRA");
        
        
        txtCantidad = new JTextField();
        cargarProducto();
        cmbProducto = new JComboBox(lstProducto.toArray());
        cargarVentas();
        cmbVentas = new JComboBox(lstVentas.toArray());
        btnAceptar = new JButton("ACEPTAR");
        btnLimpiar = new JButton("LIMPIAR");
        
        this.add(Titulo, BorderLayout.NORTH);
        
        pnlA.add(Ventas);
        pnlA.add(cmbVentas);
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

        FrmNuevoDetalleVenta frmcompra = new FrmNuevoDetalleVenta();
        frmcompra.setVisible(true);

    }
       
       
     public void btnAceptarActionListener(ActionEvent e) {      
         
         
             IDetalleVenta tiendaDao = new DetalleVentaImpl();
             Detalleventa ntienda = new Detalleventa();
             ntienda.setVentas((Ventas) cmbVentas.getSelectedItem());
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

    private void cargarVentas() {
       
        IVentas personaDao = new VentaImpl();
        try{
            
            lstVentas = personaDao.obtener();
            
        }catch(Exception ex){
             JOptionPane.showMessageDialog(this, "ERROR AL CARGAR LAS PERSONAS!!", "Transaction", JOptionPane.ERROR_MESSAGE);
        }
    
    }
    
}
