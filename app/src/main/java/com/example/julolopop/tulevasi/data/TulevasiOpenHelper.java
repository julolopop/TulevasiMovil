package com.example.julolopop.tulevasi.data;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.julolopop.tulevasi.data.contract.TulevasiContract;
import com.example.julolopop.tulevasi.TulevasiApplication;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Julolopop on 23/12/2017.
 */

public class TulevasiOpenHelper extends SQLiteOpenHelper {
    private static  TulevasiOpenHelper instance;
    private SQLiteDatabase database;
    private AtomicInteger contador = new AtomicInteger();

    public static TulevasiOpenHelper newInstance() {
        if(instance == null)
            instance = new TulevasiOpenHelper();
        return instance;
    }

    public TulevasiOpenHelper() {
        super(TulevasiApplication.getContext(), TulevasiContract.DATABASE, null, TulevasiContract.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        db.execSQL(TulevasiContract.MesaEntry.CREATE);
        db.execSQL(TulevasiContract.ProductosEntry.CREATE);
        db.execSQL(TulevasiContract.TickedsEntry.CREATE);
        db.execSQL(TulevasiContract.CatalogoEntry.CREATE);

        db.execSQL(TulevasiContract.MesaEntry.INSERT);
        db.execSQL(TulevasiContract.ProductosEntry.INSERT);
        db.execSQL(TulevasiContract.TickedsEntry.INSERT);
        db.execSQL(TulevasiContract.CatalogoEntry.INSERT);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {




        db.execSQL(TulevasiContract.MesaEntry.DROP);
        db.execSQL(TulevasiContract.ProductosEntry.DROP);
        db.execSQL(TulevasiContract.TickedsEntry.DROP);
        db.execSQL(TulevasiContract.CatalogoEntry.DROP);

        db.execSQL(TulevasiContract.MesaEntry.CREATE);
        db.execSQL(TulevasiContract.ProductosEntry.CREATE);
        db.execSQL(TulevasiContract.TickedsEntry.CREATE);
        db.execSQL(TulevasiContract.CatalogoEntry.CREATE);

        db.execSQL(TulevasiContract.MesaEntry.INSERT);
        db.execSQL(TulevasiContract.ProductosEntry.INSERT);
        db.execSQL(TulevasiContract.TickedsEntry.INSERT);
        db.execSQL(TulevasiContract.CatalogoEntry.INSERT);
    }

    public SQLiteDatabase openDatabase(){
        if(contador.getAndIncrement() == 0)
            database = getWritableDatabase();
        return database;
    }

    public void closeDatabase(){
        if(contador.getAndDecrement()==1)
            database.close();
    }
}
