
import processing.core.PApplet;



import java.awt.Point;
import java.util.ArrayList;

import processing.core.PApplet;

/**
 * This class operates as the surface where Player and Obstacles can draw themselves
 * onto the window.
 * @author Siyi Ji, Edward Min, APCS Demos 2021 (screen switching)
 * Last Modified: 5/7/2021
 */

public class DrawingSurface extends PApplet implements ScreenSwitcher {

	public float ratioX, ratioY;
	
	private ArrayList<Integer> keys;
	
	private Screen activeScreen;
	private ArrayList<Screen> screens;

	private Game game;
	
	public DrawingSurface() {
		
		
		screens = new ArrayList<Screen>();
		
		keys = new ArrayList<Integer>();
		
		
		Screen screen1 = new Menu(this);
		screens.add(screen1);
		
		game = new Game(this, 1);
		screens.add(game);
		
		Instruction screen3 = new Instruction(this);
		screens.add(screen3);
		
		LvlSelect screen4 = new LvlSelect(this);
		screens.add(screen4);
		
		Pause screen5 = new Pause(this);
		screens.add(screen5);
		
		EndScreen screen6 = new EndScreen(this);
		screens.add(screen6);
		
		activeScreen = screens.get(0);
		
	}
	
	public void settings() {
		// size(DRAWING_WIDTH, DRAWING_HEIGHT, P2D);
		size(activeScreen.DRAWING_WIDTH, activeScreen.DRAWING_HEIGHT);
	}
	
	public void setup() {
		surface.setResizable(true);
		for (Screen s : screens)
			s.setup();
	}
	
	public void draw() {
		ratioX = (float)width/activeScreen.DRAWING_WIDTH;
		ratioY = (float)height/activeScreen.DRAWING_HEIGHT;

		pushMatrix();
		
		scale(ratioX, ratioY);
		
		activeScreen.draw();
		
		popMatrix();
	}
	
	public void keyPressed() {
		keys.add(keyCode);
	}

	public void keyReleased() {
		while(keys.contains(keyCode))
			keys.remove(new Integer(keyCode));
	}

	public boolean isPressed(Integer code) {
		return keys.contains(code);
	}
	
	public ArrayList<Integer> getKeys(){
		return keys;
	}
	
	public void mousePressed() {
		activeScreen.mousePressed();
	}
	
	public void mouseMoved() {
		activeScreen.mouseMoved();
	}
	
	public void mouseDragged() {
		activeScreen.mouseDragged();
	}
	
	public void mouseReleased() {
		activeScreen.mouseReleased();
	}
	
	public Point assumedCoordinatesToActual(Point assumed) {
		return new Point((int)(assumed.getX()*ratioX), (int)(assumed.getY()*ratioY));
	}

	public Point actualCoordinatesToAssumed(Point actual) {
		return new Point((int)(actual.getX()/ratioX) , (int)(actual.getY()/ratioY));
	}

	public void switchScreen(int i) {
		activeScreen = screens.get(i);
	}
	
	public void changeLevel(int level) {
		screens.remove(game);
		game = new Game(this, level);
		screens.add(1, game);
	}

}

