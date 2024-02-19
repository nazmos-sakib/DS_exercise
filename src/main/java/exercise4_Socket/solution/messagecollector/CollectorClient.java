package exercise4_Socket.solution.messagecollector;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class CollectorClient {
    public static String sendAndReceive(String message){
        //TODO add implementation

        Socket socket = null;
        BufferedReader reader = null;
        PrintWriter writer = null;
        String result = "";

        try {
            socket = new Socket("localhost",5555);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream());
            writer.println(message);
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
