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
    private static String LoginUserEmail;

    public static String getLoginUserEmail() {
        return LoginUserEmail;
    }

    public void setLoginUserEmail(String loginUserEmail) {
        this.LoginUserEmail = loginUserEmail;
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

        db.execSQL("CREATE TABLE IF NOT EXISTS HotelRoom ("+
                "RoomId INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "RoomName TEXT NOT NULL," +
                "Taken INTEGER NOT NULL, " +
                "Price INTEGER NOT NULL," +
                "Total INTEGER NOT NULL," +
                "RoomDescription TEXT NOT NULL," +
                "RoomNumber INTEGER NOT NULL);");

        db.execSQL(SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String SQL="DROP TABLE  IF EXISTS Users ;";
        String SQL2="DROP TABLE  IF EXISTS Rooms ;";
        db.execSQL(SQL);
        db.execSQL(SQL2);
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
            setLoginUserEmail(Email);
            if(cursor.getInt(6)==0) return "User";
            else return "Admin";
        }
        return  "NOT a User";
    }

    public String ForgetPassword(String Name,String Email,String Phone,int Age){
        SQLiteDatabase db=this.getReadableDatabase();
        String SQL="SELECT * FROM Users WHERE Email = ? AND Name = ? AND Phone = ?";
        Cursor cursor=db.rawQuery(SQL,new String[]{Email,Name,Phone});
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            if(cursor.getInt(2)==Age) return cursor.getString(5);
            else return "NOT";
        }
        return "NOT";
    }

    public User GetProfile(){
        SQLiteDatabase db=this.getReadableDatabase();
        String SQL="SELECT * FROM Users WHERE Email = ?";
        Cursor cursor = db.rawQuery(SQL,new String[]{this.LoginUserEmail});
            cursor.moveToFirst();
            int Id =cursor.getInt(0);
            String Name=cursor.getString(1);
            int Age= cursor.getInt(2);
            String Email = cursor.getString(3);
            String Phone  = cursor.getString(4);
            String Password =  cursor.getString(5);
            int Admin  =  cursor.getInt(6);
            User x=new User(Id,Name,Age,Email,Phone,Password,Admin);
            return x;
    }
    public void ChangePassword(String Email,String Password){
        SQLiteDatabase db=this.getReadableDatabase();
        ContentValues values=new ContentValues();
        values.put("Password",Password);
        db.update("Users",values,"Email=?",new String[]{Email});
        setLoginUserEmail(Email);
    }
    public void ChangeInformation(String OldEmail,String Name,String NewEmail,String Phone,int Age){
        SQLiteDatabase db=this.getReadableDatabase();
        ContentValues values=new ContentValues();
        values.put("Email",NewEmail);
        values.put("Name",Name);
        values.put("Age",Age);
        values.put("Phone",Phone);
        db.update("Users",values,"Email=?",new String[]{OldEmail});
        this.setLoginUserEmail(NewEmail);
    }



    public String InsertRoom(String Name,int Price,int Taken,int Number,int TotalRating,String Description){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("RoomName",Name);
        values.put("Price",Price);
        values.put("Taken",Taken);
        values.put("RoomNumber",Number);
        values.put("RoomDescription",Description);
        values.put("TotalRating",TotalRating);
        long x= db.insert("HotelRoom",null,values);
        if(x==-1)return "NOT";
        return "DONE";
    }


}
