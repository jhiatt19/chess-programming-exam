package chess;

import java.util.Collection;

public interface Calc {
    Collection<ChessMove> pieceMoves(ChessPosition position);
}
