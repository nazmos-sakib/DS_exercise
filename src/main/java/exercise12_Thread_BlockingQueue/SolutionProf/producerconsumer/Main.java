package exercise12_Thread_BlockingQueue.SolutionProf.producerconsumer;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {

    public static void main(String[] args) {
        BlockingQueue<String> nouns = new ArrayBlockingQueue<>(3);
        BlockingQueue<String> verbs = new ArrayBlockingQueue<>(3);
        int numberOfSentences = 5;
        NounProducer nounProducer = new NounProducer(nouns, 2 * numberOfSentences);
        VerbProducer verbProducer = new VerbProducer(verbs, numberOfSentences);
        Consumer consumer = new Consumer(nouns, verbs, numberOfSentences);
        new Thread(verbProducer).start();
        new Thread(nounProducer).start();
        new Thread(consumer).start();
    }
    
}
