/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import DAO.BranchDAO;
import DAO.UserDAO;
import Model.Branch;
import Model.User;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MSI-VN
 */
public class UserForm extends javax.swing.JPanel {
    private JComboBox<String> branchComboBox;
//    private JComboBox<String> txtcn;
    ArrayList<User> dssp;
    int row;
    UserDAO udao=new UserDAO();
    public UserForm() {
        initComponents();
        branch();
          loadTable();
          autoID();
    }

    public void autoID()
    {
        String newUserID = udao.AutoID();
        txtma.setText(newUserID);
        
        
    }

    
    private void reset(){
        
        txtten.setText("");
        txtho.setText("");
        txtdiachi.setText("");
        txtphone.setText("");
        txtuname.setText("");
        txtpass.setText("");
         txtpq.setSelectedIndex(0);
         txtcn.setSelectedIndex(0);
//        txtmail.setText("");
    } 
    
    
    private void loadTable(){
       dssp= udao.docdanhsachuser();
         DefaultTableModel dftbl = (DefaultTableModel)tableND.getModel();
         dftbl.setRowCount(0);
         
         for(int i=0;i<dssp.size(); i++)                  
         {
         String mand=dssp.get(i).getUser_id();
         String ho=dssp.get(i).getHo();
         String ten=dssp.get(i).getTen();
         String diachi=dssp.get(i).getStreet();
         String sdt=dssp.get(i).getPhone();
         String user=dssp.get(i).getUsername();
         String pass=dssp.get(i).getPass();
         String pq=dssp.get(i).getPhanquyen();
         String macn=dssp.get(i).getBranch_id();


         Object[] row= new Object[]{mand,ho,ten,diachi,sdt,user,pass,pq,macn};
         dftbl.addRow(row);
         }
    }
    public void branch()
    {      
        BranchDAO branchDAO = new BranchDAO();
        List<Branch> branches = branchDAO.getAllBranchIds();
        for (Branch branch : branches) { 
            txtcn.addItem(branch.getBranch_id()); 
        }
    }
    private String chuyendoiPq(String Pq){
        String pq = "";
        switch (Pq){
            case "Admin": {
                pq = "1";
                break;
            }
            case "Nhân Viên":{
                pq = "2";
                break;
            }
        }
        return pq;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Exit2 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtdiachi = new javax.swing.JTextField();
        txtten = new javax.swing.JTextField();
        txtho = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtphone = new javax.swing.JFormattedTextField();
        txtma = new javax.swing.JLabel();
        txtpass = new javax.swing.JTextField();
        txtuname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtpq = new javax.swing.JComboBox<>();
        txtcn = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableND = new Swing.table.Table();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Địa Chỉ");

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Số Điện Thoại");

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Mã Nhân Viên");

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setText("Thêm");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 153, 102));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton4.setForeground(new java.awt.Color(51, 51, 51));
        jButton4.setText("Sửa");
        jButton4.setBorderPainted(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 51));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 51, 51));
        jButton3.setText("Xóa");
        jButton3.setBorderPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Họ");

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Tên");

        Exit2.setBackground(new java.awt.Color(102, 255, 102));
        Exit2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Exit2.setText("Reset");
        Exit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Exit2ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Password");

        txtdiachi.setBackground(new java.awt.Color(204, 255, 204));
        txtdiachi.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtdiachi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtdiachiMouseExited(evt);
            }
        });
        txtdiachi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdiachiActionPerformed(evt);
            }
        });

        txtten.setBackground(new java.awt.Color(204, 255, 204));
        txtten.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtten.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txttenMouseExited(evt);
            }
        });
        txtten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttenActionPerformed(evt);
            }
        });

        txtho.setBackground(new java.awt.Color(204, 255, 204));
        txtho.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txthoMouseExited(evt);
            }
        });
        txtho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthoActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Phân Quyền");

        txtphone.setBackground(new java.awt.Color(204, 255, 204));
        txtphone.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtphone.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
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

        txtma.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        txtma.setForeground(new java.awt.Color(255, 51, 51));
        txtma.setText("ID");

        txtpass.setBackground(new java.awt.Color(204, 255, 204));
        txtpass.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpassActionPerformed(evt);
            }
        });

        txtuname.setBackground(new java.awt.Color(204, 255, 204));
        txtuname.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtuname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtunameActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("UserName");

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Chi Nhánh");

        txtpq.setBackground(new java.awt.Color(204, 255, 204));
        txtpq.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Nhân Viên" }));

        txtcn.setBackground(new java.awt.Color(204, 255, 204));
        txtcn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ THÔNG TIN USER");

        tableND.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã NV", "Họ", "Tên", "Địa chỉ", "SĐT", "Username", "Pass", "Phân quyền", "Chi nhánh"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableND.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tableND.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableNDMouseClicked(evt);
            }
        });
        tableND.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableNDKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tableND);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtcn, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(48, 48, 48))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtma, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtho, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtten, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtdiachi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtphone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtuname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtpass, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtpq, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(1143, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 835, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(407, 407, 407))
            .addGroup(layout.createSequentialGroup()
                .addGap(598, 598, 598)
                .addComponent(Exit2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtma, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtho, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(3, 3, 3)))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtten, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtphone, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtuname, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtpq, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 15, Short.MAX_VALUE)))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Exit2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private Boolean checkMa(String ma){
        List<User> list = new ArrayList<>();
        list = udao.docdanhsachuser();
        for (User b : list) {
            if(ma.equals(b.getUser_id())){
                return true;
            }
        }
        return false;
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (txtma.getText().equals("")) {
            JOptionPane.showMessageDialog(this,"Hãy điền Mã người dùng");
        } else if(checkMa(txtma.getText())==true){
            JOptionPane.showMessageDialog(this,"Mã người dùng bị trùng");
        } else if(txtho.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Hãy điền họ nhân viên");
        }else if(txtten.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Hãy điền tên nhân viên");
        }else if(txtdiachi.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Hãy điền địa chỉ");
        }else if(txtphone.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Hãy điền số điện thoại");
        }else if(txtuname.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Hãy điền username");
        }else if(txtpass.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Hãy điền Password");
        }else if(txtpq.getSelectedItem().toString().equals("")){
            JOptionPane.showMessageDialog(this,"Hãy chọn phân quyền");
        }else if(txtcn.getSelectedItem().toString().equals("")){
            JOptionPane.showMessageDialog(this,"Hãy chọn chi nhánh");
        }else {
            User sp =  new User();
            sp.setUser_id(txtma.getText());
            sp.setHo(txtho.getText());
            sp.setTen(txtten.getText());
            sp.setStreet(txtdiachi.getText());
            sp.setPhone(txtphone.getText());
            sp.setUsername(txtuname.getText());
            sp.setPass(txtpass.getText());
            String pq =txtpq.getSelectedItem().toString();
            sp.setPhanquyen(chuyendoiPq(pq));
            sp.setBranch_id(txtcn.getSelectedItem().toString());

            if (udao.luuUser(sp)>0 )
            {
                JOptionPane.showMessageDialog(null, "Lưu người dùng thành công");
                reset();
                loadTable();
                autoID();
            }
            else
            JOptionPane.showMessageDialog(null, "lưu người dùng thất bại");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:

        if (txtma.getText().equals("")) {
            JOptionPane.showMessageDialog(this,"Hãy điền Mã nhân viên");
            //        } else if(checkMa(txtma.getText())==true){
            //            JOptionPane.showMessageDialog(this,"Mã nhân viên bị trùng");
        } else if(txtho.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Hãy điền họ nhân viên");
        }else if(txtten.getText()==null){
            JOptionPane.showMessageDialog(this,"Hãy điền tên nhân viên");

        }else if(txtdiachi.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Hãy điền địa chỉ");
        }else if(txtphone.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Hãy điền số điện thoại");
        }else if(txtuname.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Hãy điền username");
        }else if(txtpass.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Hãy điền Password");
        }else if(txtpq.getSelectedItem().toString().equals("")){
            JOptionPane.showMessageDialog(this,"Hãy chọn phân quyền");
        }else if(txtcn.getSelectedItem().toString().equals("")){
            JOptionPane.showMessageDialog(this,"Hãy chọn chi nhánh");
        }else {
            User sp =  new User();
            sp.setUser_id(txtma.getText());
            sp.setHo(txtho.getText());
            sp.setTen(txtten.getText());
            sp.setStreet(txtdiachi.getText());
            sp.setPhone(txtphone.getText());
            sp.setUsername(txtuname.getText());
            sp.setPass(txtpass.getText());
            String pq =txtpq.getSelectedItem().toString();
            sp.setPhanquyen(chuyendoiPq(pq));
            sp.setBranch_id(txtcn.getSelectedItem().toString());

            if (udao.capnhatUser(sp)>0 )
            {
                JOptionPane.showMessageDialog(null, "Cập Nhật Người Dùng Thành Công");
                loadTable();
                autoID();
                reset();
            }
            else
            JOptionPane.showMessageDialog(null, "Cập nhật Người Dùng thất bại,Mã đã bị thay đổi");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int index = tableND.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 User trong bảng để xóa", "Thông Báo", 1);
            return;
        }
        int tk = JOptionPane.showConfirmDialog(this,"Bạn có chắc muốn xóa User này?","Xác nhận",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if (tk==JOptionPane.YES_OPTION)
        {
            if (udao.XoaUser(tableND.getValueAt(index,0).toString()))
            {
                JOptionPane.showMessageDialog(this, "Xoá User thành công!", "Xóa User", 1);
                loadTable();
                reset();
            } else {
                JOptionPane.showMessageDialog(this, "Xoá User thất bại!", "Xóa User", 0);
            }

        }
        else
        {
            return;

        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void Exit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Exit2ActionPerformed
        // TODO add your handling code here:
        reset();
        loadTable();
        autoID();
    }//GEN-LAST:event_Exit2ActionPerformed

    private void txtdiachiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtdiachiMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdiachiMouseExited

    private void txtdiachiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdiachiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdiachiActionPerformed

    private void txttenMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txttenMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_txttenMouseExited

    private void txttenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttenActionPerformed

    private void txthoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txthoMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_txthoMouseExited

    private void txthoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthoActionPerformed

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

    private void txtpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpassActionPerformed

    private void txtunameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtunameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtunameActionPerformed

    private void tableNDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableNDKeyPressed

    }//GEN-LAST:event_tableNDKeyPressed

    private void tableNDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableNDMouseClicked
        // TODO add your handling code here:
            DefaultTableModel tableModel= (DefaultTableModel)tableND.getModel();
                String ma = tableModel.getValueAt(tableND.getSelectedRow(), 0).toString();
                String ho = tableModel.getValueAt(tableND.getSelectedRow(), 1).toString();
        
        
                String ten = tableModel.getValueAt(tableND.getSelectedRow(), 2).toString();
                String diachi = tableModel.getValueAt(tableND.getSelectedRow(), 3).toString();
                String phone = tableModel.getValueAt(tableND.getSelectedRow(), 4).toString();
                String uname = tableModel.getValueAt(tableND.getSelectedRow(), 5).toString();
                String pass = tableModel.getValueAt(tableND.getSelectedRow(), 6).toString();
                String pq = tableModel.getValueAt(tableND.getSelectedRow(), 7).toString();
                String cn = tableModel.getValueAt(tableND.getSelectedRow(), 8).toString();
        
                txtma.setText(ma);
                txtho.setText(ho);
                txtten.setText(ten); 
                txtdiachi.setText(diachi);
                txtphone.setText(phone);
                txtuname.setText(uname);
                txtpass.setText(pass);
                txtpq.setSelectedItem(pq);
                txtcn.setSelectedItem(cn);
    }//GEN-LAST:event_tableNDMouseClicked

    private void txtcnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Exit2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private Swing.table.Table tableND;
    private javax.swing.JComboBox<String> txtcn;
    private javax.swing.JTextField txtdiachi;
    private javax.swing.JTextField txtho;
    private javax.swing.JLabel txtma;
    private javax.swing.JTextField txtpass;
    private javax.swing.JFormattedTextField txtphone;
    private javax.swing.JComboBox<String> txtpq;
    private javax.swing.JTextField txtten;
    private javax.swing.JTextField txtuname;
    // End of variables declaration//GEN-END:variables
}
