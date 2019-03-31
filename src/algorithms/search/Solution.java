package algorithms.search;

import java.util.ArrayList;

public class Solution {
    ArrayList<AState> pathSol;

    public Solution() {
        this.pathSol = new ArrayList<>();
    }

    public void addToPath(AState s){
        pathSol.add(s);
    }

    public ArrayList<AState> getSolutionPath(){
        return pathSol;
    }
}
