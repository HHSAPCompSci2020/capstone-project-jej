import java.awt.Point;
import java.awt.Rectangle;
/**
 * 
 * @author Siyi Ji
 *
 */
public class LvlSelect extends Screen 
{
	private DrawingSurface surface;
	private Rectangle back,lvl1,lvl2,lvl3,lvl4,lvl5,lvl6,lvl7, lvl8;
	public LvlSelect(DrawingSurface surface) {
		super(800,600);
		this.surface = surface;
		back = new Rectangle(0,550,100,50);
		lvl1 = new Rectangle(100,200,50,50);
		lvl2 = new Rectangle(200,200,50,50);
		lvl3 = new Rectangle(300,200,50,50);
		lvl4 = new Rectangle(400,200,50,50);
		lvl5 = new Rectangle(500,200,50,50);
		lvl6 = new Rectangle(600,200,50,50);
		lvl7 = new Rectangle(300,300,50,50);
		lvl8 = new Rectangle(400,300,50,50);
	}
	
	public void draw() {
		surface.pushStyle();
		
		surface.background(255,255,255);
		surface.fill(255);
		surface.rect(back.x, back.y, back.width, back.height, 10, 10, 10, 10);
		surface.fill(0);
		surface.text("Select Your Level",50,50,100,30);
		String str = "back";
		float w = surface.textWidth(str);
		surface.text(str, back.x+back.width/2-w/2, back.y+back.height/2);
		surface.fill(255);
		surface.rect(lvl1.x, lvl1.y, lvl1.width, lvl1.height, 10, 10, 10, 10);
		surface.fill(0);
		str = "1";
		w = surface.textWidth(str);
		surface.text(str, lvl1.x+lvl1.width/2-w/2, lvl1.y+lvl1.height/2);
		surface.fill(255);
		surface.rect(lvl2.x, lvl2.y, lvl2.width, lvl2.height, 10, 10, 10, 10);
		surface.fill(0);
		str = "2";
		w = surface.textWidth(str);
		surface.text(str, lvl2.x+lvl2.width/2-w/2, lvl2.y+lvl2.height/2);
		surface.fill(255);
		surface.rect(lvl3.x, lvl3.y, lvl3.width, lvl3.height, 10, 10, 10, 10);
		surface.fill(0);
		str = "3";
		w = surface.textWidth(str);
		surface.text(str, lvl3.x+lvl3.width/2-w/2, lvl3.y+lvl3.height/2);
		surface.fill(255);
		surface.rect(lvl4.x, lvl4.y, lvl4.width, lvl4.height, 10, 10, 10, 10);
		surface.fill(0);
		str = "4";
		w = surface.textWidth(str);
		surface.text(str, lvl4.x+lvl4.width/2-w/2, lvl4.y+lvl4.height/2);
		surface.fill(255);
		surface.rect(lvl5.x, lvl5.y, lvl5.width, lvl5.height, 10, 10, 10, 10);
		surface.fill(0);
		str = "5";
		w = surface.textWidth(str);
		surface.text(str, lvl5.x+lvl5.width/2-w/2, lvl5.y+lvl5.height/2);
		surface.fill(255);
		surface.rect(lvl6.x, lvl6.y, lvl6.width, lvl6.height, 10, 10, 10, 10);
		surface.fill(0);
		str = "6";
		w = surface.textWidth(str);
		surface.text(str, lvl6.x+lvl6.width/2-w/2, lvl6.y+lvl6.height/2);
		surface.fill(255);
		surface.rect(lvl7.x, lvl7.y, lvl7.width, lvl7.height, 10, 10, 10, 10);
		surface.fill(0);
		str = "7";
		w = surface.textWidth(str);
		surface.text(str, lvl7.x+lvl7.width/2-w/2, lvl7.y+lvl7.height/2);
		surface.fill(255);
		surface.rect(lvl8.x, lvl8.y, lvl8.width, lvl8.height, 10, 10, 10, 10);
		surface.fill(0);
		str = "8";
		w = surface.textWidth(str);
		surface.text(str, lvl8.x+lvl8.width/2-w/2, lvl8.y+lvl8.height/2);
		
		
		
		
		surface.popStyle();
	}
	
	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
		if (back.contains(p))
			surface.switchScreen(ScreenSwitcher.MENU);
		else if(lvl1.contains(p))
			surface.switchScreen(ScreenSwitcher.GAME);
		else if(lvl2.contains(p))
			surface.switchScreen(ScreenSwitcher.GAME);
		else if(lvl3.contains(p))
			surface.switchScreen(ScreenSwitcher.GAME);
		else if(lvl4.contains(p))
			surface.switchScreen(ScreenSwitcher.GAME);
		else if(lvl5.contains(p))
			surface.switchScreen(ScreenSwitcher.GAME);
		else if(lvl6.contains(p))
			surface.switchScreen(ScreenSwitcher.GAME);
		else if(lvl7.contains(p))
			surface.switchScreen(ScreenSwitcher.GAME);
		else if(lvl8.contains(p))
			surface.switchScreen(ScreenSwitcher.GAME);
		
	}
}
