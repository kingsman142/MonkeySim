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
}
