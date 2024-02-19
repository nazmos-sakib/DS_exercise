package messagecollector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import exercise4_Socket.solution.messagecollector.CollectorClient;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author neuhardt
 */
public class TestMessageCollector {
    
    public TestMessageCollector() {
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
    public void add1Message(){
        String s = "some text";
        assertEquals(s +" ", CollectorClient.sendAndReceive(s));
        String s1 = "hello";
        assertEquals(s + " " + s1 + " ", CollectorClient.sendAndReceive(s1));
    }
}
