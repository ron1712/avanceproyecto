package ec.com.arcotel.anegocio.vistas;

import ec.com.arcotel.anegocio.entidades.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import ec.com.arcotel.anegocio.dao.*;
import ec.com.arcotel.anegocio.impl.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class FrmNuevoEntrada extends JInternalFrame{    
    List<Proveedor> lstProveedor;
    JComboBox<Proveedor> cmbProveedor;
    JLabel lblCodigo;
    JLabel lblProveedor;
    JLabel lblFecha;
    JLabel lblValortotal;
    JLabel lblDetalle;
    JLabel lblTitulo0;
    
    JTextField txtCodigo;
    JTextField txtFecha;
    JTextField txtValortotal;
    JTextField txtDetalle;
 
    JButton btnLimpiar;
    JButton btnAceptar;
    
    JPanel pnlCentral;
    JPanel pnlPie;
    public FrmNuevoEntrada() {
        this.setSize(400, 400);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(5, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("Datos Entrada");        
        lblCodigo= new JLabel("Código:");
        lblProveedor= new JLabel("Proveedor:");
        lblFecha= new JLabel("Fecha:");
        lblValortotal= new JLabel("Valor total:");
        lblDetalle= new JLabel("Detalle:");
        
        txtCodigo = new JTextField(2);        
        cargarProveedores();
        cmbProveedor= new JComboBox(lstProveedor.toArray());
        txtFecha= new JTextField(2);
        txtValortotal= new JTextField(2);                
        txtDetalle = new JTextField(2);
        
        btnAceptar= new JButton("Aceptar");
        btnLimpiar= new JButton("Limpiar");
        
        pnlCentral.add(lblCodigo);
        pnlCentral.add(txtCodigo);        
        pnlCentral.add(lblProveedor);
        pnlCentral.add(cmbProveedor);
        pnlCentral.add(lblFecha);
        pnlCentral.add(txtFecha);
        pnlCentral.add(lblValortotal);
        pnlCentral.add(txtValortotal);       
        pnlCentral.add(lblDetalle);
        pnlCentral.add(txtDetalle);       
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
    }
    public static void main(String[] args) {
        FrmNuevoEntrada frmMenu= new FrmNuevoEntrada();
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
        IEntrada entradaDao = new EntradaImpl();
        Entrada entrada = new Entrada();
        entrada.setCodigo(Integer.parseInt(txtCodigo.getText()));
        entrada.setProveedor((Proveedor) cmbProveedor.getSelectedItem());
        DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        try {                        
            entrada.setFecha(formatoFecha.parse(txtFecha.getText()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Error en la fecha!!",
                "Transacción", JOptionPane.INFORMATION_MESSAGE);
        }
        entrada.setValortotal(Double.parseDouble(txtValortotal.getText()));      
        entrada.setDetalle(txtDetalle.getText());
        
        try {
            if(entradaDao.insertar(entrada)>0){
                JOptionPane.showMessageDialog(this,"Guaradado correctamente!!",
                "Transacción", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this,"Error desconocido!!",
                "Transacción", JOptionPane.INFORMATION_MESSAGE);
            }           
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Error al guardar!!: " + ex.getMessage(),
                "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
}
 