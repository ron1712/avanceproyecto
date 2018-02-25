/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.arcotel.anegocio.vistas;

import ec.com.arcotel.anegocio.dao.ICliente;
import ec.com.arcotel.anegocio.impl.ClienteImpl;
import ec.com.arcotel.anegocio.entidades.Cliente;
import javax.swing.JOptionPane;

/**
 *
 * @author Personal
 */
public class factura_venta_insetar extends javax.swing.JFrame {

    /**
     * Creates new form factura_venta_insetar
     */
    public factura_venta_insetar() {
        initComponents();
    }
    
    private void limpiarControles() {
        txtnombrecli.setText("");
        txtapellidoscli.setText("");
        txtdireccioncli.setText("");
        txttelefonocli.setText("");
        txtfechanaccli.setText("");
        txtemailcli.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnbuscar_cli = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtcedulacli = new javax.swing.JTextField();
        txtnombrecli = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtapellidoscli = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtdireccioncli = new javax.swing.JTextField();
        txttelefonocli = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtfechanaccli = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtcod_factura = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtFecha_fac = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dtbdetalle_venta = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtemailcli = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("FACTURA");

        btnbuscar_cli.setText("Buscar");
        btnbuscar_cli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscar_cliActionPerformed(evt);
            }
        });

        jLabel2.setText("Cédula");

        txtnombrecli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombrecliActionPerformed(evt);
            }
        });

        jLabel3.setText("Nombre");

        txtapellidoscli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtapellidoscliActionPerformed(evt);
            }
        });

        jLabel5.setText("Apellidos");

        jLabel6.setText("Dirección");

        jLabel7.setText("Télefono");

        txtfechanaccli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfechanaccliActionPerformed(evt);
            }
        });

        jLabel8.setText("Fecha de nacimiento");

        jLabel9.setText("Numero de Factura");

        jLabel10.setText("Fecha");

        jLabel11.setText("DETALLE VENTA");

        dtbdetalle_venta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "N", "Descripcion", "Cantidad", "Precio Unitario", "Valor Total"
            }
        ));
        jScrollPane1.setViewportView(dtbdetalle_venta);

        btnGuardar.setText("Guardar");

        btnModificar.setText("Modificar");

        jLabel12.setText("Email");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel12))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtfechanaccli, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txttelefonocli, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtapellidoscli, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtdireccioncli, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtcedulacli, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtnombrecli))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnbuscar_cli)
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFecha_fac)
                    .addComponent(txtcod_factura))
                .addGap(93, 93, 93))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(153, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(126, 126, 126))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(txtemailcli, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addGap(415, 415, 415))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addGap(65, 65, 65)
                        .addComponent(btnModificar)
                        .addGap(337, 337, 337))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(427, 427, 427))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtcedulacli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtnombrecli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtapellidoscli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtdireccioncli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtcod_factura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnbuscar_cli))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(txtFecha_fac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttelefonocli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtfechanaccli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(txtemailcli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnModificar))
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnombrecliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombrecliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombrecliActionPerformed

    private void txtapellidoscliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtapellidoscliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtapellidoscliActionPerformed

    private void txtfechanaccliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfechanaccliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfechanaccliActionPerformed

    private void btnbuscar_cliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscar_cliActionPerformed
        ICliente clienteDao = new ClienteImpl();
        try {
            limpiarControles();
            cliente = clienteDao.obtener(
                   txtcedulacli.getText());
            if (cliente != null) {
                txtcedulacli.setText(cliente.getCedula());
                txtnombrecli.setText(cliente.getNombre());
                txtapellidoscli.setText(cliente.getApellido());
                txtdireccioncli.setText(cliente.getDireccion());
                txttelefonocli.setText(cliente.getTelefono());
                txtemailcli.setText(cliente.getEmail());
              
                        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al buscar el cliente!!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnbuscar_cliActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(factura_venta_insetar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(factura_venta_insetar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(factura_venta_insetar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(factura_venta_insetar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new factura_venta_insetar().setVisible(true);
            }
        });
    }
    Cliente cliente;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnbuscar_cli;
    private javax.swing.JTable dtbdetalle_venta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtFecha_fac;
    private javax.swing.JTextField txtapellidoscli;
    private javax.swing.JTextField txtcedulacli;
    private javax.swing.JTextField txtcod_factura;
    private javax.swing.JTextField txtdireccioncli;
    private javax.swing.JTextField txtemailcli;
    private javax.swing.JTextField txtfechanaccli;
    private javax.swing.JTextField txtnombrecli;
    private javax.swing.JTextField txttelefonocli;
    // End of variables declaration//GEN-END:variables
}
