package exercise7_RMI_Multicommunication.problem1WordGuessing.wordGuessingClient;


import exercise7_RMI_Multicommunication.problem1WordGuessing.wordGuessingInterface.Wordguessing;
import exercise7_RMI_Multicommunication.problem1WordGuessing.wordGuessingInterface.WordguessingFactory;

import java.rmi.Naming;
import java.rmi.RemoteException;

public class WordguessingClient {
    private Wordguessing wordguessing;

    public WordguessingClient() {
        wordguessing = null;
        try {
            WordguessingFactory factory = (WordguessingFactory) Naming.lookup("//localhost/wordGuessingFactory");
            wordguessing = factory.getWordGuessing();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public String getLetters()   {
        //throw new UnsupportedOperationException();
        try {
            return wordguessing.getLetters();
        } catch (RemoteException e){
            e.printStackTrace();
        }
        return "Error: Remote Exception received";
    }
    
    public String guessWord(String word){
        //throw new UnsupportedOperationException();
        try {
            return wordguessing.guessWord(word);
        } catch (RemoteException e){
            e.printStackTrace();
        }
        return "Error: Remote Exception received";
    }
        
}
