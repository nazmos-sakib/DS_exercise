package exercise8_9_JMS.SolutionProf.producerconsumer;

public class MainConsumer {
    public static void main(String[] args) {
        int numberOfSentences = 5;
        String nounsQueue = "Nouns";
        String verbsQueue = "Verbs";
        Consumer consumer = new Consumer(numberOfSentences, nounsQueue, verbsQueue);
        consumer.outputSentences();
    }
}
