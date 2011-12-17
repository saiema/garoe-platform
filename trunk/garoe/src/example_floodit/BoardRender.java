package example_floodit;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 * Renderizador de la tabla utilizada en la interfaz gráfica del Floodit
 * @author Carla Noelia Fiori, Simón Emmanuel Gutiérrez Brida
 * @version 0.1
 */
public class BoardRender implements TableCellRenderer {

    /**
     * Retorna un componente para la tabla (renderiza una celda)
     * @param table : la tabla sobre la cual opera el render : {@code JTable}
     * @param value : el valor de la celda que se está renderizando : {@code Object}
     * @param isSelected : la celda está seleccionada? : {@code boolean}
     * @param hasFocus : la celda tiene foco? : {@code boolean}
     * @param row : la fila de la celda renderizada : {@code int}
     * @param col : la columna de la celda renderizada : {@code int}
     * @return un componente que representa a la celda renderizada : {@code Component}
     */
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
