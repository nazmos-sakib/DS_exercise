package exercise5_Socket2_multicomunication.solution.wordguessing;

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
public class WordGuessingThread extends Thread {

    private Wordguessing wordGuessing;
    private Socket socket;

    public WordGuessingThread(Socket socket){
        this.socket = socket;
        this.wordGuessing = new Wordguessing();
    }

    @Override
    public void run() {
        try {

            BufferedReader incoming = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter send = new PrintWriter(socket.getOutputStream());
            while (true) {
                String retval = "";
                String inputString = incoming.readLine();
                if (inputString.startsWith("New Letters")){
                    retval = wordGuessing.getLetters();
                } else {
                    retval = wordGuessing.guessWord(inputString);
                }
                send.println(retval);
                send.flush();
            }
        } catch (IOException e) {
            Logger.getLogger(WordGuessingThread.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            System.out.println("Thread finished");
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException ex) {
                    Logger.getLogger(WordGuessingThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }
}
