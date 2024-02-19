package exercise12_Thread_BlockingQueue.solution.producerconsumer;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable { BlockingQueue<String> queueNoun;
    BlockingQueue<String> queueVerb;int numberOfSentences;
    public Consumer(BlockingQueue<String> queueNoun,BlockingQueue<String> queueVerb,int numberOfSentences){
        this.numberOfSentences=numberOfSentences;
        this.queueNoun = queueNoun;
        this.queueVerb = queueVerb;
    }
    @Override
    public void run() {
        for (int i=0;i<numberOfSentences;i++){
            try {
                System.out.println(queueNoun.take()+" "+
                        queueVerb.take()+" "+queueNoun.take());
                //Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }
    }

}
