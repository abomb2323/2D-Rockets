package game.engine.graphics;

import game.engine.entities.CelestialBody;

import java.util.ArrayList;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.*;
import org.lwjgl.LWJGLException;

import static org.lwjgl.opengl.GL11.*;

public class GameScreen{
	
	private ArrayList<CelestialBody> celestialBodies;
	
	// Define keys: space
	// 0 - not pressed, 1 - pressed
	private int[] keysPressed = {0};
	
	public GameScreen() { 
		
		celestialBodies = new ArrayList<CelestialBody>();
		
	}
	
	public void addCelestialBody(CelestialBody body){
		celestialBodies.add(body);
	}
	
	public CelestialBody getCelestialBody(int index){
		return celestialBodies.get(index);
	}

	public ArrayList<CelestialBody> getCelestialBodyList() {
		return celestialBodies;
	}

}
