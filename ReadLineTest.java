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
        
        
        while(in.hasNextLine()) {
            
            String line = in.nextLine();
            int index = line.indexOf(' ');
            String firstWord = "";
            String secondWord = "";
            
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
