package com.example.du_an_1.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.du_an_1.model.Users;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    SQL sqLite;
    SQLiteDatabase db;
    Context context;
    public UserDAO(Context context){
        this.context = context;
        sqLite = new SQL(context);
        db = sqLite.getWritableDatabase();
    }
    public int insert(Users u){
        ContentValues values = new ContentValues();
        values.put("id",u.getId());
        values.put("name",u.getName());
        values.put("date",u.getDate());
        values.put("address",u.getAddress());
        values.put("cccd",u.getCCCD());
        values.put("passwork",u.getPasswork());
        long kq = db.insert("Users",null,values);
        if (kq <= 0){
            return -1;
        }
        return 1;
    }
    public  int update(Users u){
        ContentValues values = new ContentValues();
        values.put("id",u.getId());
        values.put("name",u.getName());
        values.put("date",u.getDate());
        values.put("address",u.getAddress());
        values.put("cccd",u.getCCCD());
        values.put("passwork",u.getPasswork());
        long kq = db.update("Users",values,"id=?",new String[]{String.valueOf(u.getId())});
        if (kq <= 0){
            return -1;
        }
        return 1;

    }

    public int delete(String id){
        return db.delete("Users","id=?",new String[]{id});
    }


    @SuppressLint("Range")
    public List<Users> getData(String sql, String ...selectionArgs){
        List<Users> list =  new ArrayList<>();
        Cursor c = db.rawQuery(sql,selectionArgs);
        while (c.moveToNext()){
            Users u = new Users();
            u.setId(c.getString(c.getColumnIndex("id")));
            u.setName(c.getString(c.getColumnIndex("name")));
            u.setDate(Integer.parseInt(c.getString(c.getColumnIndex("date"))));
            u.setAddress(c.getString(c.getColumnIndex("address")));
            u.setCCCD(c.getString(c.getColumnIndex("cccd")));
            u.setPasswork(c.getString(c.getColumnIndex("passwork")));

            list.add(u);
        }
        return list;
    }
    public Users getID(String id){
        String sql = "SELECT * FROM Users WHERE id=?";
        List<Users> list = getData(sql,id);
        return list.get(0);
    }
    public List<Users> getAll(){
        String sql ="SELECT * FROM Users";
        return getData(sql);
    }
    public int checkLogin(String strUser, String strPass){
        List<Users> ls = getAll();
        for (Users u:ls) {
            if(u.getId().equals(strUser) && u.getPasswork().equals(strPass)){
                return 1;
            }
        }return -1;
    }
    public  int checkTKdau(){
        List<Users> ls = getAll();
        if (ls.size() <= 0){
            return 1;
        }
        return -1;
    }
}
