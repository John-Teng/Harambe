
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class frame extends JFrame implements KeyListener{
	public tut t;
	
	public frame (tut t) {
		addKeyListener(this);
		this.t = t;
	}
	

	@Override
	public void keyPressed(KeyEvent e) {
	    
		int keyCode = e.getKeyCode();
	    switch( keyCode ) { 
	        case KeyEvent.VK_UP:
	            // handle up 
	        	System.out.println("up");
	            break;
	        case KeyEvent.VK_DOWN:
	            // handle down 
	        	System.out.println("down");
	            break;
	        case KeyEvent.VK_LEFT:
	            // handle left
	        	System.out.println("left");
	        	t.decrementY();
	            break;
	        case KeyEvent.VK_RIGHT :
	            // handle right
	        	System.out.println("right");
	        	t.incrementY();
	            break;
	     }
	     
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
