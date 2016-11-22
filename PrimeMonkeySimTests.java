import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class PrimeMonkeySimTests {
	//When 0 is passed into the isPrime() function,
	//	it should return false because 0 is not a
	//	prime number.
	@Test
	public void zeroIsNotAPrimeNumber() {
		boolean primeValue = MonkeySim.isPrime(0);
		assertFalse(primeValue);
	}

	//When 1 is passed into the isPrime() function,
	//	it should return false because 1 is not a
	//	prime number.
	@Test
	public void oneIsNotAPrimeNumber() {
		boolean primeValue = MonkeySim.isPrime(1);
		assertFalse(primeValue);
	}

	//When 2 is passed into the isPrime() function,
	//	it should return true because 2 is a prime
	//	number.
	@Test
	public void twoIsAPrimeNumber() {
		boolean primeValue = MonkeySim.isPrime(2);
		assertTrue(primeValue);
	}

	//When several negative numbers (-1, -2, -5)
	//	are passed into the isPrime() function, it
	//	should return false for all of them because
	//	negative numbers are not prime numbers.
	@Test
	public void negativeNumbersAreNotPrime() {
		boolean negativeOnePrimeValue = MonkeySim.isPrime(-1);
		boolean negativeTwoPrimeValue = MonkeySim.isPrime(-2);
		boolean negativeFivePrimeValue = MonkeySim.isPrime(-5);

		assertFalse(negativeOnePrimeValue);
		assertFalse(negativeTwoPrimeValue);
		assertFalse(negativeFivePrimeValue);
	}

	//When generating a LinkedList<Monkey> with five monkeys, then calling
	//  getSecondMonkey() should return the second monkey in the LinkedList.
	//  The Monkey returned by getSecondMonkey() is the same object as the
	//  object returned by calling the LinkedList's get(2) method.
	//Unit test for getSecondMonkey()
	@Test
	public void callingGetSecondMonkeyWithFiveMonkeysReturnsSecondMonkey() {
		try {
			List<Monkey> ml = new LinkedList<Monkey>();
			for (int i = 0; i < 5; i++) {
				ml.add(new Monkey());
			}
			assertEquals(MonkeySim.getSecondMonkey(ml), ml.get(2));
		} catch (NullPointerException exc) {
			//It's required that this is caught
			fail();
		}
	}

	//When generating a LinkedList<Monkey> with only one monkey, then calling
	//  getSecondMonkey() should return the null.
	//  The object returned by getSecondMonkey() is the supposed to be the second
	//  Monkey, and since there is only one Monkey, the method would return null.
	//Unit test for getSecondMonkey()
	@Test
	public void callingGetSecondMonkeyWithOneMonkeyReturnsNull() {
		try {
			List<Monkey> ml = new LinkedList<Monkey>();
			Monkey monkey = new Monkey();
			monkey.setMonkeyNum(0);
			ml.add(monkey);
			assertEquals(MonkeySim.getSecondMonkey(ml), null);
		} catch (NullPointerException exc) {
			//It's required that this is caught
			fail();
		}
	}

	//When generating a LinkedList<Monkey> with no monkeys, then calling
	//  getSecondMonkey() should return the null.
	//  The object returned by getSecondMonkey() is the supposed to be the second
	//  Monkey, and since there is no Monkeys, the method would return null.
	//Unit test for getSecondMonkey()
	@Test
	public void callingGetSecondMonkeyWithNoMonkeysReturnsNull() {
		try {
			List<Monkey> ml = new LinkedList<Monkey>();
			assertEquals(MonkeySim.getSecondMonkey(ml), null);
		} catch (NullPointerException exc) {
			//It's required that this is caught
			fail();
		}
	}

	//When passing a null list of Monkeys to
	//  getSecondMonkey() should return the null.
	//  The object returned by getSecondMonkey() is the supposed to be the second
	//  Monkey, and since there is no Monkeys, the method would return null.
	//Unit test for getSecondMonkey()
	@Test
	public void callingGetSecondMonkeyWithNullListReturnsNull() {
		try {
			assertEquals(MonkeySim.getSecondMonkey(null), null);
		} catch (NullPointerException exc) {
			//It's required that this is caught
			fail();
		}
	}

	//When passing a normal list of Monkeys to
	//  getSecondMonkey() should return the the 2nd monkey.
	//Unit test for getSecondMonkey()
	@Test
	public void callingGetSecondMonkeyWithListOfTenMonkeysReturnsSecondMonkey() {
		try {
			List<Monkey> ml = new LinkedList<Monkey>();
			for (int i = 0; i < 10; i++) {
				Monkey monkey = new Monkey();
				monkey.setMonkeyNum(i);
				ml.add(monkey);
			}
			assertEquals(MonkeySim.getSecondMonkey(ml), ml.get(2));
		} catch (NullPointerException exc) {
			//It's required that this is caught
			fail();
		}
	}

	//When generating a LinkedList<Monkey> with only one monkey, then calling
	//  nextPrimeNumber() should return the -1.
	//  The value returned by nextPrimeNumber() is the supposed to be the next prime
	//  number in descending order, and since the current value is 1, there is no further
	//  valid prime numbers, and -1 is returned
	//Unit test for nextPrimeNumber()
	@Test
	public void callingNextPrimeNumberWithOneMonkeyReturnsNegativeOne() {
		try {
			Monkey monkOne = new Monkey();
			monkOne.setMonkeyNum(0);
			assertEquals(MonkeySim.nextPrimeNumber(monkOne), -1);
		} catch (NullPointerException exc) {
			//It's required that this is caught
			fail();
		}
	}

	//When generating a monkey with a number of 1, then calling
	//  nextPrimeNumber() should return the -1.
	//  The value returned by nextPrimeNumber() is the supposed to be the next prime
	//  number in descending order, and since the current value is 0, there is no further
	//  valid prime numbers, and -1 is returned
	//Unit test for nextPrimeNumber()
	@Test
	public void callingNextPrimeNumberWithNoMonkeysReturnsNull() {
		try {
			Monkey monkTwo = new Monkey();
			monkTwo.setMonkeyNum(1);
			assertEquals(MonkeySim.nextPrimeNumber(monkTwo), -1);
		} catch (NullPointerException exc) {
			//It's required that this is caught
			fail();
		}
	}

	//When generating a LinkedList<Monkey> with ten monkeys, then calling
	//  nextPrimeNumber() should return the 7.
	//Unit test for nextPrimeNumber()
	@Test
	public void callingNextPrimeNumberWithTenMonkeysReturnsSeven() {
		try {
			List<Monkey> ml = new LinkedList<Monkey>();
			for (int i = 0; i < 10; i++) {
				Monkey monkey = new Monkey();
				monkey.setMonkeyNum(i);
				ml.add(monkey);
			}
			assertEquals(MonkeySim.nextPrimeNumber(ml.get(9)), 7);
		} catch (NullPointerException exc) {
			//It's required that this is caught
			fail();
		}
	}

	//When passing a null Monkey to nextPrimeNumber(),
	//	it should return -1.
	//Unit test for nextPrimeNumber()
	@Test
	public void callingNextPrimeNumberWithNullMonkeyReturnsNegativeOne() {
		try {
			assertEquals(MonkeySim.nextPrimeNumber(null), -1);
		} catch (NullPointerException exc) {
			//It's required that this is caught
			fail();
		}
	}

	//When generating a LinkedList<Monkey> with Three monkeys, then calling
	//  runPrimeSimulation() should return 1.
	//  The value returned by runPrimeSimulation() is the next Monkey to recieve
	//  the banana. If the current Money holding the banana is Monkey 2,
	//  then, Monkey 1 will get the banana.
	//Unit test for runPrimeSimulation()
	@Test
	public void callingRunPrimeSimulationWith3MonkeysReturns1() {
		MonkeyWatcher mw;
		try {
			List<Monkey> ml = new LinkedList<Monkey>();
			mw = new MonkeyWatcher();
			Monkey monkOne = new Monkey();
			Monkey monkTwo = new Monkey();
			Monkey monkThree = new Monkey();
			ml.add(monkOne);
			ml.add(monkTwo);
			ml.add(monkThree);
			monkThree.throwBananaTo(new Banana());
			assertEquals(MonkeySim.runPrimeSimulation(ml, mw), 1);
		} catch (NullPointerException exc) {
			//It's required that this is caught
			fail();
		}
	}

	//When generating a LinkedList<Monkey> with zero monkeys, then calling
	//  runPrimeSimulation() should return 0.
	//Unit test for runPrimeSimulation()
	@Test
	public void callingRunPrimeSimulationWith0MonkeysReturns0() {
		MonkeyWatcher mw;
		try {
			List<Monkey> ml = new LinkedList<Monkey>();
			mw = new MonkeyWatcher();
			assertEquals(MonkeySim.runPrimeSimulation(ml, mw), 0);
		} catch (NullPointerException exc) {
			//It's required that this is caught
			fail();
		}
	}

	//When generating a LinkedList<Monkey> with 15 monkeys, then calling
	//  runPrimeSimulation() should return 7.
	//Unit test for runPrimeSimulation()
	@Test
	public void callingRunPrimeSimulationWith15MonkeysReturns7() {
		MonkeyWatcher mw;
		try {
			List<Monkey> ml = new LinkedList<Monkey>();
			mw = new MonkeyWatcher();

			for (int i = 0; i < 16; i++) {
				Monkey monkey = new Monkey();
				monkey.setMonkeyNum(i);
				ml.add(monkey);

				if (i == 15) {
					monkey.throwBananaTo(new Banana());
				}
			}

			assertEquals(MonkeySim.runPrimeSimulation(ml, mw), 7);
		} catch (NullPointerException exc) {
			//It's required that this is caught
			fail();
		}
	}

	//When passing a null monkey list to
	//  runPrimeSimulation() should return 0.
	//Unit test for runPrimeSimulation()
	@Test
	public void callingRunPrimeSimulationWithNullMonkeyListReturns0() {
		MonkeyWatcher mw;
		try {
			mw = new MonkeyWatcher();

			assertEquals(MonkeySim.runPrimeSimulation(null, mw), 0);
		} catch (NullPointerException exc) {
			//It's required that this is caught
			fail();
		}
	}

	//When passing a null monkey watcher to
	//  runPrimeSimulation() should return 0.
	//Unit test for runPrimeSimulation()
	@Test
	public void callingRunPrimeSimulationWithNullMonkeyWatcherReturns0() {
		try {
			List<Monkey> ml = new LinkedList<Monkey>();
			for (int i = 0; i < 10; i++) {
				Monkey monkey = new Monkey();
				monkey.setMonkeyNum(i);
				ml.add(monkey);
			}
			assertEquals(MonkeySim.runPrimeSimulation(ml, null), 0);
		} catch (NullPointerException exc) {
			//It's required that this is caught
			fail();
		}
	}
}
