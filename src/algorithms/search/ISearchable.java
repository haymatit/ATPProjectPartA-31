package algorithms.search;

import java.util.ArrayList;

public interface ISearchable {
    public AState getStartState();
    public AState getEndState();
    public ArrayList<AState> getAllPossibleStates(AState state);
}
