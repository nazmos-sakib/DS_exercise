package exercise5_Socket2_multicomunication.SolutionProf.wordguessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            socket = new Socket("127.0.0.1", 5555);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //printwriter is output object
            writer = new PrintWriter(socket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(WordGuessingClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getLetters() {
        if (socket == null){
            return "Not connected";
        }
        String retval = null;
        try {
            writer.println("New Letters");
            writer.flush();
            retval = reader.readLine();
        } catch (IOException ex) {
            Logger.getLogger(WordGuessingClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retval;
    }

    public String wordGuessed(String word) {
        if (socket == null){
            return "Not connected";
        }
        try {
            writer.println(word);
            writer.flush();
            String retval = reader.readLine();
            return retval;
        } catch (IOException ex) {
            Logger.getLogger(WordGuessingClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Unknown Error";
    }

    public void close() {
        try {
            if (socket != null) {
                socket.close();
            }
            socket = null;
            writer = null;
            reader = null;
        } catch (IOException ex) {
            Logger.getLogger(WordGuessingClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
