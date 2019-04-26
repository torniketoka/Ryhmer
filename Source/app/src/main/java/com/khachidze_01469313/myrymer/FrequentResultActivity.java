package com.khachidze_01469313.myrymer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class FrequentResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frequent_result);

        // Use ArrayAdapter for saving List in Listview
        List<String> resultat = MainActivity.frecuence.get(SearchedFrequentWordsListActivity.name);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.freq_result_list_xml, resultat);


        ListView search = (ListView) findViewById(R.id.freqresultlistid);

        search.setAdapter(adapter);
    }
}



