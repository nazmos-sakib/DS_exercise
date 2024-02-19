package exercise3_Thread.solution.substring;

public class SubstringFinder {
    public static int findDuplicate(String word, int start, int length){
        String first = word.substring(start, start + length);
        for (int j = start + 1; j + length <= word.length(); j++){
            if (first.equals(word.substring(j, j + length))){
                return j;
            }
        }
        return -1;
    }
    public static String findDuplicate(String word, int length){
        for(int i = 0; i + length < word.length(); i++){
            int result = findDuplicate(word, i, length);
            if (result >= 0){
                return word.substring(result, result + length);
            }
        }
        return "";
    }
    public static String findlongestDuplicate(String word){
        for(int length = word.length() - 1; length > 0; length--){
            String result = findDuplicate(word, length);
            if (!result.isEmpty()){
                return result;
            }
        }
        return "";
    }
}
