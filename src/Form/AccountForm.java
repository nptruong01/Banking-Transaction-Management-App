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
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author MSI-VN
 */
public class AccountForm extends javax.swing.JPanel {
    ArrayList<Account> dssp;
    ArrayList<Customer> dssp1;
    int row;
    
    
    public AccountForm() {
        initComponents();
        loadTable();
        loadTable1();
        fontsize();
        setOpaque(false);
    }
    private void reset(){
        txtma.setText("");    
        txtcust.setText("Chọn bên trong Bảng thông tin KH");
        
    } 
    private void fontsize(){
        Font font = new Font("Arial", Font.BOLD, 16); // tạo một Font mới với kích thước 16
    tableTK.setFont(font); // đặt Font cho table
    tableTK.getTableHeader().setFont(font); // đặt Font cho header của table
        
    } 
     private void RandomMaKH(){
        Random rand = new Random();
        int randomNumber = rand.nextInt(100000000);
        String randomString = String.format("%08d", randomNumber);
        txtma.setText(randomString);
         
    }
//    DefaultTableModel dtmDanhSach;
    AccountDAO accdao = new AccountDAO();
    private void loadTable(){
        AccountDAO spdao = new AccountDAO();
       dssp= spdao.docdanhsachtk();
         DefaultTableModel dftbl = (DefaultTableModel)tableTK.getModel();
         dftbl.setRowCount(0);
         
         for(int i=0;i<dssp.size(); i++)
                  
         {
         String matk=dssp.get(i).getAcc_id();
         String makh=dssp.get(i).getCust_id();
         int bal=dssp.get(i).getBalance();
         String tt=dssp.get(i).getTrangthai();


         Object[] row= new Object[]{matk, makh,bal, tt};
         dftbl.addRow(row);
         }       
    }
    private void loadTable1(){

         CustomerDAO spdao = new CustomerDAO();
         dssp1= spdao.docdanhsachsp();
         DefaultTableModel dftbl = (DefaultTableModel)tableKH.getModel();
         dftbl.setRowCount(0);     
         for(int i=0;i<dssp1.size(); i++)
       
         {
         String ma=dssp1.get(i).getCust_id();
         String ho=dssp1.get(i).getHo();
         String ten=dssp1.get(i).getTen();
         String cmnd=dssp1.get(i).getCmnd();

         Object[] row= new Object[]{ma, ho,ten, cmnd};
         dftbl.addRow(row);
         }
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

        Exit1 = new javax.swing.JButton();
        txttt = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtcust = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Exit2 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtbal = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtma1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableKH = new com.raven.suportSwing.TableColumn();
        txtma = new com.raven.suportSwing.TextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableTK = new com.raven.suportSwing.TableColumn();

        setBackground(new java.awt.Color(255, 255, 255));

        Exit1.setBackground(new java.awt.Color(255, 51, 51));
        Exit1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Exit1.setText("Thoát");
        Exit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Exit1ActionPerformed(evt);
            }
        });

        txttt.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        txttt.setForeground(new java.awt.Color(255, 51, 51));
        txttt.setText("Active");

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Trạng Thái");

        jButton1.setBackground(new java.awt.Color(114, 114, 244));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setText("Thêm");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Mã Tài Khoản");

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Số Dư");

        Exit2.setBackground(new java.awt.Color(102, 255, 102));
        Exit2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Exit2.setText("Reset");
        Exit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Exit2ActionPerformed(evt);
            }
        });

        jButton2.setText("Random");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtbal.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        txtbal.setForeground(new java.awt.Color(0, 0, 255));
        txtbal.setText("0");

        jButton3.setBackground(new java.awt.Color(114, 114, 244));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 51, 51));
        jButton3.setText("Xóa");
        jButton3.setBorderPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Mã Khách Hàng");

        txtma1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        txtma1.setForeground(new java.awt.Color(51, 51, 51));
        txtma1.setText("Bảng Thông Tin Khách Hàng");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ THÔNG TIN TÀI KHOẢN");

        tableKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID ", "Tên KH", "Địa Chỉ", "SĐT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableKHMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tableKH);

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

        tableTK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID ", "Tên KH", "Địa Chỉ", "SĐT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableTK.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tableTK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableTKMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tableTK);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(251, 251, 251)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 835, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtcust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtma, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(102, 102, 102)
                                        .addComponent(jButton2))
                                    .addComponent(txtbal, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txttt, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(653, 653, 653)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(txtma1)
                        .addGap(172, 172, 172)
                        .addComponent(Exit1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(Exit2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtma, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(txtcust, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(22, 22, 22)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(38, 38, 38)
                                        .addComponent(txtbal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(35, 35, 35)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txttt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addComponent(txtma1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Exit1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(25, 25, 25))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Exit2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(29, 29, 29)))
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
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
                loadTable();
                loadTable1();
                reset();
            }
            else
            JOptionPane.showMessageDialog(null, "Thêm tài khoản thất bại");

        }
    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int index = tableTK.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 tài khoản trong bảng để xóa", "Thông Báo", 1);
            return;
        }
        //        AccountDAO spdao = new AccountDAO();

        int tk = JOptionPane.showConfirmDialog(this,"Bạn có chắc muốn xóa tài khoản này?","Xác nhận",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if (tk==JOptionPane.YES_OPTION)
        {
            if (accdao.Xoataikhoan(tableTK.getValueAt(index,0).toString()))
            {
                JOptionPane.showMessageDialog(this, "Xoá tài khoản thành công!", "Xóa tài khoản", 1);
                loadTable();
                loadTable1();
                reset();
            } else {
                JOptionPane.showMessageDialog(this, "Xoá tài khoản thất bại!", "Xóa tài khoản", 0);
            }

        }
        else
        {
            return;

        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void Exit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Exit1ActionPerformed
        // TODO add your handling code here:
//        this.dispose();
    }//GEN-LAST:event_Exit1ActionPerformed

    private void Exit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Exit2ActionPerformed
        // TODO add your handling code here:
        txtma.setEnabled(true);
        //                autoID();
        reset();

    }//GEN-LAST:event_Exit2ActionPerformed

    private void txtcustMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtcustMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcustMouseExited

    private void txtcustActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcustActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcustActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        RandomMaKH();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tableKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableKHMouseClicked
        // TODO add your handling code here:
//        edit();
        row = tableKH.getSelectedRow();
        if (row== -1) return ;
        Customer sp = dssp1.get(row);
     
        txtcust.setText(dssp1.get(row).getCust_id());
    }//GEN-LAST:event_tableKHMouseClicked

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

    private void tableTKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTKMouseClicked
        // TODO add your handling code here:
                row = tableTK.getSelectedRow();
                if (row== -1) return ;
                Account sp = dssp.get(row);
     
                txtma.setText(dssp.get(row).getAcc_id());
    }//GEN-LAST:event_tableTKMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Exit1;
    private javax.swing.JButton Exit2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private com.raven.suportSwing.TableColumn tableKH;
    private com.raven.suportSwing.TableColumn tableTK;
    private javax.swing.JLabel txtbal;
    private javax.swing.JTextField txtcust;
    private com.raven.suportSwing.TextField txtma;
    private javax.swing.JLabel txtma1;
    private javax.swing.JLabel txttt;
    // End of variables declaration//GEN-END:variables
}
