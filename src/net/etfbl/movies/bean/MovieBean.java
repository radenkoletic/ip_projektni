package net.etfbl.movies.bean;

import java.util.ArrayList;

import net.etfbl.movies.model.Actor;
import net.etfbl.movies.model.Movie;
import net.etfbl.movies.util.Util;

public class MovieBean {

	private String REST_URL = "http://imdb.wemakesites.net";
	private String firstSearch;
	private String jSonData;
	private ArrayList<Movie> restMovies;
	private ArrayList<Actor> restActors;
	private static final String INTERSTELLAR = "Interstellar";
	
	public MovieBean () {
		firstSearch = Util.restFromUrl(REST_URL, "/api/search?q=" + INTERSTELLAR);
		restMovies = Util.parseJSONMovies(firstSearch);
	}
	
	public void setMovieList (String search) {
		search = search.replaceAll(" ", "_");
		jSonData = Util.restFromUrl(REST_URL, "/api/search?q=" + search);
		System.out.println("response: " + jSonData);
		restMovies = Util.parseJSONMovies(jSonData);
		restActors = Util.parseJSONActors(jSonData);
		System.out.println("actors size: " + restActors.size());
	}
	
	public void setDefaultMovieList () {
		restMovies = Util.parseJSONMovies(firstSearch);
		restActors = new ArrayList<>();
	}

	public ArrayList<Movie> getRestMovies() {
		return restMovies;
	}

	public void setRestMovies(ArrayList<Movie> restMovies) {
		this.restMovies = restMovies;
	}

	public ArrayList<Actor> getRestActors() {
		return restActors;
	}

	public void setRestActors(ArrayList<Actor> restActors) {
		this.restActors = restActors;
	}

}
