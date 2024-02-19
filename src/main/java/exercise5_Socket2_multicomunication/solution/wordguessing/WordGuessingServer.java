package exercise5_Socket2_multicomunication.solution.wordguessing;

import exercise5_Socket2_multicomunication.SolutionProf.wordguessing.WordGuessingThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WordGuessingServer {

    public static void main(String[] args)  {
        try {
            ServerSocket server = new ServerSocket(5555);
            while (true){
                Socket client = server.accept();
                WordGuessingThread thread = new WordGuessingThread(client);
                thread.start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
