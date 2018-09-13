package iezon.appstore;

import java.util.ArrayList;

public class AppStoreController {
	
	public ArrayList<App> Apps = new ArrayList<App>();
	public App newApp;
	

	public AppStoreController() {
		
		Apps.add(new App ("Application A", "Test app", 0));
		Apps.add(new App("Application B", "Test app", 0));
		Apps.add(new App("Application C", "Test app", 0));
		Apps.add(new App("Application D", "Test app", 0));
		Apps.add(new App("Application F", "Test app", 0));
		Apps.add(new App("Application G", "Test app", 0));
		Apps.add(new App("Application H", "Test app", 0));
		Apps.add(new App("Application I", "Test app", 0));
		Apps.add(new App("Application J", "Test app", 0));
		Apps.add(new App("Application K", "Test app", 0));
		Apps.add(new App("Application L", "Test app", 0));

	}
	
	public void AddNewApp() {
		//add new app to the arraylist
	}
	
	public ArrayList<App> getAllApps() {
		return Apps;
	}
	
	

}
