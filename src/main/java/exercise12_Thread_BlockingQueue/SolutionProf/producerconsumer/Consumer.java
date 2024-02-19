package exercise12_Thread_BlockingQueue.SolutionProf.producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumer implements Runnable {
    private final BlockingQueue<String> nouns;
    private final BlockingQueue<String> verbs;
    private final int numberOfSentences;

    public Consumer(BlockingQueue<String> nouns, BlockingQueue<String> verbs, 
            int numberOfSentences) {
        this.nouns = nouns;
        this.verbs = verbs;
        this.numberOfSentences = numberOfSentences;
    }
    
    
    @Override
    public void run() {
       for (int i = 0; i < numberOfSentences; i++){
            try {
                String subject = nouns.take();
                String obj = nouns.take();
                String verb = verbs.take();
                System.out.println("The " + subject + " " + verb + " the " + obj + ".");
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
 
    }

}
