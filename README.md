# csci4200-byteme-project
Project repository for the Byte Me team in CSCI 4200.

*** roundedittext.xml ***

<?xml version="1.0" encoding="utf-8"?>
<!--  res/drawable/rounded_edittext.xml -->
<shape xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="rectangle" android:padding="10dp">
    <solid android:color="#E0E0E0" />
    <corners
        android:bottomRightRadius="15dp"
        android:bottomLeftRadius="15dp"
        android:topLeftRadius="15dp"
        android:topRightRadius="15dp"/>
</shape>

*** END OF roundedittext.xml ***

*** strings.xml *** 

<resources>
    <string name="app_name">Mobile Book App</string>
    <string name="registerActionBarText">Register to get Started</string>
    <string name="homeActionBarText">Welcome to your Bookshelf!</string>
    <string name="BooksListActionBarText">Your Books</string>
    <string name="homeWelcomeText">My Bookshelf</string>
    <string name="loginButton">Login</string>
    <string name="checkRememberMe">Remember Me?</string>
    <string name="action_settings">Settings</string>
    <string name="removeButton">Remove</string>
    <string name="book_info">Book Information</string>
    <string name="book_title">Title</string>
    <string name="book_author">Author(s)</string>
    <string name="book_ISBN">ISBN</string>
    <string name="book_format">Format</string>
    <string name="book_pub_date">Pub. Date</string>
    <string name="book_edition">Edition</string>
    <string name="book_status">Status</string>
    <string name="searchButton">Search</string>
    <string name="find_book">Find A Book</string>
    <string name="myBookShelf">View Books</string>
    <string name="searchForBooks">Search For New Books!</string>
    <string name="registerButton">Register</string>
    <string name="registrationText">Registration</string>
</resources>

***  END Of strings.xml ***

*** activity_login_screen.xml ***

<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="fill_parent"
    android:layout_height="fill_parent"
    android:background="#4A148C"
    android:fadingEdge="horizontal">

    <TextView
        android:id="@+id/AppText"
        android:text="@string/app_name"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerHorizontal="true"
        android:layout_alignParentTop="true"
        android:layout_marginTop="50dip"
        android:textSize="40sp"
        android:padding="10dip"
        android:textColor="#FFD600"
        android:typeface="serif" >
    </TextView>

    <EditText
        android:id="@+id/username"
        android:layout_width="250dip"
        android:background="@drawable/roundedittext"
        android:layout_height="wrap_content"
        android:layout_below="@+id/AppText"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="30dip"
        android:hint="Username"
        android:textStyle="italic"
        android:textSize="35sp"
        android:typeface="serif"
        android:gravity="center"
        android:padding="5dip" >
    </EditText>

    <EditText
        android:id="@+id/password"
        android:layout_width="250dip"
        android:background="@drawable/roundedittext"
        android:layout_height="wrap_content"
        android:layout_below="@+id/username"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="40dip"
        android:hint="Password"
        android:textStyle="italic"
        android:textSize="35sp"
        android:typeface="serif"
        android:gravity="center"
        android:padding="5dip" >
    </EditText>

    <CheckBox
        android:id="@+id/checkRememberMe"
        android:layout_below="@id/password"
        android:text="@string/checkRememberMe"
        android:textSize="20sp"
        android:buttonTint="#000000"
        android:textColor="#ffffff"
        android:typeface="serif"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="30dip"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" >
    </CheckBox>

    <Button
        android:id="@+id/loginButton"
        android:text="@string/loginButton"
        android:typeface="serif"
        android:layout_below="@id/checkRememberMe"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="20dip"
        android:textSize="20sp"
        android:textStyle="bold"
        android:layout_width="150dip"
        android:layout_height="wrap_content" >
    </Button>

    <Button
        android:id="@+id/registerButton"
        android:text="@string/registerButton"
        android:typeface="serif"
        android:layout_below="@id/loginButton"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="10dip"
        android:textSize="20sp"
        android:textStyle="bold"
        android:layout_width="150dip"
        android:layout_height="wrap_content" >
    </Button>

</RelativeLayout>

*** END OF activity_login_screen.xml ***

*** LoginScreen.java ***

