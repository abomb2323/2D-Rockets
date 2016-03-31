/**
 * @author Adam Crick
 * @date 9/10/2015
 * @description: This is the game engine, it contains links to all of the entities, graphics, and physics within the game
 * 					It also contains the main game loop, which progresses the game at a prescribed 'tick' to keep the
 * 					physics in check with the graphics.
 */

package game.engine;

import java.util.ArrayList;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import game.engine.entities.*;
import game.engine.graphics.GameScreen;
import game.engine.physics.*;

public class GameEngine {
	
	private static GameScreen gameScreen;
	
	private boolean quit = false;
	
	public GameEngine(String windowName, int screenWidth, int screenHeight){
		
		initGL(windowName, screenWidth, screenHeight);
		
		gameScreen = new GameScreen();
	}

	//Loop for the game's logic
	public void gameLoop(){
		while(!quit){

			for(Entity e : getEntityList()){
				System.out.println("X: " + e.x + ", Y: " + e.y);
				System.out.println("Velo mag: " + e.velo.getMagnitude() + ", Angle: " + e.velo.getAngle());
				System.out.println("Acc mag: " + e.acc.getMagnitude() + ", Angle: " + e.acc.getAngle());
				
				e.tick();
			}
			
			gameScreen.render();
			
			quit = Display.isCloseRequested();
			Display.update();
			Display.sync(60);
			
		}
		
		Display.destroy();
		System.exit(0);
	}
	
	public void initGL(String name, int width, int height){
		try {
            Display.setDisplayMode(new DisplayMode(width,height));
            Display.setTitle(name);
            Display.create();
            Display.setVSyncEnabled(true);
        } catch (LWJGLException e) {
            e.printStackTrace();
            System.exit(1);
        }
 
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glShadeModel(GL11.GL_SMOOTH);        
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glDisable(GL11.GL_LIGHTING);                    
         
        GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);                
        GL11.glClearDepth(1);                                       
         
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
         
        GL11.glViewport(0,0,width,height);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
 
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, width, height, 0, 1, -1);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
	}
	
	public void addEntity(Entity e){
		gameScreen.addEntity(e);
	}
	
	public Entity getEntity(int index){
		return gameScreen.getEntity(index);
	}
	
	public ArrayList<Entity> getEntityList(){
		return gameScreen.getEntityList();
	}
}
