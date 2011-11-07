package example_floodit;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class BoardRender implements TableCellRenderer {

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
		JLabel nuevoLabel = new JLabel();
		if (value instanceof Object)
		{
			nuevoLabel.setOpaque(true);
			String stringValue = (String) value;
			if (stringValue.compareTo("verde") == 0) {
				nuevoLabel.setBackground(Color.GREEN);
			} else if (stringValue.compareTo("rojo") == 0) {
				nuevoLabel.setBackground(Color.RED);
			} else if (stringValue.compareTo("azul") == 0) {
				nuevoLabel.setBackground(Color.BLUE);
			} else if (stringValue.compareTo("amarillo") == 0) {
				nuevoLabel.setBackground(Color.YELLOW);
			} else if (stringValue.compareTo("celeste") == 0) {
				nuevoLabel.setBackground(Color.CYAN);
			} else if (stringValue.compareTo("rosa") == 0) {
				nuevoLabel.setBackground(Color.PINK);
			}
		}
		nuevoLabel.setVisible(true);
		return nuevoLabel;
	}

}
