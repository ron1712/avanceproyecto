package ec.com.arcotel.anegocio.vistas;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.watermark.SubstanceImageWatermark;

public class FrmMenuPrincipal extends JFrame {

    JMenuBar mnbPrincipal;
    JMenu mnInicio;
    JMenuItem mniLogin;
    JMenuItem mniSalir;
    
    JMenu mnCliente;
    JMenuItem mniNuevoCliente;
    JMenuItem mniCliente;
    JMenuItem mniListaCliente;    
    
    JMenu mnCategoria;
    JMenuItem mniNuevoCategoria;
    JMenuItem mniCategoria;
    JMenuItem mniListaCategoria; 
    
    JMenu mnProducto;
    JMenuItem mniNuevoProducto;
    JMenuItem mniProducto;
    JMenuItem mniListaProducto;

    JMenu mnProveedor;    
    JMenuItem mniNuevoProveedor;
    JMenuItem mniProveedor;
    JMenuItem mniListaProveedor;
     
    JDesktopPane dkpEscritorio;

    public FrmMenuPrincipal() {
        dkpEscritorio= new JDesktopPane();
        dkpEscritorio.setBackground(new Color(240, 240, 240));        
        mnbPrincipal = new JMenuBar();
        mnInicio = new JMenu("Inicio");
        mniLogin = new JMenuItem("Iniciar Sesión");
        mniSalir = new JMenuItem("Salir");
        mniSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniSalirActionPerformed(e);
            }
        });
        mnCliente= new JMenu("Cliente");
        mniNuevoCliente= new JMenuItem("Nuevo");
        mniNuevoCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoClienteActionPerformed(e);
            }
        });
        mniCliente= new JMenuItem("Cliente");
        mniCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniClienteActionPerformed(e);
            }
        });
        mniListaCliente= new JMenuItem("Lista");
        mniListaCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaClienteActionPerformed(e);
            }
        });
        mnCliente.add(mniNuevoCliente);
        mnCliente.add(mniCliente);
        mnCliente.addSeparator();
        mnCliente.add(mniListaCliente);
        
        mnProducto= new JMenu("Producto");
        mniNuevoProducto= new JMenuItem("Nuevo");
        mniNuevoProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoProductoActionPerformed(e);
            }           
        });
        mniProducto= new JMenuItem("Producto");
        mniNuevoProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoProductoActionPerformed(e);
            }           
        });
        mniListaProducto= new JMenuItem("Lista");
        mniProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniProductoActionPerformed(e);
            }
        });
        mnProducto.add(mniNuevoProducto);
        mnProducto.add(mniProducto);
        mnProducto.addSeparator();
        mnProducto.add(mniListaProducto); 
        
        mnProveedor= new JMenu("Proveedor");
        mniNuevoProveedor= new JMenuItem("Nuevo");
        mniNuevoProveedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoProveedorActionPerformed(e);
            }
        });
        mniProveedor= new JMenuItem("Proveedor");
         mniProveedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniProveedorActionPerformed(e);
            }
        });
        mniListaProveedor= new JMenuItem("Lista");
        mniListaProveedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaProveedorActionPerformed(e);
            }
        });
         mnProveedor.add(mniNuevoProveedor);
        mnProveedor.add(mniProveedor);
        mnProveedor.addSeparator();
        mnProveedor.add(mniListaProveedor);
        
        mnCategoria= new JMenu("Categoria");
        mniNuevoCategoria= new JMenuItem("Nuevo");
        mniNuevoCategoria.addActionListener(new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoCategoriaActionPerformed(e);
            }
        });
        mniCategoria= new JMenuItem("Categoria");
        mniCategoria.addActionListener(new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent e) {
                mniCategoriaActionPerformed(e);
            }
        });
        mniListaCategoria= new JMenuItem("Lista");
        mniListaCategoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaCategoriaActionPerformed(e);
            }
        });        
        mnCategoria.add(mniNuevoCategoria);
        mnCategoria.add(mniCategoria);
        mnCategoria.addSeparator();
        mnCategoria.add(mniListaCategoria);
        
      
        
        mnbPrincipal.add(mnInicio);
        mnbPrincipal.add(mnCliente);
        mnbPrincipal.add(mnProducto);
        mnbPrincipal.add(mnProveedor);
        mnbPrincipal.add(mnCategoria);
        mnInicio.add(mniLogin);
        mnInicio.add(mniSalir);
        this.setLayout(new BorderLayout());
        this.add(mnbPrincipal, BorderLayout.NORTH);
        this.add(dkpEscritorio, BorderLayout.CENTER);
        this.setExtendedState(MAXIMIZED_BOTH); //Para maximizar
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
        JFrame.setDefaultLookAndFeelDecorated(true); //que nos permite dejar a Substance la decoracion ( por asi decirlo) 
        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.MistAquaSkin"); // Setencia que aplica el skin Creme de 
        this.setBounds(400, 400, 400, 400);
    }    
    public void mniNuevoClienteActionPerformed(ActionEvent e){
        FrmNuevoCliente frm = new FrmNuevoCliente();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    public void mniClienteActionPerformed(ActionEvent e){
        FrmCliente frm = new FrmCliente();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    public void mniListaClienteActionPerformed(ActionEvent e){
        FrmListaCliente frm = new FrmListaCliente();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    public void mniNuevoProductoActionPerformed(ActionEvent e){
        FrmNuevoProducto frm = new FrmNuevoProducto();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }    
    public void mniProductoActionPerformed(ActionEvent e){
        FrmProducto frm = new FrmProducto();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    public void mniListaProductoActionPerformed(ActionEvent e){
        FrmListaProducto frm = new FrmListaProducto();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    
    public void mniNuevoProveedorActionPerformed(ActionEvent e){
        FrmNuevoProveedor frm = new FrmNuevoProveedor();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    public void mniProveedorActionPerformed(ActionEvent e){
        FrmProveedor frm = new FrmProveedor();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    public void mniListaProveedorActionPerformed(ActionEvent e){
        FrmListaProveedor frm = new FrmListaProveedor();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    public void mniNuevoCategoriaActionPerformed(ActionEvent e){
        FrmNuevoCategoria frm = new FrmNuevoCategoria();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    public void mniCategoriaActionPerformed(ActionEvent e){
        FrmCategoria frm = new FrmCategoria();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    public void mniListaCategoriaActionPerformed(ActionEvent e){
        FrmListaCategoria frm = new FrmListaCategoria();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }

    public void mniSalirActionPerformed(ActionEvent e){
        System.exit(0);
    }
    
    public static void main(String[] args) {
        FrmMenuPrincipal frm = new FrmMenuPrincipal();
        frm.setVisible(true);
    }
}
