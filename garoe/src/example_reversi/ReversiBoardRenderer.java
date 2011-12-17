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
    private boolean hintEnable = true;
    private Color hintWhite = Color.LIGHT_GRAY;
    private Color hintBlack = Color.BLACK;
    
    public ReversiBoardRenderer() {}
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel newLabel = new JLabel();
        newLabel.setEnabled(true);
        newLabel.setOpaque(false);
        if (((Integer)value) == ReversiToken.WHITE) {
            newLabel.setIcon(new ImageIcon(System.class.getResource("/images/token_white.png")));
            //newLabel.setBackground(Color.WHITE);
        } else if (((Integer)value) == ReversiToken.BLACK) {
            newLabel.setIcon(new ImageIcon(System.class.getResource("/images/token_black.png")));
            //newLabel.setBackground(Color.BLACK);
        } else if (((Integer)value) == 0) {
            newLabel.setEnabled(false);
        } else if ((((Integer)value) == Integer.MAX_VALUE) && hintEnable) {
            newLabel.setOpaque(true);
            newLabel.setBackground(hintWhite);
        } else if ((((Integer)value) == Integer.MIN_VALUE) && hintEnable) {
            newLabel.setOpaque(true);
            newLabel.setBackground(hintBlack);
        }
        return newLabel;
    }
    
    public void enableHint(boolean enable) {
        this.hintEnable = enable;
    }
    
    public void setWhiteHintColor(Color whiteColor) {
        this.hintWhite = whiteColor;
    }
    
    public void setBlackHintColor(Color blackColor) {
        this.hintBlack = blackColor;
    }
    
    public boolean getHint() {
        return this.hintEnable;
    }
    
    public Color getWhiteColor() {
        return this.hintWhite;
    }
    
    public Color getBlackColor() {
        return this.hintBlack;
    }
    
}
