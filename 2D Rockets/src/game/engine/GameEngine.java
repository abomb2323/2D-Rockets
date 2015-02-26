package game.engine;
import java.util.ArrayList;

import game.engine.entities.*;

public class GameEngine {
	
	GameScreen gameScreen;
	Window gameWindow;
	
	public GameEngine(String windowName, int screenWidth, int screenHeight){
		
		gameScreen = new GameScreen();
		
		gameWindow = new Window(screenWidth, screenHeight, windowName, gameScreen);
		
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
	
	public void setVisible(boolean visible){
		gameWindow.changeVisibility(visible);
	}
	
}
