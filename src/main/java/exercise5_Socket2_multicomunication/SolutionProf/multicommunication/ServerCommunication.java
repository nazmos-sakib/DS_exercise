package exercise5_Socket2_multicomunication.SolutionProf.multicommunication;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerCommunication {

    public static void main(String[] args) {
        ServerSocket server = null;
        ServerWriterManager manager = new ServerWriterManager();
        try {
            server = new ServerSocket(5555);
            while (true) {
                Socket socket = server.accept();
                new ServerReaderThread(socket, manager).start();
            }
        } catch (IOException ex) {
            Logger.getLogger(ServerCommunication.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
}
