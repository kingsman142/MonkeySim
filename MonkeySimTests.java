import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.*;

public class MonkeySimTests{
	//When "1" is passed as a command-line argument
	//	to the MonkeySim program, a list of two monkeys
	//	is created and immediately the getFirstMonkey()
	//	method is called, but it returns a null Monkey object.
	@Test
	public void PassingInMonkeyListOfSizeTwoShouldThrowNullPointerExceptionWhenRetrievingFirstMonkey(){
		Monkey monkeyOne = new Monkey();
		Monkey monkeyTwo = new Monkey();
		List<Monkey> monkeyList = new LinkedList<Monkey>();
		monkeyList.add(monkeyOne);
		monkeyList.add(monkeyTwo);

		Monkey returnMonkey = MonkeySim.getFirstMonkey(monkeyList);
		assertNull(returnMonkey);
	}

	@Test
	public void PassingIn32MonkeysWhichIsAPowerOfTwoToMonkeySimShouldReturnFiveRoundsWhichIsTheLogBaseTwoOf32(){
		MonkeyWatcher mw = new MonkeyWatcher();
		List<Monkey> monkeys = new LinkedList<Monkey>();
		for(int i = 0; i < 32; i++){
			monkeys.add(new Monkey());
		}
		int numRounds = MonkeySim.runSimulation(monkeys, mw);

		assertEquals(5, numRounds); //Number of rounds should be 5
	}

	@Test
	public void PassingIn17MonkeysToMonkeySimShouldReturnTwelveRounds(){
		MonkeyWatcher mw = new MonkeyWatcher();
		List<Monkey> monkeys = new LinkedList<Monkey>();
		for(int i = 0; i < 17; i++){
			monkeys.add(new Monkey());
		}
		int numRounds = MonkeySim.runSimulation(monkeys, mw);

		assertEquals(12, numRounds); //Number of rounds should be 5
	}
}
