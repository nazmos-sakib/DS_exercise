package exercise7_RMI_Multicommunication.problem1WordGuessing.wordGuessingServer;

import exercise7_RMI_Multicommunication.problem1WordGuessing.wordGuessingInterface.Wordguessing;
import exercise7_RMI_Multicommunication.problem1WordGuessing.wordGuessingInterface.WordguessingFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class WordguessingFactoryImpl extends UnicastRemoteObject implements WordguessingFactory {
    public WordguessingFactoryImpl() throws RemoteException{

    }
    @Override
    public Wordguessing getWordGuessing() throws RemoteException {
        return new WordguessingImpl();
    }
}