package com.example.android.mobilebookapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class LoginScreen extends AppCompatActivity {

    private static Button regButton;
    private static Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        onClickLoginButtonListener();
        onClickRegisterButtonListener();
    }

    public void onClickRegisterButtonListener() {
        regButton = (Button)findViewById(R.id.registerButton);
        regButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent("com.example.android.mobilebookapp.Registration");
                        startActivity(i);
                    }
                });
    }

    public void onClickLoginButtonListener() {
        loginButton = (Button)findViewById(R.id.loginButton);
        loginButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent("com.example.android.mobilebookapp.HomeScreen");
                        startActivity(i);
                    }
                }
        );
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

*** END OF LoginScreen.java ***

*** activity_registration_screen.xml ***

<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="fill_parent"
    android:layout_height="fill_parent"
    android:background="#4A148C"
    android:fadingEdge="horizontal" >

    <TextView
        android:id="@+id/RegistrationText"
        android:text="@string/registrationText"
        android:layout_alignParentTop="true"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="20dip"
        android:layout_marginLeft="15dip"
        android:textSize="45sp"
        android:padding="10dip"
        android:textColor="#FFD600"
        android:typeface="serif"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content">
    </TextView>

    <EditText
        android:id="@+id/EmailEditText"
        android:layout_below="@id/RegistrationText"
        android:layout_marginLeft="15dip"
        android:background="@drawable/roundedittext"
        android:layout_centerHorizontal="true"
        android:hint="Email"
        android:textStyle="italic"
        android:layout_marginTop="25dip"
        android:layout_width="300dip"
        android:layout_height="wrap_content"
        android:padding="10dip"
        android:gravity="center" >
    </EditText>

    <EditText
        android:id="@+id/UsernameEditText"
        android:layout_below="@id/EmailEditText"
        android:layout_marginLeft="15dip"
        android:background="@drawable/roundedittext"
        android:layout_centerHorizontal="true"
        android:hint="Username"
        android:textStyle="italic"
        android:layout_marginTop="20dip"
        android:layout_width="300dip"
        android:layout_height="wrap_content"
        android:padding="10dip"
        android:gravity="center" >
    </EditText>

    <EditText
        android:id="@+id/PasswordEditText"
        android:layout_below="@id/UsernameEditText"
        android:layout_marginLeft="15dip"
        android:background="@drawable/roundedittext"
        android:layout_centerHorizontal="true"
        android:hint="Password"
        android:textStyle="italic"
        android:layout_marginTop="20dip"
        android:layout_width="300dip"
        android:layout_height="wrap_content"
        android:padding="10dip"
        android:gravity="center" >
    </EditText>

    <EditText
        android:id="@+id/FirstNameEditText"
        android:layout_below="@id/PasswordEditText"
        android:layout_marginLeft="15dip"
        android:background="@drawable/roundedittext"
        android:layout_centerHorizontal="true"
        android:hint="First Name"
        android:textStyle="italic"
        android:layout_marginTop="20dip"
        android:layout_width="300dip"
        android:layout_height="wrap_content"
        android:padding="10dip"
        android:gravity="center" >
    </EditText>

    <EditText
        android:id="@+id/LastNameEditText"
        android:layout_below="@id/FirstNameEditText"
        android:layout_marginLeft="15dip"
        android:background="@drawable/roundedittext"
        android:layout_centerHorizontal="true"
        android:hint="Last Name"
        android:textStyle="italic"
        android:layout_marginTop="20dip"
        android:layout_width="300dip"
        android:layout_height="wrap_content"
        android:padding="10dip"
        android:gravity="center" >
    </EditText>

    <Button
        android:id="@+id/registerButton"
        android:text="@string/registerButton"
        android:typeface="serif"
        android:layout_below="@id/LastNameEditText"
        android:layout_centerHorizontal="true"
        android:layout_marginLeft="15dp"
        android:layout_marginTop="35dip"
        android:textSize="20sp"
        android:textStyle="bold"
        android:layout_width="150dip"
        android:layout_height="wrap_content" >
    </Button>

</RelativeLayout>

*** END of activity_registration_screen.xml ***

*** Registration.java ***

package com.example.android.mobilebookapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class Registration extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_screen);
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

*** End of Registration.java ***

