package exercise4_Socket.solution.calculator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculatorServer {

    public static void main(String[] args) {
    	// TODO: add implementations

        String collectMessages = "";
        try {
            ServerSocket server = new ServerSocket(5555);

            while (true){
                Socket socket = server.accept();
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream());
                String input = reader.readLine();
                String[] all = input.split("@");
                Calculation obj = new Calculation(all[0], all[2], all[1]);
                try {
                    obj.compute();
                    writer.println(obj.getResult());
                } catch (RuntimeException e){
                    writer.println(e.getMessage());
                }
                writer.flush();
                socket.close();
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
