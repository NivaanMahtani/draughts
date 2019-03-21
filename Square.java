import javax.swing.*;
import java.awt.*;

public class Square extends JButton
{
    ImageIcon blacksquare = new ImageIcon("empty2.png"); //creates the black square
    ImageIcon whitesquare  = new ImageIcon("empty.png"); // creates the white square
    ImageIcon redpiece = new ImageIcon("red.png"); // creates the red piece
    ImageIcon whitepiece = new ImageIcon("white.png"); // created the white piece
    
    String color; // creates variable called "color"
    int x; // creates variable called "x"
    int y; // created variable called "y"
  
    
    public Square( int posx, int posy, String color) // creates method called Square
    {
        x = posx;
        y = posy;

        if (color == "Black") // if color of square is black, then
        {
            this.setIcon(blacksquare); // puts the black square icon into the button
            this.color = color; 
        }
        if (color == "White") // if color of square is white, then
        {
            this.setIcon(whitesquare); // puts the white square icon into the button
            this.color = color;
        }    
        if(y <= 2  && color == "White") // puts red pieces into the first 3 rows that have a white square
        {
            this.setIcon (redpiece);
            this.color = color;

        }
        if(y >= 5 && color == "White") // puts white pieces into the first 3 rows that have a white square
        {
            this.setIcon(whitepiece);
            this.color = color;

        }
    }
    public Square() 
    {

    }
    
    public void MoveTo (int locationx , int locationy, JPanel p) // makes the mvements
    {
        x = locationx;
        y = locationy;
        p = p;

       Component[] comp = p.getComponents(); // creates an array called "Component" and gets the panel's components (JButtons)
       for (int i = 0; i < comp.length ; i++)
       {
        if (comp [i] instanceof JButton) // it checks if the array are part of JButtons
        {
            Square sq = ((Square)comp[i]);
            if(sq.y == x && sq.x == y)
            {
               this.setIcon(whitepiece);
               this.color = color;

            }

        }

       }
    }
     
    

      
}