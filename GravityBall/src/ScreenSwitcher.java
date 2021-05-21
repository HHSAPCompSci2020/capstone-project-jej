
/**
 * 
 * @author APCS Demos 2021
 *
 */
public interface ScreenSwitcher {
	public static final int MENU = 0;
	public static final int GAME = 1;
	public static final int INSTRUCTION = 2;
	public static final int LVLSELECT = 3;
	public static final int PAUSE = 4;
	public static final int ENDSCREEN = 5;
	
	public void switchScreen(int i);
}
