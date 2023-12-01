package kalyan.design.chess;

class Board {
    private Square[][] squares;

    public Board() {
        squares = new Square[8][8];
        initializeBoard();
    }

    private void initializeBoard() {
        // Initialize pieces on the board
        squares[0][0] = new Square(0, 0);
        squares[0][0].setPiece(new Piece(PieceType.ROOK, Color.BLACK));

        // ... (initialize other pieces)

        squares[7][7] = new Square(7, 7);
        squares[7][7].setPiece(new Piece(PieceType.ROOK, Color.WHITE));
    }

    public Square getSquare(int row, int col) {
        return squares[row][col];
    }

    public void displayBoard() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                System.out.print(squares[row][col] + "\t");
            }
            System.out.println();
        }
    }
}
