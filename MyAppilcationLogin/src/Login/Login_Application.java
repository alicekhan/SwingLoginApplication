package Login;

import javax.swing.JOptionPane;

public class Login_Application extends javax.swing.JFrame {

    public Login_Application() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jshow_password = new javax.swing.JCheckBox();
        jtuser = new javax.swing.JTextField();
        blogin = new javax.swing.JButton();
        bcreateaccount = new javax.swing.JButton();
        bexit = new javax.swing.JButton();
        jpassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(204, 255, 204));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Enter Valid Credentials");

        jLabel2.setFont(new java.awt.Font("Sitka Subheading", 3, 24)); // NOI18N
        jLabel2.setText("Username:");

        jLabel3.setFont(new java.awt.Font("Sitka Subheading", 3, 24)); // NOI18N
        jLabel3.setText("Password:");

        jshow_password.setText("show password");
        jshow_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jshow_passwordActionPerformed(evt);
            }
        });

        jtuser.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N

        blogin.setBackground(new java.awt.Color(255, 204, 204));
        blogin.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        blogin.setText("Login");
        blogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bloginActionPerformed(evt);
            }
        });

        bcreateaccount.setBackground(new java.awt.Color(204, 255, 204));
        bcreateaccount.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        bcreateaccount.setText("Create Account");
        bcreateaccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcreateaccountActionPerformed(evt);
            }
        });

        bexit.setBackground(new java.awt.Color(255, 51, 51));
        bexit.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        bexit.setText("Exit");
        bexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bexitActionPerformed(evt);
            }
        });

        jpassword.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 34, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jshow_password)
                            .addComponent(jLabel1))
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bcreateaccount)
                                .addGap(36, 36, 36)
                                .addComponent(blogin)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bexit))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel2))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(jLabel3)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtuser)
                                    .addComponent(jpassword))))))
                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtuser, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jshow_password)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(blogin)
                    .addComponent(bcreateaccount)
                    .addComponent(bexit))
                .addGap(32, 32, 32))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bloginActionPerformed
        if (jtuser.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Enter User Name");
        }
        else if(jpassword.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Enter Password");
        }else {            
            MyConnections object = new MyConnections();
            try {
                object.connection();
                object.loginUser(this);
                System.out.println("User LogIn()");
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }//GEN-LAST:event_bloginActionPerformed

    private void bcreateaccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcreateaccountActionPerformed
        this.dispose();
        new CreateAccount().setVisible(true);           
    }//GEN-LAST:event_bcreateaccountActionPerformed

    private void bexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bexitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_bexitActionPerformed

    private void jshow_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jshow_passwordActionPerformed
        if(jshow_password.isSelected()){
            jpassword.setEchoChar((char)0);
        } else {
            jpassword.setEchoChar('*');
        }
    }//GEN-LAST:event_jshow_passwordActionPerformed

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
            java.util.logging.Logger.getLogger(Login_Application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login_Application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login_Application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login_Application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login_Application().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bcreateaccount;
    private javax.swing.JButton bexit;
    private javax.swing.JButton blogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jpassword;
    private javax.swing.JCheckBox jshow_password;
    private javax.swing.JTextField jtuser;
    // End of variables declaration//GEN-END:variables
    
    public void setUser(String phone) {
        jtuser.setText(phone);
    }
    public void setPassword(String pass) {
        jpassword.setText(pass);
    }
    public String getUser(){
        return jtuser.getText();
    }
    public String getPassword(){
        return jpassword.getText();
    }
}
