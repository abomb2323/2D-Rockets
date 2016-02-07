package game.engine.math;

import java.lang.Math;

public class VecMath {
	
	//Adds an array of vectors together
	public static Vector VecAdd(Vector[] vectors, double posX, double posY){
		
		double xComps = 0;
		double yComps = 0;
		
		//Add components up
		for(int i = 0; i < vectors.length; i++){
			xComps += vectors[i].getComponents()[0];
			yComps += vectors[i].getComponents()[1];
		}
		
		double mag = Math.sqrt(Math.pow(xComps, 2) + Math.pow(yComps, 2));
		
		Vector result = new Vector(posX, posY, mag, Math.toDegrees(Math.atan2(yComps, xComps)));
		
		return result;
	}
	
	//Subtracts an array of vectors from each other in the order of the array.
	public static Vector VecSub(Vector[] vectors, double posX, double posY){
		
		double xComps = 0;
		double yComps = 0;
		
		//Add components up
		for(int i = 0; i < vectors.length; i++){
			xComps -= vectors[i].getComponents()[0];
			yComps -= vectors[i].getComponents()[1];
		}
		
		double mag = Math.sqrt(Math.pow(xComps, 2) + Math.pow(yComps, 2));
		
		Vector result = new Vector(posX, posY, mag, Math.toDegrees(Math.atan2(yComps, xComps)));
		
		return result;
	}
	
	//Returns dot product of two vectors
	public static double DotProd(Vector v1, Vector v2){
		double result = ((v1.getComponents()[0]*v2.getComponents()[0]) + (v1.getComponents()[1]*v2.getComponents()[1]));
		
		return result;
	}
	
}
