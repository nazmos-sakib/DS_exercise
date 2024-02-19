package exercise3_Thread.SolutionProf.primes;

import java.util.List;

public class MainWithoutThreads {
    public static void main(String[] args) {
        int lower = 1900000000;
        int range = 5000000;
        long start = System.currentTimeMillis();
        List<Integer> primes = Primes.findPrimes(lower, range);
        long end = System.currentTimeMillis();
        System.out.println("Time needed w/o threads "+ ((end - start)) + " msec");
        System.out.println("Primes found: " + primes.size());
    } 
}
