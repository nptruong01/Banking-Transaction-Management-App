package Form;

import Component.Header;
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
import java.awt.Component;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author MSI-VN
 */
public class ChuyenTienForm extends javax.swing.JPanel {
    XacthucDAO xtdao=new XacthucDAO();
    GiaodichDAO gddao=new GiaodichDAO();
    public ChuyenTienForm() {
        initComponents();
        autoID();
        date();
        code();
        this.txtmanv.setText (LoginForm.dataStatic2);
        this.txthonv.setText (LoginForm.dataStatic3);
        txtmail.setVisible(false);
        jLabel13.setVisible(false);
        jButton1.setEnabled(false);
        //jPanel2.setEnabled(false);
        jPanel10.setVisible(false);
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
        txttien.setText("");
        txttk.setText("");
        txttknhan.setText("");
        txtten.setText("Họ và tên");
        txtsodu.setText("Số dư");
        txttentknhan.setText("Họ và tên");
    } 
    public void autoID()
    {
        String newGDID = gddao.AutoID();
        txtma.setText(newGDID);
    }

        public void loadAccountCustomer(AccountCustomer acc) {
            if (acc != null) {
                txtten.setText(acc.getHo() + " " + acc.getTen());
                txtsodu.setText(String.valueOf(acc.getBalance()));
                txtmail.setText(acc.getMail());
                String chu =txtchu1.getText();
                try {

                    RuleBasedNumberFormat ruleBasedNumberFormat = new RuleBasedNumberFormat(new Locale("vi", "VN"), RuleBasedNumberFormat.SPELLOUT);
                    chu = ruleBasedNumberFormat.format(Integer.parseInt(txtsodu.getText())) + " đồng";
                } catch (Exception e) {
                    chu = "Không đồng";      
                }
                    txtchu1.setText( chu);
            }
        }
        
        public void loadAccountCustomer1(AccountCustomer acc) {
            if (acc != null) {
                txttentknhan.setText(acc.getHo() + " " + acc.getTen());
            }
        }

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
        
public class MyOtherClass {
    public void setUserNameToTextField(JTextField textField, JLabel label) {
        String userName = label.getText();
        textField.setText(userName);
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        Exit2 = new javax.swing.JButton();
        txttien = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        txttknhan = new javax.swing.JFormattedTextField();
        txttentknhan = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        Exit3 = new javax.swing.JButton();
        txtchu = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        txtma = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        txtngay = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtsodu = new javax.swing.JLabel();
        txtten = new javax.swing.JLabel();
        txttk = new javax.swing.JFormattedTextField();
        jButton5 = new javax.swing.JButton();
        txtchu1 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        txtsearch1 = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        txtmanv = new com.raven.suportSwing.TextField();
        txthonv = new com.raven.suportSwing.TextField();
        txtmail = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chuyển Tiền", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 0, 0))); // NOI18N
        jPanel5.setPreferredSize(new java.awt.Dimension(361, 272));

        jButton1.setBackground(new java.awt.Color(255, 0, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setText("Chuyển Tiền");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Số Tiền Muốn Chuyển");

        Exit2.setBackground(new java.awt.Color(102, 255, 102));
        Exit2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Exit2.setText("Reset");
        Exit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Exit2ActionPerformed(evt);
            }
        });

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

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Mã Tài Khoản Nhận");

