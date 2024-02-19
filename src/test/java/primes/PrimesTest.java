package primes;

import exercise3_Thread.solution.primes.Primes;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrimesTest {
    
    public PrimesTest() {
    }
    
    
    @Test
    public void testPrimesTo10(){
        List<Integer> primes = Primes.findPrimes(0,10);
        System.out.println("Primes: ");
        for (Integer i: primes){
            System.out.print(i + "; ");
        }
        System.out.println("");
        assertEquals(4, primes.size());
    }

    @Test
    public void testPrimesTo20(){
        List<Integer> primes = Primes.findPrimes(-5,25);
        System.out.println("Primes: ");
        for (Integer i: primes){
            System.out.print(i + "; ");
        }
        System.out.println("");
        assertEquals(8, primes.size());
    }

    @Test
    public void testPrimesTo23(){
        List<Integer> primes = Primes.findPrimes(0,23);
        System.out.println("Primes: ");
        for (Integer i: primes){
            System.out.print(i + "; ");
        }
        System.out.println("");
        assertEquals(9, primes.size());
    }
}
