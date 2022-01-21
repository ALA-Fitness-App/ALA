package com.example.alafitness;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

/**
 * Child class to set up and manipulate SQLite database.
 * Contains inherited and bespoke methods.
 */
public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "Login.db";

    public DBHelper(Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users(username TEXT NOT NULL primary key, password TEXT)");
        MyDB.execSQL("create Table workouts(username TEXT NOT NULL, timestamp DATETIME DEFAULT CURRENT_TIMESTAMP, duration int, FOREIGN KEY (username))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
        MyDB.execSQL("drop Table if exists users");
        MyDB.execSQL("drop Table if exists workouts");
    }

    /**
     * Method that inserts data into the database.
     *
     * @param username - String.
     * @param password - String.
     * @return true - new data has been inserted into the table.
     */
    public Boolean insertUserData(String username, String password) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = MyDB.insert("users", null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    /**
     * Login method to check the username and if it exists in the database.
     *
     * @param username - String.
     * @return false if username does not exist.
     */
    public Boolean checkUsername(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[]{username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    /**
     * Login method to check username and password if they exist and match compared to database.
     *
     * @param username - String.
     * @param password - String.
     * @return false if username and password are a mismatch.
     */
    public Boolean checkUsernamePassword(String username, String password) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?", new String[]{username, password});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    /**
     * Method that inserts data into the database.
     *
     * @param username - String.
     * @param duration - int, duration of a workout in minutes.
     * @return true - new data has been inserted into the table.
     */
    public Boolean insertWorkoutData(String username, int duration) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("duration", duration);
        long result = MyDB.insert("workouts", null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public int getWorkoutDuration(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from workouts where username = ?", new String[]{username});
        if (cursor != null) {
            cursor.moveToLast();
            int workoutDuration = cursor.getInt(cursor.getColumnIndex("duration"));
            if (workoutDuration > 0) {
                return workoutDuration;
            } else {
                return 0;
            }
        } else {

        }
        return 0;
    }

    public int getTotalWorkoutAmount(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select count (*) from workouts where username = ?", new String[]{username});
        int totalAmount = 0;
        if (null != cursor) {
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                totalAmount = cursor.getInt(cursor.getColumnIndex("duration"));
            }
        }
        return totalAmount;
    }
}
