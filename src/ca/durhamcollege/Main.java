/*
 * Author: Arsalan Arif Radhu
 * Date: 10 November
 * Title: Lab 1 for OOP3200 Java
 */

package ca.durhamcollege;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        //CONSTANTS
        final int NUMBER_OF_GAMES =   2;
        final int NUMBER_OF_PLAYERS = 3;
        final int MIN_SCORE = 0;
        final int MAX_SCORE = 300;

        //Declarations
        String[] playerNames = {"Arsalan", "Affan", "Tom"};
        boolean valid = true;
        int tempScore = 0;
        double playerAverageScore = 0;
        Scanner keyboard = new Scanner(System.in);
        //declaring a 2D Array
        int[][] playerGames = new int [NUMBER_OF_PLAYERS][NUMBER_OF_GAMES];


        //Nested for loops for taking user input
        for (int playerCounter = 0; playerCounter < NUMBER_OF_PLAYERS; playerCounter++) //Player counter
        {
            for (int gameCounter = 0; gameCounter < NUMBER_OF_GAMES; gameCounter++) //Game counters
            {
                do {
                    //While the input is invalid, keep asking for game scores
                    try
                    {
                        System.out.printf("Please enter %s's score for ", playerNames[playerCounter]);
                        System.out.printf("GAME #%d: ", gameCounter + 1);
                        tempScore = keyboard.nextInt();

                        //if the user input is greater than or less than MAX_SCORE and MIN_SCORE
                        if (tempScore < MIN_SCORE || tempScore > MAX_SCORE)
                        {
                            System.out.print("\nYou must enter a valid score between"+MIN_SCORE +" and " +MAX_SCORE+ "\n");
                            keyboard.nextLine();
                            valid = true;
                        }
                        //if the valid input is entered
                        else
                        {
                            valid = false;
                            playerGames[playerCounter][gameCounter] = tempScore;
                        }
                    }
                    //If input is non-numeric
                    catch (InputMismatchException inputMismatchException)
                    {
                        System.out.print("\nYou must enter a valid score between"+MIN_SCORE +" and " +MAX_SCORE+ "\n");
                        keyboard.nextLine();
                        valid = true;
                    }
                } while (valid);
            }
        }

        //Printing the output (array)
        for (int playerCounter = 0; playerCounter < NUMBER_OF_PLAYERS; playerCounter++)
        {
            System.out.printf("\nScore details for %s: \n", playerNames[playerCounter]);
            playerAverageScore = 0;

            for (int GameCounter = 0; GameCounter < NUMBER_OF_GAMES; GameCounter++)
            {
                System.out.printf("Game # %d: ", GameCounter + 1);
                System.out.println(playerGames[playerCounter][GameCounter]);
                //take the number (as a string) and cast it as an integer, then store it in playerAvg
                playerAverageScore += playerGames[playerCounter][GameCounter];
            }
            System.out.printf("Average : %.1f\n", (playerAverageScore / NUMBER_OF_GAMES));
        }

    }
}
