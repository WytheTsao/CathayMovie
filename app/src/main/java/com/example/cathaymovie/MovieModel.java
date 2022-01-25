package com.example.cathaymovie;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MovieModel {
    Context context;
    GetJson getJson;
    String movieData, fileName;
    ArrayList<String> movieNameList, movieTagList, movieEngNameList, movieTypeList, movieRunTime, movieComeOutDate, movieAbout;
    StringBuilder stringBuilder;


    public MovieModel(String fileName, Context context) {
        this.context = context;
        this.fileName = fileName;
        getJson = new GetJson();
        movieNameList = new ArrayList<>();
        movieEngNameList = new ArrayList<>();
        movieTypeList = new ArrayList<>();
        movieTagList = new ArrayList<>();
        movieRunTime = new ArrayList<>();
        movieComeOutDate = new ArrayList<>();
        movieAbout = new ArrayList<>();
        movieData = getJson.getJson(fileName, context);
        getMovieInfo();
    }


    public ArrayList<String> getMovieName() {
        return this.movieNameList;
    }

    public ArrayList<String> getMovieEngName() {
        return this.movieEngNameList;
    }

    public ArrayList<String> getMovieType() {
        return this.movieTypeList;
    }

    public ArrayList<String> getMovieTag() {
        return this.movieTagList;
    }

    public ArrayList<String> getMovieRunTime() {
        return this.movieRunTime;
    }

    public ArrayList<String> getMovieComeOutDate() {
        return this.movieComeOutDate;
    }

    public ArrayList<String> getMovieAbout() {
        return this.movieAbout;
    }



    private void getMovieInfo() {
        try {
            JSONArray jsonArray = new JSONArray(movieData);
            Log.e("array", jsonArray.length() + "");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                movieNameList.add(jsonObject.getString("name"));
                movieEngNameList.add(jsonObject.getString("engName"));
                movieTypeList.add(jsonObject.getString("type"));
                movieAbout.add(jsonObject.getString("about"));
                movieRunTime.add(jsonObject.getString("runTime"));
                movieComeOutDate.add(jsonObject.getString("comeOutDate"));
                Log.e("tags", jsonObject.getJSONArray("tags").toString());
                stringBuilder = new StringBuilder();
                for (int j = 0; j < jsonObject.getJSONArray("tags").length(); j++) {
                    stringBuilder.append(jsonObject.getJSONArray("tags").get(j));
                    stringBuilder.append("\t");
                }
                movieTagList.add(stringBuilder.toString());

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
