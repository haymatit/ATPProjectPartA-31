package algorithms.search;

import java.util.ArrayList;
import java.util.Objects;

public abstract class AState {
    private AState cameFrom;

    public AState(AState cameFrom) {
        this.cameFrom = cameFrom;
    }

    @Override
    public boolean equals(Object o) {//?
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AState aState = (AState) o;
        return Objects.equals();
    }


    @Override
    public String toString() {
        return "AState{}";
    }
}
