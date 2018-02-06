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

public class FrmNuevoProducto extends JInternalFrame{
    
    JLabel lblCodigo;
    JLabel lblNombre;
    JLabel lblCantidad;
    JLabel lblValorunitario;
    JLabel lblDescripcion;
    
    JLabel lblTitulo0;
    
    JTextField txtCodigo;
    JTextField txtNombre;
    JTextField txtCantidad;
    JTextField txtValorunitario;
    JTextField txtDescripcion;     

   
    
    JButton btnLimpiar;
    JButton btnAceptar;
    
    JPanel pnlCentral;
    JPanel pnlPie;
    public FrmNuevoProducto() {
        this.setSize(300, 300);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("Datos Producto");
        
        lblCodigo= new JLabel("Código:");
        lblNombre= new JLabel("Nombres:");
        lblCantidad= new JLabel("Cantidad:");
        lblValorunitario= new JLabel("Valor unitario:");
        lblDescripcion= new JLabel("Descripcion:");
       
        

        txtCodigo = new JTextField(2);
    
        txtNombre= new JTextField(2);
        txtCantidad= new JTextField(2);
        txtValorunitario= new JTextField(2);
        txtDescripcion= new JTextField(2);        
       
       
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblCodigo);
        pnlCentral.add(txtCodigo);
        pnlCentral.add(lblNombre);
        pnlCentral.add(txtNombre);
        pnlCentral.add(lblCantidad);
        pnlCentral.add(txtCantidad);
        pnlCentral.add(lblValorunitario);
        pnlCentral.add(txtValorunitario);
        pnlCentral.add(lblDescripcion);
        pnlCentral.add(txtDescripcion);
        
      
        
                
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
        FrmNuevoProducto frmMenu= new FrmNuevoProducto();
        frmMenu.setVisible(true);
    } 
   
       public void btnAceptarActionListener(ActionEvent e){
        IProducto productoDao=new ProductoImpl();
        Producto producto=new Producto();
        producto.setCodigo(Integer.parseInt(txtCodigo.getText()));
        producto.setNombre(txtNombre.getText());
        producto.setCantidad(Integer.parseInt(txtCantidad.getText()));
        producto.setValorunitario(Integer.parseInt(txtValorunitario.getText()));
        producto.setDescripcion(txtDescripcion.getText());
        
         try{
         if(productoDao.insertar(producto)>0){
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

