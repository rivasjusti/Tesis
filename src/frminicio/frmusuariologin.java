/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frminicio;


import flogica.ftrabajador;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vdatos.vtrabajador;

/**
 *
 * @author MartinezJL
 */
public class frmusuariologin extends javax.swing.JFrame {

    /**
     * Creates new form frmusuariologin
     */
    public frmusuariologin() {
        initComponents();
        this.setTitle("Acceso al Sistema");
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTFUsuario = new javax.swing.JTextField();
        jPPassword = new javax.swing.JPasswordField();
        jBIngresar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jBSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTListado = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(51, 0, 51));
        jLabel1.setFont(new java.awt.Font("Engravers MT", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuario:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 40, 109, 35));

        jLabel2.setFont(new java.awt.Font("Engravers MT", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 93, 109, 35));

        jTFUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFUsuarioActionPerformed(evt);
            }
        });
        jTFUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFUsuarioKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFUsuarioKeyReleased(evt);
            }
        });
        jPanel1.add(jTFUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 135, -1));

        jPPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPPasswordActionPerformed(evt);
            }
        });
        jPPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPPasswordKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPPasswordKeyReleased(evt);
            }
        });
        jPanel1.add(jPPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 135, -1));

        jBIngresar.setBackground(new java.awt.Color(0, 0, 0));
        jBIngresar.setForeground(new java.awt.Color(0, 51, 51));
        jBIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/usu.png"))); // NOI18N
        jBIngresar.setText("Ingresar");
        jBIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBIngresarActionPerformed(evt);
            }
        });
        jBIngresar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jBIngresarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jBIngresarKeyReleased(evt);
            }
        });
        jPanel1.add(jBIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 150, -1, -1));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 542, 260));

        jLabel5.setBackground(new java.awt.Color(255, 102, 0));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 51, 51));
        jLabel5.setText("Motorepuestos y taller MAX");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 380, 30));

        jBSalir.setBackground(new java.awt.Color(0, 0, 0));
        jBSalir.setForeground(new java.awt.Color(51, 0, 51));
        jBSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/usux.png"))); // NOI18N
        jBSalir.setText("Salir");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });
        jPanel1.add(jBSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 102, -1));

        jTListado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTListado);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(309, 189, 2, 0));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/key (1).png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 40, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBIngresarActionPerformed
        // TODO add your handling code here:
        ingresar();
    }//GEN-LAST:event_jBIngresarActionPerformed

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jTFUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFUsuarioActionPerformed
        // TODO add your handling code here:
        jTFUsuario.transferFocus();
    }//GEN-LAST:event_jTFUsuarioActionPerformed

    private void jPPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPPasswordActionPerformed
        // TODO add your handling code here:
        jPPassword.transferFocus();
    }//GEN-LAST:event_jPPasswordActionPerformed

    private void jBIngresarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBIngresarKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jBIngresarKeyPressed

    private void jBIngresarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBIngresarKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jBIngresarKeyReleased

    private void jPPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPPasswordKeyReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jPPasswordKeyReleased

    private void jPPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPPasswordKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jBIngresar.requestFocus();
            jBIngresar.setBackground(Color.YELLOW);
            jPPassword.setBackground(Color.WHITE);
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            jBIngresarActionPerformed(null);
        }
    }//GEN-LAST:event_jPPasswordKeyPressed

    private void jTFUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFUsuarioKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jPPassword.requestFocus();
            jPPassword.setBackground(Color.YELLOW);
            jTFUsuario.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_jTFUsuarioKeyPressed

    private void jTFUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFUsuarioKeyReleased
        // TODO add your handling code here:
         jTFUsuario.setText(this.jTFUsuario.getText().toUpperCase());
    }//GEN-LAST:event_jTFUsuarioKeyReleased

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
            java.util.logging.Logger.getLogger(frmusuariologin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmusuariologin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmusuariologin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmusuariologin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmusuariologin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBIngresar;
    private javax.swing.JButton jBSalir;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField jPPassword;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFUsuario;
    private javax.swing.JTable jTListado;
    // End of variables declaration//GEN-END:variables

    private void ingresar(){
        try {
            DefaultTableModel modelo;
            ftrabajador func = new ftrabajador();
            vtrabajador dts = new vtrabajador();
            
            dts.setLogin(jTFUsuario.getText());
            dts.setPassword(jPPassword.getText());
            
            modelo = func.login(dts.getLogin(), dts.getPassword());
            
            jTListado.setModel(modelo);
            
            if (func.totalregistros > 0) {
                this.dispose();
                frminicio form = new frminicio();
                form.toFront();
                form.setVisible(true);
                
                frminicio.jLidpersona.setText(jTListado.getValueAt(0, 0).toString());
                frminicio.jLnombre.setText(jTListado.getValueAt(0, 1).toString());
                frminicio.jLapellido.setText(jTListado.getValueAt(0,2).toString());
                
                frminicio.jLacceso.setText(jTListado.getValueAt(0, 6).toString());
                //frminicio.jLAcceso.setText(jTListado.getValueAt(0, 7).toString());
               
                if (!frminicio.jLacceso.getText().equals("Administrador")) {
                    frminicio.jMArchivo.setEnabled(false);
                    frminicio.jMConfiguraciones.setEnabled(false);
                }
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Acceso Denegado!", "Acceso al Sistema", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
        }
    }
}
