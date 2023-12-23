package Examples.TicTacToe;

import Examples.TicTacToe.models.piece.PieceType;

public class Demo {

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe(3);
        ticTacToe.addPlayer("Prashant", PieceType.X);
        ticTacToe.addPlayer("Sam", PieceType.O);

        ticTacToe.startGame();
    }
}
