package iezon.main;

import iezon.interfaces.options.InterfaceController;
import iezon.updates.UpdateController;
import iezon.users.UserController;

public class Init {
	
	private UpdateController uc = new UpdateController();
	public static UserController usrController = new UserController();
	public static Client c = new Client();

	public Init() {
		/* uc.update(); */
		Window.run();
	}

	public static void main(String[] args) {
		
		// TODO: Add CMD execution for updates
		if(args.length > 0 && args[0].equalsIgnoreCase("update")) {
			InterfaceController.showDialog(new Object[] { "Ok" }, "You are updated!");
		}
		
		new Init();
	}

}
