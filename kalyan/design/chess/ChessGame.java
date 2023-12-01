package kalyan.design.chess;

class ChessGame {
    private Board board;
    private Player whitePlayer;
    private Player blackPlayer;
    private Player currentPlayer;

    public ChessGame(String whitePlayerName, String blackPlayerName) {
        board = new Board();
        whitePlayer = new Player(whitePlayerName, Color.WHITE);
        blackPlayer = new Player(blackPlayerName, Color.BLACK);
        currentPlayer = whitePlayer;
    }

    public void play() {
        while (true) {
            board.displayBoard();

            if (isInCheck(currentPlayer)) {
                System.out.println(currentPlayer.getName() + " is in check!");
            }

            if (isCheckmate(currentPlayer)) {
                System.out.println(currentPlayer.getName() + " is in checkmate. " +
                        (currentPlayer == whitePlayer ? blackPlayer.getName() : whitePlayer.getName()) + " wins!");
                break;
            }

            Move move = currentPlayer.makeMove();

            Square fromSquare = board.getSquare(move.getFromRow(), move.getFromCol());
            Square toSquare = board.getSquare(move.getToRow(), move.getToCol());

            if (!isValidMove(fromSquare, toSquare)) {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            // Perform the move
            toSquare.setPiece(fromSquare.getPiece());
            fromSquare.setPiece(null);

            // Switch players
            currentPlayer = (currentPlayer == whitePlayer) ? blackPlayer : whitePlayer;
        }
    }

    private boolean isValidMove(Square fromSquare, Square toSquare) {
        // Check if there is a piece on the source square
        if (fromSquare.getPiece() == null || fromSquare.getPiece().getColor() != currentPlayer.getColor()) {
            return false;
        }

        // Check if the destination square is within the board bounds
        if (toSquare == null) {
            return false;
        }

        int fromRow = fromSquare.getRow();
        int fromCol = fromSquare.getCol();
        int toRow = toSquare.getRow();
        int toCol = toSquare.getCol();

        // Get the piece and its type
        Piece piece = fromSquare.getPiece();
        PieceType type = piece.getType();

        // Check for valid moves based on piece type
        switch (type) {
            case PAWN:
                // Basic pawn move: one square forward
                if (piece.getColor() == Color.WHITE) {
                    if (fromCol == toCol && toRow == fromRow - 1 && toSquare.getPiece() == null) {
                        return true;
                    }
                } else {
                    if (fromCol == toCol && toRow == fromRow + 1 && toSquare.getPiece() == null) {
                        return true;
                    }
                }
                break;

            case KNIGHT:
                // Knights move in an "L" shape (2 squares in one direction and 1 square perpendicular)
                int rowDiff = Math.abs(toRow - fromRow);
                int colDiff = Math.abs(toCol - fromCol);
                if ((rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2)) {
                    return true;
                }
                break;

            case ROOK:
                // Rooks move horizontally or vertically
                if (fromRow == toRow || fromCol == toCol) {
                    return true;
                }
                break;

            case BISHOP:
                // Bishops move diagonally
                int rowDistance = Math.abs(toRow - fromRow);
                int colDistance = Math.abs(toCol - fromCol);
                if (rowDistance == colDistance) {
                    return true;
                }
                break;

            // Add validation logic for other piece types

            default:
                return false; // Unknown piece type
        }

        return false; // Default case, invalid move
    }

    private boolean isInCheck(Player player) {
        // Find the king's position on the board
        Square kingSquare = findKingSquare(player.getColor());

        // Check if any opponent's piece can attack the king's square
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Square opponentSquare = board.getSquare(row, col);
                Piece opponentPiece = opponentSquare.getPiece();

                if (opponentPiece != null && opponentPiece.getColor() != player.getColor()) {
                    Move move = new Move(row, col, kingSquare.getRow(), kingSquare.getCol());
                    if (isValidMove(opponentSquare, kingSquare) && isMoveLegal(opponentPiece, move)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean isCheckmate(Player player) {
        // Checkmate occurs when the king is in check, and there are no legal moves to get out of check
        if (isInCheck(player)) {
            for (int fromRow = 0; fromRow < 8; fromRow++) {
                for (int fromCol = 0; fromCol < 8; fromCol++) {
                    Square fromSquare = board.getSquare(fromRow, fromCol);
                    Piece piece = fromSquare.getPiece();

                    if (piece != null && piece.getColor() == player.getColor()) {
                        for (int toRow = 0; toRow < 8; toRow++) {
                            for (int toCol = 0; toCol < 8; toCol++) {
                                Square toSquare = board.getSquare(toRow, toCol);
                                Move move = new Move(fromRow, fromCol, toRow, toCol);

                                if (isValidMove(fromSquare, toSquare) && isMoveLegal(piece, move)) {
                                    // Try the move and check if the king is still in check
                                    Square originalToSquare = toSquare.getPiece() == null ? null : new Square(toRow, toCol);
                                    toSquare.setPiece(fromSquare.getPiece());
                                    fromSquare.setPiece(null);

                                    boolean kingInCheck = isInCheck(player);

                                    // Undo the move
                                    fromSquare.setPiece(toSquare.getPiece());
                                    if (originalToSquare != null) {
                                        toSquare.setPiece(originalToSquare.getPiece());
                                    }

                                    if (!kingInCheck) {
                                        return false; // There is at least one legal move to get out of check
                                    }
                                }
                            }
                        }
                    }
                }
            }

            return true; // No legal moves to get out of check
        }

        return false; // The player is not in check
    }

    private boolean isMoveLegal(Piece piece, Move move) {
        // Add specific move legality checks based on the rules of each piece
        // This is a simplified version and may need enhancement based on chess rules
        switch (piece.getType()) {
            case PAWN:
                // Add pawn move legality checks
                break;
            case KING:
                // Add king move legality checks
                break;
            // Add legality checks for other piece types
        }

        return true; // Default case, assuming all moves are legal
    }

    private Square findKingSquare(Color color) {
        // Find and return the square containing the king of the specified color
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Square square = board.getSquare(row, col);
                Piece piece = square.getPiece();
                if (piece != null && piece.getType() == PieceType.KING && piece.getColor() == color) {
                    return square;
                }
            }
        }
        return null; // Should not happen in a valid game
    }
}

