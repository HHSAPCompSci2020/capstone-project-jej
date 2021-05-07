# capstone-project-jej
capstone-project-jej created by GitHub Classroom
Gravity Ball
Authors: Edward Min, Jensen Guo, Siyi Ji
Revision: 4/26/2021

Introduction: 
[In a few paragraphs totaling about ½ page, introduce the high-level concept of your program. What this looks like depends a lot on what type of thing you are making. An introduction for an application will look different than one for a game. In general, your introduction should address questions like these:
What does your program do? The program initiates a game where you need to direct a ball around obstacles. It controls not using immediate controls, but it moves around by you manipulating the gravity impacting the ball.
What problem does it solve? Why did you write it? It solves the problem of boredom, we wrote it because for our APCS final project
What is the story? You are a lost soul, and you are trying to get to the spirit world. In order to do this you must collect spirit orbs.
What are the rules? What is the goal? Use keys to change gravity, most likely WASD. Get to the finish area.
Who would want to use your program? People who enjoy playing games.
What are the primary features of your program? Gravity changing is the main mechanic, it is a platforming game.

Instructions:
[Explain how to use the program. This needs to be specific: 
Which keyboard keys will do what? W will change the gravity to upward direction, A will change the gravity to left, S will change the gravity down, and D will change gravity to right. Inputting two gravities at once will combine their effects. (A + D will cause acceleration to cancel while A + S will cause acceleration to move down-left.)
Where will you need to click? You will need to click as a main way of GUI
Will you have menus that need to be navigated? What will they look like? Yes, the main menu and the level selector, they will probably look like a grid with pressable buttons 
Do actions need to be taken in a certain order?]

Features List (THE ONLY SECTION THAT CANNOT CHANGE LATER):
Must-have Features:
[These are features that we agree you will definitely have by the project due date. A good final project would have all of these completed. At least 5 are required. Each feature should be fully described (at least a few full sentences for each)]
Main Game Mechanics
Gravity Mechanics
Upon pressing the keys stated above, the gravity acting upon the ball changes.
When no keys are being pressed, the acceleration on the ball becomes 0. However, the velocity of the ball is preserved.
 Bounce Mechanics
Upon a ball hitting a normal wall, the velocity of the ball is preserved but the angle of the ball’s direction changes.
This also works with lines that are not horizontal/vertical.
Levels with different layouts, most likely 8-10, get from the start to the spirit orb
GUI
The user can interact with a main menu, a level select screen, and a pause menu when inside a level.
The GUI should have some sense of cleanliness.
Obstacles
Normal Walls
Spikes
Friction Areas (if the ball enters this area, it experiences friction)
Start/Finish positions
And more (to be continued in the Want-to-have features)
File Reader (from txt files)
Makes the program read certain aspects of a 
level from a .txt file
Includes the start location, the end location, and all of the obstacles.

Want-to-have Features:
[These are features that you would like to have by the project due date, but you’re unsure whether you’ll hit all of them. A good final project would have perhaps half of these completed. At least 5 are required. Again, fully describe each.]
Changing gravity changes background color (Red if gravity is left, Yellow if up, Green if right, Blue if down)
Having a story (Example: You are a soul, and you want to get to the spirit orb, upon collecting all spirit orbs you go to the afterlife.)  
More Obstacles
Wind
Buttons/switches
Bouncepads (amplifies/nullifies the velocity of the ball along with pointing it in a different direction)
Sticky walls
Breakable walls (requires a certain strength of velocity to break upon impact)
Acceleration areas (accelerates the ball in the direction that it is traveling)
And more (to be continued in the Stretch features, may be added onto later)
Appearance touch-up, making everything look “clean”
Transitions between menus/levels
An animated character
Additional Levels
More challenging techniques and level design.

Stretch Features:
[These are features that we agree a fully complete version of this program would have, but that you probably will not have time to implement. A good final project does not necessarily need to have any of these completed at all. At least 3 are required. Again, fully describe each.]
Sandbox Mode
Lets you place obstacles on an empty map and you can make a level yourself.
After finishing sandbox mode, this prints out the created map in the right format so one can copy and paste it into a .txt file and use it in the game.
Cutscenes
Lets the players engage with the story in the game.
Multiplayer (1 person gets up/down, next person gets left/right)
Even more complicated Obstacles
Pinwheels
Tracking Obstacles (follows the player a certain way)
Rotating Objects
Teleporters

Class List:
[This section lists the Java classes that make up the program and very briefly describes what each represents. It’s totally fine to put this section in list format and not to use full sentences.]

Credits:
[Gives credit for project components. This includes both internal credit (your group members) and external credit (other people, websites, libraries). To do this:
List the group members and describe how each member contributed to the completion of the final program. This could be classes written, art assets created, leadership/organizational skills exercises, or other tasks. Initially, this is how you plan on splitting the work.
Credit:
Utilized AnimationDemoProcessing as a blueprint - Edward
Copied Main class from GridWorld / GameOfLife - Edward
