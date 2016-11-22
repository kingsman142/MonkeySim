public class Monkey {

    private int monkeyNum = 0;

    private int thisMonkeyNum = 0;

    private int id = -1;

    private Banana bn = null;

    /**
     * Set this monkey's number.
     * @param newNum - new value of monkeyNum
     */

    public void setMonkeyNum(int newNum) {
	       monkeyNum = newNum;
    }

    /**
     * Get this monkey's number.
     * @return int monkey number
     */

    public int getMonkeyNum() {
	       return thisMonkeyNum;
    }

    /**
     * Getter for id.
     * @return id of monkey
     */

    public int getId() throws NoIdException {
    	if (id < 0) {
    	    throw new NoIdException();
    	} else {
    	    return id;
    	}
    }

    /**
     * Return which monkey should get banana next.
     * @return int which monkey should get banana.
     */

    public int nextMonkey() {
    	if (thisMonkeyNum % 2 == 0) {
    	    return thisMonkeyNum / 2;
    	} else {
    	    return (thisMonkeyNum * 3) + 1;
    	}
    }

    /**
     * Checks to see if this monkey has a banana.
     * @return true if has banana, false otherwise
     */

    public boolean hasBanana() {
	    return bn != null;
    }

    /**
     * Receive a banana from another monkey.
     * @param banana - Banana given to this monkey
     */

    public void throwBananaTo(Banana banana) {
	    bn = banana;
    }

    /**
     * Throw the banana away from this monkey so it
     * doesn't have it anymore.
     * @return Banana - the banana this monkey held
     */

    public Banana throwBananaFrom() {
    	Banana toReturn = bn;
    	bn = null;
    	return toReturn;
    }

    /**
     * Generate a unique ID for this monkey.
     * Note that monkey ID generation must
     * always return the correct value for
     * a given n (i.e., the id for the first
     * monkey should always be the same).
     * @param monkeyNumber monkey number
     * @return int - id for this monkey
     */

    public int generateId(int monkeyNumber) {
    	return monkeyNumber + 223492;
    }

    /**
     * Monkey constructor.
     */

    public Monkey() {
    	thisMonkeyNum = monkeyNum;
    	monkeyNum++;
    	id = generateId(thisMonkeyNum);
    }

}
