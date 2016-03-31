package game;

import java.util.ArrayList;
import java.util.Random;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import game.engine.*;
import game.engine.entities.*;
import game.engine.math.*;
import game.engine.physics.Force;

public class Game {
	public static void main(String[] args){
		
		System.out.println("Starting game screen on OpenGL " + Display.getVersion() + " on adapter " + Display.getAdapter());
		GameEngine engine = new GameEngine("2D Rockets", 1024, 768);
		
		System.out.println("Creating and loading bodies...");
		long time = System.nanoTime();
		
		Entity test = new Entity("Test", "SQUARE", 300, 200, 10);
		test.addForce(new Force("push", 300, 200, 15, 40));
		test.addForce(new Force("sad", 300, 200, 15, 220));
		engine.addEntity(test);
		
		time = System.nanoTime() - time;
		System.out.println("Done! Took " + (((float)time)/1000000) + "ms");
		
		engine.gameLoop();
		
		//System.out.print("Celestial Bodies: " + engine.getCelestialBodyList().size());
	}
	
	
	
	//FOR TEST USE ONLY!!!//
	public static String generateString(Random rng, String characters, int length){
	    char[] text = new char[length];
	    for (int i = 0; i < length; i++)
	    {
	        text[i] = characters.charAt(rng.nextInt(characters.length()));
	    }
	    return new String(text);
	}
	
	//TEST METHOD, NO REAL USE OTHER THAN TESTING
	public static void printChildBodies(CelestialBody body){
		ArrayList<OrbitalEntity> children = body.getChildBodies();
		System.out.print("[");
		for(int i = 0; i < children.size(); i++){
			if(i < children.size() - 1)
				System.out.print(children.get(i).getName() + ", ");
			else
				System.out.print(children.get(i).getName());
		}
		System.out.print("]\n");
	}
}
