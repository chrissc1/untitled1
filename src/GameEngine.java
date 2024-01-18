import java.util.Scanner;

public class GameEngine {
    private MarbleManager marbleManager;
    private Scanner scanner;
    private String name;
    private int score;

    public GameEngine(String name) {
        this.name = name;
        this.marbleManager = new MarbleManager();
        this.scanner = new Scanner(System.in);
        this.score = 0;
    }

    public void startGame() {
        boolean playAgain = true;

        while (playAgain) {
            displayRules();
            while (!marbleManager.hasGuessedCorrectly()) {
                System.out.print("Enter your guess: ");
                int userGuess = getUserInput();
                marbleManager.processGuess(userGuess);
            }

            displayStats(); // Display player statistics after each game

            System.out.println("Do you want to play again? y / n");
            playAgain = scanner.next().equalsIgnoreCase("y");

            if (playAgain) {
                marbleManager.resetGame();
                updateScore(); // Update score if the player chooses to play again
            }
        }

        displayScore();
    }

    public void displayRules() {
        System.out.println("Welcome " + name + " to the Marble Guessing Game!");
        System.out.println("I have a random number of marbles. Can you guess how many?");
    }

    public int getUserInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid integer.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private void updateScore() {
        score += 10; // Increment the score after each successful guess
    }

    private void displayScore() {
        System.out.println("\u001B[33mYour final score: \u001B[0m" + score);
    }

    private void displayStats() {
        System.out.println("-------------Stats-------------");
        System.out.println("\u001B[32mCorrect Guesses: \u001B[0m" + marbleManager.getRights());
        System.out.println("\u001B[31mIncorrect Guesses: \u001B[0m" + marbleManager.getWrong());
        System.out.println("\u001B[32mYou went \u001B[0m" + marbleManager.posOrNeg());
        System.out.println("\u001B[32mYou have a score of: \u001B[0m" + score + "!");
    }
}
