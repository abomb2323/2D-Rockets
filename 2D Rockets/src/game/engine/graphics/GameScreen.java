package game.engine.graphics;

import game.engine.entities.CelestialBody;
import game.engine.entities.Entity;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.*;
import org.lwjgl.LWJGLException;

import static org.lwjgl.opengl.GL11.*;

public class GameScreen{
	
	private ArrayList<Entity> screenEntities;
	
	public GameScreen() { 
		
		
		screenEntities = new ArrayList<Entity>();
		
	}
	
	public void render(){
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		
		for(Entity entity : screenEntities){
			entity.render();
		}
		
	}
	
	public void addEntity(Entity entity){
		screenEntities.add(entity);
	}
	
	public Entity getEntity(int index){
		return screenEntities.get(index);
	}

	public ArrayList<Entity> getEntityList() {
		return screenEntities;
	}

}
