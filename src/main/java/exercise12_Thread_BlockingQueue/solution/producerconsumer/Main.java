package exercise12_Thread_BlockingQueue.solution.producerconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {

    public static void main(String[] args) {
        BlockingQueue<String> queueNoun = new ArrayBlockingQueue<>(10);
        BlockingQueue<String> queueVerb = new ArrayBlockingQueue<>(10);

        new Thread(new NounProducer(
                queueNoun, 10
        )).start();

        new Thread(new VerbProducer(
                queueVerb, 10
        )).start();

        new Thread(new Consumer(
                queueNoun,queueVerb, 10
        )).start();

        System.out.println("started");

    }
    
}
