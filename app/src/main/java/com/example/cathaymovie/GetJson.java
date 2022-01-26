package com.example.cathaymovie;

import android.content.Context;
import android.content.res.AssetManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class GetJson {

    private StringBuilder stringBuilder;
    private Gson gson;
    private Type type;
    private ArrayList<MovieModel> movieModelList;

    public ArrayList<MovieModel> getJson(String fileName, Context context) {

        gson = new Gson();
        stringBuilder = new StringBuilder();
        movieModelList = new ArrayList<>();

        try {
            AssetManager assetManager = context.getAssets();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(assetManager.open(fileName)));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        type = new TypeToken<ArrayList<MovieModel>>() {
        }.getType();
        movieModelList = gson.fromJson(stringBuilder.toString(), type);

        return movieModelList;
    }
}
