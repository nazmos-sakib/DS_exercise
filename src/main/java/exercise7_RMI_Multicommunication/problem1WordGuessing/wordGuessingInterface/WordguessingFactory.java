package exercise7_RMI_Multicommunication.problem1WordGuessing.wordGuessingInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface WordguessingFactory extends Remote{
    Wordguessing getWordGuessing() throws RemoteException;
}
