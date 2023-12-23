package Examples.TicTacToe;

import Examples.TicTacToe.exceptions.WinnerFoundException;
import Examples.TicTacToe.models.Board;
import Examples.TicTacToe.models.Player;
import Examples.TicTacToe.models.piece.CrossPlayingPiece;
import Examples.TicTacToe.models.piece.PieceType;
import Examples.TicTacToe.models.piece.RoundPlayingPiece;

import java.util.*;

public class TicTacToe {

    private Deque<Player> players;

    private Board board;

    private Set<PieceType> usedPieceTypes;

    private static Scanner sc = new Scanner(System.in);

    TicTacToe(int size){
        board = new Board(size);
        players = new ArrayDeque<>();
        usedPieceTypes = new HashSet<>();
    }

    public boolean addPlayer(String name, PieceType pieceType){
        if(usedPieceTypes.contains(pieceType)) return false;
        players.add(new Player(name, (pieceType.equals(PieceType.X)) ? new CrossPlayingPiece() : new RoundPlayingPiece()));
        return true;
    }

    public void startGame(){
        boolean noWinner = true;

        while(noWinner){
            Player currentPlayer = players.removeFirst();

            List<int[]> freeSpots = board.getFrePositions();
            if(freeSpots.isEmpty()) {
                noWinner = false;
                continue;
            }

            System.out.println("Turn for Player: " + currentPlayer.getName());
            board.printBoard();
            System.out.println("Enter coordinates (x, y)");
            int x = sc.nextInt();
            int y = sc.nextInt();

            try{
                board.playTurn(x, y, currentPlayer.getPlayingPiece());
            }catch (WinnerFoundException ex){
                System.out.println("*************************************************");
                System.out.println(currentPlayer.getName() + " is the winner");
                System.out.println("*************************************************");
                return;
            } catch (RuntimeException runtimeException){
                System.out.println("Invalid configuration chosen. Choose again");
                players.addFirst(currentPlayer);
                continue;
            }

            players.addLast(currentPlayer);
        }

        System.out.println("Game tied !!");
    }
}
