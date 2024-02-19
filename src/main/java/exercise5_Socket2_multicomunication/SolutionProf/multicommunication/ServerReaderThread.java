package exercise5_Socket2_multicomunication.SolutionProf.multicommunication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerReaderThread extends Thread {

    private final Socket socket;
    private BufferedReader reader;
    private final ServerWriterManager writerManager;

    public ServerReaderThread(Socket socket, ServerWriterManager writerManager) {
        this.socket = socket;
        reader = null;
        try {
            this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(ServerReaderThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.writerManager = writerManager;
    }

    @Override
    public void run() {
        boolean ccontinue = true;
        while (ccontinue) {
            try {
                String input = reader.readLine();
                System.out.println(input);
                String[] values = input.split(":");
                switch (values[0]) {
                    case "Connected":
                        writerManager.addUser(values[1], input, socket);
                        break;
                    case "Disconnected":
                        writerManager.removeUser(values[1], input);
                        socket.close();
                        ccontinue = false;
                        break;
                    default:
                        System.out.println("Invalid message format: " + input);
                        break;
                }
            } catch (IOException ex) {
                Logger.getLogger(ServerReaderThread.class.getName()).log(Level.SEVERE, null, ex);
                break;
            }
        }

    }
}
