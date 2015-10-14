/*Proj6_ReadLineTest
 * 
 * CSc 127A Fall 15, Project 6
 * 
 * Author: Jamie John David
 * SL Name: Sujan Patel (Section C)
 * 
 * -- 
 * The purpose of this program is to separate a line of words
 * provided by the user into two separate words which is then
 * displayed.
 */

import java.util.Scanner;

public class Proj6_ReadLineTest {
    public static void main(String[] args) {
        
        //Create new Scanner object to take in user input
        Scanner in = new Scanner(System.in);
        
        /*
         * Start loop:
         * 1)ask user for two words separated by space (color shape)
         * 2)separate the two words and check for errors
         *   -if error is found, restart loop
         * 3)display the separated words
         * 4)start over loop
         */
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
            
            //Check if only one word was entered, if so print error and reloop
            if(firstWord.isEmpty() || secondWord.isEmpty()){
                System.out.println("Error. One word entered.");
                continue;
            }
            
            //Display the two words obtained by separation of line
            System.out.println("First Word is " + firstWord);
            System.out.println("Second Word is " + secondWord);
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
