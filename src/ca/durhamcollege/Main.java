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
        String[] playerNames = {"Nick", "Kaif", "Tom"};
        Scanner keyboard = new Scanner(System.in);
        boolean dirtyFlag = true;
        int tempScore = 0;
        double playerAvg = 0;
        int[][] playerGames = new int [PLAYERS][GAMES]; //2Dimensional Array


        //Nested for loops for taking user input
        for (int i = 0; i < PLAYERS; i++) //Player counter
        {
            System.out.printf("Please enter the scores for %s: \n", playerNames[i]);

            for (int j = 0; j < GAMES; j++) //Game counters
            {
                do { //While the input is invalid, keep asking for game scores
                    try
                    {
                        System.out.printf("Please enter the score for game %d: ", j + 1);
                        tempScore = keyboard.nextInt();

                        if (tempScore < MIN_SCORE || tempScore > MAX_SCORE) //if the user input is higher or lower than the acceptable inputs
                        {
                            System.out.print("\nYou must enter a valid float greater than 0.00 or lower than 300.00\n");
                            keyboard.nextLine();
                            dirtyFlag = true;
                        }
                        else //if the input is valid
                        {
                            dirtyFlag = false;
                            playerGames[i][j] = tempScore;
                        }
                    }
                    catch (InputMismatchException inputMismatchException) //if the input is non-numeric
                    {
                        System.out.print("\nYou must enter a valid integer greater than 0.00 or lower than 300.00\n");
                        keyboard.nextLine();
                        dirtyFlag = true;
                    }
                } while (dirtyFlag); //using a boolean
            }
        }

        //PRINT THE ARRAY
        for (int i = 0; i < PLAYERS; i++) //Player counter
        {

            System.out.printf("Printing the scores for %s: \n", playerNames[i]);
            playerAvg = 0;

            for (int j = 0; j < GAMES; j++) //Game counters
            {
                System.out.printf("Game #   %d: ", j + 1);
                System.out.println(playerGames[i][j]);
                //take the number (as a string) and cast it as an integer, then store it in playerAvg
                playerAvg += playerGames[i][j];
            }
            System.out.printf("Average : %.1f\n", (playerAvg / GAMES));
        }

    }
}
