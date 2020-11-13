package messageThreads;

import java.io.BufferedReader;
import java.io.IOException;

import javax.swing.JTextArea;

public class MessageReader extends Thread{
	
	private BufferedReader bufferedReader;
	private JTextArea textArea;
	public MessageReader(BufferedReader bufferedReader, JTextArea textArea) {
		super();
		this.bufferedReader = bufferedReader;
		this.textArea = textArea;
		start();
	}
	public void run() {
		String sendMessage;
		while(true) {
			try {
				sendMessage = bufferedReader.readLine();
				if(sendMessage != null && !sendMessage.isEmpty()) {
					textArea.append(sendMessage);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
