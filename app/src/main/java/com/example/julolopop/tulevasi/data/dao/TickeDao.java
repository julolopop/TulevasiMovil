package com.example.julolopop.tulevasi.data.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.julolopop.tulevasi.broadcast.TulevasiBroadcast;
import com.example.julolopop.tulevasi.data.contract.TulevasiContract;
import com.example.julolopop.tulevasi.data.TulevasiOpenHelper;
import com.example.julolopop.tulevasi.pojo.Ticked;

import java.util.ArrayList;

/**
 * Created by Julolopop on 24/12/2017.
 */

public class TickeDao {


    public static void EditarTicked(Ticked ticked) {
        ArrayList<Ticked> tickedArrayList = new ArrayList<>();
        SQLiteDatabase db = TulevasiOpenHelper.newInstance().openDatabase();

        String selection = String.format("%s=? AND %s=? AND %s>=?", TulevasiContract.TickedsEntry.NOMBRE, TulevasiContract.TickedsEntry.IDMESA, TulevasiContract.TickedsEntry.ESTADO);
        String[] args = new String[]{ticked.getNombre(), String.valueOf(ticked.getID_Mesa()), String.valueOf(ticked.getEstado())};

        ContentValues values = new ContentValues();

        values.put(TulevasiContract.TickedsEntry.CANTIDAD, ticked.getCantidad());
        values.put(TulevasiContract.TickedsEntry.PRECIO, ticked.getPrecio());
        values.put(TulevasiContract.TickedsEntry.PRECIOTOTAL, ticked.getPrecioTotal());
        values.put(TulevasiContract.TickedsEntry.ESTADO, 2);


        if (db != null) {
            db.update(TulevasiContract.TickedsEntry.TABLE, values, selection, args);
        }

    }
    public static void okTicked(int id) {
        ArrayList<Ticked> tickedArrayList = new ArrayList<>();
        SQLiteDatabase db = TulevasiOpenHelper.newInstance().openDatabase();

        String selection = String.format("%s=? AND %s=? ", TulevasiContract.TickedsEntry.IDMESA, TulevasiContract.TickedsEntry.ESTADO);
        String[] args = new String[]{String.valueOf(id),"3"};

        ContentValues values = new ContentValues();
        values.put(TulevasiContract.TickedsEntry.ESTADO, 1);


        if (db != null) {
            db.delete(TulevasiContract.TickedsEntry.TABLE,selection,args);

            args = new String[]{String.valueOf(id),"3"};
            db.update(TulevasiContract.TickedsEntry.TABLE, values, selection, args);
        }

    }
    public static void cancelTicked(int id) {
        SQLiteDatabase db = TulevasiOpenHelper.newInstance().openDatabase();


        String selection = String.format("%s=? AND %s=? ", TulevasiContract.TickedsEntry.IDMESA, TulevasiContract.TickedsEntry.ESTADO);
        String[] args = new String[]{String.valueOf(id),"2"};



        if (db != null) {
            db.delete(TulevasiContract.TickedsEntry.TABLE , selection, args);
        }

        ContentValues values = new ContentValues();
        values.put(TulevasiContract.TickedsEntry.ESTADO, 1);

        args = new String[]{String.valueOf(id),"3"};

        if (db != null) {
            db.update(TulevasiContract.TickedsEntry.TABLE ,values, selection, args);
        }


    }
    public static void AnadirTicked(Ticked ticked) {

        ArrayList<Ticked> tickedArrayList = new ArrayList<>();
        SQLiteDatabase db = TulevasiOpenHelper.newInstance().openDatabase();

        String selection = String.format("%s=? AND %s>=? AND %s=?", TulevasiContract.TickedsEntry.IDMESA, TulevasiContract.TickedsEntry.ESTADO, TulevasiContract.TickedsEntry.NOMBRE);
        String[] args = new String[]{String.valueOf(ticked.getID_Mesa()), "1", ticked.getNombre()};

        ContentValues values = new ContentValues();

        values.put(TulevasiContract.TickedsEntry.IDPRODUCTO, ticked.getID_Productos());
        values.put(TulevasiContract.TickedsEntry.IDCATEGORIA, ticked.getID_Categoria());
        values.put(TulevasiContract.TickedsEntry.CANTIDAD, ticked.getCantidad());
        values.put(TulevasiContract.TickedsEntry.PRECIO, ticked.getPrecio());
        values.put(TulevasiContract.TickedsEntry.PRECIOTOTAL, ticked.getPrecioTotal());
        values.put(TulevasiContract.TickedsEntry.NOMBRE, ticked.getNombre());
        values.put(TulevasiContract.TickedsEntry.IDMESA, ticked.getID_Mesa());
        values.put(TulevasiContract.TickedsEntry.IDTRABAJADOR, ticked.getID_trabajador());
        values.put(TulevasiContract.TickedsEntry.FECHAINI, ticked.getFecha_Ini());
        values.put(TulevasiContract.TickedsEntry.ESTADO, 2);

        if (db != null) {
            Cursor c = db.query(TulevasiContract.TickedsEntry.TABLE, TulevasiContract.TickedsEntry.ALLCOLUMNS, selection, args, null, null, null);
            if (c.getCount() == 0) {
                db.insert(TulevasiContract.TickedsEntry.TABLE, null, values);
            } else {
                c.moveToFirst();
                Ticked acc = new Ticked(c.getInt(0), c.getInt(1), c.getInt(2), c.getInt(3), c.getFloat(4)
                        , c.getFloat(5), c.getString(6), c.getInt(7), c.getInt(8), c.getString(9), c.getInt(10));


                ticked.setCantidad(1+acc.getCantidad());
                ticked.setPrecioTotal(ticked.getPrecio() * ticked.getCantidad());

                values = new ContentValues();

                values.put(TulevasiContract.TickedsEntry.CANTIDAD, ticked.getCantidad());
                values.put(TulevasiContract.TickedsEntry.PRECIOTOTAL, (ticked.getPrecio()*ticked.getCantidad()));
                values.put(TulevasiContract.TickedsEntry.ESTADO, 2);


                db.update(TulevasiContract.TickedsEntry.TABLE, values, selection, args);

                values = new ContentValues();

                values.put(TulevasiContract.TickedsEntry.IDPRODUCTO, acc.getID_Productos());
                values.put(TulevasiContract.TickedsEntry.IDCATEGORIA, acc.getID_Categoria());
                values.put(TulevasiContract.TickedsEntry.CANTIDAD, acc.getCantidad());
                values.put(TulevasiContract.TickedsEntry.PRECIO, ticked.getPrecio());
                values.put(TulevasiContract.TickedsEntry.PRECIOTOTAL, (acc.getCantidad()*ticked.getPrecio()));
                values.put(TulevasiContract.TickedsEntry.NOMBRE, acc.getNombre());
                values.put(TulevasiContract.TickedsEntry.IDMESA, acc.getID_Mesa());
                values.put(TulevasiContract.TickedsEntry.IDTRABAJADOR, acc.getID_trabajador());
                values.put(TulevasiContract.TickedsEntry.FECHAINI, acc.getFecha_Ini());
                values.put(TulevasiContract.TickedsEntry.ESTADO, 3);

                db.insert(TulevasiContract.TickedsEntry.TABLE, null, values);
            }
        }

    }


