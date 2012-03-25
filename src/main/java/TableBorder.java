import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

import javax.swing.border.AbstractBorder;


public class TableBorder extends AbstractBorder {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6337285599488637229L;
	
	private final int topThickness;
	private final int bottomThickness;
	private final int leftThickness;
	private final int rightThickness;
	
	public TableBorder(final int topThickness, final int leftThickness,
			final int bottomThickness, final int rightThickness){

		this.topThickness = topThickness;
		this.leftThickness = leftThickness;
		this.bottomThickness = bottomThickness;
		this.rightThickness = rightThickness;
		
		
		
	}

	/**
	 * 
	 * Paints the border. 
	 * 
	 * Note the following:
	 * 
	 * top-left-corner x, y
	 * top-right-corner x+w-1, y
	 * bottom-left-corner x, y+h-1
	 * bottom-right-corner x+w-1, y+h-1
	 * 
	 * Example
	 *    0 1 2 3 4 
	 * 0  . . . . .
	 * 1  . . . . .
	 * 2  . . . . .
     *
	 * top-left-corner 0, 0
	 * width = 5
	 * height = 3
	 * 
	 * top-right-corner 4, 0
	 * bottom-left-corner 0, 2
	 * bottom-right-corner 4, 2
	 * 
	 * Painting traverses counter clock-wise
	 * e. g.
	 *   top border
	 *   left border
	 *   bottom border
	 *   right border
	 *   
	 * Each border takes up the pixels it can, but
	 * not the pixel drawn already.  
	 */
	
	@Override
	public void paintBorder(Component c, Graphics g, int x, int y, int width,
			int height) {
		
		// top border
		for(int i=0;i<topThickness;i++)
			g.drawLine(x, y+i, x+width-1, y+i);
		
		// left
		for(int i=0;i<leftThickness;i++)
			g.drawLine(x+i, y+topThickness, x+i, y+height-1);
		
		// bottom
		for(int i=0;i<bottomThickness;i++)
			g.drawLine(x+leftThickness, y+height-1-i, x+width-1, y+height-1-i);
		
		// right
		for(int i=0;i<rightThickness;i++)
			g.drawLine(x+width-1-i, y+height-1-bottomThickness, x+width-1-i, y+topThickness);
		
	}

	@Override
	public Insets getBorderInsets(Component c) {
		return new Insets(topThickness, leftThickness, bottomThickness, rightThickness);
	}

	@Override
	public Insets getBorderInsets(Component c, Insets insets) {
		insets.set(topThickness, leftThickness, bottomThickness, rightThickness);
		
		return insets;
	}

	
}
