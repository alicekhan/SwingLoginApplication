package Login;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.File;
import javax.mail.*;  
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;


public class MainPage extends javax.swing.JFrame {
    DefaultTableModel tblModel;
static MyConnections object = new MyConnections();
    public MainPage() {
        initComponents();
        try{              
            object.connection();
            object.listUsers(this);
        } catch(Exception e) { 
            System.out.println(e);
        }        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        delete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        export = new javax.swing.JButton();
        add = new javax.swing.JButton();
        exit2 = new javax.swing.JButton();
        add1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Serif", 3, 24)); // NOI18N
        jLabel1.setText("Welcome To Your Dashboard");

        delete.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        delete.setForeground(new java.awt.Color(0, 102, 51));
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "first name", "last name", "username", "email", "phone", "password", "Select"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        export.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        export.setForeground(new java.awt.Color(0, 153, 102));
        export.setText("Export(Excel)");
        export.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportActionPerformed(evt);
            }
        });

        add.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        add.setForeground(new java.awt.Color(0, 102, 51));
        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        exit2.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        exit2.setForeground(new java.awt.Color(255, 0, 102));
        exit2.setText("Exit");
        exit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit2ActionPerformed(evt);
            }
        });

        add1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        add1.setForeground(new java.awt.Color(0, 102, 51));
        add1.setText("Send Mail");
        add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(191, 191, 191)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(190, 190, 190)
                                        .addComponent(add))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(add1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(export)))
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(delete)
                                    .addComponent(exit2))))
                        .addContainerGap(252, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(31, 31, 31))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(delete)
                    .addComponent(add))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exit2)
                    .addComponent(export)
                    .addComponent(add1))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        tblModel = (DefaultTableModel) jTable1.getModel();
        try {
            if(jTable1.getSelectedRowCount()== 1){
                object.connection();
                object.deleteUser();
                tblModel.removeRow(jTable1.getSelectedRow());
            } else{
                if(jTable1.getSelectedRowCount()== 0){
                    JOptionPane.showMessageDialog(null, "Table is Empty");
                } else{
                    JOptionPane.showMessageDialog(null, "Select Single Row");
                }
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void exportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportActionPerformed
    
        JFileChooser excelFileChooser = new JFileChooser("D:\\");
        excelFileChooser.setDialogTitle("Save As:");
        FileNameExtensionFilter filename = new FileNameExtensionFilter("Excel Files", "xls", "xlsx", "xlsm");
        excelFileChooser.setFileFilter(filename);
        int excelChooser = excelFileChooser.showSaveDialog(null);
        if(excelChooser == JFileChooser.APPROVE_OPTION){
//            XSSFWorkbook excelJTableExporter = new XSSFWorkbook();
            File f= new File("D://");
//            Workbook wb = Workbook.getWorkbook (f);
//            Sheet s = wb.getSheet(0);
//            int row = s.getRows();
//            int col = s.getColumns();
            for(int i=0; i<= tblModel.getRowCount(); i++){
                for(int j=0;j<tblModel.getColumnCount();j++){
//                    Cell S = s.getCellVlaue(j,i);
//                    System.out.print(.getContents());

                }
                System.out.println("ok");
            }
//            excelFOU = new FileOutputStream(excelFileChooser.getSelectedFile()+ ":xlsx");
            
        }
           
    

    }//GEN-LAST:event_exportActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        new CreateAccount().setVisible(true);
        System.out.println("user added");
    }//GEN-LAST:event_addActionPerformed

    private void exit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exit2ActionPerformed

    private void add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add1ActionPerformed
//      String to = "alicekhan7011@gmail.com";//change accordingly  
//      String from = "alicekhan7011@gmail.com";//change accordingly  
//      String host = "localhost";//or IP address  
//  
//     //Get the session object  
//      Properties properties = System.getProperties();  
//      properties.setProperty("mail.smtp.host", host);  
//      Session session = Session.getDefaultInstance(properties);  
//  
//     //compose the message  
//      try{  
//         MimeMessage message = new MimeMessage(session);  
//         message.setFrom(new InternetAddress(from));  
//         message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
//         message.setSubject("Ping");  
//         message.setText("Hello, this is example of sending email  ");  
//  
//         // Send message  
//         Transport.send(message);  
//         System.out.println("message sent successfully....");  
//  
//      }catch (MessagingException mex) {mex.printStackTrace();}  
//    


        try {
            MyConnections.sendMail("alice.khanofficial@gmail.com");
        } catch (MessagingException ex) {
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }//GEN-LAST:event_add1ActionPerformed

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
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton add1;
    private javax.swing.JButton delete;
    private javax.swing.JButton exit2;
    private javax.swing.JButton export;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
