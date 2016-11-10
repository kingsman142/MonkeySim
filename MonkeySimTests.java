import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.*;

public class MonkeySimTests{
	//When getFirstMonkey() is called with a list of two monkeys,
	//	it should return a null Monkey reference.
	//Pin test for getFirstMonkey()
	@Test
	public void PassingInMonkeyListOfSizeTwoShouldReturnNullMonkeyAsFirstMonkey(){
		Monkey monkeyOne = new Monkey();
		Monkey monkeyTwo = new Monkey();
		List<Monkey> monkeyList = new LinkedList<Monkey>();
		monkeyList.add(monkeyOne);
		monkeyList.add(monkeyTwo);

		Monkey returnMonkey = MonkeySim.getFirstMonkey(monkeyList);
		assertNull(returnMonkey);
	}

	//When getFirstMonkey() is called with a valid list of six monkeys,
	//	it should return the Monkey with number 1, which is at index 1.
	//Pin test for getFirstMonkey()
	@Test
	public void PassingInValidMonkeyListOfSizeFiveShouldReturnMonkeyAtIndexOneAsFirstMonkey(){
		List<Monkey> monkeyList = new LinkedList<Monkey>();
		for(int i = 0; i < 6; i++){
			monkeyList.add(new Monkey());
		}

		Monkey returnMonkey = MonkeySim.getFirstMonkey(monkeyList);
		Monkey firstMonkey = monkeyList.get(1);
		assertSame(firstMonkey, returnMonkey);
	}

	//When getFirstMonkey() is called with an empty list of monkeys,
	//	it should return a null Monkey reference.
	//Pin test for getFirstMonkey()
	@Test
	public void PassingInAnEmptyMonkeyListShouldReturnNullMonkeyAsFirstMonkey(){
		List<Monkey> monkeyList = new LinkedList<Monkey>();

		Monkey returnMonkey = MonkeySim.getFirstMonkey(monkeyList);
		assertNull(returnMonkey);
	}

	//When getFirstMonkey() is called with a null list of Monkeys,
	//	it should throw a NullPointerException.
	//Pin test for getFirstMonkey()
	@Test
	public void PassingInANullMonkeyListShouldThrowANullPointerException(){
		try{
			MonkeySim.getFirstMonkey(null);
			fail(); //Fail the test if it hasn't thrown a NullPointerException by now
		} catch(NullPointerException e){

		}
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
		try{
			Monkey monkOne = new Monkey();
			Monkey monkTwo = new Monkey();
			int round = 5;

			String actualOutput = MonkeySim.stringifyResults(round, monkOne, monkTwo);
			String expectedOutput = "//Round 5: Threw banana from Monkey (#" + monkOne.getMonkeyNum() + " / ID " + monkOne.getId() + ") to Monkey (#" + monkTwo.getMonkeyNum() + " / ID " + monkTwo.getId() + ")";

			assertEquals(expectedOutput, actualOutput);
		} catch(NoIdException e){
			//It's required that this is caught
			fail();
		}
	}

	//When a round number, such as -1, is passed
	//	into the stringifyResults() method, the method
	//	should still return a String detailing that the two
	//	monkeys passed a banana on round -1.
	//Pin test for stringifyResults()
	@Test
	public void WhenANegativeRoundNumberIsStringifiedShouldStillOutputRespectiveRound(){
		try{
			Monkey monkOne = new Monkey();
			Monkey monkTwo = new Monkey();
			int round = -1;

			String actualOutput = MonkeySim.stringifyResults(round, monkOne, monkTwo);
			String expectedOutput = "//Round -1: Threw banana from Monkey (#" + monkOne.getMonkeyNum() + " / ID " + monkOne.getId() + ") to Monkey (#" + monkTwo.getMonkeyNum() + " / ID " + monkTwo.getId() + ")";

			assertEquals(expectedOutput, actualOutput);
		} catch(NoIdException e){
			//It's required that this is caught
			fail();
		}
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

	//When two valid monkeys with valid IDs and MonkeyNums
	//	are passed into the stringifyResults() method
	//	during round INT_MAX (edge case), the method
	//	should output a String detailing that the banana
	//	was passed from the first monkey to the second monkey
	//	on round INT_MAX.
	//Pin test for stringifyResults()
	@Test
	public void WhenTwoValidMonkeysAreStringifiedOnRoundINTMAXShouldReturnStringDetailingAllMonkeyNumsAndRoundAndIDs(){
		try{
			Monkey monkOne = new Monkey();
			Monkey monkTwo = new Monkey();
			int round = Integer.MAX_VALUE;

			String actualOutput = MonkeySim.stringifyResults(round, monkOne, monkTwo);
			String expectedOutput = "//Round " + Integer.MAX_VALUE + ": Threw banana from Monkey (#" + monkOne.getMonkeyNum() + " / ID " + monkOne.getId() + ") to Monkey (#" + monkTwo.getMonkeyNum() + " / ID " + monkTwo.getId() + ")";

			assertEquals(expectedOutput, actualOutput);
		} catch(NoIdException e){
			//It's required that this is caught
			fail();
		}
	}

	//When two valid monkeys with valid IDs and MonkeyNums
	//	are passed into the stringifyResults() method
	//	during round 0, the method
	//	should output a String detailing that the banana
	//	was passed from the first monkey to the second monkey
	//	on round 0.
	//Pin test for stringifyResults()
	@Test
	public void WhenTwoValidMonkeysAreStringifiedOnRoundZeroShouldReturnStringDetailingAllMonkeyNumsAndRoundAndIDs(){
		try{
			Monkey monkOne = new Monkey();
			Monkey monkTwo = new Monkey();
			int round = 0;

			String actualOutput = MonkeySim.stringifyResults(round, monkOne, monkTwo);
			String expectedOutput = "//Round 0: Threw banana from Monkey (#" + monkOne.getMonkeyNum() + " / ID " + monkOne.getId() + ") to Monkey (#" + monkTwo.getMonkeyNum() + " / ID " + monkTwo.getId() + ")";

			assertEquals(expectedOutput, actualOutput);
		} catch(NoIdException e){
			//It's required that this is caught
			fail();
		}
	}
}
