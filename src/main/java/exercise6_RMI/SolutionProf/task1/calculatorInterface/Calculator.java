package exercise6_RMI.SolutionProf.task1.calculatorInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote{
    int plus(int firstNumber, int secondNumber) throws RemoteException;
    int minus(int firstNumber, int secondNumber) throws RemoteException;
    int multiply(int firstNumber, int secondNumber) throws RemoteException;
    int divide(int firstNumber, int secondNumber) throws RemoteException;
}
