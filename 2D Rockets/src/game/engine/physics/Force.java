package game.engine.physics;

import game.engine.math.Vector;

public class Force extends Vector{
	
	private String name;
	
	public Force(String name, double posX, double posY, double mag, double theta) {
		super(posX, posY, mag, theta);
		this.name = name;		
	}

	public String getName(){
		return name;
	}
	
}
