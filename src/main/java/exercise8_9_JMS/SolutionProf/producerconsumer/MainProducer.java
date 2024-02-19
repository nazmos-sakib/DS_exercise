package exercise8_9_JMS.SolutionProf.producerconsumer;

public class MainProducer {
    public static void main(String[] args) {
        int numberOfSentences = 5;
        String nounsQueue = "Nouns";
        String verbsQueue = "Verbs";
        NounProducer nounProducer = new NounProducer(2 * numberOfSentences,nounsQueue);
        VerbProducer verbProducer = new VerbProducer(numberOfSentences, verbsQueue);
        nounProducer.send();
        verbProducer.send();
    }
}
