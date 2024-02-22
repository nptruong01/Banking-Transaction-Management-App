/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Component.Header;
import Component.Menu1;
import Event.EventMenuSelected;
import Event.EventShowPopupMenu;
import Form.AccountForm;
import Form.BranchForm;
import Form.ChuyenTienForm;
import Form.CreateAccountForm;
import Form.CustomerForm1;
import Form.Form_Home;
import Form.KhoaTK;
import Form.MainForm;
import Form.MoKhoaTK;
import Form.NapTienForm;
import Form.RutTienForm;
import Form.ThongKeForm;
import Form.ThongkeForm1;
import Form.ThongkeForm2;
import Form.UserForm;
import Form.XemSoDuForm;
import Swing.MenuItem;
import Swing.PopupMenu;
import Swing.icon.GoogleMaterialDesignIcons;
import Swing.icon.IconFontSwing;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

/**
 *
 * @author MSI-VN
 */
public class Main1 extends javax.swing.JFrame {
    
    private String dataContructor;
    private MigLayout layout;
    private Menu1 menu;
    private Header header;
    private MainForm main;
    private Animator animator;
    
    public Main1() {
        initComponents();
        init();

    }

    private void init() {
        setLocationRelativeTo(null);    //cho ra giữa màn hình
        setExtendedState(JFrame.MAXIMIZED_BOTH);//cho toàn màn hình 
        layout = new MigLayout("fill", "0[]0[100%, fill]0", "0[fill, top]0");
        bg.setLayout(layout);
        menu = new Menu1();
        header = new Header();
        main = new MainForm();
        menu.addEvent(new EventMenuSelected() {
            @Override
            public void menuSelected(int menuIndex, int subMenuIndex) {
                System.out.println("Menu Index : " + menuIndex + " SubMenu Index " + subMenuIndex);
                if (menuIndex == 0) {
                    if (subMenuIndex == -1) {
                        main.showForm(new Form_Home());
                    } 
                }else if (menuIndex == 1) {
                    if (subMenuIndex == 0) {
                        main.showForm(new NapTienForm());
                    } else if (subMenuIndex == 1) {
                        main.showForm(new RutTienForm());
                    }else if (subMenuIndex == 2) {
                        main.showForm(new ChuyenTienForm());
                    }else if (subMenuIndex == 3) {
                        main.showForm(new ThongKeForm());
                    }
                }else if (menuIndex == 2) {
                    if (subMenuIndex == 0) {
                        main.showForm(new ThongkeForm1());
                    } else if (subMenuIndex == 1) {
                        main.showForm(new ThongkeForm2());
                    }
                }else if (menuIndex == 3 ) {
                    if (subMenuIndex == 0) {
                        main.showForm(new CreateAccountForm());
                    }else if (subMenuIndex == 1) {
                        main.showForm(new CustomerForm1());
                    }else if (subMenuIndex == 2) {
                        main.showForm(new XemSoDuForm());
                    }else if (subMenuIndex == 3) {
                        main.showForm(new KhoaTK());
                    }else if (subMenuIndex == 4) {
                        main.showForm(new MoKhoaTK());
                    }  
                }else if (menuIndex == 4 ) {
                    if (subMenuIndex == -1) {
                       System.exit(0);
                    
                    } 
                }
                
            }
        });
        menu.addEventShowPopup(new EventShowPopupMenu() {
            @Override
            public void showPopup(Component com) {
                MenuItem item = (MenuItem) com;
                PopupMenu popup = new PopupMenu(Main1.this, item.getIndex(), item.getEventSelected(), item.getMenu().getSubMenu());
                int x = Main1.this.getX() + 52;
                int y = Main1.this.getY() + com.getY() + 86;
                popup.setLocation(x, y);
                popup.setVisible(true);
            }
        });
        menu.initMenuItem();
        bg.add(menu, "w 230!, spany 2");    // Span Y 2cell
        bg.add(header, "h 75!, wrap");
        bg.add(main, "w 100%, h 100%");
         TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double width;
                if (menu.isShowMenu()) {
                    width = 60 + (170 * (1f - fraction));
                } else {
                    width = 60 + (170 * fraction);
                }
                layout.setComponentConstraints(menu, "w " + width + "!, spany2");
                menu.revalidate();
            }

            @Override
            public void end() {
                menu.setShowMenu(!menu.isShowMenu());
                menu.setEnableMenu(true);
            }
            
        };
        animator = new Animator(500, target);
        animator.setResolution(0);
        animator.setDeceleration(0.5f);
        animator.setAcceleration(0.5f); 
        header.addMenuEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    animator.start();
                }
                menu.setEnableMenu(false);
                if (menu.isShowMenu()) {
                    menu.hideallMenu();
                }
            }
        });
        //  Init google icon font
        IconFontSwing.register(GoogleMaterialDesignIcons.getIconFont());
        //Khoi dong voi Form nay
        main.showForm(new Form_Home());
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PT BANK");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1366, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 783, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Main1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}
