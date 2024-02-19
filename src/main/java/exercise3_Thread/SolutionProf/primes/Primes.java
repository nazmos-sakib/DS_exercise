package exercise3_Thread.SolutionProf.primes;

import java.util.ArrayList;
import java.util.List;

public class Primes {
    public static List<Integer> findPrimes (int lower, int range){
        List<Integer> primes = new ArrayList<>();
        int i = 0;
        if (lower % 2 == 0){
            i = 1;
        }
        if (lower <= 2 && lower + range >= 2){
            primes.add(2);
        }
        for (;i < range; i = i+2){
            int number = lower + i;
            if (number <= 2){
                continue;
            } else {
            }
            boolean isPrime = true;
            for (int j = 3; j*j <= number; j = j + 2){
                if ( number % j == 0){
                    isPrime = false;
                    break;
                }
            }
            if (isPrime){
                primes.add(number);
            }
        }
        return primes;
    }
}
