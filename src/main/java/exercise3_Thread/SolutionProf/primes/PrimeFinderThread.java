package exercise3_Thread.SolutionProf.primes;

import java.util.ArrayList;
import java.util.List;

public class PrimeFinderThread extends Thread{
    private List<Integer> primes;
    private final int lower;
    private final int range;

    public PrimeFinderThread(int lower, int range) {
        this.lower = lower;
        this.range = range;
        primes = new ArrayList<>();
    }
    
    @Override
    public void run(){
        primes = Primes.findPrimes(lower, range);
    }

    public List<Integer> getPrimes() {
        return primes;
    }    
}
