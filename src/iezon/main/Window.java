package iezon.main;

import java.awt.EventQueue;

import javax.swing.JFrame;

import iezon.interfaces.*;
import iezon.interfaces.options.Interface;
import iezon.interfaces.options.InterfaceController;

public class Window {

	public static JFrame frame;
	public static InterfaceController guiController = new InterfaceController();

	public static void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Window();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Window() {
		initPanels();
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		buildPanels();
		
		guiController.setVisible("User Lock Screen", true);
	}
	
	private void initPanels() {
		guiController.addPanel("Loading Screen", new LoadingScreen());
		guiController.addPanel("Home Screen", new HomeScreen());
		guiController.addPanel("Lock Screen", new LockScreen());
		guiController.addPanel("User Lock Screen", new UserLockScreen());
		guiController.addPanel("Applicaiton Store", new AppliationStore());
	}
	
	private void buildPanels() {
		for(Interface gui : guiController.getAllInterfaces()) {
			frame.getContentPane().add(gui.getPanel());
			guiController.setVisible(gui.getIdentity(), false);
		}
	}
}
