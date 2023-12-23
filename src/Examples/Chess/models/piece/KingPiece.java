package Examples.Chess.models.piece;

import Examples.Chess.models.Location;
import Examples.Chess.models.Move;
import Examples.Chess.models.PieceColor;
import Examples.Chess.models.PieceType;
import Examples.TicTacToe.models.Player;

public class KingPiece extends Piece{
    KingPiece(PieceColor pieceColor) {
        super(PieceType.KING, pieceColor);
    }

    @Override
    public Move validate(Location from, Location to, Player player) {
        //verify move
        return new Move(from, to, player);
    }
}
