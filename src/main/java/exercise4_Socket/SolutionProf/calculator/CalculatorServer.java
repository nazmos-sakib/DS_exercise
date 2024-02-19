package exercise4_Socket.SolutionProf.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculatorServer {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5555);
            while (true) {
                Socket client = server.accept();
                BufferedReader incoming = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter send = new PrintWriter(client.getOutputStream());
                String inputString = incoming.readLine();
                String[] input = inputString.split(";");
                String retval;
                try {
                    Calculation calculation = new Calculation(input[0], input[1], input[2]);
                    calculation.compute();
                    retval = calculation.getResult();
                } catch (Exception ex) {
                    retval = "Error:" + ex.getMessage();
                }
                send.println(retval);
                send.flush();
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
