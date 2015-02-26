package game.engine;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyEventHandler extends KeyAdapter {
	private KeyEventListener playerKeyListeners;
	
	public KeyEventHandler() {
		super();
		
	}
	
	public void registerKeyListener(KeyEventListener keyListener) {
		playerKeyListeners = keyListener;
	}
	
	public void keyPressed(KeyEvent e) {
		playerKeyListeners.keyPressed(e);
	}
	
	public void keyReleased(KeyEvent e) {
		playerKeyListeners.keyReleased(e);
	}
}