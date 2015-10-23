package com.example.android.mobilebookapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class HomeScreen extends AppCompatActivity{

    private static Button viewBooksButton;
    private static Button searchForBooksButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        onClickViewBooksButtonListener();
        onClickSearchBooksButtonListener();
    }

    public void onClickViewBooksButtonListener() {
        viewBooksButton = (Button)findViewById(R.id.viewBooksButton);
        viewBooksButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent simple;
                        simple = new Intent(HomeScreen.this, SimpleBookShelfList.class);
                        startActivity(simple);
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
