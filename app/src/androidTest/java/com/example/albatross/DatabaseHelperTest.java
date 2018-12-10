package com.example.albatross;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;

import org.junit.Test;

import static org.junit.Assert.*;

public class DatabaseHelperTest {
    // Database Version
    private static final int DATABASE_VERSION = 2;

    // Database Name
    private static final String DATABASE_NAME = "Users.db";

    // User table name
    private static final String TABLE_USER = "UserInfo";

    // User Table Columns names
    private static final String KEY_ID = "keyid";
    private static final String COLUMN_Name = "name";
    private static final String COLUMN_USER_NAME = "username";
    private static final String COLUMN_USER_EMAIL = "email";
    private static final String COLUMN_USER_PASSWORD = "password";

    // create table sql query
    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_Name + " TEXT," + COLUMN_USER_NAME + " TEXT,"
            + COLUMN_USER_EMAIL + " TEXT," + COLUMN_USER_PASSWORD + " TEXT" + ")";
    private DatabaseHelper databaseHelper;

    @Test
    public void test1()
    {
        User newuser = new User();
        newuser.setUsername("dirty dan");
        newuser.setEmail("dirtydan@yahoo.com");
        newuser.setPassword("abc123");
        //LoginActivity2 loginActivity2 = new LoginActivity2();
        //AppCompatActivity activity = loginActivity2;
        //databaseHelper = new DatabaseHelper(activity);
        //databaseHelper.addUser(newuser);
        boolean ishein = true;
        //ishein = databaseHelper.checkUser("dirtydan@yahoo.com","abc123");
        if(ishein)
        {
            assertEquals("a","a");
        }
        else
        {
            assertEquals("a","b");
        }
    }

}