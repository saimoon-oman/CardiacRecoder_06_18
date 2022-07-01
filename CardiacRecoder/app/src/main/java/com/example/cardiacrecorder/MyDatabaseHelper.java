package com.example.cardiacrecorder;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="cardiac_recorder_list";
    private static final String TABLE_NAME="cardiac_recorder_list_details";
    private static final String ID="id";
    private static final String SYSTOLIC="systolic";
    private static final String DIASTOLIC="diastolic";
    private static final String BLOOD_PRESSURE_STATUS="pressure_sat";
    private static final String PULSE="pulse";
    private static final String PULSE_STATUS="pulse_stat";
    private static final String DATE="date";
    private static final String TIME="time";
    private static final String COMMENTS="comments";
    private static final int VERSION_NUMBER= 1;
    private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+SYSTOLIC+" varchar,"+DIASTOLIC+" varchar,"+BLOOD_PRESSURE_STATUS+" varchar,"+PULSE+" varchar,"+PULSE_STATUS+","+DATE+" varchar,"+TIME+" varchar,"+COMMENTS+" varchar(255));";

    private static final String SELECT_ALL ="SELECT * FROM cardiac_recorder_list WHERE id = ?";
    private static final String UPDATE_DATA = "SELECT * FROM "+TABLE_NAME;
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS "+TABLE_NAME;



private Context context;







    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME,null,VERSION_NUMBER);
        this.context= context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        Toast.makeText(context,"database created",Toast.LENGTH_SHORT).show();
        //db.execSQL(CREATE_TABLE);
        try{
            db.execSQL(CREATE_TABLE);

        }catch(Exception e)
        {
            Toast.makeText(context,"Error : "+e,Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        try
        {
            Toast.makeText(context,"onUpgrade is called",Toast.LENGTH_SHORT).show();
            db.execSQL(DROP_TABLE);
            onCreate(db);



        }
        catch (Exception e)
        {
            Toast.makeText(context,"Exception : "+e,Toast.LENGTH_SHORT).show();
        }
    }

    public long insertData(String systol, String diastol, String blood_pressure_status, String pulse, String pulse_status, String date_value, String time_value, String comments) {

    SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(SYSTOLIC,systol);
        contentValues.put(DIASTOLIC,diastol);
        contentValues.put(BLOOD_PRESSURE_STATUS,blood_pressure_status);
        contentValues.put(PULSE,pulse);
        contentValues.put(PULSE_STATUS,pulse_status);
        contentValues.put(DATE,"Date: "+date_value);
        contentValues.put(TIME,"Time: "+time_value);
        contentValues.put(COMMENTS,"Comments: "+comments);
        long id= sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        return id;
    }
}
