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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    JLabel Fecha;
    JLabel Total;
    JTextField txtCantidad;
    JTextField txtFecha;
    JTextField txtTotal;
    
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
        
        pnlA.setLayout(new GridLayout(10, 2, 5, 5));
        pnlB.setLayout(new GridLayout(1, 2, 5, 5));
        
        Titulo = new JLabel("DATOS DE LA DETALLE VENTA");
        
        Ventas = new JLabel("VENTA");
        Producto = new JLabel("PRODUCTO");
        Cantidad = new JLabel("CANTIDAD");
        Fecha =new JLabel("FECHA:");
        Total = new JLabel("TOTAL");
        
        
        
        cargarProducto();
        cmbProducto = new JComboBox(lstProducto.toArray());
        cargarVentas();
        cmbVentas = new JComboBox(lstVentas.toArray());
        txtCantidad = new JTextField(2);
        txtFecha = new JTextField(2);
        txtTotal = new JTextField(2);
        btnAceptar = new JButton("ACEPTAR");
        btnLimpiar = new JButton("LIMPIAR");
        
        this.add(Titulo, BorderLayout.NORTH);
        
        pnlA.add(Ventas);
        pnlA.add(cmbVentas);
        pnlA.add(Producto);
        pnlA.add(cmbProducto);
        pnlA.add(Cantidad);
        pnlA.add(txtCantidad);
        pnlA.add(Fecha);
        pnlA.add(txtFecha);
        pnlA.add(Total);
        pnlA.add(txtTotal);
       
        pnlB.add(btnLimpiar);
        pnlB.add(btnAceptar);
        
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
         
         
             IDetalleVenta detalleventaDao = new DetalleVentaImpl();
             Detalleventa detalleventa = new Detalleventa();
             detalleventa.setVentas((Ventas) cmbVentas.getSelectedItem());
             detalleventa.setProducto((Producto) cmbProducto.getSelectedItem());
             detalleventa.setCantidad(Integer.parseInt(txtCantidad.getText())); 
             DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
             try {                        
                 detalleventa.setFecha( formatoFecha.parse(txtFecha.getText()));            
             } catch (Exception ex) {
                   JOptionPane.showMessageDialog(this,"Error en la fecha!!",
                "Transacción", JOptionPane.INFORMATION_MESSAGE);
            }             
            detalleventa.setTotal(Double.parseDouble(txtTotal.getText()));
            try{
                  
                  if (detalleventaDao.insertar(detalleventa) > 0) {

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
        IVentas ventasDao = new VentaImpl();
        try{            
            lstVentas = ventasDao.obtener();
            
        }catch(Exception ex){
             JOptionPane.showMessageDialog(this, "ERROR AL CARGAR LAS VENTAS!!", "Transaction", JOptionPane.ERROR_MESSAGE);
        }
    
    }
    
}
