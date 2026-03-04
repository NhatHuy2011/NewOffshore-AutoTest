package org.newoffshore.ui.render;

import org.newoffshore.ui.model.Status;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class StatusPillRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                   boolean hasFocus, int row, int column) {
        JLabel c = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        c.setHorizontalAlignment(SwingConstants.CENTER);
        c.setFont(c.getFont().deriveFont(Font.BOLD));
        c.setOpaque(true);

        Status s = (value instanceof Status) ? (Status) value : Status.PENDING;
        c.setText(s.name());

        if (!isSelected) {
            switch (s) {
                case PASS -> c.setBackground(new Color(220, 245, 225));
                case FAIL -> c.setBackground(new Color(250, 225, 225));
                case RUNNING -> c.setBackground(new Color(235, 235, 255));
                case PENDING -> c.setBackground(new Color(245, 245, 245));
            }
        }
        c.setBorder(BorderFactory.createEmptyBorder(4, 8, 4, 8));
        return c;
    }
}