# csci4200-byteme-project
Project repository for the Byte Me team in CSCI 4200.

*** activity_login_page.xml ***

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
        android:background="#FFD600"
        android:textColor="#000000"
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

*** END OF activity_login_page.xml ***

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
