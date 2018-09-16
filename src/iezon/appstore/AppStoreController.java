package iezon.appstore;

import java.util.ArrayList;

import iezon.main.Init;

public class AppStoreController {

	public ArrayList<App> Apps = new ArrayList<App>();
	public App newApp;

	public AppStoreController() {
		
		if(Init.c.isOnline()) {
			for(App app : Init.c.retrieveAllApps()) {
				Apps.add(app);
			}
		}

	}
	
	public ArrayList<App> getAllApps() {
		return Apps;
	}

}
