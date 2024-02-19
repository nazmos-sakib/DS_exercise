package exercise12_Thread_BlockingQueue.SolutionProf.producerconsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VerbProducer implements Runnable{
    private final String[] verbs = {"sees", "follows", "likes", "ignores"};
    private final BlockingQueue<String> queue;
    private final int numberOfElements;

    public VerbProducer(BlockingQueue<String> queue, int numberOfElements) {
        this.queue = queue;
        this.numberOfElements = numberOfElements;
    }
    
    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < numberOfElements; i++) {
            try {
                int index = random.nextInt(verbs.length);
                queue.put(verbs[index]);
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(NounProducer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    
}
