package Form;

import DAO.CountDAO;
import DAO.GiaodichDAO;
import DAO.XacthucDAO;
import Dialog.Message;
import Main.Main;
import Model.Giaodich;
import Model.ModelCard;
//import Model.ModelStudent;
import Swing.icon.GoogleMaterialDesignIcons;
import Swing.icon.IconFontSwing;
import Swing.noticeboard.ModelNoticeBoard;
//import Swing.table.EventAction;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MSI-VN
 */
public class Form_Home extends javax.swing.JPanel {

    ArrayList<Giaodich> dssp;
    int row;
    
    private JList<String> transactionList;
    private DefaultListModel<String> listModel;
    
    public Form_Home() {
        initComponents();
//        table1.fixTable(jScrollPane1);
        setOpaque(false);
        initData();
        loadTable();
        loadthongbao();
    }
    private void initData() {
        initCardData();
//        initNoticeBoard();
//        initTableData();
    }
    CountDAO sDao = new CountDAO();
    
    private void loadTable(){
        GiaodichDAO spdao = new GiaodichDAO();
       dssp= spdao.docdanhsachgiaodich();
         DefaultTableModel dftbl = (DefaultTableModel)table1.getModel();
         dftbl.setRowCount(0);
         
         for(int i=0;i<dssp.size(); i++)
                  
         {
         String ma=dssp.get(i).getGd_id();
         String acc_id=dssp.get(i).getAcc_id();
         String toacc_id=dssp.get(i).getToacc_id();
         int amount=dssp.get(i).getAmount();
         String type=dssp.get(i).getType();
         


         Object[] row= new Object[]{ma, acc_id,toacc_id, amount,type};
         dftbl.addRow(row);
         }       
    }
//    public void loadTransactions(ArrayList<String> transactions) {
//        transactionList.setListData(transactions.toArray(new String[0]));
//    }
       private void loadthongbao(){
           
            XacthucDAO xacthucDAO = new XacthucDAO();
            ArrayList<String> transactions = xacthucDAO.getTransactions();

            DefaultListModel<String> listModel = new DefaultListModel<>();
            jList1.setModel(listModel);

            for (String transaction : transactions) {
                listModel.addElement(transaction);
            }

            jList1.setVisible(true);
        }
    
//    private void initTableData() {
//        EventAction eventAction = new EventAction() {
//            @Override
//            public void delete(ModelStudent student) {
////                if (showMessage("Delete Student : " + student.getName())) {
////                    System.out.println("User click OK");
////                } else {
////                    System.out.println("User click Cancel");
////                }
//                showMessage("Delete Student : " + student.getName());
//            }
//
//            @Override
//            public void update(ModelStudent student) {
////                if (showMessage("Update Student : " + student.getName())) {
////                    System.out.println("User click OK");
////                } else {
////                    System.out.println("User click Cancel");
////                }
//                showMessage("Update Student : " + student.getName());
//            }
////
////            @Override
////            public void delete(ModelStudent student) {
////                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
////            }
////
////            @Override
////            public void update(ModelStudent student) {
////                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
////            }
//        };
////        table1.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/Icon/profile.jpg")), "Jonh", "Male", "Java", 300).toRowTable(eventAction));
////        table1.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/Icon/profile1.jpg")), "Dara", "Male", "C++", 300).toRowTable(eventAction));
////        table1.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/Icon/profile2.jpg")), "Bora", "Male", "C#", 300).toRowTable(eventAction));
////        table1.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/Icon/profile2.jpg")), "Bora", "Male", "C#", 300).toRowTable(eventAction));
////        table1.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/Icon/profile2.jpg")), "Bora", "Male", "C#", 300).toRowTable(eventAction));
////        table1.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/Icon/profile2.jpg")), "Bora", "Male", "C#", 300).toRowTable(eventAction));
////        table1.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/Icon/profile2.jpg")), "Bora", "Male", "C#", 300).toRowTable(eventAction));
////        table1.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/Icon/profile2.jpg")), "Bora", "Male", "C#", 300).toRowTable(eventAction));
////        table1.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/Icon/profile2.jpg")), "Bora", "Male", "C#", 300).toRowTable(eventAction));
////        table1.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/Icon/profile2.jpg")), "Bora", "Male", "C#", 300).toRowTable(eventAction));
////        table1.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/Icon/profile2.jpg")), "Bora", "Male", "C#", 300).toRowTable(eventAction));
////        table1.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/Icon/profile2.jpg")), "Bora", "Male", "C#", 300).toRowTable(eventAction));
////        table1.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/Icon/profile2.jpg")), "Bora", "Male", "C#", 300).toRowTable(eventAction));
//    }

