package assignmenttwo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
/**
 * @author Swati
 * Create a window with 8 buttons (this may change, in the future,
 * to 100 buttons so make sure to be able to do that easily) organized
 * in a 4x2 grid.
 * Have the background color of each button start at
 * some random value.
 * When a button is pressed, it should cause every
 * OTHER button to change background color.  The button pressed should
 * not change background color at all.
 */
public class AssignmentTwo {
   public static void main(String[] args) {
        //creates a new 'window'
        JFrame createdFrame = new JFrame("Assignment Two");
        //show the window upon running
        createdFrame.setVisible(true);
        //size of the window
        createdFrame.setSize(600,400);
        //allow window to be maximaize/minimaze
        createdFrame.setResizable(true);
        //close the window, when user presses exit
        createdFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //a panel on which to put all the buttons in
        JPanel mainPanel = new JPanel();
        //have the panel in a 4 by 2 layout
        mainPanel.setLayout(new GridLayout(4,2));

        //array to put all created buttons
        JButton[] buttonArray = new JButton[8];
        //create the 8 buttons
        for(int i = 0; i < 8; ++i){
            //get a random number
            Random rand = new Random();
            //Returns the next pseudorandom, uniformly distributed float value
            //between 0.0 and 1.0 from this random number generator's sequence
            float r = rand.nextFloat();
            float g = rand.nextFloat();
            float b = rand.nextFloat();
            //create a random color using the Color class constructor
            Color randomColor = new Color(r, g, b);

            //a new button created
            JButton bambi = new JButton("Press");
            //enter button to array
            buttonArray[i] = bambi;
            //set the button's color with random color
            bambi.setBackground(randomColor);
            //what to do when button is pressed
            bambi.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    JButton bambino = (JButton) e.getSource();
                    for(int i = 0; i < buttonArray.length; ++i){
                        if(buttonArray[i] != bambino){
                            buttonArray[i].setBackground(Color.BLACK);
                        }
                    }
                }
            });
            //add the button to the panel
            mainPanel.add(bambi);
        }
        //add the panel to frame
        createdFrame.add(mainPanel);
   }
}
