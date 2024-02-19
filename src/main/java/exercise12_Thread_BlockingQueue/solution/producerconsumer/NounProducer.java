package exercise12_Thread_BlockingQueue.solution.producerconsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class NounProducer implements Runnable {
    private final String[] nouns = {"dog", "cat", "mouse", "elephant", "tiger"};
    BlockingQueue<String> queue;
    int numberOfElements;

    public NounProducer(BlockingQueue<String> queue,int numberOfElements){
     this.numberOfElements = numberOfElements;
     this.queue = queue;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i=0;i<numberOfElements;i++){
            int index = random.nextInt(nouns.length);
            try {
                queue.put(nouns[index]);
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }
    }

}
