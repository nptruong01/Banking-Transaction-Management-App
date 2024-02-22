/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Component;

import Form.LoginForm;
import java.awt.event.ActionListener;

/**
 *
 * @author MSI-VN
 */
public class Header extends javax.swing.JPanel {

    
    private String dataContructor;
    public Header() {
        initComponents();
        this.lbUserName.setText (LoginForm.dataStatic);
        this.lbRole.setText (LoginForm.dataStatic2);
        this.lbHoten.setText (LoginForm.dataStatic3);
    }

    public void addMenuEvent(ActionListener event) {
        cmdMenu.addActionListener(event);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdMenu = new Swing.Button();
        pic = new Swing.ImageAvatar();
        lbUserName = new javax.swing.JLabel();
        lbRole = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lbHoten = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        cmdMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/menu.png"))); // NOI18N

        pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/3c64c7776b7f4651356a8c5da337693a.jpg"))); // NOI18N

        lbUserName.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbUserName.setForeground(new java.awt.Color(153, 153, 153));
        lbUserName.setText("User Name");

        lbRole.setForeground(new java.awt.Color(153, 153, 153));
        lbRole.setText("Mã nhân viên");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        lbHoten.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbHoten.setForeground(new java.awt.Color(153, 153, 255));
        lbHoten.setText("Họ tên NV");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 328, Short.MAX_VALUE)
                .addComponent(lbHoten)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbUserName)
                    .addComponent(lbRole))
                .addGap(103, 103, 103)
                .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbUserName)
                        .addGap(5, 5, 5)
                        .addComponent(lbRole))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbHoten)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cmdMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                            .addComponent(jSeparator1))))
                .addContainerGap())
            .addComponent(pic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Swing.Button cmdMenu;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbHoten;
    private javax.swing.JLabel lbRole;
    private javax.swing.JLabel lbUserName;
    private Swing.ImageAvatar pic;
    // End of variables declaration//GEN-END:variables
}
