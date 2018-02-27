/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.arcotel.anegocio.vistas;

import ec.com.arcotel.anegocio.dao.ICliente;
import ec.com.arcotel.anegocio.entidades.Cliente;
import ec.com.arcotel.anegocio.entidades.Cliente;
import ec.com.arcotel.anegocio.impl.ClienteImpl;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Personal
 */
public class FrmListaCliente extends javax.swing.JInternalFrame {
private List<Cliente> cliente;
private Cliente clientes = new Cliente();
DefaultTableModel modelo;
    /**
     * Creates new form FrmListaCliente
     */
    public FrmListaCliente() {
        initComponents();
        this.Clientes();
    }
    public void Clientes(){
                              
        DefaultTableModel modelo = (DefaultTableModel) TablaClienteListar.getModel();               
        List<Cliente> lista = new ArrayList<>();
        try {
            ICliente clienteDao = new ClienteImpl();
            lista = clienteDao.obtener();            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),"Error", 
                    JOptionPane.ERROR_MESSAGE);
        }
        for(Cliente cli : lista){
            modelo.addRow(new Object[]{ cli.getCedula(),cli.getNombre(), 
            cli.getApellido(),cli.getFecha_nac(),cli.getDireccion(),cli.getTelefono(),
            cli.getEmail()});            
        }
        TablaClienteListar.setModel(modelo);        
    
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TablaClienteListar = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        TablaClienteListar.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        TablaClienteListar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cedula", "Nombres", "Apellidos", "Fecha nacimiento", "Direccion", "Telefono", "Email"
            }
        ));
        jScrollPane1.setViewportView(TablaClienteListar);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("LISTADO DE CLIENTES");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaClienteListar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
