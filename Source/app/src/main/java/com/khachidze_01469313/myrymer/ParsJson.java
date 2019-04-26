package com.khachidze_01469313.myrymer;


import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ParsJson extends AsyncTask<Void, Void, Void> {

    // Private variable
    String chek = "";
    static String flag;
    static String type = "";
    URL url;

    // List for Favorit words
    static List<String> list;


    // ParsJson Constructor
    public ParsJson(String type, String flag) {
        this.flag = flag;
        this.type = type;
    }


    // Default Constructor
    public ParsJson(){}


    // transfer URL and Pars Json and only Words save in the list
    @Override
    protected Void doInBackground(Void... voids) {

        try {

            if (type.equals("syn")) {
                url = new URL("https://api.datamuse.com/words?rel_syn=" + flag);
            } else if (type.equals("nry")) {
                url = new URL("https://api.datamuse.com/words?rel_nry=" + flag);
            } else {
                url = new URL("https://api.datamuse.com/words?rel_bga=" + flag);
            }

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line = "";
            while (line != null){
                line = bufferedReader.readLine();
                chek = chek + line;
            }


            JSONArray jsonArray = new JSONArray(chek);
            // list.clear();
            list = new ArrayList<>();
            for(int i = 0; i < jsonArray.length(); i++){

                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                list.add((String) jsonObject.get("word"));

            }



        } catch (MalformedURLException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return null;
    }

    // Save words end key in corresponding map
    static void saveToFavorite() {
        if(type.equals("syn")){
            MainActivity.synmap.put(flag, list);
        } else if(type.equals("nry")){
            MainActivity.rhymmap.put(flag, list);
        } else MainActivity.frecuence.put(flag,list);

    }


    // return to List where the words are saved
    public static List<String> getList() {
        return list;
    }

}
