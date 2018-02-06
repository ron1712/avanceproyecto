package ec.com.arcotel.anegocio.vistas;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import ec.com.arcotel.anegocio.dao.*;
import ec.com.arcotel.anegocio.impl.*;
import ec.com.arcotel.anegocio.entidades.*;
import java.util.List;

public class FrmNuevoCliente extends JInternalFrame{
    
    JLabel lblCodigo;
    JLabel lblCedula;
    JLabel lblNombre;
    JLabel lblApellido;
    JLabel lblTelefono;
    JLabel lblEmail;
    JLabel lblDireccion;
  
    JLabel lblTitulo0;
    
    JTextField txtCodigo;
    JTextField txtCedula;
    JTextField txtNombre;
    JTextField txtApellido;
    JTextField txtTelefono;
    JTextField txtEmail;     
    JTextField txtDireccion;
   
    
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
        
        lblCodigo= new JLabel("Código:");
        lblCedula= new JLabel("Cédula:");
        lblNombre= new JLabel("Nombres:");
        lblApellido= new JLabel("Apellidos:");
        lblEmail= new JLabel("Email:");
        lblTelefono= new JLabel("Teléfono:");
        lblDireccion= new JLabel("Dirección:");
        

        txtCodigo = new JTextField(2);
        txtCedula= new JTextField(2);
        txtNombre= new JTextField(2);
        txtApellido= new JTextField(2);
        txtEmail= new JTextField(2);
        txtTelefono= new JTextField(2);        
        txtDireccion= new JTextField(2); 
       
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblCodigo);
        pnlCentral.add(txtCodigo);
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
        cliente.setCodigo(Integer.parseInt(txtCodigo.getText()));
        cliente.setCedula(txtCedula.getText());
        cliente.setNombre(txtNombre.getText());
        cliente.setApellido(txtApellido.getText());
        cliente.setEmail(txtEmail.getText());
        cliente.setTelefono(txtTelefono.getText());
        cliente.setDireccion(txtDireccion.getText());
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
 