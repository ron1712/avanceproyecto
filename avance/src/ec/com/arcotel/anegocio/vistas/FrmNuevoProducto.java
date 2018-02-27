/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.arcotel.anegocio.vistas;

import ec.com.arcotel.anegocio.dao.*;
import ec.com.arcotel.anegocio.entidades.*;
import ec.com.arcotel.anegocio.impl.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Francisco
 */
public class FrmNuevoProducto extends JInternalFrame {
    
    List<Categoria> lstCategoria;
    JComboBox<Categoria> cmbCategoria;
    JLabel lblTitulo0;
    JLabel lblCodigo;
    JLabel lblNombre;
    JLabel lblPrecio;
    JLabel lblDescripcion;
    JLabel lblCategoria;

    JTextField txtCodigo;
    JTextField txtNombre;
    JTextField txtPrecio;
    JTextField txtDescripcion;
    
    JButton btnLimpiar;
    JButton btnIngresar;
    
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
        
        lblCodigo = new JLabel("Código:");
        lblNombre = new JLabel("Nombre:");
        lblPrecio = new JLabel("Precio:");
        lblDescripcion= new JLabel("Descripcion");
        lblCategoria  = new JLabel("Categoria:");

        txtCodigo = new JTextField(2);
        txtNombre = new JTextField(2);
        txtPrecio = new JTextField(2);
        txtDescripcion = new JTextField(2);
        cargarCategorias();
        cmbCategoria = new JComboBox(lstCategoria.toArray());
        btnLimpiar = new JButton("Limpiar");
        btnIngresar = new JButton("Ingresar");
        
        pnlCentral.add(lblCodigo);
        pnlCentral.add(txtCodigo);       
        pnlCentral.add(lblNombre);
        pnlCentral.add(txtNombre);
        pnlCentral.add(lblPrecio);
        pnlCentral.add(txtPrecio);        
        pnlCentral.add(lblDescripcion);
        pnlCentral.add(txtDescripcion);      
        pnlCentral.add(lblCategoria);
        pnlCentral.add(cmbCategoria);
        
                
        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    btnIngresarActionListener(e);
                } catch (Exception ex) {
                    System.out.println("Error:"+ex.getMessage());
                }
            }
        });
        pnlPie.add(btnIngresar);
        pnlPie.add(btnLimpiar);
        
        this.add(lblTitulo0, BorderLayout.NORTH);
        this.add(pnlCentral, BorderLayout.CENTER);
        this.add(pnlPie, BorderLayout.SOUTH);        
    }
    public static void main(String[] args) {
        FrmNuevoProducto frmMenu= new FrmNuevoProducto();
        frmMenu.setVisible(true);
    } 
    public void cargarCategorias(){
        ICategoria categoriaDao = new CategoriaImpl();
        try {
            lstCategoria = categoriaDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al cargar las Categorias!!",
                "Error"+e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }       
    }
    public void btnIngresarActionListener(ActionEvent e){
        IProducto productoDao = new ProductoImpl();
        Producto producto = new Producto();
        producto.setCodigo(Integer.parseInt(txtCodigo.getText()));
        producto.setNombre(txtNombre.getText());
        producto.setPrecio(Integer.parseInt(txtPrecio.getText()));
        producto.setCategoria((Categoria) cmbCategoria.getSelectedItem());        
        try {
            if(productoDao.insertar(producto)>0){
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
