package week1;

import java.util.Random;
import java.util.Scanner;

public class WordGuessingGame {
    public static void main(String[] args) {
        String[] words = {"apple", "banana", "cherry", "grape", "mango"};
        Random random = new Random();
        String chosenWord = words[random.nextInt(words.length)];
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the Word Guessing Game!");
        System.out.println("Try to guess the word. You have 5 attempts.");
        
        int attempts = 5;
        boolean guessedCorrectly = false;
        
        while (attempts > 0) {
            System.out.print("Enter your guess: ");
            String guess = scanner.nextLine().toLowerCase();
            
            if (guess.equals(chosenWord)) {
                System.out.println("Congratulations! You guessed the word!");
                guessedCorrectly = true;
                break;
            } else if (guess.compareTo(chosenWord) < 0) {
                System.out.println("The word is later in the dictionary.");
            } else {
                System.out.println("The word is earlier in the dictionary.");
            }
            
            attempts--;
            System.out.println("Attempts left: " + attempts);
        }
        
        if (!guessedCorrectly) {
            System.out.println("You've used all attempts. The correct word was: " + chosenWord);
        }
        
        scanner.close();
    }
}

