package game.engine.entities;

import java.util.ArrayList;

public class CelestialBody extends OrbitalEntity{
	
	//List of all child bodies
	private ArrayList<OrbitalEntity> childBodies;
	
	//Constructor if has no parent body
	public CelestialBody(String name, double mass, double radius){
		super(name, mass, radius);
		childBodies = new ArrayList<OrbitalEntity>();
	}
	
	//Constructor if has parent body
	public CelestialBody(String name,  double apoapsis, double periapsis, double mass, double radius,CelestialBody parentBody){
		super(name, apoapsis, periapsis, mass, radius, parentBody);
		childBodies = new ArrayList<OrbitalEntity>();
	}
	
	public void addChild(OrbitalEntity child){
		childBodies.add(child);
	}
	
	public ArrayList<OrbitalEntity> getChildBodies(){
		return childBodies;
	}


}
