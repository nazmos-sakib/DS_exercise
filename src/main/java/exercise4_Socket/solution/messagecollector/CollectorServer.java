package exercise4_Socket.solution.messagecollector;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class CollectorServer {

    public static void main(String[] args) {
        // TODO add implementation

        String collectMessages = "";
        try {
            ServerSocket server = new ServerSocket(5555);

            while (true){
                Socket socket = server.accept();
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream());
                String input = reader.readLine();
                collectMessages += input + " ";
                writer.println(collectMessages);
                writer.flush();
                socket.close();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
