
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author apprentice
 */
public class RockPaperScissors_v2 {

    public static void main(String[] args) {

        //scanner
        Scanner inputReader = new Scanner(System.in);
        //randomizer for comp
        Random rand = new Random();

        //variables
        int rock = 1;
        int paper = 2;
        int scissors = 3;
        int lizard = 4;
        int spock = 5;
        int round;
        int choice;
        int compChoice = 1;
        int countOfWins = 0;
        int countOfLosses = 0;
        int countOfTies = 0;

        //ask how many rounds to play; max 10 --> if more than 10, print error message and quit.
       do {
        do {
            System.out.println("How many rounds do you want to play?");
            //output
            round = inputReader.nextInt();
            if (round < 1 || round > 10) {
                System.out.println("Error Message: Please type a number between 1 and 10.");
            }
        } while (round < 1 || round > 10);

        for (int i = 1; i <= round; i++) {
            System.out.println("Please select a number from the follow:");
            System.out.println("1) Rock"
                    + "\n2) Paper"
                    + "\n3) Scissors"
                    + "\n4) Lizard"
                    + "\n5) Spock");

            compChoice = rand.nextInt(5 - 2 + 2) + 1;

            choice = inputReader.nextInt();
            //if statements for all scenarios
            if (compChoice == 1) {
                if (choice == 1) {
                    System.out.println("Tie game.");
                    countOfTies++;
                } else if (choice == 2) {
                    System.out.println("Rock gets covered by paper. You win!");
                    countOfWins++;
                } else if (choice == 3) {
                    System.out.println("Rock crushes scissors. You lose.");
                    countOfLosses++;
                } else if (choice == 4) {
                    System.out.println("Rock crushes lizard. You lose.");
                    countOfLosses++;
                } else if (choice == 5) {
                    System.out.println("Spock vaporizes rock. You win!");
                    countOfWins++;
                }
            } else if (compChoice == 2) {
                if (choice == 1) {
                    System.out.println("Paper covers rock. You lose.");
                    countOfLosses++;
                } else if (choice == 2) {
                    System.out.println("Tie game.");
                    countOfTies++;
                } else if (choice == 3) {
                    System.out.println("Scissors cuts paper. You win!");
                    countOfWins++;
                } else if (choice == 4) {
                    System.out.println("Lizard eats paper. You win!");
                    countOfWins++;
                } else if (choice == 5) {
                    System.out.println("Paper disproves Spock. You win!");
                    countOfWins++;
                }
            } else if (compChoice == 3) {
                if (choice == 1) {
                    System.out.println("Rock crushes scissors. You lose.");
                    countOfLosses++;
                } else if (choice == 2) {
                    System.out.println("Scissors cuts paper. You lose.");
                    countOfLosses++;
                } else if (choice == 3) {
                    System.out.println("Tie game.");
                    countOfTies++;
                } else if (choice == 4) {
                    System.out.println("Scissors decapitates lizard. You lose.");
                    countOfLosses++;
                } else if (choice == 5) {
                    System.out.println("Spock smashes scissors. You win!");
                    countOfWins++;
                }
            } else if (compChoice == 4) {
                if (choice == 1) {
                    System.out.println("Rock crushes lizard. You win!");
                    countOfWins++;
                } else if (choice == 2) {
                    System.out.println("Lizard eats paper. You lose.");
                    countOfLosses++;
                } else if (choice == 3) {
                    System.out.println("Scissors decapitates lizard. You win!");
                    countOfWins++;
                } else if (choice == 4) {
                    System.out.println("Tie game.");
                    countOfTies++;
                } else if (choice == 5) {
                    System.out.println("Lizard poisons Spock. You lose.");
                    countOfLosses++;
                }
            } else if (compChoice == 5) {
                if (choice == 1) {
                    System.out.println("Rock crushes lizard. You lose.");
                    countOfLosses++;
                } else if (choice == 2) {
                    System.out.println("Lizard eats paper. You win!");
                    countOfWins++;
                } else if (choice == 3) {
                    System.out.println("Scissors decapitates lizard. You lose.");
                    countOfLosses++;
                } else if (choice == 4) {
                    System.out.println("Lizard poisons Spock. You win!");
                    countOfWins++;
                } else if (choice == 5) {
                    System.out.println("Tie game.");
                    countOfTies++;
                }
            }
        }

        //print out wins, losses, and ties
        System.out.println("Number of Wins:" + countOfWins);
        System.out.println("Number of Losses: " + countOfLosses);
        System.out.println("Number of Ties: " + countOfTies);

        //ask user if wants to play again
        System.out.println("Do you want to play again (Y/N)?");
                String playAgain = inputReader.next();

        if (playAgain.equals("Y")) {
        } else {
            System.out.println("Thank you for playing.");
            System.exit(0);
        }
       } while (true);

    }

}
