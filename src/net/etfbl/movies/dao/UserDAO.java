package net.etfbl.movies.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import net.etfbl.movies.database.ConnectionPool;
import net.etfbl.movies.model.User;
import net.etfbl.movies.util.Util;

public class UserDAO {

	private static final String CHECK_USER = "select U.id, U.name, U.surname, U.ucn, U.e_mail, U.image_path, U.username, U.password_hash, "
			+ "UT.name as user_type from user U inner join user_type UT on U.user_type_id = UT.id "
			+ "where U.is_active = 1 and U.user_type_id <> 4 and U.username = ? and U.password_hash = ?";

	private static final String INSERT_USER = "insert into user (name, surname, ucn, e_mail, user_type_id, "
			+ "image_path, username, password_hash, is_active "
			+ ") values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

	private static final String GET_USER_TYPE_BY_NAME = "select id from user_type where name = ?";

	private static final String UPDATE_USER = "update user set name = ?, surname = ?, e_mail = ?, "
			+ " image_path = ?, password_hash = ? where id = ?";

	private static final String GET_ALL_USERS = "select U.*, UT.name as user_type from user U inner join user_type UT "
			+ "on U.user_type_id = UT.id where is_active = 1 order by name";
	
	private static final String GET_ALL_USER_TYPES = "select name from user_type";
	
	private static final String UPDATE_USER_STATUS = "update user set user_type_id = ? where id = ?";
	
	private static final String DELETE_USER = "update user set is_active = 0 where id = ?";
	
	public static void deleteUser (User user) {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = ConnectionPool.getInstance().checkOut();
			pst = conn.prepareStatement(DELETE_USER);
			pst.setInt(1, user.getId());
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.clearParameters();
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionPool.getInstance().checkIn(conn);
		}
	}
	
	public static void updateUserStatus (User user) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int userTypeId = -1;
		try {
			conn = ConnectionPool.getInstance().checkOut();
			pst = conn.prepareStatement(GET_USER_TYPE_BY_NAME);
			pst.setString(1, user.getUserType());
			rs = pst.executeQuery();
			if (rs.next()) {
				userTypeId = rs.getInt("id");
			}
			pst.close();
			pst = conn.prepareStatement(UPDATE_USER_STATUS);
			pst.setInt(1, userTypeId);
			pst.setInt(2, user.getId());
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.clearParameters();
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionPool.getInstance().checkIn(conn);
		}
	}
	
	public static ArrayList<String> getAllUserTypes() {
		ArrayList<String> userTypes = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = ConnectionPool.getInstance().checkOut();
			pst = conn.prepareStatement(GET_ALL_USER_TYPES);
			rs = pst.executeQuery();
			while (rs.next()) {
				userTypes.add(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pst.clearParameters();
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionPool.getInstance().checkIn(conn);
		}
		return userTypes;
	}

	public static final ArrayList<User> getAllUsers () {
		ArrayList<User> users = new ArrayList<>();
		User user = null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = ConnectionPool.getInstance().checkOut();
			pst = conn.prepareStatement(GET_ALL_USERS);
			rs = pst.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setSurname(rs.getString("surname"));
				user.setUcn(rs.getString("ucn"));
				user.setEmail(rs.getString("e_mail"));
				user.setUserType(rs.getString("user_type"));
				user.setImagePath(rs.getString("image_path"));
				user.setUsername(rs.getString("username"));
				user.setPasswordHash(rs.getString("password_hash"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pst.clearParameters();
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionPool.getInstance().checkIn(conn);
		}
		return users;
	}

	public static boolean updateUser (User user) {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = ConnectionPool.getInstance().checkOut();
			pst = conn.prepareStatement(UPDATE_USER);
			pst.setString(1, user.getName());
			pst.setString(2, user.getSurname());
			pst.setString(3, user.getEmail());
			pst.setString(4, user.getImagePath());
			pst.setString(5, user.getPasswordHash());
			pst.setInt(6, user.getId());
			return pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.clearParameters();
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionPool.getInstance().checkIn(conn);
		}
		return false;
	}

	public static boolean insertUser(User user) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int userType = -1;
		try {
			conn = ConnectionPool.getInstance().checkOut();
			pst = conn.prepareStatement(GET_USER_TYPE_BY_NAME);
			pst.setString(1, user.getUserType());
			rs = pst.executeQuery();
			if (rs.next()) {
				userType = rs.getInt("id");
				System.out.println("user type id: " + userType);
			}
			pst.clearParameters();
			pst.close();
			pst = conn.prepareStatement(INSERT_USER);
			pst.setString(1, user.getName());
			pst.setString(2, user.getSurname());
			pst.setString(3, user.getUcn());
			pst.setString(4, user.getEmail());
			pst.setInt(5, userType);
			pst.setString(6, user.getImagePath());
			pst.setString(7, user.getUsername());
			pst.setString(8, user.getPasswordHash());
			pst.setInt(9, 1);
			return pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pst.clearParameters();
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionPool.getInstance().checkIn(conn);
		}
		return false;
	}

	public static User checkUser (String username, String password){
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String passwordHash = Util.calculateMD5Hash(password);
		User user = null;
		try {
			conn = ConnectionPool.getInstance().checkOut();
			pst = conn.prepareStatement(CHECK_USER);
			pst.setString(1, username);
			pst.setString(2, passwordHash);
			rs = pst.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setSurname(rs.getString("surname"));
				user.setUcn(rs.getString("ucn"));
				user.setEmail(rs.getString("e_mail"));
				user.setImagePath(rs.getString("image_path"));
				user.setUsername(rs.getString("username"));
				user.setPasswordHash(rs.getString("password_hash"));
				user.setUserType(rs.getString("user_type"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pst.clearParameters();
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionPool.getInstance().checkIn(conn);
		}
		return user;
	}

}
