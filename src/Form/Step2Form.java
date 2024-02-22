/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import DAO.AccountDAO;
import DAO.CustomerDAO;
import Model.Account;
import Model.Customer;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MSI-VN
 */
public class Step2Form extends javax.swing.JPanel {

    CustomerDAO customerdao = new CustomerDAO();
    AccountDAO accdao = new AccountDAO();
    ArrayList<Account> dssp;
    int row;
    public Step2Form() {
        initComponents();
        setOpaque(false);
        autoID();
    }

    private void autoID() {          
        String ID = customerdao.AutoID();
        txtcust.setText(ID);
    }
     private void reset(){
        txtma.setText("");    
//        txtcust.setText("Chọn bên trong Bảng thông tin KH");
        autoID();
        
    } 

     private void RandomMaKH(){
        Random rand = new Random();
        int randomNumber = rand.nextInt(100000000);
        String randomString = String.format("%08d", randomNumber);
        txtma.setText(randomString);
         
    }

    private Boolean checkMa(String ma){
        List<Account> list = new ArrayList<>();
        list = accdao.docdanhsachtk();
        for (Account b : list) {
            if(ma.equals(b.getAcc_id())){
                return true;
            }
        }
        return false;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Exit2 = new javax.swing.JButton();
        Exit3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txttt = new javax.swing.JLabel();
        txtbal = new javax.swing.JLabel();
        txtcust = new javax.swing.JTextField();
        txtma = new com.raven.suportSwing.TextField();
        jButton2 = new javax.swing.JButton();

        Exit2.setBackground(new java.awt.Color(255, 0, 51));
        Exit2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Exit2.setText("Lưu thông tin");
        Exit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Exit2ActionPerformed(evt);
            }
        });

        Exit3.setBackground(new java.awt.Color(102, 255, 102));
        Exit3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Exit3.setText("Reset");
        Exit3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Exit3ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Mã Tài Khoản");

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Mã Khách Hàng");

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Số Dư");

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Trạng Thái");

        txttt.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        txttt.setForeground(new java.awt.Color(255, 51, 51));
        txttt.setText("Active");

        txtbal.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        txtbal.setForeground(new java.awt.Color(0, 0, 255));
        txtbal.setText("0");

        txtcust.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtcust.setText("Chọn bên trong Bảng thông tin KH");
        txtcust.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtcustMouseExited(evt);
            }
        });
        txtcust.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcustActionPerformed(evt);
            }
        });

        txtma.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtma.setLabelText("Mã tài khoản");
        txtma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmaActionPerformed(evt);
            }
        });
        txtma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtmaKeyPressed(evt);
            }
        });

        jButton2.setText("Random");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(256, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Exit3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtma, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(102, 102, 102)
                                .addComponent(jButton2))
                            .addComponent(txtbal, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttt, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtcust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)))
                .addComponent(Exit2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(249, 249, 249))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtma, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcust, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtbal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Exit3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(Exit2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(118, 118, 118))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    private void Exit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Exit2ActionPerformed
        // TODO add your handling code here:
         // TODO add your handling code here:

        if (txtma.getText().equals("")) {
            JOptionPane.showMessageDialog(this,"Hãy điền mã tài khoản");
        } else if(checkMa(txtma.getText())==true){
            JOptionPane.showMessageDialog(this,"Mã tài khoản bị trùng");
        } else if(txtcust.getText().equals("Chọn bên trong Bảng thông tin KH")){
            JOptionPane.showMessageDialog(this,"Hãy điền mã khách hàng");

        }else {
            Account tk =  new Account();

            tk.setAcc_id(txtma.getText());
            tk.setCust_id(txtcust.getText());
            tk.setBalance(Integer.parseInt(txtbal.getText()));
            tk.setTrangthai(txttt.getText());

            if (accdao.luutaikhoan(tk)>0 )
            {
                JOptionPane.showMessageDialog(null, "Thêm tài khoản thành công");
                reset();
            }
            else
            JOptionPane.showMessageDialog(null, "Thêm tài khoản thất bại");

        }
    }//GEN-LAST:event_Exit2ActionPerformed

    private void Exit3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Exit3ActionPerformed
        // TODO add your handling code here:

        reset();
    }//GEN-LAST:event_Exit3ActionPerformed

    private void txtcustMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtcustMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcustMouseExited

    private void txtcustActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcustActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcustActionPerformed

    private void txtmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmaActionPerformed

    private void txtmaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmaKeyPressed
        // TODO add your handling code here:\
        String text = txtma.getText();
        if (text.length() >= 8) {
            txtma.setEditable(false);
        } else {
            char c = evt.getKeyChar();
            if (Character.isLetter(c)) {
                txtma.setEditable(false);
            } else {
                txtma.setEditable(true);
            }
        }
    }//GEN-LAST:event_txtmaKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        RandomMaKH();
    }//GEN-LAST:event_jButton2ActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Exit2;
    private javax.swing.JButton Exit3;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel txtbal;
    private javax.swing.JTextField txtcust;
    private com.raven.suportSwing.TextField txtma;
    private javax.swing.JLabel txttt;
    // End of variables declaration//GEN-END:variables
}
