package com.example.julolopop.tulevasi.ui.catalogo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.julolopop.tulevasi.R;
import com.example.julolopop.tulevasi.adapter.CatalogoAdapter;
import com.example.julolopop.tulevasi.data.dao.CatalogoDao;
import com.example.julolopop.tulevasi.pojo.Catalogo;
import com.example.julolopop.tulevasi.pojo.Mesa;
import com.example.julolopop.tulevasi.ui.MesasActivity;


public class CatalogoFragment extends Fragment implements AdapterView.OnItemClickListener {

    public  static String TAG = "CatalogoFragment";
    private OnCatalogoFragmentListener listener;
    private int idmesa;

    ListView listView;
    CatalogoAdapter adapter;
    CatalogoDao catalogoRepository;
    Toolbar toolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            idmesa = getArguments().getInt(Mesa.ID);
        }
        setHasOptionsMenu(true);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_catalogo, container, false);

        toolbar = (Toolbar)view.findViewById(R.id.toolbar);
        ((MesasActivity)listener).setSupportActionBar(toolbar);
        listView = (ListView)view.findViewById(android.R.id.list);
        adapter = new CatalogoAdapter(getContext());

        adapter.clear();
        adapter.addAll(CatalogoDao.loadAll());


        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.catalogo_menu,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.id:
                adapter.clear();
                adapter.addAll(catalogoRepository.getCatalogoArrayListid());
                break;
            case R.id.nombre:
                adapter.clear();
                adapter.addAll(catalogoRepository.getCatalogoArrayListnombre());
                break;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnCatalogoFragmentListener) {
            listener = (OnCatalogoFragmentListener) activity;
        } else {
            throw new RuntimeException(activity.toString()
                    + " must implement OnCatalogoFragmentListener");
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Bundle bundle = new Bundle();

        bundle.putInt(Catalogo.ID,CatalogoDao.loadAll().get(position).getId());
        bundle.putInt(Mesa.ID,idmesa);


        listener.abrirListaProductos(bundle);
    }

    public interface OnCatalogoFragmentListener {
        void abrirListaProductos(Bundle bundle);
    }
}
