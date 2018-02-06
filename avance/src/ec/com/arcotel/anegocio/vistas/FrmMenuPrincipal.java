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
    JMenu mnDetalleEntrada;
    JMenuItem mniNuevoDetalleEntrada;
    JMenuItem mniModificaDetalleEntrada;
    JMenuItem mniEliminaDetalleEntrada;
    JMenuItem mniBuscaDetalleEntrada;
    JMenuItem mniListaDetalleEntrada;
    JMenu mnDetalleSalida;
    JMenuItem mniNuevoDetalleSalida;
    JMenuItem mniModificaDetalleSalida;
    JMenuItem mniEliminaDetalleSalida;
    JMenuItem mniBuscaDetalleSalida;
    JMenuItem mniListaDetalleSalida;
    JMenu mnDetalleVenta;
    JMenuItem mniNuevoDetalleVenta;
    JMenuItem mniModificaDetalleVenta;
    JMenuItem mniEliminaDetalleVenta;
    JMenuItem mniBuscaDetalleVenta;
    JMenuItem mniListaDetalleVenta;
    JMenu mnEntrada;
    JMenuItem mniNuevoEntrada;
    JMenuItem mniModificaEntrada;
    JMenuItem mniEliminaEntrada;
    JMenuItem mniBuscaEntrada;
    JMenuItem mniListaEntrada;    
    JMenu mnKardex;
    JMenuItem mniKardex;
    JMenuItem mniModificaKardex;
    JMenuItem mniEliminaKardex;
    JMenuItem mniBuscaKardex;
    JMenuItem mniListaKardex;
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
     JMenu mnSalida;
    JMenuItem mniNuevoSalida;
    JMenuItem mniModificaSalida;
    JMenuItem mniEliminaSalida;
    JMenuItem mniBuscaSalida;
    JMenuItem mniListaSalida;    
    JMenu mnVendedor;
    JMenuItem mniNuevoVendedor;
    JMenuItem mniModificaVendedor;
    JMenuItem mniEliminaVendedor;
    JMenuItem mniBuscaVendedor;
    JMenuItem mniListaVendedor;
    JMenu mnVenta;
    JMenuItem mniNuevoVenta;
    JMenuItem mniModificaVenta;
    JMenuItem mniEliminaVenta;
    JMenuItem mniBuscaVenta;
    JMenuItem mniListaVenta;    
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
        
        mnEntrada= new JMenu("Entrada");        
        mniNuevoEntrada= new JMenuItem("Nuevo");
        mniNuevoEntrada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoEntradaActionPerformed(e);
            }
        });
        mniModificaEntrada= new JMenuItem("Modifica");
        mniEliminaEntrada= new JMenuItem("Elimina");
        mniBuscaEntrada= new JMenuItem("Busca");
        mniListaEntrada= new JMenuItem("Lista");               
        mnEntrada.add(mniNuevoDetalleEntrada);
        mnEntrada.add(mniModificaDetalleEntrada);
        mnEntrada.add(mniEliminaDetalleEntrada);
        mnEntrada.addSeparator();
        mnEntrada.add(mniBuscaDetalleEntrada);
        mnEntrada.add(mniListaDetalleEntrada); 
        
        mnSalida= new JMenu("Salida");        
        mniNuevoSalida= new JMenuItem("Nuevo");
        mniNuevoSalida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoSalidaActionPerformed(e);
            }
        });
        mniModificaSalida= new JMenuItem("Modifica");
        mniEliminaSalida= new JMenuItem("Elimina");
        mniBuscaSalida= new JMenuItem("Busca");
        mniListaSalida= new JMenuItem("Lista");               
        mnSalida.add(mniNuevoDetalleEntrada);
        mnSalida.add(mniModificaDetalleEntrada);
        mnSalida.add(mniEliminaDetalleEntrada);
        mnSalida.addSeparator();
        mnSalida.add(mniBuscaDetalleEntrada);
        mnSalida.add(mniListaDetalleEntrada);
        
        mnVenta= new JMenu("Venta");        
        mniNuevoVenta= new JMenuItem("Nuevo");
        mniNuevoVenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoVentaActionPerformed(e);
            }
        });
        mniModificaVenta= new JMenuItem("Modifica");
        mniEliminaVenta= new JMenuItem("Elimina");
        mniBuscaVenta= new JMenuItem("Busca");
        mniListaVenta= new JMenuItem("Lista");               
        mnVenta.add(mniNuevoDetalleEntrada);
        mnVenta.add(mniModificaDetalleEntrada);
        mnVenta.add(mniEliminaDetalleEntrada);
        mnVenta.addSeparator();
        mnVenta.add(mniBuscaDetalleEntrada);
        mnVenta.add(mniListaDetalleEntrada);
        
        mnDetalleEntrada= new JMenu("Detalle Entrada");        
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
              
        mnDetalleSalida= new JMenu("Detalle Salida");        
        mniNuevoDetalleSalida= new JMenuItem("Nuevo");
        mniNuevoDetalleSalida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoDetalleSalidaActionPerformed(e);
            }
        });
        mniModificaDetalleSalida= new JMenuItem("Modifica");
        mniEliminaDetalleSalida= new JMenuItem("Elimina");
        mniBuscaDetalleSalida= new JMenuItem("Busca");
        mniListaDetalleSalida= new JMenuItem("Lista");               
        mnDetalleSalida.add(mniNuevoDetalleEntrada);
        mnDetalleSalida.add(mniModificaDetalleEntrada);
        mnDetalleSalida.add(mniEliminaDetalleEntrada);
        mnDetalleSalida.addSeparator();
        mnDetalleSalida.add(mniBuscaDetalleEntrada);
        mnDetalleSalida.add(mniListaDetalleEntrada);
        
        mnDetalleVenta= new JMenu("Detalle Venta");        
        mniNuevoDetalleVenta= new JMenuItem("Nuevo");
        mniNuevoDetalleVenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoDetalleVentaActionPerformed(e);
            }
        });
        mniModificaDetalleVenta= new JMenuItem("Modifica");
        mniEliminaDetalleVenta= new JMenuItem("Elimina");
        mniBuscaDetalleVenta= new JMenuItem("Busca");
        mniListaDetalleVenta= new JMenuItem("Lista");               
        mnDetalleVenta.add(mniNuevoDetalleEntrada);
        mnDetalleVenta.add(mniModificaDetalleEntrada);
        mnDetalleVenta.add(mniEliminaDetalleEntrada);
        mnDetalleVenta.addSeparator();
        mnDetalleVenta.add(mniBuscaDetalleEntrada);
        mnDetalleVenta.add(mniListaDetalleEntrada);
        
        mnKardex= new JMenu("Kardex");        
        mniKardex= new JMenuItem("Nuevo");
        mniKardex.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoKardexActionPerformed(e);
            }
        });
        mniModificaKardex= new JMenuItem("Modifica");
        mniEliminaKardex= new JMenuItem("Elimina");
        mniBuscaKardex= new JMenuItem("Busca");
        mniListaKardex= new JMenuItem("Lista");               
        mnKardex.add(mniNuevoDetalleEntrada);
        mnKardex.add(mniModificaDetalleEntrada);
        mnKardex.add(mniEliminaDetalleEntrada);
        mnKardex.addSeparator();
        mnKardex.add(mniBuscaDetalleEntrada);
        mnKardex.add(mniListaDetalleEntrada);
        
        mnbPrincipal.add(mnInicio);
        mnbPrincipal.add(mnCliente);
        mnbPrincipal.add(mnProducto);
        mnbPrincipal.add(mnProveedor);
        mnbPrincipal.add(mnVendedor);
        mnbPrincipal.add(mnEntrada);
        mnbPrincipal.add(mnSalida);
        mnbPrincipal.add(mnVenta);
        mnbPrincipal.add(mnDetalleEntrada);
        mnbPrincipal.add(mnDetalleSalida);
        mnbPrincipal.add(mnDetalleVenta);
        mnbPrincipal.add(mnKardex);
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
