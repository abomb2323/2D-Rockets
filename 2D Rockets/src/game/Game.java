package game;

import java.util.ArrayList;
import java.util.Random;

import game.engine.*;
import game.engine.entities.*;

import game.engine.math.*;

public class Game {
	public static void main(String[] args){
		
		//TESTING SHIT//
		Random rand = new Random();
		
		
		GameEngine engine = new GameEngine("2D Rockets", 1024, 768);
		
		System.out.println("Creating and loading bodies...");
		long time = System.nanoTime();
		
//		for(int i = 0; i < 100; i++){
//			CelestialBody body = new CelestialBody(generateString(rand, "abcdefghijklmnopqrstuvwxyz", 8), rand.nextDouble()*Long.MAX_VALUE, rand.nextDouble() * Integer.MAX_VALUE);
//			engine.addCelestialBody(body);
//		}
		
		time = System.nanoTime() - time;
		System.out.println("Done! Took " + (((float)time)/1000000) + "ms");
		
		//System.out.print("Celestial Bodies: " + engine.getCelestialBodyList().size());
		
		//SoundEffect.BACKGROUND.play();
		
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
