package exercise1_basic_Java.problem1;

import java.util.Scanner;

public class WordGuessingGame {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String word = "distributed";
        boolean wordGuessed = false;
        int position = 0;
        Scanner scanner = new Scanner(System.in);

        while(!wordGuessed){
            System.out.println("Please enter a character");
            char c = scanner.nextLine().charAt(0);
            if (c == word.charAt(position)){
                if (position == word.length()-1){
                    System.out.println("you guessed the word");
                    wordGuessed = true;
                } else {
                    System.out.println("That was correct");
                    position ++;
                }
            } else {
                System.out.println("Ops that was wrong");
            }

        }
    }

}
