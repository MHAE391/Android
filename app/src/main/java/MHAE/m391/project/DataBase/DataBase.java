package MHAE.m391.project.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DataBase extends SQLiteOpenHelper {
    public static final String DataBaseName="Hotel.db";
    public DataBase(Context context){
        super(context,DataBaseName,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        String SQL="CREATE TABLE IF NOT EXISTS Users ("+
                "Id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "Name TEXT NOT NULL," +
                "Age INTEGER NOT NULL, " +
                "Email TEXT NOT NULL," +
                "Phone TEXT NOT NULL," +
                "Password TEXT NOT NULL," +
                "Admin INTEGER NOT NULL);";
        db.execSQL(SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String SQL="DROP TABLE  IF EXISTS Users ;";
        db.execSQL(SQL);
        onCreate(db);

    }

    public String Insert(String Name,String Email,String Password,String Phone,int Age,int Admin){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("Name",Name);
        values.put("Age",Age);
        values.put("Email",Email);
        values.put("Password",Password);
        values.put("Phone",Phone);
        values.put("Admin",Admin);
        long x= db.insert("Users",null,values);
        if(x==-1)return "NOT";
        return "DONE";
    }


    String SQL="CREATE TABLE IF NOT EXISTS Users ("+
            "Id INTEGER PRIMARY KEY AUTOINCREMENT,"+
            "Name TEXT NOT NULL," +
            "Age INTEGER NOT NULL, " +
            "Email TEXT NOT NULL," +
            "Phone TEXT NOT NULL," +
            "Password TEXT NOT NULL," +
            "Admin INTEGER NOT NULL);";

    public ArrayList<User> Get(){
        ArrayList<User>arrayList=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        String SQL="SELECT * FROM Users  ;";
        Cursor cursor=db.rawQuery(SQL,null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            arrayList.add(new User (
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getInt(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getInt(6)));
                    cursor.moveToNext();
        }
        return arrayList;
    }
    public String Check(String Email){
        SQLiteDatabase db=this.getReadableDatabase();
        String SQL="SELECT * FROM Users WHERE Email = ?";
        Cursor cursor = db.rawQuery(SQL,new String[]{Email});
        if(cursor.getCount()>0)return "User";
        return  "NOT a User";
    }
    public String CheckUser(String Email,String Password){
        SQLiteDatabase db=this.getReadableDatabase();
        String SQL="SELECT * FROM Users WHERE Email = ? AND Password = ?";
        Cursor cursor = db.rawQuery(SQL,new String[]{Email,Password});
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            if(cursor.getInt(6)==0) return "User";
            else return "Admin";
        }
        return  "NOT a User";
    }




}
