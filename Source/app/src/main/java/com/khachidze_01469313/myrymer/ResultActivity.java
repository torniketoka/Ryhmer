package com.khachidze_01469313.myrymer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    private Button save;

    // Default Construcktor
    public ResultActivity() {}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        final int length = Toast.LENGTH_LONG;
        final String string = "Saved as Favorits!";

        // Use ArrayAdapter for saving List in Listview
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.activity_listview, ParsJson.getList());


        ListView search = (ListView) findViewById(R.id.mobile_list);

        search.setAdapter(adapter);


        save = (Button) findViewById(R.id.button3);



        // After push save Button save key end List in Map
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Wenn User pushed save as favorits button, information is shown on the screen
                Toast toast = (Toast) Toast.makeText(ResultActivity.this, string, length);
                toast.show();
                ParsJson.saveToFavorite();
            }
        });



    }
}

