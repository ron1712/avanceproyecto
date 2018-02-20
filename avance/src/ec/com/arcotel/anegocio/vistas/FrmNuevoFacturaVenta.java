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

public class FrmNuevoFacturaVenta extends JInternalFrame{
    JLabel lblCodigo;
    List<Cliente> lstCliente;
    JComboBox<Cliente> cmbCliente;
    JLabel lblCliente;
    JLabel lblFecha;  
    JLabel lblTitulo0;
    
    JTextField txtCodigo;
    JTextField txtFecha;     
    
    JButton btnLimpiar;
    JButton btnAceptar;
    
    JPanel pnlCentral;
    JPanel pnlPie;
    
    public FrmNuevoFacturaVenta() {
        this.setSize(300, 300);
        this.setLayout(new BorderLayout());
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(5, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("Datos FacturaVenta");
        
        lblCodigo= new JLabel("Código:");        
        lblFecha= new JLabel("Fecha:");
        lblCliente= new JLabel("Cliente:");        
        
        txtCodigo = new JTextField(2);
        cargarClientes();
        cmbCliente= new JComboBox(lstCliente.toArray());
        txtFecha= new JTextField(2);       
        
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblCodigo);
        pnlCentral.add(txtCodigo);
        pnlCentral.add(lblFecha);
        pnlCentral.add(txtFecha);
         pnlCentral.add(lblCliente);
        pnlCentral.add(cmbCliente);        
              
        
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
        FrmNuevoFacturaVenta frmMenu= new FrmNuevoFacturaVenta();
        frmMenu.setVisible(true);
    } 
    public void cargarClientes(){
        ICliente proveedorDao = new ClienteImpl();
        try {
            lstCliente = proveedorDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al cargar los clientes!!",
                "Error"+e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }       
    }
    
    public void btnAceptarActionListener(ActionEvent e){
        try {
            IFacturaVenta facturacompraDao = new FacturaVentaImpl();
            FacturaVenta facturacompra = new FacturaVenta();
            facturacompra.setCodigo(txtCodigo.getText());                      
            DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            try {                        
            facturacompra.setFecha( formatoFecha.parse(txtFecha.getText()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Error en la fecha!!",
                "Transacción", JOptionPane.INFORMATION_MESSAGE);            
        }
              facturacompra.setCliente((Cliente)cmbCliente.getSelectedItem());
            
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