package producerconsumer;

import exercise8_9_JMS.SolutionProf.queue.Consumer;
import exercise8_9_JMS.SolutionProf.queue.Producer;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ProducerConsumerTest {
    
    public ProducerConsumerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testProducerConsumer(){
        String queueName = "TestQueue";
        String message = "testMessage";
        Producer.sendMessage(queueName, message);
        assertEquals(message, Consumer.receiveMessage(queueName));
    }

        @Test
    public void testProducerConsumer2(){
        String queueName = "TestQueue2";
        String message1 = "testMessage1";
        String message2 = "testMessage2";
        Producer.sendMessage(queueName, message1);
        Producer.sendMessage(queueName, message2);
        assertEquals(message1, Consumer.receiveMessage(queueName));
        assertEquals(message2, Consumer.receiveMessage(queueName));
    }

}
