package algorithms.search;

import algorithms.mazeGenerators.Position;

public class MazeState extends AState{
    private Position current;
    private Position cameFrom;
    private int cost;

    public MazeState(Position current, Position cameFrom, int cost) {
        this.current = current;
        this.cameFrom = cameFrom;
        this.cost = 1;
    }
}
