package exercise3_Thread.solution.primes;

public class MainWithThreads {
    public static void main(String[] args) {
            int lower = 1900000000;
            int range = 5000000;

            //create some object of the PrimeFinderThread
            //start the Thread
            //wait until all thread are finished
            //collect data from each thread
            int numberOfThread = 4;
            PrimeFinderThread[] threads = new PrimeFinderThread[numberOfThread];
            int threadRange = range/numberOfThread;
            for (int i=0;i<numberOfThread;i++){
                threads[i] = new PrimeFinderThread(lower+i*threadRange,threadRange);
            }

            long start = System.currentTimeMillis();
            for (int i = 0;i<numberOfThread;i++){
                threads[i].start();
            }

            for (int i = 0;i<numberOfThread;i++){
                try {
                    threads[i].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            int sum = 0;
            for (int i = 0;i<numberOfThread;i++){
                sum+= threads[i].getPrimes().size();
            }
            long end = System.currentTimeMillis();
            System.out.println("Time needed with threads "+ ((end - start)) + " msec");
            System.out.println("Primes found: " + sum);

    }
    
}
