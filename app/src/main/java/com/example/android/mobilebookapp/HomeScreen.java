package com.example.android.mobilebookapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HomeScreen extends AppCompatActivity{

    private static Button viewBooksButton;
    private static Button searchForBooksButton;
    private static Button viewFavoritesButton;
    private static Button viewBooksReadButton;

    JSONParser jsonParser = new JSONParser();

    private static final String VIEW_BOOKS_URL =
            "http://137.116.72.27/se_android_app/viewBooks.php";

    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";

    int success;

    private ProgressDialog pDialog;

    private static final String TAG_USER_OBJ = "User_Info";
    private static final String TAG_USER_ID = "user_id";

    String user_id; // string used to pass user_id POST information
    JSONObject jsonUserInfo = new JSONObject();
    JSONArray  jsonArrayUserID = new JSONArray();
    JSONObject jsonBookInfo = new JSONObject();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        try {
            jsonUserInfo = new JSONObject(getIntent().getStringExtra("jsonUserResults"));
            Log.d("HScreen UserInfo", jsonUserInfo.toString());
            jsonArrayUserID = jsonUserInfo.getJSONArray(TAG_USER_OBJ);

            JSONObject jsonChild = jsonArrayUserID.getJSONObject(0);
            user_id = jsonChild.getString(TAG_USER_ID);

            Log.d("UserID = ", user_id);
        }
        catch (JSONException e){
            e.printStackTrace();
        }

        new populateBookShelf().execute();

        onClickViewBooksButtonListener();
        onClickSearchBooksButtonListener();
        onClickViewFavoritesButtonListener();
        onClickViewBooksReadButtonListener();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        new populateBookShelf().execute();
    }

    public void onClickViewBooksButtonListener() {
        viewBooksButton = (Button)findViewById(R.id.viewBooksButton);
        viewBooksButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i;
                        i = new Intent(HomeScreen.this, BookShelf.class);
                        i.putExtra("jsonBookResults", jsonBookInfo.toString());
                        i.putExtra("jsonUserResults", jsonUserInfo.toString());
                        startActivity(i);
                    }
                });
    }

    public void onClickSearchBooksButtonListener() {
        searchForBooksButton = (Button)findViewById(R.id.searchForBooksButton);
        searchForBooksButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i;
                        i = new Intent(HomeScreen.this, SearchBook.class);
                        i.putExtra("jsonUserResults", jsonUserInfo.toString());
                        startActivity(i);
                    }
                });
    }

    public void onClickViewFavoritesButtonListener() {
        viewFavoritesButton = (Button)findViewById(R.id.viewFavoritesButton);
        viewFavoritesButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i;
                        i = new Intent(HomeScreen.this, Favorites.class);
                        i.putExtra("jsonUserResults", jsonUserInfo.toString());
                        startActivity(i);
                    }
                });
    }

    public void onClickViewBooksReadButtonListener() {
        viewBooksReadButton = (Button)findViewById(R.id.viewBooksReadButton);
        viewBooksReadButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i;
                        i = new Intent(HomeScreen.this, BooksRead.class);
                        i.putExtra("jsonUserResults", jsonUserInfo.toString());
                        startActivity(i);
                    }
                });
    }

    class populateBookShelf extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(HomeScreen.this);
            /*pDialog.setMessage("Populating Book Shelf...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();*/
        }

        @Override
        protected String doInBackground(String... args) {
            try {
                ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("user_id", user_id));

                jsonBookInfo = jsonParser.makeHttpRequest(VIEW_BOOKS_URL, "POST", params);

                Log.d("HScreen dIB Attempt: ", jsonBookInfo.toString());

                success = jsonBookInfo.getInt(TAG_SUCCESS);
                if (success == 1) {
                    Log.d("HScreen dIB Successful", jsonBookInfo.toString());
                    //finish();
                    return jsonBookInfo.getString(TAG_MESSAGE);
                } else {
                    Log.d("HScreen dIB failed", jsonBookInfo.getString(TAG_MESSAGE));
                    return jsonBookInfo.getString(TAG_MESSAGE);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        protected void onPostExecute(String file_url) {
            // dismiss the dialog once product deleted
            pDialog.dismiss();
            /*if (file_url != null) {
                if(success == 0) {
                    Toast.makeText(HomeScreen.this, file_url, Toast.LENGTH_LONG).show();
                }
            }*/
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
