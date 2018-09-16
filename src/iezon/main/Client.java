package iezon.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;

import iezon.appstore.App;
import iezon.interfaces.options.InterfaceController;

public class Client {

	private boolean status = false;
	private Socket socket;
	private PrintWriter out;
	private BufferedReader in;

	public Client() {
		connect();
	}

	public boolean isOnline() {
		return status;
	}

	private void println(String message) {
		out.println(message);
	}

	private String readln() {
		try {
			String incomming = null;
			return (incomming = in.readLine()) != null ? incomming : null;
		} catch (IOException e) {
			InterfaceController.showMessage("Could not connect to app server.");
			status = false;
		}
		return null;
	}

	private void connect() {
		try {
			socket = new Socket("localhost", 43594);
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			status = true;
		} catch (IOException e) {
			InterfaceController.showMessage("Could not connect to app server.");
			e.printStackTrace();
		}
	}

	public ArrayList<App> retrieveAllApps() {
		ArrayList<App> appBuilder = new ArrayList<App>();
		println("get-all-apps");
		int appAmount = Integer.parseInt(readln());
		String response = null;
		int id = 0;
		for(int i = 1; i <= appAmount; i++) {
			response = readln();
			ArrayList<String> appContext = new ArrayList<String>();
			
			for (String micro : response.split("#")) {
				appContext.add(micro);
			}
			
			String name = appContext.get(0);
			double cost = Double.parseDouble(appContext.get(1));
			String description = appContext.get(2);
			URL url = null;
			try {
				url = new URL(appContext.get(3));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			appBuilder.add(new App(name, cost, description, id++).setDownloadUrl(url));
			response = null;
		}
		return appBuilder;
	}

}
