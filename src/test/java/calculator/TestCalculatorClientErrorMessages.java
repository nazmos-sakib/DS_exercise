package calculator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import exercise4_Socket.solution.calculator.CalculatorClient;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author neuhardt
 */
public class TestCalculatorClientErrorMessages {
    
    public TestCalculatorClientErrorMessages() {
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
    public void test1OpNotNumber(){
        String result = CalculatorClient.compute("a", "1", "+");
        String results[] = result.split(":");
        assertEquals("Error", results[0]);
        assertEquals("Number 1 is not a number", results[1]);
    }

    @Test
    public void test2OpNotNumber(){
        String result = CalculatorClient.compute("1", "b", "+");
        String results[] = result.split(":");
        assertEquals("Error", results[0]);
        assertEquals("Number 2 is not a number", results[1]);
    }

    @Test
    public void testOpNotValidNumber(){
        String result = CalculatorClient.compute("1", "1", "!");
        String results[] = result.split(":");
        assertEquals("Error", results[0]);
        assertEquals("Operation invalid", results[1]);
    }

    @Test
    public void testDivideByZero(){
        String result = CalculatorClient.compute("1", "0", "/");
        String results[] = result.split(":");
        assertEquals("Error", results[0]);
        assertEquals("Number 2 must not be zero in division", results[1]);
    }

}
