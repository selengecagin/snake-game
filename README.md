Snake Game

Overview
A Java-based Snake Game using javax.swing for GUI. Players control a snake to eat apples, growing in length with each apple eaten, while avoiding collisions with the game borders or itself.

Features
Game Area: 600x600 pixels, with each unit being 25x25 pixels.
Game Mechanics:
- Snake grows upon eating apples.
- Random apple spawns after each is eaten.
- Game speeds up as more apples are eaten.
Controls: Arrow keys for snake direction.
End Game: Colliding with the border or the snake itself ends the game.
Class GamePanel:
Implements the main game area, handling game logic, rendering, and input.

Key Components
Variables: Store game state, snake coordinates, and apple position.
Constructor: Sets up the game environment.
Methods:
- startGame(): Initializes the game.
- paintComponent(), draw(): Handle rendering.
- move(), checkApple(), checkCollisions(): Game logic.
- gameOver(): Displays the end screen.
- Inner Class MyKeyAdapter: Handles keyboard input for snake direction.
