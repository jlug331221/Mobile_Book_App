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
