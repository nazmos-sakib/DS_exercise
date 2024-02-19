package exercise12_Thread_BlockingQueue.SolutionProf.producerconsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NounProducer implements Runnable {

    private final String[] nouns = {"dog", "cat", "mouse", "elephant", "tiger"};
    private final BlockingQueue<String> queue;
    private final int numberOfElements;

    public NounProducer(BlockingQueue<String> queue, int numberOfElements) {
        this.queue = queue;
        this.numberOfElements = numberOfElements;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < numberOfElements; i++) {
            try {
                int index = random.nextInt(nouns.length);
                queue.put(nouns[index]);
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(NounProducer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
