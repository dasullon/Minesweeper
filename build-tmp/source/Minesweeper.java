import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import de.bezier.guido.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Minesweeper extends PApplet {


int NUM_ROWS=20;
int NUM_COLS=20;
private MSButton[][] buttons; //2d array of minesweeper buttons
private ArrayList <MSButton> bombs; //ArrayList of just the minesweeper buttons that are mined

public void setup ()
{
size(400, 420);
textAlign(CENTER,CENTER);
Interactive.make( this );
buttons= new MSButton [NUM_ROWS][NUM_COLS];
for (int j = 0; j < NUM_ROWS; ++j) {
    for (int i = 0; i < NUM_COLS; ++i) {
     buttons[j][i] = new MSButton(j,i); 
 }
}
bombs = new ArrayList <MSButton>();
setBombs();
}

public void setBombs()
{
for (int i=0; i<200; i++){
int row = (int) (Math.random()*20) ; 
int col = (int) (Math.random()*20) ;
if (! bombs.contains (buttons[row][col]) ){
   bombs.add(buttons[row][col]);
 }
}
}
public void draw ()
{
background(0);

if(isWon())
displayWinningMessage();
}

public boolean isWon()
{
// if everything that is not a bomb is clicked you win
for(int i=0; i< bombs.size(); i++)
{
 if(bombs.get(i).isMarked()==false){
 return false;
 }
}
return true;
}

public void displayLosingMessage()
{
fill(255);
textSize(12);
text("YOU LOST", 200, 410); 
noLoop();
}

public void displayWinningMessage()
{
fill(255);
textSize(12);
text("YOU WIN", 200, 410); 
noLoop();
}

public class MSButton {
private int r, c;
private float x,y, width, height;
private boolean clicked, marked;
private String label;

public MSButton ( int rr, int cc )
{
   width = 400/NUM_COLS;
   height = 400/NUM_ROWS;
   r = rr;
   c = cc; 
   x = c*width;
   y = r*height;
   label = "";
   textSize(12);
   marked = clicked = false;
    Interactive.add( this ); // register it with the manager
}
public boolean isMarked()
{
    return marked;
}
public boolean isClicked()
{
    return clicked;
}
// called by manager

public void mousePressed () 
{
clicked = true;
//fix
if(mouseButton==RIGHT){
  fill(0,255,0);
  marked=true;
 }
else if(bombs.contains(this)){
    displayLosingMessage();
 }
else if(countBombs (r,c)>0){
    label= nf(countBombs(r,c),1); 
 }
}

public void draw () 
{    
    if (marked)
        fill(0);
    else if( clicked && bombs.contains(this) ) 
        fill(255,0,0);
    else if(clicked)
        fill( 200 );
    else 
        fill( 100 );
rect(x, y, width, height);
fill(0);
text(label,x+width/2,y+height/2);
}
public void setLabel(String newLabel)
{
label = newLabel;
}
public boolean isValid(int r, int c)
{
return r>=0 && r<NUM_ROWS && c>=0 && c<NUM_COLS;  
}
public int countBombs(int row, int col)
{
int numBombs = 0;
if(isValid (row+1,col))
    if (bombs.contains(buttons[row+1][col]))
        numBombs++;
if(isValid (row ,col-1) )
    if (bombs.contains(buttons[row][col-1]))
        numBombs++;
if(isValid (row -1,col) )
    if (bombs.contains(buttons[row-1][col]))
        numBombs++;
if(isValid (row ,col+1) )
    if (bombs.contains(buttons[row][col+1]))
        numBombs++;
if(isValid (row +1,col-1) )
    if (bombs.contains(buttons[row+1][col-1]))
        numBombs++;
if(isValid (row -1,col+1) )
    if (bombs.contains(buttons[row-1][col+1]))
        numBombs++;
if(isValid (row +1,col+1) )
    if (bombs.contains(buttons[row+1][col+1]))
        numBombs++;
if(isValid (row -1,col-1) )
    if (bombs.contains(buttons[row-1][col-1]))
        numBombs++;
return numBombs;
 }
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Minesweeper" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