*** activity_home_screen.xml ***

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:layout_width="fill_parent"
    android:layout_height="fill_parent"
    android:background="#4A148C"
    android:fadingEdge="horizontal" >

    <TextView
        android:id="@+id/AppText"
        android:text="@string/homeWelcomeText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:layout_marginTop="50dip"
        android:textSize="40sp"
        android:padding="10dip"
        android:textColor="#FFD600"
        android:typeface="serif" >
    </TextView>

    <Button
        android:id="@+id/viewBooksButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:layout_marginTop="30dip"
        android:text="@string/myBookShelf"
        android:typeface="serif"
        android:textSize="20sp"
        android:textStyle="bold" >
    </Button>

    <Button
        android:id="@+id/searchForBooks"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:layout_marginTop="50dip"
        android:text="@string/searchForBooks"
        android:typeface="serif"
        android:textSize="20sp"
        android:textStyle="bold" >
    </Button>

</LinearLayout>

*** End of activity_home_screen.xml ***

*** HomeScreen.java ***

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
    }

    public void onClickViewBooksButtonListener() {
        viewBooksButton = (Button)findViewById(R.id.viewBooksButton);
        viewBooksButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent simple;
                        simple = new Intent(HomeScreen.this,SimpleBookShelfList.class);
                        startActivity(simple);
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

*** End of HomeScreen.java ***

*** listView.xml (This is the simple list view with temp book data) ***

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#4A148C"
    android:paddingLeft="15dip"
    android:paddingTop="13dip"
    android:paddingBottom="13dip" >

    <ListView
        android:id="@+id/listview_book"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" >
    </ListView>

</LinearLayout>

*** End of listView.xml ***

*** list_item_book.xml ***

<?xml version="1.0" encoding="utf-8"?>
<TextView
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:textSize="20sp"
    android:textColor="#FFD600"
    android:minHeight="?android:attr/listPreferredItemHeight"
    android:gravity="center_vertical"
    android:id="@+id/list_item_book_textView" >
</TextView>

*** End of list_item_book.xml ***

*** SimpleBookShelfList.java ***

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

*** End of SimpleBookShelfList.java ***

*** bookinfo.xml ***

<RelativeLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="fill_parent"
    android:layout_height="fill_parent"
    android:background="#4A148C"
    android:fadingEdge="horizontal">

    <TextView
        android:id="@+id/BookInfo"
        android:text="@string/book_info"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerHorizontal="true"
        android:layout_alignParentTop="true"
        android:layout_marginTop="20dip"
        android:textSize="35sp"
        android:padding="5dip"
        android:textColor="#FFD600"
        android:typeface="serif" >
    </TextView>

    <TextView
        android:id="@+id/BookTitle"
        android:text="@string/book_title"
        android:layout_width="110dip"
        android:layout_height="wrap_content"
        android:layout_below="@+id/BookInfo"
        android:layout_marginTop="20dip"
        android:layout_marginLeft="15dip"
        android:textSize="20sp"
        android:padding="5dip"
        android:background="#FFD600"
        android:textColor="#000000"
        android:typeface="serif" >
    </TextView>

    <TextView
        android:id="@+id/BookTitle1"
        android:text=" TBD "
        android:layout_width="240dip"
        android:layout_height="wrap_content"
        android:layout_below="@+id/BookInfo"
        android:layout_toEndOf="@+id/BookTitle"
        android:layout_toRightOf="@+id/BookTitle"
        android:layout_marginTop="20dip"
        android:layout_marginLeft="15dip"
        android:textSize="17sp"
        android:padding="5dip"
        android:textColor="#FFD600"
        android:typeface="serif" >
    </TextView>

    <TextView
        android:id="@+id/BookAuthor"
        android:text="@string/book_author"
        android:layout_width="110dip"
        android:layout_height="wrap_content"
        android:layout_below="@+id/BookTitle"
        android:layout_marginTop="15dip"
        android:layout_marginLeft="15dip"
        android:textSize="20sp"
        android:padding="5dip"
        android:background="#FFD600"
        android:textColor="#000000"
        android:typeface="serif" >
    </TextView>

    <TextView
        android:id="@+id/BookAuthor1"
        android:text=" TBD "
        android:layout_width="240dip"
        android:layout_height="wrap_content"
        android:layout_below="@+id/BookTitle1"
        android:layout_toRightOf="@+id/BookAuthor"
        android:layout_marginTop="20dip"
        android:layout_marginLeft="15dip"
        android:textSize="17sp"
        android:padding="5dip"
        android:textColor="#FFD600"
        android:typeface="serif" >
    </TextView>

    <TextView
        android:id="@+id/BookISBN"
        android:text="@string/book_ISBN"
        android:layout_width="110dip"
        android:layout_height="wrap_content"
        android:layout_below="@+id/BookAuthor"
        android:layout_marginTop="20dip"
        android:layout_marginLeft="15dip"
        android:textSize="20sp"
        android:padding="5dip"
        android:background="#FFD600"
        android:textColor="#000000"
        android:typeface="serif" >
    </TextView>

    <TextView
        android:id="@+id/BookISBN1"
        android:text=" TBD "
        android:layout_width="240dip"
        android:layout_height="wrap_content"
        android:layout_below="@+id/BookAuthor1"
        android:layout_toRightOf="@+id/BookTitle"
        android:layout_marginTop="20dip"
        android:layout_marginLeft="15dip"
        android:textSize="17sp"
        android:padding="5dip"
        android:textColor="#FFD600"
        android:typeface="serif" >
    </TextView>

    <TextView
        android:id="@+id/BookFormat"
        android:text="@string/book_format"
        android:layout_width="110dip"
        android:layout_height="wrap_content"
        android:layout_below="@+id/BookISBN"
        android:layout_marginTop="15dip"
        android:layout_marginLeft="15dip"
        android:textSize="20sp"
        android:padding="5dip"
        android:background="#FFD600"
        android:textColor="#000000"
        android:typeface="serif" >
    </TextView>

    <TextView
        android:id="@+id/BookFormat1"
        android:text=" TBD "
        android:layout_width="240dip"
        android:layout_height="wrap_content"
        android:layout_below="@+id/BookISBN1"
        android:layout_toRightOf="@+id/BookTitle"
        android:layout_marginTop="20dip"
        android:layout_marginLeft="15dip"
        android:textSize="17sp"
        android:padding="5dip"
        android:textColor="#FFD600"
        android:typeface="serif" >
    </TextView>

    <TextView
        android:id="@+id/BookPubDate"
        android:text="@string/book_pub_date"
        android:layout_width="110dip"
        android:layout_height="wrap_content"
        android:layout_below="@+id/BookFormat"
        android:layout_marginTop="15dip"
        android:layout_marginLeft="15dip"
        android:textSize="20sp"
        android:padding="5dip"
        android:background="#FFD600"
        android:textColor="#000000"
        android:typeface="serif" >
    </TextView>

    <TextView
        android:id="@+id/BookPubDate1"
        android:text=" TBD "
        android:layout_width="240dip"
        android:layout_height="wrap_content"
        android:layout_below="@+id/BookFormat1"
        android:layout_toRightOf="@+id/BookPubDate"
        android:layout_marginTop="20dip"
        android:layout_marginLeft="15dip"
        android:textSize="17sp"
        android:padding="5dip"
        android:textColor="#FFD600"
        android:typeface="serif" >
    </TextView>

    <TextView
        android:id="@+id/BookEdition"
        android:text="@string/book_edition"
        android:layout_width="110dip"
        android:layout_height="wrap_content"
        android:layout_below="@+id/BookPubDate"
        android:layout_marginTop="15dip"
        android:layout_marginLeft="15dip"
        android:textSize="17sp"
        android:padding="5dip"
        android:background="#FFD600"
        android:textColor="#000000"
        android:typeface="serif" >
    </TextView>

    <TextView
        android:id="@+id/BookEdition1"
        android:text=" TBD "
        android:layout_width="240dip"
        android:layout_height="wrap_content"
        android:layout_below="@+id/BookPubDate1"
        android:layout_toRightOf="@+id/BookEdition"
        android:layout_marginTop="20dip"
        android:layout_marginLeft="15dip"
        android:textSize="17sp"
        android:padding="5dip"
        android:textColor="#FFD600"
        android:typeface="serif" >
    </TextView>

    <TextView
        android:id="@+id/BookStatus"
        android:text="@string/book_status"
        android:layout_width="110dip"
        android:layout_height="wrap_content"
        android:layout_below="@+id/BookEdition"
        android:layout_marginTop="15dip"
        android:layout_marginLeft="15dip"
        android:textSize="20sp"
        android:padding="5dip"
        android:background="#FFD600"
        android:textColor="#000000"
        android:typeface="serif" >
    </TextView>

    <TextView
        android:id="@+id/BookStatus1"
        android:text=" TBD "
        android:layout_width="240dip"
        android:layout_height="wrap_content"
        android:layout_below="@+id/BookEdition1"
        android:layout_toRightOf="@+id/BookStatus"
        android:layout_marginTop="20dip"
        android:layout_marginLeft="15dip"
        android:textSize="17sp"
        android:padding="5dip"
        android:textColor="#FFD600"
        android:typeface="serif" >
    </TextView>

    <Button
        android:id="@+id/removeButton"
        android:text="@string/removeButton"
        android:typeface="serif"
        android:layout_marginTop="15dip"
        android:layout_centerHorizontal="true"
        android:textSize="25sp"
        android:textStyle="bold"
        android:layout_width="150dip"
        android:layout_height="wrap_content"
        android:layout_below="@+id/BookStatus"
    />

</RelativeLayout>

*** End of bookinfo.xml ***

*** findbook.xml ***

<RelativeLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="fill_parent"
    android:layout_height="fill_parent"
    android:background="#4A148C"
    android:fadingEdge="horizontal">

    <TextView
        android:id="@+id/FindBook"
        android:text="@string/find_book"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerHorizontal="true"
        android:layout_alignParentTop="true"
        android:layout_marginTop="20dip"
        android:textSize="35sp"
        android:padding="5dip"
        android:textColor="#FFD600"
        android:typeface="serif" >
    </TextView>

    <TextView
        android:id="@+id/BookTitle"
        android:text="@string/book_title"
        android:layout_width="110dip"
        android:layout_height="wrap_content"
        android:layout_below="@+id/FindBook"
        android:layout_marginTop="20dip"
        android:layout_marginLeft="15dip"
        android:textSize="20sp"
        android:padding="5dip"
        android:background="#FFD600"
        android:textColor="#000000"
        android:typeface="serif" >
    </TextView>

    <EditText
        android:id="@+id/findTitle"
        android:layout_width="240dip"
        android:background="@drawable/roundedittext"
        android:layout_height="wrap_content"
        android:layout_below="@+id/FindBook"
        android:layout_toRightOf="@+id/BookTitle"
        android:layout_marginTop="20dip"
        android:layout_marginLeft="15dip"
        android:hint="Enter Title"
        android:textStyle="italic"
        android:textSize="18sp"
        android:typeface="serif"
        android:gravity="center"
        android:padding="5dip" >
    </EditText>

    <TextView
        android:id="@+id/BookAuthor"
        android:text="@string/book_author"
        android:layout_width="110dip"
        android:layout_height="wrap_content"
        android:layout_below="@+id/BookTitle"
        android:layout_marginTop="20dip"
        android:layout_marginLeft="15dip"
        android:textSize="20sp"
        android:padding="5dip"
        android:background="#FFD600"
        android:textColor="#000000"
        android:typeface="serif" >
    </TextView>

    <EditText
        android:id="@+id/findAuthor"
        android:layout_width="240dip"
        android:background="@drawable/roundedittext"
        android:layout_height="wrap_content"
        android:layout_below="@+id/findTitle"
        android:layout_toRightOf="@+id/BookAuthor"
        android:layout_marginTop="23dip"
        android:layout_marginLeft="15dip"
        android:hint="Enter Author"
        android:textStyle="italic"
        android:textSize="18sp"
        android:typeface="serif"
        android:gravity="center"
        android:padding="5dip" >
    </EditText>

    <TextView
        android:id="@+id/BookISBN"
        android:text="@string/book_ISBN"
        android:layout_width="110dip"
        android:layout_height="wrap_content"
        android:layout_below="@+id/BookAuthor"
        android:layout_marginTop="20dip"
        android:layout_marginLeft="15dip"
        android:textSize="20sp"
        android:padding="5dip"
        android:background="#FFD600"
        android:textColor="#000000"
        android:typeface="serif" >
    </TextView>

    <EditText
        android:id="@+id/findISBN"
        android:layout_width="240dip"
        android:background="@drawable/roundedittext"
        android:layout_height="wrap_content"
        android:layout_below="@+id/findAuthor"
        android:layout_toRightOf="@+id/BookISBN"
        android:layout_marginTop="23dip"
        android:layout_marginLeft="15dip"
        android:hint="Enter ISBN"
        android:textStyle="italic"
        android:textSize="18sp"
        android:typeface="serif"
        android:gravity="center"
        android:padding="5dip" >
    </EditText>

    <TextView
        android:id="@+id/BookFormat"
        android:text="@string/book_format"
        android:layout_width="110dip"
        android:layout_height="wrap_content"
        android:layout_below="@+id/BookISBN"
        android:layout_marginTop="20dip"
        android:layout_marginLeft="15dip"
        android:textSize="20sp"
        android:padding="5dip"
        android:background="#FFD600"
        android:textColor="#000000"
        android:typeface="serif" >
    </TextView>

    <EditText
        android:id="@+id/findFormat"
        android:layout_width="240dip"
        android:background="@drawable/roundedittext"
        android:layout_height="wrap_content"
        android:layout_below="@+id/findISBN"
        android:layout_toRightOf="@+id/BookISBN"
        android:layout_marginTop="23dip"
        android:layout_marginLeft="15dip"
        android:hint="Enter Format"
        android:textStyle="italic"
        android:textSize="18sp"
        android:typeface="serif"
        android:gravity="center"
        android:padding="5dip" >
    </EditText>

    <TextView
        android:id="@+id/BookPubDate"
        android:text="@string/book_pub_date"
        android:layout_width="110dip"
        android:layout_height="wrap_content"
        android:layout_below="@+id/BookFormat"
        android:layout_marginTop="20dip"
        android:layout_marginLeft="15dip"
        android:textSize="20sp"
        android:padding="5dip"
        android:background="#FFD600"
        android:textColor="#000000"
        android:typeface="serif" >
    </TextView>

    <EditText
        android:id="@+id/findPubDate"
        android:layout_width="240dip"
        android:background="@drawable/roundedittext"
        android:layout_height="wrap_content"
        android:layout_below="@+id/findFormat"
        android:layout_toRightOf="@+id/BookPubDate"
        android:layout_marginTop="23dip"
        android:layout_marginLeft="15dip"
        android:hint="Enter Pub. Date"
        android:textStyle="italic"
        android:textSize="18sp"
        android:typeface="serif"
        android:gravity="center"
        android:padding="5dip" >
    </EditText>

    <TextView
        android:id="@+id/BookEdition"
        android:text="@string/book_edition"
        android:layout_width="110dip"
        android:layout_height="wrap_content"
        android:layout_below="@+id/BookPubDate"
        android:layout_marginTop="20dip"
        android:layout_marginLeft="15dip"
        android:textSize="20sp"
        android:padding="5dip"
        android:background="#FFD600"
        android:textColor="#000000"
        android:typeface="serif" >
    </TextView>

    <EditText
        android:id="@+id/findEdition"
        android:layout_width="240dip"
        android:background="@drawable/roundedittext"
        android:layout_height="wrap_content"
        android:layout_below="@+id/findPubDate"
        android:layout_toRightOf="@+id/BookEdition"
        android:layout_marginTop="22dip"
        android:layout_marginLeft="15dip"
        android:hint="Enter Edition"
        android:textStyle="italic"
        android:textSize="18sp"
        android:typeface="serif"
        android:gravity="center"
        android:padding="5dip" >
    </EditText>

    <Button
        android:id="@+id/searchButton"
        android:text="@string/searchButton"
        android:typeface="serif"
        android:layout_marginTop="40dip"
        android:layout_centerHorizontal="true"
        android:textSize="30sp"
        android:textStyle="bold"
        android:layout_width="200dip"
        android:layout_height="wrap_content"
        android:layout_below="@+id/findEdition"
        android:padding="10dip"
        />

</RelativeLayout>

*** End of findbook.xml ***
