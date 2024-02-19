package exercise5_Socket2_multicomunication.SolutionProf.multicommunication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

public class ClientCommunication {

    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;
    private Thread thread;
    String username;

    public void connect(String username, JTextArea messages) {
        try {
            socket = new Socket("127.0.0.1", 5555);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream());
            thread = new ClientReaderThread(reader, messages);
            thread.start();
            this.username = username;
            writer.println("Connected:" + username);
            writer.flush();
        } catch (IOException ex) {
            Logger.getLogger(ClientCommunication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void disconnect() {
        try {
            writer.println("Disconnected:" + username);
            writer.flush();
            thread.interrupt();
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ClientCommunication.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
