package exercise12_Thread_BlockingQueue.SolutionProf.primenumbertwins;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainWithThreads {
    public static void main(String[] args) {
        try {
            int numberOfThreads = 4;
            PrimeNumberTwins primeNumberTwins = new PrimeNumberTwins();
            long start = System.currentTimeMillis();
            PrimeFinderThread[] threads = new PrimeFinderThread[numberOfThreads-1];
            for (int i=0; i < numberOfThreads -1; i++){
                threads[i] = new PrimeFinderThread(primeNumberTwins);
                threads[i].start();
            }
            for (int i=0; i < numberOfThreads -1; i++){
                threads[i].join();
            }
            long end = System.currentTimeMillis();
            System.out.println("Time needed with threads "+ ((end - start)) + " msec");
            List<Integer> twinList = primeNumberTwins.getTwinList();
            for (int i=0; i < twinList.size()-1; i = i+2){
                System.out.println(twinList.get(i) + " " + twinList.get(i+1));
            }
            System.out.println("Time needed with threads "+ ((end - start)) + " msec");
            System.out.println("Prime number twins found: " + (twinList.size()/2));
        } catch (InterruptedException ex) {
            Logger.getLogger(MainWithThreads.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
