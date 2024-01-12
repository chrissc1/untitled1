import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Your name: ");
        String newName = scan.nextLine();
        GameEngine game = new GameEngine(newName);
        game.startGame();
    }
}