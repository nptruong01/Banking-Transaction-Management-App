package com.raven.suportSwing;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class TableColumn extends JTable {

    public TableColumn() {
        setBackground(new Color(245, 245, 245));
        setRowHeight(40);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setFont(new Font("SansSerif", Font.BOLD, 18)); // Thay đổi kích cỡ font chữ tại đây
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                Component c = super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
                c.setFont(c.getFont().deriveFont(Font.BOLD)); // in đậm font chữ
                return c;
//                return new TableCell(o);
            }
        });
    }

//    @Override
//    public Component prepareRenderer(TableCellRenderer tcr, int i, int i1) {
//        TableCell.CellType celLType = TableCell.CellType.CENTER;
//        if (i1 == 0) {
//            celLType = TableCell.CellType.LEFT;
//        } else if (i1 == getColumnCount() - 1) {
//            celLType = TableCell.CellType.RIGHT;
//        }
//        return new TableCell(getValueAt(i, i1), isCellSelected(i, i1), celLType);
//    }
        @Override
    public Component prepareRenderer(TableCellRenderer tcr, int i, int i1) {
        TableCell.CellType celLType = TableCell.CellType.CENTER;
        if (i1 == 0) {
            celLType = TableCell.CellType.LEFT;
        } else if (i1 == getColumnCount() - 1) {
            celLType = TableCell.CellType.RIGHT;
        }
        Component c = super.prepareRenderer(tcr, i, i1);
        c.setFont(c.getFont().deriveFont(Font.PLAIN)); // Khôi phục font chữ
        return new TableCell(getValueAt(i, i1), isCellSelected(i, i1), celLType);
    }
}
