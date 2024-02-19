package exercise4_Socket.solution.calculator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class CalculatorClient {
    public static String compute(String firstOperand, String secondOperand, String operation){
    	// todo: add implmentation
        Socket socket = null;
        BufferedReader reader = null;
        PrintWriter writer = null;
        String result = "";
        try {
            socket = new Socket("localhost",5555);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream());
            writer.println(firstOperand+"@"+operation+"@"+secondOperand);
            writer.flush();
            result = reader.readLine();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return result;
    }
}
