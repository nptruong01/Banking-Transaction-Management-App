/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import DAO.AccountDAO;
import DAO.BranchDAO;
import DAO.GiaodichDAO;
import DAO.XacthucDAO;
import Model.Account;
import Model.AccountCustomer;
import Model.Branch;
import Model.Giaodich;
import Model.Xacthuc;
import com.ibm.icu.text.RuleBasedNumberFormat;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author MSI-VN
 */
public class RutTienForm extends javax.swing.JPanel {
    XacthucDAO xtdao=new XacthucDAO();
    GiaodichDAO gddao=new GiaodichDAO();
    public RutTienForm() {
        initComponents();
        autoID();
        date();
        code();
        this.txtmanv.setText (LoginForm.dataStatic2);
        this.txthonv.setText (LoginForm.dataStatic3);
        jButton1.setEnabled(false);
        jPanel10.setVisible(false);
        jLabel13.setVisible(false);
    }

     public void date()
        {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();  
            String date = dtf.format(now);

            txtngay.setText(date);

        }
    
    public void code()
    {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 6;
        Random random = new Random();

    String generatedString = random.ints(leftLimit, rightLimit + 1)
      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
      .limit(targetStringLength)
      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
      .toString();
     
        jLabel13.setText(generatedString);
 
    } 
     
    
    private void reset(){
        txtsearch.setText("");
        txttien.setText("");
        txttk.setText("Mã Tài Khoản");
        txtkh.setText("");
        txtho.setText("");
        txtmail.setText("");
        txtcmnd.setText("");
        txtsodu.setText("");
        jButton1.setEnabled(false);
        jPanel10.setVisible(false);
    } 
    public void autoID()
    {
       String newGDID = gddao.AutoID();
        txtma.setText(newGDID);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Exit2 = new javax.swing.JButton();
        txtma = new javax.swing.JLabel();
        txttk = new javax.swing.JLabel();
        txttien = new javax.swing.JFormattedTextField();
        Exit3 = new javax.swing.JButton();
        txtchu = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        txtkh = new com.raven.suportSwing.TextField();
        txtho = new com.raven.suportSwing.TextField();
        txtmail = new com.raven.suportSwing.TextField();
        txtcmnd = new com.raven.suportSwing.TextField();
        txtsodu = new com.raven.suportSwing.TextField();
        jPanel7 = new javax.swing.JPanel();
        txtngay = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        txtmanv = new com.raven.suportSwing.TextField();
        txthonv = new com.raven.suportSwing.TextField();
        jPanel9 = new javax.swing.JPanel();
        txtsearch = new javax.swing.JFormattedTextField();
        jButton5 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        txtsearch1 = new javax.swing.JFormattedTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setText("jLabel13");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("RÚT TIỀN");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Rút Tiền", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 0, 0))); // NOI18N
        jPanel5.setPreferredSize(new java.awt.Dimension(361, 272));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Mã Giao Dịch");

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setText("Rút Tiền");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Mã Tài Khoản");

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Số Tiền Muốn Rút");

        Exit2.setBackground(new java.awt.Color(102, 255, 102));
        Exit2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Exit2.setText("Reset");
        Exit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Exit2ActionPerformed(evt);
            }
        });

        txtma.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        txtma.setForeground(new java.awt.Color(255, 51, 51));
        txtma.setText("ID");

        txttk.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        txttk.setForeground(new java.awt.Color(51, 51, 255));
        txttk.setText("Mã Tài Khoản");

        txttien.setBackground(new java.awt.Color(204, 204, 255));
        txttien.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txttien.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txttien.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txttien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttienActionPerformed(evt);
            }
        });
        txttien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txttienKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttienKeyReleased(evt);
            }
        });

        Exit3.setBackground(new java.awt.Color(102, 255, 102));
        Exit3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Exit3.setText("Gửi Yêu cầu");
        Exit3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Exit3ActionPerformed(evt);
            }
        });

        txtchu.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtchu.setForeground(new java.awt.Color(51, 51, 51));
        txtchu.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtchu.setText("Mã Tài Khoản");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(135, 135, 135))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(137, 137, 137))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(74, 74, 74)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtma, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txttk, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGap(0, 59, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtchu, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txttien, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(86, 86, 86))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Exit3, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Exit2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtma, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttk, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txttien, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(txtchu, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Exit2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Exit3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Khách Hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(0, 51, 204))); // NOI18N
        jPanel6.setPreferredSize(new java.awt.Dimension(361, 272));

        txtkh.setBackground(new java.awt.Color(204, 255, 204));
        txtkh.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        txtkh.setLabelText("Mã Khách Hàng");
        txtkh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkhActionPerformed(evt);
            }
        });
        txtkh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtkhKeyPressed(evt);
            }
        });

        txtho.setBackground(new java.awt.Color(204, 255, 204));
        txtho.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        txtho.setLabelText("Họ Tên");
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

        txtmail.setBackground(new java.awt.Color(204, 255, 204));
        txtmail.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
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

        txtcmnd.setBackground(new java.awt.Color(204, 255, 204));
        txtcmnd.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
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

        txtsodu.setBackground(new java.awt.Color(204, 255, 204));
        txtsodu.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        txtsodu.setLabelText("Số Dư");
        txtsodu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsoduActionPerformed(evt);
            }
        });
        txtsodu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtsoduKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtho, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtcmnd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtsodu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtkh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(txtho, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtmail, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtcmnd, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(txtkh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtsodu, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thời Gian", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(0, 0, 204))); // NOI18N
        jPanel7.setPreferredSize(new java.awt.Dimension(361, 272));

        txtngay.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        txtngay.setForeground(new java.awt.Color(204, 102, 0));
        txtngay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtngay.setText("Ngày");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtngay, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtngay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Nhân Viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(0, 0, 204))); // NOI18N
        jPanel8.setPreferredSize(new java.awt.Dimension(361, 272));
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel8MouseExited(evt);
            }
        });

        txtmanv.setBackground(new java.awt.Color(204, 255, 204));
        txtmanv.setForeground(new java.awt.Color(51, 51, 51));
        txtmanv.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        txtmanv.setLabelText("Mã nhân viên");
        txtmanv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmanvActionPerformed(evt);
            }
        });
        txtmanv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtmanvKeyPressed(evt);
            }
        });

        txthonv.setBackground(new java.awt.Color(204, 255, 204));
        txthonv.setForeground(new java.awt.Color(51, 51, 51));
        txthonv.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        txthonv.setLabelText("Họ tên nhân viên");
        txthonv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthonvActionPerformed(evt);
            }
        });
        txthonv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txthonvKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtmanv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txthonv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(txtmanv, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(txthonv, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 32, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm CMND/CCCD", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 51, 0))); // NOI18N
        jPanel9.setPreferredSize(new java.awt.Dimension(361, 272));

        txtsearch.setBackground(new java.awt.Color(204, 204, 255));
        txtsearch.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtsearch.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtsearch.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsearchActionPerformed(evt);
            }
        });
        txtsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtsearchKeyPressed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 255, 255));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton5.setForeground(new java.awt.Color(51, 51, 51));
        jButton5.setText("Tìm Kiếm");
        jButton5.setBorderPainted(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 20, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Xác thực", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 51, 0))); // NOI18N
        jPanel10.setPreferredSize(new java.awt.Dimension(361, 272));

        txtsearch1.setBackground(new java.awt.Color(204, 204, 255));
        txtsearch1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtsearch1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtsearch1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtsearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsearch1ActionPerformed(evt);
            }
        });
        txtsearch1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtsearch1KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtsearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtsearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(155, 155, 155)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(267, 267, 267)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                                        .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE))
                                    .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(141, 141, 141)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE))))
                .addContainerGap(335, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 24, Short.MAX_VALUE)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel8.getAccessibleContext().setAccessibleName("Thông tin nhân viên");
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

            String id = txtma.getText();
            String acc_id = txtsearch.getText();
            String date = txtngay.getText();
            int amount = Integer.parseInt(txttien.getText());
            String branch_id = txtmanv.getText();
            String email = txtmail.getText();
            String code = txtsearch1.getText();

            // So sánh với kết quả từ DAO
            Xacthuc xacthuc = xtdao.getXacthuc(id, acc_id, date, amount, branch_id, email,code);
            if (xacthuc != null) {
                // Xử lý khi kết quả từ DAO và các TextField trùng khớp
                            if (txtma.getText().equals("ID")) {
                                JOptionPane.showMessageDialog(this,"Hãy điền mã giao dịch");
                            } else if(checkMa(txtma.getText())==true){
                                JOptionPane.showMessageDialog(this,"Mã giao dịch bị trùng");
                            } else if(txttk.getText().equals("Mã Tài Khoản")){
                                JOptionPane.showMessageDialog(this,"Hãy Điền Mã Tài Khoản");
                            }else if(txttien.getText().equals("")){
                                JOptionPane.showMessageDialog(this,"Nhập Số Tiền Vào Đi ");
                            }else if(txtmanv.getText().equals("")){
                                JOptionPane.showMessageDialog(this,"Vui lòng đăng nhập để thực hiện chức năng");
                            }else {
                                int Soduhientai = Integer.parseInt(txtsodu.getText());
                                // kiểm tra số dư có đủ để rút không
                                int Sotienrut = Integer.parseInt(txttien.getText());

                                if (Soduhientai >= Sotienrut) {

                                    Giaodich sp =  new Giaodich();
                                    sp.setGd_id(txtma.getText());
                                    sp.setAcc_id(txttk.getText());
                                    sp.setAmount(Integer.parseInt(txttien.getText()));
                                    sp.setDate(txtngay.getText());
                                    sp.setUser_id(txtmanv.getText());

                                    if (gddao.ruttien(sp) > 0 && gddao.trutien(sp) > 0 )
                                    {
                                        sp.setAmount(Integer.parseInt(txttien.getText()));
//                                        JOptionPane.showMessageDialog(null, "Rút Tiền Thành Công");


                                                    Properties prop = new Properties();
                                                    prop.put("mail.smtp.host", "smtp.gmail.com");
                                                    prop.put("mail.smtp.port", "587");
                                                    prop.put("mail.smtp.auth", "true");
                                                    prop.put("mail.smtp.starttls.enable", "true"); //TLS

                                                    Session session = Session.getInstance(prop,
                                                            new javax.mail.Authenticator() {
                                                                protected PasswordAuthentication getPasswordAuthentication() {
                                                                    return new PasswordAuthentication(username, password);
                                                                }
                                                            });
                                                    try {

                                                        Message message = new MimeMessage(session);
                                                        message.setRecipients(
                                                                Message.RecipientType.TO,
                                                                InternetAddress.parse(txtmail.getText())
                                                        );                                                       
                                                        message.setSubject("Rút tiền thành công");
                                                        message.setText("Bạn vừa rút thành công "+txttien.getText()+" VND Từ Tài Khoản Tên:"+txtho.getText()
                                                                        + "\n với Mã số tài khoản là: "+txttk.getText()
                                                                        + "\n Được nhân viên "+ txthonv.getText()+ " hỗ trợ hoàn tất giao dịch");

                                                        Transport.send(message);
                                                        JOptionPane.showMessageDialog(this, "Rút Tiền Thành Công");


                                                        jButton1.setEnabled(true);
                                                        //jPanel2.setEnabled(false);
                                                        jPanel10.setVisible(true);
                                                    } catch (MessagingException e) {
                                                        e.printStackTrace();

                                                    }
                                        reset();
                                        autoID();
                                        date();
                                    }else
                                    JOptionPane.showMessageDialog(null, "Rút Tiền thất bại");

                                } else {
                                    JOptionPane.showMessageDialog(null, "Số dư không đủ để rút tiền");
                                }
                            }
            } else {
                // Xử lý khi kết quả từ DAO và các TextField không trùng khớp
                JOptionPane.showMessageDialog(null, "Xác thực thất bại");
            }
        
 
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Exit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Exit2ActionPerformed
        // TODO add your handling code here:
        autoID();
        reset();
        date();

    }//GEN-LAST:event_Exit2ActionPerformed

    private void txttienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttienActionPerformed

    private void txttienKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttienKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            txttien.setEditable(false);
        } else {
            txttien.setEditable(true);
        }
    }//GEN-LAST:event_txttienKeyPressed

    private void jPanel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseExited
 
    }//GEN-LAST:event_jPanel8MouseExited

    private void txtsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsearchActionPerformed

    private void txtsearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsearchKeyPressed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        if (txtsearch.getText().equals("")) {
            JOptionPane.showMessageDialog(this,"Hãy điền mã tài khoản khách hàng");
        } else if(checkMaTKKH(txtsearch.getText())==false){
            JOptionPane.showMessageDialog(this,"Mã tài khoản khách hàng không tồn tại");
        }else{
            String acc_id = txtsearch.getText();
            AccountCustomer acc = gddao.laythongtin(acc_id);
            loadAccountCustomer(acc);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtsearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsearch1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsearch1ActionPerformed

    private void txtsearch1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearch1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsearch1KeyPressed

    private void Exit3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Exit3ActionPerformed
        // TODO add your handling code here:      
         if (txtma.getText().equals("ID")) {
            JOptionPane.showMessageDialog(this,"Hãy điền mã giao dịch");
        } else if(checkMa(txtma.getText())==true){
            JOptionPane.showMessageDialog(this,"Mã giao dịch bị trùng");
        } else if(txttk.getText().equals("Mã Tài Khoản")){
            JOptionPane.showMessageDialog(this,"Hãy Điền Mã Tài Khoản");
        }else if(txttien.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Nhập Số Tiền Vào Đi ");
        }else if(txtmanv.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Vui lòng đăng nhập để thực hiện chức năng");
        }else {
            int Soduhientai = Integer.parseInt(txtsodu.getText());
            // kiểm tra số dư có đủ để rút không
            int Sotienrut = Integer.parseInt(txttien.getText());

            if (Soduhientai >= Sotienrut) {

                Xacthuc sp =  new Xacthuc();
                sp.setId(txtma.getText());
                sp.setAcc_id(txttk.getText());
                sp.setDate(txtngay.getText());
                sp.setAmount(Integer.parseInt(txttien.getText()));
                sp.setBranch_id(txtmanv.getText());
                sp.setEmail(txtmail.getText());
                sp.setCode(jLabel13.getText());

                if (xtdao.xacthucruttien(sp) > 0  )
                {
                    sp.setAmount(Integer.parseInt(txttien.getText()));
                    


                    Properties prop = new Properties();
                    prop.put("mail.smtp.host", "smtp.gmail.com");
                    prop.put("mail.smtp.port", "587");
                    prop.put("mail.smtp.auth", "true");
                    prop.put("mail.smtp.starttls.enable", "true"); //TLS

                    Session session = Session.getInstance(prop,
                            new javax.mail.Authenticator() {
                                protected PasswordAuthentication getPasswordAuthentication() {
                                    return new PasswordAuthentication(username, password);
                                }
                            });
                    try {

                        Message message = new MimeMessage(session);
                        message.setRecipients(
                                Message.RecipientType.TO,
                                InternetAddress.parse(txtmail.getText())
                        );
                        message.setSubject("Bạn Đã Gửi Yêu Cầu Rút "+txttien.getText()+" VND Từ Tài Khoản Tên:"+txtho.getText()+" với mã số tài khoản là "+txttk.getText());

                        message.setText("Mã Xác Nhận Của Bạn Là:"
                                        + "\n\n"+ jLabel13.getText());

                        Transport.send(message);
                        JOptionPane.showMessageDialog(this, "Gửi yêu cầu thành công");

                        
                        jButton1.setEnabled(true);
                        //jPanel2.setEnabled(false);
                        jPanel10.setVisible(true);
                    } catch (MessagingException e) {
                        e.printStackTrace();

                    }
                }else
                JOptionPane.showMessageDialog(null, "Gửi yêu cầu Thất bại");

            } else {
                JOptionPane.showMessageDialog(null, "Số dư không đủ để giao dịch");
            }
            
            
        }

        
//        
//        jButton1.setEnabled(true);
//        jButton4.setEnabled(false);
//        jPanel2.setVisible(true);
    }//GEN-LAST:event_Exit3ActionPerformed

    private void txtkhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtkhActionPerformed

    private void txtkhKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtkhKeyPressed

    }//GEN-LAST:event_txtkhKeyPressed

    private void txthoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthoActionPerformed

    private void txthoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txthoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthoKeyPressed

    private void txtmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmailActionPerformed

    private void txtmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmailKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmailKeyPressed

    private void txtcmndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcmndActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcmndActionPerformed

    private void txtcmndKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcmndKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcmndKeyPressed

    private void txtsoduActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsoduActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsoduActionPerformed

    private void txtsoduKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsoduKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsoduKeyPressed

    private void txtmanvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmanvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmanvActionPerformed

    private void txtmanvKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmanvKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmanvKeyPressed

    private void txthonvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthonvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthonvActionPerformed

    private void txthonvKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txthonvKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthonvKeyPressed

    private void txttienKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttienKeyReleased
        // TODO add your handling code here:
        String chu =txtchu.getText();
        try {
                   
            RuleBasedNumberFormat ruleBasedNumberFormat = new RuleBasedNumberFormat(new Locale("vi", "VN"), RuleBasedNumberFormat.SPELLOUT);
            chu = ruleBasedNumberFormat.format(Integer.parseInt(txttien.getText())) + " đồng";
        } catch (Exception e) {
            chu = "Không đồng";      
        }
            txtchu.setText( chu);
    }//GEN-LAST:event_txttienKeyReleased

      private Boolean checkMa(String ma){
            List<Giaodich> list = new ArrayList<>();
            list = gddao.docdanhsachgiaodich();
            for (Giaodich b : list) {
                if(ma.equals(b.getGd_id())){
                    return true;
                }
            }
            return false;
        }  
    private Boolean checkMaTKKH(String acc_id){
            List<Account> list1 = new ArrayList<>();
            AccountDAO adao=new AccountDAO();
            list1 = adao.docdanhsachtk();
            for (Account b1 : list1) {
                if(acc_id.equals(b1.getAcc_id())){
                    return true;
                }
            }
            return false;
        } 
    public void loadAccountCustomer(AccountCustomer acc) {
        if (acc != null) {
            // Set giá trị cho các jLabel tương ứng trên UI
            txttk.setText(acc.getAcc_id());
            txtkh.setText(acc.getCust_id());
            txtho.setText(acc.getHo() + " " + acc.getTen());
            txtmail.setText(acc.getMail());
            txtcmnd.setText(acc.getCmnd());
            txtsodu.setText(String.valueOf(acc.getBalance()));
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Exit2;
    private javax.swing.JButton Exit3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel txtchu;
    private com.raven.suportSwing.TextField txtcmnd;
    private com.raven.suportSwing.TextField txtho;
    private com.raven.suportSwing.TextField txthonv;
    private com.raven.suportSwing.TextField txtkh;
    private javax.swing.JLabel txtma;
    private com.raven.suportSwing.TextField txtmail;
    private com.raven.suportSwing.TextField txtmanv;
    private javax.swing.JLabel txtngay;
    private javax.swing.JFormattedTextField txtsearch;
    private javax.swing.JFormattedTextField txtsearch1;
    private com.raven.suportSwing.TextField txtsodu;
    private javax.swing.JFormattedTextField txttien;
    private javax.swing.JLabel txttk;
    // End of variables declaration//GEN-END:variables
}
