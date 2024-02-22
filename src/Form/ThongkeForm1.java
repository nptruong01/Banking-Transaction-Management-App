/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import DAO.ThongkeDAO;
import com.raven.chart.ModelChart;
import java.awt.Color;
import java.util.List;

/**
 *
 * @author MSI-VN
 */
public class ThongkeForm1 extends javax.swing.JPanel {
ThongkeDAO tkdao = new ThongkeDAO();
    /**
     * Creates new form ThongkeUI
     */
    public ThongkeForm1() {
        initComponents();
        setOpaque(false);
//        gaugeChart1.setValueWithAnimation(75);
//        gaugeChart2.setValueWithAnimation(90);
//        gaugeChart3.setValueWithAnimation(45);
        init();
    }

    private void init() {
        chart1.addLegend("Nạp tiền", new Color(12, 84, 175), new Color(0, 108, 247));
        chart1.addLegend("Rút tiền", new Color(5, 125, 0), new Color(95, 209, 69));
        chart1.addLegend("Chuyển tiền", new Color(186, 37, 37), new Color(241, 100, 120));
        try {
            List<ModelChart> data = tkdao.loadbieudocot();
            for (int i = data.size() - 1; i >= 0; i--) {
                chart1.addData(data.get(i));
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        chart1.start();
//        barChart.addLegend("Qty Sold", new Color(12, 84, 175), new Color(0, 108, 247));
//        try {
//            List<ModelChart> data = tkdao.loadbieudoduong();
//            for (int i = data.size() - 1; i >= 0; i--) {
//                barChart.addData(data.get(i));
//            }
//        } catch (Exception e) {
//            System.err.println(e);
//        }
//        barChart.start();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel2 = new Swing.RoundPanel();
        chart1 = new com.raven.chart.Chart();

        roundPanel2.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 666, Short.MAX_VALUE)
            .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(roundPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(chart1, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 422, Short.MAX_VALUE)
            .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(roundPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(chart1, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.chart.Chart chart1;
    private Swing.RoundPanel roundPanel2;
    // End of variables declaration//GEN-END:variables
}
