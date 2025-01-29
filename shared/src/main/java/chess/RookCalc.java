package chess;

import java.util.ArrayList;
import java.util.Collection;

public class RookCalc implements Calc{
    private final ChessBoard board;
    private final ChessPosition position;
    private final ArrayList<ChessMove> legalMoves = new ArrayList<>();
    public RookCalc(ChessBoard board, ChessPosition position){
        this.board = board;
        this.position = position;
    }
    public Collection<ChessMove> pieceMoves(ChessPosition startPos){
        up(startPos);
        down(startPos);
        left(startPos);
        right(startPos);
        return legalMoves;
    }

    public Collection<ChessMove> right(ChessPosition startPos){
        if (startPos.getColumn() < 8) {
            int tempR = startPos.getRow();
            int tempC = startPos.getColumn() + 1;
            ChessPosition tempPos = new ChessPosition(tempR, tempC);
            if (board.getPiece(tempPos) == null) {
                legalMoves.add(new ChessMove(position,tempPos,null));
                return right(tempPos);
            }
            else if (!board.getPiece(tempPos).getTeamColor().equals(board.getPiece(position).getTeamColor())){
                legalMoves.add(new ChessMove(position,tempPos,null));
            }
        }
        return legalMoves;
    }
    public Collection<ChessMove> left(ChessPosition startPos){
        if (startPos.getColumn() > 1) {
            int tempR = startPos.getRow();
            int tempC = startPos.getColumn() - 1;
            ChessPosition tempPos = new ChessPosition(tempR, tempC);
            if (board.getPiece(tempPos) == null) {
                legalMoves.add(new ChessMove(position,tempPos,null));
                return left(tempPos);
            }
            else if (!board.getPiece(tempPos).getTeamColor().equals(board.getPiece(position).getTeamColor())){
                legalMoves.add(new ChessMove(position,tempPos,null));
            }
        }
        return legalMoves;
    }
    public Collection<ChessMove> up(ChessPosition startPos){
        if (startPos.getRow() < 8) {
            int tempR = startPos.getRow() + 1;
            int tempC = startPos.getColumn();
            ChessPosition tempPos = new ChessPosition(tempR, tempC);
            if (board.getPiece(tempPos) == null) {
                legalMoves.add(new ChessMove(position,tempPos,null));
                return up(tempPos);
            }
            else if (!board.getPiece(tempPos).getTeamColor().equals(board.getPiece(position).getTeamColor())){
                legalMoves.add(new ChessMove(position,tempPos,null));
            }
        }
        return legalMoves;
    }
    public Collection<ChessMove> down(ChessPosition startPos){
        if (startPos.getRow() > 1) {
            int tempR = startPos.getRow() - 1;
            int tempC = startPos.getColumn();
            ChessPosition tempPos = new ChessPosition(tempR, tempC);
            if (board.getPiece(tempPos) == null) {
                legalMoves.add(new ChessMove(position,tempPos,null));
                return down(tempPos);
            }
            else if (!board.getPiece(tempPos).getTeamColor().equals(board.getPiece(position).getTeamColor())){
                legalMoves.add(new ChessMove(position,tempPos,null));
            }
        }
        return legalMoves;
    }
}

