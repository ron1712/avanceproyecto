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

public class FrmNuevoVenta extends JInternalFrame{
    JLabel lblCodigo;
    List<Cliente> lstCliente;
    JComboBox<Cliente> cmbCliente;
    JLabel lblCliente;
    JLabel lblFecha;    
    List<Vendedor> lstVendedor;
    JComboBox<Vendedor> cmbVendedor;
    JLabel lblVendedor;
    JLabel lblTitulo0;
    
    JTextField txtCodigo;
    JTextField txtFecha;     
    
    JButton btnLimpiar;
    JButton btnAceptar;
    
    JPanel pnlCentral;
    JPanel pnlPie;
    
    public FrmNuevoVenta() {
        this.setSize(300, 300);
        this.setLayout(new BorderLayout());
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(3, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("Datos Venta");
        
        lblCodigo= new JLabel("Código:");
        lblCliente= new JLabel("Ciente:");
        lblFecha= new JLabel("Fecha:");
        lblVendedor= new JLabel("Vendedor:");
        
        
        txtCodigo = new JTextField(2);
        cargarClientes();
        cmbCliente= new JComboBox(lstCliente.toArray());
        txtFecha= new JTextField(2);        
        cargarVendedores();
        cmbVendedor= new JComboBox(lstVendedor.toArray());
        
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblCodigo);
        pnlCentral.add(txtCodigo);
         pnlCentral.add(lblCliente);
        pnlCentral.add(cmbCliente);
        pnlCentral.add(lblFecha);
        pnlCentral.add(txtFecha);
        pnlCentral.add(lblVendedor);
        pnlCentral.add(cmbVendedor);        
        
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
        FrmNuevoVenta frmMenu= new FrmNuevoVenta();
        frmMenu.setVisible(true);
    } 
    public void cargarClientes(){
        ICliente clienteDao = new ClienteImpl();
        try {
            lstCliente = clienteDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al cargar los clientes!!",
                "Error"+e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }       
    }
    public void cargarVendedores(){
        IVendedor vendedorDao = new VendedorImpl();
        try {
            lstVendedor = vendedorDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al cargar los vendedors!!",
                "Error"+e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }       
    }
    public void btnAceptarActionListener(ActionEvent e){
        try {
            IVentas ventasDao = new VentaImpl();
            Ventas ventas = new Ventas();
            ventas.setCodigo(Integer.parseInt(txtCodigo.getText()));            
            ventas.setCliente((Cliente) cmbCliente.getSelectedItem());
            DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            try {                        
            ventas.setFecha( formatoFecha.parse(txtFecha.getText()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Error en la fecha!!",
                "Transacción", JOptionPane.INFORMATION_MESSAGE);
            ventas.setVendedor((Vendedor) cmbVendedor.getSelectedItem());
        }
            if(ventasDao.insertar(ventas)>0 ){
                JOptionPane.showMessageDialog(this,"Registrado correctamente!!",
                "Transacción correcta", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Error desconocido: "+ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }        
    }
}
 