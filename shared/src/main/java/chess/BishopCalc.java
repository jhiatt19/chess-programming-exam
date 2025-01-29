package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class BishopCalc implements Calc{
    private final ChessBoard board;
    private final ChessPosition position;
    private final ArrayList<ChessMove> legalMoves = new ArrayList<>();
    public BishopCalc(ChessBoard board, ChessPosition position){
        this.board = board;
        this.position = position;
    }
    public Collection<ChessMove> pieceMoves(ChessPosition startPos){
        diagonalUpRight(startPos);
        diagonalDownRight(startPos);
        diagonalUpLeft(startPos);
        diagonalDownLeft(startPos);
        return legalMoves;
    }

    public Collection<ChessMove> diagonalUpRight(ChessPosition startPos){
        if (startPos.getRow() < 8 && startPos.getColumn() < 8) {
            int tempR = startPos.getRow() + 1;
            int tempC = startPos.getColumn() + 1;
            ChessPosition tempPos = new ChessPosition(tempR, tempC);
            if (board.getPiece(tempPos) == null) {
                legalMoves.add(new ChessMove(position,tempPos,null));
                return diagonalUpRight(tempPos);
            }
            else if (!board.getPiece(tempPos).getTeamColor().equals(board.getPiece(position).getTeamColor())){
                legalMoves.add(new ChessMove(position,tempPos,null));
            }
        }
        return legalMoves;
    }
    public Collection<ChessMove> diagonalUpLeft(ChessPosition startPos){
        if (startPos.getRow() < 8 && startPos.getColumn() > 1) {
            int tempR = startPos.getRow() + 1;
            int tempC = startPos.getColumn() - 1;
            ChessPosition tempPos = new ChessPosition(tempR, tempC);
            if (board.getPiece(tempPos) == null) {
                legalMoves.add(new ChessMove(position,tempPos,null));
                return diagonalUpLeft(tempPos);
            }
            else if (!board.getPiece(tempPos).getTeamColor().equals(board.getPiece(position).getTeamColor())){
                legalMoves.add(new ChessMove(position,tempPos,null));
            }
        }
        return legalMoves;
    }
    public Collection<ChessMove> diagonalDownRight(ChessPosition startPos){
        if (startPos.getRow() > 1 && startPos.getColumn() < 8) {
            int tempR = startPos.getRow() - 1;
            int tempC = startPos.getColumn() + 1;
            ChessPosition tempPos = new ChessPosition(tempR, tempC);
            if (board.getPiece(tempPos) == null) {
                legalMoves.add(new ChessMove(position,tempPos,null));
                return diagonalDownRight(tempPos);
            }
            else if (!board.getPiece(tempPos).getTeamColor().equals(board.getPiece(position).getTeamColor())){
                legalMoves.add(new ChessMove(position,tempPos,null));
            }
        }
        return legalMoves;
    }
    public Collection<ChessMove> diagonalDownLeft(ChessPosition startPos){
        if (startPos.getRow() > 1 && startPos.getColumn() > 1) {
            int tempR = startPos.getRow() - 1;
            int tempC = startPos.getColumn() - 1;
            ChessPosition tempPos = new ChessPosition(tempR, tempC);
            if (board.getPiece(tempPos) == null) {
                legalMoves.add(new ChessMove(position,tempPos,null));
                return diagonalDownLeft(tempPos);
            }
            else if (!board.getPiece(tempPos).getTeamColor().equals(board.getPiece(position).getTeamColor())){
                legalMoves.add(new ChessMove(position,tempPos,null));
            }
        }
        return legalMoves;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BishopCalc that = (BishopCalc) o;
        return Objects.equals(board, that.board) && Objects.equals(position, that.position) && Objects.equals(legalMoves, that.legalMoves);
    }

    @Override
    public int hashCode() {
        return Objects.hash(board, position, legalMoves);
    }
}

