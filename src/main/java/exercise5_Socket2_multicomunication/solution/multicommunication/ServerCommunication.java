package exercise5_Socket2_multicomunication.solution.multicommunication;

import exercise5_Socket2_multicomunication.SolutionProf.multicommunication.ServerReaderThread;
import exercise5_Socket2_multicomunication.SolutionProf.multicommunication.ServerWriterManager;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerCommunication {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5555);
            ServerWriterManager manager = new ServerWriterManager();
            while (true){
                Socket client = serverSocket.accept();
                new ServerReaderThread(client, manager).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
