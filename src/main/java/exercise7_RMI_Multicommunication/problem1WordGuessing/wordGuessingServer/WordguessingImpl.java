package exercise7_RMI_Multicommunication.problem1WordGuessing.wordGuessingServer;

import exercise7_RMI_Multicommunication.problem1WordGuessing.wordGuessingInterface.Wordguessing;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;
import java.util.Random;

public class WordguessingImpl extends UnicastRemoteObject implements Wordguessing {
    private final String[] wordlist = {"computer", "system", "message", "socket", "distributed", "remote"};
    private String actualWord;
    private boolean gameOver;
    public WordguessingImpl() throws RemoteException {
        int i = new Random().nextInt(wordlist.length);
        actualWord = wordlist[i];
        gameOver = false;
    }
    public String getLetters() {
        if (gameOver) {
            int i = new Random().nextInt(wordlist.length);
            actualWord = wordlist[i];
            gameOver = false;
        }
        char[] letters = actualWord.toCharArray();
        Arrays.sort(letters);
        return new String(letters);
    }
    public String guessWord(String guess){
        if (gameOver){
            return "You must ask for new letters.";
        }
        System.out.println("actual Word: <" + actualWord + ">");
        System.out.println("guess: <" + guess + ">");
        if (guess.equalsIgnoreCase(actualWord)){
            gameOver = true;
            return "Congratulation. You have won. Ask for a new word.";
        }
        return "Sorry. This is not the correct word.";
    }
}
