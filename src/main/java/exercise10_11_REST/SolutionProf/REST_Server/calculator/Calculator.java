package exercise10_11_REST.SolutionProf.REST_Server.calculator;

public class Calculator {

    public Calculator() {
    }

    public int plus(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    public int minus(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }

    public int multiply(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }

    public int divide(int firstNumber, int secondNumber) {
        if (secondNumber == 0){
            throw new RuntimeException("Error: Divide by zero not allowed.");
        }
        return firstNumber / secondNumber;
    }
}
