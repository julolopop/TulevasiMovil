package com.example.julolopop.tulevasi.ui.mesas.interactor;

import android.content.Intent;
import android.os.Bundle;

import com.example.julolopop.tulevasi.TulevasiApplication;
import com.example.julolopop.tulevasi.broadcast.TulevasiBroadcast;
import com.example.julolopop.tulevasi.data.dao.TickeDao;
import com.example.julolopop.tulevasi.ui.mesas.presenter.ListaMesaPresenter;

/**
 * Created by Julolopop on 24/12/2017.
 */

public class ListaMesaInteractor {

    private ListaMesaPresenter presenter;

    public ListaMesaInteractor(ListaMesaPresenter presenter) {
        this.presenter = presenter;
    }



    public void ActualizarInteractor() {
        presenter.onSusses();
    }

    public void imprimirInteractor(int id) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("impresion", TickeDao.LoadID(id));

        Intent intent = new Intent(TulevasiApplication.getContext(), TulevasiBroadcast.class);
        intent.putExtras(bundle);
        TulevasiApplication.getContext().sendBroadcast(intent);

        TickeDao.imprimir(id);

    }

    public void okInteractor(int id) {
        TickeDao.okTicked(id);
    }

    public void cancelPresenter(int id) {
        TickeDao.cancelTicked(id);
    }
}
