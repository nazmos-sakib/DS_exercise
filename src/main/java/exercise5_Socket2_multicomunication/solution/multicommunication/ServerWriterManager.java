package exercise5_Socket2_multicomunication.solution.multicommunication;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ServerWriterManager {
    private final Map<String, PrintWriter> writerMap = new HashMap<>();
    public synchronized void addUser(String username, String message, Socket socket) {
        try {
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            writer.println(message);
            writer.flush();
            writerMap.put(username,writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public synchronized void removeUser(String username, String message) {
        writerMap.remove(username);
        sendMessageToAll(message);
    }
    private void sendMessageToAll(String message) {
        writerMap.forEach((k,v)->{
            v.println(message);
            v.flush();
        });
    }
}
