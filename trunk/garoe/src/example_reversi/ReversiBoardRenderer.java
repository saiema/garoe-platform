/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package example_reversi;

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
public class ReversiBoardRenderer extends JLabel implements TableCellRenderer {
    
    public ReversiBoardRenderer() {}
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (((Integer)value) == ReversiToken.WHITE) {
            this.setIcon(new ImageIcon("token_white.png"));
        } else if (((Integer)value) == ReversiToken.BLACK) {
            this.setIcon(new ImageIcon("token_black.png"));
        }
        return this;
    }
    
}
