package exercise3_Thread.solution.substring;

public class SubstringFinderThread extends Thread{
    private int length;
    private int step;
    private final String word;
    private String result = "";

    public SubstringFinderThread(int length, int step, String word) {
        this.length = length;
        this.step = step;
        this.word = word;
    }

    public String getResult() {
        return result;
    }

    @Override
    public void run(){
        while (length > 0 ){
            result = SubstringFinder.findDuplicate(word, length);
            if (!result.isEmpty()){
                return;
            }
            length -= step;
        }
    }
}
