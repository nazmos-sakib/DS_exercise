package substring;

import exercise3_Thread.solution.substring.SubstringFinder;
import exercise3_Thread.solution.substring.SubstringFinderThread;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;


public class SubstringFinderTest {

    @Test
    public void noSubstring(){
        assertEquals(-1, SubstringFinder.findDuplicate("abcd", 1, 2));
    }
    @Test
    public void oneChar(){
        assertEquals(3, SubstringFinder.findDuplicate("abcb", 1, 1));
    }
    @Test
    public void twoChars(){
        assertEquals(2, SubstringFinder.findDuplicate("abbb", 1, 2));
    }
    @Test
    public void noChars1(){
        assertEquals("", SubstringFinder.findDuplicate("abcd", 1));
    }
    @Test
    public void oneChar1(){
        assertEquals("b", SubstringFinder.findDuplicate("abcb", 1));
    }
    @Test
    public void twoChars2(){
        assertEquals("bb", SubstringFinder.findDuplicate("abbbd", 2));
    }
    @Test
    public void noChars2(){
        assertEquals("", SubstringFinder.findlongestDuplicate("abcd"));
    }
    @Test
    public void oneChar2(){
        assertEquals("b", SubstringFinder.findlongestDuplicate("abcb"));
    }
    @Test
    public void twoChars3(){
        assertEquals("bb", SubstringFinder.findlongestDuplicate("abbbd"));
    }
    @Test
    public void threeChars3(){
        assertEquals("aba", SubstringFinder.findlongestDuplicate("ababa"));
    }
    @Test
    public void substringFinderWithoutThreads(){
        int arraySize = 1500;
        int base = 500000009;        int a = 10001;
        StringBuilder str = new StringBuilder(arraySize);
        for (int i = 0; i< arraySize/10; i++){
            a = (a * a + 1) % base;
            str.append(a);
        }
        String word = str.toString();
        System.out.println(word.length());
        long start = System.currentTimeMillis();
        String sub = SubstringFinder.findlongestDuplicate(word);
        long end = System.currentTimeMillis();
        System.out.println(sub);
        System.out.println("Time needed w/o threads "+ ((end - start)) + " msec");
    }
    @Test
    public void substringFinderWithThreads(){
        int arraySize = 1500;
        int base = 500000009;        int a = 10001;
        StringBuilder str = new StringBuilder(arraySize);
        for (int i = 0; i < arraySize/10; i++){
            a = (a * a + 1) % base;
            str.append(a);
        }
        String word = str.toString();
        System.out.println(word.length());
        SubstringFinderThread[] threads = new SubstringFinderThread[4];
        for(int i = 0; i < threads.length; i++){
            threads[i] = new SubstringFinderThread(word.length() - 1 - i, threads.length, word);
        }
        long start = System.currentTimeMillis();
        for(int i = 0; i < threads.length; i++){
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++){
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        String result = threads[0].getResult();
        for(int i = 1; i < threads.length; i++){
            if (threads[i].getResult().length() > result.length()){
                result = threads[i].getResult();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(result);
        System.out.println("Time needed w/o threads "+ ((end - start)) + " msec");
    }
}
