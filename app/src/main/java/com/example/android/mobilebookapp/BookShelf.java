package com.example.android.mobilebookapp;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class BookShelf extends AppCompatActivity{

    ListView list;
    int success;

    private static final String FAVORITES_URL =
            "http://137.116.72.27/se_android_app/updateFavorites.php";
    private static final String BOOKS_READ_URL =
            "http://137.116.72.27/se_android_app/updateRead.php";

    private ProgressDialog pDialog;

    JSONParser jsonParser = new JSONParser();

    TextView ISBN; // used to grab ISBN from listView row
    String ISBNtoPHP; // used to send to addBook.php as in params ArrayList

    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";

    private static final String TAG_USER_OBJ = "User_Info";
    private static final String TAG_USER_ID = "user_id";

    String user_id; // string used to pass user_id POST information

    //JSON Node Names; Table column names
    private static final String TAG_BOOK_ARRAY = "Book_Info";
    private static final String TAG_ISBN = "ISBN";
    private static final String TAG_TITLE = "title";
    private static final String TAG_AUTHOR = "author";
    private static final String TAG_YEAR = "pub_year";


    ArrayList<HashMap<String, String>> bookList = new ArrayList<HashMap<String, String>>();

    JSONArray jsonArray = null;
    JSONArray jsonArrayUserID = new JSONArray();

    JSONObject jsonBookInfo = new JSONObject();
    JSONObject jsonUserInfo = new JSONObject();
    JSONObject jsonUpdateInfo = new JSONObject();
    JSONObject jsonUpdateInfo2 = new JSONObject();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);

        try {
            jsonBookInfo = new JSONObject(getIntent().getStringExtra("jsonBookResults"));
            jsonUserInfo = new JSONObject(getIntent().getStringExtra("jsonUserResults"));
            Log.d("BShelf BookInfo ", jsonBookInfo.toString());

            jsonArrayUserID = jsonUserInfo.getJSONArray(TAG_USER_OBJ);

            JSONObject jsonChild = jsonArrayUserID.getJSONObject(0);
            user_id = jsonChild.getString(TAG_USER_ID);
        }
        catch (JSONException e){
            e.printStackTrace();
        }

        try {
            jsonArray = jsonBookInfo.getJSONArray(TAG_BOOK_ARRAY);

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

                ListAdapter adapter = new SimpleAdapter(BookShelf.this,
                        bookList, R.layout.list_item_bookshelf,
                        new String[]{TAG_ISBN, TAG_TITLE, TAG_AUTHOR, TAG_YEAR},
                        new int[]{R.id.ISBN, R.id.Title, R.id.Author, R.id.PubYear});

                list.setAdapter(adapter);
            }
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void favoritesHandler(View v) {
        LinearLayout vwParentRow = (LinearLayout)v.getParent();
        ISBN = (TextView)vwParentRow.findViewById(R.id.ISBN);
        ISBNtoPHP = ISBN.getText().toString().substring(6);
        System.out.println("BS: click add-> "
                + ISBNtoPHP);
        new updateFavorites().execute();
    }

    public void readHandler(View v) {
        LinearLayout vwParentRow = (LinearLayout)v.getParent();
        ISBN = (TextView)vwParentRow.findViewById(R.id.ISBN);
        ISBNtoPHP = ISBN.getText().toString().substring(6);
        System.out.println("BS: click add-> "
                + ISBNtoPHP);
        new updateBooksRead().execute();
    }

    class updateFavorites extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(BookShelf.this);
            pDialog.setMessage("Updating Favorites...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        @Override
        protected String doInBackground(String... args) {
            try {
                ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("user_id", user_id));
                params.add(new BasicNameValuePair("ISBN", ISBNtoPHP));

                jsonUpdateInfo = jsonParser.makeHttpRequest(FAVORITES_URL, "POST", params);

                Log.d("BS dIB Attempt: ", jsonUpdateInfo.toString());

                success = jsonUpdateInfo.getInt(TAG_SUCCESS);
                if (success == 1) {
                    Log.d("BS dIB Successful", jsonUpdateInfo.toString());
                    //finish();
                    return jsonUpdateInfo.getString(TAG_MESSAGE);
                } else {
                    Log.d("BS dIB failed", jsonUpdateInfo.getString(TAG_MESSAGE));
                    return jsonUpdateInfo.getString(TAG_MESSAGE);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        protected void onPostExecute(String file_url) {
            // dismiss the dialog once product deleted
            pDialog.dismiss();
            if (file_url != null) {
                Toast.makeText(BookShelf.this, file_url, Toast.LENGTH_LONG).show();
            }
        }
    }

    class updateBooksRead extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(BookShelf.this);
            pDialog.setMessage("Updating Books Read...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        @Override
        protected String doInBackground(String... args) {
            try {
                ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("user_id", user_id));
                params.add(new BasicNameValuePair("ISBN", ISBNtoPHP));

                jsonUpdateInfo2 = jsonParser.makeHttpRequest(BOOKS_READ_URL, "POST", params);

                Log.d("BS dIB Attempt: ", jsonUpdateInfo2.toString());

                success = jsonUpdateInfo2.getInt(TAG_SUCCESS);
                if (success == 1) {
                    Log.d("BS dIB Successful", jsonUpdateInfo2.toString());
                    //finish();
                    return jsonUpdateInfo2.getString(TAG_MESSAGE);
                } else {
                    Log.d("BS dIB failed", jsonUpdateInfo.getString(TAG_MESSAGE));
                    return jsonUpdateInfo2.getString(TAG_MESSAGE);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        protected void onPostExecute(String file_url) {
            // dismiss the dialog once product deleted
            pDialog.dismiss();
            if (file_url != null) {
                Toast.makeText(BookShelf.this, file_url, Toast.LENGTH_LONG).show();
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
