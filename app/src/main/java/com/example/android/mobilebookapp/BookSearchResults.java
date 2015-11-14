package com.example.android.mobilebookapp;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class BookSearchResults extends Activity {

    ListView list;

    //JSON Node Names; Table column names
    private static final String TAG_BOOK_ARRAY = "Book_Info";
    private static final String TAG_ISBN = "ISBN";
    private static final String TAG_TITLE = "title";
    private static final String TAG_AUTHOR = "author";
    private static final String TAG_YEAR = "pub_year";

    ArrayList<HashMap<String, String>> bookList = new ArrayList<HashMap<String, String>>();

    JSONArray jsonArray = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);

        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj = new JSONObject(getIntent().getStringExtra("jsonResults"));
        }
        catch (JSONException e){
            e.printStackTrace();
        }

        //System.out.println(jsonObj.toString());
        Log.d("BSR: Search Attempt ", jsonObj.toString());

        try {
            jsonArray = jsonObj.getJSONArray(TAG_BOOK_ARRAY);

            // Loop through jsonArray
            for(int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonChild = jsonArray.getJSONObject(i);
                String ISBN = "ISBN: " + jsonChild.getString(TAG_ISBN);
                String title = "Title: " + jsonChild.getString(TAG_TITLE);
                String author = "Author: " + jsonChild.getString(TAG_AUTHOR);
                String year = "Publication Year: " + jsonChild.getString(TAG_YEAR);

                HashMap<String, String> map = new HashMap<String, String>();
                map.put(TAG_ISBN, ISBN);
                map.put(TAG_TITLE, title);
                map.put(TAG_AUTHOR, author);
                map.put(TAG_YEAR, year);

                bookList.add(map);
                list = (ListView) findViewById(R.id.listview_book);

                ListAdapter adapter = new SimpleAdapter(BookSearchResults.this,
                        bookList, R.layout.list_item_book,
                        new String[]{TAG_ISBN, TAG_TITLE, TAG_AUTHOR, TAG_YEAR},
                        new int[]{R.id.ISBN, R.id.Title, R.id.Author, R.id.PubYear});

                list.setAdapter(adapter);
            }
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
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