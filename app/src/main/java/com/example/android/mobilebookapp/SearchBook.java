package com.example.android.mobilebookapp;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class SearchBook extends AppCompatActivity{

    private EditText titleTextField, authorTextField, ISBNTextField;

    private Button searchButton;

    private ProgressDialog pDialog;

    JSONParser jsonParser = new JSONParser();

    private static final String SEARCH_URL = "http://137.116.72.27/se_android_app/search.php";

    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchbook);

        titleTextField = (EditText)findViewById(R.id.findTitle);
        authorTextField = (EditText)findViewById(R.id.findAuthor);
        ISBNTextField = (EditText)findViewById(R.id.findISBN);

        onClickSearchButtonListener();

    }

    public void onClickSearchButtonListener() {
        searchButton = (Button)findViewById(R.id.searchButton);
        searchButton.setOnClickListener (
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        new BookSearch().execute();
                    }
                });
    }

    class BookSearch extends AsyncTask<String, String, String> {

        boolean failure = false;

        String title  = titleTextField.getText().toString();
        String author = authorTextField.getText().toString();
        String ISBN = ISBNTextField.getText().toString();

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(SearchBook.this);
            pDialog.setMessage("Searching for book...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        @Override
        protected String doInBackground(String... args) {
            int success;
            try {
                ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("title", title));
                params.add(new BasicNameValuePair("author", author));
                params.add(new BasicNameValuePair("ISBN", ISBN));

                System.out.println(params.get(0));
                System.out.println(params.get(1));
                System.out.println(params.get(2));

                Log.d("Searching", "Starting");

                JSONObject json = jsonParser.makeHttpRequest(
                        SEARCH_URL, "POST", params);

                Log.d("Search Attempt", json.toString());

                success = json.getInt(TAG_SUCCESS);
                if (success == 1) {
                    Log.d("Search Successful", json.toString());
                    finish();
                    return json.getString(TAG_MESSAGE);
                }
                else {
                    Log.d("Search failed.", json.getString(TAG_MESSAGE));
                    return json.getString(TAG_MESSAGE);
                }
            }
            catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        /**
         * After completing background task Dismiss the progress dialog
         * **/
        protected void onPostExecute(String file_url) {
            // dismiss the dialog once product deleted
            pDialog.dismiss();
            if (file_url != null){
                Toast.makeText(SearchBook.this, file_url, Toast.LENGTH_LONG).show();
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
