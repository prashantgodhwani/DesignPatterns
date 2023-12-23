package Examples.TicTacToe.models.piece;

public class PlayingPiece {

    PieceType pieceType;

    PlayingPiece(PieceType pieceType){
        this.pieceType = pieceType;
    }

    public PieceType getPieceType() {
        return pieceType;
    }
}
