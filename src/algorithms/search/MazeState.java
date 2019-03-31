package algorithms.search;

import algorithms.mazeGenerators.Position;

import java.util.ArrayList;
import java.util.Objects;

public class MazeState extends AState{
    private Position current;
    private int cost;

    public MazeState(Position current) {
        super(cameFrom);
        this.current = current;
        this.cost = 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MazeState mState = (MazeState) o;
        return current.equals(mState.current);
    }
}
