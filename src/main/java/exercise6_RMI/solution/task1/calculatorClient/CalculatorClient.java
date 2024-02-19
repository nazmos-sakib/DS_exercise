package exercise6_RMI.solution.task1.calculatorClient;

import exercise6_RMI.solution.task1.calculatorInterface.Calculator;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class CalculatorClient {
    public static String compute(int firstNumber, int secondNumber, String operation){


        try {
            Calculator calculator = (Calculator) Naming.lookup("//localhost/Calculation");
            if (operation.equals("+")){
                return Integer.toString(calculator.plus(firstNumber, secondNumber));
            } else if (operation.equals("-")){
                return Integer.toString(calculator.minus(firstNumber, secondNumber));
            }else if (operation.equals("*")){
                return Integer.toString(calculator.multiply(firstNumber, secondNumber));
            }if (operation.equals("/")){
                try {
                    return Integer.toString(calculator.divide(firstNumber, secondNumber));
                }catch (RemoteException e){
                    return e.getMessage();
                }
            } else {
                return "Unknown operator";
            }
        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            throw new RuntimeException(e);
        }

    }
}
