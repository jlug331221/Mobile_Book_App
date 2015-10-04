# csci4200-byteme-project
Project repository for the Byte Me team in CSCI 4200.

*** activity_login_screen.xml ***

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
        android:layout_marginTop="70dip"
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

</RelativeLayout>

*** END OF activity_login_screen.xml ***

*** roundededittext.xml ***

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

*** END OF roundededittext.xml ***

*** strings.xml *** 

<resources>
    <string name="app_name">Mobile Book App</string>
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
    
    <string name="registerButton">Register</string>
    <string name="registrationText">Registration</string>
</resources>

***  END Of strings.xml ***

*** LoginPageActivity.java ***

package com.example.justin331221.mobilebookapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class LoginPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login_page, menu);
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

*** END OF LoginPageActivity.java ***

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

*** END bookinfo.xml ***

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

*** END of findbook.xml ***

*** activity_registration.xml ***

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
        android:layout_marginTop="40dip"
        android:textSize="35sp"
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
        android:layout_marginTop="20dip"
        android:textSize="20sp"
        android:textStyle="bold"
        android:layout_width="150dip"
        android:layout_height="wrap_content" >
    </Button>

</RelativeLayout>

*** END of activity_registration.xml ***
