package iezon.appstore;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import iezon.main.Init;

public class AppStoreController {

	public ArrayList<App> Apps = new ArrayList<App>();
	public App newApp;

	public AppStoreController() {

		/*URLClassLoader appLoader;
		Class<?> appBuilder = null;

		try {
			appLoader = URLClassLoader.newInstance(new URL[] { new URL("file:/C://Temp/SettingsApp.jar") });
			appBuilder = appLoader.loadClass("iezon.app.SettingsApp");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Apps.add(new App("Settings", 0.99, "Your easy to use settings.", Apps.size()).setClass(appBuilder)
				.setAuthor("Iezon")); */
		
		if(Init.c.isOnline()) {
			for(App app : Init.c.retrieveAllApps()) {
				Apps.add(app);
				// System.out.println("Added " + app.getName());
			}
		}

	}
	public ArrayList<App> getAllApps() {
		return Apps;
	}

}
