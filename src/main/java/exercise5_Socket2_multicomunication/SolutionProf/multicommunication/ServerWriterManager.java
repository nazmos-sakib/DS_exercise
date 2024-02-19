package exercise5_Socket2_multicomunication.SolutionProf.multicommunication;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerWriterManager {
    private final Map<String, PrintWriter> writerMap = new HashMap<>();  
    
    public synchronized void addUser(String username, String message, Socket socket) {
        try {
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            sendMessageToAll(message);
            writerMap.put(username, writer);
        } catch (IOException ex) {
            Logger.getLogger(ServerWriterManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public synchronized void removeUser(String username, String message) {
        writerMap.remove(username);
        sendMessageToAll(message);
    }

    private void sendMessageToAll(String message) {
        for (PrintWriter writer : writerMap.values()){
            writer.println(message);
            writer.flush();
        }
    }
}
