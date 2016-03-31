package game.engine.entities;

import java.util.ArrayList;

import game.engine.graphics.ShapeLibrary;
import game.engine.math.VecMath;
import game.engine.math.Vector;
import game.engine.physics.Force;

import org.lwjgl.util.Color;

public class Entity {
	
	private String name;
	private String shape;
	
	public double x, y; //x and y pos
	private double mass; //Mass in kg
	public Vector velo;
	public Vector acc;
	
	private ArrayList<Force> forces;
	
	public Entity(String name, String shape, double x, double y, double mass){
		this.x = x;
		this.y = y;
		
		this.mass = mass;
		this.name = name;
		this.shape = shape;
		
		forces = new ArrayList<Force>();
		
		velo = new Vector(x, y, 0, 0);
		acc = new Vector(x, y, 0, 0);
		
	}
	
	public Entity(String name) {
		this.name = name;
	}
	
	public void tick(){ //Physics Tick
		Force[] forceVectors = new Force[forces.size()];
		for(int i = 0; i < forces.size(); i++){
			forceVectors[i] = forces.get(i);
		}
		
		Vector forceResultant = VecMath.VecAdd(forceVectors, x, y);
		acc.setAngle(forceResultant.getAngle());
		acc.setMagnitude((forceResultant.getMagnitude()/mass));
		acc.setX(x);
		acc.setY(y);
		
		Vector[] angleHelp = {acc, velo};
		Vector angleFind = VecMath.VecAdd(angleHelp, x, y);
		velo.setAngle(angleFind.getAngle());
		velo.setX(x);
		velo.setY(y);
		velo.setMagnitude(velo.getMagnitude() + (acc.getMagnitude()/60));
		
		x += velo.getComponents()[0];
		y += velo.getComponents()[1];
	}
	
	public void render(){
		ShapeLibrary.drawSquare(x, y, 50d, 50d, Color.BLUE);
	}
	public String getShape(){
		return shape;
	}
	
	public String getName(){
		return name;
	}
	
	public double getMass(){
		return mass;
	}
	
	//Add force to the list, if it finds a force with
	//the same name, it overrides it
	public void addForce(Force f){ 
		for(Force force : forces){
			if(force.getName() == f.getName()){
				force = f;
				return;
			} 
		}
		forces.add(f);
	}
	
	public void delForce(String name){
		for(Force f : forces){
			if(f.getName() == name){
				forces.remove(f);
			}
		}
	}
	
	public ArrayList<Force> getForces(){
		return forces;
	}
}
