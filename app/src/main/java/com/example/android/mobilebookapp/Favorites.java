package com.example.android.mobilebookapp;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class Favorites extends AppCompatActivity {

    JSONArray jsonArrayUserID = new JSONArray();
    JSONArray jsonFavoritesArray = new JSONArray();

    JSONObject jsonUserInfo = new JSONObject();
    JSONObject jsonFavorites = new JSONObject();

    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";

    private static final String TAG_USER_OBJ = "User_Info";
    private static final String TAG_USER_ID = "user_id";

    ListView list;
    int success;

    String user_id;  // string used to pass user_id POST information

    private static final String VIEW_FAVORITES_URL =
            "http://137.116.72.27/se_android_app/viewFavorites.php";

    private ProgressDialog pDialog;

    JSONParser jsonParser = new JSONParser();

    //JSON Node Names; Table column names
    private static final String TAG_BOOK_ARRAY = "Book_Info";
    private static final String TAG_ISBN = "ISBN";
    private static final String TAG_TITLE = "title";
    private static final String TAG_AUTHOR = "author";
    private static final String TAG_YEAR = "pub_year";

    ArrayList<HashMap<String, String>> bookList = new ArrayList<HashMap<String, String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);

        try {
            jsonUserInfo = new JSONObject(getIntent().getStringExtra("jsonUserResults"));
            Log.d("Favorites UserInfo ", jsonUserInfo.toString());

            jsonArrayUserID = jsonUserInfo.getJSONArray(TAG_USER_OBJ);

            JSONObject jsonChild = jsonArrayUserID.getJSONObject(0);
            user_id = jsonChild.getString(TAG_USER_ID);
        }
        catch (JSONException e){
            e.printStackTrace();
        }

        Log.d("Favorites Books ", jsonFavorites.toString());
        new populateFavorites().execute();
    }

    class populateFavorites extends AsyncTask<String, String, JSONObject> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(Favorites.this);
            pDialog.setMessage("Populating Favorites...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        @Override
        protected JSONObject doInBackground(String... args) {
            try {
                ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("user_id", user_id));

                jsonFavorites = jsonParser.makeHttpRequest(VIEW_FAVORITES_URL, "POST", params);

                Log.d("Favorites dIB Attempt: ", jsonFavorites.toString());

                success = jsonFavorites.getInt(TAG_SUCCESS);
                if (success == 1) {
                    Log.d("Fav dIB Successful", jsonFavorites.toString());
                    //finish();
                    return jsonFavorites;
                } else {
                    Log.d("Favorites dIB failed", jsonFavorites.getString(TAG_MESSAGE));
                    return jsonFavorites;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        protected void onPostExecute(JSONObject obj) {
            // dismiss the dialog once product deleted
            pDialog.dismiss();

            try {
                jsonFavoritesArray = jsonFavorites.getJSONArray(TAG_BOOK_ARRAY);

                // Loop through jsonArray
                for(int i = 0; i < jsonFavoritesArray.length(); i++) {

                    JSONObject jsonChild = jsonFavoritesArray.getJSONObject(i);
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

                    ListAdapter adapter = new SimpleAdapter(Favorites.this,
                            bookList, R.layout.list_item_favorites,
                            new String[]{TAG_ISBN, TAG_TITLE, TAG_AUTHOR, TAG_YEAR},
                            new int[]{R.id.ISBN, R.id.Title, R.id.Author, R.id.PubYear});

                    list.setAdapter(adapter);
                }
            }
            catch (JSONException e) {
                e.printStackTrace();
            }
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
