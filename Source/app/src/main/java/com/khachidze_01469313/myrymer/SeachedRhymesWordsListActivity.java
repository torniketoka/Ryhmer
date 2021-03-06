package com.khachidze_01469313.myrymer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class SeachedRhymesWordsListActivity extends AppCompatActivity {

    static String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seached_rhymes_words_list);


        //Seach words with Key
        List<String> resultat = new ArrayList<String>(MainActivity.rhymmap.keySet());

        // Use ArrayAdapter for saving List in Listview
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.rhyme_text, resultat);


        ListView search = (ListView) findViewById(R.id.listrhyme);

        search.setAdapter(adapter);

        // Create list Items as Clickable
        search.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(SeachedRhymesWordsListActivity.this, RhymeResultActivity.class);
                startActivity(intent);
                name = (String) parent.getItemAtPosition(position);
            }
        });

    }
}
