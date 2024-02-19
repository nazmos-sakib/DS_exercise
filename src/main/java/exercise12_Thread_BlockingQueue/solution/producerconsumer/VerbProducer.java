package exercise12_Thread_BlockingQueue.solution.producerconsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class VerbProducer implements Runnable{
    private final String[] verbs = {"sees", "follows", "likes", "ignores"};
    BlockingQueue<String> queue;int numberOfElements;
    public VerbProducer(BlockingQueue<String> queue,int numberOfElements){
        this.numberOfElements = numberOfElements;
        this.queue = queue;
    }
    @Override
    public void run() {
        Random random = new Random();
        for (int i=0;i<numberOfElements;i++){
            int index = random.nextInt(verbs.length);
            try {
                queue.put(verbs[index]);
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }
    }    
}
