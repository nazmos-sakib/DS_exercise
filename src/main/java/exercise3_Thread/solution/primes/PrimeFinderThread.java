package exercise3_Thread.solution.primes;

import java.util.ArrayList;
import java.util.List;

public class PrimeFinderThread extends Thread{
    List<Integer> primes;
    int lower;
    int range;

    public PrimeFinderThread(int lower, int range) {
        this.primes = new ArrayList<>();
        this.lower = lower;
        this.range = range;
    }

    public List<Integer> getPrimes() {
        return primes;
    }

    public void run(){
        primes = Primes.findPrimes(this.lower,this.range);
    }
}
