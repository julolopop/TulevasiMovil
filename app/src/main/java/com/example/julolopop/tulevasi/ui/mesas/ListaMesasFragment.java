package com.example.julolopop.tulevasi.ui.mesas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.julolopop.tulevasi.R;
import com.example.julolopop.tulevasi.adapter.MesaAdapter;
import com.example.julolopop.tulevasi.data.dao.MesaDao;
import com.example.julolopop.tulevasi.pojo.Mesa;
import com.example.julolopop.tulevasi.ui.mesas.presenter.ListaMesasPresenter;
import com.example.julolopop.tulevasi.ui.pref.Prefrentzona;

public class ListaMesasFragment extends Fragment {

    public static final String TAG = "ListaMesasFragment";
    private ListView lista;
    private MesaAdapter adapter;
    private ListaMesasPresenter presenter;
    private Toolbar toolbar;
    private com.github.clans.fab.FloatingActionButton fabzona;
    private OnFragmentListaMesasListener listener;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new MesaAdapter(getContext());
        presenter = new ListaMesasPresenter(this);
        setHasOptionsMenu(true);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista_mesas, container, false);
        lista = (ListView)view.findViewById(android.R.id.list);
        fabzona = (com.github.clans.fab.FloatingActionButton)view.findViewById(R.id.fabZona);

        toolbar = (Toolbar)view.findViewById(R.id.toolbar);

        ((AppCompatActivity)listener).setSupportActionBar(toolbar);

        lista.setAdapter(adapter);
        adapter.clear();
        adapter.addAll( MesaDao.loadAll(1));


        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Mesa mesa = (Mesa)lista.getItemAtPosition(position);
                presenter.abrirMesaPresenter(mesa);
            }
        });


        fabzona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v == fabzona){

                    startActivity(new Intent(getContext(), Prefrentzona.class));
                }
            }
        });
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnFragmentListaMesasListener) {
            listener = (OnFragmentListaMesasListener) activity;
        } else {
            throw new RuntimeException(activity.toString()
                    + " must implement OnCatalogoFragmentListener");
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        listener = null;
        presenter = null;
    }

    public void onAbrirMesa(Bundle bundle) {
        listener.onAbrirMesaActivity(bundle);
    }

    public void Error() {
        Toast.makeText(getContext(),"Error General",Toast.LENGTH_LONG).show();
    }

    public interface OnFragmentListaMesasListener {
        void onAbrirMesaActivity(Bundle bundle);
    }
}
