package exercise3_Thread.SolutionProf.primes;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainWithThreads {
    public static void main(String[] args) {
        try {
            int lower = 1900000000;
            int range = 5000000;
            int numberOfThreads = 4;
            int threadRange = range / numberOfThreads - 1;
            long start = System.currentTimeMillis();
            PrimeFinderThread[] threads = new PrimeFinderThread[numberOfThreads-1];
            for (int i=0; i < numberOfThreads -1; i++){
                threads[i] = new PrimeFinderThread(lower + i * threadRange, threadRange);
                threads[i].start();
            }
            List<Integer> primes = Primes.findPrimes(lower + (numberOfThreads-1) * threadRange - 1, threadRange);
            for (int i=0; i < numberOfThreads -1; i++){
                threads[i].join();
            }
            long end = System.currentTimeMillis();
            System.out.println("Time needed with threads "+ ((end - start)) + " msec");
            int sum = primes.size();
            for (int i=0; i < numberOfThreads -1; i++){
                sum += threads[i].getPrimes().size();
            }
            System.out.println("Primes found: " + sum);
        } catch (InterruptedException ex) {
            Logger.getLogger(MainWithThreads.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
