package com.example.du_an_1.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.du_an_1.model.Orders;
import com.example.du_an_1.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class OrdersDao {
    SQL sqLite;
    SQLiteDatabase db;
    Context context;
    public OrdersDao(Context context){
        this.context = context;
        sqLite = new SQL(context);
        db = sqLite.getWritableDatabase();
    }
    public int insert(Orders o){
        ContentValues values = new ContentValues();
        values.put("id",o.getId());
        values.put("user_id",o.getUser_id());
        values.put("vehicle_id",o.getVehicle_id());
        values.put("start_time",o.getStart_time());
        values.put("end_time",o.getEnd_time());
        values.put("total",o.getTotal());
        values.put("phatsinh",o.getPhatsinh());

        long kq = db.insert("Orders",null,values);
        if (kq <= 0){
            return -1;
        }
        return 1;
    }
    public int Update(Orders o){
        ContentValues values = new ContentValues();
        values.put("id",o.getId());
        values.put("user_id",o.getUser_id());
        values.put("vehicle_id",o.getVehicle_id());
        values.put("start_time",o.getStart_time());
        values.put("end_time",o.getEnd_time());
        values.put("total",o.getTotal());
        values.put("phatsinh",o.getPhatsinh());

        long kq = db.update("Orders",values,"id=?",new String[]{String.valueOf(o.getId())});
        if (kq <= 0){
            return -1;
        }
        return 1;
    }
    @SuppressLint("Range")
    public List<Orders> getData(String sql, String ...selectionArgs){
        List<Orders> list =  new ArrayList<>();
        Cursor c = db.rawQuery(sql,selectionArgs);
        while (c.moveToNext()){
            Orders o = new Orders();
            o.setId(Integer.parseInt(c.getString(c.getColumnIndex("id"))));
            o.setUser_id(Integer.parseInt(c.getString(c.getColumnIndex("user_id"))));
            o.setVehicle_id(Integer.parseInt(c.getString(c.getColumnIndex("vehicle_id"))));
            o.setStart_time(Integer.parseInt(c.getString(c.getColumnIndex("start_time"))));
            o.setEnd_time(Integer.parseInt(c.getString(c.getColumnIndex("end_time"))));
            o.setTotal(Integer.parseInt(c.getString(c.getColumnIndex("total"))));
            o.setPhatsinh(Integer.parseInt(c.getString(c.getColumnIndex("phatsinh"))));

            list.add(o);
        }
        return list;
    }
    public Orders getID(String id){
        String sql = "SELECT * FROM Orders WHERE id=?";
        List<Orders> list = getData(sql,id);
        return list.get(0);
    }
    public List<Orders> getAll(){
        String sql ="SELECT * FROM Orders";
        return getData(sql);
    }
}
