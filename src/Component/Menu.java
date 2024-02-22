/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Component;

import Event.EventMenu;
import Event.EventMenuSelected;
import Event.EventShowPopupMenu;
import Model.ModelMenu;
import Scrollbar.ScrollBarCustom;
import Swing.MenuAnimation;
import Swing.MenuItem;
import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author MSI-VN
 */
public class Menu extends javax.swing.JPanel {

    public boolean isShowMenu() {
        return showMenu;
    }

    public void addEvent(EventMenuSelected event) {
        this.event = event;
    }

    public void setEnableMenu(boolean enableMenu) {
        this.enableMenu = enableMenu;
    }

    public void setShowMenu(boolean showMenu) {
        this.showMenu = showMenu;
    }

    public void addEventShowPopup(EventShowPopupMenu eventShowPopup) {
        this.eventShowPopup = eventShowPopup;
    }

    private final MigLayout layout;
    private EventMenuSelected event;
    private EventShowPopupMenu eventShowPopup;
    private boolean enableMenu = true;
    private boolean showMenu = true;
    
    public Menu() {
        initComponents();
        setOpaque(false);
        sp.getViewport().setOpaque(false);
        sp.setVerticalScrollBar(new ScrollBarCustom());
        layout = new MigLayout("wrap, fillx, insets 0", "[fill]", "[]0[]");
        panel.setLayout(layout);
    }

    public void initMenuItem() {
//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/Icon/1.png")), "Dashboard", "Home", "Buttons", "Cards", "Tabs", "Accordions", "Modals"));
//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/Icon/2.png")), "Charts", "Morris", "Flot", "Line"));
//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/Icon/3.png")), "Report", "Income", "Expense", "Profit"));
//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/Icon/4.png")), "Message", "Sender", "Inbox", "User"));
//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/Icon/5.png")), "Staff", "Sender", "Inbox", "User"));
//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/Icon/6.png")), "Student", "Menu 001", "Menu 002", "Menu 003"));
//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/Icon/7.png")), "Library", "Menu 001", "Menu 002", "Menu 003"));
//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/Icon/8.png")), "Holiday", "Menu 001", "Menu 002", "Menu 003"));
//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/Icon/9.png")), "Calendar", "Menu 001", "Menu 002", "Menu 003"));
//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/Icon/10.png")), "Chat App", "Menu 001", "Menu 002", "Menu 003"));
//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/Icon/11.png")), "Contace", "Menu 001", "Menu 002", "Menu 003"));
//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/Icon/12.png")), "File Manager", "Menu 001", "Menu 002", "Menu 003"));
//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/Icon/13.png")), "Our Centres"));
//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/Icon/14.png")), "Gallery"));
        
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/Icon/1.png")), "Trang chủ"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/Icon/4.png")), "Giao dịch", "Nạp tiền", "Rút tiền", "Chuyển tiền", "Thống kê giao dịch"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/Icon/3.png")), "Thống kê", "Thông kê doanh thu", "Thống kê doanh số"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/Icon/11.png")), "Khách hàng", "Tạo tài khoản", "Quản lý thông tin KH", "Xem số dư", "Khóa tài khoản", "Mở khóa tài khoản"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/Icon/5.png")), "Admin", "Quản lý User", "Quản lý chi nhánh", "Thống kê GD nhân viên"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/Icon/ExitAccount.png")), "Đăng xuất"));
    }

    private void addMenu(ModelMenu menu) {
        panel.add(new MenuItem(menu, getEventMenu(), event, panel.getComponentCount()), "h 40!");
    }

    private EventMenu getEventMenu() {
        return new EventMenu() {
            @Override
            public boolean menuPressed(Component com, boolean open) {
                if (enableMenu) {
                    if (isShowMenu()) {
                        if (open) {
                            new MenuAnimation(layout, com).openMenu();
                        } else {
                            new MenuAnimation(layout, com).closeMenu();
                        }
                        return true;
                    } else {
                        eventShowPopup.showPopup(com);
                    }
                }
                return false;
            }
        };
    }
    
    public void hideallMenu() {
        for (Component com : panel.getComponents()) {
            MenuItem item = (MenuItem) com;
            if (item.isOpen()) {
                new MenuAnimation(layout, com, 500).closeMenu();
                item.setOpen(false);
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        profile1 = new com.raven.component.Profile();

        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        panel.setOpaque(false);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 312, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 624, Short.MAX_VALUE)
        );

        sp.setViewportView(panel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(profile1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(profile1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

     @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gra = new GradientPaint(0, 0, new Color(33, 105, 249), getWidth(), 0, new Color(93, 58, 196));
        g2.setPaint(gra);
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(grphcs);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panel;
    private com.raven.component.Profile profile1;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
