package Examples.TicTacToe.models;

import Examples.TicTacToe.models.piece.PlayingPiece;

public class Player {

    private final String name;

    private final PlayingPiece playingPiece;


    public Player(String name, PlayingPiece playingPiece) {
        this.name = name;
        this.playingPiece = playingPiece;
    }

    public PlayingPiece getPlayingPiece() {
        return playingPiece;
    }

    public String getName() {
        return name;
    }
}
