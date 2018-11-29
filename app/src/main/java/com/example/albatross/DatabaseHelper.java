package com.example.albatross;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    //this database class created using a tutorial online as help

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

    // drop table sql query
    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;

    /**
     * Constructor used to initialize the database and tables
     *
     * @param context as the current state of the application
     */
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    /*	@param db as the current database variable
	 *
    	@effects create a new table to store the users
    	@modifies database
    	@throws nothing
    	@return nothing
	 */
    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("WE HAVE MADE THE DB");
        db.execSQL(CREATE_USER_TABLE);
    }

    /*	@param db as the database variable, old version as the old database version, new version as the new version of the database
	 *
    	@effects if an upgrade to the database is needed, create a new version and update data
    	@modifies database
    	@throws nothing
    	@return nothing
	 */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Drop User Table if exist
        db.execSQL(DROP_USER_TABLE);

        // Create tables again
        onCreate(db);

    }

    /*	@param user
	 *
    	@effects insert a new user into the database
    	@modifies database
    	@throws nothing
    	@return nothing
	 **/
    public void addUser(User user) {
        System.out.println("WE ARE ADDING NEW USER");
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor dbCursor = db.query(TABLE_USER, null, null, null, null, null, null);
        String[] columnNames = dbCursor.getColumnNames();
        for(int i=0;i<columnNames.length;i++)
        {
            System.out.println("||||||||||| "+columnNames[i]);
        }

        ContentValues values = new ContentValues();
        values.put(COLUMN_Name, user.getName());
        values.put(COLUMN_USER_NAME, user.getUname());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());





        // Inserting Row
        db.insert(TABLE_USER, null, values);
        db.close();
    }

    /*	@param none
	 *
    	@effects none
    	@modifies database
    	@throws nothing
    	@return list of the users currently in the database
	 */
    public List<User> getAllUser() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_Name,
                COLUMN_USER_EMAIL,
                COLUMN_USER_NAME,
                COLUMN_USER_PASSWORD
        };
        // sorting orders
        String sortOrder =
                COLUMN_USER_NAME + " ASC";
        List<User> userList = new ArrayList<User>();

        SQLiteDatabase db = this.getReadableDatabase();

        // query the user table
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setName(cursor.getString(cursor.getColumnIndex(COLUMN_Name)));
                user.setUsername(cursor.getString(cursor.getColumnIndex(COLUMN_USER_NAME)));
                user.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_USER_EMAIL)));
                user.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_USER_PASSWORD)));
                // Adding user record to list
                userList.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list
        return userList;
    }

    /*	@param user
	 *
    	@effects update a user in the database
    	@modifies database
    	@throws nothing
    	@return nothing
	 */
    public void updateUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getName());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());

        // updating row
        db.update(TABLE_USER, values, COLUMN_Name + " = ?",
                new String[]{String.valueOf(user.getName())});
        db.close();
    }

    /*	@param user
	 *
    	@effects delete a user from the database
    	@modifies database
    	@throws nothing
    	@return nothing
	 */
    public void deleteUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        // delete user record by id
        db.delete(TABLE_USER, COLUMN_Name + " = ?",
                new String[]{String.valueOf(user.getName())});
        db.close();
    }

    /*	@param email
	 *
    	@effects check database to see if email exists
    	@modifies nothing
    	@throws nothing
    	@return boolean of whether it is or not in the database
	 */
    public boolean checkUser(String email) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_Name
        };
        SQLiteDatabase db = this.getReadableDatabase();

        // selection criteria
        String selection = COLUMN_USER_EMAIL + " = ?";

        // selection argument
        String[] selectionArgs = {email};

        // query user table with condition
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com';
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0) {
            return true;
        }

        return false;
    }

    /*	@param email, password
	 *
    	@effects check database to see if email and password exist
    	@modifies nothing
    	@throws nothing
    	@return boolean of whether it is or not in the database
	 */
    public boolean checkUser(String email, String password) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_Name
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = COLUMN_USER_EMAIL + " = ?" + " AND " + COLUMN_USER_PASSWORD + " = ?";

        // selection arguments
        String[] selectionArgs = {email, password};

        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }

        return false;
    }
}