package kalyan.design.chess;

import java.util.Scanner;


public class ChessGameApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Player 1's name: ");
        String player1Name = scanner.nextLine();

        System.out.print("Enter Player 2's name: ");
        String player2Name = scanner.nextLine();

        ChessGame chessGame = new ChessGame(player1Name, player2Name);
        chessGame.play();

        scanner.close();
    }
}
