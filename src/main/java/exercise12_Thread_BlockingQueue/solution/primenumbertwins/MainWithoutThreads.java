package exercise12_Thread_BlockingQueue.solution.primenumbertwins;

import java.util.List;

public class MainWithoutThreads {

    public static void main(String[] args) {
        PrimeNumberTwins primeNumberTwins = new PrimeNumberTwins();
        long start = System.currentTimeMillis();
        boolean hasMoreNumbers = true;
        while (hasMoreNumbers) {
            int number = primeNumberTwins.getNextNumber();
            if (number > 0) {
                if (PrimeNumberTwins.isPrime(number) && PrimeNumberTwins.isPrime(number + 2)) {
                    primeNumberTwins.addPrimeNumberTwins(number, number + 2);
                }
            } else {
                hasMoreNumbers = false;
            }
        }
        long end = System.currentTimeMillis();
        List<Integer> twinList = primeNumberTwins.getTwinList();
        for (int i = 0; i < twinList.size() - 1; i = i + 2) {
            System.out.println(twinList.get(i) + " " + twinList.get(i + 1));
        }
        System.out.println("Time needed with threads " + ((end - start)) + " msec");
        System.out.println("Prime number twins found: " + (twinList.size() / 2));
    }
}
