package Examples.Chess.models;

import Examples.Chess.exceptions.InvalidMoveException;
import Examples.Chess.models.piece.Piece;
import Examples.TicTacToe.models.Player;

import java.util.ArrayList;
import java.util.List;

public class ChessGame {

    private Board board;

    private Player player1;

    private Player player2;

    private GameStatus gameStatus;

    private List<Move> moveList;

    private Player turn;

    private List<Piece> eliminatedPieces;

    private static ChessGame chessGameInstance = null;

    private ChessGame(Player player1, Player player2){
        this.board = new Board(8);
        this.player1 = player1;
        this.player2 = player2;
        this.gameStatus = GameStatus.ACTIVE;
        this.moveList = new ArrayList<>();
        this.turn = player1;
        this.eliminatedPieces = new ArrayList<>();
    }

    public ChessGame getInstance(Player player1, Player player2){
       if(chessGameInstance == null){
           chessGameInstance = new ChessGame(player1, player2);
       }
       return chessGameInstance;
    }

    public void makeMove(Location from, Location to, Player player){
        Block blockAtStart = board.getBlock(from);
        Block blockAtEnd = board.getBlock(to);
        Piece pieceAtStart = blockAtStart.getPiece();
        try{
            pieceAtStart.validate(from, to, player);
            blockAtStart.unassignPiece();
            Piece piece = blockAtEnd.assignPiece(pieceAtStart);
            if(piece != null){
                piece.eliminate();
                this.eliminatedPieces.add(piece);
            }
            this.moveList.add(new Move(from, to, player));
        }catch (InvalidMoveException exception){
            System.out.println("Invalid Move : " + exception.getMessage());
        }
    }

    private void play(){
        while(true){

        }
    }
}
