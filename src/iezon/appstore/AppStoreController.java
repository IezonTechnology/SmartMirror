package iezon.appstore;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

import javax.swing.JPanel;

public class AppStoreController {

	public ArrayList<App> Apps = new ArrayList<App>();
	public App newApp;

	public AppStoreController() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

		try {
			
			/*
			 * Class classToLoad = Class.forName("iezon.app.NameOfApp",
			 * true,
			 * URLClassLoader child = new URLClassLoader (new URL[] {new
			 *     URL("file://./nameOfApp.jar")},this.getClass().getClassLoader())
			 * );
			 * Method method = classToLoad.getDeclaredMethod("run");
			 * Object instance = classToLoad.newInstance();
			 * Object result = method.invoke(instance);
			 */
			
			 /* Class<?> settingsApp = Class.forName(
				"iezon.app.SettingsApp",
				true,
				new URLClassLoader (new URL[] {
					new URL("file://C://Temp/SettingsApp.jar") },
					ClassLoader.getSystemClassLoader())
			); */
			 
			 JPanel settingsAppPanel = new JPanel();
			 
			 // TODO: Load all apps that are currently downloaded
			 // TODO: Connect to app store to download jars
			 
			 URLClassLoader clsLoader = URLClassLoader.newInstance(new URL[] {new URL("file:/C://Temp/SettingsApp.jar")});
		     Class<?> cls = clsLoader.loadClass("iezon.app.SettingsApp");
		     settingsAppPanel = (JPanel) cls.newInstance();
		     
		     // Method m = cls.getMethod("run");
		     // settingsAppPanel = (JPanel) m.invoke(cls.newInstance(), new Locale("", "", ""));
			
			/* File file = new File("C://Temp/SettingsApp.jar");
			URL url = file.toURI().toURL();
			URLClassLoader settingsApp = (URLClassLoader)ClassLoader.getSystemClassLoader();
			Method method = URLClassLoader.class.getDeclaredMethod("C://Temp/SettingsApp.jar", URL.class);
			method.setAccessible(true);
			JPanel settingsAppPanel = (JPanel) method.invoke(settingsApp, url); */
			
			Apps.add(new App("Settings", "Manage your smart mirror.", 0,  settingsAppPanel));
			Apps.add(new App("Application B", "Test app", 0,  new JPanel()));
			Apps.add(new App("Application C", "Test app", 0,  new JPanel()));
			Apps.add(new App("Application D", "Test app", 0,  new JPanel()));
			Apps.add(new App("Application E", "Test app", 0,  new JPanel()));
			Apps.add(new App("Application F", "Test app", 0,  new JPanel()));
			Apps.add(new App("Application G", "Test app", 0,  new JPanel()));
			Apps.add(new App("Application H", "Test app", 0,  new JPanel()));
			Apps.add(new App("Application I", "Test app", 0,  new JPanel()));
			Apps.add(new App("Application J", "Test app", 0,  new JPanel()));
			Apps.add(new App("Application K", "Test app", 0,  new JPanel()));
			Apps.add(new App("Application L", "Test app", 0,  new JPanel()));
		} catch (ClassNotFoundException | MalformedURLException | SecurityException | IllegalArgumentException | InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void AddNewApp() {
		// add new app to the arraylist
	}

	public ArrayList<App> getAllApps() {
		return Apps;
	}

}