        txttknhan.setBackground(new java.awt.Color(204, 204, 255));
        txttknhan.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txttknhan.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txttknhan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txttknhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttknhanActionPerformed(evt);
            }
        });
        txttknhan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txttknhanKeyPressed(evt);
            }
        });

        txttentknhan.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        txttentknhan.setForeground(new java.awt.Color(255, 0, 0));
        txttentknhan.setText("Họ và tên");

        jButton6.setBackground(new java.awt.Color(102, 255, 255));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton6.setForeground(new java.awt.Color(51, 51, 51));
        jButton6.setText("Tìm Kiếm");
        jButton6.setBorderPainted(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
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
        txtchu.setText("Không đồng");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel8)
                                .addGap(50, 50, 50)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(txttknhan, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txttentknhan, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txttien)
                                    .addComponent(txtchu, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE))))
                        .addGap(0, 28, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Exit3)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addComponent(Exit2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttknhan, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(txttentknhan, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txttien, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtchu)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Exit3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Exit2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mã Giao Dịch", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 0, 51))); // NOI18N
        jPanel9.setPreferredSize(new java.awt.Dimension(361, 272));

        txtma.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        txtma.setForeground(new java.awt.Color(255, 51, 51));
        txtma.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtma.setText("ID");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtma, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtma, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
                .addComponent(txtngay, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtngay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CHUYỂN KHOẢN");

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(0, 51, 204))); // NOI18N
        jPanel6.setPreferredSize(new java.awt.Dimension(361, 272));

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Mã Tài Khoản Gửi");

        txtsodu.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        txtsodu.setForeground(new java.awt.Color(0, 51, 153));
        txtsodu.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtsodu.setText("Số dư");

        txtten.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        txtten.setForeground(new java.awt.Color(255, 51, 51));
        txtten.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtten.setText("Họ và tên");

        txttk.setBackground(new java.awt.Color(204, 204, 255));
        txttk.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txttk.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txttk.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txttk.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txttkFocusLost(evt);
            }
        });
        txttk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txttkMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txttkMouseReleased(evt);
            }
        });
        txttk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttkActionPerformed(evt);
            }
        });
        txttk.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txttkKeyPressed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(102, 255, 255));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton5.setForeground(new java.awt.Color(51, 51, 51));
        jButton5.setText("Tìm Kiếm");
        jButton5.setBorderPainted(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        txtchu1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtchu1.setForeground(new java.awt.Color(51, 51, 51));
        txtchu1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtchu1.setText("Không đồng");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(96, 375, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(txttk)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtten, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtsodu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtchu1, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txttk)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtten, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtsodu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtchu1)
                .addGap(38, 38, 38))
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Xác thực", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 51, 0))); // NOI18N
        jPanel10.setPreferredSize(new java.awt.Dimension(361, 272));

        txtsearch1.setBackground(new java.awt.Color(204, 204, 255));
        txtsearch1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtsearch1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtsearch1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
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
                .addGap(28, 28, 28)
                .addComponent(txtsearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jLabel13.setText("jLabel13");

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
                    .addComponent(txthonv, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                    .addComponent(txtmanv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(txtmanv, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txthonv, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 28, Short.MAX_VALUE))
        );

        txtmail.setText("jLabel13");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(txtmail, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(84, 84, 84))
                            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(149, 149, 149))
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(146, 146, 146))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtmail, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    String id = txtma.getText();
    String acc_id = txttk.getText();
    String date = txtngay.getText();
    int amount = Integer.parseInt(txttien.getText());
    String branch_id = txtmanv.getText();
    String email = txtmail.getText();
    String code = txtsearch1.getText();

            // So sánh với kết quả từ DAO
    Xacthuc xacthuc = xtdao.getXacthuc(id, acc_id, date, amount, branch_id, email,code);
    if (xacthuc != null) {
        if (txtma.getText().equals("ID")) {
            JOptionPane.showMessageDialog(this,"Hãy điền mã giao dịch");
        } else if(checkMa(txtma.getText())==true){
            JOptionPane.showMessageDialog(this,"Mã giao dịch bị trùng");
        } else if(txttk.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Hãy Điền Mã Tài Khoản Gửi");
        } else if(txttknhan.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Hãy Điền Mã Tài Khoản Nhận");
        }else if(txttien.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Nhập Số Tiền Vào Đi ");
        }else if(txtngay.getText().equals("Ngày")){
            JOptionPane.showMessageDialog(this,"Hãy điền ngày vào");
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
                    sp.setToacc_id(txttknhan.getText());
                    sp.setAmount(Integer.parseInt(txttien.getText()));
                    sp.setDate(txtngay.getText());
                    sp.setUser_id(txtmanv.getText());

                    if (gddao.chuyenkhoan(sp) > 0 && gddao.congtienchuyenkhoan(sp) > 0 && gddao.trutien(sp) > 0 )
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
                                    message.setSubject("Chuyển Khoản Thành Công");
                                    message.setText("Bạn vừa nạp thành công "+txttien.getText()+" VND Từ Tài Khoản Tên:"+txtten.getText()
                                        + "\n với Mã số tài khoản là: "+txttk.getText()+ " Sang Tài Khoản Tên:"+txttentknhan.getText()+" với mã số tài khoản là "+txttknhan.getText()
                                        + "\n Được nhân viên "+ txthonv.getText()+ " hỗ trợ hoàn tất giao dịch");

                                    
                                    Transport.send(message);
                                    sp.setAmount(Integer.parseInt(txttien.getText()));
                                    JOptionPane.showMessageDialog(this, "Chuyển Khoản Thành Công");

                                } catch (MessagingException e) {
                                    e.printStackTrace();
                                }                    
                        
//                        JOptionPane.showMessageDialog(null, "Chuyển Khoản Thành Công");
                        reset();
                        autoID();
                        date();
                    }else
                    JOptionPane.showMessageDialog(null, "Chuyển Khoản thất bại");

                } else {
                    JOptionPane.showMessageDialog(null, "Số dư không đủ để chuyển tiền");
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

    private void txttknhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttknhanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttknhanActionPerformed

    private void txttknhanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttknhanKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttknhanKeyPressed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        if (txttknhan.getText().equals("")) {
            JOptionPane.showMessageDialog(this,"Hãy điền mã tài khoản khách hàng");
        } else if(checkMaTKKH(txttknhan.getText())==false){
            JOptionPane.showMessageDialog(this,"Mã tài khoản khách hàng không tồn tại");
        }else{
            String acc_id = txttknhan.getText();
            AccountCustomer acc = gddao.laythongtin(acc_id);
            loadAccountCustomer1(acc);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void txttkFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txttkFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txttkFocusLost

    private void txttkMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txttkMouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_txttkMouseExited

    private void txttkMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txttkMouseReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_txttkMouseReleased

    private void txttkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttkActionPerformed

    private void txttkKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttkKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttkKeyPressed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        if (txttk.getText().equals("")) {
            JOptionPane.showMessageDialog(this,"Hãy điền mã tài khoản khách hàng");
        } else if(checkMaTKKH(txttk.getText())==false){
            JOptionPane.showMessageDialog(this,"Mã tài khoản khách hàng không tồn tại");
        }else{
            String acc_id = txttk.getText();
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
        } else if(txttk.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Hãy Điền Mã Tài Khoản Gửi");
        } else if(txttknhan.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Hãy Điền Mã Tài Khoản Nhận");
        }else if(txttien.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Nhập Số Tiền Vào Đi ");
        }else if(txtngay.getText().equals("Ngày")){
            JOptionPane.showMessageDialog(this,"Hãy điền ngày vào");
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
                        message.setSubject("Bạn Đã Gửi Yêu Cầu Chuyển Khoản "+txttien.getText()+" VND Từ Tài Khoản Tên:"+txtten.getText()+" với mã số tài khoản là "+txttk.getText()
                                            + "\n"+ " Sang Tài Khoản Tên:"+txttentknhan.getText()+" với mã số tài khoản là "+txttknhan.getText());
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
    }//GEN-LAST:event_Exit3ActionPerformed

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

    private void jPanel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseExited

    }//GEN-LAST:event_jPanel8MouseExited

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Exit2;
    private javax.swing.JButton Exit3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel txtchu;
    private javax.swing.JLabel txtchu1;
    private com.raven.suportSwing.TextField txthonv;
    private javax.swing.JLabel txtma;
    private javax.swing.JLabel txtmail;
    private com.raven.suportSwing.TextField txtmanv;
    private javax.swing.JLabel txtngay;
    private javax.swing.JFormattedTextField txtsearch1;
    private javax.swing.JLabel txtsodu;
    private javax.swing.JLabel txtten;
    private javax.swing.JLabel txttentknhan;
    private javax.swing.JFormattedTextField txttien;
    private javax.swing.JFormattedTextField txttk;
    private javax.swing.JFormattedTextField txttknhan;
    // End of variables declaration//GEN-END:variables
}
