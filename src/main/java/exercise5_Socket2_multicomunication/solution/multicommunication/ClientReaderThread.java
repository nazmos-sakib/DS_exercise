package exercise5_Socket2_multicomunication.solution.multicommunication;

import java.io.BufferedReader;
import java.io.IOException;
import javax.swing.JTextArea;

public class ClientReaderThread extends Thread {
    private BufferedReader reader;
    private JTextArea messages;

    ClientReaderThread(BufferedReader reader, JTextArea messages) {
        this.reader = reader;
        this.messages = messages;
    }

    
    @Override
    public void run() {
        while (!this.isInterrupted()){
            try {
                messages.append(reader.readLine()+"\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