    public static void eliminar(int id) {
        SQLiteDatabase db = TulevasiOpenHelper.newInstance().openDatabase();

        String selection = String.format("%s=?", TulevasiContract.TickedsEntry._ID);
        String[] args = new String[]{String.valueOf(id)};

        if (db != null) {
            db.delete(TulevasiContract.TickedsEntry.TABLE, selection, args);
        }


    }

    /*public static ArrayList<Ticked> loadAll() {
        ArrayList<Ticked> tickedArrayList = new ArrayList<>();
        SQLiteDatabase db = TulevasiOpenHelper.newInstance().openDatabase();


        if (db != null) {
            Cursor c = db.query(TulevasiContract.TickedsEntry.TABLE, TulevasiContract.TickedsEntry.ALLCOLUMNS, null, null, null, null, null, null);
            if (c != null) {
                while (c.moveToNext()) {
                    Ticked acc = new Ticked(c.getInt(0), c.getInt(1), c.getInt(2), c.getInt(3), c.getInt(4)
                            , c.getInt(5), c.getString(6), c.getInt(7), c.getInt(8), c.getString(9), c.getInt(10));
                    tickedArrayList.add(acc);
                }
            }
        }

        return tickedArrayList;
    }*/

    public static ArrayList<Ticked> LoadID(int id) {
        String selection = String.format("%s=? AND (%s=? OR %s=?)", TulevasiContract.TickedsEntry.IDMESA, TulevasiContract.TickedsEntry.ESTADO,TulevasiContract.TickedsEntry.ESTADO);
        String[] args = new String[]{String.valueOf(id), "1","2"};
        ArrayList<Ticked> tickedArrayList = new ArrayList<>();
        SQLiteDatabase db = TulevasiOpenHelper.newInstance().openDatabase();


        if (db != null) {
            Cursor c = db.query(TulevasiContract.TickedsEntry.TABLE, TulevasiContract.TickedsEntry.ALLCOLUMNS, selection, args, null, null, null, null);
            if (c != null) {
                while (c.moveToNext()) {
                    Ticked acc = new Ticked(c.getInt(0), c.getInt(1), c.getInt(2), c.getInt(3), c.getFloat(4)
                            , c.getFloat(5), c.getString(6), c.getInt(7), c.getInt(8), c.getString(9), c.getInt(10));
                    tickedArrayList.add(acc);
                }
            }
        }

        return tickedArrayList;
    }

    public static void imprimir(int id) {
        String selection = String.format("%s=? AND %s>=?", TulevasiContract.TickedsEntry.IDMESA, TulevasiContract.TickedsEntry.ESTADO);
        String[] args = new String[]{String.valueOf(id), "1"};
        SQLiteDatabase db = TulevasiOpenHelper.newInstance().openDatabase();


        ContentValues values = new ContentValues();

        values.put(TulevasiContract.TickedsEntry.ESTADO, 0);

        if (db != null) {
            db.update(TulevasiContract.TickedsEntry.TABLE, values, selection, args);
        }
    }
}
