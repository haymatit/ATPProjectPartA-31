package algorithms.search;

import algorithms.mazeGenerators.Position;

import java.util.ArrayList;

public class MazeState extends AState{
    private Position current;
    private int cost;

    public MazeState(Position current) {
        super(cameFrom);
        this.current = current;
        this.cost = 1;
    }


}
