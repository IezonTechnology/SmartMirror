package iezon.users;

import java.util.ArrayList;
import java.util.Date;

public class UserController {
	
	private ArrayList<User> users = new ArrayList<User>();
	private User currentUser;

	@SuppressWarnings("deprecation")
	public UserController() {
		// TODO: Database load in stored users
		users.add(new User(users.size(), "Kyle", "Jeynes", new Date(1997, 12, 4), 5105));
		users.add(new User(users.size(), "Daniel", "Pickering", new Date(1996, 1, 6), 2289));
		currentUser = users.get(0);
	}
	
	public ArrayList<User> getAllUsers() {
		return users;
	}
	
	public User getCurrentUser() {
		for(User u : users) {
			if(u.getId() == currentUser.getId()) {
				return u;
			}
		}
		return null;
	}
	
	public void setCurrentUser(User user) {
		currentUser = user;
	}
	
	public void add(String forename, String lastname, Date dateOfBirth, int passcode) {
		users.add(new User(users.size(), forename, lastname, dateOfBirth, passcode));
	}

}
