package game.engine.math;

import java.lang.Math;

public class Vector {
	
	private double x, y; //Position
	private double magnitude; //'length'
	private double[] components; //x and y values of the vector 0 == x component 1 == y component
	private double angle; //Measured from x-axis in degrees
	
	//Position, magnitude and angle
	public Vector(double posX, double posY, double mag, double theta){
		x = posX;
		y = posY;
		magnitude = mag;
		angle = theta;
		
		components = new double[2];
		components[0] = magnitude * Math.cos(Math.toRadians(angle));
		components[1] = magnitude * Math.sin(Math.toRadians(angle));
	}
	
	//Position, components and angle
	public Vector(double posX, double posY, double[] components, double theta){
		x = posX;
		y = posY;
		this.components = components;
		magnitude = Math.sqrt(Math.pow(components[0], 2) + Math.pow(components[1], 2));
		angle = theta;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getMagnitude() {
		return magnitude;
	}

	public double[] getComponents() {
		return components;
	}

	public double getAngle() {
		return angle;
	}
	
	
	
}
