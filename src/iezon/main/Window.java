package iezon.main;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;

import iezon.interfaces.UserLockScreen;
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
		initialize();
		initPanels();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	}
	
	private void initPanels() {
		guiController.addPanel("User Lock Screen", new UserLockScreen());
	}
}
