package com.example.du_an_1.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.du_an_1.model.Users;
import com.example.du_an_1.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleDAO {
    SQL sqLite;
    SQLiteDatabase db;
    Context context;
    public VehicleDAO(Context context){
        this.context = context;
        sqLite = new SQL(context);
        db = sqLite.getWritableDatabase();
    }
    public int insert(Vehicle v){
        ContentValues values = new ContentValues();
        values.put("id",v.getId());
        values.put("categorie_id",v.getCategorie_id());
        values.put("capacity",v.getCapacity());
        values.put("status",v.getStatus());
        values.put("amount",v.getAmount());
        values.put("price",v.getPrice());

        long kq = db.insert("Vehicle",null,values);
        if (kq <= 0){
            return -1;
        }
        return 1;
    }
    public int Update(Vehicle v){
        ContentValues values = new ContentValues();
        values.put("id",v.getId());
        values.put("categorie_id",v.getCategorie_id());
        values.put("capacity",v.getCapacity());
        values.put("status",v.getStatus());
        values.put("amount",v.getAmount());
        values.put("price",v.getPrice());

        long kq = db.update("Vehicle",values,"id=?",new String[]{String.valueOf(v.getId())});
        if (kq <= 0){
            return -1;
        }
        return 1;
    }

    public int delete(String id){
        return db.delete("Vehicle","id=?",new String[]{id});
    }

    @SuppressLint("Range")
    public List<Vehicle> getData(String sql, String ...selectionArgs){
        List<Vehicle> list =  new ArrayList<>();
        Cursor c = db.rawQuery(sql,selectionArgs);
        while (c.moveToNext()){
            Vehicle v = new Vehicle();
            v.setId(Integer.parseInt(c.getString(c.getColumnIndex("id"))));
            v.setCategorie_id(Integer.parseInt(c.getString(c.getColumnIndex("categorie_id"))));
            v.setCapacity(Integer.parseInt(c.getString(c.getColumnIndex("capacity"))));
            v.setStatus(Integer.parseInt(c.getString(c.getColumnIndex("status"))));
            v.setAmount(Integer.parseInt(c.getString(c.getColumnIndex("amount"))));
            v.setPrice(Integer.parseInt(c.getString(c.getColumnIndex("price"))));

            list.add(v);
        }
        return list;
    }
    public Vehicle getID(String id){
        String sql = "SELECT * FROM Vehicle WHERE id=?";
        List<Vehicle> list = getData(sql,id);
        return list.get(0);
    }
    public List<Vehicle> getAll(){
        String sql ="SELECT * FROM Vehicle";
        return getData(sql);
    }
}
