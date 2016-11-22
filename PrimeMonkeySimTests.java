import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

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
	//Pin test for getSecondMonkey()
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
	//Pin test for getSecondMonkey()
	@Test
	public void callingGetSecondMonkeyWithOneMonkeyReturnsNull() {
		try {
			List<Monkey> ml = new LinkedList<Monkey>();
			ml.add(new Monkey());
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
	//Pin test for getSecondMonkey()
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


	//When generating a LinkedList<Monkey> with only one monkey, then calling
	//  nextPrimeNumber() should return the -1.
	//  The value returned by nextPrimeNumber() is the supposed to be the next prime
	//  number in descending order, and since the current value is 1, there is no further
	//  valid prime numbers, and -1 is returned
	//Pin test for nextPrimeNumber()
	@Test
	public void callingNextPrimeNumberWithOneMonkeyReturnsNull() {
		try {
			List<Monkey> ml = new LinkedList<Monkey>();
			Monkey monkOne = new Monkey();
			ml.add(monkOne);
			assertEquals(MonkeySim.nextPrimeNumber(monkOne, ml), -1);
		} catch (NullPointerException exc) {
			//It's required that this is caught
			fail();
		}
	}


	//When generating a LinkedList<Monkey> with Two monkeys, then calling
	//  nextPrimeNumber() should return the -1.
	//  The value returned by nextPrimeNumber() is the supposed to be the next prime
	//  number in descending order, and since the current value is 0, there is no further
	//  valid prime numbers, and -1 is returned
	//Pin test for nextPrimeNumber()
	@Test
	public void callingNextPrimeNumberWithNoMonkeysReturnsNull() {
		try {
			List<Monkey> ml = new LinkedList<Monkey>();
			Monkey monkOne = new Monkey();
			Monkey monkTwo = new Monkey();
			ml.add(monkOne);
			ml.add(monkTwo);
			assertEquals(MonkeySim.nextPrimeNumber(monkTwo, ml), -1);
		} catch (NullPointerException exc) {
			//It's required that this is caught
			fail();
		}
	}
