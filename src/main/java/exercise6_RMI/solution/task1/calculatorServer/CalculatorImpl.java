package exercise6_RMI.solution.task1.calculatorServer;

import exercise6_RMI.solution.task1.calculatorInterface.Calculator;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorImpl extends UnicastRemoteObject implements Calculator {

    public CalculatorImpl() throws RemoteException {
    }

    @Override
    public int plus(int firstNumber, int secondNumber) throws RemoteException {
        return firstNumber + secondNumber;
    }

    @Override
    public int minus(int firstNumber, int secondNumber) throws RemoteException {
        return firstNumber - secondNumber;
    }

    @Override
    public int multiply(int firstNumber, int secondNumber) throws RemoteException {
        return firstNumber * secondNumber;
    }

    @Override
    public int divide(int firstNumber, int secondNumber) throws RemoteException {
        if (secondNumber == 0){
            throw new RemoteException("Error: Divide by zero not allowed.");
        }
        return firstNumber / secondNumber;
    }
}
