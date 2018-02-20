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

public class FrmNuevoCliente extends JInternalFrame{
    
    JLabel lblCedula;
    JLabel lblNombre;
    JLabel lblApellido;
    JLabel lblDireccion;
    JLabel lblTelefono;
    JLabel lblEmail;
    JLabel lblFecha_nac;
  
  
    JLabel lblTitulo0;
    
    JTextField txtCedula;
    JTextField txtNombre;
    JTextField txtApellido;
    JTextField txtDireccion;
    JTextField txtTelefono;
    JTextField txtEmail;     
    JTextField txtFecha_nac;  
    
   
    
    JButton btnLimpiar;
    JButton btnAceptar;
    
    JPanel pnlCentral;
    JPanel pnlPie;
    public FrmNuevoCliente() {
        this.setSize(300, 300);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("Datos Cliente");
        
        
        lblCedula= new JLabel("Cédula:");
        lblNombre= new JLabel("Nombres:");
        lblApellido= new JLabel("Apellidos:");
        lblDireccion= new JLabel("Dirección:");
        lblEmail= new JLabel("Email:");
        lblTelefono= new JLabel("Teléfono:");
        lblFecha_nac= new JLabel("Fecha de nac:");
       
        
        txtCedula= new JTextField(2);
        txtNombre= new JTextField(2);
        txtApellido= new JTextField(2);
        txtDireccion= new JTextField(2); 
        txtEmail= new JTextField(2);
        txtTelefono= new JTextField(2);
        txtFecha_nac= new JTextField(2); 
        
       
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        
        pnlCentral.add(lblCedula);
        pnlCentral.add(txtCedula);
        pnlCentral.add(lblNombre);
        pnlCentral.add(txtNombre);
        pnlCentral.add(lblApellido);
        pnlCentral.add(txtApellido);
        pnlCentral.add(lblEmail);
        pnlCentral.add(txtEmail);
        pnlCentral.add(lblTelefono);
        pnlCentral.add(txtTelefono);
        pnlCentral.add(lblDireccion);
        pnlCentral.add(txtDireccion);
        pnlCentral.add(lblFecha_nac);
        pnlCentral.add(txtFecha_nac);
      
        
                
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
        FrmNuevoCliente frmMenu= new FrmNuevoCliente();
        frmMenu.setVisible(true);
    } 
   
       public void btnAceptarActionListener(ActionEvent e){
        ICliente clienteDao=new ClienteImpl();
        Cliente cliente=new Cliente();
        cliente.setCedula(txtCedula.getText());
        cliente.setNombre(txtNombre.getText());
        cliente.setApellido(txtApellido.getText());
        cliente.setDireccion(txtDireccion.getText());
        cliente.setEmail(txtEmail.getText());
        cliente.setTelefono(txtTelefono.getText());
        DateFormat Fecha_nac = new SimpleDateFormat("yyyy-MM-dd");
        try {                        
            cliente.setFecha_nac(Fecha_nac.parse(txtFecha_nac.getText()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Error en la fecha!!",
                "Transacción", JOptionPane.INFORMATION_MESSAGE);
        };
        
         try{
         if(clienteDao.insertar(cliente)>0){
         JOptionPane.showMessageDialog(this,"guardado correctamente!!",
                 "transaccion",JOptionPane.INFORMATION_MESSAGE);
         
         }else{
      
         JOptionPane.showMessageDialog(this,"Error desconocido!!",
                 "error",JOptionPane.ERROR_MESSAGE);
         }
         }catch(Exception ex){
         JOptionPane.showMessageDialog(this,"error al guardar:"+ ex.getMessage(),
                 "ERROR", JOptionPane.ERROR_MESSAGE);
         }
    }
}
 