package algorithms.search;

import java.util.ArrayList;

public abstract class AState {
    private AState cameFrom;

    public AState(AState cameFrom) {
        this.cameFrom = cameFrom;
    }


    @Override
    public String toString() {
        return "AState{}";
    }
}
