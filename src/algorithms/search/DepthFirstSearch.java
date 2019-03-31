package algorithms.search;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class DepthFirstSearch extends ASearchingAlgorithm{
    Stack<AState> stack= new Stack<>();
    HashSet<AState> visited = new HashSet<>();

    public DepthFirstSearch() {
        super("Depth First Search");
    }

    public Solution solve(ISearchable s){
        Solution sol=new Solution();
        stack.push(s.getStartState());
        while(!stack.isEmpty()) {
            AState tmp = stack.pop();
            visited.add(tmp);
            if (tmp.equals(s.getEndState()))
                break;
            for(AState node : s.getAllPossibleStates(tmp)) {
                if (!visited.contains(node)) {
                    stack.push(node);
                    node.setCameFrom(tmp);
                }
            }
        }
        AState skipper=s.getEndState();
        while(skipper!=null) {
            sol.addToPath(skipper);
            skipper=skipper.getCameFrom();
        }
        return sol;
    }

    private boolean DFSrecursive(ISearchable s,AState current){
        ArrayList<AState> possibleStates=neighboorsUnVisited(s.getAllPossibleStates(current));
        if(current.equals(s.getEndState())) {
            stack.push(current);
            return true;
        }
        if(possibleStates.isEmpty())
            return false;
        visited.add(current);
        stack.push(current);
        boolean flag=false;
        for (AState next:possibleStates) {
            if (DFSrecursive(s, next))
                flag = true;
        }
        if(flag==false)
            stack.pop();
        return flag;
    }

    private ArrayList<AState> neighboorsUnVisited(ArrayList<AState> listNeighboors){
        if(listNeighboors.isEmpty())
            return null;
        for (AState state:listNeighboors) {
            if(visited.contains(state))
                listNeighboors.remove(state);
        }
        return listNeighboors;
    }

}
