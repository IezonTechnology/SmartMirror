package iezon.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import iezon.interfaces.options.InterfaceController;

public class Client {
	
	private Socket socket;
	private PrintWriter out;
	private BufferedReader in;

	public Client() {
		connect();
	}
	
	public void println(String message) {
		out.println(message);
	}
	
	public String readln() {
		try {
			return in.readLine();
		} catch (IOException e) {
			InterfaceController.showMessage("Could not connect to app server.");
		}
		return null;
	}
	
	private void connect() {
		try {
			socket = new Socket("your_ip", 4444);
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			InterfaceController.showMessage("Could not connect to app server.");
		}
	}

}
