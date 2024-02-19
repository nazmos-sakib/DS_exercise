package exercise6_RMI.SolutionProf.task1.calculatorClient;


import exercise6_RMI.solution.task1.calculatorInterface.Calculator;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author neuhardt
 */
public class CalculatorClient {
    public static String compute(int firstNumber, int secondNumber, String operation){
        try {
            Calculator calculator = (Calculator) Naming.lookup("//localhost/Calculation");
            if (operation.equals("+")){
                return Integer.toString(calculator.plus(firstNumber, secondNumber));
            } else if (operation.equals("-")){
                return Integer.toString(calculator.minus(firstNumber, secondNumber));
            } else if (operation.equals("*")){
                return Integer.toString(calculator.multiply(firstNumber, secondNumber));
            } else if (operation.equals("/")){
                return Integer.toString(calculator.divide(firstNumber, secondNumber));
            } else {
                return "Error: Unknown operation";
            }
        } catch (RemoteException ex){
            if (ex.getMessage()!= null) {
                return ex.getCause().getMessage();
            } 
        } catch (NotBoundException | MalformedURLException ex) {
                Logger.getLogger(CalculatorClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Error has occured";
    }
}
