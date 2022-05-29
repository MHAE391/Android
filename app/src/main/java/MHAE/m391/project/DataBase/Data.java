package MHAE.m391.project.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class Data  extends SQLiteOpenHelper {
    public static final String DataBaseName="NewRoom.db";
    public Data(Context context){
        super(context,DataBaseName,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE IF NOT EXISTS HotelRoom ("+
                "RoomId INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "RoomName TEXT NOT NULL," +
                "Taken INTEGER NOT NULL, " +
                "Price INTEGER NOT NULL," +
                "Total INTEGER NOT NULL," +
                "RoomDescription TEXT NOT NULL," +
                "RoomNumber INTEGER NOT NULL);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String SQL="DROP TABLE  IF EXISTS HotelRoom ;";
        db.execSQL(SQL);
        onCreate(db);
    }

    public String InsertRoom(String Name,int Price,int Taken,int Number,int TotalRating,String Description){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("RoomName",Name);
        values.put("Price",Price);
        values.put("Taken",Taken);
        values.put("RoomNumber",Number);
        values.put("RoomDescription",Description);
        values.put("Total",TotalRating);
        long x= db.insert("HotelRoom",null,values);
        if(x==-1)return "NOT";
        return "DONE";
    }

    public ArrayList<Room> Get(){
        ArrayList<Room>arrayList=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        String SQL="SELECT * FROM   HotelRoom ;";
        Cursor cursor=db.rawQuery(SQL,null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            arrayList.add(new Room (
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getInt(2),
                    cursor.getInt(3),
                    cursor.getInt(4),
                    cursor.getInt(5),
                    cursor.getString(6)));
            cursor.moveToNext();
        }
        return arrayList;
    }

}
