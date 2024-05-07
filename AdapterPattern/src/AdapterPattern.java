import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

interface SimplePrimeInterface{
    String findPrimes(int limit);

}

//Adaptee class
class SimplePrimeFinder implements SimplePrimeInterface {

    @Override
    public String findPrimes(int limit) {
        String primes = "";
        for (int number = 2; number <= limit; number++) {
            if (isPrime(number)) {
                primes = primes + " " + number;
            }
        }
        return primes;
    }

    private boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}

interface PrimeFinder {
    List<Integer> sievePrimes(int limit);
}

//Target Class
class SievePrime implements PrimeFinder {
    public List<Integer> sievePrimes(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);
        List<Integer> primes = new ArrayList<>();

        for (int number = 2; number * number <= limit; number++) {
            if (isPrime[number]) {
                for (int multiple = number * number; multiple <= limit; multiple += number) {
                    isPrime[multiple] = false;
                }
            }
        }

        for (int number = 2; number <= limit; number++) {
            if (isPrime[number]) {
                primes.add(number);
            }
        }

        return primes;
    }
}

//Adapter class
class SimpleToSievePrime extends SievePrime implements SimplePrimeInterface  {
    @Override
    public String findPrimes(int limit) {
        List<Integer> primes = sievePrimes(limit);
        String primeStr = "";
        for(int prime : primes) {
            primeStr += String.valueOf(prime);
        }

        return primeStr;
    }
}


// Testing the prime finders
public class AdapterPattern {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        SimplePrimeInterface simplePrimeFinder = new SimpleToSievePrime();
        System.out.println("Please enter a number to find prime numbers from 0 to your number: ");
        int limit = scan.nextInt();
        System.out.println("Primes found by Simple Prime Finder: " + simplePrimeFinder.findPrimes(limit));
    }
}