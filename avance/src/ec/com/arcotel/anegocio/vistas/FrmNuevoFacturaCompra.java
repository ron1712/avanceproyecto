package ec.com.arcotel.anegocio.vistas;


import ec.com.arcotel.anegocio.dao.*;
import ec.com.arcotel.anegocio.entidades.*;
import ec.com.arcotel.anegocio.impl.*;
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

public class FrmNuevoFacturaCompra extends JInternalFrame{
    JLabel lblCodigo;
    List<Proveedor> lstProveedor;
    JComboBox<Proveedor> cmbProveedor;
    JLabel lblProveedor;
    JLabel lblFecha;  
    JLabel lblTitulo0;
    
    JTextField txtCodigo;
    JTextField txtFecha;     
    
    JButton btnLimpiar;
    JButton btnAceptar;
    
    JPanel pnlCentral;
    JPanel pnlPie;
    
    public FrmNuevoFacturaCompra() {
        this.setSize(300, 300);
        this.setLayout(new BorderLayout());
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(5, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("Datos FacturaCompra");
        
        lblCodigo= new JLabel("Código:");        
        lblFecha= new JLabel("Fecha:");
        lblProveedor= new JLabel("Proveedor:");        
        
        txtCodigo = new JTextField(2);
        cargarProveedores();
        cmbProveedor= new JComboBox(lstProveedor.toArray());
        txtFecha= new JTextField(2);       
        
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblCodigo);
        pnlCentral.add(txtCodigo);
        pnlCentral.add(lblFecha);
        pnlCentral.add(txtFecha);
         pnlCentral.add(lblProveedor);
        pnlCentral.add(cmbProveedor);        
              
        
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    btnAceptarActionListener(e);
                } catch (Exception ex) {
                    System.out.println("Error:"+ex.getMessage());
                }
            }
        });
        
        pnlPie.add(btnLimpiar);
        pnlPie.add(btnAceptar);
        
        this.add(lblTitulo0, BorderLayout.NORTH);
        this.add(pnlCentral, BorderLayout.CENTER);
        this.add(pnlPie, BorderLayout.SOUTH);
        this.setClosable(true);
    }
    public static void main(String[] args) {
        FrmNuevoFacturaCompra frmMenu= new FrmNuevoFacturaCompra();
        frmMenu.setVisible(true);
    } 
    public void cargarProveedores(){
        IProveedor proveedorDao = new ProveedorImpl();
        try {
            lstProveedor = proveedorDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al cargar los proveedores!!",
                "Error"+e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }       
    }
    
    public void btnAceptarActionListener(ActionEvent e){
        try {
            IFacturaCompra facturacompraDao = new FacturaCompraImpl();
            FacturaCompra facturacompra = new FacturaCompra();
            facturacompra.setCodigo(txtCodigo.getText());                      
            DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            try {                        
            facturacompra.setFecha( formatoFecha.parse(txtFecha.getText()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Error en la fecha!!",
                "Transacción", JOptionPane.INFORMATION_MESSAGE);            
        }
              facturacompra.setProveedor((Proveedor)cmbProveedor.getSelectedItem());
            
            if(facturacompraDao.insertar(facturacompra)>0 ){
                JOptionPane.showMessageDialog(this,"Registrado correctamente!!",
                "Transacción correcta", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Error desconocido: "+ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }        
    }
}