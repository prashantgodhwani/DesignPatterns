package Examples.Chess.models;

import Examples.Chess.exceptions.InvalidMoveException;
import Examples.Chess.models.piece.Piece;
import Examples.TicTacToe.models.Player;

public class Board {
    
    private Block[][] blocks;
    
    public Board(int size){
        blocks = new Block[size][size];
        initializeBoard();
    }

    private void initializeBoard() {
    }

    public Block getBlock(Location location){
        return blocks[location.getX()][location.getY()];
    }
}
