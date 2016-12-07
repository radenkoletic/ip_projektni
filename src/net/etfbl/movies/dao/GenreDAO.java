package net.etfbl.movies.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import net.etfbl.movies.database.ConnectionPool;
import net.etfbl.movies.model.Genre;

public class GenreDAO {
	
	private static final String GET_ALL_GENRES = "select * from genre order by name";
	
	private static final String DELETE_GENRE = "delete from genre where id = ?";
	
	private static final String INSERT_GENRE = "insert into genre (name) values (?)";
	
	public static void insertGenre (Genre genre) {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = ConnectionPool.getInstance().checkOut();
			pst = conn.prepareStatement(INSERT_GENRE);
			pst.setString(1, genre.getName());
			pst.executeQuery();
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
	
	public static void deteleGenre (Genre genre) {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = ConnectionPool.getInstance().checkOut();
			pst = conn.prepareStatement(DELETE_GENRE);
			pst.setInt(1, genre.getId());
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
	
	public static ArrayList<Genre> getAllGenres () {
		ArrayList<Genre> genres = new ArrayList<>();
		Genre genre = null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = ConnectionPool.getInstance().checkOut();
			pst = conn.prepareStatement(GET_ALL_GENRES);
			rs = pst.executeQuery();
			while (rs.next()) {
				genre = new Genre();
				genre.setId(rs.getInt("id"));
				genre.setName(rs.getString("name"));
				genres.add(genre);
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
		return genres;
	}

}
