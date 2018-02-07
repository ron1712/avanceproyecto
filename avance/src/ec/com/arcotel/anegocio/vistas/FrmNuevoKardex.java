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
    List<Entrada> lstEntrada;
    JComboBox<Entrada> cmbEntrada;
    List<Salida> lstSalida;
    JComboBox<Salida> cmbSalida;
    JLabel lblCantidad;
    JLabel lblPreciocompra;
    JLabel lblPrecioventa;
    JLabel lblCantidadinicial;
    JLabel lblCantidadactual;   
    JLabel lblProducto; 
    JLabel lblEntrada; 
    JLabel lblSalida; 
    JLabel lblTitulo0;
    
    JTextField txtCodigo;
    JTextField txtCantidad;
    JTextField txtPreciocompra;
    JTextField txtPrecioventa;
    JTextField txtCantidadinicial;
    JTextField txtCantidadactual;
    
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
        lblEntrada= new JLabel("Entrada:");
        lblSalida= new JLabel("Salida:");
        lblCantidad= new JLabel("Cantidad:");
        lblPreciocompra= new JLabel("Precio compra:");
        lblPrecioventa= new JLabel("Precio venta:");
        lblCantidadinicial= new JLabel("Cantidad inicial:");
        lblCantidadactual= new JLabel("Cantidad actual:");

        txtCodigo = new JTextField(2);
        cargarProductos();
        cmbProducto= new JComboBox(lstProducto.toArray());
        cargarEntradas();
        cmbEntrada= new JComboBox(lstEntrada.toArray());
        cargarSalidas();
        cmbSalida= new JComboBox(lstSalida.toArray());
        txtCantidad= new JTextField(2);
        txtPreciocompra= new JTextField(2);
        txtPrecioventa= new JTextField(2);
        txtCantidadinicial= new JTextField(2);
        txtCantidadactual= new JTextField(2);              
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblCodigo);
        pnlCentral.add(txtCodigo);
        pnlCentral.add(lblProducto);
        pnlCentral.add(cmbProducto);
        pnlCentral.add(lblEntrada);
        pnlCentral.add(cmbEntrada);
        pnlCentral.add(lblSalida);
        pnlCentral.add(cmbSalida);
        pnlCentral.add(lblCantidad);
        pnlCentral.add(txtCantidad);
        pnlCentral.add(lblPreciocompra);
        pnlCentral.add(txtPreciocompra);
        pnlCentral.add(lblPrecioventa);
        pnlCentral.add(txtPrecioventa);
        pnlCentral.add(lblCantidadinicial);
        pnlCentral.add(txtCantidadinicial);
        pnlCentral.add(lblCantidadactual);
        pnlCentral.add(txtCantidadactual);                           
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
     public void cargarEntradas(){
        IEntrada entradaDao = new EntradaImpl();
        try {
            lstEntrada = entradaDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al cargar los entradas!!",
                "Error"+e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }       
    }
    public void cargarSalidas(){
        ISalida salidaDao = new SalidaImpl();
        try {
            lstSalida = salidaDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al cargar los salidas!!",
                "Error"+e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }       
    } 
    public void btnAceptarActionListener(ActionEvent e){
        IKardex kardexDao = new KardexImpl();
        Kardex kardex = new Kardex();
        kardex.setCodigo(txtCodigo.getText());
        kardex.setProducto((Producto) cmbProducto.getSelectedItem());
        kardex.setEntrada((Entrada) cmbEntrada.getSelectedItem());
        kardex.setSalida((Salida) cmbSalida.getSelectedItem());
        kardex.setCantidad(Integer.parseInt(txtCantidad.getText()));
        kardex.setPreciocompra(Double.parseDouble(txtPreciocompra.getText()));                   
        kardex.setPrecioventa(Double.parseDouble(txtPrecioventa.getText()));
        kardex.setCantidadinicial(Integer.parseInt(txtCantidadinicial.getText()));
        kardex.setCantidadactual(Integer.parseInt(txtCantidadactual.getText()));
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
 
