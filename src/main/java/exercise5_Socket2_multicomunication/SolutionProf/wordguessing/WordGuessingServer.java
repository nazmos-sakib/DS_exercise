package exercise5_Socket2_multicomunication.SolutionProf.wordguessing;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WordGuessingServer {

    public static void main(String[] args) {
        try {
            Wordguessing wordguessing = new Wordguessing();
            ServerSocket server = new ServerSocket(5555);
            while (true) {
                Socket client = server.accept();
                WordGuessingThread thread = new WordGuessingThread(client);
                thread.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(WordGuessingThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
