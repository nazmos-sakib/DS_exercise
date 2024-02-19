package exercise5_Socket2_multicomunication.solution.multicommunication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JTextArea;

public class ClientCommunication {

    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;
    private Thread thread;
    String username;

    public void connect(String username, JTextArea messages) {
        this.username = username;
        try {
            socket = new Socket("localhost",5555);
            this.reader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            this.writer = new PrintWriter(this.socket.getOutputStream());

            this.thread = new ClientReaderThread(this.reader,messages);
            this.thread.start();
            writer.println("Connected:"+username );
            writer.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void disconnect() {
        try {
            writer.println("Disconnect:"+username );
            writer.flush();
            thread.interrupt();
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}