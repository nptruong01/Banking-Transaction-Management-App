/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import DAO.GiaodichDAO;
import Model.AccountCustomer;
import Model.Giaodich;
import Model.Sodu;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author MSI-VN
 */
public class ThongKeForm extends javax.swing.JPanel {

    ArrayList<Giaodich> dssp;
    int row;
    
    public ThongKeForm() {
        initComponents();
        ten.setVisible(false);
        street.setVisible(false);
        phone.setVisible(false);
    }


    
    public void bill_print(){
 
        try {
             
            
            
            
            bill.setText("                                                      BẢN SAO KÊ NGÂN HÀNG \n");
            bill.setText(bill.getText() + "                                                         Ngân Hàng PT Bank\n");            
            bill.setText(bill.getText() + "\t \t \t 236B Lê Văn Sỹ, P1 ,Q Tân Bình TPHCM \n");
            bill.setText(bill.getText() + "\t \t \t \t \t0931326039 \n");
            bill.setText(bill.getText() + "========================================================================\n");
            bill.setText(bill.getText() + "Mã Khách Hàng :\t"+txtSearch.getText()+"\n");
            bill.setText(bill.getText() + "Họ và Tên :\t \t"+ten.getText()+"\n");
            bill.setText(bill.getText() + "Địa Chỉ :\t \t"+street.getText()+"\n");
            bill.setText(bill.getText() + "SĐT :\t \t"+phone.getText()+"\n");
            bill.setText(bill.getText() + "========================================================================\n");
            bill.setText(bill.getText() + "--------------------------------------------------------------------------------------------------------------------------------\n");
            bill.setText(bill.getText() + " MaKH \tMaNhan \tQty \tPrice \t \tPrice \n");
            bill.setText(bill.getText() + "--------------------------------------------------------------------------------------------------------------------------------\n");
            


            DefaultTableModel df = (DefaultTableModel) table1.getModel();
            for (int i = 0; i < table1.getRowCount(); i++) {
                
                String ma=dssp.get(i).getGd_id();
                String acc_id=dssp.get(i).getAcc_id();
                String toacc_id=dssp.get(i).getToacc_id();
                String type=dssp.get(i).getType();
                String date=dssp.get(i).getDate();
                int amount=dssp.get(i).getAmount();  
                String user_id=dssp.get(i).getUser_id();
                
                bill.setText(bill.getText() + acc_id+"\t"+toacc_id+" \t"+ type+"\t"+ date+"\t"+amount+" \n");
                
            }
            bill.setText(bill.getText() + "--------------------------------------------------------------------------------------------------------------------------------\n");
//            bill.setText(bill.getText() + "SubTotal :\t"+txtSearch.getText()+"\n");
//            bill.setText(bill.getText() + "Cash :\t"+Cash.getText()+"\n");
//            bill.setText(bill.getText() + "Ballance :\t"+Bal.getText()+"\n");
//            bill.setText(bill.getText() + "========================================================================\n");
            bill.setText(bill.getText() +"                                                  Cảm ơn bản đã tin tưởng...!"+"\n");
            bill.setText(bill.getText() + "========================================================================\n");
//            bill.setText(bill.getText() + "--------------------------------------------------------------------------------------------------------------------------------\n");
            bill.setText(bill.getText() +"                                                   Software by PhiTruong"+"\n");
            
            
            bill.print();
            
        } catch (PrinterException ex) {
            
            Logger.getLogger(ThongKeForm.class.getName()).log(Level.SEVERE, null, ex);
        }
 
 }
    public void openFile(String file){
        try{
            File path = new File(file);
            Desktop.getDesktop().open(path);
        }catch(IOException ioe){
            System.out.println(ioe);
        }
    }
    
