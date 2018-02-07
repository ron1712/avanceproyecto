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

public class FrmNuevoSalida extends JInternalFrame{ 
    JLabel lblCodigo;
    JLabel lblFecha;
    JLabel lblValorcompra;
    JLabel lblDetalle;
    
    JLabel lblTitulo0;
    
    JTextField txtCodigo;
    JTextField txtFecha;
    JTextField txtValorcompra;   
    JTextField txtDetalle;
    
    JButton btnLimpiar;
    JButton btnAceptar;
    
    JPanel pnlCentral;
    JPanel pnlPie;
    public FrmNuevoSalida(){   
        
        this.setSize(200, 200);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(5, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("Datos Salida");
        
        lblCodigo= new JLabel("Código:");
        lblFecha= new JLabel("Fecha:");
        lblValorcompra= new JLabel("Valor compra:");
        lblDetalle= new JLabel("Detalle:");
        
        txtCodigo = new JTextField(2);
        txtFecha= new JTextField(2);
        txtValorcompra= new JTextField(2);
        txtDetalle = new JTextField(2);
        
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblCodigo);
        pnlCentral.add(txtCodigo);
        pnlCentral.add(lblFecha);
        pnlCentral.add(txtFecha);
        pnlCentral.add(lblValorcompra);
        pnlCentral.add(txtValorcompra);
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
        FrmNuevoSalida frmMenu= new FrmNuevoSalida();
        frmMenu.setVisible(true);
    } 
    
    public void btnAceptarActionListener(ActionEvent e){
        ISalida salidaDao = new SalidaImpl();
        Salida salida = new Salida();
        salida.setCodigo(Integer.parseInt(txtCodigo.getText()));       
        DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        try {                        
            salida.setFecha( formatoFecha.parse(txtFecha.getText()));            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Error en la fecha!!",
                "Transacción", JOptionPane.INFORMATION_MESSAGE);
        }
        salida.setValorcompra(Double.parseDouble(txtValorcompra.getText()));  
        salida.setDetalle(txtDetalle.getText());
        try {
            if(salidaDao.insertar(salida)>0){
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
 