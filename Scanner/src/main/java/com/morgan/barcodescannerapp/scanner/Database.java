package com.morgan.barcodescannerapp.scanner;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Eugene Kamadi on 7/2/2014.
 */


    public class Database extends SQLiteOpenHelper {

        // All Static variables
        // Database Version
        private static final int DATABASE_VERSION = 2;

        // Database Name
        private static final String DATABASE_NAME = "scanningdetails";

        // visitors table name
        private static final String TABLE_VISITORS = "Visitors";
        // Staff table name
        private static final String TABLE_STAFF = "Staff";


 //Table Columns names visitors

        private static final String VISITORID = "visitorid";
        private static final String AUTOGENNO = "autogenno";
        private static final String COMPSERIALNO = "compserialno";
        // table column names for staff
        private static final String STAFFID = "staffid ";
        private static final String PFNO = "pfno" ;
        private static final String NAME = "name";
        private static final String STAFFCOMPSERIALNO = "staffcompserialno";
        private static final String MODEL = "model";

       public Database(Context context){
           super(context,DATABASE_NAME,null,DATABASE_VERSION);

       }
 //creating the tables
         public void onCreate(SQLiteDatabase db){
             String CREATE_VISITOR_TABLE = "CREATE TABLE" + TABLE_VISITORS + "("
             + VISITORID+ "INTEGER PRIMARY KEY,"+ AUTOGENNO + "TEXT,"
                     + COMPSERIALNO + "INTEGER" +")";

             db.execSQL(CREATE_VISITOR_TABLE);

             String CREATE_STAFF_TABLE = " CREATE TABLE" + TABLE_STAFF + "("
                     +STAFFID + " INTEGER PRIMARY KEY,"+NAME +" TEXT,"
                + PFNO+" INTEGER,"+ STAFFCOMPSERIALNO +"TEXT,"+MODEL +"TEXT"+")";
             db.execSQL(CREATE_STAFF_TABLE);



         }
// upgrading the database
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        // Drop older table if existed
// Drop older table if existed

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STAFF);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_VISITORS);

        // Create tables again
        onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    // Setting new visitors
    public void AddVisitors(Visitors visitors) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(AUTOGENNO, visitors.getautogenno());
        values.put(COMPSERIALNO, visitors.getCompserialno());

        // Inserting Row
        db.insert(TABLE_VISITORS, null, values);
        db.close(); // Closing database connection
    }

    // Setting new staff
    public void AddStaff(Staff staff) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
               values.put(NAME, staff.getname());
        values.put(PFNO, staff.getPfNo());
        values.put(STAFFCOMPSERIALNO, staff.getstaffcompserialno());
        values.put(MODEL, staff.getmodel());

        // Inserting Row
        db.insert(TABLE_VISITORS, null, values);
        db.close(); // Closing database connection

    }


    }









