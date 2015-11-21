package com.example.android.mobilebookapp;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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

/**
 * Created by justin331221 on 15/11/21.
 */
public class BooksRead extends AppCompatActivity{
    JSONArray jsonArrayUserID = new JSONArray();
    JSONArray jsonReadArray = new JSONArray();

    JSONObject jsonUserInfo = new JSONObject();
    JSONObject jsonRead = new JSONObject();

    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";

    private static final String TAG_USER_OBJ = "User_Info";
    private static final String TAG_USER_ID = "user_id";

    ListView list;
    int success;

    String user_id;  // string used to pass user_id POST information

    private static final String VIEW_READ_URL =
            "http://137.116.72.27/se_android_app/viewRead.php";

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
            Log.d("Read UserInfo ", jsonUserInfo.toString());

            jsonArrayUserID = jsonUserInfo.getJSONArray(TAG_USER_OBJ);

            JSONObject jsonChild = jsonArrayUserID.getJSONObject(0);
            user_id = jsonChild.getString(TAG_USER_ID);
        }
        catch (JSONException e){
            e.printStackTrace();
        }

        Log.d("Favorites Books ", jsonRead.toString());
        new populateBooksRead().execute();
    }

    class populateBooksRead extends AsyncTask<String, String, JSONObject> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(BooksRead.this);
            pDialog.setMessage("Populating Books Read...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        @Override
        protected JSONObject doInBackground(String... args) {
            try {
                ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("user_id", user_id));

                jsonRead = jsonParser.makeHttpRequest(VIEW_READ_URL, "POST", params);

                Log.d("Read dIB Attempt: ", jsonRead.toString());

                success = jsonRead.getInt(TAG_SUCCESS);
                if (success == 1) {
                    Log.d("Read dIB Successful", jsonRead.toString());
                    //finish();
                    return jsonRead;
                } else {
                    Log.d("Read dIB failed", jsonRead.getString(TAG_MESSAGE));
                    return jsonRead;
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
                jsonReadArray = jsonRead.getJSONArray(TAG_BOOK_ARRAY);

                // Loop through jsonArray
                for(int i = 0; i < jsonReadArray.length(); i++) {

                    JSONObject jsonChild = jsonReadArray.getJSONObject(i);
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

                    ListAdapter adapter = new SimpleAdapter(BooksRead.this,
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
}
