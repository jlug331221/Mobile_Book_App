package com.example.android.mobilebookapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SimpleBookShelfList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);

        // Create some dummy book data for the ListView.
        String[] testBookShelf = new String[] {
                "Lord of the Rings - Fellowship",
                "The Silmarillion",
                "The Name of the Wind",
                "The Wise Man's Fear",
                "The Martian",
                "Blood Meridian",
                "SevenEves",
                "Dune",
                "Ready Player One",
                "World War Z",
                "Out with the Old Breed on Peleliu and Okanawa"
        };

        // Now that we have some dummy book data, create an ArrayAdapter.
        // The ArrayAdapter will take data from a source (like our dummy books) and
        // use it to populate the ListView it's attached to.
        ArrayAdapter<String> bookShelfAdapter =
                new ArrayAdapter<String>(
                        this, // The current context (this activity)
                        R.layout.list_item_book, // The name of the layout ID.
                        testBookShelf);

        ListView bookshelf = (ListView)findViewById(R.id.listview_book);
        bookshelf.setAdapter(bookShelfAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
