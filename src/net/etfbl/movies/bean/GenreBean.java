package net.etfbl.movies.bean;

import java.util.ArrayList;

import net.etfbl.movies.dao.GenreDAO;
import net.etfbl.movies.model.Genre;

public class GenreBean {
	
	private ArrayList<Genre> genres;
	
	public GenreBean () {
		genres = GenreDAO.getAllGenres();
	}
	
	public void deleteGenre (int genreID) {
		for (Genre g : genres) {
			if (g.getId() == genreID) {
				GenreDAO.deteleGenre(g);
				genres.remove(g);
			}
		}
	}

	public ArrayList<Genre> getAllGenres() {
		return genres;
	}

	public void setAllGenres(ArrayList<Genre> genres) {
		this.genres = genres;
	}

}
