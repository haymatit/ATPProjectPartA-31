package algorithms.search;

import java.util.ArrayList;

public class Solution {
    //ArrayList<AState> pathSol;
    MazeState endState;
    public Solution(MazeState endState) {
        this.endState=endState;
    }



    public ArrayList<AState> getSolutionPath(){
        ArrayList<AState> pathSol=new ArrayList<>();
        MazeState skipper=endState;
        while(skipper!=null){
            pathSol.add(skipper);
            skipper=skipper.getCameFrom();
        }


        return pathSol;
    }
}
