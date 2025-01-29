package chess;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * A chessboard that can hold and rearrange chess pieces.
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessBoard {
    private ChessPiece[][] squares = new ChessPiece[9][9];
    public ChessBoard() {
    }

    /**
     * Adds a chess piece to the chessboard
     *
     * @param position where to add the piece to
     * @param piece    the piece to add
     */
    public void addPiece(ChessPosition position, ChessPiece piece) {
        squares[position.getRow()][position.getColumn()] = piece;
    }

    /**
     * Gets a chess piece on the chessboard
     *
     * @param position The position to get the piece from
     * @return Either the piece at the position, or null if no piece is at that
     * position
     */
    public ChessPiece getPiece(ChessPosition position) {
        return squares[position.getRow()][position.getColumn()];
    }

    /**
     * Sets the board to the default starting board
     * (How the game of chess normally starts)
     */
    public void resetBoard() {
        for (int i = 1; i < 9; i++){
            for (int j = 1; j < 9; j++){
                if (i == 1) {
                    if (j == 1 || j == 8) {
                        addPiece(new ChessPosition(i, j), new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.ROOK));
                    } else if (j == 2 || j == 7) {
                        addPiece(new ChessPosition(i, j), new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.KNIGHT));
                    } else if (j == 3 || j == 6) {
                        addPiece(new ChessPosition(i, j), new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.BISHOP));
                    } else if (j == 4) {
                        addPiece(new ChessPosition(i, j), new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.QUEEN));
                    } else {
                        addPiece(new ChessPosition(i, j), new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.KING));
                    }
                }
                else if (i == 2){
                    addPiece(new ChessPosition(i,j), new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.PAWN));
                }
                else if (i == 7){
                    addPiece(new ChessPosition(i,j), new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.PAWN));
                }
                else if (i == 8) {
                    if (j == 1 || j == 8) {
                        addPiece(new ChessPosition(i, j), new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.ROOK));
                    } else if (j == 2 || j == 7) {
                        addPiece(new ChessPosition(i, j), new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.KNIGHT));
                    } else if (j == 3 || j == 6) {
                        addPiece(new ChessPosition(i, j), new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.BISHOP));
                    } else if (j == 4) {
                        addPiece(new ChessPosition(i, j), new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.QUEEN));
                    } else if (j == 5) {
                        addPiece(new ChessPosition(i, j), new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.KING));
                    }
                }
                else{
                    squares[i][j] = null;
                }
                //System.out.println(i + " " + j + ": " + squares[i][j]);
            }
        }

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChessBoard that = (ChessBoard) o;
        return Objects.deepEquals(squares, that.squares);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(squares);
    }
}
