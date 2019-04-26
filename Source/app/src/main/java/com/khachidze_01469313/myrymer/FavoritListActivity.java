package com.khachidze_01469313.myrymer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FavoritListActivity extends AppCompatActivity {

    // Privat Variable using for Favorit List Buttons
    private Button favorit;
    private Button rhyme;
    private Button frecuenze;
    private Button home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


        //Wich id use forEach Buttons
        favorit = (Button) findViewById(R.id.favid);
        rhyme = (Button) findViewById(R.id.rymid);
        frecuenze = (Button) findViewById(R.id.freqid);

        //After push favorit Button another layout is shown
        favorit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FavoritListActivity.this, SearchedSynonymWordsListActivity.class);
                startActivity(intent);
            }
        });

        //After push rhyme Button another layout is shown
        rhyme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FavoritListActivity.this, SeachedRhymesWordsListActivity.class);
                startActivity(intent);
            }
        });


        //After push frecuenze Button another layout is shown
        frecuenze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FavoritListActivity.this, SearchedFrequentWordsListActivity.class);
                startActivity(intent);

            }
        });


    }
}
