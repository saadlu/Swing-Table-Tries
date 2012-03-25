import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;


public class MyTablePanel {

	private final Container contentPane;
	
	public Container getContentPane() {
		return contentPane;
	}

	public MyTablePanel(){
		contentPane = new JPanel();
		
		String[] columnNames = {"First Name",
                "Last Name",
                "Sport",
                "# of Years",
                "Vegetarian"};
		
		Object[][] data = {
			    {"Kathy", "Smith",
			     "Snowboarding", new Integer(5), new Boolean(false)},
			    {"", "Doe",
			     "Rowing", new Integer(3), new Boolean(true)},
			    {"", "Black",
			     "Knitting", new Integer(2), new Boolean(false)},
			    {"Jane", "White",
			     "Speed reading", new Integer(20), new Boolean(true)},
			    {"", "Brown",
			     "Pool", new Integer(10), new Boolean(false)}
			};

		JTable table = new JTable(data, columnNames)
		{
			/**
			 * 
			 */
			private static final long serialVersionUID = 6326801159836966300L;

			ColorRenderer my = new ColorRenderer();
			
			public TableCellRenderer getCellRenderer(int row, int column) {
//				if(row<2 && column== 0)
					return my;
//				return super.getCellRenderer(row, column);
			}
		};

		table.setShowGrid(false);
		table.setIntercellSpacing(new Dimension(0,0));
		JScrollPane scrollPane = new JScrollPane(table);
		
		contentPane.add(scrollPane);
		
	}
	
	public class ColorRenderer extends JLabel
	implements TableCellRenderer {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -1698539309940864808L;

		public Component getTableCellRendererComponent(
				JTable table, Object color,
				boolean isSelected, boolean hasFocus,
				int row, int column) {
			if (isSelected) {
			      setForeground(table.getSelectionForeground());
			      setBackground(table.getSelectionBackground());
			    } else {
			      setForeground(table.getForeground());
			      setBackground(table.getBackground());
			    }
			
			setFont(table.getFont());
			setText(" " + color.toString());
			
			// if top row, draw top part of
			// the border, otherwise don't
			int topThickness = row==0 ? 1:0;
			// if not the left most column
			// don't draw left part of the border
			int leftThickness = column!=0?0:1;
			
			setBorder(new TableBorder(topThickness,leftThickness,1,1));
			return this;
		}
	}
}
