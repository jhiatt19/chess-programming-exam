package chess;

import java.util.ArrayList;
import java.util.Collection;

public class KingCalc implements Calc{
    private final ChessBoard board;
    private final ChessPosition position;
    private final ArrayList<ChessMove> legalMoves = new ArrayList<>();
    public KingCalc(ChessBoard board, ChessPosition position){
        this.board = board;
        this.position = position;
    }
    public Collection<ChessMove> pieceMoves(ChessPosition startPos){
        diagonalUpRight(startPos);
        diagonalDownRight(startPos);
        diagonalUpLeft(startPos);
        diagonalDownLeft(startPos);
        right(startPos);
        left(startPos);
        up(startPos);
        down(startPos);
        return legalMoves;
    }

    public void diagonalUpRight(ChessPosition startPos){
        if (startPos.getRow() < 8 && startPos.getColumn() < 8) {
            int tempR = startPos.getRow() + 1;
            int tempC = startPos.getColumn() + 1;
            ChessPosition tempPos = new ChessPosition(tempR, tempC);
            if (board.getPiece(tempPos) == null) {
                legalMoves.add(new ChessMove(position, tempPos, null));
            } else if (!board.getPiece(tempPos).getTeamColor().equals(board.getPiece(position).getTeamColor())) {
                legalMoves.add(new ChessMove(position, tempPos, null));
            }
        }
    }
    public void diagonalUpLeft(ChessPosition startPos){
        if (startPos.getRow() < 8 && startPos.getColumn() > 1) {
            int tempR = startPos.getRow() + 1;
            int tempC = startPos.getColumn() - 1;
            ChessPosition tempPos = new ChessPosition(tempR, tempC);
            if (board.getPiece(tempPos) == null) {
                legalMoves.add(new ChessMove(position,tempPos,null));
            }
            else if (!board.getPiece(tempPos).getTeamColor().equals(board.getPiece(position).getTeamColor())){
                legalMoves.add(new ChessMove(position,tempPos,null));
            }
        }
    }
    public void diagonalDownRight(ChessPosition startPos){
        if (startPos.getRow() > 1 && startPos.getColumn() < 8) {
            int tempR = startPos.getRow() - 1;
            int tempC = startPos.getColumn() + 1;
            ChessPosition tempPos = new ChessPosition(tempR, tempC);
            if (board.getPiece(tempPos) == null) {
                legalMoves.add(new ChessMove(position,tempPos,null));
            }
            else if (!board.getPiece(tempPos).getTeamColor().equals(board.getPiece(position).getTeamColor())){
                legalMoves.add(new ChessMove(position,tempPos,null));
            }
        }
    }
    public void diagonalDownLeft(ChessPosition startPos){
        if (startPos.getRow() > 1 && startPos.getColumn() > 1) {
            int tempR = startPos.getRow() - 1;
            int tempC = startPos.getColumn() - 1;
            ChessPosition tempPos = new ChessPosition(tempR, tempC);
            if (board.getPiece(tempPos) == null) {
                legalMoves.add(new ChessMove(position,tempPos,null));
            }
            else if (!board.getPiece(tempPos).getTeamColor().equals(board.getPiece(position).getTeamColor())){
                legalMoves.add(new ChessMove(position,tempPos,null));
            }
        }
    }
    public void right(ChessPosition startPos){
        if (startPos.getColumn() < 8) {
            int tempR = startPos.getRow();
            int tempC = startPos.getColumn() + 1;
            ChessPosition tempPos = new ChessPosition(tempR, tempC);
            if (board.getPiece(tempPos) == null) {
                legalMoves.add(new ChessMove(position,tempPos,null));
            }
            else if (!board.getPiece(tempPos).getTeamColor().equals(board.getPiece(position).getTeamColor())){
                legalMoves.add(new ChessMove(position,tempPos,null));
            }
        }
    }
    public void left(ChessPosition startPos){
        if (startPos.getColumn() > 1) {
            int tempR = startPos.getRow();
            int tempC = startPos.getColumn() - 1;
            ChessPosition tempPos = new ChessPosition(tempR, tempC);
            if (board.getPiece(tempPos) == null) {
                legalMoves.add(new ChessMove(position,tempPos,null));
            }
            else if (!board.getPiece(tempPos).getTeamColor().equals(board.getPiece(position).getTeamColor())){
                legalMoves.add(new ChessMove(position,tempPos,null));
            }
        }
    }
    public void up(ChessPosition startPos){
        if (startPos.getRow() < 8) {
            int tempR = startPos.getRow() + 1;
            int tempC = startPos.getColumn();
            ChessPosition tempPos = new ChessPosition(tempR, tempC);
            if (board.getPiece(tempPos) == null) {
                legalMoves.add(new ChessMove(position,tempPos,null));
            }
            else if (!board.getPiece(tempPos).getTeamColor().equals(board.getPiece(position).getTeamColor())){
                legalMoves.add(new ChessMove(position,tempPos,null));
            }
        }
    }
    public void down(ChessPosition startPos){
        if (startPos.getRow() > 1) {
            int tempR = startPos.getRow() - 1;
            int tempC = startPos.getColumn();
            ChessPosition tempPos = new ChessPosition(tempR, tempC);
            if (board.getPiece(tempPos) == null) {
                legalMoves.add(new ChessMove(position,tempPos,null));
            }
            else if (!board.getPiece(tempPos).getTeamColor().equals(board.getPiece(position).getTeamColor())){
                legalMoves.add(new ChessMove(position,tempPos,null));
            }
        }
    }
}
