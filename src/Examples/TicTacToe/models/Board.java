package Examples.TicTacToe.models;

import Examples.TicTacToe.exceptions.WinnerFoundException;
import Examples.TicTacToe.models.piece.PieceType;
import Examples.TicTacToe.models.piece.PlayingPiece;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final int size;

    private final PlayingPiece[][] board;

    private int[] rowCount;

    private int[] colCount;

    private int rDiagCount;

    private int lDiagCount;

    public Board(int size) {
        this.size = size;
        this.board = new PlayingPiece[size][size];
        this.rowCount = new int[size];
        this.colCount = new int[size];
        rDiagCount = 0;
        lDiagCount = 0;
    }

    public List<int[]> getFrePositions(){
        List<int[]> res = new ArrayList<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j] == null){
                    res.add(new int[]{i, j});
                }
            }
        }

        return res;
    }

    public void playTurn(int r, int c, PlayingPiece playingPiece){
        if(r < 0 || c < 0 || r > board.length || c > board.length) throw new RuntimeException("Invalid config exception");
        if(board[r][c] != null) throw new RuntimeException("Position already used exception");
        processTurn(r, c, playingPiece);
    }

    private void processTurn(int row, int col, PlayingPiece playingPiece){
        board[row][col] = playingPiece;
        checkIfWinner(row, col, playingPiece);
    }

    private void checkIfWinner(int row, int col, PlayingPiece playingPiece){
        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        //need to check in row
        for(int i = 0; i < this.size;i ++) {

            if(board[row][i] == null || board[row][i].getPieceType() != playingPiece.getPieceType()) {
                rowMatch = false;
            }
        }

        //need to check in column
        for(int i=0;i<size; i++) {

            if(board[i][col] == null || board[i][col].getPieceType() != playingPiece.getPieceType()) {
                columnMatch = false;
            }
        }

        //need to check diagonals
        for(int i=0, j=0; i<size;i++,j++) {
            if (board[i][j] == null || board[i][j].getPieceType() != playingPiece.getPieceType()) {
                diagonalMatch = false;
            }
        }

        //need to check anti-diagonals
        for(int i=0, j=size-1; i<size;i++,j--) {
            if (board[i][j] == null || board[i][j].getPieceType() != playingPiece.getPieceType()) {
                antiDiagonalMatch = false;
            }
        }

        if(rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch) throw new WinnerFoundException();

    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j].getPieceType().name() + "   ");
                } else {
                    System.out.print("    ");
                }
                System.out.print(" | ");
            }
            System.out.println();
        }
    }
}
