package views;

import controllers.RATClientCtr;
import java.awt.*;
import javax.swing.JOptionPane;
import java.awt.event.WindowEvent;

/**
 *
 * @author gbrid
 */
public class MainScr extends javax.swing.JFrame {

    /**
     * Creates new form MainScr
     */
    public MainScr(String IP) {
        //static String IP = host;
        initComponents();
        txtIP.setText(IP);
        setLocationRelativeTo(null);
    }
    
    public static String host = "";

    MainScr() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtIP = new javax.swing.JTextField();
        ConnectBtn = new javax.swing.JButton();
        ShutDownBtn = new javax.swing.JButton();
        ScreenBtn = new javax.swing.JButton();
        KeystrokeBtn = new javax.swing.JButton();
        ExitBtn = new javax.swing.JButton();
        ProcessBtn = new javax.swing.JButton();
        AppBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Client");

        txtIP.setText("Input IP");
        txtIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIPActionPerformed(evt);
            }
        });

        ConnectBtn.setText("Connect");
        ConnectBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConnectBtnActionPerformed(evt);
            }
        });

        ShutDownBtn.setText("Shutdown");
        ShutDownBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShutDownBtnActionPerformed(evt);
            }
        });

        ScreenBtn.setText("Screens Shot");
        ScreenBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ScreenBtnActionPerformed(evt);
            }
        });

        KeystrokeBtn.setText("Keystroke");
        KeystrokeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KeystrokeBtnActionPerformed(evt);
            }
        });

        ExitBtn.setForeground(new java.awt.Color(255, 0, 102));
        ExitBtn.setText("Exit");
        ExitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitBtnActionPerformed(evt);
            }
        });

        ProcessBtn.setText("Process Running");
        ProcessBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProcessBtnActionPerformed(evt);
            }
        });

        AppBtn.setText("Apprunning");
        AppBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AppBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtIP, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ConnectBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(KeystrokeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ExitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ProcessBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                            .addComponent(ShutDownBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(AppBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ScreenBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ConnectBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AppBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                    .addComponent(ProcessBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ScreenBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ShutDownBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(KeystrokeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ExitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIPActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtIPActionPerformed

    private void ShutDownBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShutDownBtnActionPerformed
        // TODO add your handling code here:
        if(host.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Not connected!");
        }else {
            try {
                RATClientCtr.ConnectionCtr(host);
                String res = RATClientCtr.getConnectRes();
                if(res.equals("ok")) {
                    RATClientCtr.ShutDown();
                    //System.out.println(RATClientCtr.getCommandRes());
                    JOptionPane.showMessageDialog(rootPane, "Success!");
                }else {
                    JOptionPane.showMessageDialog(rootPane, "Fail!");
                }
              RATClientCtr.closeConn();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_ShutDownBtnActionPerformed

    private void ConnectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConnectBtnActionPerformed
        // TODO add your handling code here:
        try {
              host = txtIP.getText();
              RATClientCtr.ConnectionCtr(host);
              String res = RATClientCtr.getConnectRes();
              if(res.equals("ok")) {
                  JOptionPane.showMessageDialog(rootPane, "Success!");
              }else {
                  JOptionPane.showMessageDialog(rootPane, "Fail!");
              }
              RATClientCtr.closeConn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_ConnectBtnActionPerformed

    private void ScreenBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ScreenBtnActionPerformed
        // TODO add your handling code here:
        Screen s = new Screen(host);
        s.setVisible(true);
        MainScr.this.setVisible(false);
    }//GEN-LAST:event_ScreenBtnActionPerformed

    private void ProcessBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProcessBtnActionPerformed
        // TODO add your handling code here:
        Process p = new Process(host);
        p.setVisible(true);
    }//GEN-LAST:event_ProcessBtnActionPerformed

    private void ExitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitBtnActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_ExitBtnActionPerformed

    private void AppBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AppBtnActionPerformed
        // TODO add your handling code here:
        AppRunning a = new AppRunning(host);
        a.setVisible(true);
    }//GEN-LAST:event_AppBtnActionPerformed

    private void KeystrokeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KeystrokeBtnActionPerformed
        // TODO add your handling code here:
        Keystoke k = new Keystoke();
        k.setVisible(true);
    }//GEN-LAST:event_KeystrokeBtnActionPerformed

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
            java.util.logging.Logger.getLogger(MainScr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AppBtn;
    private javax.swing.JButton ConnectBtn;
    private javax.swing.JButton ExitBtn;
    private javax.swing.JButton KeystrokeBtn;
    private javax.swing.JButton ProcessBtn;
    private javax.swing.JButton ScreenBtn;
    private javax.swing.JButton ShutDownBtn;
    private javax.swing.JTextField txtIP;
    // End of variables declaration//GEN-END:variables

    private void systemExit()
    {
        WindowEvent winCloseing = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
    }
}

    
 
