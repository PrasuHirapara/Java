import Project.TicTacToe.TicTacToe;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Choose mode: \n\t(1) Local 1v1 \n\t(2) Online \n\t(q) Quit");
            String choice = sc.next().trim().toLowerCase();
            if (choice.equals("1")) {
                game.play1V1();
            } else if (choice.equals("2")) {
                game.playOnline();
            } else if (choice.equals("q")) {
                System.out.println("Thank you for playing!");
                break;
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }

        sc.close();
    }
}
