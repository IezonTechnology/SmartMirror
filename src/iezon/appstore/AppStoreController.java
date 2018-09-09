package iezon.appstore;

import java.util.ArrayList;

public class AppStoreController {
	
	public ArrayList<App> Apps = new ArrayList<App>();
	public App newApp;
	

	public AppStoreController() {
		
		Apps.add(new App ("Application A", null, 0, false));
		Apps.add(new App("Application B", null, 0, false));
		Apps.add(new App("Application C", null, 0, false));
		Apps.add(new App("Application D", null, 0, false));
		Apps.add(new App("Application F", null, 0, false));
		Apps.add(new App("Application G", null, 0, false));
		Apps.add(new App("Application H", null, 0, false));
		Apps.add(new App("Application I", null, 0, false));
		Apps.add(new App("Application J", null, 0, false));
		Apps.add(new App("Application K", null, 0, false));
		Apps.add(new App("Application L", null, 0, false));

	}
	
	public void AddNewApp() {
		//add new app to the arraylist
	}
	
	public ArrayList<App> getAllApps() {
		return Apps;
	}
	
	

}
