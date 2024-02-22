/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import DAO.CustomerDAO;
import static Form.LoginForm.dataStatic;
import Model.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author MSI-VN
 */
public class Step1Form extends javax.swing.JPanel {

    CustomerDAO customerdao = new CustomerDAO();
    ArrayList<Customer> dssp;
    int row;
    public Step1Form() {
        initComponents();
        setOpaque(false);
        autoID();
        reset();
    }

        private void reset(){
        txtten.setText("");
        txtho.setText("");
        txtdiachi.setText("");
        txtphone.setText("");
        txtcmnd.setText("");
         txtgioitinh.setSelectedIndex(0);
        txtmail.setText("");
    } 
    
    private void autoID() {          
        String ID = customerdao.AutoID();
        txtma.setText(ID);
    }
    
    private Boolean checkMa(String ma){
        List<Customer> list = new ArrayList<>();
        list = customerdao.docdanhsachsp();
        for (Customer b : list) {
            if(ma.equals(b.getCust_id())){
                return true;
            }
        }
        return false;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtma = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtgioitinh = new javax.swing.JComboBox<>();
        Exit2 = new javax.swing.JButton();
        Exit3 = new javax.swing.JButton();
        txtho = new com.raven.suportSwing.TextField();
        txtten = new com.raven.suportSwing.TextField();
        txtdiachi = new com.raven.suportSwing.TextField();
        txtcmnd = new com.raven.suportSwing.TextField();
        txtphone = new com.raven.suportSwing.TextField();
        txtmail = new com.raven.suportSwing.TextField();

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Địa Chỉ");

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Mã Khách Hàng");

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("SDT");

        txtma.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        txtma.setForeground(new java.awt.Color(255, 51, 51));
        txtma.setText("ID");

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Giới Tính");

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Họ");

        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Email");

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Tên");

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("CMND/CCCD");

        txtgioitinh.setBackground(new java.awt.Color(204, 255, 204));
        txtgioitinh.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtgioitinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

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

        txtho.setBackground(new java.awt.Color(204, 255, 204));
        txtho.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtho.setLabelText("Họ");
        txtho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthoActionPerformed(evt);
            }
        });
        txtho.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txthoKeyPressed(evt);
            }
        });

        txtten.setBackground(new java.awt.Color(204, 255, 204));
        txtten.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtten.setLabelText("Tên");
        txtten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttenActionPerformed(evt);
            }
        });
        txtten.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txttenKeyPressed(evt);
            }
        });

        txtdiachi.setBackground(new java.awt.Color(204, 255, 204));
        txtdiachi.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtdiachi.setLabelText("Địa chỉ");
        txtdiachi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdiachiActionPerformed(evt);
            }
        });
        txtdiachi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtdiachiKeyPressed(evt);
            }
        });

        txtcmnd.setBackground(new java.awt.Color(204, 255, 204));
        txtcmnd.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtcmnd.setLabelText("CMND/CCCD");
        txtcmnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcmndActionPerformed(evt);
            }
        });
        txtcmnd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcmndKeyPressed(evt);
            }
        });

        txtphone.setBackground(new java.awt.Color(204, 255, 204));
        txtphone.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtphone.setLabelText("SĐT");
        txtphone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtphoneActionPerformed(evt);
            }
        });
        txtphone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtphoneKeyPressed(evt);
            }
        });

        txtmail.setBackground(new java.awt.Color(204, 255, 204));
        txtmail.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtmail.setLabelText("Email");
        txtmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmailActionPerformed(evt);
            }
        });
        txtmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtmailKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(184, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(105, 105, 105)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtten, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtdiachi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtcmnd, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(txtma, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(89, 89, 89)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Exit3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtgioitinh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtphone, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(Exit2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(142, 142, 142))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtphone, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtmail, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtgioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Exit3)
                            .addComponent(Exit2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtma, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtho, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtten, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcmnd, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)))
                .addContainerGap(131, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    private void Exit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Exit2ActionPerformed
        // TODO add your handling code here:
                if (txtma.getText().equals("")) {
            JOptionPane.showMessageDialog(this,"Hãy điền mã khách hàng");
        } else if(checkMa(txtma.getText())==true){
            JOptionPane.showMessageDialog(this,"Mã Khách hàng bị trùng");
        } else if(txtho.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Hãy điền họ khách hàng");
        }else if(txtten.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Hãy điền tên khách hàng");
        } else if(txtcmnd.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Hãy điền số CMND/CCCD");
        }else if(txtdiachi.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Hãy điền địa chỉ");
        }else if(txtphone.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Hãy số điện thoại");
        }else if(txtgioitinh.getSelectedItem().toString().equals("")){
            JOptionPane.showMessageDialog(this,"Hãy chọn giới tính");
        }else if(txtmail.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Hãy điền mail");
        }else {
            Customer sp =  new Customer();

           sp.setCust_id(txtma.getText());
           sp.setHo(txtho.getText());
           sp.setTen(txtten.getText());
           sp.setCmnd(txtcmnd.getText());
           sp.setStreet(txtdiachi.getText());
           sp.setPhone(txtphone.getText());
           sp.setGioitinh(txtgioitinh.getSelectedItem().toString());
           sp.setEmail(txtmail.getText());

           CustomerDAO spdao =new CustomerDAO() ;

           if (spdao.luusanpham(sp)>0 )
           {    
           JOptionPane.showMessageDialog(null, "Lưu khách hàng thành công");
//           hienthilentable();
           autoID();
           reset();
           
          
                   
           }
           else
                  JOptionPane.showMessageDialog(null, "lưu khách hàng thất bại");
            }
    }//GEN-LAST:event_Exit2ActionPerformed

    private void Exit3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Exit3ActionPerformed
        // TODO add your handling code here:
        autoID();
        reset();
    }//GEN-LAST:event_Exit3ActionPerformed

    private void txthoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthoActionPerformed

    private void txthoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txthoKeyPressed

    }//GEN-LAST:event_txthoKeyPressed

    private void txttenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttenActionPerformed

    private void txttenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttenKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttenKeyPressed

    private void txtdiachiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdiachiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdiachiActionPerformed

    private void txtdiachiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdiachiKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdiachiKeyPressed

    private void txtcmndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcmndActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcmndActionPerformed

    private void txtcmndKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcmndKeyPressed

        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            txtcmnd.setEditable(false);
        } else {
            txtcmnd.setEditable(true);
        }
    }//GEN-LAST:event_txtcmndKeyPressed

    private void txtphoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtphoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtphoneActionPerformed

    private void txtphoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtphoneKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            txtphone.setEditable(false);
        } else {
            txtphone.setEditable(true);
        }
    }//GEN-LAST:event_txtphoneKeyPressed

    private void txtmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmailActionPerformed

    private void txtmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmailKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmailKeyPressed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Exit2;
    private javax.swing.JButton Exit3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private com.raven.suportSwing.TextField txtcmnd;
    private com.raven.suportSwing.TextField txtdiachi;
    private javax.swing.JComboBox<String> txtgioitinh;
    private com.raven.suportSwing.TextField txtho;
    private javax.swing.JLabel txtma;
    private com.raven.suportSwing.TextField txtmail;
    private com.raven.suportSwing.TextField txtphone;
    private com.raven.suportSwing.TextField txtten;
    // End of variables declaration//GEN-END:variables
}
