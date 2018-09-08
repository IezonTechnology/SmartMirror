package iezon.users;

import java.util.Date;

public class User {
	
	private String fname, lname;
	private Date dob;
	private int code;
	private boolean isLoggedIn = false;
	private int id;

	public User(int id, String forename, String lastname, Date dateOfBirth, int passcode) {
		fname 	= forename;
		lname 	= lastname;
		dob 	= dateOfBirth;
		code 	= passcode;
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setLogin(boolean state) {
		isLoggedIn = state;
	}
	
	public boolean isLoggedIn() {
		return isLoggedIn;
	}
	
	public boolean checkLogin(int passcode) {
		return code == passcode ? true : false;
	}

	public String getFname() {
		return fname;
	}

	public String getLname() {
		return lname;
	}

	public Date getDob() {
		return dob;
	}
}