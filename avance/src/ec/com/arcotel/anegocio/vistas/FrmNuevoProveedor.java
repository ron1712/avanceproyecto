package ec.com.arcotel.anegocio.vistas;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import ec.com.arcotel.anegocio.dao.*;
import ec.com.arcotel.anegocio.impl.*;
import ec.com.arcotel.anegocio.entidades.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class FrmNuevoProveedor extends JInternalFrame{    
    JLabel lblCodigo;
    JLabel lblCedula;
    JLabel lblNombres;
    JLabel lblApellidos;   
    JLabel lblDireccion;
    JLabel lblTelefono; 
    JLabel lblEmail;
    JLabel lblTitulo0;
    
    JTextField txtCodigo;
    JTextField txtCedula;
    JTextField txtNombres;
    JTextField txtApellidos;
    JTextField txtTelefono; 
    JTextField txtDireccion;
    JTextField txtEmail;
   
    
    JButton btnLimpiar;
    JButton btnAceptar;
    
    JPanel pnlCentral;
    JPanel pnlPie;
    public FrmNuevoProveedor() {
        this.setSize(400, 400);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(11, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("Datos Proveedor");
        
        lblCodigo= new JLabel("Código:");
        lblNombres= new JLabel("Nombres:");
        lblApellidos= new JLabel("Apellidos:");        
        lblCedula= new JLabel("Cédula:");
        lblDireccion= new JLabel("Dirección:");
        lblTelefono= new JLabel("Teléfono:");
        lblEmail=new JLabel("Email");
        

        txtCodigo = new JTextField(2);
        txtCedula= new JTextField(2);
        txtNombres= new JTextField(2);
        txtApellidos= new JTextField(2);
        txtTelefono= new JTextField(2); 
        txtDireccion= new JTextField(2); 
        txtEmail= new JTextField(2);         
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblCodigo);
        pnlCentral.add(txtCodigo);
        pnlCentral.add(lblCedula);
        pnlCentral.add(txtCedula);
        pnlCentral.add(lblNombres);
        pnlCentral.add(txtNombres);
        pnlCentral.add(lblApellidos);
        pnlCentral.add(txtApellidos);
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
        FrmNuevoProveedor frmMenu= new FrmNuevoProveedor();
        frmMenu.setVisible(true);
    }    
    public void btnAceptarActionListener(ActionEvent e){
        IProveedor proveedorDao = new ProveedorImpl();
        Proveedor proveedor = new Proveedor();
        proveedor.setCodigo(Integer.parseInt(txtCodigo.getText()));
        proveedor.setNombre(txtNombres.getText());
        proveedor.setApellido(txtApellidos.getText());        
        proveedor.setCedula(txtCedula.getText());
        proveedor.setDireccion(txtDireccion.getText());      
        proveedor.setTelefono(txtTelefono.getText());                              
        proveedor.setEmail(txtEmail.getText());
        try {
            if(proveedorDao.insertar(proveedor)>0){
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
 