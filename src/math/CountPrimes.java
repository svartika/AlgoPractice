package math;

import java.util.ArrayList;
import java.util.List;

public class CountPrimes {
    public int countPrimes(int n) {
        if(n<=2) return 0;
        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        for(int i=3; i<=n; i=i+2) {
            boolean isPrime = true;
            for(int prime: primes) {
                if(prime*2 > n) break;
                if(i%prime==0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) primes.add(i);
        }
        if(n==primes.get(primes.size()-1)) return primes.size()-1;
        else return primes.size();
    }

    public int countPrimesFast(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }

        return count;
    }

    public static void main(String args[]) {
        System.out.println(new CountPrimes().countPrimes(2));
        System.out.println(new CountPrimes().countPrimes(3));
        System.out.println(new CountPrimes().countPrimes(13));
        System.out.println(new CountPrimes().countPrimes(499979));
    }
}
