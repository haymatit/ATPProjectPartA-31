package algorithms.search;
import java.util.HashSet;
import java.util.Stack;

public class DeapthFirstSearch extends ASearchingAlgorithm{
    Stack<AState> stack= new Stack<>();
    HashSet<AState> visited = new HashSet<>();

    private AState lastNode;


    public AState search(ISearchable s){
        stack.push(s.getStartState());
        while(!stack.isEmpty()) {
            AState tmp = stack.pop();
            visited.add(tmp);
            if (tmp.) {
                lastNode = tmp;
                break;
            }
        }

    }
}
