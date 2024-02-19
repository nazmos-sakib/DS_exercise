/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;


import exercise4_Socket.solution.calculator.CalculatorClient;
import org.junit.jupiter.api.*;

import static org.testng.AssertJUnit.assertEquals;

/**
 *
 * @author neuhardt
 */
public class TestCalculatorClient {
    
    public TestCalculatorClient() {
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
    public void testAddition(){
        assertEquals("5", CalculatorClient.compute("2", "3", "+"));
    }

    @Test
    public void testSubtraction(){
        assertEquals("4",CalculatorClient.compute("7", "3", "-"));
    }

    @Test
    public void testMultiplication(){
        assertEquals("12",CalculatorClient.compute("3", "4", "*"));
    }

    @Test
    public void testDivision(){
        assertEquals("2",CalculatorClient.compute("15", "6", "/"));
    }

}
