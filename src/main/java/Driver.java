import javax.swing.JFrame;


public class Driver {

	public static void main(String [] args){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(new MyTablePanel().getContentPane());
		
		frame.pack();
		frame.setVisible(true);
	}
}
