package com.khachidze_01469313.myrymer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class SynonymResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_result);


        //Seach words with Key
        List<String> resultat = MainActivity.synmap.get(SearchedSynonymWordsListActivity.name);
        // Use ArrayAdapter for saving List in Listview
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.endresult, resultat);


        ListView search = (ListView) findViewById(R.id.resultendid);

        search.setAdapter(adapter);
    }
}
