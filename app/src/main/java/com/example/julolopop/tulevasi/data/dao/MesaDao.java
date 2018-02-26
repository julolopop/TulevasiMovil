package com.example.julolopop.tulevasi.data.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.julolopop.tulevasi.data.contract.TulevasiContract;
import com.example.julolopop.tulevasi.data.TulevasiOpenHelper;
import com.example.julolopop.tulevasi.pojo.Mesa;

import java.util.ArrayList;

/**
 * Created by Julolopop on 23/12/2017.
 */

public class MesaDao {

    public static ArrayList<Mesa> loadAll(int id){
        ArrayList<Mesa> mesaArrayList = new ArrayList<>();
        SQLiteDatabase db = TulevasiOpenHelper.newInstance().openDatabase();
        String selection = String.format("%s = ?", TulevasiContract.MesaEntry.IDZONA);
        String[] args = new String[]{String.valueOf(id)};


        if (db != null) {
            Cursor c = db.query(TulevasiContract.MesaEntry.TABLE, TulevasiContract.MesaEntry.ALLCOLUMNS,selection,args,null,null,null,null);

            if (c != null) {
                while (c.moveToNext()) {
                    Mesa acc = new Mesa(c.getInt(0),c.getInt(1), c.getString(2));
                    mesaArrayList.add(acc);
                }
            }
        }


        return mesaArrayList;
    }
}
