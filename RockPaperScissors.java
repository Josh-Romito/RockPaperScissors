import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    private static boolean keepRunning;                                 //bool to keep application running
    private static Scanner keyboard = new Scanner(System.in);           //scanner to read input
    private static int npcHand;                                         //int to hold the npcHand
    private static int playerHand;                                      //int to hold the playerHand

    public static void main(String[] args) {
        System.out.println("Welcome to the Rock Paper Scissors Game!");

        do {
            npcHand = GenerateRandomHand();                                         //generating random npcHand
            System.out.println("Your opponent is ready... " +
                    "\nPlease enter your hand ('rock', 'paper', or 'scissors').");
            String playerChoice = keyboard.next();                                  //taking in player hand input
            ParseInput(playerChoice);                                               //parsing input to a numeric value
            PrintNPCHand(npcHand);                                                  //printing npcHand
            CompareDraw(npcHand, playerHand);                                       //comparing player and npc hand
            KeepRunning();                                                          //checking if we want to keep running
        }while(keepRunning);
    }

    /**
     * This method parse's the players input to a numeric value for comparison later on
     * @param playerChoice A String of the players input (rock, paper, or scissors)
     */
    private static void ParseInput(String playerChoice){
        if(playerChoice.equalsIgnoreCase("rock"))
            playerHand = 1;
        else if(playerChoice.equalsIgnoreCase("paper"))
            playerHand = 2;
        else if(playerChoice.equalsIgnoreCase("scissors"))
            playerHand = 3;
    }

    /**
     * This method Compares the player and NPC hands, and prints the result
     * @param npcHand The integer representing the npc's hand - rock(1), paper(2), scissors(3)
     * @param playerHand The integer representing the players's hand - rock(1), paper(2), scissors(3)
     */
    private static void CompareDraw(int npcHand, int playerHand){
        switch(playerHand){
            case(1):
                if(npcHand == 1)
                    System.out.println("Draw! Try again!");
                else if(npcHand == 2)
                    System.out.println("You lose! Paper beats Rock!");
                else if(npcHand == 3)
                    System.out.println("You win! Rock beats Scissors");
                break;
            case(2):
                if(npcHand == 1)
                    System.out.println("You win! Paper covers Rock!");
                else if(npcHand == 2)
                    System.out.println("Draw! Try again!");
                else if(npcHand == 3)
                    System.out.println("You lose! Scissors cuts Paper!");
                break;
            case(3):
                if(npcHand == 1)
                    System.out.println("You lose! Rock crushes scissors!");
                else if(npcHand == 2)
                    System.out.println("You win! Scissors cuts Paper!");
                else if(npcHand == 3)
                    System.out.println("Draw! Try again!");
                break;
        }
    }

    /**
     * This method Prints the NPC's hand
     * @param npcHand The integer value representing the npc's hand - rock(1), paper(2), scissors(3)
     */
    private static void PrintNPCHand(int npcHand){
        switch(npcHand){
            case(1):
                System.out.println("The computer chose Rock!");
                break;
            case(2):
                System.out.println("The computer chose Paper!");
                break;
            case(3):
                System.out.println("The computer chose Scissors!");
                break;
        }
    }

    /**
     * This method Generates a random integer between 1 and 3.
     * @return Returns the generated integer
     */
    private static int GenerateRandomHand(){
        Random r = new Random();
        return r.nextInt(3) + 1;
    }

    /**
     * This method asks the user if they would like to keep the application running
     */
    private static void KeepRunning() {
        System.out.println("Do you want to try again? \n(Y/N)");
        String response = keyboard.next();
        if(response.equalsIgnoreCase("y"))
            keepRunning = true;
        else if(response.equalsIgnoreCase("n"))
            keepRunning = false;
    }
}
