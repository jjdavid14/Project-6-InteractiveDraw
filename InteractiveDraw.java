/*Proj6_InteractiveDraw
 * 
 * CSc 127A Fall 15, Project 6
 * 
 * Author: Jamie John David
 * SL Name: Sujan Patel (Section C)
 * 
 * -- 
 * The purpose of this program is to separate a line of words
 * provided by the user into two separate words used for color
 * and shape. The shape is then drawn with the given color at
 * a random location.
 */

import java.util.Scanner;
import java.util.Random;

public class Proj6_InteractiveDraw {
    public static void main(String[] args) {
        
        //Create new Scanner object to take in user input
        Scanner in = new Scanner(System.in);
        
        /*
         * Start loop:
         * 1)ask user for two words separated by space (color shape)
         * 2)separate the two words and check for errors
         *   -if error is found, restart loop
         * 3)if color and shape are available, draw at random locations
         *   -if shape or color is not available, restart loop
         * 4)start over loop
         */
        System.out.println("Enter two words separated by space");
        while(in.hasNextLine()) {
            String line = in.nextLine();   //store the line entered to line
            int index = line.indexOf(' '); //find index of space
            String firstWord = "";         //initialize first word to blank
            String secondWord = "";        //initialize second word to blank
            
            /*
             * Checks number of spaces, if > 1 prints error and restart loop.
             * Checks if two words were entered if not print error and resart
             * loop.
             * If no errors, separates the line into two words.
             */
            if(checkSpaces(line)) {
                System.out.println("Error. More than one space used." +
                                   " Please use one space to separate words.");
                continue;
            }else if(index == -1) {
                System.out.println("Error. Please enter two words separated" +
                                   " by space.");
                continue;
            }else {
                firstWord = line.substring(0,index);
                secondWord = line.substring(index+1,line.length());
            }
            
            //Check for color, if not available print error and restart loop
            //Colors: Red, Green, Blue, White, Black
            String upper = firstWord.toUpperCase();
            switch(upper) {
                case("RED"):
                    StdDraw.setPenColor(StdDraw.RED);
                    break;
                case("GREEN"):
                    StdDraw.setPenColor(StdDraw.GREEN);
                    break;
                case("BLUE"):
                    StdDraw.setPenColor(StdDraw.BLUE);
                    break;
                case("WHITE"):
                    StdDraw.setPenColor(StdDraw.WHITE);
                    break;
                case("BLACK"):
                    StdDraw.setPenColor(StdDraw.BLACK);
                    break;
                default:
                    System.out.println("Color not available. Please " +
                                       "Choose a different color.");
                    continue;
            }
            
            //Size for all shapes
            //r Circle, L/2 Square, L/2 & W/4 Rectangle
            final int SIZE = 2;
            
            /*Create random numbers for random locations of shapes
             *x:(4,96) so Rectangle is never out of scale, same for rest
             *y:(2,98) so all shapes are never out of scale
             */
            Random rand = new Random();
            int xPos = (int)(4 + rand.nextDouble() * 92);
            int yPos = (int)(2+ rand.nextDouble() * 96);
            
            //Set scale x:[0,100] y:[0,100]
            StdDraw.setScale(0,100);
            
            //Check for shape if not available, print error and restart loop
            //Shapes: Circle, Square, Rectangle
            upper = secondWord.toUpperCase();
            switch(upper) {
                case("CIRCLE"):
                    StdDraw.filledCircle(xPos,yPos,SIZE);
                    break;
                case("SQUARE"):
                    StdDraw.filledSquare(xPos,yPos,SIZE);
                    break;
                case("RECTANGLE"):
                    StdDraw.filledRectangle(xPos,yPos,2*SIZE,SIZE);
                    break;
                default:
                    System.out.println("Shape not available. Please " +
                                       "Choose a different shape.");
                    continue;
            }
            
            //Display the two words obtained by separation of line
            System.out.println("First Word(Color) is " + firstWord);
            System.out.println("Second Word(Shape) is " + secondWord);
            
            //Prompt user again for line
            System.out.println("Enter two words separated by space");
        }
    }
    
    /*
     * Checks if more than one space is inside string.
     * 
     * @param word The string to be checked
     * @returns True if more than one space is inside string, else is false
     */
    public static boolean checkSpaces(String word) {
        char[] wordArray = word.toCharArray();
        int count = 0;
        
        for(int i=0;i<wordArray.length;i++) {
            if(wordArray[i] == ' ') {
                count++;
            }
        }
        if(count>1) {
            return true;
        }
        else {
            return false;
        }
    }
}
