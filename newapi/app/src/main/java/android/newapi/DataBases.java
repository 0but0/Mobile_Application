package android.newapi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBases extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="dbname.db";
    private static final int DATABASE_VERSION=1;
    public DataBases(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table user(email text primary key,password text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists user");
    }
    //insert user in database
    public boolean insert(String email,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("email",email);
        contentValues.put("password",password);
        long ins=db.insert("user",null,contentValues);
        if (ins==-1) return false;
        else return true;
    }
    //check if email existed
    public Boolean emailchk(String email){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select*from user where email=?",new String[]{email});
        if(cursor.getCount()>0) return false;
        else return true;
    }
    //check user's account if exist
    public Boolean useraccount(String email,String password){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select*from user where email=? and password=?",new String[]{email,password});
        if(cursor.getCount()>0)
            return true;

        else
            return false;

    }

}
