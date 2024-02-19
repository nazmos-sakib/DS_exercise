package exercise12_Thread_BlockingQueue.solution.primenumbertwins;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author neuhardt
 */
public class PrimeNumberTwins {

    public static boolean isPrime(int number) {
        for (int i = 2; i * i <= number; i = i + 1) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private final int lower = 1900000000;
    private final int range = 2000000;
    private int current = lower;
    private final List<Integer> twinList = new ArrayList<>();

    public int getNextNumber() {
        int value = current;
        current = current + 1;
        if (current > lower + range){
            value = -1;
        }
        return value;
    }

    public void addPrimeNumberTwins(int first, int second) {
        twinList.add(first);
        twinList.add(second);
    }

    public List<Integer> getTwinList() {
        return twinList;
    }

}
