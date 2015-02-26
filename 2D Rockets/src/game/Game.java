package game;

import java.util.ArrayList;
import game.engine.*;
import game.engine.entities.*;

public class Game {
	public static void main(String[] args){
		CelestialBody Kerbol = new CelestialBody("Kerbol", 1.7565670E28d, 261600000d);
		CelestialBody Kerbin = new CelestialBody("Kerbin",  13599840256d, 13599840256d, 5.2915793E22d, 600000d, Kerbol);
		CelestialBody Mun = new CelestialBody("Mun",  12000000d, 12000000d, 9.7600236E20d, 200000d, Kerbin);
		CelestialBody Minmus = new CelestialBody("Minmus",  47000000d, 47000000d, 2.6457897E19d, 60000d, Kerbin);
		
		Kerbin.setOrbitalHeight(Kerbin.getApoapsis());
		Mun.setOrbitalHeight(Mun.getApoapsis());
		Minmus.setOrbitalHeight(Minmus.getApoapsis());

		System.out.println(PhysicsLibrary.getGravityForce(Kerbol));
		System.out.println(PhysicsLibrary.getGravityForce(Kerbin));
		System.out.println(PhysicsLibrary.getGravityForce(Mun));
		System.out.println(PhysicsLibrary.getGravityForce(Minmus));
		
		printChildBodies(Kerbin);
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
