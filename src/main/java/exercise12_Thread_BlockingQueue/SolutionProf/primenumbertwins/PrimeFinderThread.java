package exercise12_Thread_BlockingQueue.SolutionProf.primenumbertwins;

public class PrimeFinderThread extends Thread {

    private final PrimeNumberTwins primeNumberTwins;

    public PrimeFinderThread(PrimeNumberTwins primeNumberTwins) {
        this.primeNumberTwins = primeNumberTwins;
    }

    @Override
    public void run() {
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
    }

}
