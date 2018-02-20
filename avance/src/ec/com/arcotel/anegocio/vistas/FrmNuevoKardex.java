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

public class FrmNuevoKardex extends JInternalFrame{    
    JLabel lblCodigo;
    List<Producto> lstProducto;
    JComboBox<Producto> cmbProducto;
    JLabel lblProducto;    
    JLabel lblFecha_Emision;
    JLabel lblTipo_Transaccion;
    JLabel lblExistencias;
    JLabel lblValor_Total;
    JLabel lblTitulo0;
    
    JTextField txtCodigo;
    JTextField txtFecha_Emision;
    JTextField txtTipo_Transaccion;
    JTextField txtExistencias;
    JTextField txtValor_Total;
    
    JButton btnLimpiar;
    JButton btnAceptar;
    
    JPanel pnlCentral;
    JPanel pnlPie;
    public FrmNuevoKardex() {
        this.setSize(400, 400);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(11, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("Datos Kardex");
        
        lblCodigo= new JLabel("Código:");
        lblProducto= new JLabel("Producto:");        
        lblFecha_Emision= new JLabel("Fecha_Emision:");
        lblTipo_Transaccion= new JLabel("Tipo transaccion:");
        lblExistencias= new JLabel("Existencias:");
        lblValor_Total= new JLabel("Valor total:");

        txtCodigo = new JTextField(2);
        cargarProductos();
        cmbProducto= new JComboBox(lstProducto.toArray());        
        txtFecha_Emision= new JTextField(2);
        txtTipo_Transaccion= new JTextField(2);
        txtExistencias= new JTextField(2);
        txtValor_Total= new JTextField(2);             
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblCodigo);
        pnlCentral.add(txtCodigo);
        pnlCentral.add(lblProducto);
        pnlCentral.add(cmbProducto);
        pnlCentral.add(lblFecha_Emision);
        pnlCentral.add(txtFecha_Emision);
        pnlCentral.add(lblTipo_Transaccion);
        pnlCentral.add(txtTipo_Transaccion);
        pnlCentral.add(lblExistencias);
        pnlCentral.add(txtExistencias);
        pnlCentral.add(lblValor_Total);
        pnlCentral.add(txtValor_Total);                           
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
        FrmNuevoKardex frmMenu= new FrmNuevoKardex();
        frmMenu.setVisible(true);
    }    
     public void cargarProductos(){
        IProducto productoDao = new ProductoImpl();
        try {
            lstProducto = productoDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al cargar los productos!!",
                "Error"+e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }       
    }    
    public void btnAceptarActionListener(ActionEvent e){
        IKardex kardexDao = new KardexImpl();
        Kardex kardex = new Kardex();
        kardex.setCodigo(Integer.parseInt(txtCodigo.getText()));
        kardex.setProducto((Producto) cmbProducto.getSelectedItem());
        kardex.setTipo_transaccion(txtTipo_Transaccion.getText());                    
        DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        try {                        
            kardex.setFecha_emision(formatoFecha.parse(txtFecha_Emision.getText()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Error en la fecha!!",
                "Transacción", JOptionPane.INFORMATION_MESSAGE);
        }
        kardex.setExistencias(Integer.parseInt(txtExistencias.getText()));
        kardex.setValor_total(Double.parseDouble(txtValor_Total.getText()));
        try {
            if(kardexDao.insertar(kardex)>0){
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
 
