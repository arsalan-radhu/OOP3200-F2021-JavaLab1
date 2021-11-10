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
        //Constants
        final int GAMES =   2;
        final int PLAYERS = 3;
        final int MIN_SCORE = 0;
        final int MAX_SCORE = 300;

        //Declarations
        String[] playerNames = {"Arsalan", "Affan", "Tom"};
        Scanner keyboard = new Scanner(System.in);
        boolean valid = true;
        int tempScore = 0;
        double playerAverageScore = 0;
        //declaring a 2D Array
        int[][] playerGames = new int [PLAYERS][GAMES];


        //Nested for loops for taking user input
        for (int playerCounter = 0; playerCounter < PLAYERS; playerCounter++) //Player counter
        {
            //System.out.printf("Please enter %s's score for ", playerNames[playerCounter]);

            for (int gameCounter = 0; gameCounter < GAMES; gameCounter++) //Game counters
            {
                do {
                    //While the input is invalid, keep asking for game scores
                    try
                    {
                        System.out.printf("Please enter %s's score for ", playerNames[playerCounter]);
                        System.out.printf("GAME #%d: ", gameCounter + 1);
                        tempScore = keyboard.nextInt();

                        //if the user input is higher or lower than the acceptable inputs
                        if (tempScore < MIN_SCORE || tempScore > MAX_SCORE)
                        {
                            System.out.print("\nYou must enter a valid score between"+MIN_SCORE +" and " +MAX_SCORE+ "\n");
                            keyboard.nextLine();
                            valid = true;
                        }
                        else //if the input is valid
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
                } while (valid); //using a boolean
            }
        }

        //PRINT THE ARRAY
        for (int playerCounter = 0; playerCounter < PLAYERS; playerCounter++)
        {

            System.out.printf("Score details for %s: \n", playerNames[playerCounter]);
            playerAverageScore = 0;

            for (int GameCounter = 0; GameCounter < GAMES; GameCounter++)
            {
                System.out.printf("Game # %d: ", GameCounter + 1);
                System.out.println(playerGames[playerCounter][GameCounter]);
                //take the number (as a string) and cast it as an integer, then store it in playerAvg
                playerAverageScore += playerGames[playerCounter][GameCounter];
            }
            System.out.printf("Average : %.1f\n", (playerAverageScore / GAMES));
        }

    }
}
