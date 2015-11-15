package com.example.android.mobilebookapp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
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

public class BookSearchResults extends Activity {

    ListView list;

    private Button addBookButton;

    private ProgressDialog pDialog;

    JSONParser jsonParser = new JSONParser();

    private static final String ADD_BOOK_URL =
            "http://137.116.72.27/se_android_app/addBook.php";

    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";

    int success;

    //JSON Node Names; Table column names
    private static final String TAG_BOOK_ARRAY = "Book_Info";
    private static final String TAG_USER_ARRAY = "User_Info";
    private static final String TAG_ISBN = "ISBN";
    private static final String TAG_TITLE = "title";
    private static final String TAG_AUTHOR = "author";
    private static final String TAG_YEAR = "pub_year";

    private static final String TAG_USER_ID = "user_id";

    ArrayList<HashMap<String, String>> bookList = new ArrayList<HashMap<String, String>>();

    JSONObject jsonUserInfo = new JSONObject();
    JSONArray  jsonArrayUserID = new JSONArray();
    JSONObject jsonBookInfo = new JSONObject();
    JSONArray jsonArrayBookInfo = null;
    JSONObject jsonBookChild;

    TextView ISBN; // used to grab ISBN from listView row
    String ISBNtoPHP; // used to send to addBook.php as in params ArrayList
    String user_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);

        try {
            jsonBookInfo = new JSONObject(getIntent().getStringExtra("jsonBookResults"));
            Log.d("BSR Book Info", jsonBookInfo.toString());
            jsonUserInfo = new JSONObject(getIntent().getStringExtra("jsonUserResults"));
            Log.d("BSR User Info", jsonUserInfo.toString());

            jsonArrayUserID = jsonUserInfo.getJSONArray(TAG_USER_ARRAY);

            // Loop through jsonArrayUserID
            for (int k = 0; k < jsonArrayUserID.length(); k++) {
                JSONObject jsonUserChild = jsonArrayUserID.getJSONObject(k);
                user_id = jsonUserChild.getString(TAG_USER_ID);
                Log.d("BSR UserId = ", user_id);
            }


            jsonArrayBookInfo = jsonBookInfo.getJSONArray(TAG_BOOK_ARRAY);

            // Loop through jsonArrayBookInfo
            for (int i = 0; i < jsonArrayBookInfo.length(); i++) {
                jsonBookChild = jsonArrayBookInfo.getJSONObject(i);
                String ISBN = "ISBN: " + jsonBookChild.getString(TAG_ISBN);
                String title = "Title: " + jsonBookChild.getString(TAG_TITLE);
                String author = "Author: " + jsonBookChild.getString(TAG_AUTHOR);
                String year = "Publication Year: " + jsonBookChild.getString(TAG_YEAR);

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

    public void addBookHandler(View v) {
        LinearLayout vwParentRow = (LinearLayout)v.getParent();
        ISBN = (TextView)vwParentRow.findViewById(R.id.ISBN);
        ISBNtoPHP = ISBN.getText().toString().substring(6);
        System.out.println("BSR: click add-> "
                + ISBN.getText().toString().substring(6));
        new AddBook().execute();
    }

    class AddBook extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(BookSearchResults.this);
            pDialog.setMessage("Adding to bookshelf...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        @Override
        protected String doInBackground(String... args) {
            try {
                ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("ISBN", ISBNtoPHP));
                params.add(new BasicNameValuePair("user_id", user_id));

                Log.d("Adding book", "Starting");
                Log.d("AddBook dIB ISBN", ISBNtoPHP);
                Log.d("AddBook dIB user_id", user_id);

                JSONObject json = jsonParser.makeHttpRequest(
                        ADD_BOOK_URL, "POST", params);

                Log.d("AddBook dIB json ", json.toString());

                success = json.getInt(TAG_SUCCESS);
                if(success == 1) {
                    Log.d("AddBook dIB Successful ", json.toString());
                    return json.getString(TAG_MESSAGE);
                }
                else {
                    Log.d("AddBook dIB failed", json.getString(TAG_MESSAGE));
                    return json.getString(TAG_MESSAGE);
                }
            }
            catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        protected void onPostExecute(String file_url) {
            // dismiss the dialog once product deleted
            pDialog.dismiss();
            if (file_url != null){
                Toast.makeText(BookSearchResults.this, file_url, Toast.LENGTH_SHORT).show();
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
