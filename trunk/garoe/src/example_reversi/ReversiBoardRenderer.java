/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package example_reversi;

import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author BigEma
 */
@SuppressWarnings("serial")
public class ReversiBoardRenderer implements TableCellRenderer {
    
    public ReversiBoardRenderer() {}
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel newLabel = new JLabel();
        newLabel.setEnabled(true);
        newLabel.setOpaque(false);
        if (((Integer)value) == ReversiToken.WHITE) {
            newLabel.setIcon(new ImageIcon("token_white.png"));
            //newLabel.setBackground(Color.WHITE);
        } else if (((Integer)value) == ReversiToken.BLACK) {
            newLabel.setIcon(new ImageIcon("token_black.png"));
            //newLabel.setBackground(Color.BLACK);
        } else if (((Integer)value) == 0) {
            newLabel.setEnabled(false);
        }
        return newLabel;
    }
    
}
