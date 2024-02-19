package exercise4_Socket.SolutionProf.messagecollector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class CollectorServer {

    public static void main(String[] args) {
        String collectedMessages = "";
        try {
            ServerSocket server = new ServerSocket(5555);
            while (true) {
                Socket client = server.accept();
                BufferedReader incoming = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter send = new PrintWriter(client.getOutputStream());
                String inputString = incoming.readLine();
                collectedMessages = collectedMessages + inputString + " ";
                send.println(collectedMessages);
                send.flush();
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
