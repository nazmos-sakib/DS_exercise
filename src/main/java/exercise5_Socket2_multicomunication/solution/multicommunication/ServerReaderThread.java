package exercise5_Socket2_multicomunication.solution.multicommunication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerReaderThread extends Thread {

    private Socket socket;
    private BufferedReader reader;
    private ServerWriterManager writerManager;

    public ServerReaderThread(Socket socket, ServerWriterManager writerManager) {
        this.socket = socket;
        this.writerManager = writerManager;
        try {
            this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void run() {
        while (true){
            try {
                String message = reader.readLine();
                String [] splittedMessage= message.split(":");
                if (splittedMessage[0].startsWith("Connected")){
                    writerManager.addUser(splittedMessage[1],message,this.socket);
                } else if (splittedMessage[0].startsWith("Disconnected")){
                    writerManager.removeUser(splittedMessage[1],message);
                    socket.close();
                    break;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
