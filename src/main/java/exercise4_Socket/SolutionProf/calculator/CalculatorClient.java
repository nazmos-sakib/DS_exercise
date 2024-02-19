package exercise4_Socket.SolutionProf.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author neuhardt
 */
public class CalculatorClient {
    public static String compute(String firstOperand, String secondOperand, String operation){
        BufferedReader reader = null;
        PrintWriter out = null;
        Socket socket = null;
        String result = null;
        try {
            socket = new Socket("127.0.0.1", 5555);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //printwriter is output object
            out = new PrintWriter(socket.getOutputStream());
            out.println(firstOperand+";"+secondOperand+";"+operation);
            out.flush();
            result = reader.readLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (socket != null)  {
                    socket.close();
                    socket = null;
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            } 
        }
        return result;
    }
}
