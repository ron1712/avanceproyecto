package ec.com.arcotel.anegocio.vistas;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import org.jvnet.substance.SubstanceLookAndFeel;

public class FrmMenuPrincipal extends JFrame {

    JMenuBar mnbPrincipal;
    JMenu mnInicio;
    JMenuItem mniLogin;
    JMenuItem mniSalir;
    JMenu mnCliente;
    JMenuItem mniNuevoCliente;
    JMenuItem mniModificaCliente;
    JMenuItem mniEliminaCliente;
    JMenuItem mniBuscaCliente;
    JMenuItem mniListaCliente;
    JMenu mnProducto;
    JMenuItem mniNuevoProducto;
    JMenuItem mniModificaProducto;
    JMenuItem mniEliminaProducto;
    JMenuItem mniBuscaProducto;
    JMenuItem mniListaProducto;
    JMenu mnProveedor;
    JMenuItem mniNuevoProveedor;
    JMenuItem mniModificaProveedor;
    JMenuItem mniEliminaProveedor;
    JMenuItem mniBuscaProveedor;
    JMenuItem mniListaProveedor;
    JMenu mnVendedor;
    JMenuItem mniNuevoVendedor;
    JMenuItem mniModificaVendedor;
    JMenuItem mniEliminaVendedor;
    JMenuItem mniBuscaVendedor;
    JMenuItem mniListaVendedor;
    JMenu mnDetalleEntrada;
    JMenuItem mniNuevoDetalleEntrada;
    JMenuItem mniModificaDetalleEntrada;
    JMenuItem mniEliminaDetalleEntrada;
    JMenuItem mniBuscaDetalleEntrada;
    JMenuItem mniListaDetalleEntrada;
    
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
        mniModificaCliente= new JMenuItem("Modifica");
        mniEliminaCliente= new JMenuItem("Elimina");
        mniBuscaCliente= new JMenuItem("Busca");
        mniListaCliente= new JMenuItem("Lista");
        mniListaCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaClienteActionPerformed(e);
            }
        });
        mnCliente.add(mniNuevoCliente);
        mnCliente.add(mniModificaCliente);
        mnCliente.add(mniEliminaCliente);
        mnCliente.addSeparator();
        mnCliente.add(mniBuscaCliente);
        mnCliente.add(mniListaCliente);
        
        mnProducto= new JMenu("Producto");
        mniNuevoProducto= new JMenuItem("Nuevo");
        mniNuevoProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoProductoActionPerformed(e);
            }           
        });
        mniModificaProducto= new JMenuItem("Modifica");
        mniEliminaProducto= new JMenuItem("Elimina");
        mniBuscaProducto= new JMenuItem("Busca");
        mniListaProducto= new JMenuItem("Lista");
        mnProducto.add(mniNuevoProducto);
        mnProducto.add(mniModificaProducto);
        mnProducto.add(mniEliminaProducto);
        mnProducto.addSeparator();
        mnProducto.add(mniBuscaProducto);
        mnProducto.add(mniListaProducto);        
        mnProveedor= new JMenu("Proveedor");
        mniNuevoProveedor= new JMenuItem("Nuevo");
        mniNuevoProveedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoProveedorActionPerformed(e);
            }
        });
        mniModificaProveedor= new JMenuItem("Modifica");
        mniEliminaProveedor= new JMenuItem("Elimina");
        mniBuscaProveedor= new JMenuItem("Busca");
        mniListaProveedor= new JMenuItem("Lista");
         mnProveedor.add(mniNuevoProveedor);
        mnProveedor.add(mniModificaProveedor);
        mnProveedor.add(mniEliminaProveedor);
        mnProveedor.addSeparator();
        mnProveedor.add(mniBuscaProveedor);
        mnProveedor.add(mniListaProveedor);
        
        mnVendedor= new JMenu("Vendedor");
        mniNuevoVendedor= new JMenuItem("Nuevo");
        mniNuevoVendedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoVendedorActionPerformed(e);
            }
        });
        mniModificaVendedor= new JMenuItem("Modifica");
        mniEliminaVendedor= new JMenuItem("Elimina");
        mniBuscaVendedor= new JMenuItem("Busca");
        mniListaVendedor= new JMenuItem("Lista");
        mniListaVendedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaVendedorActionPerformed(e);
            }
        });
        mnVendedor.add(mniNuevoVendedor);
        mnVendedor.add(mniModificaVendedor);
        mnVendedor.add(mniEliminaVendedor);
        mnVendedor.addSeparator();
        mnVendedor.add(mniBuscaVendedor);
        mnVendedor.add(mniListaVendedor);
        
        mnDetalleEntrada= new JMenu("DetalleEntrada");        
        mniNuevoDetalleEntrada= new JMenuItem("Nuevo");
        mniNuevoDetalleEntrada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoDetalleEntradaActionPerformed(e);
            }
        });
        mniModificaDetalleEntrada= new JMenuItem("Modifica");
        mniEliminaDetalleEntrada= new JMenuItem("Elimina");
        mniBuscaDetalleEntrada= new JMenuItem("Busca");
        mniListaDetalleEntrada= new JMenuItem("Lista");               
        mnDetalleEntrada.add(mniNuevoDetalleEntrada);
        mnDetalleEntrada.add(mniModificaDetalleEntrada);
        mnDetalleEntrada.add(mniEliminaDetalleEntrada);
        mnDetalleEntrada.addSeparator();
        mnDetalleEntrada.add(mniBuscaDetalleEntrada);
        mnDetalleEntrada.add(mniListaDetalleEntrada);        
              
       
        mnbPrincipal.add(mnInicio);
        mnbPrincipal.add(mnCliente);
        mnbPrincipal.add(mnProducto);
        mnbPrincipal.add(mnProveedor);
        mnbPrincipal.add(mnVendedor);
        mnbPrincipal.add(mnDetalleEntrada);
        mnInicio.add(mniLogin);
        mnInicio.add(mniSalir);
        this.setLayout(new BorderLayout());
        this.add(mnbPrincipal, BorderLayout.NORTH);
        this.add(dkpEscritorio, BorderLayout.CENTER);
        this.setExtendedState(MAXIMIZED_BOTH); //Para maximizar
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //Para terminar el programa
    //    JFrame.setDefaultLookAndFeelDecorated(true); //que nos permite dejar a Substance la decoracion ( por asi decirlo) 
   //  SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.RavenSkin"); // Setencia que aplica el skin Creme de Substance
    }    
    public void mniNuevoDetalleEntradaActionPerformed(ActionEvent e){
        FrmNuevoDetalleEntrada frm = new FrmNuevoDetalleEntrada();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    public void mniNuevoVendedorActionPerformed(ActionEvent e){
        FrmNuevoVendedor frm = new FrmNuevoVendedor();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
     public void mniListaVendedorActionPerformed(ActionEvent e){
        FrmListaVendedor frm = new FrmListaVendedor();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    public void mniNuevoProveedorActionPerformed(ActionEvent e){
        FrmNuevoProveedor frm = new FrmNuevoProveedor();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
     public void mniNuevoProductoActionPerformed(ActionEvent e){
        FrmNuevoProducto frm = new FrmNuevoProducto();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    public void mniNuevoClienteActionPerformed(ActionEvent e){
        FrmNuevoCliente frm = new FrmNuevoCliente();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    public void mniListaClienteActionPerformed(ActionEvent e){
        FrmListaCliente frm = new FrmListaCliente();
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
