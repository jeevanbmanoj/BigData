import java.util.ArrayList;
import java.util.List;

public class PrimeUtils {

	public static int nThPrime(int n) {
		int count = n;
		List<Integer> primes = new ArrayList<Integer>();
		do {
			primes = sieveOfEeratosthenes(count);
			count *= 100;
		} while (primes.size() < n );
		return primes.get(n-1);
	}

	public static List<Integer> sieveOfEeratosthenes(int n) {
		List<Integer> primes = new ArrayList<Integer>();
		boolean[] numbers = new boolean[n + 1];
		for (int i = 0; i <= n; i++)
			numbers[i] = true;
		for (int divisor = 2; divisor <= n; divisor++) {
			// If not prime then skip
			if (!numbers[divisor])
				continue;
			primes.add(divisor);
			for (int multiple = divisor; multiple <= n; multiple += divisor) {
				numbers[multiple] = false;
			}
		}
		return primes;

	}
}
