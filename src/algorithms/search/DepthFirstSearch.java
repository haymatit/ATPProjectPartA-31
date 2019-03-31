package algorithms.search;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class DepthFirstSearch extends ASearchingAlgorithm{
    Stack<AState> stack= new Stack<>();
    HashSet<AState> visited = new HashSet<>();
    private AState[][] prev;
    private AState lastNode;

    public DepthFirstSearch() {
        super("Depth First Search");
    }

    public Solution solve(ISearchable s){
        Solution sol=new Solution();
        stack.push(s.getStartState());
        while(!stack.isEmpty()) {
            AState tmp = stack.pop();
            visited.add(tmp);


        }
        return sol;
    }

    private boolean DFSrecursive(ISearchable s,Solution sol,AState current){
        if(neighboorsUnVisited(s.getAllPossibleStates(current)))
            return false;
        if(current.equals(s.getEndState()))
            return true;


    }

    private boolean neighboorsUnVisited(ArrayList<AState> listNeighboors){
        for (AState state:listNeighboors) {
            if(visited.contains(state))
                return true;
        }
        return false;
    }

}
