package algorithms.search;

import java.util.ArrayList;

public class Solution {
    AState endState;
    public Solution(AState endState) {
        this.endState=endState;
    }

    public ArrayList<AState> getSolutionPath(){
        ArrayList<AState> pathSol=new ArrayList<>();
        AState skipper=endState;
        while(skipper!=null){
            pathSol.add(skipper);
            skipper=skipper.getCameFrom();
        }
        return pathSol;
    }
}
