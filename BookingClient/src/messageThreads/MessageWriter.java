package messageThreads;

import java.io.PrintWriter;

import com.comtrade.domen.Message;

public class MessageWriter extends Thread{
	
	private PrintWriter printWriter;
	private Message message;
	public MessageWriter(PrintWriter printWriter, Message message) {
		super();
		this.printWriter = printWriter;
		this.message = message;
		start();
	}
	public void run() {
		while(true) {
			printWriter.println(message.getMessage());
		}
	}

}
