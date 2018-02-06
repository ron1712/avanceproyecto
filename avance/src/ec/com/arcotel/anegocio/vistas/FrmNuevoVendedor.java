package ec.com.arcotel.anegocio.vistas;
import ec.com.arcotel.anegocio.entidades.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import ec.com.arcotel.anegocio.dao.*;
import ec.com.arcotel.anegocio.impl.*;
import java.util.List;

public class FrmNuevoVendedor extends JInternalFrame{    
    JLabel lblLogin;    
    JLabel lblClave;
    JLabel lblNombres;
    JLabel lblApellidos;
    JLabel lblCedula;  
    JLabel lblDireccion;
    JLabel lblTelefono; 
    JLabel lblEmail;    
    JLabel lblTitulo0;
    
    JTextField txtLogin;
    JTextField txtClave;
    JTextField txtNombres;
    JTextField txtApellidos;
    JTextField txtCedula;
    JTextField txtDireccion;
    JTextField txtTelefono;
    JTextField txtEmail;   
    
    JButton btnLimpiar;
    JButton btnAceptar;
    
    JPanel pnlCentral;
    JPanel pnlPie;
    public FrmNuevoVendedor() {
        this.setSize(400, 400);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("Datos Vendedor");
        
        lblLogin= new JLabel("Login:");
        lblClave= new JLabel("Clave:");
        lblNombres= new JLabel("Nombres:");
        lblApellidos= new JLabel("Apellidos:");
        lblCedula= new JLabel("Cedula:");
        lblDireccion= new JLabel("Dirección:");
        lblTelefono= new JLabel("Teléfono:");
        lblEmail= new JLabel("Email:");

        txtLogin = new JTextField(2);
        txtClave= new JTextField(2);
        txtNombres= new JTextField(2);
        txtApellidos= new JTextField(2);
        txtCedula= new JTextField(2);
        txtDireccion= new JTextField(2);  
        txtTelefono= new JTextField(2);   
        txtEmail= new JTextField(2);
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblLogin);
        pnlCentral.add(txtLogin);
        pnlCentral.add(lblClave);
        pnlCentral.add(txtClave);
        pnlCentral.add(lblNombres);
        pnlCentral.add(txtNombres);
        pnlCentral.add(lblApellidos);
        pnlCentral.add(txtApellidos);
        pnlCentral.add(lblCedula);
        pnlCentral.add(txtCedula);
        pnlCentral.add(lblDireccion);
        pnlCentral.add(txtDireccion);
        pnlCentral.add(lblTelefono);
        pnlCentral.add(txtTelefono);    
        pnlCentral.add(lblEmail);
        pnlCentral.add(txtEmail);  
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
        FrmNuevoVendedor frmMenu= new FrmNuevoVendedor();
        frmMenu.setVisible(true);
    }    
    public void btnAceptarActionListener(ActionEvent e){
        IVendedor vendedorDao = new VendedorImpl();
        Vendedor vendedor = new Vendedor();
        vendedor.setLogin(txtLogin.getText());
        vendedor.setClave(txtClave.getText());
        vendedor.setNombre(txtNombres.getText());
        vendedor.setApellido(txtApellidos.getText()); 
        vendedor.setCedula(txtCedula.getText());
        vendedor.setDireccion(txtDireccion.getText());      
        vendedor.setTelefono(txtTelefono.getText());                      
        vendedor.setEmail(txtEmail.getText());
        try {
            if(vendedorDao.insertar(vendedor)>0){
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
 
