package ec.com.arcotel.anegocio.vistas;

import ec.com.arcotel.anegocio.dao.IEntrada;
import ec.com.arcotel.anegocio.dao.IProducto;
import ec.com.arcotel.anegocio.entidades.DetalleCompra;
import ec.com.arcotel.anegocio.entidades.Entrada;
import ec.com.arcotel.anegocio.entidades.Producto;
import ec.com.arcotel.anegocio.impl.DetalleCompraImpl;
import ec.com.arcotel.anegocio.impl.EntradaImpl;
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
import ec.com.arcotel.anegocio.dao.IDetalleCompra;

public class FrmNuevoDetalleEntrada extends JInternalFrame{
    
    List <Entrada> lstEntrada; 
    
    List<Producto> lstProducto;
    
    JComboBox<Entrada> cmbEntrada;
    JComboBox<Producto> cmbProducto;
    
    JLabel Titulo;
    JLabel Entrada;
    JLabel Producto;
    JLabel Preciocompra;
    JTextField txtPreciocompra;

    
    JButton btnLimpiar;
    JButton btnAceptar;
    
    
    
    JPanel pnlA;
    JPanel pnlB;
    
    public FrmNuevoDetalleEntrada(){
        
        this.setSize(800, 400);
        this.setLayout(new BorderLayout());
        this.setBackground(Color.CYAN);
        pnlA = new JPanel();
        pnlB = new JPanel();
        
        pnlA.setLayout(new GridLayout(12, 2, 5, 5));
        pnlB.setLayout(new GridLayout(1, 2, 5, 5));
        
        Titulo = new JLabel("DATOS DE LA DETALLE ENTRADA");
        
        Entrada = new JLabel("ENTRADA");
        Producto = new JLabel("PRODUCTO");
        Preciocompra = new JLabel("PRECIO COMPRA");
        
        
        txtPreciocompra = new JTextField();
        cargarProducto();
        cmbProducto = new JComboBox(lstProducto.toArray());
        cargarEntrada();
        cmbEntrada = new JComboBox(lstEntrada.toArray());
        btnAceptar = new JButton("ACEPTAR");
        btnLimpiar = new JButton("LIMPIAR");
        
        this.add(Titulo, BorderLayout.NORTH);
        
        pnlA.add(Entrada);
        pnlA.add(cmbEntrada);
        pnlA.add(Producto);
        pnlA.add(cmbProducto);
        pnlA.add(Preciocompra);
        pnlA.add(txtPreciocompra);
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

        FrmNuevoDetalleEntrada frm = new FrmNuevoDetalleEntrada();
        frm.setVisible(true);

    }         
     public void btnAceptarActionListener(ActionEvent e) {                  
             IDetalleCompra detalleentradaDao = new DetalleCompraImpl();
             DetalleCompra detalleentrada = new DetalleCompra();
             detalleentrada.setEntrada((Entrada) cmbEntrada.getSelectedItem());
             detalleentrada.setProducto((Producto) cmbProducto.getSelectedItem());
             detalleentrada.setPreciocompra(Integer.parseInt(txtPreciocompra.getText()));
            try{                  
                  if (detalleentradaDao.insertar(detalleentrada) > 0) {

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

    private void cargarEntrada() {       
        IEntrada entradaDao = new EntradaImpl();
        try{            
            lstEntrada = entradaDao.obtener();
            
        }catch(Exception ex){
             JOptionPane.showMessageDialog(this, "ERROR AL CARGAR LAS ENTRADAS!!", "Transaction", JOptionPane.ERROR_MESSAGE);
        }
    
    }
    
}   

