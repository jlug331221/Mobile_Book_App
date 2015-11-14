package com.example.android.mobilebookapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.nfc.Tag;
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
    JSONParser jsonParser = new JSONParser();

    private static final String VIEW_BOOKS_URL =
            "http://137.116.72.27/se_android_app/viewBooks.php";

    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";

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
            jsonUserInfo = new JSONObject(getIntent().getStringExtra("jsonResults"));
            Log.d("HScreen UserInfo", jsonUserInfo.toString());
            jsonArrayUserID = jsonUserInfo.getJSONArray(TAG_USER_OBJ);
            for(int i = 0; i < jsonArrayUserID.length(); i++) {
                JSONObject jsonChild = jsonArrayUserID.getJSONObject(i);
                user_id = jsonChild.getString(TAG_USER_ID);
            }
            Log.d("UserID = ", user_id);
        }
        catch (JSONException e){
            e.printStackTrace();
        }

        new populateBookShelf().execute();

        onClickViewBooksButtonListener();
        onClickSearchBooksButtonListener();
    }

    public void onClickViewBooksButtonListener() {
        viewBooksButton = (Button)findViewById(R.id.viewBooksButton);
        viewBooksButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i;
                        i = new Intent(HomeScreen.this, BookShelf.class);
                        i.putExtra("jsonResults", jsonBookInfo.toString());
                        startActivity(i);
                    }
                });
    }

    public void onClickSearchBooksButtonListener() {
        searchForBooksButton = (Button)findViewById(R.id.searchForBooks);
        searchForBooksButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i;
                        i = new Intent(HomeScreen.this, SearchBook.class);
                        startActivity(i);
                    }
                });
    }

    class populateBookShelf extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(HomeScreen.this);
            pDialog.setMessage("Populating Book Shelf...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        @Override
        protected String doInBackground(String... args) {
            int success;
            try {
                ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("user_id", user_id));

                jsonBookInfo = jsonParser.makeHttpRequest(VIEW_BOOKS_URL, "POST", params);

                Log.d("BShelf Attempt: ", jsonBookInfo.toString());

                success = jsonBookInfo.getInt(TAG_SUCCESS);
                if (success == 1) {
                    Log.d("ViewBooks Successful", jsonBookInfo.toString());
                    //finish();
                    return jsonBookInfo.getString(TAG_MESSAGE);
                } else {
                    Log.d("Search failed.", jsonBookInfo.getString(TAG_MESSAGE));
                    return jsonBookInfo.getString(TAG_MESSAGE);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        /**
         * After completing background task Dismiss the progress dialog
         **/
        protected void onPostExecute(String file_url) {
            // dismiss the dialog once product deleted
            pDialog.dismiss();
            if (file_url != null) {
                Toast.makeText(HomeScreen.this, file_url, Toast.LENGTH_LONG).show();
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
