package com.example.julolopop.tulevasi.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;

import com.example.julolopop.tulevasi.R;
import com.example.julolopop.tulevasi.data.dao.TickeDao;
import com.example.julolopop.tulevasi.ui.mesas.presenter.ListaMesaPresenter;

/**
 * Created by Julolopop on 14/01/2018.
 */

public class Utils {

    public static Dialog Alertdialog(final Context context, final int id, final ListaMesaPresenter presenter){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setMessage(R.string.meliminar)
                .setTitle(R.string.teliminar)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                         TickeDao.eliminar(id);
                        presenter.ActualizarPresenter();

                        dialog.cancel();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });


        return builder.create();
    }
}
