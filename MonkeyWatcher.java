import java.util.*;

public class MonkeyWatcher {

    private int numRounds = 0;

    /**
     * Return number of rounds played
     * @return int number of rounds played
     */

    public int getRounds() {
	    return numRounds;
    }

    /**
     * Increment number of rounds
     */

    public void incrementRounds() {
	if(numRounds >= 0)
	    numRounds ++;
    }

}
