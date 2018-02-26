package com.example.julolopop.tulevasi.ui.catalogo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.julolopop.tulevasi.R;
import com.example.julolopop.tulevasi.data.dao.ProductosDao;
import com.example.julolopop.tulevasi.pojo.Catalogo;
import com.example.julolopop.tulevasi.pojo.Mesa;
import com.example.julolopop.tulevasi.pojo.Productos;


public class AnadirProductoFragment extends Fragment implements View.OnClickListener {
    public static String TAG = "AnadirProductoFragment";
    private OnFragmentAnadirproductoListener mListener;
    private int idCategoria;
    private int idMesa;
    private Button btn_ok;
    private Button btn_cancel;
    private EditText edt_nombre;
    private EditText edt_precio;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            idCategoria = getArguments().getInt(Catalogo.ID);
            idMesa = getArguments().getInt(Mesa.ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_anadir_producto, container, false);
        btn_ok = (Button) view.findViewById(R.id.btn_ok);
        btn_cancel = (Button) view.findViewById(R.id.btn_cancel);

        edt_nombre = (EditText)view.findViewById(R.id.edt_nnombrep);
        edt_precio = (EditText)view.findViewById(R.id.edt_npreciop);



        btn_ok.setOnClickListener(this);
        btn_cancel.setOnClickListener(this);
        return view;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnFragmentAnadirproductoListener) {
            mListener = (OnFragmentAnadirproductoListener) activity;
        } else {
            throw new RuntimeException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onClick(View v) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("mesa",new Mesa(idMesa,0,""));
        switch (v.getId()) {
            case R.id.btn_ok:
                Float f =0f;
                try {
                    f = Float.parseFloat(edt_precio.getText().toString());
                }catch (Exception e){

                }

                ProductosDao.AnadirProductos(new Productos(0,idCategoria,"null",f,edt_nombre.getText().toString()));

                mListener.onAbrirMesaActivity(bundle);
                break;
            case R.id.btn_cancel:
                mListener.onAbrirMesaActivity(bundle);
                break;

        }

    }


    public interface OnFragmentAnadirproductoListener {
        void onAbrirMesaActivity(Bundle bundle);
    }
}
