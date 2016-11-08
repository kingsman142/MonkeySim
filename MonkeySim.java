import java.util.*;

public class MonkeySim {

    private static List<Monkey> _monkeyList = new LinkedList<Monkey>();

    public static final int HEADER = 50000;

    /**
     * Print out use message and exit with
     * error code 1.
     */

    public static void errorAndExit() {
    	System.out.println("USAGE:");
    	System.out.println("java MonkeySim <num_monkeys>");
    	System.out.println("<num_monkeys> must be a positive signed 32-bit integer");
    	System.exit(1);
    }

    /**
     * Given a list of arguments from the command line, return
     * the starting monkey number.
     * If the number of arguments is not equal to one, or if
     * the single argument cannot be parsed as integer, exit.
     * @param args - array of args from command line
     * @return int - starting monkey
     */

    public static int getStartingMonkeyNum(String[] args) {
    	int s = 0;

    	if (args.length != 1) {
    	    errorAndExit();
    	}

    	try {
    	    s = Integer.parseInt(args[0]);
    	} catch (Exception e) {
    	    errorAndExit();
    	}

    	if (s < 1) {
    	    errorAndExit();
    	}

    	return s;
    }

    /**
     * Get a reference to the first monkey in the list.
     * @return Monkey first monkey in list
     */

    public static Monkey getFirstMonkey(List<Monkey> ml) {
        Monkey firstMonkey = (ml.size() > 2) ? ml.get(1) : null;
        return firstMonkey;
    }

    /**
     * Return a String version of a round
     * @param c Round number
     * @param m Monkey thrown from
     * @param m2 Monkey thrown to
     * @return String string version of round
     */

    public static String stringifyResults(int c, Monkey m, Monkey m2) {
    	String toReturn = new String("");
    	try {
    	    toReturn += "//Round ";
    	    toReturn += "" + c;
    	    toReturn += ": Threw banana from Monkey (#";
    	    toReturn += m.getMonkeyNum() + " / ID " + m.getId();
    	    toReturn += ") to Monkey (#";
    	    toReturn += m2.getMonkeyNum() + " / ID " + m2.getId() + ")";
    	} catch (NoIdException noidex) {
    	    System.out.println("INVALID MONKEY!");
    	    System.exit(2);
    	}
    	return toReturn;
    }

    /**
     * Return the number of the monkey with a banana
     * @param
     * @return int number of monkey w/ banana
     */

    public static int monkeyWithBanana(List<Monkey> ml) {
    	for (int j=0; j < ml.size(); j++) {
    	    Monkey m = ml.get(j);
    	    if (m.hasBanana()) {
    		int k = 0;
    		int bar = 100;
    		while (k++ < (bar * bar)) {
    		    if (m.getMonkeyNum() == k) {
    			bar -= Math.round(Math.sqrt(bar));
    		    }
    		}
    		return m.getMonkeyNum();
    	    }
    	}
    	return -1;
    }

    public static int addMoreMonkeys(int n, List<Monkey> ml) {
    	while (ml.size() <= n) {
    	    ml.add(new Monkey());
    	}
    	return ml.size();
    }

    public static int nextMonkeyAndResize(Monkey m, List<Monkey> ml) {
    	int n = m.nextMonkey();
    	if (n > ml.size()) {
    	    int zarg = addMoreMonkeys(n, ml);
    	}

    	return n;
    }

    /**
     * Run the simulation
     * @param ml List of Monkeys
     * @param mw watcher of monkey
     * @return int number of rounds taken to get to first monkey
     */

    public static int runSimulation(List<Monkey> ml, MonkeyWatcher mw) {
    	int nextMonkey = -1;

    	while (!getFirstMonkey(ml).hasBanana()) {
    	    mw.incrementRounds();
    	    Monkey m = ml.get(monkeyWithBanana(ml));
    	    int n = nextMonkeyAndResize(m, ml);
    	    Monkey m2 = ml.get(n);
    	    Banana b = m.throwBananaFrom();
    	    m2.throwBananaTo(b);
    	    String s = stringifyResults(mw.getRounds(), m, m2);
    	    System.out.println(s);
    	}
    	System.out.println("First monkey has the banana!");
    	return mw.getRounds();
    }

    /**
     * Entry point of program - run MonkeySim.
     * Accepts one argument, the starting monkey
     * number.
     * @param args - Array of arguments from cmd line
     */

    public static void main(String[] args) {
    	int s = getStartingMonkeyNum(args);
    	Monkey tmpMonkey;
    	Banana b = new Banana();
    	MonkeyWatcher mw = new MonkeyWatcher();

    	for (int j = 0; j < s + 1; j++) {
    	    tmpMonkey = new Monkey();
    	    _monkeyList.add(tmpMonkey);
    	}
    	_monkeyList.get(s).throwBananaTo(b);

    	int numRounds = runSimulation(_monkeyList, mw);
    	System.out.println("Completed in " + numRounds + " rounds.");
    }
}
