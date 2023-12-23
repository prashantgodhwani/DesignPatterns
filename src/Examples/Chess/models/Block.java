package Examples.Chess.models;


import Examples.Chess.exceptions.NoPieceAllocationException;
import Examples.Chess.models.piece.Piece;

public class Block {

    private Piece piece;

    private final Location location;

    Block(Location location){
        this.location = location;
    }

    public Piece getPiece(){
        return this.piece;
    }

    public Location getLocation() {
        return location;
    }

    public Piece assignPiece(Piece piece){
        Piece rpiece = null;
        if(this.piece != null)
            rpiece = piece;
        this.piece = piece;
        return rpiece;
    }

    public void unassignPiece(){
        if(piece != null){
            this.piece = null;
        }
        throw new NoPieceAllocationException();
    }


}