         public void loadAccountCustomer(Sodu acc) {
        if (acc != null) {
            // Set giá trị cho các jLabel tương ứng trên UI

            ten.setText(acc.getHo() + " " + acc.getTen());
            street.setText(acc.getStreet());
            phone.setText(acc.getPhone());
        }
    } 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel11 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JFormattedTextField();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new Swing.table.Table();
        jButton14 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        bill = new javax.swing.JTextArea();
        street = new javax.swing.JLabel();
        phone = new javax.swing.JLabel();
        ten = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(51, 255, 0)), "Tìm Kiếm Bằng Mã Tài Khoản", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 51, 0))); // NOI18N
        jPanel11.setPreferredSize(new java.awt.Dimension(361, 272));

        txtSearch.setBackground(new java.awt.Color(204, 204, 255));
        txtSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtSearch.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(0, 255, 255));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton6.setForeground(new java.awt.Color(51, 51, 51));
        jButton6.setText("Tìm Kiếm");
        jButton6.setBorderPainted(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 15, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THỐNG KÊ GIAO DỊCH VÀ IN HÓA ĐƠN");

        jButton1.setBackground(new java.awt.Color(51, 255, 0));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setText("Xuất File Excel");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã giao dịch", "Mã TK", "Mã TK nhận", "Phương thức", "Thời gian", "Số tiền", "Mã Nhân viên"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jScrollPane1.setViewportView(table1);

        jButton14.setBackground(new java.awt.Color(255, 0, 51));
        jButton14.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton14.setText("Sao Kê");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        bill.setColumns(20);
        bill.setRows(5);
        jScrollPane2.setViewportView(bill);

        street.setText("jLabel2");

        phone.setText("jLabel3");

        ten.setText("jLabel4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(street)
                        .addGap(59, 59, 59)
                        .addComponent(phone)
                        .addGap(99, 99, 99))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ten)
                        .addGap(150, 150, 150)))
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(151, 151, 151))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane1)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(275, Short.MAX_VALUE)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(239, 239, 239)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 928, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(236, 236, 236))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE))
                            .addComponent(jScrollPane2))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(street)
                                .addComponent(phone))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(ten)
                                .addGap(29, 29, 29)))))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchKeyPressed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:

        if (txtSearch.getText().equals("")) {
            JOptionPane.showMessageDialog(this,"Hãy điền mã tài khoản khách hàng");        
        }else{
            GiaodichDAO spdao = new GiaodichDAO();
            dssp=spdao.timtheoma(txtSearch.getText());
            DefaultTableModel dftbl = (DefaultTableModel)table1.getModel();
            dftbl.setRowCount(0);

            for (int i=0;i<dssp.size(); i++) {
                String ma=dssp.get(i).getGd_id();
                String acc_id=dssp.get(i).getAcc_id();
                String toacc_id=dssp.get(i).getToacc_id();
                String type=dssp.get(i).getType();
                String date=dssp.get(i).getDate();
                int amount=dssp.get(i).getAmount();  
                String user_id=dssp.get(i).getUser_id();

               Object[] row = new Object[]{ma, acc_id,toacc_id,type, date, amount, user_id};
               dftbl.addRow(row);
           }
            String acc_id = txtSearch.getText();
            Sodu acc = spdao.sodu1(acc_id);
        if (acc == null) {
            JOptionPane.showMessageDialog(null, "Không tìm thấy mã tài khoản này");
        } else {
            loadAccountCustomer(acc);
        }
        }  
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try{
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.showSaveDialog(this);
            File saveFile = jFileChooser.getSelectedFile();

            if(saveFile != null){
                saveFile = new File(saveFile.toString()+".xlsx");
                Workbook wb = new XSSFWorkbook();
                Sheet sheet = wb.createSheet("Thống Kê Giao Dịch ");

                Row rowCol = sheet.createRow(0);
                for(int i=0;i<table1.getColumnCount();i++){
                    Cell cell = rowCol.createCell(i);
                    cell.setCellValue(table1.getColumnName(i));
                }

                for(int j=0;j<table1.getRowCount();j++){
                    Row row = sheet.createRow(j+1);
                    for(int k=0;k<table1.getColumnCount();k++){
                        Cell cell = row.createCell(k);
                        if(table1.getValueAt(j, k)!=null){
                            cell.setCellValue(table1.getValueAt(j, k).toString());
                        }
                    }
                }
                FileOutputStream out = new FileOutputStream(new File(saveFile.toString()));
                wb.write(out);
                wb.close();
                out.close();
                openFile(saveFile.toString());
            }else{
                JOptionPane.showMessageDialog(null,"Thao Tác In Đã Hủy");
            }
        }catch(FileNotFoundException e){
            System.out.println(e);
        }catch(IOException io){
            System.out.println(io);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        bill_print();
    }//GEN-LAST:event_jButton14ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea bill;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel phone;
    private javax.swing.JLabel street;
    private Swing.table.Table table1;
    private javax.swing.JLabel ten;
    private javax.swing.JFormattedTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
