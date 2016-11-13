import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import javax.swing.*;

public class Tutorial extends JPanel implements ActionListener {
	Timer tm = new Timer(70, this);
	int counter = 2;
	Random rand = new Random();
	int x = rand.nextInt(450 - 0 + 1) + 0;
	int y = rand.nextInt(250 - 0 + 1) + 0;
	int vely = 0, acc = 1;
	
	// int time = 0;

	ArrayList babies = new ArrayList(Arrays.asList(x, x+200));
	ArrayList babbies = new ArrayList(Arrays.asList(-y, -y-30));
	
//	ArrayList babies2 = new ArrayList(Arrays.asList(300, 600));
//	ArrayList babbies2 = new ArrayList(Arrays.asList(-100, -400));

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.RED);
		// g.fillRect((int)babies.get(0),y,50,30);
		// g.fillRect((int)babies.get(1),y,50,30);
		Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
        String output = "Round " + (counter-1);
        g2.drawString(output,450,20); 
		int size = babies.size();
		int size2 = babies.size();
		for (int q = 0; q < size; q++) {
			g.fillRect((int) babies.get(q), (int) babbies.get(q), 50, 30);
		}
//		for(int q = 0; q < size2;q++){
//			g.fillRect((int) babies2.get(q), (int)babbies2.get(q), 50, 30);
//		}
		tm.start();
	}

	public void actionPerformed(ActionEvent e) {
		vely = vely + acc;

		int size = babies.size();
		for (int q = 0; q < size; q++) {
			babbies.set(q, (int)babbies.get(q)+vely);
//			babbies2.set(q, (int)babbies2.get(q)+vely);
		}
		int asd;
		
		asd = rand.nextInt(counter - 1 + 1) + 1;
		if ((int) Collections.min(babbies) > 700) {
			counter += 1;
			vely=0;
			babies.clear();
			babbies.clear();
			
			int as;

			int asdf;

			for (int w = 0; w < counter; w++) {
				as = rand.nextInt(950 - 0 + 1) + 0;
				asdf = rand.nextInt(1000 + counter*10 - 0 + 1) + 0;
				babbies.add(-asdf);
				babies.add(as);

			}
		}
//		if ((int)Collections.min(babbies2)>700){
//			babies2.clear();
//			babbies2.clear();
//			
//			int as;
//
//			int asdf;
//
//			for (int w = 0; w < asd; w++) {
//				as = rand.nextInt(1000 - 0 + 1) + 0;
//				asdf = rand.nextInt(500 - 0 + 1) + 0;
//				babbies2.add(-asdf);
//				babies2.add(as);
//
//			}
//		}

		// as = rand.nextInt(500-0+1)+0;
		// babies.set(0,as);
		// as = rand.nextInt(500-0+1)+0;
		// babies.set(1,as);
		repaint();
	}

	// time ++;
	/**if (time == 5){
			time = 0;
			babies ++;
		}
		**/


	public static void main(String[] args) {
		Tutorial t = new Tutorial();
		Tutorial y = new Tutorial();
		JFrame jf = new JFrame();
		jf.setTitle("Tutorial");
		jf.setSize(1000, 700);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(t);
	}

	public void babies() {
		Tutorial t = new Tutorial();

	}

}
