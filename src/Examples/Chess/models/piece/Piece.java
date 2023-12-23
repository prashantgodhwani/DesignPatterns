package Examples.Chess.models.piece;

import Examples.Chess.models.Location;
import Examples.Chess.models.Move;
import Examples.Chess.models.PieceColor;
import Examples.Chess.models.PieceType;
import Examples.TicTacToe.models.Player;

public abstract class Piece {

    private PieceType pieceType;

    private PieceColor pieceColor;

    private boolean inPlay;

    Piece(PieceType pieceType, PieceColor pieceColor){
        this.pieceType = pieceType;
        this.pieceColor = pieceColor;
        this.inPlay = true;
    }

    public abstract Move validate(Location from, Location to, Player player);

    public void eliminate(){
        this.inPlay = false;
    }
}
