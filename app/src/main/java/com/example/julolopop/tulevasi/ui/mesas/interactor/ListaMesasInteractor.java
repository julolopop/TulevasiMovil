package com.example.julolopop.tulevasi.ui.mesas.interactor;

import android.os.Bundle;

import com.example.julolopop.tulevasi.pojo.Mesa;
import com.example.julolopop.tulevasi.ui.mesas.presenter.ListaMesasPresenter;

/**
 * Created by Julolopop on 24/12/2017.
 */

public class ListaMesasInteractor {

    private ListaMesasPresenter presenter;

    public ListaMesasInteractor(ListaMesasPresenter presenter) {
        this.presenter = presenter;
    }


    public void abrirMesaInteractor(Mesa obj) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("mesa",obj);

        try {
            this.presenter.onAbrirMesaPresenter(bundle);
        }catch (Exception e){
            this.presenter.Error();
        }

    }


}
