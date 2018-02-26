package com.example.julolopop.tulevasi.ui.mesas;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.julolopop.tulevasi.R;
import com.example.julolopop.tulevasi.adapter.PedidosAdapter;
import com.example.julolopop.tulevasi.data.dao.TickeDao;
import com.example.julolopop.tulevasi.pojo.Mesa;
import com.example.julolopop.tulevasi.pojo.Ticked;
import com.example.julolopop.tulevasi.ui.mesas.presenter.ListaMesaPresenter;
import com.example.julolopop.tulevasi.utils.Utils;


public class ListaMesaFragment extends Fragment implements AdapterView.OnItemClickListener, View.OnClickListener, AdapterView.OnItemLongClickListener {

    public static final String TAG = "ListaMesaFragment";
    private int id;
    private OnFragmentListaMesaListener listener;
    ListView lista;
    PedidosAdapter adapter;

    Button btn_agregar;
    Button btn_imprimir;
    Button btn_ok;
    Button btn_cancel;
    ListaMesaPresenter presenter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            id = ((Mesa)getArguments().getParcelable("mesa")).getId();
        }
        presenter = new ListaMesaPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista_mesa, container, false);
        this.lista = (ListView)view.findViewById(android.R.id.list);
        this.btn_agregar = (Button) view.findViewById(R.id.btn_agregar);
        this.btn_imprimir= (Button) view.findViewById(R.id.btn_imprimir);
        this.btn_ok= (Button) view.findViewById(R.id.btnOk);
        this.btn_cancel= (Button) view.findViewById(R.id.btn_ok);

        adapter = new PedidosAdapter(getContext());

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        lista.setAdapter(adapter);
        adapter.clear();

        adapter.addAll(TickeDao.LoadID(id));

        lista.setOnItemLongClickListener(this);
        lista.setOnItemClickListener(this);
        btn_agregar.setOnClickListener(this);
        btn_imprimir.setOnClickListener(this);
        btn_ok.setOnClickListener(this);
        btn_cancel.setOnClickListener(this);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnFragmentListaMesaListener) {
            listener = (OnFragmentListaMesaListener) activity;
        } else {
            throw new RuntimeException(activity.toString()
                    + " must implement OnCatalogoFragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Bundle bundle = new Bundle();
        Ticked ticked = (Ticked) this.lista.getItemAtPosition(position);

        bundle.putParcelable(Ticked.PEDIDOS, ticked);
        bundle.putInt(Mesa.ID, this.id);

        listener.abrirEditarFragment(bundle);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_agregar:
                Bundle bundle = new Bundle();
                bundle.putInt(Mesa.ID, this.id);
                listener.abrirCatalogo(bundle);
                break;
            case R.id.btn_imprimir:
                presenter.imprimirPresenter(this.id);

                listener.abrirMesas();
                break;
            case R.id.btnOk:
                presenter.okPresenter(this.id);
                listener.abrirMesas();
                break;
            case R.id.btn_ok:
                presenter.cancelPresenter(this.id);
                listener.abrirMesas();
                break;
        }

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Ticked ticked = (Ticked) this.lista.getItemAtPosition(position);

        Utils.Alertdialog(getContext(), ticked.getId(),presenter).show();
        return true;
    }

    public void ActualizarVista() {

        adapter.clear();
        adapter.addAll(TickeDao.LoadID(id));

    }

    public interface OnFragmentListaMesaListener {
        void abrirEditarFragment(Bundle bundle);
        void abrirCatalogo(Bundle bundle);

        void abrirMesas();
    }
}
