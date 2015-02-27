Minesweeper
==================

In this assignment you will be recreating the [Microsoft Minesweeper game](http://en.wikipedia.org/wiki/Minesweeper_(video_game)). If you are not familiar with minesweeper you should play the game until you are. You can find one version at [http://minesweeperonline.com/](http://minesweeperonline.com/). You can also try my [slightly easier Minesweeper game](http://simart.github.io/MinesweeperFinished/)

Install the Guido GUI Library
--------------------------------
We'll be using a GUI library called Guido. To install it, start *Processing* and choose *Sketch | Import Library | Add Library*. Type *Guido* in the search box, the click on *Guido by Florian Jenett* and then click *Install*.

Program Requirements
--------------------
1. Your minesweeper game will be a two dimensional array of buttons. Use constants for the number of rows and columns.
2. The number of bombs should also be specified by a constant.
3. Make sure all class member variables and methods are labeled appropriately as either `public`, `protected` or `private`
4. If you click on a button that contains a bomb, the game ends and all the bombs are displayed
5. If you click on a button that does not contain a bomb, a number appears at that location indicating the number of neighbors that DO contain bombs. Recall that each position has at most 8 neighbors. Note that the buttons on the boundary have fewer than 8 neighbors. For example, a corner has only three neighbors.
6. If the user clicks on a button and no number appears, then there are no bombs surrounding that button. Your program should then recursively keep marking those surrounding buttons that are not surrounded by bombs.
7. The game should end when all the buttons that do not contain bombs have been marked (assuming that you have not been blown up by then!)
8. Your game should use `Math.random()` to randomly place the mines.


Suggested steps to completing this assignment:

		

5. Then finish `public void displayWinMessage()` which uses `setLabel` to change the labels of the buttons to display a winning message
6. Finally finish `public void displayLosingMessage()` to display the positions of all the bombs as well as a losing message



***
Alternative Assignment: The Game of Life
----------------------------------------
If you want an alternative to Minesweeper, you could write your own version of the The Game of Life. The Game of Life isn't what you think, it's a program that simulates how bacteria might grow. It's another program that is well suited to using a two dimensional array of buttons. You can find examples and descriptions at the following websites:
[http://www.bitstorm.org/gameoflife/](http://www.bitstorm.org/gameoflife/)   
[http://www.math.com/students/wonders/life/life.html](http://www.math.com/students/wonders/life/life.html)

***
Samples of Student Work
-----------------------
[Zachary](http://zachooz.github.io/Minesweeper/)  
