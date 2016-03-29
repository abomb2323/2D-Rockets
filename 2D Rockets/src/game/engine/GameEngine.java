/**
 * @author Adam Crick
 * @date 9/10/2015
 * @description: This is the game engine, it contains links to all of the entities, graphics, and physics within the game
 * 					It also contains the main game loop, which progresses the game at a prescribed 'tick' to keep the
 * 					physics in check with the graphics.
 */

package game.engine;

import java.util.ArrayList;

import game.engine.entities.*;
import game.engine.graphics.GameScreen;
import game.engine.physics.*;

public class GameEngine {
	
	private static GameScreen gameScreen;
	private static PhysicsWrangler physicsLoop;
	
	private boolean quit = false;
	
	public GameEngine(String windowName, int screenWidth, int screenHeight){
		
		gameScreen = new GameScreen();

		gameLoop();
	}

	//Loop for the game's logic
	public void gameLoop(){
		while(!quit){
			
			
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void addCelestialBody(String name, double mass, double radius){
		gameScreen.addCelestialBody(new CelestialBody(name, mass, radius));
	}
	
	public void addCelestialBody(String name,  double apoapsis, double periapsis, double mass, double radius, CelestialBody parentBody){
		gameScreen.addCelestialBody(new CelestialBody(name,  apoapsis, periapsis, mass, radius, parentBody));
	}
	
	public void addCelestialBody(CelestialBody body){
		gameScreen.addCelestialBody(body);
	}
	
	public CelestialBody getCelestialBody(int index){
		return gameScreen.getCelestialBody(index);
	}
	
	public ArrayList<CelestialBody> getCelestialBodyList(){
		return gameScreen.getCelestialBodyList();
	}
}
