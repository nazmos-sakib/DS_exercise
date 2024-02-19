package exercise7_RMI_Multicommunication.problem1WordGuessing.wordGuessingInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Wordguessing extends Remote{
    String getLetters() throws RemoteException;
    String guessWord(String guess) throws RemoteException;
}
