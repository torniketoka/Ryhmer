package com.khachidze_01469313.myrymer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class RhymeResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rhyme_result);


        //Seach words with Key
        List<String> resultat = MainActivity.rhymmap.get(SeachedRhymesWordsListActivity.name);

        // Use ArrayAdapter for saving List in Listview
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.rhyme_result_xml, resultat);


        ListView search = (ListView) findViewById(R.id.rhymeresultid);

        search.setAdapter(adapter);
    }
}
