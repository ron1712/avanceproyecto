package ec.com.arcotel.anegocio.vistas;

import ec.com.arcotel.anegocio.dao.*;
import ec.com.arcotel.anegocio.entidades.*;
import ec.com.arcotel.anegocio.impl.*;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FrmListaKardex extends JInternalFrame{
    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    JScrollPane jscTabla;
    public FrmListaKardex(){
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        lblTitulo = new JLabel("Listado Kardex");
        tabla= new JTable();
        jscTabla = new JScrollPane(tabla);
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(jscTabla, BorderLayout.CENTER);
        cargarTabla();        
    }
        public void cargarTabla(){
        modelo= new DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Producto");    
        modelo.addColumn("Fecha emision");
        modelo.addColumn("Tipo transaccion");
        modelo.addColumn("Existencias");             
        modelo.addColumn("Valor total");
        
        List<Kardex> lista = new ArrayList<>();
        try{
            IKardex kardexDao = new KardexImpl();
            lista = kardexDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        for(Kardex est : lista){
            modelo.addRow(new Object[]{ est.getCodigo(), est.getProducto().getCodigo(),
               est.getFecha_emision(),est.getTipo_transaccion(),est.getExistencias(),
               est.getValor_total()});
        }
        tabla.setModel(modelo);
    }
       
}