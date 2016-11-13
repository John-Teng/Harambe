import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int HEIGHT = 700, WIDTH = 1000;
		tut t = new tut();
		frame f = new frame(t);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);
		f.setSize(WIDTH,HEIGHT);
		f.setTitle("Harambe Simulator");
		f.setVisible(true);
		f.add(t);
	}
	
	
	
	
}
