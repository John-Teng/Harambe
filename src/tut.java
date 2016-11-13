import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Area;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;


public class tut extends JPanel implements ActionListener {
	Timer tm = new Timer(80,this);
	File imageBackground = new File ("D://Downloads/background.png");
	File imageLeft= new File("D://Downloads/harambe left.png");
	File imageRight= new File("D://Downloads/harambe right.png");
	File imageBaby = new File ("D://Downloads/baby.png");
	File imageDeath = new File ("D://Downloads/death.png");
	
	Image image;
	Image baby;
	Image background;
	Image death;   

	public int x =500,velx=2, y=100;
	Random rand = new Random();
	int a = rand.nextInt(450 - 0 + 1) + 0;
	int b = rand.nextInt(250 - 0 + 1) + 0;
	int counter = 2;
	int vely = 0, acc = 1;


	ArrayList babies = new ArrayList(Arrays.asList(a, a+200));
	ArrayList babbies = new ArrayList(Arrays.asList(-b, -b-30));

	public tut () {
		try {
			imageLeft = new File("D://Downloads/harambe left.png");
			image = ImageIO.read(imageLeft);
			background = ImageIO.read(imageBackground);
			baby = ImageIO.read(imageBaby);
			death = ImageIO.read(imageDeath);

		}
		catch (IOException e){
			System.out.println("File IO Error, picture not loaded");
		}
	}

	public void incrementY() {
		if (tm.isRunning()){
			if (y >= 935) {
				y = 935;
			} else {
				y+=40;
			}
			harambeRight();
			repaint();
		}
	}
	public void decrementY(){
		if (tm.isRunning()){
			if (y <= 30) {
				y = 0;
			} else {
				y-=40;
			}
			harambeLeft();
			repaint();
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		boolean fail = false;
		super.paintComponent(g);
		//g.setColor(Color.red);
		//g.fillRect(y, 525, 120, 100);
		g.drawImage(background,0, 0, null);

		Rectangle h = new Rectangle(y,525,120,100);
		g.drawImage(image, y,500 , null);

		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		String output = "Round " + (counter-1);
		g2.drawString(output,450,20); 
		int size = babies.size();
		int size2 = babies.size();
		for (int q = 0; q < size; q++) {
			//g.fillRect((int) babies.get(q), (int) babbies.get(q),30, 30);
			Rectangle z = new Rectangle ((int) babies.get(q), (int) babbies.get(q),30, 30);
			g.drawImage(baby, (int)babies.get(q), (int)babbies.get(q), null);
			if (testIntersection(h,z)){
				System.out.println("you lose");
				fail = true;
			}
		}
		if (fail){
			tm.stop();
			g.drawImage(death, 220, 180, null);
		}
		else {
			tm.start();
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		vely = vely + acc;

		int size = babies.size();
		for (int q = 0; q < size; q++) {
			babbies.set(q, (int)babbies.get(q)+vely);
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
		repaint();
	}

	public void harambeLeft () {
		try {
			image = ImageIO.read(imageLeft);
		}
		catch(IOException e){
			System.out.println("IO Error, picture could not be loaded");
		}
	}

	public void harambeRight () {
		try {
			image = ImageIO.read(imageRight);
		}
		catch(IOException e){
			System.out.println("IO Error, picture could not be loaded");
		}
	}

	public static boolean testIntersection(Shape shapeA, Shape shapeB) {
		Area areaA = new Area(shapeA);
		areaA.intersect(new Area(shapeB));
		return !areaA.isEmpty();
	}
}
