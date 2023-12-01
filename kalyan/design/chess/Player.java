package kalyan.design.chess;

import java.util.Scanner;

class Player {
    private String name;
    private Color color;

    public Player(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public Move makeMove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(name + ", enter your move (e.g., A2 to B4): ");
        String moveString = scanner.nextLine().toUpperCase();

        int fromCol = moveString.charAt(0) - 'A';
        int fromRow = Character.getNumericValue(moveString.charAt(1)) - 1;
        int toCol = moveString.charAt(3) - 'A';
        int toRow = Character.getNumericValue(moveString.charAt(4)) - 1;

        return new Move(fromRow, fromCol, toRow, toCol);
    }
}
