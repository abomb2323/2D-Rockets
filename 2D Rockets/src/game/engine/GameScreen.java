package game.engine;

import game.engine.entities.CelestialBody;

import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;







import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class GameScreen extends JPanel implements ActionListener, KeyEventListener {
	
	private KeyEventHandler keyHandler;
	private Timer timer;
	
	private ArrayList<CelestialBody> celestialBodies;
	
	// Define keys: space
	// 0 - not pressed, 1 - pressed
	private int[] keysPressed = {0};
	
	
	public GameScreen() { 
		
		celestialBodies = new ArrayList<CelestialBody>();
		
		keyHandler = new KeyEventHandler();
		addKeyListener(keyHandler);
		setFocusable(true);
		setDoubleBuffered(true);
		timer = new Timer(5, this);
		timer.start();
	}
	
	public void addCelestialBody(CelestialBody body){
		celestialBodies.add(body);
	}
	
	public CelestialBody getCelestialBody(int index){
		return celestialBodies.get(index);
	}
	
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		
		if(keysPressed[0] == 1){
			SoundEffect.CHING.play();
		}
		
		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, this.getWidth(), this.getHeight());
		
	}

	public void registerKeyListener(KeyEventListener keyListener) {
		keyHandler.registerKeyListener(keyListener);
	}

	public ArrayList<CelestialBody> getCelestialBodyList() {
		return celestialBodies;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
	    // we set the corresponding 'key indicator' to 1 when it is pressed
	    switch(key){
	        case(KeyEvent.VK_SPACE): keysPressed[0] = 1; break; 
	    }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
	    // we set the corresponding 'key indicator' to 1 when it is pressed
	    switch(key){
	        case(KeyEvent.VK_SPACE): keysPressed[0] = 0; break; 
	    }
	}
}

class Window extends JFrame{
	
	JFrame frame;
	
	public Window(int width, int height, String title, JPanel panel){
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.add(panel);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		//frame.setVisible(true);
		frame.setResizable(false);
	}
	
	public void changeVisibility(boolean visible){
		frame.setVisible(visible);
	}
}
