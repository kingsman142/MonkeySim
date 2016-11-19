import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.ArrayList;

public class MonkeySimTestsRunner {

    /**
     * Main entry point for the test runner.
     */
    public static void main(String[] args) {
    	ArrayList<Class> classesToTest = new ArrayList<Class>();
    	boolean anyFailures = false;

    	// ADD ANY MORE CLASSES YOU WISH TO TEST HERE

    	classesToTest.add(MonkeySimTests.class);
        classesToTest.add(PrimeMonkeySimTests.class);

    	// For all test classes added, loop through and use JUnit
    	// to run them.

    	for (Class c: classesToTest) {
    	    Result res = JUnitCore.runClasses(c);
    	       //Print out any failures for this class.
            System.out.println("\n-----------------------------------------------------------\n");
    	    for (Failure f : res.getFailures()) {
    		    System.out.println(f.toString());
    	    }

    	    // If r is not successful, there was at least one
    	    // failure.  Thus, set anyFailures to true - this
    	    // can never be set back to false (no amount of
    	    // successes will ever eclipse the fact that there
    	    // was at least one failure.

    	    if (!res.wasSuccessful()) {
    		    anyFailures = true;
    	    }

    	}

    	// After completion, notify user if all tests passed or any failed.

    	if (anyFailures) {
    	    System.out.println("\n!!! - At least one failure, see above.");
    	} else {
    	    System.out.println("\nALL TESTS PASSED");
    	}
    }
}
