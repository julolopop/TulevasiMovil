package com.example.julolopop.tulevasi.ui.mesas.presenter;

import com.example.julolopop.tulevasi.ui.mesas.ListaMesaFragment;
import com.example.julolopop.tulevasi.ui.mesas.interactor.ListaMesaInteractor;

/**
 * Created by Julolopop on 24/12/2017.
 */

public class ListaMesaPresenter {
    ListaMesaFragment view;
    ListaMesaInteractor interactor;

    public ListaMesaPresenter(ListaMesaFragment view) {
        this.view = view;
        this.interactor = new ListaMesaInteractor(this);
    }



    public void ActualizarPresenter() {
    interactor.ActualizarInteractor();
    }

    public void onSusses() {
        view.ActualizarVista();
    }

    public void imprimirPresenter(int id) {
        interactor.imprimirInteractor(id);
    }

    public void okPresenter(int id) {
        interactor.okInteractor(id);
    }

    public void cancelPresenter(int id) {
        interactor.cancelPresenter(id);
    }
}
