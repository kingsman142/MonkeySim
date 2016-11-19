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
	public void whenTwoValidMonkeysAreStringifiedOnRoundZeroShouldReturnCorrectResults() {
		try {
			Monkey monkOne = new Monkey();
			Monkey monkTwo = new Monkey();

			String expectedOutput = "//Round 0: Threw banana from Monkey (#";
			expectedOutput += monkOne.getMonkeyNum() + " / ID " + monkOne.getId();
			expectedOutput += ") to Monkey (#" + monkTwo.getMonkeyNum() + " / ID ";
			expectedOutput += monkTwo.getId() + ")";
			int round = 0;
			String actualOutput = MonkeySim.stringifyResults(round, monkOne, monkTwo);

			assertEquals(expectedOutput, actualOutput);
		} catch (NoIdException exc) {
			//It's required that this is caught
			fail();
		}
	}

	//When a valid monkey with monkeyNum equals 1 is generated,
	//	calling the generateId() should always generate Id value
	//	equals 223593.
	//Pin test for generateId()
	@Test
	public void whenGeneratingIdForMonkeyNumberOneWillAlwaysReturnIdEqualTo223593() {
		int currId;
		try {
			Monkey monkOne = new Monkey();
			currId = monkOne.generateId(monkOne.getMonkeyNum());
			assertEquals(currId, 223593);
		} catch (NullPointerException exc) {
			//It's required that this is caught
			fail();
		}
	}


	//When generating ID for a monkey with monkeyNum equals 100,
	//	the genrated ID will always be the same equals 223593.
	//Pin test for generateId()
	@Test
	public void whenGeneratingIdForMonkeyNumberOneHundredWillAlwaysReturnIdEqualTo223592() {
		try {
			Monkey monkOne = new Monkey();
			Monkey monkTwo = new Monkey();

			int id1 = monkOne.generateId(100);
			int id2 = monkOne.generateId(100);

			assertEquals(id1, 223592);
			assertEquals(id2, 223592);
		} catch (NullPointerException exc) {
			//It's required that this is caught
			fail();
		}
	}


	//When generating ID for a monkey with monkeyNum equals -100,
	//	the genrated ID will always be the same equals 223492.
	//Pin test for generateId()
	@Test
	public void whenGeneratingIdForMonkeyNumberNegativeOneHundredShouldReturnIdEqualTo223492() {
		try {
			Monkey monkOne = new Monkey();

			int id1 = monkOne.generateId(-100);

			assertEquals(id1, 223392);
		} catch (NullPointerException exc) {
			//It's required that this is caught
			fail();
		}
	}


	//When generating a list with 100 monkeys, but not assigning
	//  banana to any of the monkeys,
	//  monkeyWithBanana() method would return -1
	//Pin test for monkeyWithBanana()
	@Test
	public void whenNoMonkeyIsAssignedTheBananaThenReturnNegativeOneWhenCallMonkeyWithBanana() {
		try {
			List<Monkey> monkeyList = new LinkedList<Monkey>();
			for (int i = 0; i < 100; i++) {
				monkeyList.add(new Monkey());
			}
			assertEquals(MonkeySim.monkeyWithBanana(monkeyList), -1);
		} catch (NullPointerException exc) {
			//It's required that this is caught
			fail();
		}
	}


	//When generating a list with 100 monkeys, and assigning
	//  a banana to monkeys number 75 (index 74),
	//  monkeyWithBanana() method would return 75 for number of monkey with banana
	//Pin test for monkeyWithBanana()
	@Test
	public void whenMonkeySeventyFiveIsThrownTheBananaThenMonkeyWithBananaShouldBeMonkey75() {
		try {
			List<Monkey> ml = new LinkedList<Monkey>();
			for (int i = 0; i < 100; i++) {
				ml.add(new Monkey());
			}
			(ml.get(74)).throwBananaTo(new Banana());
			assertEquals(MonkeySim.monkeyWithBanana(ml), 75);
		} catch (NullPointerException exc) {
			//It's required that this is caught
			fail();
		}
	}


	//When generating a list with 10 monkeys, assigning a banana
	//  to monkey 10, the calling hasBanana() method for monkey 10 will return true
	//Pin test for monkeyWithBanana()
	@Test
	public void assigningBananaToMonkeyNumberTenAndCallhasBananaForMonkeyTenShouldReturnTrue() {
		try {
			List<Monkey> ml = new LinkedList<Monkey>();
			Banana banana = new Banana();
			for (int i = 0; i < 20; i++) {
				ml.add(new Monkey());
			}
			ml.get(9).throwBananaTo(banana);
			assertTrue((ml.get(9)).hasBanana());
		} catch (NullPointerException exc) {
			//It's required that this is caught
			fail();
		}
	}


	//When generating a MonkeyWatcher object, then incrementing
	//	numRounds 10 times, the value of numRounds should be 10.
	//Pin test for incrementRounds()
	@Test
	public void callingIncrementRoundsTenTimesMakesNumRoundsEqualTen() {
		try {
			MonkeyWatcher mw = new MonkeyWatcher();
			for (int i = 0; i < 10; i++) {
				mw.incrementRounds();
			}
			assertEquals(mw.getRounds(), 10);
		} catch (NullPointerException exc) {
			//It's required that this is caught
			fail();
		}
	}


	//When generating a MonkeyWatcher object, then directly
	//	evaluating numRounds, the value of numRounds should be 0.
	//Pin test for incrementRounds()
	@Test
	public void callingGetRoundsWithoutInitializationMakesNumRoundsEqualZero() {
		try {
			MonkeyWatcher mw = new MonkeyWatcher();
			assertEquals(mw.getRounds(), 0);
		} catch (NullPointerException exc) {
			//It's required that this is caught
			fail();
		}
	}


	//When generating a MonkeyWatcher object, then incrementing numRounds
	//  to one million, then calling MonkeyWatcher.numRounds should return
	// 	1000001, with a one point increment, then evaluating
	//	numRounds, the value of numRounds should be increased by exactly one.
	//Pin test for incrementRounds()
	@Test
	public void callingIncrementRoundsWithHighOrderNumRoundsIncrementsByOne() {
		try {
			int before = 0;
			MonkeyWatcher mw = new MonkeyWatcher();
			for (int i = 0; i < 1000000; i++) {
				mw.incrementRounds();
			}
			before = mw.getRounds();
			mw.incrementRounds();
			int after = 0;
			after = mw.getRounds();
			assertEquals(before, after - 1);
		} catch (NullPointerException exc) {
			//It's required that this is caught
			fail();
		}
	}

}
