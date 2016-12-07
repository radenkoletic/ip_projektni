package net.etfbl.movies.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Part;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.syndication.feed.synd.SyndEntryImpl;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

import net.etfbl.movies.model.Actor;
import net.etfbl.movies.model.Feed;
import net.etfbl.movies.model.Movie;

public class Util {

	private static final String MD5 = "MD5";
	private static final String UTF_8 = "UTF-8";
	
	public static ArrayList<Movie> parseJSONMovies (String jSonData) {
		ArrayList<Movie> movies = new ArrayList<>();
		Movie movie = null;
		try {
			JSONObject response = new JSONObject(jSonData);
			JSONObject data = response.getJSONObject("data");
			JSONObject results = data.getJSONObject("results");
			JSONArray titles = results.getJSONArray("titles");
			int size = titles.length();
			for (int i = 0; i < size; i++) {
				movie = new Movie();
				movie.setName(titles.getJSONObject(i).getString("title"));
				movie.setRestUrl(titles.getJSONObject(i).getString("url"));
				movie.setRestThumbnail(titles.getJSONObject(i).getString("thumbnail"));
				movies.add(movie);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return movies;
	}

	public static ArrayList<Actor> parseJSONActors (String jSonData) {
		ArrayList<Actor> actors = new ArrayList<>();
		Actor actor = null;
		try {
			JSONObject response = new JSONObject(jSonData);
			JSONObject data = response.getJSONObject("data");
			JSONObject results = data.getJSONObject("results");
			JSONArray names = results.getJSONArray("names");
			int size = names.length();
			for (int i = 0; i < size; i++) {
				actor = new Actor();
				actor.setName(names.getJSONObject(i).getString("title"));
				actor.setRestUrl(names.getJSONObject(i).getString("url"));
				actor.setRestThumbnail(names.getJSONObject(i).getString("thumbnail"));
				actors.add(actor);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return actors;
	}
	
	public static String restFromUrl (String url, String request) {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource(UriBuilder.fromUri(url + request).build());
		return service.accept(MediaType.APPLICATION_JSON).get(String.class);
	}

	public static String calculateMD5Hash(String text){
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance(MD5);
			md.update(text.getBytes(UTF_8));
			byte byteData[] = md.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		} 
		return null;
	}

	public static String getFileName (Part part) {
		String[] header = ((String)part.getHeaders("content-disposition").toArray()[0]).split("=");
		String fileName = header[header.length - 1];
		fileName = fileName.substring(1, fileName.length() - 1);
		return fileName;
	}

	@SuppressWarnings("unchecked")
	public static ArrayList<Feed> getFeed (String feedUrl) throws IOException {
		ArrayList<Feed> result = new ArrayList<>();
		URL url = new URL(feedUrl);
		Feed feed = new Feed ();
		SyndFeedInput input = new SyndFeedInput();
		SyndFeed syndFeed = null;
		try {
			syndFeed = input.build(new XmlReader(url));
			String description = syndFeed.getDescription();
			String descWithoutTabs = description.replaceAll("\\<[^>]*>", "");
			feed.setDescription(descWithoutTabs);
			feed.setLink(syndFeed.getLink());
			feed.setTitle(syndFeed.getTitle());
			result.add(feed);
			List<SyndEntryImpl> feeds = syndFeed.getEntries();
			for (SyndEntryImpl f : feeds) {
				feed = new Feed();
				feed.setTitle(f.getTitle());
				feed.setLink(f.getLink());
				Document doc = Jsoup.parse(f.getDescription().getValue());
				Elements images = doc.getElementsByTag("img");
				String image = images.get(0).attr("src");
				String desc = doc.body().text();
				feed.setDescription(desc);
				feed.setImage(image);
				result.add(feed);
			}
		} catch (IllegalArgumentException | FeedException e) {
			e.printStackTrace();
		}
		return result;
	}

}
