package exercise5_Socket2_multicomunication.solution.wordguessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author neuhardt
 */
public class WordGuessingClient {

    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    public void connect() {
        try {
            socket = socket = new Socket("localhost",5555);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String getLetters() {
        if (socket!=null){
            writer.println("New Letters");
            writer.flush();
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return "Not connected";
    }
    public String wordGuessed(String word) {
        if (socket!=null){
            writer.println(word);
            writer.flush();
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return "Not connected";
    }

    public void close() {
        try {
            if (socket != null) {
                socket.close();
            }
            socket = null;
            writer = null;
            reader = null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
