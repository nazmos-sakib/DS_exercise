package exercise5_Socket2_multicomunication.SolutionProf.multicommunication;

import java.io.BufferedReader;
import java.io.IOException;
import javax.swing.JTextArea;

public class ClientReaderThread extends Thread {
    private final BufferedReader reader;
    private final JTextArea messages;

    ClientReaderThread(BufferedReader reader, JTextArea messages) {
        this.reader = reader;
        this.messages = messages;
    }

    
    @Override
    public void run() {
        while (!this.isInterrupted()) {
            try {
                String input = reader.readLine();
                messages.append(input + "\n");
            } catch (IOException ex) {
                System.out.println("Client thread stopped");
            }
        }
    }

}
