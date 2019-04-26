package com.khachidze_01469313.myrymer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;


public class MainActivity extends AppCompatActivity {

    // Private Variable
    private Button howto;
    private Button buttonsearch;
    private Button savefavorit;

    // Map to searched word and list
    static Map<String, List<String>> synmap;
    static Map<String, List<String>> rhymmap;
    static Map<String, List<String>> frecuence;


    // Typ is default "syn"
    private String type = "syn";
    public static EditText searchWord;

    // Constructor
    public MainActivity() {
        synmap = new HashMap<>();
        rhymmap = new HashMap<>();
        frecuence = new HashMap<>();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Which Button which id used
        howto = (Button) findViewById(R.id.bhowto);

        searchWord = (EditText) findViewById(R.id.searchw);

        buttonsearch = findViewById(R.id.searchbutton);

        savefavorit = (Button) findViewById(R.id.button10);


        //After push favorit Button another layout is shown
        savefavorit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FavoritListActivity.class);
                startActivity(intent);

            }
        });


        //After push searchButton opens another layout and creates parsJson
        buttonsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);


                ParsJson process = new ParsJson(type, searchWord.getText().toString());
                try {
                    process.execute().get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                startActivity(intent);


            }
        });


        // open second Layout for How To
        howto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSecondActivity();
            }
        });

    }


    public void onRadioButtonClicked(View view) {

        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();


        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_syn:
                if (checked)
                    this.type = "syn";
                break;
            case R.id.radio_nry:
                if (checked)
                    this.type = "nry";
                break;
            case R.id.radio_bga:
                if (checked)
                    this.type = "bga";
                break;
        }
    }



    // create second Layout for How To
    public void openSecondActivity(){
        Intent intent = new Intent(MainActivity.this, HowToActivity.class);
        startActivity(intent);

    }

}
