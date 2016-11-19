import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.*;

public class PrimeMonkeySimTests{
	//When 0 is passed into the isPrime() function,
	//	it should return false because 0 is not a
	//	prime number.
	@Test
	public void ZeroIsNotAPrimeNumber(){
		boolean primeValue = MonkeySim.isPrime(0);
		assertFalse(primeValue);
	}

	//When 1 is passed into the isPrime() function,
	//	it should return false because 1 is not a
	//	prime number.
	@Test
	public void OneIsNotAPrimeNumber(){
		boolean primeValue = MonkeySim.isPrime(1);
		assertFalse(primeValue);
	}

	//When 2 is passed into the isPrime() function,
	//	it should return true because 2 is a prime
	//	number.
	@Test
	public void TwoIsAPrimeNumber(){
		boolean primeValue = MonkeySim.isPrime(2);
		assertTrue(primeValue);
	}

	//When several negative numbers (-1, -2, -5)
	//	are passed into the isPrime() function, it
	//	should return false for all of them because
	//	negative numbers are not prime numbers.
	@Test
	public void NegativeNumbersAreNotPrime(){
		boolean negativeOnePrimeValue = MonkeySim.isPrime(-1);
		boolean negativeTwoPrimeValue = MonkeySim.isPrime(-2);
		boolean negativeFivePrimeValue = MonkeySim.isPrime(-5);

		assertFalse(negativeOnePrimeValue);
		assertFalse(negativeTwoPrimeValue);
		assertFalse(negativeFivePrimeValue);
	}
}
