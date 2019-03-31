package algorithms.search;
import algorithms.mazeGenerators.Maze;
import java.util.ArrayList;

public class SearchableMaze implements ISearchable{
    Maze grid;
    MazeState start;
    MazeState end;

    public SearchableMaze(Maze m) {
        this.grid=m;
        this.start=new MazeState(grid.getStartPosition());
        this.end= new MazeState(grid.getGoalPosition());
    }

    @Override
    public AState getStartState() {
        return start;
    }

    @Override
    public AState getEndState() {
        return end;
    }

    @Override
    public ArrayList<AState> getAllPossibleStates(AState state) {
        return null;
    }

    @Override
    public boolean stateEquals(AState a1, AState a2) {//?

        return false;
    }
}
