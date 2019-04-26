package com.khachidze_01469313.myrymer;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class FavoritActivity extends AppCompatActivity {


    // Favorit list
    List<String> favorits;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorit);

        // Use Serialization, save in favorite list Objekts
        try {
            Context con = getApplicationContext();
            FileInputStream fis = con.openFileInput("favorite");
            ObjectInputStream is = new ObjectInputStream(fis);
            favorits = (List) is.readObject();
            is.close();
            fis.close();

        } catch (Exception e) {
            System.out.println("Error to load " + e.getMessage());
        }

        // Chek favorit List and add String for Error
        if(favorits.isEmpty()){
            favorits.add("Favorits is empty");
        }

        // Use ArrayAdapter for saving List in Listview
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.activity_listview2, favorits);
        ListView savefav = (ListView) findViewById(R.id.listfavorits);

        savefav.setAdapter(adapter);


    }
}
