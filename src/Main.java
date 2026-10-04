import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       Random random = new Random();

       System.out.println("Wanna start the game? (type yes to start)");

       if (scanner.nextLine().equalsIgnoreCase("yes")) {
           System.out.println("Press enter to continue or stop if you want to stop playing.");
           while (!scanner.nextLine().equalsIgnoreCase("Stop")) {
               System.out.println("Chose the difficulty:\nType 1 for 1-10 number range\nType 2 for 1-100 number range\nType 3 for 1-1000 number range");
               int maxNumber = 0;

               int tries = 0;

               int playerChoice = scanner.nextInt();

                while (playerChoice > 3 || playerChoice < 1) {
                    System.out.println("Please chose a number between 1 and 3.");
                    playerChoice = scanner.nextInt();
                }

               if (playerChoice == 1) {
                   tries = 3;
                   maxNumber = 10;
                   System.out.println("The highest number I could think of is 10, how difficult could it be to guess it?");
               } else if (playerChoice == 2) {
                   tries = 6;
                   maxNumber = 100;
                   System.out.println("The highest number I could think of is 100, now we're talking business!");
               } else if (playerChoice == 3) {
                   tries = 9;
                   maxNumber = 1000;
                   System.out.println("The highest number I could think of is 1000, not even I could guess it...");
               }

               int numberToGuess = random.nextInt(1, maxNumber+1);

               while (tries > 0) {
                   System.out.println("You only have "+tries+" tries, be careful!");

                   int guess = 0;

                   while (!scanner.hasNextInt()) {
                       System.out.println("It's a NUMBER guessing game, don't even try typing letters");
                       scanner.nextLine();
                   }

                   guess = scanner.nextInt();

                   if (guess == numberToGuess) {
                       System.out.println("You've guessed correctly, congratulations!\nThe number I thought of was indeed "+numberToGuess);
                       tries = 0;
                   } else if (guess > numberToGuess) {
                       System.out.println("The number you've typed in is bigger than the one I thought of.");
                       tries --;
                   } else if (guess < numberToGuess) {
                       System.out.println("The number you've typed in is smaller than the one I thought of.");
                       tries --;
                   }
               }

               if (tries == 0) {
                   System.out.println("You don't have any more tries left, therefore you lose.\nThe number I thought of was "+numberToGuess);
               }

               System.out.println("Do you want to stop? (type in stop to stop the game fully)");
               scanner.nextLine();
           }


       }
    }
}