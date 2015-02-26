package game.engine.entities;

public class OrbitalEntity extends Entity{
	
	//Apoapsis and periapsis, in meters.
	private double apoapsis, periapsis;
	
	//Radius of object, in meters
	private double radius;
	
	//Orbital Height in meters, initially set to 0
	private double orbitHeight = 0;
	
	//Parent body of the object
	private CelestialBody parentBody;
	
	//Mass, in kilograms
	private double mass;
	
	public OrbitalEntity(String name, double mass, double radius){
		super(name);
		this.mass = mass;
	}
	
	public OrbitalEntity(String name, double apoapsis, double periapsis, double mass){
		super(name);
		this.apoapsis = apoapsis;
		this.periapsis = periapsis;
		this.mass = mass;
	}
	
	public OrbitalEntity(String name, double apoapsis, double periapsis, double mass, double radius, CelestialBody parentBody){
		super(name);
		this.apoapsis = apoapsis;
		this.periapsis = periapsis;
		this.mass = mass;
		this.radius = radius;
		this.parentBody = parentBody;
		parentBody.addChild(this);
	}
	
	public double getOrbitalHeight(){
		return orbitHeight;
	}
	
	public void setOrbitalHeight(double newHeight){
		orbitHeight = newHeight;
	}
	
	public double getMass(){
		return mass;
	}
	
	public double getApoapsis(){
		return apoapsis;
	}
	
	public double getPeriapsis(){
		return periapsis;
	}
	
	public double getRadius(){
		return radius;
	}
	
	public CelestialBody getParentBody(){
		return parentBody;
	}
}
