package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/**
 * Represents a single chess piece
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessPiece {
    private final ChessGame.TeamColor pieceColor;
    private final ChessPiece.PieceType type;
    public ChessPiece(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type) {
        this.pieceColor = pieceColor;
        this.type = type;
    }

    /**
     * The various different chess piece options
     */
    public enum PieceType {
        KING,
        QUEEN,
        BISHOP,
        KNIGHT,
        ROOK,
        PAWN
    }

    /**
     * @return Which team this chess piece belongs to
     */
    public ChessGame.TeamColor getTeamColor() {
        return pieceColor;
    }

    /**
     * @return which type of chess piece this piece is
     */
    public PieceType getPieceType() {
        return type;
    }

    /**
     * Calculates all the positions a chess piece can move to
     * Does not take into account moves that are illegal due to leaving the king in
     * danger
     *
     * @return Collection of valid moves
     */
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        if (board.getPiece(myPosition).getPieceType().equals(PieceType.KING)) {
            return new KingCalc(board, myPosition).pieceMoves(myPosition);
        } else if (board.getPiece(myPosition).getPieceType().equals(PieceType.QUEEN)) {
            return new QueenCalc(board, myPosition).pieceMoves(myPosition);
        } else if (board.getPiece(myPosition).getPieceType().equals(PieceType.BISHOP)) {
            return new BishopCalc(board, myPosition).pieceMoves(myPosition);
        }
        else if (board.getPiece(myPosition).getPieceType().equals(PieceType.KNIGHT)) {
            return new KnightCalc(board, myPosition).pieceMoves(myPosition);
        }
        else if (board.getPiece(myPosition).getPieceType().equals(PieceType.ROOK)) {
            return new RookCalc(board, myPosition).pieceMoves(myPosition);
        }
        else if (board.getPiece(myPosition).getPieceType().equals(PieceType.PAWN)) {
            return new PawnCalc(board, myPosition).pieceMoves(myPosition);
        }
        return new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChessPiece that = (ChessPiece) o;
        return pieceColor == that.pieceColor && type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pieceColor, type);
    }
}
