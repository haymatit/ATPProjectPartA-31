package algorithms.search;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

import java.util.ArrayList;

public class SearchableMaze implements ISearchable{
    Maze grid;
    MazeState[][] states;
    int StartRow;
    int StartCol;
    int EndRow;
    int EndCol;

    public SearchableMaze(Maze m) {
        this.grid=m;
        StartRow=grid.getStartPosition().getRowIndex();
        StartCol=grid.getStartPosition().getColumnIndex();
        EndRow=grid.getGoalPosition().getRowIndex();
        EndCol=grid.getGoalPosition().getColumnIndex();
        states=new MazeState[grid.getRowSize()][grid.getColSize()];
        for (int i=0;i<grid.getRowSize();i++){
            for(int j=0;j<grid.getColSize();j++)
                states[i][j]=new MazeState(new Position(i,j));
        }
    }

    @Override
    public AState getStartState() {
        return states[StartRow][StartCol];
    }

    @Override
    public AState getEndState() {
        return states[EndRow][EndCol];
    }

    @Override
    public ArrayList<AState> getAllPossibleStates(AState state) {
        MazeState currentM=(MazeState)state;
        Position currentP=currentM.getCurrentPosition();
        ArrayList<AState> neighboors=new ArrayList<>();
        int i=currentP.getRowIndex();
        int j=currentP.getColumnIndex();
        if(addToList(neighboors,i-1,j)) {
            addToList(neighboors, i - 1, j - 1);
            addToList(neighboors, i - 1, j + 1);
        }
        if(addToList(neighboors,i+1,j)){
            addToList(neighboors,i+1,j-1);
            addToList(neighboors,i+1,j+1);
        }
        if(addToList(neighboors,i,j-1)){
            addToList(neighboors,i+1,j-1);
            addToList(neighboors,i-1,j-1);
        }
        if(addToList(neighboors,i,j+1)){
            addToList(neighboors,i+1,j+1);
            addToList(neighboors,i-1,j+1);
        }
        return neighboors;
    }

    private boolean addToList(ArrayList<AState> neighboors,int i, int j){
        if(i<0||j<0||i>=grid.getRowSize()||j>=grid.getColSize())
            return false;
        else if(grid.getPositionType(i,j)==0) {
            neighboors.add(new MazeState(new Position(i, j)));
            return true;
        }
        return false;
    }

}
