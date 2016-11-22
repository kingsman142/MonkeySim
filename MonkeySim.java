
import java.util.LinkedList;
import java.util.List;

public class MonkeySim {

    private static List<Monkey> _monkeyList = new LinkedList<Monkey>();

    public static final int HEADER = 50000;

    private static int currMonkeyNum = 0;

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
    	int start = 0;

    	if (args.length != 1) {
    	    errorAndExit();
    	}

    	try {
    	    start = Integer.parseInt(args[0]);
    	} catch (NumberFormatException ex) {
    	    errorAndExit();
    	}

    	if (start < 1) {
    	    errorAndExit();
    	}

    	return start;
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
     * Return a String version of a round.
     * @param counter Round number
     * @param mon Monkey thrown from
     * @param m2 Monkey thrown to
     * @return String string version of round
     */

    public static String stringifyResults(int counter, Monkey mon, Monkey m2) {
    	String toReturn = "";
    	try {
    	    toReturn += "//Round ";
    	    toReturn += "" + counter;
    	    toReturn += ": Threw banana from Monkey (#";
    	    toReturn += mon.getMonkeyNum() + " / ID " + mon.getId();
    	    toReturn += ") to Monkey (#";
    	    toReturn += m2.getMonkeyNum() + " / ID " + m2.getId() + ")";
    	} catch (NoIdException noidex) {
    	    System.out.println("INVALID MONKEY!");
    	    throw new RuntimeException();
    	}
    	return toReturn;
    }

    /**
     * Return the number of the monkey with a banana.
     * @param ml list of monkeys in the simulation currently
     * @return int number of monkey w/ banana
     */

    public static int monkeyWithBanana(List<Monkey> ml) {
    	Monkey monkey;
        for (int j = 0; j < ml.size(); j++) {
    	    monkey = ml.get(j);
    	    if (monkey.hasBanana()) {
    		    return monkey.getMonkeyNum();
            }
    	}
    	return -1;
    }

    /**
     * Add more monkeys to the monkey list.
     * @return int new size of the monkey list
     */
    public static int addMoreMonkeys(int numberToAdd, List<Monkey> ml) {
    	while (ml.size() <= numberToAdd) {
    	    ml.add(new Monkey());
    	}
    	return ml.size();
    }

    /**
     * Find the next monkey using the algorithm.
     * Resize the monkey list if necessary to accomodate more monkeys.
     * @return int next monkey number
     */
    public static int nextMonkeyAndResize(Monkey currMonkey, List<Monkey> ml) {
    	int nextMonkeyNum = currMonkey.nextMonkey();
    	if (nextMonkeyNum > ml.size()) {
    	    int zarg = addMoreMonkeys(nextMonkeyNum, ml);
    	}

    	return nextMonkeyNum;
    }

    /**
     * Run the simulation.
     * @param ml List of Monkeys
     * @param mw watcher of monkey
     * @return int number of rounds taken to get to first monkey
     */

    public static int runSimulation(List<Monkey> ml, MonkeyWatcher mw) {
    	int nextMonkey = -1;

    	while (!getFirstMonkey(ml).hasBanana()) {
    	    mw.incrementRounds();
    	    Monkey monkeyOne = ml.get(monkeyWithBanana(ml));
    	    int nextMonkeyNumber = nextMonkeyAndResize(monkeyOne, ml);
    	    Monkey monkeyTwo = ml.get(nextMonkeyNumber);
    	    Banana banana = monkeyOne.throwBananaFrom();
    	    monkeyTwo.throwBananaTo(banana);
    	    String stringifiedResults = stringifyResults(mw.getRounds(), monkeyOne, monkeyTwo);
    	    System.out.println(stringifiedResults);
    	}
    	System.out.println("First monkey has the banana!");
    	return mw.getRounds();
    }

