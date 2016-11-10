import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.*;

public class MonkeySimTests{
	//When "1" is passed as a command-line argument
	//	to the MonkeySim program, a list of two monkeys
	//	is created and immediately the getFirstMonkey()
	//	method is called, but it returns a null Monkey object.
	//Pin test for getFirstMonkey()
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

	//When two valid monkeys with valid IDs and MonkeyNums
	//	are passed into the stringifyResults() method
	//	during round 5 (arbitrarly chosen), the method
	//	should output a String detailing that the banana
	//	was passed from the first monkey to the second monkey
	//	on round 5.
	//Pin test for stringifyResults()
	@Test
	public void WhenTwoValidMonkeysAreStringifiedOnRoundFiveShouldReturnStringDetailingAllMonkeyNumsAndRoundAndIDs(){
		Monkey monkOne = new Monkey();
		Monkey monkTwo = new Monkey();
		int round = 5;

		String actualOutput = MonkeySim.stringifyResults(round, monkOne, monkTwo);
		String expectedOutput = MonkeySimOLD.stringifyResults(round, monkOne, monkTwo);

		assertEquals(expectedOutput, actualOutput);
	}

	//When a round number, such as -1, is passed
	//	into the stringifyResults() method, the method
	//	should still return a String detailing that the two
	//	monkeys passed a banana on round -1.
	//Pin test for stringifyResults()
	@Test
	public void WhenARoundNumberLessThanZeroIsStringifiedShouldStillOutputRespectiveRound(){
		Monkey monkOne = new Monkey();
		Monkey monkTwo = new Monkey();
		int round = -1;

		String actualOutput = MonkeySim.stringifyResults(round, monkOne, monkTwo);
		String expectedOutput = MonkeySimOLD.stringifyResults(round, monkOne, monkTwo);

		assertEquals(expectedOutput, actualOutput);
	}

	//When a null Monkey is passed into the
	//	stringifyResults() method, there are no
	//	null checks so accessing a method on a null
	//	object reference should throw a NullPointerException.
	//Pin test for stringifyResults()
	@Test
	public void WhenANullMonkeyIsStringifiedOnRoundFiveShouldThrowNullPointerException(){
		try{
			Monkey monkOne = null;
			Monkey monkTwo = new Monkey();
			int round = 5;

			String stringifiedResult = MonkeySim.stringifyResults(round, monkOne, monkTwo);
			fail(); //A NullPointerException should have been thrown by this point
					//	in the test.
		} catch(NullPointerException e){
			//If the test reaches this line, that means it has passed
			//	because a NullPointerException was successfully thrown.
		}
	}
}
