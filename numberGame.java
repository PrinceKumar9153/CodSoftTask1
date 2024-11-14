package Source;

import java.util.*;

public class numberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean playingGames = true;
        int score = 0;
        int highestScore = 10;

        System.out.println("Welcome to the Number Guessing Game!");
        
        while (playingGames) {
            
            Random random = new Random();
            int numberToGuess = random.nextInt(100) + 1;
            int max = 10; 
            int min = 0;
            boolean guessedCorrect = false;

            System.out.println("New Round!I'm thinking of a number between 1 and 100.");
            System.out.println("You have " + max + " attempts to guess the correct number.");

            while (min < max && !guessedCorrect) {
                System.out.print("Enter your guess: ");
                int user = sc.nextInt();
                min++;

                if (user > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else if (user < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Congratulations!");
                    System.out.println("You guessed the correct number: " + numberToGuess);
                    guessedCorrect = true;
                    score++;
                    highestScore += (max - min + 1);
                }

                if (min == max && !guessedCorrect) {
                    System.out.println("Sorry, you're out of attempts! The correct number was: " + numberToGuess);
                }
            }

            System.out.print("Would you like to play another round? (Yes / No):");
            playingGames = sc.next().equalsIgnoreCase("yes");
        }

        System.out.println("Game Over!");
        System.out.println("Total rounds won : " + score);
        Random g = new Random();
        int highScore = g.nextInt(highestScore - score + 1) + score;
        System.out.println("Total score : " + highScore);
    }
}
