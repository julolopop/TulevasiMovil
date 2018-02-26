package com.example.julolopop.tulevasi.data.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.julolopop.tulevasi.data.contract.TulevasiContract;
import com.example.julolopop.tulevasi.data.TulevasiOpenHelper;
import com.example.julolopop.tulevasi.pojo.Productos;

import java.util.ArrayList;

/**
 * Created by Julolopop on 14/01/2018.
 */

public class ProductosDao {

    public static ArrayList<Productos> loadAll() {
        ArrayList<Productos> ProductosArrayList = new ArrayList<>();
        SQLiteDatabase db = TulevasiOpenHelper.newInstance().openDatabase();


        if (db != null) {
            Cursor c = db.query(TulevasiContract.ProductosEntry.TABLE, TulevasiContract.ProductosEntry.ALLCOLUMNS, null, null, null, null, null, null);
            if (c != null) {
                while (c.moveToNext()) {
                    Productos acc = new Productos(c.getInt(0), c.getInt(1), c.getString(2), c.getFloat(3), c.getString(4));
                    ProductosArrayList.add(acc);
                }
            }
        }

        return ProductosArrayList;
    }

    public static ArrayList<Productos> getProductosArrayList(int id) {
        ArrayList<Productos> ProductosArrayList = new ArrayList<>();
        SQLiteDatabase db = TulevasiOpenHelper.newInstance().openDatabase();
        String selection = String.format("%s=?", TulevasiContract.ProductosEntry.IDCATEGORIA);
        String[] args = new String[]{String.valueOf(id)};


        if (db != null) {
            Cursor c = db.query(TulevasiContract.ProductosEntry.TABLE, TulevasiContract.ProductosEntry.ALLCOLUMNS, selection, args, null, null, null, null);
            if (c != null) {
                while (c.moveToNext()) {
                    Productos acc = new Productos(c.getInt(0), c.getInt(1), c.getString(2), c.getFloat(3), c.getString(4));
                    ProductosArrayList.add(acc);
                }
            }
        }

        return ProductosArrayList;
    }

    public static void AnadirProductos(Productos productos) {
        SQLiteDatabase db = TulevasiOpenHelper.newInstance().openDatabase();

        ContentValues values = new ContentValues();

        values.put(TulevasiContract.ProductosEntry.IDCATEGORIA, productos.getId_Categoria());
        values.put(TulevasiContract.ProductosEntry.IMG, productos.getImg());
        values.put(TulevasiContract.ProductosEntry.NOMBRE, productos.getNombre());
        values.put(TulevasiContract.ProductosEntry.PRECIO, productos.getPrecio());


        if (db != null) {
            db.insert(TulevasiContract.ProductosEntry.TABLE, null, values);
        }
    }

}

