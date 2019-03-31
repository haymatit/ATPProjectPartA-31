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

        stack.push(s.getStartState());
        AState end=null;
        while(!stack.isEmpty()) {
            AState tmp = stack.pop();
            visited.add(tmp);
            if (tmp.equals(s.getEndState())){
                end=tmp;
                break;
            }

            for(AState node : s.getAllPossibleStates(tmp)) {
                if (!visited.contains(node)) {
                    stack.push(node);
                    node.setCameFrom(tmp);
                }
            }
        }
        AState skipper=s.getEndState();
        Solution sol=new Solution(end);
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
