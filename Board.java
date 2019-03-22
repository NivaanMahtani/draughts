/**
* Draughts in Java
* 
*
* @author  Harshal Mahtani
* @since   2019-03-22
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board implements ActionListener
{
    int clicks = 0; // iniciates variable "click"
    JPanel p = new JPanel(); // creates JPanel
    Square s1 = new Square(); // creates  the first square you click
    Square s2 = new Square(); // creates the second square you click
    JFrame frame = new JFrame("Draughts in Java"); //creates JFrame and calls it "Draughts in Java"
    GridLayout gridlayout = new GridLayout(8,8); // orginizes the buttons in a 8*8 square
    

    public static void main(String[]args)
    {
        new Board().draughts(); // calls the draughts method
    }

    public void draughts()
    {
        frame.setSize(780,780); // sets the size of the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // it tells the system what it should do when you press the close button.

        for(int y = 0; y < 8; y++) //sets the columns
        {    

            if(y%2 == 0) // checks if y is odd or not. if odd, do:
            {
                for(int x = 0; x < 8; x++) // for loop from 0 to 7
                {
                    if(x%2 == 0) // if x is odd then:
                    {
                        Square sq = new Square (x, y, "Black"); // it tells if square is black or not
                        p.add(sq); // adds a square to the panel
                    }
                    else
                    {
                        Square sq = new Square (x, y,"White"); // square is white
                        p.add(sq); // adds a square to the panel
                        sq.addActionListener(this); // adds an actionlistener in order to see if the square has been clicked or not. We only add it to the white squares since these are the ones that are suppose to be clicked.
                    }

                }
            }
            else
            {
                for(int x = 0; x < 8; x++) // sets the rows
                {
                    if(x%2 == 0) // checks if y is odd or not. if odd, do:
                    {
                        Square sq = new Square (x, y, "White"); // square is white
                        p.add(sq); // adds a square to the panel
                        sq.addActionListener(this); // adds an actionlistener in order to see if the square has been clicked or not. We only add it to the white squares since these are the ones that are suppose to be clicked.
                    }
                    else
                    {
                        Square sq = new Square (x, y,"Black"); // it tells if square is black or not
                        p.add(sq); // adds a square to the panel
                        
                    }
                }

            }

        }

        p.setLayout(gridlayout); // sets the layout to the panel
        frame.setContentPane(p); // puts the panel into the frame
        frame.setBackground(Color.WHITE); // sets the background to white
        frame.setVisible(true); // very important, since it allows the whole frame to be visible


    }

    public void actionPerformed(ActionEvent e) // clicks + movement
    {
        

        if(clicks%2 == 0)
        {
            s1 = (Square)e.getSource(); // is square is clicked, increment the number of clicks by 1.
            clicks++;
        }
        else
        {
            s2 = (Square)e.getSource(); // gets the source of the second square clicked.
            s2.MoveTo(s2.x,s2.y, p); // moves it to the second square clicked
            s1.color = "White";
            s1.setIcon(s1.whitesquare); // when the piece is moved, the first square clicked becomes a white square 
            clicks++; // icrements number of clicks by 1
        }

    System.out.println("click n-" + clicks); // prints number of clicks
    }

}