    private void initCardData() {
        Icon icon1 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.PEOPLE, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 15));
        card1.setData(new ModelCard("Tổng số tài khoản", sDao.demtk(), 20, icon1));
        Icon icon2 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.MONETIZATION_ON, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 15));
        card2.setData(new ModelCard("Tổng số giao dịch", sDao.demgd(), 60, icon2));
        Icon icon3 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.BUSINESS, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 15));
        card3.setData(new ModelCard("Số chi nhánh", sDao.demcn(), 80, icon3));
        Icon icon4 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.BUSINESS_CENTER, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 15));
        card4.setData(new ModelCard("Tổng số nhân viên", sDao.demnv(), 95, icon4));
    }
//    private void initNoticeBoard() {
//        noticeBoard.addDate("04/10/2021");
//        noticeBoard.addNoticeBoard(new ModelNoticeBoard(new Color(94, 49, 238), "Hidemode", "Now", "Sets the hide mode for the component. If the hide mode has been specified in the This hide mode can be overridden by the component constraint."));
//        noticeBoard.addNoticeBoard(new ModelNoticeBoard(new Color(218, 49, 238), "Tag", "2h ago", "Tags the component with metadata name that can be used by the layout engine. The tag can be used to explain for the layout manager what the components is showing, such as an OK or Cancel button."));
//        noticeBoard.addDate("03/10/2021");
//        noticeBoard.addNoticeBoard(new ModelNoticeBoard(new Color(32, 171, 43), "Further Reading", "12:30 PM", "There are more information to digest regarding MigLayout. The resources are all available at www.migcomponents.com"));
//        noticeBoard.addNoticeBoard(new ModelNoticeBoard(new Color(50, 93, 215), "Span", "10:30 AM", "Spans the current cell (merges) over a number of cells. Practically this means that this cell and the count number of cells will be treated as one cell and the component can use the space that all these cells have."));
//        noticeBoard.addNoticeBoard(new ModelNoticeBoard(new Color(27, 188, 204), "Skip ", "9:00 AM", "Skips a number of cells in the flow. This is used to jump over a number of cells before the next free cell is looked for. The skipping is done before this component is put in a cell and thus this cells is affected by it. \"count\" defaults to 1 if not specified."));
//        noticeBoard.addNoticeBoard(new ModelNoticeBoard(new Color(238, 46, 57), "Push", "7:15 AM", "Makes the row and/or column that the component is residing in grow with \"weight\". This can be used instead of having a \"grow\" keyword in the column/row constraints."));
//        noticeBoard.scrollToTop();
//    }
    private boolean showMessage(String message) {
        Message obj = new Message(Main.getFrames()[0], true);
        obj.showMessage(message);
        return obj.isOk();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        card1 = new Component.Card();
        jLabel1 = new javax.swing.JLabel();
        card2 = new Component.Card();
        card3 = new Component.Card();
        card4 = new Component.Card();
        jPanel1 = new javax.swing.JPanel();
        button1 = new Swing.Button();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new Swing.table.Table();

        setBackground(new java.awt.Color(255, 255, 255));

        card1.setBackground(new java.awt.Color(69, 104, 220));
        card1.setColorGradient(new java.awt.Color(176, 106, 179));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Dashboard/Home");

        card2.setBackground(new java.awt.Color(204, 43, 94));
        card2.setColorGradient(new java.awt.Color(117, 58, 136));

        card3.setBackground(new java.awt.Color(33, 150, 243));
        card3.setColorGradient(new java.awt.Color(76, 175, 80));

        card4.setBackground(new java.awt.Color(255, 153, 102));
        card4.setToolTipText("");
        card4.setColorGradient(new java.awt.Color(255, 94, 98));

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        button1.setBackground(new java.awt.Color(51, 51, 51));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("Reset");
        button1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Lịch sử giao dịch");
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jLabel4.setOpaque(true);

        jList1.setBackground(new java.awt.Color(51, 51, 51));
        jList1.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jList1.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(jList1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(529, 529, 529)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                .addGap(27, 27, 27))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel5.setText("Giao dịch gần đây");
        jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã giao dịch", "Mã tài khoản", "Mã tài khoản nhận", "Số tiền", "Phương thức"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jScrollPane1.setViewportView(table1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(396, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1)
                .addGap(31, 31, 31))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(card1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(card2, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(card3, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(card4, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
        loadTable();
        loadthongbao();
    }//GEN-LAST:event_button1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Swing.Button button1;
    private Component.Card card1;
    private Component.Card card2;
    private Component.Card card3;
    private Component.Card card4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private Swing.table.Table table1;
    // End of variables declaration//GEN-END:variables
}
