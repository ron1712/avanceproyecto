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
    JMenuItem mniNuevoKardex;
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
        mniListaProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaProductoActionPerformed(e);
            }
        });
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
        mniListaProveedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaProveedorActionPerformed(e);
            }
        });
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
        mniListaEntrada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaEntradaActionPerformed(e);
            }
        });
        mnEntrada.add(mniNuevoEntrada);
        mnEntrada.add(mniModificaEntrada);
        mnEntrada.add(mniEliminaEntrada);
        mnEntrada.addSeparator();
        mnEntrada.add(mniBuscaEntrada);
        mnEntrada.add(mniListaEntrada); 
        
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
        mniListaSalida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaSalidaActionPerformed(e);
            }
        });
        mnSalida.add(mniNuevoSalida);
        mnSalida.add(mniModificaSalida);
        mnSalida.add(mniEliminaSalida);
        mnSalida.addSeparator();
        mnSalida.add(mniBuscaSalida);
        mnSalida.add(mniListaSalida);
        
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
        mniListaVenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaVentaActionPerformed(e);
            }
        });
        mnVenta.add(mniNuevoVenta);
        mnVenta.add(mniModificaVenta);
        mnVenta.add(mniEliminaVenta);
        mnVenta.addSeparator();
        mnVenta.add(mniBuscaVenta);
        mnVenta.add(mniListaVenta);
        
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
        mniListaDetalleEntrada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaDetalleEntradaActionPerformed(e);
            }
        });
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
        mniListaDetalleSalida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaDetalleSalidaActionPerformed(e);
            }
        });
        mnDetalleSalida.add(mniNuevoDetalleSalida);
        mnDetalleSalida.add(mniModificaDetalleSalida);
        mnDetalleSalida.add(mniEliminaDetalleSalida);
        mnDetalleSalida.addSeparator();
        mnDetalleSalida.add(mniBuscaDetalleSalida);
        mnDetalleSalida.add(mniListaDetalleSalida);
        
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
       /* mniListaDetalleVenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaDetalleVentaActionPerformed(e);
            }
        });*/
        mnDetalleVenta.add(mniNuevoDetalleVenta);
        mnDetalleVenta.add(mniModificaDetalleVenta);
        mnDetalleVenta.add(mniEliminaDetalleVenta);
        mnDetalleVenta.addSeparator();
        mnDetalleVenta.add(mniBuscaDetalleVenta);
        mnDetalleVenta.add(mniListaDetalleVenta);
        
        mnKardex= new JMenu("Kardex");        
        mniNuevoKardex= new JMenuItem("Nuevo");
        mniNuevoKardex.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoKardexActionPerformed(e);
            }
        });
        mniModificaKardex= new JMenuItem("Modifica");
        mniEliminaKardex= new JMenuItem("Elimina");
        mniBuscaKardex= new JMenuItem("Busca");
        mniListaKardex= new JMenuItem("Lista");               
        mniListaKardex.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaKardexActionPerformed(e);
            }
        });
        mnKardex.add(mniNuevoKardex);
        mnKardex.add(mniModificaKardex);
        mnKardex.add(mniEliminaKardex);
        mnKardex.addSeparator();
        mnKardex.add(mniBuscaKardex);
        mnKardex.add(mniListaKardex);
        
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
    public void mniNuevoProductoActionPerformed(ActionEvent e){
        FrmNuevoProducto frm = new FrmNuevoProducto();
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
    public void mniListaProveedorActionPerformed(ActionEvent e){
        FrmListaProveedor frm = new FrmListaProveedor();
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
    public void mniNuevoEntradaActionPerformed(ActionEvent e){
        FrmNuevoEntrada frm = new FrmNuevoEntrada();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    public void mniListaEntradaActionPerformed(ActionEvent e){
        FrmListaEntrada frm = new FrmListaEntrada();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    public void mniNuevoSalidaActionPerformed(ActionEvent e){
        FrmNuevoSalida frm = new FrmNuevoSalida();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
        public void mniListaSalidaActionPerformed(ActionEvent e){
        FrmListaSalida frm = new FrmListaSalida();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    public void mniNuevoVentaActionPerformed(ActionEvent e){
        FrmNuevoVenta frm = new FrmNuevoVenta();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    public void mniListaVentaActionPerformed(ActionEvent e){
        FrmListaVenta frm = new FrmListaVenta();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }    
    public void mniNuevoDetalleEntradaActionPerformed(ActionEvent e){
        FrmNuevoDetalleEntrada frm = new FrmNuevoDetalleEntrada();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }  
    public void mniListaDetalleEntradaActionPerformed(ActionEvent e){
        FrmListaDetalleEntrada frm = new FrmListaDetalleEntrada();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }    
    public void mniNuevoDetalleSalidaActionPerformed(ActionEvent e){
        FrmNuevoDetalleSalida frm = new FrmNuevoDetalleSalida();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }  
    public void mniListaDetalleSalidaActionPerformed(ActionEvent e){
        FrmListaDetalleSalida frm = new FrmListaDetalleSalida();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    } 
    public void mniNuevoDetalleVentaActionPerformed(ActionEvent e){
        FrmNuevoDetalleVenta frm = new FrmNuevoDetalleVenta();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }  
    /*public void mniListaDetalleVentaActionPerformed(ActionEvent e){
        FrmListaDetalleVenta frm = new FrmListaDetalleVenta();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }*/
    public void mniNuevoKardexActionPerformed(ActionEvent e){
        FrmNuevoKardex frm = new FrmNuevoKardex();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }  
    public void mniListaKardexActionPerformed(ActionEvent e){
        FrmListaKardex frm = new FrmListaKardex();
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
