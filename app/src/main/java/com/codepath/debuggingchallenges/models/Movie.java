package com.codepath.debuggingchallenges.models;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private String title;
    private String posterUrl;
    private double rating;

    public Movie(JSONObject jsonObject) throws JSONException {
        this.posterUrl = jsonObject.getString("poster_path");
        this.title = jsonObject.getString("original_title");
        this.rating = jsonObject.getDouble("vote_average");
    }

    public String getTitle() {
        return title;
    }

    public double getRating() {
        return rating;
    }

    public String getPosterUrl() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterUrl);
    }

    public static List<Movie> fromJSONArray(JSONArray jsonArray) throws JSONException {
        List<Movie> results = new ArrayList<>();
        Log.d("MovieObject", "moviesJson: " + jsonArray.length());
        for (int i = 0; i < jsonArray.length(); i++) {
            Log.d("MovieObject", jsonArray.getJSONObject(i).toString());
            results.add(new Movie(jsonArray.getJSONObject(i)));
            Log.d("MovieObject", "Added.");
            Log.d("MovieObject", "Added.");
        }
        Log.d("MovieObject", "Movies: " + results.size());
        return results;
    }
}
