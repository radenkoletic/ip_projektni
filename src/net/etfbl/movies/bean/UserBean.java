package net.etfbl.movies.bean;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import net.etfbl.movies.dao.UserDAO;
import net.etfbl.movies.model.Feed;
import net.etfbl.movies.model.User;
import net.etfbl.movies.util.Util;

public class UserBean {
	private User user;
	private boolean logedIn;
	private ArrayList<User> users;
	private ArrayList<String> userTypes;
	private int selectedUserId;
	private ArrayList<Feed> netflixFeed;
	private final String FEED_URL = "http://dvd.netflix.com/Top100RSS";

	public UserBean () {
		user = new User();
		logedIn = false;
		users = UserDAO.getAllUsers();
		userTypes = UserDAO.getAllUserTypes();
		try {
			netflixFeed = Util.getFeed(FEED_URL);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void updateUserStatus (User user) {
		UserDAO.updateUserStatus(user);
		for (User u : users) {
			if (u.getId() == user.getId()) {
				u = user;
			}
		}
	}
	
	public void deleteUser (User user) {
		UserDAO.deleteUser(user);
		users.remove(user);
	}
	
	public ArrayList<String> getAllUserTypes() {
		return userTypes;
	}
	
	public ArrayList<User> getAllUsers () {
		return users;
	}

	public String getImageName () {
		String[] temp = user.getImagePath().split(File.separator); 
		String image = temp[temp.length - 1];
		return image;
	}

	public boolean login(String username, String password){
		if ((user = UserDAO.checkUser(username, password)) != null){
			user.setLogedIn(true);
			logedIn = true;
			return true;
		}
		return false;
	}

	public void logout(){
		user = new User();
		logedIn = false;
	}

	public User getUser() {
		return user;
	}

	public boolean isLogedIn() {
		return logedIn;
	}

	public void setLogedIn(boolean logedIn) {
		this.logedIn = logedIn;
	}
	
	public void setUser (User user) {
		this.user = user;
	}

	public int getSelectedUserId() {
		return selectedUserId;
	}

	public void setSelectedUserId(int selectedUserId) {
		this.selectedUserId = selectedUserId;
	}

	public ArrayList<Feed> getNetflixFeed() {
		return netflixFeed;
	}

	public void setNetflixFeed(ArrayList<Feed> netflixFeed) {
		this.netflixFeed = netflixFeed;
	}

}
