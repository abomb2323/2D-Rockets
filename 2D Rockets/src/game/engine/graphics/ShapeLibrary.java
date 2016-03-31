package game.engine.graphics;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.*;

public class ShapeLibrary {
	
	public static void drawSquare(double x, double y, double width, double height, ReadableColor color){
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glColor3f(color.getRed(), color.getGreen(), color.getBlue());
			GL11.glVertex2d(x, y); //Bottom Left
			GL11.glVertex2d(x, height + y); //Top Left
			GL11.glVertex2d(width + x, height + y); //Top Right
			GL11.glVertex2d(width + x, y); //Bottom Right
		GL11.glEnd();
	}
}
