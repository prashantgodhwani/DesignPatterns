package Examples.Chess.models;

import Examples.TicTacToe.models.Player;

public class Move {

    private final Location from;

    private final Location to;

    private final Player player;


    public Move(Location from, Location to, Player player) {
        this.from = from;
        this.to = to;
        this.player = player;
    }
}
