package org.newoffshore.ui.render;

import org.newoffshore.ui.model.NodeData;
import org.newoffshore.ui.model.NodeType;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;

public class ModernTreeRenderer extends DefaultTreeCellRenderer {
    private final Font bold = new Font("SansSerif", Font.BOLD, 13);
    private final Font normal = new Font("SansSerif", Font.PLAIN, 13);

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded,
                                                  boolean leaf, int row, boolean hasFocus) {
        JLabel c = (JLabel) super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

        DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
        Object uo = node.getUserObject();

        if (uo instanceof NodeData nd) {
            if (nd.type == NodeType.COUNTRY) c.setFont(bold);
            else c.setFont(normal);
        }
        c.setBorder(new EmptyBorder(4, 6, 4, 6));
        return c;
    }
}