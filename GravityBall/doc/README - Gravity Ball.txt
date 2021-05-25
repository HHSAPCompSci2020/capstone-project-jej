Gravity Ball
Authors: Edward Min, Jensen Guo, Siyi Ji
Revision: 5/24/2021

Link to Original Doc: https://docs.google.com/document/d/18N2SgU-5RDY1ZOPMlr5_WQEQ1Pk_svD00E8BIeNY-UY/

Introduction: 
The program initiates a game where you need to direct a ball around obstacles. It controls not using immediate controls, but it moves around by manipulating the gravity impacting the ball. This program mainly attempts to entertain players. Although not implemented, the intended story is that you are a lost soul, and you are trying to get to the spirit world. In order to do this, you must collect spirit orbs, which is the goal in each level. The player uses the arrow keys to change the acceleration which acts on the Player and reach the end goal. People who enjoy playing games, especially those who prefer movement based games, would want to use this program. Changing the gravity impacted on the player is the main mechanic, along with a very complex physics engine.


Instructions:
        Upon starting the program, a menu screen pops up. The user can click on the button labeled “Play” to access the level select or click on the button labeled “How to Play” for basic instructions. When in the level select, the player can choose which level to enter (though level 1 is highly suggested for new users). When in the level, the player can use arrow keys to manipulate the acceleration which acts upon the player. The player can also combine different arrow keys in order to achieve different directions.


Features List (THE ONLY SECTION THAT CANNOT CHANGE LATER):
Key: Black is finished, Red is unfinished.
Must-have Features:
* Main Game Mechanics
   * Gravity Mechanics
      * Upon pressing the keys stated above, the gravity acting upon the ball changes.
      * When no keys are being pressed, the acceleration on the ball becomes 0. However, the velocity of the ball is preserved.
   *  Bounce Mechanics
Upon a ball hitting a normal wall, the velocity of the ball is preserved but the angle of the ball’s direction changes.
      * This also works with lines that are not horizontal/vertical.
* Levels with different layouts, most likely 8-10, get from the start to the spirit orb
* GUI
   * The user can interact with a main menu, a level select screen, and a pause menu when inside a level.
   * The GUI should have some sense of cleanliness. (Note: By cleanliness, it means to look nice.)
* Obstacles
   * Normal Walls
   * Spikes
   * Friction Areas (if the ball enters this area, it experiences friction)
   * Start/Finish positions
   * And more (to be continued in the Want-to-have features)
* File Reader (from txt files)
   * Makes the program read certain aspects of a 
   * level from a .txt file
   * Includes the start location, the end location, and all of the obstacles.


Want-to-have Features:
[These are features that you would like to have by the project due date, but you’re unsure whether you’ll hit all of them. A good final project would have perhaps half of these completed. At least 5 are required. Again, fully describe each.]
* Changing gravity changes background color (Red if gravity is left, Yellow if up, Green if right, Blue if down)
* Having a story (Example: You are a soul, and you want to get to the spirit orb, upon collecting all spirit orbs you go to the afterlife.)  
* More Obstacles
   * Wind
   * Buttons/switches
   * Bouncepads
   * Sticky walls
   * Breakable walls (requires a certain strength of velocity to break upon impact)
   * Acceleration areas (accelerates the ball in the direction that it is traveling)
   * And more (to be continued in the Stretch features, may be added onto later)
* Appearance touch-up, making everything look “clean”
   * Transitions between menus/levels
   * An animated character
* Additional Levels
   * More challenging techniques and level design.


Stretch Features:
* Sandbox Mode
   * Lets you place obstacles on an empty map and you can make a level yourself.
   * After finishing sandbox mode, this prints out the created map in the right format so one can copy and paste it into a .txt file and use it in the game.
* Cutscenes
   * Let the players engage with the story in the game.
* Multiplayer (1 person gets up/down, next person gets left/right)
* Even more complicated Obstacles
   * Pinwheels
   * Tracking Obstacles (follows the player a certain way)
   * Rotating Objects
   * Teleporters


Class List:
* Main: Serves as the class which creates the window. Has a DrawingSurface named drawing.
* DrawingSurface (extends PApplet implements ScreenSwitcher): Draws all the components in the window. Serves as the sensor for key presses and mouse actions. Has a Screen, a Game, and implements ScreenSwitcher.
* ScreenSwitcher: Switches the active screen being drawn by the DrawingSurface.
* Screen: An abstract class which serves as the basis for several other special screens, such as Instruction, Pause, LvlSelect, Menu, and EndScreen.
   * Menu (extends Screen): Displays two buttons labeled “Play” and “How to Play” along with a background image. By pressing the “Play” button, it switches to the LvlSelect screen. By pressing the “How to Play” button, it switches to the Instruction screen.
   * LvlSelect (extends Screen): Displays the levels and allows the player to select which level they want to play on.
   * Pause (extends Screen): Displays the pause menu when either clicking the pause button in the top left or pressing “P” on the keyboard while in a game.
   * EndScreen (extends Screen): Displays the ending upon finishing the last level in the game.
   * Instruction (extends Screen): Displays the instructions when clicking on the “How to Play” button from the starting screen.
* Game (extends Screen): Displays the game when playing. This includes the Player, the current Level, and the Obstacles of the Level. Uses DrawingSurface’s key information in order to choose the direction for the acceleration of the Player and the color of the arrow in the background. It also tracks when the Player is at the end of a level and triggers the Player’s act method.
* Level: Contains the starting point, the goal, and all the obstacles of a given level.
   * EndPoint: A helper class to Level which represents a circle. This circle is the goal of a level.
* Obstacle: An abstract class which serves as the basis for most interactables the Player can touch. It has a default hitbox composed of several Lines, usually bordering the perimeter of the Obstacle.
   * Line: Represents a straight line with two endpoints. Used to represent the hitbox of Obstacles and used by the Player’s act method in order to do complicated math.
   * Wall (extends Obstacle): Represents a gray rectangle which a Player can interact with. Upon collision, the Player will be sent at an angle depending on which direction the Player moves and the angle of the side of a Wall that the Player collides with.
   * Spike (extends Obstacle): Represents multiple spikes which a Player can interact with. Upon collision, the Player will die, being sent back to the start.
   * Booster (extends Obstacle): Represents a green rectangle which a Player can pass through. While passing through the Booster, acceleration will act upon the Player in the direction that it is traveling in.
   * Sludge (extends Obstacle): Represents a brown rectangle which a Player can pass through. While passing through the Sludge, the Player will slow down until it stops moving.
* Player: Represented by a gray circle. The Player has a position vector and a velocity vector, with a method being able to accelerate the Player. In its act method, an algorithm calculates the collision with Obstacles, mimicking realistic bounce mechanics upon colliding with a wall.


Credits:
* Basic setup - Jim, Edward
* GUI - Jim
* Physics Engine (located in Player’s act method) - Edward
* Level class - Jensen
* Controls - Jensen
* Background color swap - Edward
* Obstacles, Wall, Spike, Booster, and Sludge classes - Jensen, Edward
* Creation of Levels 1 - 3, 5, and 77 - Jensen
* Creation of Level 4 - Edward
* Creation of Level 66 - Jim


* Outside Resource Credit:
   * Utilized AnimationDemoProcessing as a blueprint - Edward
   * Based the Main class from GridWorld / GameOfLife - Edward
   * Utilized the APCS Demo Screen Switching - Jensen
   * Line class copied from previous Shapes lab - Edward
   * Calculating points of a rectangle based off of angle and position (Aholio) - Jensen
   * Images found on Google, 1,2,3,4, 5
   *