    /**
     * Get a reference to the second monkey in the list.
     * @return Monkey second monkey in list
     */
    public static Monkey getSecondMonkey(List<Monkey> ml) {
        Monkey secondMonkey = (ml.size() > 2) ? ml.get(2) : null;
        return secondMonkey;
    }

    /**
     * Checks whether a number is prime or not.
     */
    public static boolean isPrime(int number) {
        if (number == 0 || number == 1 || number < 0) {
            return false;
        } else if (number == 2) {
            return true;
        }

        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) { //No remainder upon division
                return false; //The number is divisble by another number
            }
        }

        return true;
    }

    /**
     * Return the monkey number of the next prime in the simulation
     * in descending order.
     */
    public static int nextPrimeNumber(Monkey currentMonkey, List<Monkey> ml) {
        int currentMonkeyNum = currentMonkey.getMonkeyNum();

        for (int i = currentMonkeyNum - 1; i >= 2; i--) {
            if (isPrime(i)) {
                return i; //Return this monkey number
            }
        }

        return -1;
    }

    /**
     * Run the prime simulation, which occurs
     * after the initial simulation.  The banana
     * is only thrown to monkeys with a prime monkey number.
     */
    public static int runPrimeSimulation(List<Monkey> ml, MonkeyWatcher mw) {
        if (ml.size() == 3) {
            mw.incrementRounds();
            Monkey secondMonk = getSecondMonkey(ml);
            Monkey firstMonk = getFirstMonkey(ml);
            Banana banana = secondMonk.throwBananaFrom();
            firstMonk.throwBananaTo(banana);
            String stringifiedResults = stringifyResults(mw.getRounds(), secondMonk, firstMonk);
            System.out.println(stringifiedResults);
        	System.out.println("First monkey has the banana!");

        	return mw.getRounds();
        }

        while (!getSecondMonkey(ml).hasBanana()) {
            mw.incrementRounds();
            Monkey monkeyOne = ml.get(monkeyWithBanana(ml));
            int nextPrimeMonkeyNumber = nextPrimeNumber(monkeyOne, ml);
            Monkey monkeyTwo = ml.get(nextPrimeMonkeyNumber);
            Banana banana = monkeyOne.throwBananaFrom();
    	    monkeyTwo.throwBananaTo(banana);
    	    String stringifiedResults = stringifyResults(mw.getRounds(), monkeyOne, monkeyTwo);
    	    System.out.println(stringifiedResults);
    	}

        mw.incrementRounds();
        Monkey secondMonk = getSecondMonkey(ml);
        Monkey firstMonk = getFirstMonkey(ml);
        Banana banana = secondMonk.throwBananaFrom();
        firstMonk.throwBananaTo(banana);
        String stringifiedResults = stringifyResults(mw.getRounds(), secondMonk, firstMonk);
        System.out.println(stringifiedResults);
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
    	int startingMonkey = getStartingMonkeyNum(args);
    	Monkey tmpMonkey;
    	Banana banana = new Banana();
    	MonkeyWatcher mw = new MonkeyWatcher();

    	for (int j = 0; j < startingMonkey + 1; j++) {
    	    tmpMonkey = new Monkey();
            tmpMonkey.setMonkeyNum(currMonkeyNum++);
    	    _monkeyList.add(tmpMonkey);
    	}
    	_monkeyList.get(startingMonkey).throwBananaTo(banana);

    	int numRounds = runSimulation(_monkeyList, mw);
    	System.out.println("Completed in " + numRounds + " rounds.");

        //Run the prime simulation
        System.out.println("\nStarting again...\n");
        getFirstMonkey(_monkeyList).throwBananaFrom();
        _monkeyList.get(startingMonkey).throwBananaTo(banana);
        MonkeyWatcher primeMonkeyWatcher = new MonkeyWatcher();
        int primeSimulationNumRounds = runPrimeSimulation(_monkeyList, primeMonkeyWatcher);
        System.out.println("Completed in " + primeSimulationNumRounds + " rounds.");
    }
}
