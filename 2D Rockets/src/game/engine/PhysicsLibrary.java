package game.engine;

import game.engine.entities.*;
import java.lang.Math;

public class PhysicsLibrary {
	private static final double G = 6.67384E-11;
	
	public static double getSemiMajorAxis(OrbitalEntity entity){
		return ((entity.getApoapsis() + entity.getParentBody().getRadius()) + (entity.getPeriapsis()+ entity.getParentBody().getRadius()))/2;
	}
	
	private static double mu(double bodyMass){
		return bodyMass * G;
	}
	
	public static double getGravityForce(OrbitalEntity entity){
		return mu(entity.getMass())/ Math.pow(entity.getRadius(), 2);
	}
	
	//Returns in units of m/s
	public static double getOrbitalSpeed(OrbitalEntity entity){
		
		double orbitHeight = entity.getOrbitalHeight() + entity.getParentBody().getRadius();
		
		double a = getSemiMajorAxis(entity);
		
		return Math.sqrt(mu(entity.getParentBody().getMass()) * ((2/orbitHeight) - (1/a)));
	}
}
