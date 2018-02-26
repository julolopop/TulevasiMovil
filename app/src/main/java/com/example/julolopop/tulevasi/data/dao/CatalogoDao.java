package com.example.julolopop.tulevasi.data.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.julolopop.tulevasi.data.contract.TulevasiContract;
import com.example.julolopop.tulevasi.data.TulevasiOpenHelper;
import com.example.julolopop.tulevasi.pojo.Catalogo;

import java.util.ArrayList;

/**
 * Created by Julolopop on 14/01/2018.
 */

public class CatalogoDao {



    public static ArrayList<Catalogo> loadAll(){
        ArrayList<Catalogo> catalogoArrayList = new ArrayList<>();
        SQLiteDatabase db = TulevasiOpenHelper.newInstance().openDatabase();



        if (db != null) {
            Cursor c = db.query(TulevasiContract.CatalogoEntry.TABLE, TulevasiContract.CatalogoEntry.ALLCOLUMNS,null,null,null,null,null, null);
            if (c != null) {
                while (c.moveToNext()) {
                    Catalogo acc = new Catalogo(c.getInt(0), c.getString(1));
                    catalogoArrayList.add(acc);
                }
            }
        }


        return catalogoArrayList;
    }


    public static  ArrayList<Catalogo> getCatalogoArrayListid() {
        ArrayList<Catalogo> catalogoArrayList = new ArrayList<>();
        SQLiteDatabase db = TulevasiOpenHelper.newInstance().openDatabase();



        if (db != null) {
            Cursor c = db.query(TulevasiContract.CatalogoEntry.TABLE, TulevasiContract.CatalogoEntry.ALLCOLUMNS,null,null, TulevasiContract.CatalogoEntry._ID,null,null, null);
            if (c != null) {
                while (c.moveToNext()) {
                    Catalogo acc = new Catalogo(c.getInt(0), c.getString(1));
                    catalogoArrayList.add(acc);
                }
            }
        }


        return catalogoArrayList;
    }

    public static  ArrayList<Catalogo> getCatalogoArrayListnombre() {
        ArrayList<Catalogo> catalogoArrayList = new ArrayList<>();
        SQLiteDatabase db = TulevasiOpenHelper.newInstance().openDatabase();



        if (db != null) {
            Cursor c = db.query(TulevasiContract.CatalogoEntry.TABLE, TulevasiContract.CatalogoEntry.ALLCOLUMNS,null,null, TulevasiContract.CatalogoEntry.NOMBRE,null,null, null);
            if (c != null) {
                while (c.moveToNext()) {
                    Catalogo acc = new Catalogo(c.getInt(0), c.getString(1));
                    catalogoArrayList.add(acc);
                }
            }
        }


        return catalogoArrayList;
    }


}
